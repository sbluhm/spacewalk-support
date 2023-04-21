<html>
<head>
<meta http-equiv="cache-control" content="no-cache" />

<style type="text/css">
ul.apidoc {
   list-style-image: url('/img/parent_node.gif');
}

.deprecated {
   text-decoration: line-through;
}
</style>
</head>
<body>
<div class="spacewalk-toolbar-h1">
<h1><i class="fa fa-gears"></i>API Overview</h1>
</div>

<h2>Description</h2>
<p><strong>Namespace</strong>:
system.crash
</p>
<p>Provides methods to access and modify software crash information.</p>
<span class="small-text">( <a href="/rhn/apidoc/index.jsp">Return to API Overview</a> )</span>
<hr />

<div class="rounded-box">
<h2><a name="top">Available methods</a></h2>
<ul class="apidoc">

<li><a href="#createCrashNote"/>createCrashNote</a></li>
<li><a href="#deleteCrash"/>deleteCrash</a></li>
<li><a href="#deleteCrashNote"/>deleteCrashNote</a></li>
<li><a href="#getCrashCountInfo"/>getCrashCountInfo</a></li>
<li><a href="#getCrashFile"/>getCrashFile</a></li>
<li><a href="#getCrashFileUrl"/>getCrashFileUrl</a></li>
<li><a href="#getCrashNotesForCrash"/>getCrashNotesForCrash</a></li>
<li><a href="#getCrashOverview"/>getCrashOverview</a></li>
<li><a href="#getCrashesByUuid"/>getCrashesByUuid</a></li>
<li><a href="#listSystemCrashFiles"/>listSystemCrashFiles</a></li>
<li><a href="#listSystemCrashes"/>listSystemCrashes</a></li>
</ul>
</div>
<hr />

<h3> <a name="createCrashNote" href="#top">Method: createCrashNote</a></h3>
Description:<br />
Create a crash note
<p />




Parameters:<br />
<ul>
<li>

    string sessionKey
 </li>
<li>

    int crashId
 </li>
<li>

    string subject
 </li>
<li>

    string details
 </li>
</ul>
<p />
Returns:
<code><ul><li>


    int - 1 on success, exception thrown otherwise.
 
</li></ul>
</code>
<p />
<hr />

<h3> <a name="deleteCrash" href="#top">Method: deleteCrash</a></h3>
Description:<br />
Delete a crash with given crash id.
<p />




Parameters:<br />
<ul>
<li>

    string sessionKey
 </li>
<li>

    int crashId
 </li>
</ul>
<p />
Returns:
<code><ul><li>


    int - 1 on success, exception thrown otherwise.
 
</li></ul>
</code>
<p />
<hr />

<h3> <a name="deleteCrashNote" href="#top">Method: deleteCrashNote</a></h3>
Description:<br />
Delete a crash note
<p />




Parameters:<br />
<ul>
<li>

    string sessionKey
 </li>
<li>

    int crashNoteId
 </li>
</ul>
<p />
Returns:
<code><ul><li>


    int - 1 on success, exception thrown otherwise.
 
</li></ul>
</code>
<p />
<hr />

<h3> <a name="getCrashCountInfo" href="#top">Method: getCrashCountInfo</a></h3>
Description:<br />
Return date of last software crashes report for given system
<p />




Parameters:<br />
<ul>
<li>

    string sessionKey
 </li>
<li>

    int serverId
 </li>
</ul>
<p />
Returns:
<code><ul><li>


	     struct - Crash Count Information
	<ul>
             <li> int "total_count" - Total number of software crashes for a system </li>
             <li> int "unique_count" - Number of unique software crashes for a system </li>
             <li> dateTime.iso8601 "last_report" - Date of the last software crash report </li>
     	</ul>
 
</li></ul>
</code>
<p />
<hr />

<h3> <a name="getCrashFile" href="#top">Method: getCrashFile</a></h3>
Description:<br />
Download a crash file.
<p />




Parameters:<br />
<ul>
<li>

    string sessionKey
 </li>
<li>

    int crashFileId
 </li>
</ul>
<p />
Returns:
<code><ul><li>


base64 - base64 encoded crash file. 
 
</li></ul>
</code>
<p />
<hr />

<h3> <a name="getCrashFileUrl" href="#top">Method: getCrashFileUrl</a></h3>
Description:<br />
Get a crash file download url.
<p />




Parameters:<br />
<ul>
<li>

    string sessionKey
 </li>
