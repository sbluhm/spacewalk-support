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
kickstart.tree
</p>
<p>Provides methods to access and modify the kickstart trees.</p>
<span class="small-text">( <a href="/rhn/apidoc/index.jsp">Return to API Overview</a> )</span>
<hr />

<div class="rounded-box">
<h2><a name="top">Available methods</a></h2>
<ul class="apidoc">

<li><a href="#create"/>create</a></li>
<li><a href="#delete"/>delete</a></li>
<li><a href="#deleteTreeAndProfiles"/>deleteTreeAndProfiles</a></li>
<li><a href="#getDetails"/>getDetails</a></li>
<li><a href="#list"/>list</a></li>
<li><a href="#listInstallTypes"/>listInstallTypes</a></li>
<li><a href="#rename"/>rename</a></li>
<li><a href="#update"/>update</a></li>
</ul>
</div>
<hr />

<h3> <a name="create" href="#top">Method: create</a></h3>
Description:<br />
Create a Kickstart Tree (Distribution) in Satellite.
<p />




Parameters:<br />
<ul>
<li>

        string sessionKey
 </li>
<li>

    string treeLabel - The new kickstart tree label.
 </li>
<li>

    string basePath - Path to the base or
 root of the kickstart tree.
 </li>
<li>

    string channelLabel - Label of channel to
 associate with the kickstart tree. 
 </li>
<li>

    string installType - Label for
 KickstartInstallType (rhel_2.1, rhel_3, rhel_4, rhel_5, fedora_9).
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

<h3> <a name="delete" href="#top">Method: delete</a></h3>
Description:<br />
Delete a Kickstart Tree (Distribution) in Satellite.
<p />




Parameters:<br />
<ul>
<li>

        string sessionKey
 </li>
<li>

    string treeLabel - Label for the
 kickstart tree to delete.
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

<h3> <a name="deleteTreeAndProfiles" href="#top">Method: deleteTreeAndProfiles</a></h3>
Description:<br />
Delete a kickstarttree and any profiles associated with
 this kickstart tree.  WARNING:  This will delete all profiles
 associated with this kickstart tree!
<p />




Parameters:<br />
<ul>
<li>

        string sessionKey
 </li>
<li>

    string treeLabel - Label for the
 kickstart tree to delete.
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
The detailed information about a kickstartable tree given the tree name.
<p />




Parameters:<br />
<ul>
<li>

    string sessionKey
 </li>
<li>

    string treeLabel - Label of kickstartable tree to
 search.
 </li>
</ul>
<p />
Returns:
<code><ul><li>




	     struct - kickstartable tree
	<ul>
   	<li> int "id"</li>
   	<li> string "label"</li>
   	<li> string "abs_path"</li>
   	<li> int "channel_id"</li>
   

	     struct - kickstart install type
	<ul>
   	<li> int "id"</li>
   	<li> string "label"</li>
   	<li> string "name"</li>
 	</ul>
 
 	</ul>
  
 
</li></ul>
</code>
<p />
<hr />

<h3> <a name="list" href="#top">Method: list</a></h3>
Description:<br />
List the available kickstartable trees for the given channel.
<p />




Parameters:<br />
<ul>
<li>

    string sessionKey
 </li>
<li>

    string channelLabel - Label of channel to
 search.
 </li>
</ul>
<p />
Returns:
<code><ul><li>


array:
  <ul>
   <li>
 

	     struct - kickstartable tree
	<ul>
   	<li> int "id"</li>
   	<li> string "label"</li>
   	<li> string "base_path"</li>
   	<li> int "channel_id"</li>
 	</ul>
  </li></ul>
 
</li></ul>
</code>
<p />
<hr />

<h3> <a name="listInstallTypes" href="#top">Method: listInstallTypes</a></h3>
Description:<br />
List the available kickstartable install types (rhel2,3,4,5 and
 fedora9+).
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
 

	     struct - kickstart install type
	<ul>
   	<li> int "id"</li>
   	<li> string "label"</li>
   	<li> string "name"</li>
 	</ul>
  </li></ul>
 
</li></ul>
</code>
<p />
<hr />

<h3> <a name="rename" href="#top">Method: rename</a></h3>
Description:<br />
Rename a Kickstart Tree (Distribution) in Satellite.
<p />




Parameters:<br />
<ul>
<li>

        string sessionKey
 </li>
<li>

    string originalLabel - Label for the
 kickstart tree to rename.
 </li>
<li>

    string newLabel - The kickstart tree's new label.
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

<h3> <a name="update" href="#top">Method: update</a></h3>
Description:<br />
Edit a Kickstart Tree (Distribution) in Satellite.
<p />




Parameters:<br />
<ul>
<li>

        string sessionKey
 </li>
<li>

    string treeLabel - Label for the kickstart tree.
 </li>
<li>

    string basePath - Path to the base or
 root of the kickstart tree.
 </li>
<li>

    string channelLabel - Label of channel to
 associate with kickstart tree.
 </li>
<li>

    string installType - Label for
 KickstartInstallType (rhel_2.1, rhel_3, rhel_4, rhel_5, fedora_9).
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
