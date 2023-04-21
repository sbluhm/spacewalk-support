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
configchannel
</p>
<p>Provides methods to access and modify many aspects of
 configuration channels.</p>
<span class="small-text">( <a href="/rhn/apidoc/index.jsp">Return to API Overview</a> )</span>
<hr />

<div class="rounded-box">
<h2><a name="top">Available methods</a></h2>
<ul class="apidoc">

<li><a href="#channelExists"/>channelExists</a></li>
<li><a href="#create"/>create</a></li>
<li><a href="#createOrUpdatePath"/>createOrUpdatePath</a></li>
<li><a href="#createOrUpdateSymlink"/>createOrUpdateSymlink</a></li>
<li><a href="#deleteChannels"/>deleteChannels</a></li>
<li><a href="#deleteFileRevisions"/>deleteFileRevisions</a></li>
<li><a href="#deleteFiles"/>deleteFiles</a></li>
<li><a href="#deployAllSystems"/>deployAllSystems</a></li>
<li><a href="#deployAllSystems"/>deployAllSystems</a></li>
<li><a href="#deployAllSystems"/>deployAllSystems</a></li>
<li><a href="#deployAllSystems"/>deployAllSystems</a></li>
<li><a href="#getDetails"/>getDetails</a></li>
<li><a href="#getDetails"/>getDetails</a></li>
<li><a href="#getEncodedFileRevision"/>getEncodedFileRevision</a></li>
<li><a href="#getFileRevision"/>getFileRevision</a></li>
<li><a href="#getFileRevisions"/>getFileRevisions</a></li>
<li><a href="#listFiles"/>listFiles</a></li>
<li><a href="#listGlobals"/>listGlobals</a></li>
<li><a href="#listSubscribedSystems"/>listSubscribedSystems</a></li>
<li><a href="#lookupChannelInfo"/>lookupChannelInfo</a></li>
<li><a href="#lookupFileInfo"/>lookupFileInfo</a></li>
<li><a href="#lookupFileInfo"/>lookupFileInfo</a></li>
<li><a href="#scheduleFileComparisons"/>scheduleFileComparisons</a></li>
<li><a href="#update"/>update</a></li>
</ul>
</div>
<hr />

<h3> <a name="channelExists" href="#top">Method: channelExists</a></h3>
Description:<br />
Check for the existence of the config channel provided.
<p />




Parameters:<br />
<ul>
<li>

        string sessionKey
 </li>
<li>

    string channelLabel - Channel to check for.
 </li>
</ul>
<p />
Returns:
<code><ul><li>


1 if exists, 0 otherwise. 
 
</li></ul>
</code>
<p />
<hr />

<h3> <a name="create" href="#top">Method: create</a></h3>
Description:<br />
Create a new global config channel. Caller must be at least a
 config admin or an organization admin.
<p />




Parameters:<br />
<ul>
<li>

        string sessionKey
 </li>
<li>

    string channelLabel
 </li>
<li>

    string channelName
 </li>
<li>

    string channelDescription
 </li>
</ul>
<p />
Returns:
<code><ul><li>




	     struct - Configuration Channel information
	<ul>
   	<li> int "id"</li>
   	<li> int "orgId"</li>
   	<li> string "label"</li>
   	<li> string "name"</li>
   	<li> string "description"</li>
   	<li> struct "configChannelType"</li>
   

	     struct - Configuration Channel Type information
	<ul>
   	<li> int "id"</li>
   	<li> string "label"</li>
   	<li> string "name"</li>
   	<li> int "priority"</li>
 	</ul>
 
 	</ul>
  
 
</li></ul>
</code>
<p />
<hr />

<h3> <a name="createOrUpdatePath" href="#top">Method: createOrUpdatePath</a></h3>
Description:<br />
Create a new file or directory with the given path, or
 update an existing path.
<p />




Parameters:<br />
<ul>
<li>

        string sessionKey
 </li>
<li>

    string configChannelLabel
 </li>
<li>

    string path
 </li>
<li>

    boolean isDir - True if the path is a directory, False if it is a file.
 </li>
