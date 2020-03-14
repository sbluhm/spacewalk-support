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
kickstart.profile.system
</p>
<p>Provides methods to set various properties of a kickstart profile.</p>
<span class="small-text">( <a href="/rhn/apidoc/index.jsp">Return to API Overview</a> )</span>
<hr />

<div class="rounded-box">
<h2><a name="top">Available methods</a></h2>
<ul class="apidoc">

<li><a href="#addFilePreservations"/>addFilePreservations</a></li>
<li><a href="#addKeys"/>addKeys</a></li>
<li><a href="#checkConfigManagement"/>checkConfigManagement</a></li>
<li><a href="#checkRemoteCommands"/>checkRemoteCommands</a></li>
<li><a href="#disableConfigManagement"/>disableConfigManagement</a></li>
<li><a href="#disableRemoteCommands"/>disableRemoteCommands</a></li>
<li><a href="#enableConfigManagement"/>enableConfigManagement</a></li>
<li><a href="#enableRemoteCommands"/>enableRemoteCommands</a></li>
<li><a href="#getLocale"/>getLocale</a></li>
<li><a href="#getPartitioningScheme"/>getPartitioningScheme</a></li>
<li><a href="#getRegistrationType"/>getRegistrationType</a></li>
<li><a href="#getSELinux"/>getSELinux</a></li>
<li><a href="#listFilePreservations"/>listFilePreservations</a></li>
<li><a href="#listKeys"/>listKeys</a></li>
<li><a href="#removeFilePreservations"/>removeFilePreservations</a></li>
<li><a href="#removeKeys"/>removeKeys</a></li>
<li><a href="#setLocale"/>setLocale</a></li>
<li><a href="#setPartitioningScheme"/>setPartitioningScheme</a></li>
<li><a href="#setRegistrationType"/>setRegistrationType</a></li>
<li><a href="#setSELinux"/>setSELinux</a></li>
</ul>
</div>
<hr />

<h3> <a name="addFilePreservations" href="#top">Method: addFilePreservations</a></h3>
Description:<br />
Adds the given list of file preservations to the specified kickstart
 profile.
<p />




Parameters:<br />
<ul>
<li>

    string sessionKey
 </li>
<li>

    string kickstartLabel
 </li>
<li>

array:
<ul>
    <li>string - filePreservations</li>
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

<h3> <a name="addKeys" href="#top">Method: addKeys</a></h3>
Description:<br />
Adds the given list of keys to the specified kickstart profile.
<p />




Parameters:<br />
<ul>
<li>

    string sessionKey
 </li>
<li>

    string kickstartLabel
 </li>
<li>

array:
<ul>
    <li>string - keyDescription</li>
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

<h3> <a name="checkConfigManagement" href="#top">Method: checkConfigManagement</a></h3>
Description:<br />
Check the configuration management status for a kickstart profile.
<p />




Parameters:<br />
<ul>
<li>

        string sessionKey
 </li>
<li>

    string ksLabel - the kickstart profile label
 </li>
</ul>
<p />
Returns:
<code><ul><li>


    boolean enabled - true if configuration
 management is enabled; otherwise, false
 
</li></ul>
</code>
<p />
<hr />

<h3> <a name="checkRemoteCommands" href="#top">Method: checkRemoteCommands</a></h3>
Description:<br />
Check the remote commands status flag for a kickstart profile.
<p />




Parameters:<br />
<ul>
<li>

        string sessionKey
 </li>
<li>

    string ksLabel - the kickstart profile label
 </li>
</ul>
<p />
Returns:
<code><ul><li>


    boolean enabled - true if remote
 commands support is enabled; otherwise, false
 
</li></ul>
</code>
<p />
<hr />

<h3> <a name="disableConfigManagement" href="#top">Method: disableConfigManagement</a></h3>
Description:<br />
Disables the configuration management flag in a kickstart profile
 so that a system created using this profile will be NOT be configuration capable.
<p />




Parameters:<br />
<ul>
<li>

        string sessionKey
 </li>
