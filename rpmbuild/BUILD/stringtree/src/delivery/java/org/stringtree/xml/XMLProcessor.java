package org.stringtree.xml;

import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.util.HashMap;
import java.util.Map;

public class XMLProcessor
{
	// State Machine states
    //
    private static final int OUTSIDE = 0;
	private static final int STARTED = 1;
	private static final int TAGNAME = 2;
	private static final int TAGSPACE = 3;
	private static final int TAGARG = 4;
	private static final int TAGEQUALS = 5;
	private static final int TAGARGVAL = 6;
	private static final int TAGARGQUOTE = 7;
	private static final int ENTITY = 8;
    private static final int DOCTYPE = 9;
		
	// State machine symbol types
    //
	private static final int ORDINARY = 10;
	private static final int NAMECHAR = 20;
	private static final int LESSTHAN = 30;
	private static final int GREATERTHAN = 40;
	private static final int SPACE = 50;
	private static final int EQUALS = 60;
	private static final int SLASH = 70;
	private static final int QUOTE = 80;
	private static final int QUERY = 90;
	private static final int AMPERSAND = 100;
	private static final int SEMICOLON = 110;
    private static final int EXCLAMATION = 120;
		
	// are we processing a start or end tag
    //
    private static final int BLOCKSTART = 0;
	private static final int BLOCKEND = 1;
    
    // what sort of quotes are in use
    //
    private static final int NOQUOTES = 0;

    // predefined standard entity substitution sequences
    //
	private static Map entities;
	{
        entities = new HashMap();
	    entities.put("lt", "<");
	    entities.put("gt", ">");
	    entities.put("amp", "&");
	    entities.put("quot", "\"");
	    entities.put("apos", "'");
    }
	
	private XMLProcessorContext context;
	
	private Writer out = null;
	
	private int tagType = 0;
	private int status = 0;
    private int realstatus = status;
	private HashMap args = null;
	
	public XMLProcessor(XMLProcessorContext context) {
		this.context = context;
		out = context.getWriter();
		args = new HashMap();
	}
	
	private void reset() {
		tagType = BLOCKSTART;
		status = OUTSIDE;
        realstatus = status;
		args.clear();
	}
	
	private boolean isNameChar(char c) {
		return (Character.isUpperCase(c) || Character.isLowerCase(c) || Character.isDigit(c) 
                || c=='-' || c=='_' || c==':');
	}
	