<li>

	     struct - path info
	<ul>
          <li> string "contents" - Contents of the file (text or base64 encoded if binary).
                   (only for non-directories) </li>
          <li> boolean "contents_enc64" - Identifies base64 encoded content
                   (default: disabled, only for non-directories) </li>
          <li> string "owner" - Owner of the file/directory. </li>
          <li> string "group" - Group name of the file/directory. </li>
          <li> string "permissions" - Octal file/directory permissions (eg: 644) </li>
          <li> string "selinux_ctx" - SELinux Security context (optional) </li>
          <li> string "macro-start-delimiter" - Config file macro start delimiter. Use null or empty
                  string to accept the default. (only for non-directories) </li>
          <li> string "macro-end-delimiter" - Config file macro end delimiter. Use null or
  empty string to accept the default. (only for non-directories) </li>
          <li> int "revision" - next revision number, auto increment for null </li>
          <li> boolean "binary" - mark the binary content, if True,
      base64 encoded content is expected (only for non-directories) </li>

  	</ul>
 </li>
</ul>
<p />
Returns:
<code><ul><li>




	     struct - Configuration Revision information
	<ul>
   	<li> string "type"</li>
              	<ul>
                  	<li>file</li>
                  	<li>directory</li>
                  	<li>symlink</li>
              	</ul>
       <li> string "path" - File Path </li>
       <li> string "target_path" - Symbolic link Target File Path.
                              Present for Symbolic links only. </li>
       <li> string "channel" - Channel Name </li>
       <li> string "contents" - File contents (base64 encoded according
                to the contents_enc64 attribute) </li>
       <li> boolean "contents_enc64" -  Identifies base64 encoded content </li>
       <li> int "revision" - File Revision </li>
       <li> dateTime.iso8601 "creation" - Creation Date </li>
       <li> dateTime.iso8601 "modified" - Last Modified Date </li>
       <li> string "owner" - File Owner. Present for files or directories only. </li>
       <li> string "group" - File Group. Present for files or directories only. </li>
       <li> int "permissions" - File Permissions (Deprecated).
                                  Present for files or directories only. </li>
       <li> string "permissions_mode" - File Permissions.
                                      Present for files or directories only. </li>
       <li> string "selinux_ctx" - SELinux Context (optional). </li>
       <li> boolean "binary" - true/false , Present for files only. </li>
       <li> string "sha256" - File's sha256 signature. Present for files only. </li>
       <li> string "macro-start-delimiter" - Macro start delimiter for a config file. Present for text files only. </li>
       <li> string "macro-end-delimiter" - Macro end delimiter for a config file. Present for text files only. </li>
 	</ul>
  
 
</li></ul>
</code>
<p />
Available since: 10.2 <p />
<hr />

<h3> <a name="createOrUpdateSymlink" href="#top">Method: createOrUpdateSymlink</a></h3>
Description:<br />
Create a new symbolic link with the given path, or
 update an existing path.
<p />




Parameters:<br />
<ul>
<li>

        string sessionKey
 </li>
<li>

    string configChannelLabel
 </li>
<li>

    string path
 </li>
<li>

	     struct - path info
	<ul>
          <li> string "target_path" - The target path for the symbolic link </li>
          <li> string "selinux_ctx" - SELinux Security context (optional) </li>
          <li> int "revision" - next revision number,
       skip this field for automatic revision number assignment </li>
  	</ul>
 </li>
</ul>
<p />
Returns:
<code><ul><li>




	     struct - Configuration Revision information
	<ul>
   	<li> string "type"</li>
              	<ul>
                  	<li>file</li>
                  	<li>directory</li>
                  	<li>symlink</li>
              	</ul>
       <li> string "path" - File Path </li>
       <li> string "target_path" - Symbolic link Target File Path.
                              Present for Symbolic links only. </li>
       <li> string "channel" - Channel Name </li>
       <li> string "contents" - File contents (base64 encoded according
                to the contents_enc64 attribute) </li>
       <li> boolean "contents_enc64" -  Identifies base64 encoded content </li>
       <li> int "revision" - File Revision </li>
       <li> dateTime.iso8601 "creation" - Creation Date </li>
       <li> dateTime.iso8601 "modified" - Last Modified Date </li>
       <li> string "owner" - File Owner. Present for files or directories only. </li>
       <li> string "group" - File Group. Present for files or directories only. </li>
       <li> int "permissions" - File Permissions (Deprecated).
                                  Present for files or directories only. </li>
       <li> string "permissions_mode" - File Permissions.
                                      Present for files or directories only. </li>
       <li> string "selinux_ctx" - SELinux Context (optional). </li>
       <li> boolean "binary" - true/false , Present for files only. </li>
       <li> string "sha256" - File's sha256 signature. Present for files only. </li>
       <li> string "macro-start-delimiter" - Macro start delimiter for a config file. Present for text files only. </li>
       <li> string "macro-end-delimiter" - Macro end delimiter for a config file. Present for text files only. </li>
 	</ul>
  
 