<li>

    int crashFileId
 </li>
</ul>
<p />
Returns:
<code><ul><li>


string - The crash file download url 
 
</li></ul>
</code>
<p />
<hr />

<h3> <a name="getCrashNotesForCrash" href="#top">Method: getCrashNotesForCrash</a></h3>
Description:<br />
List crash notes for crash
<p />




Parameters:<br />
<ul>
<li>

    string sessionKey
 </li>
<li>

    int crashId
 </li>
</ul>
<p />
Returns:
<code><ul><li>


array:
  <ul>
   <li>
         	     struct - crashNote
	<ul>
             	<li> int "id"</li>
             	<li> string "subject"</li>
             	<li> string "details"</li>
             	<li> string "updated"</li>
         	</ul>
     </li></ul>
 
</li></ul>
</code>
<p />
<hr />

<h3> <a name="getCrashOverview" href="#top">Method: getCrashOverview</a></h3>
Description:<br />
Get Software Crash Overview
<p />




Parameters:<br />
<ul>
<li>

    string sessionKey
 </li>
</ul>
<p />
Returns:
<code><ul><li>


array:
  <ul>
   <li>
         	     struct - crash
	<ul>
                 <li> string "uuid" - Crash UUID </li>
                 <li> string "component" - Package component (set if unique and non empty) </li>
                 <li> int "crash_count" - Number of crashes occurred </li>
                 <li> int "system_count" - Number of systems affected </li>
                 <li> dateTime.iso8601 "last_report" - Last crash occurence </li>
         	</ul>
     </li></ul>
 
</li></ul>
</code>
<p />
<hr />

<h3> <a name="getCrashesByUuid" href="#top">Method: getCrashesByUuid</a></h3>
Description:<br />
List software crashes with given UUID
<p />




Parameters:<br />
<ul>
<li>

    string sessionKey
 </li>
<li>

    string uuid
 </li>
</ul>
<p />
Returns:
<code><ul><li>


array:
  <ul>
   <li>
         	     struct - crash
	<ul>
                 <li> int "server_id" - ID of the server the crash occurred on </li>
                 <li> string "server_name" - Name of the server the crash occurred on </li>
                 <li> int "crash_id" - ID of the crash with given UUID </li>
                 <li> int "crash_count" - Number of times the crash with given UUID occurred </li>
                 <li> string "crash_component" - Crash component </li>
                 <li> dateTime.iso8601 "last_report" - Last crash occurence </li>
         	</ul>
     </li></ul>
 
</li></ul>
</code>
<p />
<hr />

<h3> <a name="listSystemCrashFiles" href="#top">Method: listSystemCrashFiles</a></h3>
Description:<br />
Return list of crash files for given crash id.
<p />




Parameters:<br />
<ul>
<li>

    string sessionKey
 </li>
<li>

    int crashId
 </li>
</ul>
<p />
Returns:
<code><ul><li>


array:
  <ul>
   <li>
         	     struct - crashFile
	<ul>
             	<li> int "id"</li>
             	<li> string "filename"</li>
             	<li> string "path"</li>
             	<li> int "filesize"</li>
             	<li> boolean "is_uploaded"</li>
             	<li> date "created"</li>
             	<li> date "modified"</li>
         	</ul>
     </li></ul>
 
</li></ul>
</code>
<p />
<hr />

<h3> <a name="listSystemCrashes" href="#top">Method: listSystemCrashes</a></h3>
Description:<br />
Return list of software crashes for a system.
<p />




Parameters:<br />
<ul>
<li>

    string sessionKey
 </li>
<li>

    int serverId
 </li>
</ul>
<p />
Returns:
<code><ul><li>


array:
  <ul>
   <li>
         	     struct - crash
	<ul>
             	<li> int "id"</li>
             	<li> string "crash"</li>
             	<li> string "path"</li>
             	<li> int "count"</li>
             	<li> string "uuid"</li>
             	<li> string "analyzer"</li>
             	<li> string "architecture"</li>
             	<li> string "cmdline"</li>
             	<li> string "component"</li>
             	<li> string "executable"</li>
             	<li> string "kernel"</li>
             	<li> string "reason"</li>
             	<li> string "username"</li>
             	<li> date "created"</li>
             	<li> date "modified"</li>
         	</ul>
     </li></ul>
 
</li></ul>
</code>
<p />
<hr />
</body>
</html>