	private void process(Object context, Reader in, String name) throws IOException {
		StringBuffer tagName = new StringBuffer();
		StringBuffer argName = new StringBuffer();
		StringBuffer argValue = new StringBuffer();
        StringBuffer entity = new StringBuffer();
        StringBuffer pushback = new StringBuffer();
        
		int chartype = ORDINARY;
		boolean singleTagFlag = false;
		boolean inblock = true;
        char quoteType = NOQUOTES;
		
        int line = 0;
        int column = 0;

		int i = 99; // dummy non-zero value
		
		while (i >= 0 && inblock) {
            char c;
            
            if (pushback.length() > 0) {
                c = pushback.charAt(0);
                pushback.deleteCharAt(0);
                chartype = NAMECHAR;
            } else {
    			i = in.read();
            
			    if (i == 0) {
				    continue;
			    }
			
			    c = (char)i;
			
			    // work out the character type
			    //
			    switch(c) {
			    case '<':
				    chartype = LESSTHAN;
				    break;
			    case '>':
				    chartype = GREATERTHAN;
				    break;
			    case '=':
				    chartype = EQUALS;
				    break;
			    case '/':
				    chartype = SLASH;
				    break;
			    case '"':
                case '\'':
                    if (quoteType == NOQUOTES) {
                        quoteType = c;
                        chartype = QUOTE;
                    } else if (quoteType == c) {
                        chartype = QUOTE;
                        quoteType = NOQUOTES;
                    } else {
                        chartype = NAMECHAR;
                    }
				    break;
                case '?':
                    chartype = QUERY;
                    break;
			    case '&':
			        chartype = AMPERSAND;
			        break;
			    case ';':
			        chartype = SEMICOLON;
			        break;
                case '!':
                    chartype = EXCLAMATION;
                    break;
			    default:
				    if (isNameChar(c)) {
					    chartype = NAMECHAR;
				    } else if (Character.isWhitespace(c)) {
					    chartype = SPACE;
				    } else {
					    chartype = ORDINARY;
				    }
			    }
                
                if (c == '\n') {
                    ++line;
                    column = 0;
                } else {
                    ++column;
                }
			}
			
			String tagNameString = tagName.toString();
			String argNameString = argName.toString();
			String argValueString = argValue.toString();
			String entityString = entity.toString();
            
			// work out what to do with it
			//
			switch(status+chartype) {
            case ENTITY+ORDINARY:
			case ENTITY+NAMECHAR:
			case ENTITY+LESSTHAN:
			case ENTITY+GREATERTHAN:
			case ENTITY+SPACE:
			case ENTITY+EQUALS:
			case ENTITY+SLASH:
			case ENTITY+QUOTE:
			case ENTITY+QUERY:
            case ENTITY+AMPERSAND:
                entity.append(c);
                break;
            
			case ENTITY+SEMICOLON:
                String entityValue = (String)entities.get(entityString);
                if (entityValue != null) {
                    pushback.append(entityValue);
                }
                entity.setLength(0);
                status = realstatus;
                break;
                
            case OUTSIDE+AMPERSAND:
            case STARTED+AMPERSAND:
            case TAGNAME+AMPERSAND:
            case TAGSPACE+AMPERSAND:
            case TAGARG+AMPERSAND:
            case TAGEQUALS+AMPERSAND:
            case TAGARGVAL+AMPERSAND:
            case TAGARGQUOTE+AMPERSAND:
                realstatus = status;
                status = ENTITY;
                break;

			case OUTSIDE+ORDINARY:
			case OUTSIDE+NAMECHAR:
			case OUTSIDE+SPACE:
			case OUTSIDE+EQUALS:
			case OUTSIDE+SLASH:
			case OUTSIDE+QUOTE:
		    case OUTSIDE+QUERY:
            case OUTSIDE+EXCLAMATION:
				if (out != null) {
					out.write(c);
				}
				break;
				
			case OUTSIDE+LESSTHAN:
				status = STARTED;
				tagName.setLength(0);
				break;
				
			case STARTED+SPACE:
				// ignore spaces after '<'
				break;
				
			case STARTED+SLASH:
				tagType = BLOCKEND;
				status = TAGNAME;
				break;
				
			case STARTED+NAMECHAR:
			case STARTED+QUERY:
				tagType = BLOCKSTART;
				status = TAGNAME;
				tagName.append(c);
				break;
                
            case STARTED+EXCLAMATION:
            case DOCTYPE+ORDINARY:
            case DOCTYPE+NAMECHAR:
            case DOCTYPE+LESSTHAN:
            case DOCTYPE+SPACE:
            case DOCTYPE+EQUALS:
            case DOCTYPE+SLASH:
            case DOCTYPE+QUOTE:
            case DOCTYPE+QUERY:
            case DOCTYPE+AMPERSAND:
            case DOCTYPE+SEMICOLON:
            case DOCTYPE+EXCLAMATION:
                status = DOCTYPE;
                break;
                
            case DOCTYPE+GREATERTHAN:
                status=OUTSIDE;
                break;
				
			case TAGNAME+NAMECHAR:
				tagName.append(c);
				break;
				
			case TAGNAME+SPACE:
				status = TAGSPACE;
				break;
				
			case TAGNAME+SLASH:
			case TAGSPACE+SLASH:
		    case TAGNAME+QUERY:
			case TAGSPACE+QUERY:
				status = TAGSPACE;
				singleTagFlag = true;
				break;
				
			case TAGSPACE+SPACE:
				break;
				
			case TAGSPACE+NAMECHAR:
				argName.append(c);
				status = TAGARG;
				break;
				
			case TAGARG+NAMECHAR:
				argName.append(c);
				break;
				
			case TAGARG+SPACE:
				// ignore space after arg name
				break;
				
			case TAGARG+EQUALS:
				status = TAGEQUALS;
				break;
				
			case TAGEQUALS+SPACE:
				// ignore space after '='
				break;
				
			case TAGEQUALS+NAMECHAR:
			case TAGEQUALS+ORDINARY:
			case TAGEQUALS+SLASH:
				argValue.append(c);
				status = TAGARGVAL;
				break;
			
			case TAGEQUALS+QUOTE:
			case TAGARGVAL+QUOTE:
				status = TAGARGQUOTE;
				break;
				
			case TAGARGVAL+NAMECHAR:
			case TAGARGVAL+ORDINARY:
			case TAGARGQUOTE+SPACE:
			case TAGARGQUOTE+ORDINARY:
			case TAGARGQUOTE+NAMECHAR:
			case TAGARGQUOTE+SLASH:
			case TAGARGQUOTE+LESSTHAN:
			case TAGARGQUOTE+GREATERTHAN:
            case TAGARGQUOTE+QUERY:
			case TAGARGQUOTE+EQUALS:
            case TAGARGQUOTE+EXCLAMATION:
				argValue.append(c);
				break;
				
			case TAGARGQUOTE+QUOTE:
			case TAGARGVAL+SPACE:
            case TAGARGVAL+SLASH:
            case TAGARGVAL+QUERY:
                if (argName.length() > 0) {
    				args.put(argNameString, argValueString);
                    argName.setLength(0);
                }
				argValue.setLength(0);
				status = TAGSPACE;
				break;
				
			case TAGARGVAL+GREATERTHAN:
			case TAGNAME+GREATERTHAN:
			case TAGSPACE+GREATERTHAN:
				if (argName.length() > 0) {
					args.put(argNameString, argValueString);
					argName.setLength(0);
				}
				argValue.setLength(0);
				
				if (tagType == BLOCKSTART) {
					if (singleTagFlag) {
						handleSingle(context, tagNameString, (Map)args.clone());
						
						singleTagFlag = false;
					} else {
						handlePair(context, tagNameString, (Map)args.clone(), in);
					}
				}
				
				else { // tagtype == BLOCKEND
					if (name.equals(tagNameString)) {
						inblock = false;
					} else {
						throw new UnbalancedTagException(tagNameString, line, column);
					}
				}
				
				tagName.setLength(0);
				reset();
				break;
                
			
			case OUTSIDE+GREATERTHAN:
			case STARTED+EQUALS:
			case STARTED+LESSTHAN:
			case STARTED+GREATERTHAN:
			case STARTED+ORDINARY:
			case STARTED+QUOTE:
			case TAGNAME+EQUALS:
			case TAGNAME+ORDINARY:
			case TAGNAME+LESSTHAN:
			case TAGNAME+QUOTE:
			case TAGSPACE+LESSTHAN:
			case TAGSPACE+EQUALS:
			case TAGSPACE+ORDINARY:
			case TAGSPACE+QUOTE:
			case TAGARG+LESSTHAN:
			case TAGARG+GREATERTHAN:
			case TAGARG+ORDINARY:
			case TAGARG+SLASH:
			case TAGARG+QUOTE:
			case TAGARG+QUERY:
			case TAGEQUALS+LESSTHAN:
			case TAGEQUALS+GREATERTHAN:
			case TAGEQUALS+EQUALS:
			case TAGEQUALS+QUERY:
			case TAGARGVAL+LESSTHAN:
			case TAGARGVAL+EQUALS:
System.err.println("state=" + status + " chartype=" + chartype);
				throw new UnexpectedCharacterException(c, line, column);
                
            default:
                throw new BadXMLException("Incomplete State Machine: state " + 
                    status + ", chartype " + chartype + " not implemented");
			}
		}
	}
	
	private TagHandler findTag(String name) {
		TagHandler handler = context.getHandler(name);
		if (handler == null) {
			handler = context.getDefaultHandler();
		}
		
		return handler;
	}
	
	private void handlePair(Object context, String tag, Map args, Reader in) throws IOException {
		TagHandler handler = findTag(tag);
		if (handler != null) {
			handler.doPair(context, tag, args, in);
		}
	}

	private void handleSingle(Object context, String tag, Map args) {
		TagHandler handler = findTag(tag);
		if (handler != null) {
			handler.doSingle(context, tag, args);
		}
	}

	public void run(Object context, Reader in, String name) throws IOException {
		reset();
		
		if (in != null) {
			process(context, in, name);
		}
		
		if (out != null) {
			out.flush();
		}
	}
}