</li></ul>
</code>
<p />
Available since: 10.2 <p />
<hr />

<h3> <a name="deleteChannels" href="#top">Method: deleteChannels</a></h3>
Description:<br />
Delete a list of global config channels.
 Caller must be a config admin.
<p />




Parameters:<br />
<ul>
<li>

        string sessionKey
 </li>
<li>

array:
<ul>
    <li>string - configuration channel labels to delete.</li>
</ul>
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

<h3> <a name="deleteFileRevisions" href="#top">Method: deleteFileRevisions</a></h3>
Description:<br />
Delete specified revisions of a given configuration file
<p />




Parameters:<br />
<ul>
<li>

        string sessionKey
 </li>
<li>

    string channelLabel - Label of config channel to lookup on.
 </li>
<li>

    string filePath - Configuration file path.
 </li>
<li>

array:
<ul>
    <li>int - List of revisions to delete</li>
</ul>
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

<h3> <a name="deleteFiles" href="#top">Method: deleteFiles</a></h3>
Description:<br />
Remove file paths from a global channel.
<p />




Parameters:<br />
<ul>
<li>

        string sessionKey
 </li>
<li>

    string channelLabel - Channel to remove the files from.
 </li>
<li>

array:
<ul>
    <li>string - file paths to remove.</li>
</ul>
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

<h3> <a name="deployAllSystems" href="#top">Method: deployAllSystems</a></h3>
Description:<br />
Schedule an immediate configuration deployment for all systems
    subscribed to a particular configuration channel.
<p />




Parameters:<br />
<ul>
<li>

        string sessionKey
 </li>
<li>

    string channelLabel - The configuration channel's label.
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

<h3> <a name="deployAllSystems" href="#top">Method: deployAllSystems</a></h3>
Description:<br />
Schedule a configuration deployment for all systems
    subscribed to a particular configuration channel.
<p />




Parameters:<br />
<ul>
<li>

        string sessionKey
 </li>
<li>

    string channelLabel - The configuration channel's label.
 </li>
<li>

    dateTime.iso8601 date - The date to schedule the action
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

<h3> <a name="deployAllSystems" href="#top">Method: deployAllSystems</a></h3>
Description:<br />
Schedule a configuration deployment of a certain file for all systems
    subscribed to a particular configuration channel.
<p />




Parameters:<br />
<ul>
<li>

        string sessionKey
 </li>
<li>

    string channelLabel - The configuration channel's label.
 </li>
<li>

    string filePath - The configuration file path.
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

<h3> <a name="deployAllSystems" href="#top">Method: deployAllSystems</a></h3>
Description:<br />
Schedule a configuration deployment of a certain file for all systems
    subscribed to a particular configuration channel.
<p />




Parameters:<br />
<ul>
<li>

        string sessionKey
 </li>
<li>

    string channelLabel - The configuration channel's label.
 </li>
<li>

    string filePath - The configuration file path.
 </li>
<li>

    dateTime.iso8601 date - The date to schedule the action
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

<h3> <a name="getDetails" href="#top">Method: getDetails</a></h3>
Description:<br />
Lookup config channel details.
<p />




Parameters:<br />
<ul>
<li>

        string sessionKey
 </li>
<li>

    string channelLabel
 </li>
</ul>
<p />
Returns:
<code><ul><li>




	     struct - Configuration Channel information
	<ul>
   	<li> int "id"</li>
   	<li> int "orgId"</li>
   	<li> string "label"</li>
   	<li> string "name"</li>
   	<li> string "description"</li>
   	<li> struct "configChannelType"</li>
   

	     struct - Configuration Channel Type information
	<ul>
   	<li> int "id"</li>
   	<li> string "label"</li>
   	<li> string "name"</li>
   	<li> int "priority"</li>
 	</ul>
 
 	</ul>
  
 
