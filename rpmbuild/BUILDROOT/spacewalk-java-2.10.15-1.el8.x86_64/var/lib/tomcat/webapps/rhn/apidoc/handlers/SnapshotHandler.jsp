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
system.provisioning.snapshot
</p>
<p>Provides methods to access and delete system snapshots.</p>
<span class="small-text">( <a href="/rhn/apidoc/index.jsp">Return to API Overview</a> )</span>
<hr />

<div class="rounded-box">
<h2><a name="top">Available methods</a></h2>
<ul class="apidoc">

<li><a href="#addTagToSnapshot"/>addTagToSnapshot</a></li>
<li><a href="#deleteSnapshot"/>deleteSnapshot</a></li>
<li><a href="#deleteSnapshots"/>deleteSnapshots</a></li>
<li><a href="#deleteSnapshots"/>deleteSnapshots</a></li>
<li><a href="#listSnapshotConfigFiles"/>listSnapshotConfigFiles</a></li>
<li><a href="#listSnapshotPackages"/>listSnapshotPackages</a></li>
<li><a href="#listSnapshots"/>listSnapshots</a></li>
<li><a href="#rollbackToSnapshot"/>rollbackToSnapshot</a></li>
<li><a href="#rollbackToTag"/>rollbackToTag</a></li>
<li><a href="#rollbackToTag"/>rollbackToTag</a></li>
</ul>
</div>
<hr />

<h3> <a name="addTagToSnapshot" href="#top">Method: addTagToSnapshot</a></h3>
Description:<br />
Adds tag to snapshot
<p />




Parameters:<br />
<ul>
<li>

        string sessionKey
 </li>
<li>

    int snapshotId - Id of the snapshot
 </li>
<li>

    string tag - Name of the snapshot tag
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

<h3> <a name="deleteSnapshot" href="#top">Method: deleteSnapshot</a></h3>
Description:<br />
Deletes a snapshot with the given snapshot id
<p />




Parameters:<br />
<ul>
<li>

        string sessionKey
 </li>
<li>

    int snapshotId - Id of snapshot to delete
 </li>
</ul>
<p />
Returns:
<code><ul><li>


    int - 1 on success, exception thrown otherwise.
 
</li></ul>
</code>
<p />
Available since: 10.1 <p />
<hr />

<h3> <a name="deleteSnapshots" href="#top">Method: deleteSnapshots</a></h3>
Description:<br />
Deletes all snapshots across multiple systems based on the given date
 criteria.  For example,
 <ul>
 <li>If the user provides startDate only, all snapshots created either on or after
 the date provided will be removed.</li>
 <li>If user provides startDate and endDate, all snapshots created on or between the
 dates provided will be removed.</li>
 <li>If the user doesn't provide a startDate and endDate, all snapshots will be
 removed.</li>
 </ul>
<p />




Parameters:<br />
<ul>
<li>

        string sessionKey
 </li>
<li>

	     struct - date details
	<ul>
             <li> dateTime.iso8601 "startDate" - Optional, unless endDate
         is provided. </li>
             <li> dateTime.iso8601 "endDate" - Optional. </li>
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
Available since: 10.1 <p />
<hr />

<h3> <a name="deleteSnapshots" href="#top">Method: deleteSnapshots</a></h3>
Description:<br />
Deletes all snapshots for a given system based on the date
 criteria.  For example,
 <ul>
 <li>If the user provides startDate only, all snapshots created either on or after
 the date provided will be removed.</li>
 <li>If user provides startDate and endDate, all snapshots created on or between the
 dates provided will be removed.</li>
 <li>If the user doesn't provide a startDate and endDate, all snapshots associated
 with the server will be removed.</li>
 </ul>
<p />




Parameters:<br />
<ul>
<li>

        string sessionKey
 </li>
<li>

    int sid - system id of system to delete
          snapshots for
 </li>
