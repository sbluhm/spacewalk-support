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
kickstart.profile
</p>
<p>Provides methods to access and modify many aspects of
 a kickstart profile.</p>
<span class="small-text">( <a href="/rhn/apidoc/index.jsp">Return to API Overview</a> )</span>
<hr />

<div class="rounded-box">
<h2><a name="top">Available methods</a></h2>
<ul class="apidoc">

<li><a href="#addIpRange"/>addIpRange</a></li>
<li><a href="#addScript"/>addScript</a></li>
<li><a href="#addScript"/>addScript</a></li>
<li><a href="#addScript"/>addScript</a></li>
<li><a href="#compareActivationKeys"/>compareActivationKeys</a></li>
<li><a href="#compareAdvancedOptions"/>compareAdvancedOptions</a></li>
<li><a href="#comparePackages"/>comparePackages</a></li>
<li><a href="#downloadKickstart"/>downloadKickstart</a></li>
<li><a href="#downloadRenderedKickstart"/>downloadRenderedKickstart</a></li>
<li><a href="#getAdvancedOptions"/>getAdvancedOptions</a></li>
<li><a href="#getAvailableRepositories"/>getAvailableRepositories</a></li>
<li><a href="#getCfgPreservation"/>getCfgPreservation</a></li>
<li><a href="#getChildChannels"/>getChildChannels</a></li>
<li><a href="#getCustomOptions"/>getCustomOptions</a></li>
<li><a href="#getKickstartTree"/>getKickstartTree</a></li>
<li><a href="#getRepositories"/>getRepositories</a></li>
<li><a href="#getUpdateType"/>getUpdateType</a></li>
<li><a href="#getVariables"/>getVariables</a></li>
<li><a href="#getVirtualizationType"/>getVirtualizationType</a></li>
<li><a href="#listIpRanges"/>listIpRanges</a></li>
<li><a href="#listScripts"/>listScripts</a></li>
<li><a href="#orderScripts"/>orderScripts</a></li>
<li><a href="#removeIpRange"/>removeIpRange</a></li>
<li><a href="#removeScript"/>removeScript</a></li>
<li><a href="#setAdvancedOptions"/>setAdvancedOptions</a></li>
<li><a href="#setCfgPreservation"/>setCfgPreservation</a></li>
<li><a href="#setChildChannels"/>setChildChannels</a></li>
<li><a href="#setCustomOptions"/>setCustomOptions</a></li>
<li><a href="#setKickstartTree"/>setKickstartTree</a></li>
<li><a href="#setLogging"/>setLogging</a></li>
<li><a href="#setRepositories"/>setRepositories</a></li>
<li><a href="#setUpdateType"/>setUpdateType</a></li>
<li><a href="#setVariables"/>setVariables</a></li>
<li><a href="#setVirtualizationType"/>setVirtualizationType</a></li>
</ul>
</div>
<hr />

<h3> <a name="addIpRange" href="#top">Method: addIpRange</a></h3>
Description:<br />
Add an ip range to a kickstart profile.
<p />




Parameters:<br />
<ul>
<li>

        string sessionKey
 </li>
<li>

    string label - The label of the
 kickstart
 </li>
<li>

    string min - The ip address making up the
 minimum of the range (i.e. 192.168.0.1)
 </li>
<li>

    string max - The ip address making up the
 maximum of the range (i.e. 192.168.0.254)
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

<h3> <a name="addScript" href="#top">Method: addScript</a></h3>
Description:<br />
Add a pre/post script to a kickstart profile.
<p />




Parameters:<br />
<ul>
<li>

        string sessionKey
 </li>
<li>

    string ksLabel - The kickstart label to
 add the script to.
 </li>
<li>

    string name - The kickstart script name.
 </li>
<li>

    string contents - The full script to
 add.
 </li>
<li>

    string interpreter - The path to the
 interpreter to use (i.e. /bin/bash). An empty string will use the
 kickstart default interpreter.
 </li>
<li>

    string type - The type of script (either
 'pre' or 'post').
 </li>
<li>

    boolean chroot - Whether to run the script
 in the chrooted install location (recommended) or not.
 </li>
</ul>
<p />
Returns:
<code><ul><li>


int id - the id of the added script 
 
</li></ul>
</code>
<p />
<hr />

<h3> <a name="addScript" href="#top">Method: addScript</a></h3>
Description:<br />
Add a pre/post script to a kickstart profile.
<p />