</li></ul>
</code>
<p />
<hr />

<h3> <a name="getDetails" href="#top">Method: getDetails</a></h3>
Description:<br />
Lookup config channel details.
<p />




Parameters:<br />
<ul>
<li>

        string sessionKey
 </li>
<li>

int channelId 
 </li>
</ul>
<p />
Returns:
<code><ul><li>




	     struct - Configuration Channel information
	<ul>
   	<li> int "id"</li>
   	<li> int "orgId"</li>
   	<li> string "label"</li>
   	<li> string "name"</li>
   	<li> string "description"</li>
   	<li> struct "configChannelType"</li>
   

	     struct - Configuration Channel Type information
	<ul>
   	<li> int "id"</li>
   	<li> string "label"</li>
   	<li> string "name"</li>
   	<li> int "priority"</li>
 	</ul>
 
 	</ul>
  
 
</li></ul>
</code>
<p />
<hr />

<h3> <a name="getEncodedFileRevision" href="#top">Method: getEncodedFileRevision</a></h3>
Description:<br />
Get revision of the specified configuration file and transmit the
             contents as base64 encoded.
<p />




Parameters:<br />
<ul>
<li>

        string sessionKey
 </li>
<li>

    string configChannelLabel - label of config channel to lookup on
 </li>
<li>

    string filePath - config file path to examine
 </li>
<li>

    int revision - config file revision to examine
 </li>
</ul>
<p />
Returns:
<code><ul><li>




	     struct - Configuration Revision information
	<ul>
   	<li> string "type"</li>
              	<ul>
                  	<li>file</li>
                  	<li>directory</li>
                  	<li>symlink</li>
              	</ul>
       <li> string "path" - File Path </li>
       <li> string "target_path" - Symbolic link Target File Path.
                              Present for Symbolic links only. </li>
       <li> string "channel" - Channel Name </li>
       <li> string "contents" - File contents (base64 encoded according
                to the contents_enc64 attribute) </li>
       <li> boolean "contents_enc64" -  Identifies base64 encoded content </li>
       <li> int "revision" - File Revision </li>
       <li> dateTime.iso8601 "creation" - Creation Date </li>
       <li> dateTime.iso8601 "modified" - Last Modified Date </li>
       <li> string "owner" - File Owner. Present for files or directories only. </li>
       <li> string "group" - File Group. Present for files or directories only. </li>
       <li> int "permissions" - File Permissions (Deprecated).
                                  Present for files or directories only. </li>
       <li> string "permissions_mode" - File Permissions.
                                      Present for files or directories only. </li>
       <li> string "selinux_ctx" - SELinux Context (optional). </li>
       <li> boolean "binary" - true/false , Present for files only. </li>
       <li> string "sha256" - File's sha256 signature. Present for files only. </li>
       <li> string "macro-start-delimiter" - Macro start delimiter for a config file. Present for text files only. </li>
       <li> string "macro-end-delimiter" - Macro end delimiter for a config file. Present for text files only. </li>
 	</ul>
  
 
</li></ul>
</code>
<p />
<hr />

<h3> <a name="getFileRevision" href="#top">Method: getFileRevision</a></h3>
Description:<br />
Get revision of the specified config file
<p />




Parameters:<br />
<ul>
<li>

        string sessionKey
 </li>
<li>

    string configChannelLabel - label of config channel to lookup on
 </li>
<li>

    string filePath - config file path to examine
 </li>
<li>

    int revision - config file revision to examine
 </li>