<li>

	     struct - date details
	<ul>
             <li> dateTime.iso8601 "startDate" - Optional, unless endDate
         is provided. </li>
             <li> dateTime.iso8601 "endDate" - Optional. </li>
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
Available since: 10.1 <p />
<hr />

<h3> <a name="listSnapshotConfigFiles" href="#top">Method: listSnapshotConfigFiles</a></h3>
Description:<br />
List the config files associated with a snapshot.
<p />




Parameters:<br />
<ul>
<li>

        string sessionKey
 </li>
<li>

    int snapId
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

<h3> <a name="listSnapshotPackages" href="#top">Method: listSnapshotPackages</a></h3>
Description:<br />
List the packages associated with a snapshot.
<p />




Parameters:<br />
<ul>
<li>

        string sessionKey
 </li>
<li>

    int snapId
 </li>
</ul>
<p />
Returns:
<code><ul><li>


array:
  <ul>
   <li>
         

	     struct - package nvera
	<ul>
      	<li> string "name"</li>
      	<li> string "epoch"</li>
      	<li> string "version"</li>
      	<li> string "release"</li>
      	<li> string "arch"</li>
  	</ul>
 
     </li></ul>
 
</li></ul>
</code>
<p />
Available since: 10.1 <p />
<hr />

<h3> <a name="listSnapshots" href="#top">Method: listSnapshots</a></h3>
Description:<br />
List snapshots for a given system.
 A user may optionally provide a start and end date to narrow the snapshots that
 will be listed.  For example,
 <ul>
 <li>If the user provides startDate only, all snapshots created either on or after
 the date provided will be returned.</li>
 <li>If user provides startDate and endDate, all snapshots created on or between the
 dates provided will be returned.</li>
 <li>If the user doesn't provide a startDate and endDate, all snapshots associated
 with the server will be returned.</li>
 </ul>
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

	     struct - date details
	<ul>
             <li> dateTime.iso8601 "startDate" - Optional, unless endDate
         is provided. </li>
             <li> dateTime.iso8601 "endDate" - Optional. </li>
     	</ul>
 </li>
</ul>
<p />
Returns:
<code><ul><li>


array:
  <ul>
   <li>
      

	     struct - server snapshot
	<ul>
      	<li> int "id"</li>
          <li> string "reason" - the reason for the snapshot's existence </li>
      	<li> dateTime.iso8601 "created"</li>
          <li>array "channels"
        <ul>
            <li>string labels of channels associated with the
              snapshot</li>
        </ul>
    </li>
          <li>array "groups"
        <ul>
            <li>string Names of server groups associated with
              the snapshot</li>
        </ul>
    </li>
          <li>array "entitlements"
        <ul>
            <li>string Names of system entitlements associated
              with the snapshot</li>
        </ul>
    </li>
           <li>array "config_channels"
        <ul>
            <li>string Labels of config channels the snapshot
                  is associated with.</li>
        </ul>
    </li>
          <li>array "tags"
        <ul>
            <li>string Tag names associated with this snapshot.</li>
        </ul>
    </li>
          <li> string "Invalid_reason" - If the snapshot is invalid, this is the
                  reason (optional). </li>
  	</ul>
 
  </li></ul>
 
</li></ul>
</code>
<p />
Available since: 10.1 <p />
<hr />

<h3> <a name="rollbackToSnapshot" href="#top">Method: rollbackToSnapshot</a></h3>
Description:<br />
Rollbacks server to snapshot
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

    int snapshotId - Id of the snapshot
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

<h3> <a name="rollbackToTag" href="#top">Method: rollbackToTag</a></h3>
Description:<br />
Rollbacks server to snapshot
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

    string tagName - Name of the snapshot tag
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

<h3> <a name="rollbackToTag" href="#top">Method: rollbackToTag</a></h3>
Description:<br />
Rollbacks server to snapshot
<p />




Parameters:<br />
<ul>
<li>

        string sessionKey
 </li>
<li>

    string tagName - Name of the snapshot tag
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