Parameters:<br />
<ul>
<li>

        string sessionKey
 </li>
<li>

    string ksLabel - The kickstart label to
 add the script to.
 </li>
<li>

    string name - The kickstart script name.
 </li>
<li>

    string contents - The full script to
 add.
 </li>
<li>

    string interpreter - The path to the
 interpreter to use (i.e. /bin/bash). An empty string will use the
 kickstart default interpreter.
 </li>
<li>

    string type - The type of script (either
 'pre' or 'post').
 </li>
<li>

    boolean chroot - Whether to run the script
 in the chrooted install location (recommended) or not.
 </li>
<li>

    boolean template - Enable templating using cobbler.
 </li>
</ul>
<p />
Returns:
<code><ul><li>


int id - the id of the added script 
 
</li></ul>
</code>
<p />
<hr />

<h3> <a name="addScript" href="#top">Method: addScript</a></h3>
Description:<br />
Add a pre/post script to a kickstart profile.
<p />




Parameters:<br />
<ul>
<li>

        string sessionKey
 </li>
<li>

    string ksLabel - The kickstart label to
 add the script to.
 </li>
<li>

    string name - The kickstart script name.
 </li>
<li>

    string contents - The full script to
 add.
 </li>
<li>

    string interpreter - The path to the
 interpreter to use (i.e. /bin/bash). An empty string will use the
 kickstart default interpreter.
 </li>
<li>

    string type - The type of script (either
 'pre' or 'post').
 </li>
<li>

    boolean chroot - Whether to run the script
 in the chrooted install location (recommended) or not.
 </li>
<li>

    boolean template - Enable templating using cobbler.
 </li>
<li>

    boolean erroronfail - Whether to throw an
 error if the script fails or not
 </li>
</ul>
<p />
Returns:
<code><ul><li>


int id - the id of the added script 
 
</li></ul>
</code>
<p />
<hr />

<h3> <a name="compareActivationKeys" href="#top">Method: compareActivationKeys</a></h3>
Description:<br />
Returns a list for each kickstart profile; each list will contain
             activation keys not present on the other profile.
<p />




Parameters:<br />
<ul>
<li>

    string sessionKey
 </li>
<li>

    string kickstartLabel1
 </li>
<li>

    string kickstartLabel2
 </li>
</ul>
<p />
Returns:
<code><ul><li>


	     struct - Comparison Info
	<ul>
          <li> array "kickstartLabel1" - Actual label of the first kickstart
                 profile is the key into the struct </li>
          array:
  <ul>
   <li>
              

	     struct - activation key
	<ul>
     	<li> string "key"</li>
     	<li> string "description"</li>
     	<li> int "usage_limit"</li>
     	<li> string "base_channel_label"</li>
         <li>array "child_channel_labels"
        <ul>
            <li>string childChannelLabel</li>
        </ul>
    </li>
         <li>array "entitlements"
        <ul>
            <li>string entitlementLabel</li>
        </ul>
    </li>
         <li>array "server_group_ids"
        <ul>
            <li>string serverGroupId</li>
        </ul>
    </li>
         <li>array "package_names"
        <ul>
            <li>string packageName - (deprecated by packages)</li>
        </ul>
    </li>
         <li>array "packages"
        <ul>
            <li>
       	     struct - package
	<ul>
             <li> string "name" - packageName </li>
             <li> string "arch" - archLabel - optional </li>
       	</ul>
                </li>
        </ul>
    </li>
     	<li> boolean "universal_default"</li>
     	<li> boolean "disabled"</li>
   	</ul>
 
          </li></ul>
          <li> array "kickstartLabel2" - Actual label of the second kickstart
                 profile is the key into the struct </li>
          array:
  <ul>
   <li>
              

	     struct - activation key
	<ul>
     	<li> string "key"</li>
     	<li> string "description"</li>
     	<li> int "usage_limit"</li>
     	<li> string "base_channel_label"</li>
         <li>array "child_channel_labels"
        <ul>
            <li>string childChannelLabel</li>
        </ul>
    </li>
         <li>array "entitlements"
        <ul>
            <li>string entitlementLabel</li>
        </ul>
    </li>
         <li>array "server_group_ids"
        <ul>
            <li>string serverGroupId</li>
        </ul>
    </li>
         <li>array "package_names"
        <ul>
            <li>string packageName - (deprecated by packages)</li>
        </ul>
    </li>
         <li>array "packages"
        <ul>
            <li>
       	     struct - package
	<ul>
             <li> string "name" - packageName </li>
             <li> string "arch" - archLabel - optional </li>
       	</ul>
                </li>
        </ul>
    </li>
     	<li> boolean "universal_default"</li>
     	<li> boolean "disabled"</li>
   	</ul>
 
          </li></ul>
  	</ul>
 