</ul>
<p />
Returns:
<code><ul><li>




	     struct - Configuration Revision information
	<ul>
   	<li> string "type"</li>
              	<ul>
                  	<li>file</li>
                  	<li>directory</li>
                  	<li>symlink</li>
              	</ul>
       <li> string "path" - File Path </li>
       <li> string "target_path" - Symbolic link Target File Path.
                              Present for Symbolic links only. </li>
       <li> string "channel" - Channel Name </li>
       <li> string "contents" - File contents (base64 encoded according
                to the contents_enc64 attribute) </li>
       <li> boolean "contents_enc64" -  Identifies base64 encoded content </li>
       <li> int "revision" - File Revision </li>
       <li> dateTime.iso8601 "creation" - Creation Date </li>
       <li> dateTime.iso8601 "modified" - Last Modified Date </li>
       <li> string "owner" - File Owner. Present for files or directories only. </li>
       <li> string "group" - File Group. Present for files or directories only. </li>
       <li> int "permissions" - File Permissions (Deprecated).
                                  Present for files or directories only. </li>
       <li> string "permissions_mode" - File Permissions.
                                      Present for files or directories only. </li>
       <li> string "selinux_ctx" - SELinux Context (optional). </li>
       <li> boolean "binary" - true/false , Present for files only. </li>
       <li> string "sha256" - File's sha256 signature. Present for files only. </li>
       <li> string "macro-start-delimiter" - Macro start delimiter for a config file. Present for text files only. </li>
       <li> string "macro-end-delimiter" - Macro end delimiter for a config file. Present for text files only. </li>
 	</ul>
  
 
</li></ul>
</code>
<p />
<hr />

<h3> <a name="getFileRevisions" href="#top">Method: getFileRevisions</a></h3>
Description:<br />
Get list of revisions for specified config file
<p />




Parameters:<br />
<ul>
<li>

        string sessionKey
 </li>
<li>

    string channelLabel - label of config channel to lookup on
 </li>
<li>

    string filePath - config file path to examine
 </li>
</ul>
<p />
Returns:
<code><ul><li>


array:
  <ul>
   <li>
 

	     struct - Configuration Revision information
	<ul>
   	<li> string "type"</li>
              	<ul>
                  	<li>file</li>
                  	<li>directory</li>
                  	<li>symlink</li>
              	</ul>
       <li> string "path" - File Path </li>
       <li> string "target_path" - Symbolic link Target File Path.
                              Present for Symbolic links only. </li>
       <li> string "channel" - Channel Name </li>
       <li> string "contents" - File contents (base64 encoded according
                to the contents_enc64 attribute) </li>
       <li> boolean "contents_enc64" -  Identifies base64 encoded content </li>
       <li> int "revision" - File Revision </li>
       <li> dateTime.iso8601 "creation" - Creation Date </li>
       <li> dateTime.iso8601 "modified" - Last Modified Date </li>
       <li> string "owner" - File Owner. Present for files or directories only. </li>
       <li> string "group" - File Group. Present for files or directories only. </li>
       <li> int "permissions" - File Permissions (Deprecated).
                                  Present for files or directories only. </li>
       <li> string "permissions_mode" - File Permissions.
                                      Present for files or directories only. </li>
       <li> string "selinux_ctx" - SELinux Context (optional). </li>
       <li> boolean "binary" - true/false , Present for files only. </li>
       <li> string "sha256" - File's sha256 signature. Present for files only. </li>
       <li> string "macro-start-delimiter" - Macro start delimiter for a config file. Present for text files only. </li>
       <li> string "macro-end-delimiter" - Macro end delimiter for a config file. Present for text files only. </li>
 	</ul>
 
 </li></ul>
 
</li></ul>
</code>
<p />
<hr />

<h3> <a name="listFiles" href="#top">Method: listFiles</a></h3>
Description:<br />
Return a list of files in a channel.
<p />




Parameters:<br />
<ul>
<li>

        string sessionKey
 </li>
<li>

    string channelLabel - label of config channel to list files on.
 </li>
</ul>
<p />
Returns:
<code><ul><li>


array:
  <ul>
   <li>
 

	     struct - Configuration File information
	<ul>
   	<li> string "type"</li>
              	<ul>
                  	<li>file</li>
                  	<li>directory</li>
                  	<li>symlink</li>
              	</ul>
       <li> string "path" - File Path </li>
       <li> dateTime.iso8601 "last_modified" - Last Modified Date </li>
 	</ul>
 
 </li></ul>
 
</li></ul>
</code>
<p />
<hr />

