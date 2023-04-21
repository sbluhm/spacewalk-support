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
kickstart
</p>
<p>Provides methods to create kickstart files</p>
<span class="small-text">( <a href="/rhn/apidoc/index.jsp">Return to API Overview</a> )</span>
<hr />

<div class="rounded-box">
<h2><a name="top">Available methods</a></h2>
<ul class="apidoc">

<li><a href="#cloneProfile"/>cloneProfile</a></li>
<li><a href="#createProfile"/>createProfile</a></li>
<li><a href="#createProfile"/>createProfile</a></li>
<li><a href="#createProfileWithCustomUrl"/>createProfileWithCustomUrl</a></li>
<li><a href="#createProfileWithCustomUrl"/>createProfileWithCustomUrl</a></li>
<li><a href="#deleteProfile"/>deleteProfile</a></li>
<li><a href="#disableProfile"/>disableProfile</a></li>
<li><a href="#findKickstartForIp"/>findKickstartForIp</a></li>
<li><a href="#importFile"/>importFile</a></li>
<li><a href="#importFile"/>importFile</a></li>
<li><a href="#importFile"/>importFile</a></li>
<li><a href="#importRawFile"/>importRawFile</a></li>
<li><a href="#importRawFile"/>importRawFile</a></li>
<li><a href="#isProfileDisabled"/>isProfileDisabled</a></li>
<li><a href="#listAllIpRanges"/>listAllIpRanges</a></li>
<li><a href="#listKickstartableChannels"/>listKickstartableChannels</a></li>
<li><a href="#listKickstartableTreeChannels"/>listKickstartableTreeChannels</a></li>
<li><a href="#listKickstartableTrees"/>listKickstartableTrees</a></li>
<li><a href="#listKickstarts"/>listKickstarts</a></li>
<li><a href="#renameProfile"/>renameProfile</a></li>
</ul>
</div>
<hr />

<h3> <a name="cloneProfile" href="#top">Method: cloneProfile</a></h3>
Description:<br />
Clone a Kickstart Profile
<p />




Parameters:<br />
<ul>
<li>

        string sessionKey
 </li>
<li>

    string ksLabelToClone - Label of the
 kickstart profile to clone
 </li>
<li>

    string newKsLabel - label of the cloned profile
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

<h3> <a name="createProfile" href="#top">Method: createProfile</a></h3>
Description:<br />
Create a kickstart profile.
<p />




Parameters:<br />
<ul>
<li>

        string sessionKey
 </li>
<li>

    string profileLabel - Label for the new
 kickstart profile.
 </li>
<li>

    string virtualizationType - none, para_host,
 qemu, xenfv or xenpv.
 </li>
<li>

    string kickstartableTreeLabel - Label of a
 kickstartable tree to associate the new profile with.
 </li>
<li>

    string kickstartHost - Kickstart hostname
 (of a satellite or proxy) used to construct the default download URL for
 the new kickstart profile.
 </li>
<li>

    string rootPassword - Root password.
 </li>
<li>

    string updateType - Should the profile update
 itself to use the newest tree available? Possible values are: none (default),
 red_hat (only use Kickstart Trees synced from Red Hat), or all (includes
 custom Kickstart Trees).
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

<h3> <a name="createProfile" href="#top">Method: createProfile</a></h3>
Description:<br />
Create a kickstart profile.
<p />




Parameters:<br />
<ul>
<li>

        string sessionKey
 </li>
<li>

    string profileLabel - Label for the new
 kickstart profile.
 </li>
<li>

    string virtualizationType - none, para_host,
 qemu, xenfv or xenpv.
 </li>
<li>

    string kickstartableTreeLabel - Label of a
 kickstartable tree to associate the new profile with.
 </li>
<li>

    string kickstartHost - Kickstart hostname
 (of a satellite or proxy) used to construct the default download URL for
 the new kickstart profile.
 </li>
<li>

    string rootPassword - Root password.
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