</li></ul>
</code>
<p />
<hr />

<h3> <a name="compareAdvancedOptions" href="#top">Method: compareAdvancedOptions</a></h3>
Description:<br />
Returns a list for each kickstart profile; each list will contain the
             properties that differ between the profiles and their values for that
             specific profile .
<p />




Parameters:<br />
<ul>
<li>

    string sessionKey
 </li>
<li>

    string kickstartLabel1
 </li>
<li>

    string kickstartLabel2
 </li>
</ul>
<p />
Returns:
<code><ul><li>


	     struct - Comparison Info
	<ul>
          <li> array "kickstartLabel1" - Actual label of the first kickstart
                 profile is the key into the struct </li>
          array:
  <ul>
   <li>
              

	     struct - value
	<ul>
          	<li> string "name"</li>
          	<li> string "value"</li>
          	<li> boolean "enabled"</li>
      	</ul>
 
          </li></ul>
          <li> array "kickstartLabel2" - Actual label of the second kickstart
                 profile is the key into the struct </li>
          array:
  <ul>
   <li>
              

	     struct - value
	<ul>
          	<li> string "name"</li>
          	<li> string "value"</li>
          	<li> boolean "enabled"</li>
      	</ul>
 
          </li></ul>
  	</ul>
 
</li></ul>
</code>
<p />
<hr />

<h3> <a name="comparePackages" href="#top">Method: comparePackages</a></h3>
Description:<br />
Returns a list for each kickstart profile; each list will contain
             package names not present on the other profile.
<p />




Parameters:<br />
<ul>
<li>

    string sessionKey
 </li>
<li>

    string kickstartLabel1
 </li>
<li>

    string kickstartLabel2
 </li>
</ul>
<p />
Returns:
<code><ul><li>


	     struct - Comparison Info
	<ul>
          <li> array "kickstartLabel1" - Actual label of the first kickstart
                 profile is the key into the struct </li>
          array:
<ul>
    <li>string - package name</li>
</ul>
          <li> array "kickstartLabel2" - Actual label of the second kickstart
                 profile is the key into the struct </li>
          array:
<ul>
    <li>string - package name</li>
</ul>
  	</ul>
 
</li></ul>
</code>
<p />
<hr />

<h3> <a name="downloadKickstart" href="#top">Method: downloadKickstart</a></h3>
Description:<br />
Download the full contents of a kickstart file.
<p />




Parameters:<br />
<ul>
<li>

        string sessionKey
 </li>
<li>

    string ksLabel - The label of the
 kickstart to download.
 </li>