<li>

    string ksLabel - the kickstart profile label
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

<h3> <a name="disableRemoteCommands" href="#top">Method: disableRemoteCommands</a></h3>
Description:<br />
Disables the remote command flag in a kickstart profile
 so that a system created using this profile
 will be capable of running remote commands
<p />




Parameters:<br />
<ul>
<li>

        string sessionKey
 </li>
<li>

    string ksLabel - the kickstart profile label
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

<h3> <a name="enableConfigManagement" href="#top">Method: enableConfigManagement</a></h3>
Description:<br />
Enables the configuration management flag in a kickstart profile
 so that a system created using this profile will be configuration capable.
<p />




Parameters:<br />
<ul>
<li>

        string sessionKey
 </li>
<li>

    string ksLabel - the kickstart profile label
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

<h3> <a name="enableRemoteCommands" href="#top">Method: enableRemoteCommands</a></h3>
Description:<br />
Enables the remote command flag in a kickstart profile
 so that a system created using this profile
  will be capable of running remote commands
<p />




Parameters:<br />
<ul>
<li>

        string sessionKey
 </li>
<li>

    string ksLabel - the kickstart profile label
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

<h3> <a name="getLocale" href="#top">Method: getLocale</a></h3>
Description:<br />
Retrieves the locale for a kickstart profile.
<p />




Parameters:<br />
<ul>
<li>

    string sessionKey
 </li>
<li>

    string ksLabel - the kickstart profile label
 </li>
</ul>
<p />
Returns:
<code><ul><li>


	     struct - locale info
	<ul>
              	<li> string "locale"</li>
              	<li> boolean "useUtc"</li>
                  	<ul>
                      	<li>true - the hardware clock uses UTC</li>
                      	<li>false - the hardware clock does not use UTC</li>
                  	</ul>
          	</ul>
 
</li></ul>
</code>
<p />
<hr />

<h3> <a name="getPartitioningScheme" href="#top">Method: getPartitioningScheme</a></h3>
Description:<br />
Get the partitioning scheme for a kickstart profile.
<p />




Parameters:<br />
<ul>
<li>

        string sessionKey
 </li>
<li>

    string ksLabel - The label of a kickstart
 profile.
 </li>
</ul>
<p />
Returns:
<code><ul><li>


string[] - A list of partitioning commands used to
 setup the partitions, logical volumes and volume groups." 
 
</li></ul>
</code>
<p />
<hr />

<h3> <a name="getRegistrationType" href="#top">Method: getRegistrationType</a></h3>
Description:<br />
returns the registration type of a given kickstart profile.
 Registration Type can be one of reactivation/deletion/none
 These types determine the behaviour of the registration when using
 this profile for reprovisioning.
<p />




Parameters:<br />
<ul>
<li>

    string sessionKey
 </li>
<li>

    string kickstartLabel
 </li>
</ul>
<p />
Returns:
<code><ul><li>


    string registrationType
      	<ul>
         	<li>reactivation</li>
         	<li>deletion</li>
         	<li>none</li>
      	</ul>
 
</li></ul>
</code>
<p />
<hr />

<h3> <a name="getSELinux" href="#top">Method: getSELinux</a></h3>
Description:<br />
Retrieves the SELinux enforcing mode property of a kickstart
 profile.
<p />




Parameters:<br />
<ul>
<li>

        string sessionKey
 </li>
<li>

    string ksLabel - the kickstart profile label
 </li>
</ul>
<p />
Returns:
<code><ul><li>


    string enforcingMode
      	<ul>
          	<li>enforcing</li>
          	<li>permissive</li>
          	<li>disabled</li>
      	</ul>
 
</li></ul>
</code>
<p />
<hr />

<h3> <a name="listFilePreservations" href="#top">Method: listFilePreservations</a></h3>
Description:<br />
Returns the set of all file preservations associated with the given
 kickstart profile.
<p />




Parameters:<br />
<ul>
<li>

    string sessionKey
 </li>
<li>

    string kickstartLabel
 </li>
</ul>
<p />
Returns:
<code><ul><li>