<h3> <a name="createProfileWithCustomUrl" href="#top">Method: createProfileWithCustomUrl</a></h3>
Description:<br />
Create a kickstart profile.
<p />




Parameters:<br />
<ul>
<li>

        string sessionKey
 </li>
<li>

    string profileLabel - Label for the new
 kickstart profile.
 </li>
<li>

    string virtualizationType - none, para_host,
 qemu, xenfv or xenpv.
 </li>
<li>

    string kickstartableTreeLabel - Label of a
 kickstartable tree to associate the new profile with.
 </li>
<li>

    boolean downloadUrl - Download URL, or
 'default' to use the kickstart tree's default URL.
 </li>
<li>

    string rootPassword - Root password.
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

<h3> <a name="createProfileWithCustomUrl" href="#top">Method: createProfileWithCustomUrl</a></h3>
Description:<br />
Create a kickstart profile.
<p />




Parameters:<br />
<ul>
<li>

        string sessionKey
 </li>
<li>

    string profileLabel - Label for the new
 kickstart profile.
 </li>
<li>

    string virtualizationType - none, para_host,
 qemu, xenfv or xenpv.
 </li>
<li>

    string kickstartableTreeLabel - Label of a
 kickstartable tree to associate the new profile with.
 </li>
<li>

    boolean downloadUrl - Download URL, or
 'default' to use the kickstart tree's default URL.
 </li>
<li>

    string rootPassword - Root password.
 </li>
<li>

    string updateType - Should the profile update
 itself to use the newest tree available? Possible values are: none (default),
 red_hat (only use Kickstart Trees synced from Red Hat), or all (includes
 custom Kickstart Trees).
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

<h3> <a name="deleteProfile" href="#top">Method: deleteProfile</a></h3>
Description:<br />
Delete a kickstart profile
<p />




Parameters:<br />
<ul>
<li>

        string sessionKey
 </li>
<li>

    string ksLabel - The label of
 the kickstart profile you want to remove
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

<h3> <a name="disableProfile" href="#top">Method: disableProfile</a></h3>
Description:<br />
Enable/Disable a Kickstart Profile
<p />




Parameters:<br />
<ul>
<li>

        string sessionKey
 </li>
<li>

    string profileLabel - Label for the
 kickstart tree you want to en/disable
 </li>
<li>

    string disabled - true to disable the profile
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

<h3> <a name="findKickstartForIp" href="#top">Method: findKickstartForIp</a></h3>
Description:<br />
Find an associated kickstart for a given ip address.
<p />




Parameters:<br />
<ul>
<li>

        string sessionKey
 </li>
<li>

    string ipAddress - The ip address to
 search for (i.e. 192.168.0.1)
 </li>
</ul>
<p />
Returns:
<code><ul><li>


string - label of the kickstart. Empty string ("") if
 not found. 
 
</li></ul>
</code>
<p />
<hr />

<h3> <a name="importFile" href="#top">Method: importFile</a></h3>
Description:<br />
Import a kickstart profile.
<p />




Parameters:<br />
<ul>
<li>

        string sessionKey
 </li>
<li>

    string profileLabel - Label for the new
 kickstart profile.
 </li>
<li>

    string virtualizationType - none, para_host,
 qemu, xenfv or xenpv.
 </li>
<li>

    string kickstartableTreeLabel - Label of a
 kickstartable tree to associate the new profile with.
 </li>
<li>

    string kickstartFileContents - Contents of
 the kickstart file to import.
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

<h3> <a name="importFile" href="#top">Method: importFile</a></h3>
Description:<br />
Import a kickstart profile.
<p />




Parameters:<br />
<ul>
<li>

        string sessionKey
 </li>
<li>

    string profileLabel - Label for the new
 kickstart profile.
 </li>
<li>

    string virtualizationType - none, para_host,
 qemu, xenfv or xenpv.
 </li>
<li>

    string kickstartableTreeLabel - Label of a
 kickstartable tree to associate the new profile with.
 </li>
