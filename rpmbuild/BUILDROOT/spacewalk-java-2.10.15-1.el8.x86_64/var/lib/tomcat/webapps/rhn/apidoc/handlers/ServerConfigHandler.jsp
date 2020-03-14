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
system.config
</p>
<p>Provides methods to access and modify many aspects of
 configuration channels and server association.
 basically system.config name space</p>
<span class="small-text">( <a href="/rhn/apidoc/index.jsp">Return to API Overview</a> )</span>
<hr />

<div class="rounded-box">
<h2><a name="top">Available methods</a></h2>
<ul class="apidoc">

<li><a href="#addChannels"/>addChannels</a></li>
<li><a href="#createOrUpdatePath"/>createOrUpdatePath</a></li>
<li><a href="#createOrUpdateSymlink"/>createOrUpdateSymlink</a></li>
<li><a href="#deleteFiles"/>deleteFiles</a></li>
<li><a href="#deployAll"/>deployAll</a></li>
<li><a href="#listChannels"/>listChannels</a></li>
<li><a href="#listFiles"/>listFiles</a></li>
<li><a href="#lookupFileInfo"/>lookupFileInfo</a></li>
<li><a href="#removeChannels"/>removeChannels</a></li>
<li><a href="#setChannels"/>setChannels</a></li>
</ul>
</div>
<hr />

<h3> <a name="addChannels" href="#top">Method: addChannels</a></h3>
Description:<br />
Given a list of servers and configuration channels,
 this method appends the configuration channels to either the top or
 the bottom (whichever you specify) of a system's subscribed
 configuration channels list. The ordering of the configuration channels
 provided in the add list is maintained while adding.
 If one of the configuration channels in the 'add' list
 has been previously subscribed by a server, the
 subscribed channel will be re-ranked to the appropriate place.
<p />




Parameters:<br />
<ul>
<li>

        string sessionKey
 </li>
<li>

array:
<ul>
    <li>int - IDs of the systems to add the channels to.</li>
</ul>
 </li>
<li>

array:
<ul>
    <li>string - List of configuration channel labels in the ranked order.</li>
</ul>
 </li>
<li>

    boolean addToTop
      	<ul>
          	<li>true - to prepend the given channels
          list to the top of the configuration channels list of a server</li>
          	<li>false - to append the given  channels
          list to the bottom of the configuration channels list of a server</li>
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

<h3> <a name="createOrUpdatePath" href="#top">Method: createOrUpdatePath</a></h3>
Description:<br />
Create a new file (text or binary) or directory with the given path, or
 update an existing path on a server.
<p />




Parameters:<br />
<ul>
<li>

        string sessionKey
 </li>
<li>

    int serverId
 </li>
<li>

    string path - the configuration file/directory path
 </li>
<li>

    boolean isDir
      	<ul>
          	<li>True - if the path is a directory</li>
          	<li>False - if the path is a file</li>
      	</ul>
 </li>