array:
  <ul>
   <li>
         

	     struct - file list
	<ul>
     	<li> string "name"</li>
         <li>array "file_names"
        <ul>
            <li>string name</li>
        </ul>
    </li>
   	</ul>
 
     </li></ul>
 
</li></ul>
</code>
<p />
<hr />

<h3> <a name="listKeys" href="#top">Method: listKeys</a></h3>
Description:<br />
Returns the set of all keys associated with the given kickstart
             profile.
<p />




Parameters:<br />
<ul>
<li>

    string sessionKey
 </li>
<li>

    string kickstartLabel
 </li>
</ul>
<p />
Returns:
<code><ul><li>


array:
  <ul>
   <li>
          	     struct - key
	<ul>
              	<li> string "description"</li>
              	<li> string "type"</li>
              	<li> string "content"</li>
          	</ul>
      </li></ul>
 
</li></ul>
</code>
<p />
<hr />

<h3> <a name="removeFilePreservations" href="#top">Method: removeFilePreservations</a></h3>
Description:<br />
Removes the given list of file preservations from the specified
 kickstart profile.
<p />




Parameters:<br />
<ul>
<li>

    string sessionKey
 </li>
<li>

    string kickstartLabel
 </li>
<li>

array:
<ul>
    <li>string - filePreservations</li>
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

<h3> <a name="removeKeys" href="#top">Method: removeKeys</a></h3>
Description:<br />
Removes the given list of keys from the specified kickstart profile.
<p />




Parameters:<br />
<ul>
<li>

    string sessionKey
 </li>
<li>

    string kickstartLabel
 </li>
<li>

array:
<ul>
    <li>string - keyDescription</li>
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

<h3> <a name="setLocale" href="#top">Method: setLocale</a></h3>
Description:<br />
Sets the locale for a kickstart profile.
<p />




Parameters:<br />
<ul>
<li>

    string sessionKey
 </li>
<li>

    string ksLabel - the kickstart profile label
 </li>
<li>

    string locale - the locale
 </li>
<li>

    boolean useUtc
      	<ul>
          	<li>true - the hardware clock uses UTC</li>
          	<li>false - the hardware clock does not use UTC</li>
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

<h3> <a name="setPartitioningScheme" href="#top">Method: setPartitioningScheme</a></h3>
Description:<br />
Set the partitioning scheme for a kickstart profile.
<p />




Parameters:<br />
<ul>
<li>

        string sessionKey
 </li>
<li>

    string ksLabel - The label of the
 kickstart profile to update.
 </li>
<li>

    string[] scheme - The partitioning scheme
 is a list of partitioning command strings used to setup the partitions,
 volume groups and logical volumes.
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

<h3> <a name="setRegistrationType" href="#top">Method: setRegistrationType</a></h3>
Description:<br />
Sets the registration type of a given kickstart profile.
 Registration Type can be one of reactivation/deletion/none
 These types determine the behaviour of the re registration when using
 this profile.
<p />




Parameters:<br />
<ul>
<li>

    string sessionKey
 </li>
<li>

    string kickstartLabel
 </li>
<li>

    string registrationType
      	<ul>
         	<li>reactivation - to try and generate a reactivation key
              and use that to register the system when reprovisioning a system.</li>
         	<li>deletion - to try and delete the existing system profile
              and reregister the system being reprovisioned as new</li>
         	<li>none - to preserve the status quo and leave the current system
              as a duplicate on a reprovision.</li>
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

<h3> <a name="setSELinux" href="#top">Method: setSELinux</a></h3>
Description:<br />
Sets the SELinux enforcing mode property of a kickstart profile
 so that a system created using this profile will be have
 the appropriate SELinux enforcing mode.
<p />




Parameters:<br />
<ul>
<li>

        string sessionKey
 </li>
<li>

    string ksLabel - the kickstart profile label
 </li>
<li>

    string enforcingMode - the selinux enforcing mode
      	<ul>
          	<li>enforcing</li>
          	<li>permissive</li>
          	<li>disabled</li>
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