<li>

    string kickstartHost - Kickstart hostname
 (of a satellite or proxy) used to construct the default download URL for
 the new kickstart profile. Using this option signifies that this default
 URL will be used instead of any url/nfs/cdrom/harddrive commands in the
 kickstart file itself.
 </li>
<li>

    string kickstartFileContents - Contents of
 the kickstart file to import.
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

<h3> <a name="importFile" href="#top">Method: importFile</a></h3>
Description:<br />
Import a kickstart profile.
<p />




Parameters:<br />
<ul>
<li>

        string sessionKey
 </li>
<li>

    string profileLabel - Label for the new
 kickstart profile.
 </li>
<li>

    string virtualizationType - none, para_host,
 qemu, xenfv or xenpv.
 </li>
<li>

    string kickstartableTreeLabel - Label of a
 kickstartable tree to associate the new profile with.
 </li>
<li>

    string kickstartHost - Kickstart hostname
 (of a satellite or proxy) used to construct the default download URL for
 the new kickstart profile. Using this option signifies that this default
 URL will be used instead of any url/nfs/cdrom/harddrive commands in the
 kickstart file itself.
 </li>
<li>

    string kickstartFileContents - Contents of
 the kickstart file to import.
 </li>
<li>

    string updateType - Should the profile update
 itself to use the newest tree available? Possible values are: none (default),
 red_hat (only use Kickstart Trees synced from Red Hat), or all (includes
 custom Kickstart Trees).
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

<h3> <a name="importRawFile" href="#top">Method: importRawFile</a></h3>
Description:<br />
Import a raw kickstart file into satellite.
<p />




Parameters:<br />
<ul>
<li>

        string sessionKey
 </li>
<li>

    string profileLabel - Label for the new
 kickstart profile.
 </li>
<li>

    string virtualizationType - none, para_host,
 qemu, xenfv or xenpv.
 </li>
<li>

    string kickstartableTreeLabel - Label of a
 kickstartable tree to associate the new profile with.
 </li>
<li>

    string kickstartFileContents - Contents of
 the kickstart file to import.
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

<h3> <a name="importRawFile" href="#top">Method: importRawFile</a></h3>
Description:<br />
Import a raw kickstart file into satellite.
<p />




Parameters:<br />
<ul>
<li>

        string sessionKey
 </li>
<li>

    string profileLabel - Label for the new
 kickstart profile.
 </li>
<li>

    string virtualizationType - none, para_host,
 qemu, xenfv or xenpv.
 </li>
<li>

    string kickstartableTreeLabel - Label of a
 kickstartable tree to associate the new profile with.
 </li>
<li>

    string kickstartFileContents - Contents of
 the kickstart file to import.
 </li>
<li>

    string updateType - Should the profile update
 itself to use the newest tree available? Possible values are: none (default),
 red_hat (only use Kickstart Trees synced from Red Hat), or all (includes
 custom Kickstart Trees).
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

<h3> <a name="isProfileDisabled" href="#top">Method: isProfileDisabled</a></h3>
Description:<br />
Returns whether a kickstart profile is disabled
<p />




Parameters:<br />
<ul>
<li>

        string sessionKey
 </li>
<li>

    string profileLabel - kickstart profile label
 </li>
</ul>
<p />
Returns:
<code><ul><li>


true if profile is disabled 
 
</li></ul>
</code>
<p />
<hr />

<h3> <a name="listAllIpRanges" href="#top">Method: listAllIpRanges</a></h3>
Description:<br />
List all Ip Ranges and their associated kickstarts available
 in the user's org.
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
 

	     struct - Kickstart Ip Range
	<ul>
         <li> string "ksLabel" - The kickstart label associated with the ip range </li>
         <li> string "max" - The max ip of the range </li>
         <li> string "min" - The min ip of the range </li>
   	</ul>
  </li></ul>
 
</li></ul>
</code>
<p />
<hr />