<li>

    string host - The host to use when
 referring to the satellite itself (Usually this should be the FQDN of the
 satellite, but could be the ip address or shortname of it as well.
 </li>
</ul>
<p />
Returns:
<code><ul><li>


string - The contents of the kickstart file. Note: if
 an activation key is not associated with the kickstart file, registration
 will not occur in the satellite generated %post section. If one is
 associated, it will be used for registration. 
 
</li></ul>
</code>
<p />
<hr />

<h3> <a name="downloadRenderedKickstart" href="#top">Method: downloadRenderedKickstart</a></h3>
Description:<br />
Downloads the Cobbler-rendered Kickstart file.
<p />




Parameters:<br />
<ul>
<li>

        string sessionKey
 </li>
<li>

    string ksLabel - The label of the
 kickstart to download.
 </li>
</ul>
<p />
Returns:
<code><ul><li>


string - The contents of the kickstart file. 
 
</li></ul>
</code>
<p />
<hr />

<h3> <a name="getAdvancedOptions" href="#top">Method: getAdvancedOptions</a></h3>
Description:<br />
Get advanced options for a kickstart profile.
<p />




Parameters:<br />
<ul>
<li>

        string sessionKey
 </li>
<li>

    string ksLabel - Label of kickstart
 profile to be changed.
 </li>
</ul>
<p />
Returns:
<code><ul><li>


array:
  <ul>
   <li>
 

	     struct - option
	<ul>
          	<li> string "name"</li>
          	<li> string "arguments"</li>
      	</ul>
 
 </li></ul>
 
</li></ul>
</code>
<p />
<hr />

<h3> <a name="getAvailableRepositories" href="#top">Method: getAvailableRepositories</a></h3>
Description:<br />
Lists available OS repositories to associate with the provided
 kickstart profile.
<p />




Parameters:<br />
<ul>
<li>

    string sessionKey
 </li>
<li>

    string ksLabel
 </li>
</ul>
<p />
Returns:
<code><ul><li>


array:
<ul>
    <li>string - repositoryLabel</li>
</ul>
 
</li></ul>
</code>
<p />
<hr />

<h3> <a name="getCfgPreservation" href="#top">Method: getCfgPreservation</a></h3>
Description:<br />
Get ks.cfg preservation option for a kickstart profile.
<p />




Parameters:<br />
<ul>
<li>

        string sessionKey
 </li>
<li>

    string kslabel - Label of kickstart
 profile to be changed.
 </li>
</ul>
<p />
Returns:
<code><ul><li>


boolean - The value of the option. True means that
     ks.cfg will be copied to /root, false means that it will not. 
 
</li></ul>
</code>
<p />
<hr />

<h3> <a name="getChildChannels" href="#top">Method: getChildChannels</a></h3>
Description:<br />
Get the child channels for a kickstart profile.
<p />




Parameters:<br />
<ul>
<li>

        string sessionKey
 </li>
<li>

    string kslabel - Label of kickstart
 profile.
 </li>
</ul>
<p />
Returns:
<code><ul><li>


array:
<ul>
    <li>string - channelLabel</li>
</ul>
 
</li></ul>
</code>
<p />
<hr />

<h3> <a name="getCustomOptions" href="#top">Method: getCustomOptions</a></h3>
Description:<br />
Get custom options for a kickstart profile.
<p />




Parameters:<br />
<ul>
<li>

        string sessionKey
 </li>
<li>

    string ksLabel
 </li>
</ul>
<p />
Returns:
<code><ul><li>


array:
  <ul>
   <li>
 

	     struct - option
	<ul>
          	<li> int "id"</li>
          	<li> string "arguments"</li>
      	</ul>
 
 </li></ul>
 
</li></ul>
</code>
<p />
<hr />

<h3> <a name="getKickstartTree" href="#top">Method: getKickstartTree</a></h3>
Description:<br />
Get the kickstart tree for a kickstart profile.
<p />




Parameters:<br />
<ul>
<li>

        string sessionKey
 </li>
<li>

    string kslabel - Label of kickstart
 profile to be changed.
 </li>
</ul>
<p />
Returns:
<code><ul><li>


    string kstreeLabel - Label of the kickstart tree.
 
</li></ul>
</code>
<p />
<hr />

<h3> <a name="getRepositories" href="#top">Method: getRepositories</a></h3>
Description:<br />
Lists all OS repositories associated with provided kickstart profile.
<p />




Parameters:<br />
<ul>
<li>

    string sessionKey
 </li>
<li>

    string ksLabel
 </li>
</ul>
<p />
Returns:
<code><ul><li>


array:
<ul>
    <li>string - repositoryLabel</li>
</ul>
 
</li></ul>
</code>
<p />
<hr />

<h3> <a name="getUpdateType" href="#top">Method: getUpdateType</a></h3>
Description:<br />
Get the update type for a kickstart profile.
<p />




Parameters:<br />
<ul>
<li>

        string sessionKey
 </li>
<li>

    string kslabel - Label of kickstart
 profile.
 </li>
</ul>
<p />
Returns:
<code><ul><li>


    string update_type - Update type for this Kickstart Profile.
 
</li></ul>
</code>
<p />
<hr />

<h3> <a name="getVariables" href="#top">Method: getVariables</a></h3>
Description:<br />
Returns a list of variables
                      associated with the specified kickstart profile
<p />




Parameters:<br />
<ul>
<li>

    string sessionKey
 </li>
<li>

    string ksLabel
 </li>
</ul>
<p />
Returns:
<code><ul><li>


	     struct - kickstart variable
	<ul>
         	<li> string "key"</li>
         	<li> string or int "value"</li>
     	</ul>
 
</li></ul>
</code>
<p />
<hr />

<h3> <a name="getVirtualizationType" href="#top">Method: getVirtualizationType</a></h3>
Description:<br />
For given kickstart profile label returns label of
 virtualization type it's using
<p />




Parameters:<br />
<ul>
<li>

    string sessionKey
 </li>
<li>

    string ksLabel
 </li>
</ul>
<p />
Returns:
<code><ul><li>


    string virtLabel - Label of virtualization type.
 
</li></ul>
</code>
<p />
<hr />

<h3> <a name="listIpRanges" href="#top">Method: listIpRanges</a></h3>
Description:<br />
List all ip ranges for a kickstart profile.
<p />




Parameters:<br />
<ul>
<li>

        string sessionKey
 </li>
<li>

    string label - The label of the
 kickstart
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

<h3> <a name="listScripts" href="#top">Method: listScripts</a></h3>
Description:<br />
List the pre and post scripts for a kickstart profile
 in the order they will run during the kickstart.
<p />




Parameters:<br />
<ul>
<li>

        string sessionKey
 </li>
<li>

    string ksLabel - The label of the
 kickstart
 </li>
</ul>
<p />
Returns:
<code><ul><li>


array:
  <ul>
   <li>
 

	     struct - kickstart script
	<ul>
          	<li> int "id"</li>
          	<li> string "name"</li>
          	<li> string "contents"</li>
              <li> string "script_type" - Which type of script ('pre' or 'post'). </li>
              <li> string "interpreter" - The scripting language interpreter to use
                      for this script.  An empty string indicates the default kickstart
                      shell. </li>
              <li> boolean "chroot" - True if the script will be executed within the
                  chroot environment. </li>
              <li> boolean "erroronfail" - True if the script will throw an error if
                  it fails. </li>
              <li> boolean "template" - True if templating using cobbler is enabled </li>
              <li> boolean "beforeRegistration" - True if script will run before the
                  server registers and performs server actions. </li>
     	</ul>
  </li></ul>
 
</li></ul>
</code>
<p />
<hr />

<h3> <a name="orderScripts" href="#top">Method: orderScripts</a></h3>
Description:<br />
Change the order that kickstart scripts will run for
 this kickstart profile. Scripts will run in the order they appear
 in the array. There are three arrays, one for all pre scripts, one
 for the post scripts that run before registration and server
 actions happen, and one for post scripts that run after registration
 and server actions. All scripts must be included in one of these
 lists, as appropriate.
<p />




Parameters:<br />
<ul>
<li>

        string sessionKey
 </li>
<li>

    string ksLabel - The label of the
 kickstart
 </li>
<li>

array:
<ul>
    <li>int - IDs of the ordered pre scripts</li>
</ul>
 </li>
<li>

array:
<ul>
    <li>int - IDs of the ordered post scripts that will run
              before registration</li>
</ul>
 </li>
<li>

array:
<ul>
    <li>int - IDs of the ordered post scripts that will run
              after registration</li>
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

<h3> <a name="removeIpRange" href="#top">Method: removeIpRange</a></h3>
Description:<br />
Remove an ip range from a kickstart profile.
<p />




Parameters:<br />
<ul>
<li>

        string sessionKey
 </li>
<li>

    string ksLabel - The kickstart label of
 the ip range you want to remove
 </li>
<li>

    string ip_address - An Ip Address that
 falls within the range that you are wanting to remove. The min or max of
 the range will work.
 </li>
</ul>
<p />
Returns:
<code><ul><li>


int - 1 on successful removal, 0 if range wasn't found
 for the specified kickstart, exception otherwise. 
 
</li></ul>
</code>
<p />
<hr />

<h3> <a name="removeScript" href="#top">Method: removeScript</a></h3>
Description:<br />
Remove a script from a kickstart profile.
<p />




Parameters:<br />
<ul>
<li>

        string sessionKey
 </li>
<li>

    string ksLabel - The kickstart from which
 to remove the script from.
 </li>
<li>

    int scriptId - The id of the script to
 remove.
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

<h3> <a name="setAdvancedOptions" href="#top">Method: setAdvancedOptions</a></h3>
Description:<br />
Set advanced options for a kickstart profile.
 If 'md5_crypt_rootpw' is set to 'True', 'root_pw' is taken as plaintext and
 will md5 encrypted on server side, otherwise a hash encoded password
 (according to the auth option) is expected
<p />




Parameters:<br />
<ul>
<li>

        string sessionKey
 </li>
<li>

    string ksLabel
 </li>
<li>

array:
  <ul>
   <li>
      	     struct - advanced options
	<ul>
              <li> string "name" - Name of the advanced option.
              Valid Option names: autostep, interactive, install, upgrade, text,
              network, cdrom, harddrive, nfs, url, lang, langsupport keyboard,
              mouse, device, deviceprobe, zerombr, clearpart, bootloader,
              timezone, auth, rootpw, selinux, reboot, firewall, xconfig, skipx,
              key, ignoredisk, autopart, cmdline, firstboot, graphical, iscsi,
              iscsiname, logging, monitor, multipath, poweroff, halt, services,
              shutdown, user, vnc, zfcp, driverdisk, md5_crypt_rootpw </li>
              <li> string "arguments" - Arguments of the option </li>
      	</ul>
   </li></ul>
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

<h3> <a name="setCfgPreservation" href="#top">Method: setCfgPreservation</a></h3>
Description:<br />
Set ks.cfg preservation option for a kickstart profile.
<p />




Parameters:<br />
<ul>
<li>

        string sessionKey
 </li>
<li>

    string kslabel - Label of kickstart
 profile to be changed.
 </li>
<li>

    boolean preserve - whether or not
      ks.cfg and all %include fragments will be copied to /root.
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

<h3> <a name="setChildChannels" href="#top">Method: setChildChannels</a></h3>
Description:<br />
Set the child channels for a kickstart profile.
<p />




Parameters:<br />
<ul>
<li>

        string sessionKey
 </li>
<li>

    string kslabel - Label of kickstart
 profile to be changed.
 </li>
<li>

    string[] channelLabels - List of labels of child channels
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

<h3> <a name="setCustomOptions" href="#top">Method: setCustomOptions</a></h3>
Description:<br />
Set custom options for a kickstart profile.
<p />




Parameters:<br />
<ul>
<li>

        string sessionKey
 </li>
<li>

    string ksLabel
 </li>
<li>

    string[] options
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

<h3> <a name="setKickstartTree" href="#top">Method: setKickstartTree</a></h3>
Description:<br />
Set the kickstart tree for a kickstart profile.
<p />




Parameters:<br />
<ul>
<li>

        string sessionKey
 </li>
<li>

    string kslabel - Label of kickstart
 profile to be changed.
 </li>
<li>

    string kstreeLabel - Label of new
 kickstart tree.
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

<h3> <a name="setLogging" href="#top">Method: setLogging</a></h3>
Description:<br />
Set logging options for a kickstart profile.
<p />




Parameters:<br />
<ul>
<li>

        string sessionKey
 </li>
<li>

    string kslabel - Label of kickstart
 profile to be changed.
 </li>
<li>

    boolean pre - whether or not to log
      the pre section of a kickstart to /root/ks-pre.log
 </li>
<li>

    boolean post - whether or not to log
      the post section of a kickstart to /root/ks-post.log
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

<h3> <a name="setRepositories" href="#top">Method: setRepositories</a></h3>
Description:<br />
Associates OS repository to a kickstart profile.
<p />




Parameters:<br />
<ul>
<li>

    string sessionKey
 </li>
<li>

    string ksLabel
 </li>
<li>

array:
<ul>
    <li>string - repositoryLabel</li>
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

<h3> <a name="setUpdateType" href="#top">Method: setUpdateType</a></h3>
Description:<br />
Set the update typefor a kickstart profile.
<p />




Parameters:<br />
<ul>
<li>

        string sessionKey
 </li>
<li>

    string kslabel - Label of kickstart
 profile to be changed.
 </li>
<li>

    string updateType - The new update type
 to set. Possible values are 'red_hat', 'all', and 'none'.
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

<h3> <a name="setVariables" href="#top">Method: setVariables</a></h3>
Description:<br />
Associates list of kickstart variables
                              with the specified kickstart profile
<p />




Parameters:<br />
<ul>
<li>

    string sessionKey
 </li>
<li>

    string ksLabel
 </li>
<li>

	     struct - kickstart variable
	<ul>
         	<li> string "key"</li>
         	<li> string or int "value"</li>
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

<h3> <a name="setVirtualizationType" href="#top">Method: setVirtualizationType</a></h3>
Description:<br />
For given kickstart profile label sets its virtualization type.
<p />




Parameters:<br />
<ul>
<li>

    string sessionKey
 </li>
<li>

    string ksLabel
 </li>
<li>

    string typeLabel - One of the following: 'none',
 'qemu', 'para_host', 'xenpv', 'xenfv'
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
