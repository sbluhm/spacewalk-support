#include <stdio.h>
#include <stdlib.h>
#include <stdarg.h>
#include <string.h>
#include <syslog.h>

struct _Log_t {
	int level;		/**< Log type, based on syslog levels (LOG_ERR|LOG_WARNING) */
	char *message;		/**< Formated log text */
	unsigned int read;	/**< Number of times this log entry has been read */
	struct _Log_t *next;	/**< Next log entry */
};
typedef struct _Log_t Log_t;


/**
 * Allocates memory for a new Log_t record
 *
 * @return Returns a pointer to a new Log_t record, otherwise NULL on error
 */
Log_t * log_init()
{
	Log_t *ret = NULL;

	ret = (Log_t *) calloc(1, sizeof(Log_t)+2);
	if( !ret ) {
		fprintf(stderr, "** ERROR **  Could not allocate memory for log data\n");
	}
	ret->level = -1; // Initialised - chain header pointer always have -1.
	return ret;
}




/**
 * Registers a new log entry
 *
 * @param logp   Pointer to an allocated Log_t record.  New records will be appended to the end
 * @param level  syslog log level values.  LOG_ERR and LOG_WARNING are allowed
 * @param fmt    stdarg based string with the log contents
 *
 * @return Returns 1 on successful registration of log entry, otherwise -1 and error is printed to stderr
 */
int log_append(Log_t *logp, int level, const char *fmt, ...) {
	Log_t *ptr = NULL;
	va_list ap;

	// Go the end of the record chain
	ptr = logp;
	while( ptr && ptr->next ) {
		ptr = ptr->next;
	}


	if( ptr && ((level == LOG_ERR) || (level == LOG_WARNING)) ) {
		ptr->next = log_init();
		if( ptr->next ) {
			ptr->next->message = (char *) calloc(1, 4098);
		}
	}

        va_start(ap, fmt);
	if( !ptr || !ptr->next || !ptr->next->message ) {
		fprintf(stderr, "** ERROR **  Failed to save log entry\n");	
                vfprintf(stderr, fmt, ap);
                fprintf(stderr, "\n");
		va_end(ap);
		return -1;
	}

	ptr->next->level = level;
	vsnprintf(ptr->next->message, 4096, fmt, ap);
	ptr->next->message = realloc(ptr->next->message, strlen(ptr->next->message)+2);
	va_end(ap);

	return 1;
}


/**
 * Retrieve all log entries in the Log_t record chain with the corresponding log level.
 * One string will be returned, with all log entries separated with newline.
 *
 * @param logp  Pointer to Log_t record chain with log data
 * @param level Log entries to retrieve
 *
 * @return Returns a pointer to a buffer with all log lines.  This must be freed after usage.
 */
char *log_retrieve(Log_t *logp, int level)
{
	char *ret = NULL;
	size_t len = 0;
	Log_t *ptr = NULL;

	if( !logp ) {
		return NULL;
	}

	for( ptr = logp; ptr != NULL; ptr = ptr->next ) {
		if( ptr && ptr->level == level ) {
			if( ret ) {
				ret = realloc(ret, strlen(ptr->message)+len+3);
			} else {
				ret = calloc(1, strlen(ptr->message)+2);
			}

			if( !ret ) {
				fprintf(stderr,
					"** ERROR ** Could not allocate log retrieval memory buffer\n");
				return NULL;
			}
			strcat(ret, ptr->message);
			strcat(ret, "\n");
			ptr->read++;
			len = strlen(ret);
		}
	}
	return ret;
}


/**
 * Remove only log records of a particular log level from the log chain.  Only
 * records that have been read (by using log_retrieve()) will be removed.
 *
 * @param logp   Pointer to log chain to work on
 * @param level  Log level to remove
 *
 * @return Returns number of removed elements.
 */
size_t log_free_partial(Log_t *logp, int level) {
	Log_t *ptr = NULL, *prev = NULL;
	size_t elmnt = 0;

	if( !logp ) {
		return 0;
	}

	prev = logp;
	for( ptr = logp->next; ptr != NULL; ptr = ptr->next ) {
		if( !ptr ) {
			break;
		}

		// Only remove log entries which is of the expected log level
		// and that have been read.
		if( (ptr->level == level) && (ptr->read > 0) ) {
			prev->next = ptr->next;
			if( ptr->message ) {
				free(ptr->message);
				ptr->message = NULL;
			}
			free(ptr);
			ptr = prev;
			elmnt++;
		}
		prev = ptr;
	}

	return elmnt;
}


/**
 * Free all memory used by a Log_t pointer chain.
 *
 * @param logp Pointer to log entries to free up.
 */
void log_close(Log_t *logp) {
	Log_t *ptr = NULL, *next = NULL;

	ptr = logp;
	while( ptr ) {
		next = ptr->next;
		ptr->next = NULL;
		if( ptr->message ) {
			free(ptr->message);
			ptr->message = NULL;
		}
		free(ptr);
		ptr = next;
	}
}



int main()  {
	Log_t *l = NULL;
	int i = 0;
	char *ptr = NULL;

	l = log_init();


	for( i = 1; i <= 10; i++ ) {
		log_append(l, LOG_ERR, "Error record %i", i);
		log_append(l, LOG_WARNING, "Warn record %i", i);
	}

	printf("\n---------------------------\n");
	ptr = log_retrieve(l, LOG_ERR);
	printf("** LOG_ERR\n%s\n", ptr);
	free(ptr);

	printf("Free LOG_ERR: %ld\n", log_free_partial(l, LOG_ERR));

	for( i = 11; i <= 20; i++ ) {
		log_append(l, LOG_ERR, "Error record %i", i);
		log_append(l, LOG_WARNING, "Warn record %i", i);
	}


	printf("\n---------------------------\n");
	ptr = log_retrieve(l, LOG_ERR);
	printf("** LOG_ERR\n%s\n", ptr);
	free(ptr);

	printf("\n---------------------------\n");
	ptr = log_retrieve(l, LOG_WARNING);
	printf("** LOG_WARNING\n%s\n", ptr);
	free(ptr);


	for( i = 11; i <= 20; i++ ) {
		log_append(l, LOG_DEBUG, "Debug record %i", i);
	}


	printf("Free LOG_ERR: %ld\n", log_free_partial(l, LOG_ERR));
	printf("Free LOG_WARNING: %ld\n", log_free_partial(l, LOG_WARNING));

	log_close(l);
	return 0;
}