<h3> <a name="listKickstartableChannels" href="#top">Method: listKickstartableChannels</a></h3>
Description:<br />
List kickstartable channels for the logged in user.
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
 

	     struct - channel
	<ul>
      	<li> int "id"</li>
      	<li> string "name"</li>
      	<li> string "label"</li>
      	<li> string "arch_name"</li>
      	<li> string "arch_label"</li>
      	<li> string "summary"</li>
      	<li> string "description"</li>
      	<li> string "checksum_label"</li>
      	<li> dateTime.iso8601 "last_modified"</li>
      	<li> string "maintainer_name"</li>
      	<li> string "maintainer_email"</li>
      	<li> string "maintainer_phone"</li>
      	<li> string "support_policy"</li>
      	<li> string "gpg_key_url"</li>
      	<li> string "gpg_key_id"</li>
      	<li> string "gpg_key_fp"</li>
          <li> dateTime.iso8601 "yumrepo_last_sync" - (optional) </li>
      	<li> string "end_of_life"</li>
      	<li> string "parent_channel_label"</li>
      	<li> string "clone_original"</li>
      array:
  <ul>
   <li>
          	     struct - contentSources
	<ul>
              	<li> int "id"</li>
              	<li> string "label"</li>
              	<li> string "sourceUrl"</li>
              	<li> string "type"</li>
          	</ul>
      </li></ul>
  	</ul>
  </li></ul>
 
</li></ul>
</code>
<p />
<hr />

<h3> <a name="listKickstartableTreeChannels" href="#top">Method: listKickstartableTreeChannels</a></h3>
Description:<br />
List kickstartable tree channels for the logged in user.
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
 

	     struct - channel
	<ul>
      	<li> int "id"</li>
      	<li> string "name"</li>
      	<li> string "label"</li>
      	<li> string "arch_name"</li>
      	<li> string "arch_label"</li>
      	<li> string "summary"</li>
      	<li> string "description"</li>
      	<li> string "checksum_label"</li>
      	<li> dateTime.iso8601 "last_modified"</li>
      	<li> string "maintainer_name"</li>
      	<li> string "maintainer_email"</li>
      	<li> string "maintainer_phone"</li>
      	<li> string "support_policy"</li>
      	<li> string "gpg_key_url"</li>
      	<li> string "gpg_key_id"</li>
      	<li> string "gpg_key_fp"</li>
          <li> dateTime.iso8601 "yumrepo_last_sync" - (optional) </li>
      	<li> string "end_of_life"</li>
      	<li> string "parent_channel_label"</li>
      	<li> string "clone_original"</li>
      array:
  <ul>
   <li>
          	     struct - contentSources
	<ul>
              	<li> int "id"</li>
              	<li> string "label"</li>
              	<li> string "sourceUrl"</li>
              	<li> string "type"</li>
          	</ul>
      </li></ul>
  	</ul>
  </li></ul>
 
</li></ul>
</code>
<p />
<hr />

<h3 class="deprecated"><a name="listKickstartableTrees" href="#top">Method: listKickstartableTrees</a></h3>
Description:<br />
List the available kickstartable trees for the given channel.
<p />


Deprecated - being replaced by kickstart.tree.list(string sessionKey,
 string channelLabel) <p />


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

<h3> <a name="listKickstarts" href="#top">Method: listKickstarts</a></h3>
Description:<br />
Provides a list of kickstart profiles visible to the user's
 org
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
 

	     struct - kickstart
	<ul>
          	<li> string "label"</li>
          	<li> string "tree_label"</li>
          	<li> string "name"</li>
          	<li> boolean "advanced_mode"</li>
          	<li> boolean "org_default"</li>
          	<li> boolean "active"</li>
          	<li> string "update_type"</li>
   	</ul>
  </li></ul>
 
</li></ul>
</code>
<p />
<hr />

<h3> <a name="renameProfile" href="#top">Method: renameProfile</a></h3>
Description:<br />
Rename a Kickstart Profile in Satellite
<p />




Parameters:<br />
<ul>
<li>

        string sessionKey
 </li>
<li>

    string originalLabel - Label for the
 kickstart profile you want to rename
 </li>
<li>

    string newLabel - new label to change to
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