<h3> <a name="listGlobals" href="#top">Method: listGlobals</a></h3>
Description:<br />
List all the global config channels accessible to the logged-in user.
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
  

	     struct - Configuration Channel information
	<ul>
   	<li> int "id"</li>
   	<li> int "orgId"</li>
   	<li> string "label"</li>
   	<li> string "name"</li>
   	<li> string "description"</li>
   	<li> string "type"</li>
   	<li> struct "configChannelType"</li>
   

	     struct - Configuration Channel Type information
	<ul>
   	<li> int "id"</li>
   	<li> string "label"</li>
   	<li> string "name"</li>
   	<li> int "priority"</li>
 	</ul>
 
 	</ul>
 
 </li></ul>
 
</li></ul>
</code>
<p />
<hr />

<h3> <a name="listSubscribedSystems" href="#top">Method: listSubscribedSystems</a></h3>
Description:<br />
Return a list of systems subscribed to a configuration channel
<p />




Parameters:<br />
<ul>
<li>

        string sessionKey
 </li>
<li>

    string channelLabel - label of config channel to list subscribed systems.
 </li>
</ul>
<p />
Returns:
<code><ul><li>


array:
  <ul>
   <li>
 

	     struct - system
	<ul>
   	<li> int "id"</li>
   	<li> string "name"</li>
 	</ul>
 
 </li></ul>
 
</li></ul>
</code>
<p />
<hr />

<h3> <a name="lookupChannelInfo" href="#top">Method: lookupChannelInfo</a></h3>
Description:<br />
Lists details on a list channels given their channel labels.
<p />




Parameters:<br />
<ul>
<li>

        string sessionKey
 </li>
<li>

array:
<ul>
    <li>string - configuration channel label</li>
</ul>
 </li>
</ul>
<p />
Returns:
<code><ul><li>


array:
  <ul>
   <li>
  

	     struct - Configuration Channel information
	<ul>
   	<li> int "id"</li>
   	<li> int "orgId"</li>
   	<li> string "label"</li>
   	<li> string "name"</li>
   	<li> string "description"</li>
   	<li> struct "configChannelType"</li>
   

	     struct - Configuration Channel Type information
	<ul>
   	<li> int "id"</li>
   	<li> string "label"</li>
   	<li> string "name"</li>
   	<li> int "priority"</li>
 	</ul>
 
 	</ul>
 
 </li></ul>
 
</li></ul>
</code>
<p />
<hr />

<h3> <a name="lookupFileInfo" href="#top">Method: lookupFileInfo</a></h3>
Description:<br />
Given a list of paths and a channel, returns details about
 the latest revisions of the paths.
<p />




Parameters:<br />
<ul>
<li>

        string sessionKey
 </li>
<li>

    string channelLabel - label of config channel to lookup on
 </li>
<li>

array:
<ul>
    <li>string - List of paths to examine.</li>
</ul>
 </li>
</ul>
<p />
Returns:
<code><ul><li>


array:
  <ul>
   <li>
 

	     struct - Configuration Revision information
	<ul>
   	<li> string "type"</li>
              	<ul>
                  	<li>file</li>
                  	<li>directory</li>
                  	<li>symlink</li>
              	</ul>
       <li> string "path" - File Path </li>
       <li> string "target_path" - Symbolic link Target File Path.
                              Present for Symbolic links only. </li>
       <li> string "channel" - Channel Name </li>
       <li> string "contents" - File contents (base64 encoded according
                to the contents_enc64 attribute) </li>
       <li> boolean "contents_enc64" -  Identifies base64 encoded content </li>
       <li> int "revision" - File Revision </li>
       <li> dateTime.iso8601 "creation" - Creation Date </li>
       <li> dateTime.iso8601 "modified" - Last Modified Date </li>
       <li> string "owner" - File Owner. Present for files or directories only. </li>
       <li> string "group" - File Group. Present for files or directories only. </li>
       <li> int "permissions" - File Permissions (Deprecated).
                                  Present for files or directories only. </li>
       <li> string "permissions_mode" - File Permissions.
                                      Present for files or directories only. </li>
       <li> string "selinux_ctx" - SELinux Context (optional). </li>
       <li> boolean "binary" - true/false , Present for files only. </li>
       <li> string "sha256" - File's sha256 signature. Present for files only. </li>
       <li> string "macro-start-delimiter" - Macro start delimiter for a config file. Present for text files only. </li>
       <li> string "macro-end-delimiter" - Macro end delimiter for a config file. Present for text files only. </li>
 	</ul>
 
 </li></ul>
 