<li>

	     struct - path info
	<ul>
          <li> string "contents" - Contents of the file (text or base64 encoded if binary)
                   ((only for non-directories) </li>
          <li> boolean "contents_enc64" - Identifies base64 encoded content
                  (default: disabled, only for non-directories). </li>
          <li> string "owner" - Owner of the file/directory. </li>
          <li> string "group" - Group name of the file/directory. </li>
          <li> string "permissions" - Octal file/directory permissions (eg: 644) </li>
          <li> string "macro-start-delimiter" - Config file macro end delimiter. Use null or empty string
              to accept the default. (only for non-directories) </li>
          <li> string "macro-end-delimiter" - Config file macro end delimiter. Use null or empty string
              to accept the default. (only for non-directories) </li>
          <li> string "selinux_ctx" - SeLinux context (optional) </li>
          <li> int "revision" - next revision number, auto increment for null </li>
          <li> boolean "binary" - mark the binary content, if True,
      base64 encoded content is expected (only for non-directories) </li>
  	</ul>
 </li>
<li>

    int commitToLocal
      	<ul>
          	<li>1 - to commit configuration files
              to the system's local override configuration channel</li>
          	<li>0 - to commit configuration files
              to the system's sandbox configuration channel</li>
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

    int serverId
 </li>
<li>

    string path - the configuration file/directory path
 </li>
<li>

	     struct - path info
	<ul>
          <li> string "target_path" - The target path for the symbolic link </li>
          <li> string "selinux_ctx" - SELinux Security context (optional) </li>
          <li> int "revision" - next revision number, auto increment for null </li>
  	</ul>
 </li>
<li>

    int commitToLocal
      	<ul>
          	<li>1 - to commit configuration files
              to the system's local override configuration channel</li>
          	<li>0 - to commit configuration files
              to the system's sandbox configuration channel</li>
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

<h3> <a name="deleteFiles" href="#top">Method: deleteFiles</a></h3>
Description:<br />
Removes file paths from a local or sandbox channel of a server.
<p />




Parameters:<br />
<ul>
<li>

        string sessionKey
 </li>
<li>

    int serverId
 </li>
<li>

array:
<ul>
    <li>string - paths to remove.</li>
</ul>
 </li>
<li>

    boolean deleteFromLocal
      	<ul>
          	<li>True - to delete configuration file paths
              from the system's local override configuration channel</li>
          	<li>False - to delete configuration file paths
              from the system's sandbox configuration channel</li>
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

<h3> <a name="deployAll" href="#top">Method: deployAll</a></h3>
Description:<br />
Schedules a deploy action for all the configuration files
 on the given list of systems.
<p />




Parameters:<br />
<ul>
<li>

        string sessionKey
 </li>
<li>

array:
<ul>
    <li>int - id of the systems to schedule configuration files deployment</li>
</ul>
 </li>
<li>

    dateTime.iso8601 date - Earliest date for the deploy action.
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

<h3> <a name="listChannels" href="#top">Method: listChannels</a></h3>
Description:<br />
List all global configuration channels associated to a
              system in the order of their ranking.
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

<h3> <a name="listFiles" href="#top">Method: listFiles</a></h3>
Description:<br />
Return the list of files in a given channel.
<p />




Parameters:<br />
<ul>
<li>

        string sessionKey
 </li>
<li>

    int serverId
 </li>
<li>

    int listLocal
      	<ul>
          	<li>1 - to return configuration files
              in the system's local override configuration channel</li>
          	<li>0 - to return configuration files
              in the system's sandbox configuration channel</li>
      	</ul>
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
       <li> string "channel_label" - the label of the  central configuration channel
      that has this file. Note this entry only shows up
      if the file has not been overridden by a central channel. </li>
   	<li> struct "channel_type"</li>
   

	     struct - Configuration Channel Type information
	<ul>
   	<li> int "id"</li>
   	<li> string "label"</li>
   	<li> string "name"</li>
   	<li> int "priority"</li>
 	</ul>
 
       <li> dateTime.iso8601 "last_modified" - Last Modified Date </li>
 	</ul>
 
 </li></ul>
 
</li></ul>
</code>
<p />
<hr />

<h3> <a name="lookupFileInfo" href="#top">Method: lookupFileInfo</a></h3>
Description:<br />
Given a list of paths and a server, returns details about
 the latest revisions of the paths.
<p />




Parameters:<br />
<ul>
<li>

        string sessionKey
 </li>
<li>

    int serverId
 </li>
<li>

array:
<ul>
    <li>string - paths to lookup on.</li>
</ul>
 </li>
<li>

    int searchLocal
      	<ul>
          	<li>1 - to search configuration file paths
              in the system's local override configuration or
              systems subscribed central channels</li>
          	<li>0 - to search configuration file paths
              in the system's sandbox configuration channel</li>
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

<h3> <a name="removeChannels" href="#top">Method: removeChannels</a></h3>
Description:<br />
Remove config channels from the given servers.
<p />




Parameters:<br />
<ul>
<li>

        string sessionKey
 </li>
<li>

array:
<ul>
    <li>int - the IDs of the systems from which you
              would like to remove configuration channels..</li>
</ul>
 </li>
<li>

array:
<ul>
    <li>string - List of configuration channel labels to remove.</li>
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

<h3> <a name="setChannels" href="#top">Method: setChannels</a></h3>
Description:<br />
Replace the existing set of config channels on the given servers.
 Channels are ranked according to their order in the configChannelLabels
 array.
<p />




Parameters:<br />
<ul>
<li>

        string sessionKey
 </li>
<li>

array:
<ul>
    <li>int - IDs of the systems to set the channels on.</li>
</ul>
 </li>
<li>

array:
<ul>
    <li>string - List of configuration channel labels in the ranked order.</li>
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
</body>
</html>