</li></ul>
</code>
<p />
Available since: 10.2 <p />
<hr />

<h3> <a name="lookupFileInfo" href="#top">Method: lookupFileInfo</a></h3>
Description:<br />
Given a path, revision number, and a channel, returns details about
 the latest revisions of the paths.
<p />




Parameters:<br />
<ul>
<li>

        string sessionKey
 </li>
<li>

    string channelLabel - label of config channel to lookup on
 </li>
<li>

    string path - path of file/directory
 </li>
<li>

    int revsion - The revision number.
 </li>
</ul>
<p />
Returns:
<code><ul><li>




	     struct - Configuration Revision information
	<ul>
   	<li> string "type"</li>
              	<ul>
                  	<li>file</li>
                  	<li>directory</li>
                  	<li>symlink</li>
              	</ul>
       <li> string "path" - File Path </li>
       <li> string "target_path" - Symbolic link Target File Path.
                              Present for Symbolic links only. </li>
       <li> string "channel" - Channel Name </li>
       <li> string "contents" - File contents (base64 encoded according
                to the contents_enc64 attribute) </li>
       <li> boolean "contents_enc64" -  Identifies base64 encoded content </li>
       <li> int "revision" - File Revision </li>
       <li> dateTime.iso8601 "creation" - Creation Date </li>
       <li> dateTime.iso8601 "modified" - Last Modified Date </li>
       <li> string "owner" - File Owner. Present for files or directories only. </li>
       <li> string "group" - File Group. Present for files or directories only. </li>
       <li> int "permissions" - File Permissions (Deprecated).
                                  Present for files or directories only. </li>
       <li> string "permissions_mode" - File Permissions.
                                      Present for files or directories only. </li>
       <li> string "selinux_ctx" - SELinux Context (optional). </li>
       <li> boolean "binary" - true/false , Present for files only. </li>
       <li> string "sha256" - File's sha256 signature. Present for files only. </li>
       <li> string "macro-start-delimiter" - Macro start delimiter for a config file. Present for text files only. </li>
       <li> string "macro-end-delimiter" - Macro end delimiter for a config file. Present for text files only. </li>
 	</ul>
  
 
</li></ul>
</code>
<p />
Available since: 10.12 <p />
<hr />

<h3> <a name="scheduleFileComparisons" href="#top">Method: scheduleFileComparisons</a></h3>
Description:<br />
Schedule a comparison of the latest revision of a file
 against the version deployed on a list of systems.
<p />




Parameters:<br />
<ul>
<li>

        string sessionKey
 </li>
<li>

    string channelLabel - Label of config channel
 </li>
<li>

    string path - File path
 </li>
<li>

array:
<ul>
    <li>long - The list of server id that the
 comparison will be performed on</li>
</ul>
 </li>
</ul>
<p />
Returns:
<code><ul><li>


int actionId - The action id of the scheduled action 
 
</li></ul>
</code>
<p />
<hr />

<h3> <a name="update" href="#top">Method: update</a></h3>
Description:<br />
Update a global config channel. Caller must be at least a
 config admin or an organization admin, or have access to a system containing this
 config channel.
<p />




Parameters:<br />
<ul>
<li>

        string sessionKey
 </li>
<li>

string channelLabel 
 </li>
<li>

string channelName 
 </li>
<li>

string description 
 </li>
</ul>
<p />
Returns:
<code><ul><li>




	     struct - Configuration Channel information
	<ul>
   	<li> int "id"</li>
   	<li> int "orgId"</li>
   	<li> string "label"</li>
   	<li> string "name"</li>
   	<li> string "description"</li>
   	<li> struct "configChannelType"</li>
   

	     struct - Configuration Channel Type information
	<ul>
   	<li> int "id"</li>
   	<li> string "label"</li>
   	<li> string "name"</li>
   	<li> int "priority"</li>
 	</ul>
 
 	</ul>
  
 
</li></ul>
</code>
<p />
<hr />
</body>
</html>
