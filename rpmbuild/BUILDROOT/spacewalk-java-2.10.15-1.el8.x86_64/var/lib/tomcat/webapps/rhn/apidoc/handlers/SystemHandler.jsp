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
system
</p>
<p>Provides methods to access and modify registered system.</p>
<span class="small-text">( <a href="/rhn/apidoc/index.jsp">Return to API Overview</a> )</span>
<hr />

<div class="rounded-box">
<h2><a name="top">Available methods</a></h2>
<ul class="apidoc">

<li><a href="#addEntitlements"/>addEntitlements</a></li>
<li><a href="#addNote"/>addNote</a></li>
<li><a href="#applyErrata"/>applyErrata</a></li>
<li><a href="#comparePackageProfile"/>comparePackageProfile</a></li>
<li><a href="#comparePackages"/>comparePackages</a></li>
<li><a href="#createPackageProfile"/>createPackageProfile</a></li>
<li><a href="#createSystemRecord"/>createSystemRecord</a></li>
<li><a href="#deleteCustomValues"/>deleteCustomValues</a></li>
<li><a href="#deleteGuestProfiles"/>deleteGuestProfiles</a></li>
<li><a href="#deleteNote"/>deleteNote</a></li>
<li><a href="#deleteNotes"/>deleteNotes</a></li>
<li><a href="#deletePackageProfile"/>deletePackageProfile</a></li>
<li><a href="#deleteSystem"/>deleteSystem</a></li>
<li><a href="#deleteSystem"/>deleteSystem</a></li>
<li><a href="#deleteSystems"/>deleteSystems</a></li>
<li><a href="#deleteTagFromSnapshot"/>deleteTagFromSnapshot</a></li>
<li><a href="#downloadSystemId"/>downloadSystemId</a></li>
<li><a href="#getConnectionPath"/>getConnectionPath</a></li>
<li><a href="#getCpu"/>getCpu</a></li>
<li><a href="#getCustomValues"/>getCustomValues</a></li>
<li><a href="#getDetails"/>getDetails</a></li>
<li><a href="#getDevices"/>getDevices</a></li>
<li><a href="#getDmi"/>getDmi</a></li>
<li><a href="#getEntitlements"/>getEntitlements</a></li>
<li><a href="#getEventHistory"/>getEventHistory</a></li>
<li><a href="#getId"/>getId</a></li>
<li><a href="#getMemory"/>getMemory</a></li>
<li><a href="#getName"/>getName</a></li>
<li><a href="#getNetwork"/>getNetwork</a></li>
<li><a href="#getNetworkDevices"/>getNetworkDevices</a></li>
<li><a href="#getOsaPing"/>getOsaPing</a></li>
<li><a href="#getRegistrationDate"/>getRegistrationDate</a></li>
<li><a href="#getRelevantErrata"/>getRelevantErrata</a></li>
<li><a href="#getRelevantErrataByType"/>getRelevantErrataByType</a></li>
<li><a href="#getRunningKernel"/>getRunningKernel</a></li>
<li><a href="#getScriptActionDetails"/>getScriptActionDetails</a></li>
<li><a href="#getScriptResults"/>getScriptResults</a></li>
<li><a href="#getSubscribedBaseChannel"/>getSubscribedBaseChannel</a></li>
<li><a href="#getSystemCurrencyMultipliers"/>getSystemCurrencyMultipliers</a></li>
<li><a href="#getSystemCurrencyScores"/>getSystemCurrencyScores</a></li>
<li><a href="#getUnscheduledErrata"/>getUnscheduledErrata</a></li>
<li><a href="#getUuid"/>getUuid</a></li>
<li><a href="#getVariables"/>getVariables</a></li>
<li><a href="#isNvreInstalled"/>isNvreInstalled</a></li>
<li><a href="#isNvreInstalled"/>isNvreInstalled</a></li>
<li><a href="#listActivationKeys"/>listActivationKeys</a></li>
<li><a href="#listActiveSystems"/>listActiveSystems</a></li>
<li><a href="#listActiveSystemsDetails"/>listActiveSystemsDetails</a></li>
<li><a href="#listAdministrators"/>listAdministrators</a></li>
<li><a href="#listAllInstallablePackages"/>listAllInstallablePackages</a></li>
<li><a href="#listBaseChannels"/>listBaseChannels</a></li>
<li><a href="#listChildChannels"/>listChildChannels</a></li>
<li><a href="#listDuplicatesByHostname"/>listDuplicatesByHostname</a></li>
<li><a href="#listDuplicatesByIp"/>listDuplicatesByIp</a></li>
<li><a href="#listDuplicatesByMac"/>listDuplicatesByMac</a></li>
<li><a href="#listExtraPackages"/>listExtraPackages</a></li>
<li><a href="#listGroups"/>listGroups</a></li>
<li><a href="#listInactiveSystems"/>listInactiveSystems</a></li>
<li><a href="#listInactiveSystems"/>listInactiveSystems</a></li>
<li><a href="#listLatestAvailablePackage"/>listLatestAvailablePackage</a></li>
<li><a href="#listLatestInstallablePackages"/>listLatestInstallablePackages</a></li>
<li><a href="#listLatestUpgradablePackages"/>listLatestUpgradablePackages</a></li>
<li><a href="#listNewerInstalledPackages"/>listNewerInstalledPackages</a></li>
<li><a href="#listNotes"/>listNotes</a></li>
<li><a href="#listOlderInstalledPackages"/>listOlderInstalledPackages</a></li>
<li><a href="#listOutOfDateSystems"/>listOutOfDateSystems</a></li>
<li><a href="#listPackageProfiles"/>listPackageProfiles</a></li>
<li><a href="#listPackages"/>listPackages</a></li>
<li><a href="#listPackagesFromChannel"/>listPackagesFromChannel</a></li>
<li><a href="#listPhysicalSystems"/>listPhysicalSystems</a></li>
<li><a href="#listSubscribableBaseChannels"/>listSubscribableBaseChannels</a></li>
<li><a href="#listSubscribableChildChannels"/>listSubscribableChildChannels</a></li>
<li><a href="#listSubscribedChildChannels"/>listSubscribedChildChannels</a></li>
<li><a href="#listSuggestedReboot"/>listSuggestedReboot</a></li>
<li><a href="#listSystemEvents"/>listSystemEvents</a></li>
<li><a href="#listSystemEvents"/>listSystemEvents</a></li>
<li><a href="#listSystems"/>listSystems</a></li>
<li><a href="#listSystemsWithExtraPackages"/>listSystemsWithExtraPackages</a></li>
<li><a href="#listSystemsWithPackage"/>listSystemsWithPackage</a></li>
<li><a href="#listSystemsWithPackage"/>listSystemsWithPackage</a></li>
<li><a href="#listUngroupedSystems"/>listUngroupedSystems</a></li>
<li><a href="#listUserSystems"/>listUserSystems</a></li>
<li><a href="#listUserSystems"/>listUserSystems</a></li>
<li><a href="#listVirtualGuests"/>listVirtualGuests</a></li>
<li><a href="#listVirtualHosts"/>listVirtualHosts</a></li>
<li><a href="#obtainReactivationKey"/>obtainReactivationKey</a></li>
<li><a href="#obtainReactivationKey"/>obtainReactivationKey</a></li>
<li><a href="#provisionSystem"/>provisionSystem</a></li>
<li><a href="#provisionSystem"/>provisionSystem</a></li>
<li><a href="#provisionVirtualGuest"/>provisionVirtualGuest</a></li>
<li><a href="#provisionVirtualGuest"/>provisionVirtualGuest</a></li>
<li><a href="#provisionVirtualGuest"/>provisionVirtualGuest</a></li>
<li><a href="#removeEntitlements"/>removeEntitlements</a></li>
<li><a href="#scheduleApplyErrata"/>scheduleApplyErrata</a></li>
<li><a href="#scheduleApplyErrata"/>scheduleApplyErrata</a></li>
<li><a href="#scheduleApplyErrata"/>scheduleApplyErrata</a></li>
<li><a href="#scheduleApplyErrata"/>scheduleApplyErrata</a></li>
<li><a href="#scheduleApplyErrata"/>scheduleApplyErrata</a></li>
<li><a href="#scheduleApplyErrata"/>scheduleApplyErrata</a></li>
<li><a href="#scheduleApplyErrata"/>scheduleApplyErrata</a></li>
<li><a href="#scheduleApplyErrata"/>scheduleApplyErrata</a></li>
<li><a href="#scheduleCertificateUpdate"/>scheduleCertificateUpdate</a></li>
<li><a href="#scheduleCertificateUpdate"/>scheduleCertificateUpdate</a></li>
<li><a href="#scheduleGuestAction"/>scheduleGuestAction</a></li>
<li><a href="#scheduleGuestAction"/>scheduleGuestAction</a></li>
<li><a href="#scheduleHardwareRefresh"/>scheduleHardwareRefresh</a></li>
<li><a href="#schedulePackageInstall"/>schedulePackageInstall</a></li>
<li><a href="#schedulePackageInstall"/>schedulePackageInstall</a></li>
<li><a href="#schedulePackageInstall"/>schedulePackageInstall</a></li>
<li><a href="#schedulePackageInstall"/>schedulePackageInstall</a></li>
<li><a href="#schedulePackageInstallByNevra"/>schedulePackageInstallByNevra</a></li>
<li><a href="#schedulePackageInstallByNevra"/>schedulePackageInstallByNevra</a></li>
<li><a href="#schedulePackageInstallByNevra"/>schedulePackageInstallByNevra</a></li>
<li><a href="#schedulePackageInstallByNevra"/>schedulePackageInstallByNevra</a></li>
<li><a href="#schedulePackageRefresh"/>schedulePackageRefresh</a></li>
<li><a href="#schedulePackageRemove"/>schedulePackageRemove</a></li>
<li><a href="#schedulePackageRemove"/>schedulePackageRemove</a></li>
<li><a href="#schedulePackageRemove"/>schedulePackageRemove</a></li>
<li><a href="#schedulePackageRemove"/>schedulePackageRemove</a></li>
<li><a href="#schedulePackageRemoveByNevra"/>schedulePackageRemoveByNevra</a></li>
<li><a href="#schedulePackageRemoveByNevra"/>schedulePackageRemoveByNevra</a></li>
<li><a href="#schedulePackageRemoveByNevra"/>schedulePackageRemoveByNevra</a></li>
<li><a href="#schedulePackageRemoveByNevra"/>schedulePackageRemoveByNevra</a></li>
<li><a href="#scheduleReboot"/>scheduleReboot</a></li>
<li><a href="#scheduleScriptRun"/>scheduleScriptRun</a></li>
<li><a href="#scheduleScriptRun"/>scheduleScriptRun</a></li>
<li><a href="#scheduleScriptRun"/>scheduleScriptRun</a></li>
<li><a href="#scheduleScriptRun"/>scheduleScriptRun</a></li>
<li><a href="#scheduleSyncPackagesWithSystem"/>scheduleSyncPackagesWithSystem</a></li>
<li><a href="#searchByName"/>searchByName</a></li>
<li><a href="#sendOsaPing"/>sendOsaPing</a></li>
<li><a href="#setBaseChannel"/>setBaseChannel</a></li>
<li><a href="#setBaseChannel"/>setBaseChannel</a></li>
<li><a href="#setChildChannels"/>setChildChannels</a></li>
<li><a href="#setCustomValues"/>setCustomValues</a></li>
<li><a href="#setDetails"/>setDetails</a></li>
<li><a href="#setGroupMembership"/>setGroupMembership</a></li>
<li><a href="#setGuestCpus"/>setGuestCpus</a></li>
<li><a href="#setGuestMemory"/>setGuestMemory</a></li>
<li><a href="#setLockStatus"/>setLockStatus</a></li>
<li><a href="#setPrimaryInterface"/>setPrimaryInterface</a></li>
<li><a href="#setProfileName"/>setProfileName</a></li>
<li><a href="#setVariables"/>setVariables</a></li>
<li><a href="#tagLatestSnapshot"/>tagLatestSnapshot</a></li>
<li><a href="#unentitle"/>unentitle</a></li>
<li><a href="#upgradeEntitlement"/>upgradeEntitlement</a></li>
<li><a href="#whoRegistered"/>whoRegistered</a></li>
</ul>
</div>
<hr />

<h3> <a name="addEntitlements" href="#top">Method: addEntitlements</a></h3>
Description:<br />
Add entitlements to a server. Entitlements a server already has
 are quietly ignored.
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
    <li>string - entitlementLabel - one of following:
 virtualization_host, enterprise_entitled</li>
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

<h3> <a name="addNote" href="#top">Method: addNote</a></h3>
Description:<br />
Add a new note to the given server.
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

    string subject - What the note is about.
 </li>
<li>

    string body - Content of the note.
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

<h3 class="deprecated"><a name="applyErrata" href="#top">Method: applyErrata</a></h3>
Description:<br />
Schedules an action to apply errata updates to a system.
<p />


Deprecated - being replaced by system.scheduleApplyErrata(string sessionKey,
 int serverId, array[int errataId]) <p />


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
    <li>int - errataId</li>
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

<h3> <a name="comparePackageProfile" href="#top">Method: comparePackageProfile</a></h3>
Description:<br />
Compare a system's packages against a package profile.  In
 the result returned, 'this_system' represents the server provided as an input
 and 'other_system' represents the profile provided as an input.
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

    string profileLabel
 </li>
</ul>
<p />
Returns:
<code><ul><li>


array:
  <ul>
   <li>
              

	     struct - Package Metadata
	<ul>
      	<li> int "package_name_id"</li>
      	<li> string "package_name"</li>
      	<li> string "package_epoch"</li>
      	<li> string "package_version"</li>
      	<li> string "package_release"</li>
      	<li> string "package_arch"</li>
          <li> string "this_system" - Version of package on this system. </li>
          <li> string "other_system" - Version of package on the other system. </li>
      	<li> int "comparison"</li>
          	<ul>
              	<li>0 - No difference.</li>
              	<li>1 - Package on this system only.</li>
              	<li>2 - Newer package version on this system.</li>
              	<li>3 - Package on other system only.</li>
              	<li>4 - Newer package version on other system.</li>
           	</ul>
   	</ul>
 
          </li></ul>
 
</li></ul>
</code>
<p />
<hr />

<h3> <a name="comparePackages" href="#top">Method: comparePackages</a></h3>
Description:<br />
Compares the packages installed on two systems.
<p />




Parameters:<br />
<ul>
<li>

    string sessionKey
 </li>
<li>

    int thisServerId
 </li>
<li>

    int otherServerId
 </li>
</ul>
<p />
Returns:
<code><ul><li>


array:
  <ul>
   <li>
              

	     struct - Package Metadata
	<ul>
      	<li> int "package_name_id"</li>
      	<li> string "package_name"</li>
      	<li> string "package_epoch"</li>
      	<li> string "package_version"</li>
      	<li> string "package_release"</li>
      	<li> string "package_arch"</li>
          <li> string "this_system" - Version of package on this system. </li>
          <li> string "other_system" - Version of package on the other system. </li>
      	<li> int "comparison"</li>
          	<ul>
              	<li>0 - No difference.</li>
              	<li>1 - Package on this system only.</li>
              	<li>2 - Newer package version on this system.</li>
              	<li>3 - Package on other system only.</li>
              	<li>4 - Newer package version on other system.</li>
           	</ul>
   	</ul>
 
          </li></ul>
 
</li></ul>
</code>
<p />
<hr />

<h3> <a name="createPackageProfile" href="#top">Method: createPackageProfile</a></h3>
Description:<br />
Create a new stored Package Profile from a systems
      installed package list.
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

    string profileLabel
 </li>
<li>

    string description
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

<h3> <a name="createSystemRecord" href="#top">Method: createSystemRecord</a></h3>
Description:<br />
Creates a cobbler system record with the specified kickstart label
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

    string ksLabel
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

<h3> <a name="deleteCustomValues" href="#top">Method: deleteCustomValues</a></h3>
Description:<br />
Delete the custom values defined for the custom system information keys
 provided from the given system.
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
    <li>string - customInfoLabel</li>
</ul>
 </li>
</ul>
<p />
Returns:
<code><ul><li>


    int - 1 on success, exception thrown otherwise.
 (Note: Attempt to delete values of non-existing keys throws exception. Attempt to
 delete value of existing key which has assigned no values doesn't throw exception.) 
 
</li></ul>
</code>
<p />
<hr />

<h3> <a name="deleteGuestProfiles" href="#top">Method: deleteGuestProfiles</a></h3>
Description:<br />
Delete the specified list of guest profiles for a given host
<p />




Parameters:<br />
<ul>
<li>

    string sessionKey
 </li>
<li>

    int hostId
 </li>
<li>

array:
<ul>
    <li>string - guestNames</li>
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

<h3> <a name="deleteNote" href="#top">Method: deleteNote</a></h3>
Description:<br />
Deletes the given note from the server.
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

    int noteId
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

<h3> <a name="deleteNotes" href="#top">Method: deleteNotes</a></h3>
Description:<br />
Deletes all notes from the server.
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


    int - 1 on success, exception thrown otherwise.
 
</li></ul>
</code>
<p />
<hr />

<h3> <a name="deletePackageProfile" href="#top">Method: deletePackageProfile</a></h3>
Description:<br />
Delete a package profile
<p />




Parameters:<br />
<ul>
<li>

    string sessionKey
 </li>
<li>

    int profileId
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

<h3> <a name="deleteSystem" href="#top">Method: deleteSystem</a></h3>
Description:<br />
Delete a system given its client certificate.
<p />




Parameters:<br />
<ul>
<li>

    string systemid - systemid file
 </li>
</ul>
<p />
Returns:
<code><ul><li>


    int - 1 on success, exception thrown otherwise.
 
</li></ul>
</code>
<p />
Available since: 10.10 <p />
<hr />

<h3> <a name="deleteSystem" href="#top">Method: deleteSystem</a></h3>
Description:<br />
Delete a system given its server id synchronously
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


    int - 1 on success, exception thrown otherwise.
 
</li></ul>
</code>
<p />
<hr />

<h3> <a name="deleteSystems" href="#top">Method: deleteSystems</a></h3>
Description:<br />
Delete systems given a list of system ids asynchronously.
<p />




Parameters:<br />
<ul>
<li>

    string sessionKey
 </li>
<li>

array:
<ul>
    <li>int - serverId</li>
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

<h3> <a name="deleteTagFromSnapshot" href="#top">Method: deleteTagFromSnapshot</a></h3>
Description:<br />
Deletes tag from system snapshot
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

    string tagName
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

<h3> <a name="downloadSystemId" href="#top">Method: downloadSystemId</a></h3>
Description:<br />
Get the system ID file for a given server.
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


string 
 
</li></ul>
</code>
<p />
<hr />

<h3> <a name="getConnectionPath" href="#top">Method: getConnectionPath</a></h3>
Description:<br />
Get the list of proxies that the given system connects
 through in order to reach the server.
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
          

	     struct - proxy connection path details
	<ul>
             <li> int "position" - Position of proxy in chain. The proxy that the
             system connects directly to is listed in position 1. </li>
             <li> int "id" - Proxy system id </li>
             <li> string "hostname" - Proxy host name </li>
  	</ul>
 
      </li></ul>
 
</li></ul>
</code>
<p />
<hr />

<h3> <a name="getCpu" href="#top">Method: getCpu</a></h3>
Description:<br />
Gets the CPU information of a system.
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




	     struct - CPU
	<ul>
      	<li> string "cache"</li>
      	<li> string "family"</li>
      	<li> string "mhz"</li>
      	<li> string "flags"</li>
      	<li> string "model"</li>
      	<li> string "vendor"</li>
      	<li> string "arch"</li>
      	<li> string "stepping"</li>
      	<li> string "count"</li>
      	<li> int "socket_count (if available)"</li>
  	</ul>
  
 
</li></ul>
</code>
<p />
<hr />

<h3> <a name="getCustomValues" href="#top">Method: getCustomValues</a></h3>
Description:<br />
Get the custom data values defined for the server.
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


	     struct - custom value
	<ul>
          	<li> string "custom info label"</li>
      	</ul>
 
</li></ul>
</code>
<p />
<hr />

<h3> <a name="getDetails" href="#top">Method: getDetails</a></h3>
Description:<br />
Get system details.
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




	     struct - server details
	<ul>
             <li> int "id" - System id </li>
         	<li> string "profile_name"</li>
             <li> string "base_entitlement" - System's base entitlement label </li>

             <li>array "string"
        <ul>
            <li>addon_entitlements System's addon entitlements labels,
                       currently only 'virtualization_host'</li>
        </ul>
    </li>
              <li> boolean "auto_update" - True if system has auto errata updates
                                          enabled. </li>
              <li> string "release" - The Operating System release (i.e. 4AS,
                      5Server </li>
          	<li> string "address1"</li>
          	<li> string "address2"</li>
          	<li> string "city"</li>
          	<li> string "state"</li>
          	<li> string "country"</li>
          	<li> string "building"</li>
          	<li> string "room"</li>
          	<li> string "rack"</li>
          	<li> string "description"</li>
          	<li> string "hostname"</li>
          	<li> dateTime.iso8601 "last_boot"</li>
              <li> string "osa_status" - Either 'unknown', 'offline', or 'online'. </li>
              <li> boolean "lock_status" - True indicates that the system is locked.
           False indicates that the system is unlocked. </li>
              <li> string "virtualization" - Virtualization type -
           for virtual guests only (optional) </li>
  	</ul>
  
 
</li></ul>
</code>
<p />
<hr />

<h3> <a name="getDevices" href="#top">Method: getDevices</a></h3>
Description:<br />
Gets a list of devices for a system.
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
              

	     struct - device
	<ul>
          <li> string "device" - optional </li>
          <li> string "device_class" - Includes CDROM, FIREWIRE, HD, USB, VIDEO,
                  OTHER, etc. </li>
      	<li> string "driver"</li>
      	<li> string "description"</li>
      	<li> string "bus"</li>
      	<li> string "pcitype"</li>
   	</ul>
 
              </li></ul>
 
</li></ul>
</code>
<p />
<hr />

<h3> <a name="getDmi" href="#top">Method: getDmi</a></h3>
Description:<br />
Gets the DMI information of a system.
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




	     struct - DMI
	<ul>
          	<li> string "vendor"</li>
          	<li> string "system"</li>
          	<li> string "product"</li>
          	<li> string "asset"</li>
          	<li> string "board"</li>
              <li> string "bios_release" - (optional) </li>
              <li> string "bios_vendor" - (optional) </li>
              <li> string "bios_version" - (optional) </li>
      	</ul>
  
 
</li></ul>
</code>
<p />
<hr />

<h3> <a name="getEntitlements" href="#top">Method: getEntitlements</a></h3>
Description:<br />
Gets the entitlements for a given server.
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
    <li>string - entitlement_label</li>
</ul>
 
</li></ul>
</code>
<p />
<hr />

<h3> <a name="getEventHistory" href="#top">Method: getEventHistory</a></h3>
Description:<br />
Returns a list history items associated with the system, ordered
             from newest to oldest. Note that the details may be empty for
             events that were scheduled against the system (as compared to instant).
             For more information on such events, see the system.listSystemEvents
             operation.
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
           

	     struct - History Event
	<ul>
          <li> dateTime.iso8601 "completed" - Date that
          the event occurred (optional) </li>
          <li> string "summary" - Summary of the event </li>
          <li> string "details" - Details of the event </li>
  	</ul>
 
      </li></ul>
 
</li></ul>
</code>
<p />
<hr />

<h3> <a name="getId" href="#top">Method: getId</a></h3>
Description:<br />
Get system IDs and last check in information for the given system name.
<p />




Parameters:<br />
<ul>
<li>

    string sessionKey
 </li>
<li>

    string systemName
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
           <li> dateTime.iso8601 "last_checkin" - Last time server
              successfully checked in </li>
           <li> dateTime.iso8601 "last_boot" - Last server boot time </li>
           <li> dateTime.iso8601 "created" - Server registration time </li>

 	</ul>
 
          </li></ul>
 
</li></ul>
</code>
<p />
<hr />

<h3> <a name="getMemory" href="#top">Method: getMemory</a></h3>
Description:<br />
Gets the memory information for a system.
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


	     struct - memory
	<ul>
          <li> int "ram" - The amount of physical memory in MB. </li>
          <li> int "swap" - The amount of swap space in MB. </li>
  	</ul>
 
</li></ul>
</code>
<p />
<hr />

<h3> <a name="getName" href="#top">Method: getName</a></h3>
Description:<br />
Get system name and last check in information for the given system ID.
<p />




Parameters:<br />
<ul>
<li>

    string sessionKey
 </li>
<li>

    string serverId
 </li>
</ul>
<p />
Returns:
<code><ul><li>


	     struct - name info
	<ul>
          <li> int "id" - Server id </li>
          <li> string "name" - Server name </li>
          <li> dateTime.iso8601 "last_checkin" - Last time server
              successfully checked in </li>
  	</ul>
 
</li></ul>
</code>
<p />
<hr />

<h3> <a name="getNetwork" href="#top">Method: getNetwork</a></h3>
Description:<br />
Get the addresses and hostname for a given server.
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


	     struct - network info
	<ul>
                  <li> string "ip" - IPv4 address of server </li>
                  <li> string "ip6" - IPv6 address of server </li>
                  <li> string "hostname" - Hostname of server </li>
          	</ul>
 
</li></ul>
</code>
<p />
<hr />

<h3> <a name="getNetworkDevices" href="#top">Method: getNetworkDevices</a></h3>
Description:<br />
Returns the network devices for the given server.
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
          

	     struct - network device
	<ul>
              <li> string "ip" - IP address assigned to this network device </li>
              <li> string "interface" - Network interface assigned to device e.g.
                              eth0 </li>
              <li> string "netmask" - Network mask assigned to device </li>
              <li> string "hardware_address" - Hardware Address of device. </li>
              <li> string "module" - Network driver used for this device. </li>
              <li> string "broadcast" -  Broadcast address for device. </li>
              <li> array "ipv6" - List of IPv6 addresses </li>
            array:
  <ul>
   <li>
               	     struct - ipv6 address
	<ul>
                     <li> string "address" - IPv6 address of this network device </li>
                     <li> string "netmask" - IPv6 netmask of this network device </li>
                     <li> string "scope" - IPv6 address scope </li>
               	</ul>
            </li></ul>
      	</ul>
 
      </li></ul>
 
</li></ul>
</code>
<p />
<hr />

<h3> <a name="getOsaPing" href="#top">Method: getOsaPing</a></h3>
Description:<br />
get details about a ping sent to a system using OSA
<p />




Parameters:<br />
<ul>
<li>

    User loggedInUser
 </li>
<li>

    int serverId
 </li>
</ul>
<p />
Returns:
<code><ul><li>


	     struct - osaPing
	<ul>
              <li> String "state" - state of the system (unknown, online, offline) </li>
              <li> dateTime.iso8601 "lastMessageTime" - time of the last received response
          (1970/01/01 00:00:00 if never received a response) </li>
              <li> dateTime.iso8601 "lastPingTime" - time of the last sent ping
          (1970/01/01 00:00:00 if no ping is pending </li>
      	</ul>
 
</li></ul>
</code>
<p />
<hr />

<h3> <a name="getRegistrationDate" href="#top">Method: getRegistrationDate</a></h3>
Description:<br />
Returns the date the system was registered.
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


dateTime.iso8601 - The date the system was registered,
 in local time. 
 
</li></ul>
</code>
<p />
<hr />

<h3> <a name="getRelevantErrata" href="#top">Method: getRelevantErrata</a></h3>
Description:<br />
Returns a list of all errata that are relevant to the system.
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
          

	     struct - errata
	<ul>
              <li> int "id" - Errata ID. </li>
              <li> string "date" - Date erratum was created. </li>
              <li> string "update_date" - Date erratum was updated. </li>
              <li> string "advisory_synopsis" - Summary of the erratum. </li>
              <li> string "advisory_type" - Type label such as Security, Bug Fix </li>
              <li> string "advisory_name" - Name such as RHSA, etc </li>
      	</ul>
 
      </li></ul>
 
</li></ul>
</code>
<p />
<hr />

<h3> <a name="getRelevantErrataByType" href="#top">Method: getRelevantErrataByType</a></h3>
Description:<br />
Returns a list of all errata of the specified type that are
 relevant to the system.
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

    string advisoryType - type of advisory (one of
 of the following: 'Security Advisory', 'Product Enhancement Advisory',
 'Bug Fix Advisory'
 </li>
</ul>
<p />
Returns:
<code><ul><li>


array:
  <ul>
   <li>
          

	     struct - errata
	<ul>
              <li> int "id" - Errata ID. </li>
              <li> string "date" - Date erratum was created. </li>
              <li> string "update_date" - Date erratum was updated. </li>
              <li> string "advisory_synopsis" - Summary of the erratum. </li>
              <li> string "advisory_type" - Type label such as Security, Bug Fix </li>
              <li> string "advisory_name" - Name such as RHSA, etc </li>
      	</ul>
 
      </li></ul>
 
</li></ul>
</code>
<p />
<hr />

<h3> <a name="getRunningKernel" href="#top">Method: getRunningKernel</a></h3>
Description:<br />
Returns the running kernel of the given system.
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


string 
 
</li></ul>
</code>
<p />
<hr />

<h3> <a name="getScriptActionDetails" href="#top">Method: getScriptActionDetails</a></h3>
Description:<br />
Returns script details for script run actions
<p />




Parameters:<br />
<ul>
<li>

    string sessionKey
 </li>
<li>

    int actionId - ID of the script run action.
 </li>
</ul>
<p />
Returns:
<code><ul><li>


	     struct - Script details
	<ul>
              <li> int "id" - action id </li>
              <li> string "content" - script content </li>
              <li> string "run_as_user" - Run as user </li>
              <li> string "run_as_group" - Run as group </li>
              <li> int "timeout" - Timeout in seconds </li>
          array:
  <ul>
   <li>
              

	     struct - script result
	<ul>
          <li> int "serverId" - ID of the server the script runs on. </li>
          <li> dateTime.iso8601 "startDate" - Time script began execution. </li>
          <li> dateTime.iso8601 "stopDate" - Time script stopped execution. </li>
          <li> int "returnCode" - Script execution return code. </li>
          <li> string "output" - Output of the script (base64 encoded according
                to the output_enc64 attribute) </li>
          <li> boolean "output_enc64" - Identifies base64 encoded output </li>
  	</ul>
 
          </li></ul>
      	</ul>
 
</li></ul>
</code>
<p />
<hr />

<h3> <a name="getScriptResults" href="#top">Method: getScriptResults</a></h3>
Description:<br />
Fetch results from a script execution. Returns an empty array if no
 results are yet available.
<p />




Parameters:<br />
<ul>
<li>

    string sessionKey
 </li>
<li>

    int actionId - ID of the script run action.
 </li>
</ul>
<p />
Returns:
<code><ul><li>


array:
  <ul>
   <li>
              

	     struct - script result
	<ul>
          <li> int "serverId" - ID of the server the script runs on. </li>
          <li> dateTime.iso8601 "startDate" - Time script began execution. </li>
          <li> dateTime.iso8601 "stopDate" - Time script stopped execution. </li>
          <li> int "returnCode" - Script execution return code. </li>
          <li> string "output" - Output of the script (base64 encoded according
                to the output_enc64 attribute) </li>
          <li> boolean "output_enc64" - Identifies base64 encoded output </li>
  	</ul>
 
         </li></ul>
 
</li></ul>
</code>
<p />
<hr />

<h3> <a name="getSubscribedBaseChannel" href="#top">Method: getSubscribedBaseChannel</a></h3>
Description:<br />
Provides the base channel of a given system
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
</code>
<p />
<hr />

<h3> <a name="getSystemCurrencyMultipliers" href="#top">Method: getSystemCurrencyMultipliers</a></h3>
Description:<br />
Get the System Currency score multipliers
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


Map of score multipliers 
 
</li></ul>
</code>
<p />
<hr />

<h3> <a name="getSystemCurrencyScores" href="#top">Method: getSystemCurrencyScores</a></h3>
Description:<br />
Get the System Currency scores for all servers the user has access to
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
          	     struct - system currency
	<ul>
              	<li> int "sid"</li>
              	<li> int "critical security errata count"</li>
              	<li> int "important security errata count"</li>
              	<li> int "moderate security errata count"</li>
              	<li> int "low security errata count"</li>
              	<li> int "bug fix errata count"</li>
              	<li> int "enhancement errata count"</li>
              	<li> int "system currency score"</li>
          	</ul>
      </li></ul>
 
</li></ul>
</code>
<p />
<hr />

<h3> <a name="getUnscheduledErrata" href="#top">Method: getUnscheduledErrata</a></h3>
Description:<br />
Provides an array of errata that are applicable to a given system.
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
          

	     struct - errata
	<ul>
              <li> int "id" - Errata Id </li>
              <li> string "date" - Date erratum was created. </li>
              <li> string "advisory_type" - Type of the advisory. </li>
              <li> string "advisory_name" - Name of the advisory. </li>
              <li> string "advisory_synopsis" - Summary of the erratum. </li>
     	</ul>
 
      </li></ul>
 
</li></ul>
</code>
<p />
<hr />

<h3> <a name="getUuid" href="#top">Method: getUuid</a></h3>
Description:<br />
Get the UUID from the given system ID.
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


string 
 
</li></ul>
</code>
<p />
<hr />

<h3> <a name="getVariables" href="#top">Method: getVariables</a></h3>
Description:<br />
Lists kickstart variables set  in the system record
  for the specified server.
  Note: This call assumes that a system record exists in cobbler for the
  given system and will raise an XMLRPC fault if that is not the case.
  To create a system record over xmlrpc use system.createSystemRecord

  To create a system record in the Web UI  please go to
  System -&gt; &lt;Specified System&gt; -&gt; Provisioning -&gt;
  Select a Kickstart profile -&gt; Create Cobbler System Record.
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


	     struct - System kickstart variables
	<ul>
              <li> boolean "netboot" - netboot enabled </li>
              <li>array "kickstart variables"
        <ul>
            <li>
              	     struct - kickstart variable
	<ul>
                  	<li> string "key"</li>
                  	<li> string or int "value"</li>
              	</ul>
                     </li>
        </ul>
    </li>
      	</ul>
 
</li></ul>
</code>
<p />
<hr />

<h3> <a name="isNvreInstalled" href="#top">Method: isNvreInstalled</a></h3>
Description:<br />
Check if the package with the given NVRE is installed on given system.
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

    string name - Package name.
 </li>
<li>

    string version - Package version.
 </li>
<li>

    string release - Package release.
 </li>
</ul>
<p />
Returns:
<code><ul><li>


1 if package exists, 0 if not, exception is thrown
 if an error occurs 
 
</li></ul>
</code>
<p />
<hr />

<h3> <a name="isNvreInstalled" href="#top">Method: isNvreInstalled</a></h3>
Description:<br />
Is the package with the given NVRE installed on given system.
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

    string name - Package name.
 </li>
<li>

    string version - Package version.
 </li>
<li>

    string release - Package release.
 </li>
<li>

    string epoch - Package epoch.
 </li>
</ul>
<p />
Returns:
<code><ul><li>


1 if package exists, 0 if not, exception is thrown
 if an error occurs 
 
</li></ul>
</code>
<p />
<hr />

<h3> <a name="listActivationKeys" href="#top">Method: listActivationKeys</a></h3>
Description:<br />
List the activation keys the system was registered with.  An empty
 list will be returned if an activation key was not used during registration.
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
    <li>string - key</li>
</ul>
 
</li></ul>
</code>
<p />
<hr />

<h3> <a name="listActiveSystems" href="#top">Method: listActiveSystems</a></h3>
Description:<br />
Returns a list of active servers visible to the user.
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
          

	     struct - system
	<ul>
      	<li> int "id"</li>
      	<li> string "name"</li>
           <li> dateTime.iso8601 "last_checkin" - Last time server
              successfully checked in </li>
           <li> dateTime.iso8601 "last_boot" - Last server boot time </li>
           <li> dateTime.iso8601 "created" - Server registration time </li>

 	</ul>
 
      </li></ul>
 
</li></ul>
</code>
<p />
<hr />

<h3> <a name="listActiveSystemsDetails" href="#top">Method: listActiveSystemsDetails</a></h3>
Description:<br />
Given a list of server ids, returns a list of active servers'
 details visible to the user.
<p />




Parameters:<br />
<ul>
<li>

    string sessionKey
 </li>
<li>

array:
<ul>
    <li>int - serverIds</li>
</ul>
 </li>
</ul>
<p />
Returns:
<code><ul><li>


array:
  <ul>
   <li>
     	     struct - server details
	<ul>
           <li> int "id" - The server's id </li>
           <li> string "name" - The server's name </li>
           <li> dateTime.iso8601 "last_checkin" - Last time server successfully checked in (in UTC) </li>
           <li> int "ram" - The amount of physical memory in MB. </li>
           <li> int "swap" - The amount of swap space in MB. </li>
           <li> struct "network_devices" - The server's network devices </li>
       

	     struct - network device
	<ul>
              <li> string "ip" - IP address assigned to this network device </li>
              <li> string "interface" - Network interface assigned to device e.g.
                              eth0 </li>
              <li> string "netmask" - Network mask assigned to device </li>
              <li> string "hardware_address" - Hardware Address of device. </li>
              <li> string "module" - Network driver used for this device. </li>
              <li> string "broadcast" -  Broadcast address for device. </li>
              <li> array "ipv6" - List of IPv6 addresses </li>
            array:
  <ul>
   <li>
               	     struct - ipv6 address
	<ul>
                     <li> string "address" - IPv6 address of this network device </li>
                     <li> string "netmask" - IPv6 netmask of this network device </li>
                     <li> string "scope" - IPv6 address scope </li>
               	</ul>
            </li></ul>
      	</ul>
 
           <li> struct "dmi_info" - The server's dmi info </li>
       

	     struct - DMI
	<ul>
          	<li> string "vendor"</li>
          	<li> string "system"</li>
          	<li> string "product"</li>
          	<li> string "asset"</li>
          	<li> string "board"</li>
              <li> string "bios_release" - (optional) </li>
              <li> string "bios_vendor" - (optional) </li>
              <li> string "bios_version" - (optional) </li>
      	</ul>
 
           <li> struct "cpu_info" - The server's cpu info </li>
       

	     struct - CPU
	<ul>
      	<li> string "cache"</li>
      	<li> string "family"</li>
      	<li> string "mhz"</li>
      	<li> string "flags"</li>
      	<li> string "model"</li>
      	<li> string "vendor"</li>
      	<li> string "arch"</li>
      	<li> string "stepping"</li>
      	<li> string "count"</li>
      	<li> int "socket_count (if available)"</li>
  	</ul>
 
           <li> array "subscribed_channels" - List of subscribed channels </li>
         array:
  <ul>
   <li>
           	     struct - channel
	<ul>
                 <li> int "channel_id" - The channel id. </li>
                 <li> string "channel_label" - The channel label. </li>
           	</ul>
         </li></ul>
           <li> array "active_guest_system_ids" - List of virtual guest system ids for active guests </li>
         array:
  <ul>
   <li>
               <li> int "guest_id" - The guest's system id. </li>
         </li></ul>
     	</ul>
   </li></ul>
 
</li></ul>
</code>
<p />
<hr />

<h3> <a name="listAdministrators" href="#top">Method: listAdministrators</a></h3>
Description:<br />
Returns a list of users which can administer the system.
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
              

	     struct - user
	<ul>
              	<li> int "id"</li>
              	<li> string "login"</li>
                  <li> string "login_uc" - upper case version of the login </li>
                  <li> boolean "enabled" - true if user is enabled,
                         false if the user is disabled </li>
      	</ul>
 
      </li></ul>
 
</li></ul>
</code>
<p />
<hr />

<h3> <a name="listAllInstallablePackages" href="#top">Method: listAllInstallablePackages</a></h3>
Description:<br />
Get the list of all installable packages for a given system.
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


	     struct - package
	<ul>
          	<li> string "name"</li>
          	<li> string "version"</li>
          	<li> string "release"</li>
          	<li> string "epoch"</li>
          	<li> int "id"</li>
          	<li> string "arch_label"</li>
      	</ul>
 
</li></ul>
</code>
<p />
<hr />

<h3 class="deprecated"><a name="listBaseChannels" href="#top">Method: listBaseChannels</a></h3>
Description:<br />
Returns a list of subscribable base channels.
<p />


Deprecated - being replaced by listSubscribableBaseChannels(string sessionKey,
 int serverId) <p />


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
      	     struct - channel
	<ul>
              <li> int "id" - Base Channel ID. </li>
              <li> string "name" - Name of channel. </li>
              <li> string "label" - Label of Channel </li>
              <li> int "current_base" - 1 indicates it is the current base
                                      channel </li>
      	</ul>
  </li></ul>
 
</li></ul>
</code>
<p />
<hr />

<h3 class="deprecated"><a name="listChildChannels" href="#top">Method: listChildChannels</a></h3>
Description:<br />
Returns a list of subscribable child channels.  This only shows channels
 the system is *not* currently subscribed to.
<p />


Deprecated - being replaced by listSubscribableChildChannels(string sessionKey,
 int serverId) <p />


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
          	     struct - child channel
	<ul>
              	<li> int "id"</li>
              	<li> string "name"</li>
              	<li> string "label"</li>
              	<li> string "summary"</li>
              	<li> string "has_license"</li>
              	<li> string "gpg_key_url"</li>
          	</ul>
      </li></ul>
 
</li></ul>
</code>
<p />
<hr />

<h3> <a name="listDuplicatesByHostname" href="#top">Method: listDuplicatesByHostname</a></h3>
Description:<br />
List duplicate systems by Hostname.
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
           	     struct - Duplicate Group
	<ul>
                   	<li> string "hostname"</li>
                       <li>array "systems"
        <ul>
            <li>
                      

	     struct - system
	<ul>
      	<li> int "systemId"</li>
      	<li> string "systemName"</li>
          <li> dateTime.iso8601 "last_checkin" - Last time server
              successfully checked in </li>
 	</ul>
 
                              </li>
        </ul>
    </li>
           	</ul>
      </li></ul>
 
</li></ul>
</code>
<p />
<hr />

<h3> <a name="listDuplicatesByIp" href="#top">Method: listDuplicatesByIp</a></h3>
Description:<br />
List duplicate systems by IP Address.
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
           	     struct - Duplicate Group
	<ul>
                   	<li> string "ip"</li>
                       <li>array "systems"
        <ul>
            <li>
                      

	     struct - system
	<ul>
      	<li> int "systemId"</li>
      	<li> string "systemName"</li>
          <li> dateTime.iso8601 "last_checkin" - Last time server
              successfully checked in </li>
 	</ul>
 
                              </li>
        </ul>
    </li>
           	</ul>
      </li></ul>
 
</li></ul>
</code>
<p />
<hr />

<h3> <a name="listDuplicatesByMac" href="#top">Method: listDuplicatesByMac</a></h3>
Description:<br />
List duplicate systems by Mac Address.
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
           	     struct - Duplicate Group
	<ul>
                   	<li> string "mac"</li>
                       <li>array "systems"
        <ul>
            <li>
                      

	     struct - system
	<ul>
      	<li> int "systemId"</li>
      	<li> string "systemName"</li>
          <li> dateTime.iso8601 "last_checkin" - Last time server
              successfully checked in </li>
 	</ul>
 
                              </li>
        </ul>
    </li>
           	</ul>
      </li></ul>
 
</li></ul>
</code>
<p />
<hr />

<h3> <a name="listExtraPackages" href="#top">Method: listExtraPackages</a></h3>
Description:<br />
List extra packages for a system
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
          	     struct - package
	<ul>
                 	<li> string "name"</li>
                 	<li> string "version"</li>
                 	<li> string "release"</li>
                     <li> string "epoch" - returned only if non-zero </li>
                 	<li> string "arch"</li>
                     <li> date "installtime" - returned only if known </li>
          	</ul>
      </li></ul>
 
</li></ul>
</code>
<p />
<hr />

<h3> <a name="listGroups" href="#top">Method: listGroups</a></h3>
Description:<br />
List the available groups for a given system.
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
      	     struct - system group
	<ul>
              <li> int "id" - server group id </li>
              <li> int "subscribed" - 1 if the given server is subscribed
               to this server group, 0 otherwise </li>
              <li> string "system_group_name" - Name of the server group </li>
              <li> string "sgid" - server group id (Deprecated) </li>
      	</ul>
  </li></ul>
 
</li></ul>
</code>
<p />
<hr />

<h3> <a name="listInactiveSystems" href="#top">Method: listInactiveSystems</a></h3>
Description:<br />
Lists systems that have been inactive for the default period of
          inactivity
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
          

	     struct - system
	<ul>
      	<li> int "id"</li>
      	<li> string "name"</li>
           <li> dateTime.iso8601 "last_checkin" - Last time server
              successfully checked in </li>
           <li> dateTime.iso8601 "last_boot" - Last server boot time </li>
           <li> dateTime.iso8601 "created" - Server registration time </li>

 	</ul>
 
      </li></ul>
 
</li></ul>
</code>
<p />
<hr />

<h3> <a name="listInactiveSystems" href="#top">Method: listInactiveSystems</a></h3>
Description:<br />
Lists systems that have been inactive for the specified
      number of days..
<p />




Parameters:<br />
<ul>
<li>

    string sessionKey
 </li>
<li>

    int days
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
           <li> dateTime.iso8601 "last_checkin" - Last time server
              successfully checked in </li>
           <li> dateTime.iso8601 "last_boot" - Last server boot time </li>
           <li> dateTime.iso8601 "created" - Server registration time </li>

 	</ul>
 
      </li></ul>
 
</li></ul>
</code>
<p />
<hr />

<h3> <a name="listLatestAvailablePackage" href="#top">Method: listLatestAvailablePackage</a></h3>
Description:<br />
Get the latest available version of a package for each system
<p />




Parameters:<br />
<ul>
<li>

    string sessionKey
 </li>
<li>

array:
<ul>
    <li>int - serverId</li>
</ul>
 </li>
<li>

    string packageName
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
                 <li> int "id" - server ID </li>
                 <li> string "name" - server name </li>
                 <li> struct "package" - package structure </li>
                 	     struct - package
	<ul>
                     	<li> int "id"</li>
                     	<li> string "name"</li>
                     	<li> string "version"</li>
                     	<li> string "release"</li>
                     	<li> string "epoch"</li>
                     	<li> string "arch"</li>
                	</ul>
        	</ul>
    </li></ul>
 
</li></ul>
</code>
<p />
<hr />

<h3> <a name="listLatestInstallablePackages" href="#top">Method: listLatestInstallablePackages</a></h3>
Description:<br />
Get the list of latest installable packages for a given system.
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
      	     struct - package
	<ul>
          	<li> string "name"</li>
          	<li> string "version"</li>
          	<li> string "release"</li>
          	<li> string "epoch"</li>
          	<li> int "id"</li>
          	<li> string "arch_label"</li>
      	</ul>
 </li></ul>
 
</li></ul>
</code>
<p />
<hr />

<h3> <a name="listLatestUpgradablePackages" href="#top">Method: listLatestUpgradablePackages</a></h3>
Description:<br />
Get the list of latest upgradable packages for a given system.
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
      	     struct - package
	<ul>
          	<li> string "name"</li>
          	<li> string "arch"</li>
          	<li> string "from_version"</li>
          	<li> string "from_release"</li>
          	<li> string "from_epoch"</li>
          	<li> string "to_version"</li>
          	<li> string "to_release"</li>
          	<li> string "to_epoch"</li>
          	<li> string "to_package_id"</li>
      	</ul>
 </li></ul>
 
</li></ul>
</code>
<p />
<hr />

<h3> <a name="listNewerInstalledPackages" href="#top">Method: listNewerInstalledPackages</a></h3>
Description:<br />
Given a package name, version, release, and epoch, returns the
 list of packages installed on the system w/ the same name that are newer.
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

    string name - Package name.
 </li>
<li>

    string version - Package version.
 </li>
<li>

    string release - Package release.
 </li>
<li>

    string epoch - Package epoch.
 </li>
</ul>
<p />
Returns:
<code><ul><li>


array:
  <ul>
   <li>
          	     struct - package
	<ul>
              	<li> string "name"</li>
              	<li> string "version"</li>
              	<li> string "release"</li>
              	<li> string "epoch"</li>
          	</ul>
      </li></ul>
 
</li></ul>
</code>
<p />
<hr />

<h3> <a name="listNotes" href="#top">Method: listNotes</a></h3>
Description:<br />
Provides a list of notes associated with a system.
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
      

	     struct - note details
	<ul>
   	<li> int "id"</li>
       <li> string "subject" - Subject of the note </li>
       <li> string "note" - Contents of the note </li>
       <li> int "system_id" - The id of the system associated with the note </li>
       <li> string "creator" - Creator of the note if exists (optional) </li>
       <li> date "updated" - Date of the last note update </li>
 	</ul>
 
  </li></ul>
 
</li></ul>
</code>
<p />
<hr />

<h3> <a name="listOlderInstalledPackages" href="#top">Method: listOlderInstalledPackages</a></h3>
Description:<br />
Given a package name, version, release, and epoch, returns
 the list of packages installed on the system with the same name that are
 older.
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

    string name - Package name.
 </li>
<li>

    string version - Package version.
 </li>
<li>

    string release - Package release.
 </li>
<li>

    string epoch - Package epoch.
 </li>
</ul>
<p />
Returns:
<code><ul><li>


array:
  <ul>
   <li>
          	     struct - package
	<ul>
              	<li> string "name"</li>
              	<li> string "version"</li>
              	<li> string "release"</li>
              	<li> string "epoch"</li>
          	</ul>
      </li></ul>
 
</li></ul>
</code>
<p />
<hr />

<h3> <a name="listOutOfDateSystems" href="#top">Method: listOutOfDateSystems</a></h3>
Description:<br />
Returns list of systems needing package updates.
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
              

	     struct - system
	<ul>
      	<li> int "id"</li>
      	<li> string "name"</li>
           <li> dateTime.iso8601 "last_checkin" - Last time server
              successfully checked in </li>
           <li> dateTime.iso8601 "last_boot" - Last server boot time </li>
           <li> dateTime.iso8601 "created" - Server registration time </li>

 	</ul>
 
          </li></ul>
 
</li></ul>
</code>
<p />
<hr />

<h3> <a name="listPackageProfiles" href="#top">Method: listPackageProfiles</a></h3>
Description:<br />
List the package profiles in this organization
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
      

	     struct - package profile
	<ul>
   	<li> int "id"</li>
   	<li> string "name"</li>
   	<li> string "channel"</li>
 	</ul>
 
  </li></ul>
 
</li></ul>
</code>
<p />
<hr />

<h3> <a name="listPackages" href="#top">Method: listPackages</a></h3>
Description:<br />
List the installed packages for a given system. The attribute
 installtime is returned since API version 10.10.
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
          	     struct - package
	<ul>
                 	<li> string "name"</li>
                 	<li> string "version"</li>
                 	<li> string "release"</li>
                 	<li> string "epoch"</li>
                 	<li> string "arch"</li>
                     <li> date "installtime" - returned only if known </li>
          	</ul>
      </li></ul>
 
</li></ul>
</code>
<p />
<hr />

<h3> <a name="listPackagesFromChannel" href="#top">Method: listPackagesFromChannel</a></h3>
Description:<br />
Provides a list of packages installed on a system that are also
          contained in the given channel.  The installed package list did not
          include arch information before RHEL 5, so it is arch unaware.  RHEL 5
          systems do upload the arch information, and thus are arch aware.
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

    string channelLabel
 </li>
</ul>
<p />
Returns:
<code><ul><li>


array:
  <ul>
   <li>
      

	     struct - package
	<ul>
      	<li> string "name"</li>
      	<li> string "version"</li>
      	<li> string "release"</li>
      	<li> string "epoch"</li>
      	<li> int "id"</li>
      	<li> string "arch_label"</li>
          <li> string "path" - The path on that file system that the package
             resides </li>
          <li> string "provider" - The provider of the package, determined by
              the gpg key it was signed with. </li>
      	<li> dateTime.iso8601 "last_modified"</li>
  	</ul>
 
  </li></ul>
 
</li></ul>
</code>
<p />
<hr />

<h3> <a name="listPhysicalSystems" href="#top">Method: listPhysicalSystems</a></h3>
Description:<br />
Returns a list of all Physical servers visible to the user.
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
          

	     struct - system
	<ul>
      	<li> int "id"</li>
      	<li> string "name"</li>
           <li> dateTime.iso8601 "last_checkin" - Last time server
              successfully checked in </li>
           <li> dateTime.iso8601 "last_boot" - Last server boot time </li>
           <li> dateTime.iso8601 "created" - Server registration time </li>

 	</ul>
 
      </li></ul>
 
</li></ul>
</code>
<p />
<hr />

<h3> <a name="listSubscribableBaseChannels" href="#top">Method: listSubscribableBaseChannels</a></h3>
Description:<br />
Returns a list of subscribable base channels.
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
      	     struct - channel
	<ul>
              <li> int "id" - Base Channel ID. </li>
              <li> string "name" - Name of channel. </li>
              <li> string "label" - Label of Channel </li>
              <li> int "current_base" - 1 indicates it is the current base
                                      channel </li>
      	</ul>
  </li></ul>
 
</li></ul>
</code>
<p />
<hr />

<h3> <a name="listSubscribableChildChannels" href="#top">Method: listSubscribableChildChannels</a></h3>
Description:<br />
Returns a list of subscribable child channels.  This only shows channels
 the system is *not* currently subscribed to.
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
          	     struct - child channel
	<ul>
              	<li> int "id"</li>
              	<li> string "name"</li>
              	<li> string "label"</li>
              	<li> string "summary"</li>
              	<li> string "has_license"</li>
              	<li> string "gpg_key_url"</li>
          	</ul>
      </li></ul>
 
</li></ul>
</code>
<p />
<hr />

<h3> <a name="listSubscribedChildChannels" href="#top">Method: listSubscribedChildChannels</a></h3>
Description:<br />
Returns a list of subscribed child channels.
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

<h3> <a name="listSuggestedReboot" href="#top">Method: listSuggestedReboot</a></h3>
Description:<br />
List systems that require reboot.
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

<h3> <a name="listSystemEvents" href="#top">Method: listSystemEvents</a></h3>
Description:<br />
List system actions of the specified type that were *scheduled* against the given server.
 "actionType" should be exactly the string returned in the action_type field
 from the listSystemEvents(sessionKey, serverId) method. For example,
 'Package Install' or 'Initiate a kickstart for a virtual guest.'
 Note: see also system.getEventHistory method which returns a history of all events.
<p />




Parameters:<br />
<ul>
<li>

    string sessionKey
 </li>
<li>

    int serverId - ID of system.
 </li>
<li>

    string actionType - Type of the action.
 </li>
</ul>
<p />
Returns:
<code><ul><li>


array:
  <ul>
   <li>
      	     struct - action
	<ul>
              <li> int "failed_count" - Number of times action failed. </li>
              <li> string "modified" - Date modified. (Deprecated by
                     modified_date) </li>
              <li> dateTime.iso8601 "modified_date" - Date modified. </li>
              <li> string "created" - Date created. (Deprecated by
                     created_date) </li>
              <li> dateTime.iso8601 "created_date" - Date created. </li>
          	<li> string "action_type"</li>
              <li> int "successful_count" - Number of times action was successful. </li>
              <li> string "earliest_action" - Earliest date this action
                     will occur. </li>
              <li> int "archived" - If this action is archived. (1 or 0) </li>
              <li> string "scheduler_user" - available only if concrete user
                     has scheduled the action </li>
              <li> string "prerequisite" - Pre-requisite action. (optional) </li>
              <li> string "name" - Name of this action. </li>
              <li> int "id" - Id of this action. </li>
              <li> string "version" - Version of action. </li>
              <li> string "completion_time" - The date/time the event was
                     completed. Format -&gt;YYYY-MM-dd hh:mm:ss.ms
                     Eg -&gt;2007-06-04 13:58:13.0. (optional)
                     (Deprecated by completed_date) </li>
              <li> dateTime.iso8601 "completed_date" - The date/time the event was completed.
                     (optional) </li>
              <li> string "pickup_time" - The date/time the action was picked
                     up. Format -&gt;YYYY-MM-dd hh:mm:ss.ms
                     Eg -&gt;2007-06-04 13:58:13.0. (optional)
                     (Deprecated by pickup_date) </li>
              <li> dateTime.iso8601 "pickup_date" - The date/time the action was picked up.
                     (optional) </li>
              <li> string "result_msg" - The result string after the action
                     executes at the client machine. (optional) </li>
              <li>array "additional_info" - This array contains additional
              information for the event, if available.
        <ul>
            <li>
              	     struct - info
	<ul>
                      <li> string "detail" - The detail provided depends on the
                  specific event.  For example, for a package event, this will be the
                  package name, for an errata event, this will be the advisory name
                  and synopsis, for a config file event, this will be path and
                  optional revision information...etc. </li>
                      <li> string "result" - The result (if included) depends
                  on the specific event.  For example, for a package or errata event,
                  no result is included, for a config file event, the result might
                  include an error (if one occurred, such as the file was missing)
                  or in the case of a config file comparison it might include the
                  differenes found. </li>
              	</ul>
                     </li>
        </ul>
    </li>
      	</ul>
  </li></ul>
 
</li></ul>
</code>
<p />
Available since: 10.8 <p />
<hr />

<h3> <a name="listSystemEvents" href="#top">Method: listSystemEvents</a></h3>
Description:<br />
List all system actions that were *scheduled* against the given server.
 This may require the caller to filter the result to fetch actions with a specific action type or
 to use the overloaded system.listSystemEvents method with actionType as a parameter.
 Note: see also system.getEventHistory method which returns a history of all events.
<p />




Parameters:<br />
<ul>
<li>

    string sessionKey
 </li>
<li>

    int serverId - ID of system.
 </li>
</ul>
<p />
Returns:
<code><ul><li>


array:
  <ul>
   <li>
      	     struct - action
	<ul>
              <li> int "failed_count" - Number of times action failed. </li>
              <li> string "modified" - Date modified. (Deprecated by
                     modified_date) </li>
              <li> dateTime.iso8601 "modified_date" - Date modified. </li>
              <li> string "created" - Date created. (Deprecated by
                     created_date) </li>
              <li> dateTime.iso8601 "created_date" - Date created. </li>
          	<li> string "action_type"</li>
              <li> int "successful_count" - Number of times action was successful. </li>
              <li> string "earliest_action" - Earliest date this action
                     will occur. </li>
              <li> int "archived" - If this action is archived. (1 or 0) </li>
              <li> string "scheduler_user" - available only if concrete user
                     has scheduled the action </li>
              <li> string "prerequisite" - Pre-requisite action. (optional) </li>
              <li> string "name" - Name of this action. </li>
              <li> int "id" - Id of this action. </li>
              <li> string "version" - Version of action. </li>
              <li> string "completion_time" - The date/time the event was
                     completed. Format -&gt;YYYY-MM-dd hh:mm:ss.ms
                     Eg -&gt;2007-06-04 13:58:13.0. (optional)
                     (Deprecated by completed_date) </li>
              <li> dateTime.iso8601 "completed_date" - The date/time the event was completed.
                     (optional) </li>
              <li> string "pickup_time" - The date/time the action was picked
                     up. Format -&gt;YYYY-MM-dd hh:mm:ss.ms
                     Eg -&gt;2007-06-04 13:58:13.0. (optional)
                     (Deprecated by pickup_date) </li>
              <li> dateTime.iso8601 "pickup_date" - The date/time the action was picked up.
                     (optional) </li>
              <li> string "result_msg" - The result string after the action
                     executes at the client machine. (optional) </li>
              <li>array "additional_info" - This array contains additional
              information for the event, if available.
        <ul>
            <li>
              	     struct - info
	<ul>
                      <li> string "detail" - The detail provided depends on the
                  specific event.  For example, for a package event, this will be the
                  package name, for an errata event, this will be the advisory name
                  and synopsis, for a config file event, this will be path and
                  optional revision information...etc. </li>
                      <li> string "result" - The result (if included) depends
                  on the specific event.  For example, for a package or errata event,
                  no result is included, for a config file event, the result might
                  include an error (if one occurred, such as the file was missing)
                  or in the case of a config file comparison it might include the
                  differenes found. </li>
              	</ul>
                     </li>
        </ul>
    </li>
      	</ul>
  </li></ul>
 
</li></ul>
</code>
<p />
Available since: 10.8 <p />
<hr />

<h3> <a name="listSystems" href="#top">Method: listSystems</a></h3>
Description:<br />
Returns a list of all servers visible to the user.
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
          

	     struct - system
	<ul>
      	<li> int "id"</li>
      	<li> string "name"</li>
           <li> dateTime.iso8601 "last_checkin" - Last time server
              successfully checked in </li>
           <li> dateTime.iso8601 "last_boot" - Last server boot time </li>
           <li> dateTime.iso8601 "created" - Server registration time </li>

 	</ul>
 
      </li></ul>
 
</li></ul>
</code>
<p />
<hr />

<h3> <a name="listSystemsWithExtraPackages" href="#top">Method: listSystemsWithExtraPackages</a></h3>
Description:<br />
List systems with extra packages
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
         	     struct - system
	<ul>
                 <li> int "id" - System ID </li>
                 <li> string "name" - System profile name </li>
                 <li> int "extra_pkg_count" - Extra packages count </li>
         	</ul>
     </li></ul>
 
</li></ul>
</code>
<p />
<hr />

<h3> <a name="listSystemsWithPackage" href="#top">Method: listSystemsWithPackage</a></h3>
Description:<br />
Lists the systems that have the given installed package
<p />




Parameters:<br />
<ul>
<li>

    string sessionKey
 </li>
<li>

    int pid - the package id
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
           <li> dateTime.iso8601 "last_checkin" - Last time server
              successfully checked in </li>
           <li> dateTime.iso8601 "last_boot" - Last server boot time </li>
           <li> dateTime.iso8601 "created" - Server registration time </li>

 	</ul>
 
           </li></ul>
 
</li></ul>
</code>
<p />
<hr />

<h3> <a name="listSystemsWithPackage" href="#top">Method: listSystemsWithPackage</a></h3>
Description:<br />
Lists the systems that have the given installed package
<p />




Parameters:<br />
<ul>
<li>

    string sessionKey
 </li>
<li>

    string name - the package name
 </li>
<li>

    string version - the package version
 </li>
<li>

    string release - the package release
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
           <li> dateTime.iso8601 "last_checkin" - Last time server
              successfully checked in </li>
           <li> dateTime.iso8601 "last_boot" - Last server boot time </li>
           <li> dateTime.iso8601 "created" - Server registration time </li>

 	</ul>
 
              </li></ul>
 
</li></ul>
</code>
<p />
<hr />

<h3> <a name="listUngroupedSystems" href="#top">Method: listUngroupedSystems</a></h3>
Description:<br />
List systems that are not associated with any system groups.
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
          

	     struct - system
	<ul>
      	<li> int "id"</li>
      	<li> string "name"</li>
           <li> dateTime.iso8601 "last_checkin" - Last time server
              successfully checked in </li>
           <li> dateTime.iso8601 "last_boot" - Last server boot time </li>
           <li> dateTime.iso8601 "created" - Server registration time </li>

 	</ul>
 
      </li></ul>
 
</li></ul>
</code>
<p />
<hr />

<h3> <a name="listUserSystems" href="#top">Method: listUserSystems</a></h3>
Description:<br />
List systems for a given user.
<p />




Parameters:<br />
<ul>
<li>

    string sessionKey
 </li>
<li>

    string login - User's login name.
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
           <li> dateTime.iso8601 "last_checkin" - Last time server
              successfully checked in </li>
           <li> dateTime.iso8601 "last_boot" - Last server boot time </li>
           <li> dateTime.iso8601 "created" - Server registration time </li>

 	</ul>
 
          </li></ul>
 
</li></ul>
</code>
<p />
<hr />

<h3> <a name="listUserSystems" href="#top">Method: listUserSystems</a></h3>
Description:<br />
List systems for the logged in user.
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
              

	     struct - system
	<ul>
      	<li> int "id"</li>
      	<li> string "name"</li>
           <li> dateTime.iso8601 "last_checkin" - Last time server
              successfully checked in </li>
           <li> dateTime.iso8601 "last_boot" - Last server boot time </li>
           <li> dateTime.iso8601 "created" - Server registration time </li>

 	</ul>
 
          </li></ul>
 
</li></ul>
</code>
<p />
<hr />

<h3> <a name="listVirtualGuests" href="#top">Method: listVirtualGuests</a></h3>
Description:<br />
Lists the virtual guests for a given virtual host
<p />




Parameters:<br />
<ul>
<li>

    string sessionKey
 </li>
<li>

    int sid - the virtual host's id
 </li>
</ul>
<p />
Returns:
<code><ul><li>


array:
  <ul>
   <li>
          

	     struct - virtual system
	<ul>
      	<li> int "id"</li>
      	<li> string "name"</li>
          <li> string "guest_name" - The virtual guest name as provided
                  by the virtual host </li>
          <li> dateTime.iso8601 "last_checkin" - Last time server successfully
                   checked in. </li>
      	<li> string "uuid"</li>
   	</ul>
 
     </li></ul>
 
</li></ul>
</code>
<p />
<hr />

<h3> <a name="listVirtualHosts" href="#top">Method: listVirtualHosts</a></h3>
Description:<br />
Lists the virtual hosts visible to the user
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
       

	     struct - system
	<ul>
      	<li> int "id"</li>
      	<li> string "name"</li>
           <li> dateTime.iso8601 "last_checkin" - Last time server
              successfully checked in </li>
           <li> dateTime.iso8601 "last_boot" - Last server boot time </li>
           <li> dateTime.iso8601 "created" - Server registration time </li>

 	</ul>
 
      </li></ul>
 
</li></ul>
</code>
<p />
<hr />

<h3> <a name="obtainReactivationKey" href="#top">Method: obtainReactivationKey</a></h3>
Description:<br />
Obtains a reactivation key for this server.
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


string 
 
</li></ul>
</code>
<p />
<hr />

<h3> <a name="obtainReactivationKey" href="#top">Method: obtainReactivationKey</a></h3>
Description:<br />
Obtains a reactivation key for this server.
<p />




Parameters:<br />
<ul>
<li>

    string systemid - systemid file
 </li>
</ul>
<p />
Returns:
<code><ul><li>


string 
 
</li></ul>
</code>
<p />
Available since: 10.10 <p />
<hr />

<h3> <a name="provisionSystem" href="#top">Method: provisionSystem</a></h3>
Description:<br />
Provision a system using the specified kickstart profile.
<p />




Parameters:<br />
<ul>
<li>

    string sessionKey
 </li>
<li>

    int serverId - ID of the system to be provisioned.
 </li>
<li>

    string profileName - Kickstart profile to use.
 </li>
</ul>
<p />
Returns:
<code><ul><li>


int - ID of the action scheduled, otherwise exception thrown
 on error 
 
</li></ul>
</code>
<p />
<hr />

<h3> <a name="provisionSystem" href="#top">Method: provisionSystem</a></h3>
Description:<br />
Provision a system using the specified kickstart profile.
<p />




Parameters:<br />
<ul>
<li>

    string sessionKey
 </li>
<li>

    int serverId - ID of the system to be provisioned.
 </li>
<li>

    string profileName - Kickstart profile to use.
 </li>
<li>

    dateTime.iso8601 earliestDate
 </li>
</ul>
<p />
Returns:
<code><ul><li>


int - ID of the action scheduled, otherwise exception thrown
 on error 
 
</li></ul>
</code>
<p />
<hr />

<h3> <a name="provisionVirtualGuest" href="#top">Method: provisionVirtualGuest</a></h3>
Description:<br />
Provision a guest on the host specified.  Defaults to:
 memory=512MB, vcpu=1, storage=3GB, mac_address=random.
<p />




Parameters:<br />
<ul>
<li>

    string sessionKey
 </li>
<li>

    int serverId - ID of host to provision guest on.
 </li>
<li>

    string guestName
 </li>
<li>

    string profileName - Kickstart profile to use.
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

<h3> <a name="provisionVirtualGuest" href="#top">Method: provisionVirtualGuest</a></h3>
Description:<br />
Provision a guest on the host specified.  This schedules the guest
 for creation and will begin the provisioning process when the host checks in
 or if OSAD is enabled will begin immediately. Defaults to mac_address=random.
<p />




Parameters:<br />
<ul>
<li>

    string sessionKey
 </li>
<li>

    int serverId - ID of host to provision guest on.
 </li>
<li>

    string guestName
 </li>
<li>

    string profileName - Kickstart Profile to use.
 </li>
<li>

    int memoryMb - Memory to allocate to the guest
 </li>
<li>

    int vcpus - Number of virtual CPUs to allocate to
                                          the guest.
 </li>
<li>

    int storageGb - Size of the guests disk image.
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

<h3> <a name="provisionVirtualGuest" href="#top">Method: provisionVirtualGuest</a></h3>
Description:<br />
Provision a guest on the host specified.  This schedules the guest
 for creation and will begin the provisioning process when the host checks in
 or if OSAD is enabled will begin immediately.
<p />




Parameters:<br />
<ul>
<li>

    string sessionKey
 </li>
<li>

    int serverId - ID of host to provision guest on.
 </li>
<li>

    string guestName
 </li>
<li>

    string profileName - Kickstart Profile to use.
 </li>
<li>

    int memoryMb - Memory to allocate to the guest
 </li>
<li>

    int vcpus - Number of virtual CPUs to allocate to
                                          the guest.
 </li>
<li>

    int storageGb - Size of the guests disk image.
 </li>
<li>

    string macAddress - macAddress to give the guest's
                                          virtual networking hardware.
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

<h3> <a name="removeEntitlements" href="#top">Method: removeEntitlements</a></h3>
Description:<br />
Remove addon entitlements from a server. Entitlements a server does
 not have are quietly ignored.
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
    <li>string - entitlement_label</li>
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

<h3> <a name="scheduleApplyErrata" href="#top">Method: scheduleApplyErrata</a></h3>
Description:<br />
Schedules an action to apply errata updates to multiple systems.
<p />




Parameters:<br />
<ul>
<li>

    string sessionKey
 </li>
<li>

array:
<ul>
    <li>int - serverId</li>
</ul>
 </li>
<li>

array:
<ul>
    <li>int - errataId</li>
</ul>
 </li>
</ul>
<p />
Returns:
<code><ul><li>


array:
<ul>
    <li>int - actionId</li>
</ul>
 
</li></ul>
</code>
<p />
Available since: 13.0 <p />
<hr />

<h3> <a name="scheduleApplyErrata" href="#top">Method: scheduleApplyErrata</a></h3>
Description:<br />
Schedules an action to apply errata updates to multiple systems.
<p />




Parameters:<br />
<ul>
<li>

    string sessionKey
 </li>
<li>

array:
<ul>
    <li>int - serverId</li>
</ul>
 </li>
<li>

array:
<ul>
    <li>int - errataId</li>
</ul>
 </li>
<li>

    boolean allowModules - Allow this API call, despite modular content being present
 </li>
</ul>
<p />
Returns:
<code><ul><li>


array:
<ul>
    <li>int - actionId</li>
</ul>
 
</li></ul>
</code>
<p />
Available since: 21 <p />
<hr />

<h3> <a name="scheduleApplyErrata" href="#top">Method: scheduleApplyErrata</a></h3>
Description:<br />
Schedules an action to apply errata updates to multiple systems at a
 given date/time.
<p />




Parameters:<br />
<ul>
<li>

    string sessionKey
 </li>
<li>

array:
<ul>
    <li>int - serverId</li>
</ul>
 </li>
<li>

array:
<ul>
    <li>int - errataId</li>
</ul>
 </li>
<li>

dateTime.iso8601 earliestOccurrence 
 </li>
</ul>
<p />
Returns:
<code><ul><li>


array:
<ul>
    <li>int - actionId</li>
</ul>
 
</li></ul>
</code>
<p />
Available since: 13.0 <p />
<hr />

<h3> <a name="scheduleApplyErrata" href="#top">Method: scheduleApplyErrata</a></h3>
Description:<br />
Schedules an action to apply errata updates to multiple systems at a
 given date/time.
<p />




Parameters:<br />
<ul>
<li>

    string sessionKey
 </li>
<li>

array:
<ul>
    <li>int - serverId</li>
</ul>
 </li>
<li>

array:
<ul>
    <li>int - errataId</li>
</ul>
 </li>
<li>

dateTime.iso8601 earliestOccurrence 
 </li>
<li>

    boolean allowModules - Allow this API call, despite modular content being present
 </li>
</ul>
<p />
Returns:
<code><ul><li>


array:
<ul>
    <li>int - actionId</li>
</ul>
 
</li></ul>
</code>
<p />
Available since: 21 <p />
<hr />

<h3> <a name="scheduleApplyErrata" href="#top">Method: scheduleApplyErrata</a></h3>
Description:<br />
Schedules an action to apply errata updates to a system.
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
    <li>int - errataId</li>
</ul>
 </li>
</ul>
<p />
Returns:
<code><ul><li>


array:
<ul>
    <li>int - actionId</li>
</ul>
 
</li></ul>
</code>
<p />
Available since: 13.0 <p />
<hr />

<h3> <a name="scheduleApplyErrata" href="#top">Method: scheduleApplyErrata</a></h3>
Description:<br />
Schedules an action to apply errata updates to a system.
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
    <li>int - errataId</li>
</ul>
 </li>
<li>

    boolean allowModules - Allow this API call, despite modular content being present
 </li>
</ul>
<p />
Returns:
<code><ul><li>


array:
<ul>
    <li>int - actionId</li>
</ul>
 
</li></ul>
</code>
<p />
Available since: 21 <p />
<hr />

<h3> <a name="scheduleApplyErrata" href="#top">Method: scheduleApplyErrata</a></h3>
Description:<br />
Schedules an action to apply errata updates to a system at a
 given date/time.
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
    <li>int - errataId</li>
</ul>
 </li>
<li>

dateTime.iso8601 earliestOccurrence 
 </li>
</ul>
<p />
Returns:
<code><ul><li>


array:
<ul>
    <li>int - actionId</li>
</ul>
 
</li></ul>
</code>
<p />
Available since: 13.0 <p />
<hr />

<h3> <a name="scheduleApplyErrata" href="#top">Method: scheduleApplyErrata</a></h3>
Description:<br />
Schedules an action to apply errata updates to a system at a
 given date/time.
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
    <li>int - errataId</li>
</ul>
 </li>
<li>

dateTime.iso8601 earliestOccurrence 
 </li>
<li>

    boolean allowModules - Allow this API call, despite modular content being present
 </li>
</ul>
<p />
Returns:
<code><ul><li>


array:
<ul>
    <li>int - actionId</li>
</ul>
 
</li></ul>
</code>
<p />
Available since: 21 <p />
<hr />

<h3> <a name="scheduleCertificateUpdate" href="#top">Method: scheduleCertificateUpdate</a></h3>
Description:<br />
Schedule update of client certificate
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


int actionId - The action id of the scheduled action 
 
</li></ul>
</code>
<p />
<hr />

<h3> <a name="scheduleCertificateUpdate" href="#top">Method: scheduleCertificateUpdate</a></h3>
Description:<br />
Schedule update of client certificate at given date and time
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

    dateTime.iso860 date
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

<h3> <a name="scheduleGuestAction" href="#top">Method: scheduleGuestAction</a></h3>
Description:<br />
Schedules a guest action for the specified virtual guest for a given
          date/time.
<p />




Parameters:<br />
<ul>
<li>

        string sessionKey
 </li>
<li>

    int sid - the system Id of the guest
 </li>
<li>

    string state - One of the following actions  'start',
          'suspend', 'resume', 'restart', 'shutdown'.
 </li>
<li>

    dateTime.iso8601 date - the time/date to schedule the action
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

<h3> <a name="scheduleGuestAction" href="#top">Method: scheduleGuestAction</a></h3>
Description:<br />
Schedules a guest action for the specified virtual guest for the
          current time.
<p />




Parameters:<br />
<ul>
<li>

        string sessionKey
 </li>
<li>

    int sid - the system Id of the guest
 </li>
<li>

    string state - One of the following actions  'start',
          'suspend', 'resume', 'restart', 'shutdown'.
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

<h3> <a name="scheduleHardwareRefresh" href="#top">Method: scheduleHardwareRefresh</a></h3>
Description:<br />
Schedule a hardware refresh for a system.
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

    dateTime.iso8601 earliestOccurrence
 </li>
</ul>
<p />
Returns:
<code><ul><li>


int actionId - The action id of the scheduled action 
 
</li></ul>
</code>
<p />
Available since: 13.0 <p />
<hr />

<h3> <a name="schedulePackageInstall" href="#top">Method: schedulePackageInstall</a></h3>
Description:<br />
Schedule package installation for several systems.
<p />




Parameters:<br />
<ul>
<li>

    string sessionKey
 </li>
<li>

array:
<ul>
    <li>int - serverId</li>
</ul>
 </li>
<li>

array:
<ul>
    <li>int - packageId</li>
</ul>
 </li>
<li>

dateTime.iso8601 earliestOccurrence 
 </li>
</ul>
<p />
Returns:
<code><ul><li>


array:
<ul>
    <li>int - actionId</li>
</ul>
 
</li></ul>
</code>
<p />
<hr />

<h3> <a name="schedulePackageInstall" href="#top">Method: schedulePackageInstall</a></h3>
Description:<br />
Schedule package installation for several systems.
<p />




Parameters:<br />
<ul>
<li>

    string sessionKey
 </li>
<li>

array:
<ul>
    <li>int - serverId</li>
</ul>
 </li>
<li>

array:
<ul>
    <li>int - packageId</li>
</ul>
 </li>
<li>

dateTime.iso8601 earliestOccurrence 
 </li>
<li>

    boolean allowModules - Allow this API call, despite modular content being present
 </li>
</ul>
<p />
Returns:
<code><ul><li>


array:
<ul>
    <li>int - actionId</li>
</ul>
 
</li></ul>
</code>
<p />
Available since: 21 <p />
<hr />

<h3> <a name="schedulePackageInstall" href="#top">Method: schedulePackageInstall</a></h3>
Description:<br />
Schedule package installation for a system.
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
    <li>int - packageId</li>
</ul>
 </li>
<li>

dateTime.iso8601 earliestOccurrence 
 </li>
</ul>
<p />
Returns:
<code><ul><li>


int actionId - The action id of the scheduled action 
 
</li></ul>
</code>
<p />
Available since: 13.0 <p />
<hr />

<h3> <a name="schedulePackageInstall" href="#top">Method: schedulePackageInstall</a></h3>
Description:<br />
Schedule package installation for a system.
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
    <li>int - packageId</li>
</ul>
 </li>
<li>

dateTime.iso8601 earliestOccurrence 
 </li>
<li>

    boolean allowModules - Allow this API call, despite modular content being present
 </li>
</ul>
<p />
Returns:
<code><ul><li>


int actionId - The action id of the scheduled action 
 
</li></ul>
</code>
<p />
Available since: 21 <p />
<hr />

<h3> <a name="schedulePackageInstallByNevra" href="#top">Method: schedulePackageInstallByNevra</a></h3>
Description:<br />
Schedule package installation for several systems.
<p />




Parameters:<br />
<ul>
<li>

    string sessionKey
 </li>
<li>

array:
<ul>
    <li>int - serverId</li>
</ul>
 </li>
<li>

array:
  <ul>
   <li>
                   	     struct - Package nevra
	<ul>
                          	<li> string "package_name"</li>
                          	<li> string "package_epoch"</li>
                          	<li> string "package_version"</li>
                          	<li> string "package_release"</li>
                          	<li> string "package_arch"</li>

                   	</ul>
               </li></ul>
 </li>
<li>

dateTime.iso8601 earliestOccurrence 
 </li>
</ul>
<p />
Returns:
<code><ul><li>


array:
<ul>
    <li>int - actionId</li>
</ul>
 
</li></ul>
</code>
<p />
<hr />

<h3> <a name="schedulePackageInstallByNevra" href="#top">Method: schedulePackageInstallByNevra</a></h3>
Description:<br />
Schedule package installation for several systems.
<p />




Parameters:<br />
<ul>
<li>

    string sessionKey
 </li>
<li>

array:
<ul>
    <li>int - serverId</li>
</ul>
 </li>
<li>

array:
  <ul>
   <li>
                   	     struct - Package nevra
	<ul>
                          	<li> string "package_name"</li>
                          	<li> string "package_epoch"</li>
                          	<li> string "package_version"</li>
                          	<li> string "package_release"</li>
                          	<li> string "package_arch"</li>

                   	</ul>
               </li></ul>
 </li>
<li>

dateTime.iso8601 earliestOccurrence 
 </li>
<li>

    boolean allowModules - Allow this API call, despite modular content being present
 </li>
</ul>
<p />
Returns:
<code><ul><li>


array:
<ul>
    <li>int - actionId</li>
</ul>
 
</li></ul>
</code>
<p />
Available since: 21 <p />
<hr />

<h3> <a name="schedulePackageInstallByNevra" href="#top">Method: schedulePackageInstallByNevra</a></h3>
Description:<br />
Schedule package installation for a system.
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
   <li>
                   	     struct - Package nevra
	<ul>
                          	<li> string "package_name"</li>
                          	<li> string "package_epoch"</li>
                          	<li> string "package_version"</li>
                          	<li> string "package_release"</li>
                          	<li> string "package_arch"</li>

                   	</ul>
               </li></ul>
 </li>
<li>

dateTime.iso8601 earliestOccurrence 
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

<h3> <a name="schedulePackageInstallByNevra" href="#top">Method: schedulePackageInstallByNevra</a></h3>
Description:<br />
Schedule package installation for a system.
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
   <li>
                   	     struct - Package nevra
	<ul>
                          	<li> string "package_name"</li>
                          	<li> string "package_epoch"</li>
                          	<li> string "package_version"</li>
                          	<li> string "package_release"</li>
                          	<li> string "package_arch"</li>

                   	</ul>
               </li></ul>
 </li>
<li>

dateTime.iso8601 earliestOccurrence 
 </li>
<li>

    boolean allowModules - Allow this API call, despite modular content being present
 </li>
</ul>
<p />
Returns:
<code><ul><li>


int actionId - The action id of the scheduled action 
 
</li></ul>
</code>
<p />
Available since: 21 <p />
<hr />

<h3> <a name="schedulePackageRefresh" href="#top">Method: schedulePackageRefresh</a></h3>
Description:<br />
Schedule a package list refresh for a system.
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

    dateTime.iso8601 earliestOccurrence
 </li>
</ul>
<p />
Returns:
<code><ul><li>


int - ID of the action scheduled, otherwise exception thrown
 on error 
 
</li></ul>
</code>
<p />
<hr />

<h3> <a name="schedulePackageRemove" href="#top">Method: schedulePackageRemove</a></h3>
Description:<br />
Schedule package removal for several systems.
<p />




Parameters:<br />
<ul>
<li>

    string sessionKey
 </li>
<li>

array:
<ul>
    <li>int - serverId</li>
</ul>
 </li>
<li>

array:
<ul>
    <li>int - packageId</li>
</ul>
 </li>
<li>

dateTime.iso8601 earliestOccurrence 
 </li>
</ul>
<p />
Returns:
<code><ul><li>


array:
<ul>
    <li>int - actionId</li>
</ul>
 
</li></ul>
</code>
<p />
<hr />

<h3> <a name="schedulePackageRemove" href="#top">Method: schedulePackageRemove</a></h3>
Description:<br />
Schedule package removal for several systems.
<p />




Parameters:<br />
<ul>
<li>

    string sessionKey
 </li>
<li>

array:
<ul>
    <li>int - serverId</li>
</ul>
 </li>
<li>

array:
<ul>
    <li>int - packageId</li>
</ul>
 </li>
<li>

dateTime.iso8601 earliestOccurrence 
 </li>
<li>

    boolean allowModules - Allow this API call, despite modular content being present
 </li>
</ul>
<p />
Returns:
<code><ul><li>


array:
<ul>
    <li>int - actionId</li>
</ul>
 
</li></ul>
</code>
<p />
Available since: 21 <p />
<hr />

<h3> <a name="schedulePackageRemove" href="#top">Method: schedulePackageRemove</a></h3>
Description:<br />
Schedule package removal for a system.
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
    <li>int - packageId</li>
</ul>
 </li>
<li>

dateTime.iso8601 earliestOccurrence 
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

<h3> <a name="schedulePackageRemove" href="#top">Method: schedulePackageRemove</a></h3>
Description:<br />
Schedule package removal for a system.
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
    <li>int - packageId</li>
</ul>
 </li>
<li>

dateTime.iso8601 earliestOccurrence 
 </li>
<li>

    boolean allowModules - Allow this API call, despite modular content being present
 </li>
</ul>
<p />
Returns:
<code><ul><li>


int actionId - The action id of the scheduled action 
 
</li></ul>
</code>
<p />
Available since: 21 <p />
<hr />

<h3> <a name="schedulePackageRemoveByNevra" href="#top">Method: schedulePackageRemoveByNevra</a></h3>
Description:<br />
Schedule package removal for several systems.
<p />




Parameters:<br />
<ul>
<li>

    string sessionKey
 </li>
<li>

array:
<ul>
    <li>int - serverId</li>
</ul>
 </li>
<li>

array:
  <ul>
   <li>
                   	     struct - Package nevra
	<ul>
                          	<li> string "package_name"</li>
                          	<li> string "package_epoch"</li>
                          	<li> string "package_version"</li>
                          	<li> string "package_release"</li>
                          	<li> string "package_arch"</li>

                   	</ul>
               </li></ul>
 </li>
<li>

dateTime.iso8601 earliestOccurrence 
 </li>
</ul>
<p />
Returns:
<code><ul><li>


array:
<ul>
    <li>int - actionId</li>
</ul>
 
</li></ul>
</code>
<p />
<hr />

<h3> <a name="schedulePackageRemoveByNevra" href="#top">Method: schedulePackageRemoveByNevra</a></h3>
Description:<br />
Schedule package removal for several systems.
<p />




Parameters:<br />
<ul>
<li>

    string sessionKey
 </li>
<li>

array:
<ul>
    <li>int - serverId</li>
</ul>
 </li>
<li>

array:
  <ul>
   <li>
                   	     struct - Package nevra
	<ul>
                          	<li> string "package_name"</li>
                          	<li> string "package_epoch"</li>
                          	<li> string "package_version"</li>
                          	<li> string "package_release"</li>
                          	<li> string "package_arch"</li>

                   	</ul>
               </li></ul>
 </li>
<li>

dateTime.iso8601 earliestOccurrence 
 </li>
<li>

    boolean allowModules - Allow this API call, despite modular content being present
 </li>
</ul>
<p />
Returns:
<code><ul><li>


array:
<ul>
    <li>int - actionId</li>
</ul>
 
</li></ul>
</code>
<p />
Available since: 21 <p />
<hr />

<h3> <a name="schedulePackageRemoveByNevra" href="#top">Method: schedulePackageRemoveByNevra</a></h3>
Description:<br />
Schedule package removal for a system.
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
   <li>
                   	     struct - Package nevra
	<ul>
                          	<li> string "package_name"</li>
                          	<li> string "package_epoch"</li>
                          	<li> string "package_version"</li>
                          	<li> string "package_release"</li>
                          	<li> string "package_arch"</li>

                   	</ul>
               </li></ul>
 </li>
<li>

dateTime.iso8601 earliestOccurrence 
 </li>
</ul>
<p />
Returns:
<code><ul><li>


array:
<ul>
    <li>int - actionId</li>
</ul>
 
</li></ul>
</code>
<p />
<hr />

<h3> <a name="schedulePackageRemoveByNevra" href="#top">Method: schedulePackageRemoveByNevra</a></h3>
Description:<br />
Schedule package removal for a system.
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
   <li>
                   	     struct - Package nevra
	<ul>
                          	<li> string "package_name"</li>
                          	<li> string "package_epoch"</li>
                          	<li> string "package_version"</li>
                          	<li> string "package_release"</li>
                          	<li> string "package_arch"</li>

                   	</ul>
               </li></ul>
 </li>
<li>

dateTime.iso8601 earliestOccurrence 
 </li>
<li>

    boolean allowModules - Allow this API call, despite modular content being present
 </li>
</ul>
<p />
Returns:
<code><ul><li>


array:
<ul>
    <li>int - actionId</li>
</ul>
 
</li></ul>
</code>
<p />
Available since: 21 <p />
<hr />

<h3> <a name="scheduleReboot" href="#top">Method: scheduleReboot</a></h3>
Description:<br />
Schedule a reboot for a system.
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

    dateTime.iso860 earliestOccurrence
 </li>
</ul>
<p />
Returns:
<code><ul><li>


int actionId - The action id of the scheduled action 
 
</li></ul>
</code>
<p />
Available since: 13.0 <p />
<hr />

<h3> <a name="scheduleScriptRun" href="#top">Method: scheduleScriptRun</a></h3>
Description:<br />
Schedule a script to run.
<p />




Parameters:<br />
<ul>
<li>

    string sessionKey
 </li>
<li>

    string label
 </li>
<li>

array:
<ul>
    <li>int - System IDs of the servers to run the script on.</li>
</ul>
 </li>
<li>

    string username - User to run script as.
 </li>
<li>

    string groupname - Group to run script as.
 </li>
<li>

    int timeout - Seconds to allow the script to run
before timing out.
 </li>
<li>

    string script - Contents of the script to run.
 </li>
<li>

    dateTime.iso8601 earliestOccurrence - Earliest the script can run.
 </li>
</ul>
<p />
Returns:
<code><ul><li>


int - ID of the script run action created. Can be used to fetch
 results with system.getScriptResults. 
 
</li></ul>
</code>
<p />
<hr />

<h3> <a name="scheduleScriptRun" href="#top">Method: scheduleScriptRun</a></h3>
Description:<br />
Schedule a script to run.
<p />




Parameters:<br />
<ul>
<li>

    string sessionKey
 </li>
<li>

array:
<ul>
    <li>int - System IDs of the servers to run the script on.</li>
</ul>
 </li>
<li>

    string username - User to run script as.
 </li>
<li>

    string groupname - Group to run script as.
 </li>
<li>

    int timeout - Seconds to allow the script to run
before timing out.
 </li>
<li>

    string script - Contents of the script to run.
 </li>
<li>

    dateTime.iso8601 earliestOccurrence - Earliest the script can run.
 </li>
</ul>
<p />
Returns:
<code><ul><li>


int - ID of the script run action created. Can be used to fetch
 results with system.getScriptResults. 
 
</li></ul>
</code>
<p />
<hr />

<h3> <a name="scheduleScriptRun" href="#top">Method: scheduleScriptRun</a></h3>
Description:<br />
Schedule a script to run.
<p />




Parameters:<br />
<ul>
<li>

    string sessionKey
 </li>
<li>

    int serverId - ID of the server to run the script on.
 </li>
<li>

    string username - User to run script as.
 </li>
<li>

    string groupname - Group to run script as.
 </li>
<li>

    int timeout - Seconds to allow the script to run
before timing out.
 </li>
<li>

    string script - Contents of the script to run.
 </li>
<li>

    dateTime.iso8601 earliestOccurrence - Earliest the script can run.
 </li>
</ul>
<p />
Returns:
<code><ul><li>


int - ID of the script run action created. Can be used to fetch
 results with system.getScriptResults. 
 
</li></ul>
</code>
<p />
<hr />

<h3> <a name="scheduleScriptRun" href="#top">Method: scheduleScriptRun</a></h3>
Description:<br />
Schedule a script to run.
<p />




Parameters:<br />
<ul>
<li>

    string sessionKey
 </li>
<li>

    string label
 </li>
<li>

    int serverId - ID of the server to run the script on.
 </li>
<li>

    string username - User to run script as.
 </li>
<li>

    string groupname - Group to run script as.
 </li>
<li>

    int timeout - Seconds to allow the script to run
before timing out.
 </li>
<li>

    string script - Contents of the script to run.
 </li>
<li>

    dateTime.iso8601 earliestOccurrence - Earliest the script can run.
 </li>
</ul>
<p />
Returns:
<code><ul><li>


int - ID of the script run action created. Can be used to fetch
 results with system.getScriptResults. 
 
</li></ul>
</code>
<p />
<hr />

<h3> <a name="scheduleSyncPackagesWithSystem" href="#top">Method: scheduleSyncPackagesWithSystem</a></h3>
Description:<br />
Sync packages from a source system to a target.
<p />




Parameters:<br />
<ul>
<li>

    string sessionKey
 </li>
<li>

    int targetServerId - Target system to apply package
                  changes to.
 </li>
<li>

    int sourceServerId - Source system to retrieve
                  package state from.
 </li>
<li>

array:
<ul>
    <li>int - packageId - Package IDs to be synced.</li>
</ul>
 </li>
<li>

    dateTime.iso8601 date - Date to schedule action for
 </li>
</ul>
<p />
Returns:
<code><ul><li>


int actionId - The action id of the scheduled action 
 
</li></ul>
</code>
<p />
Available since: 13.0 <p />
<hr />

<h3> <a name="searchByName" href="#top">Method: searchByName</a></h3>
Description:<br />
Returns a list of system IDs whose name matches
  the supplied regular expression(defined by
  <a href="http://docs.oracle.com/javase/1.5.0/docs/api/java/util/regex/Pattern.html"
  target="_blank">
 Java representation of regular expressions</a>)
<p />




Parameters:<br />
<ul>
<li>

    string sessionKey
 </li>
<li>

    string regexp - A regular expression
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
           <li> dateTime.iso8601 "last_checkin" - Last time server
              successfully checked in </li>
           <li> dateTime.iso8601 "last_boot" - Last server boot time </li>
           <li> dateTime.iso8601 "created" - Server registration time </li>

 	</ul>
 
          </li></ul>
 
</li></ul>
</code>
<p />
<hr />

<h3> <a name="sendOsaPing" href="#top">Method: sendOsaPing</a></h3>
Description:<br />
send a ping to a system using OSA
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


    int - 1 on success, exception thrown otherwise.
 
</li></ul>
</code>
<p />
<hr />

<h3 class="deprecated"><a name="setBaseChannel" href="#top">Method: setBaseChannel</a></h3>
Description:<br />
Assigns the server to a new baseChannel.
<p />


Deprecated - being replaced by system.setBaseChannel(string sessionKey,
 int serverId, string channelLabel) <p />


Parameters:<br />
<ul>
<li>

    string sessionKey
 </li>
<li>

    int serverId
 </li>
<li>

    int channelId
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

<h3> <a name="setBaseChannel" href="#top">Method: setBaseChannel</a></h3>
Description:<br />
Assigns the server to a new base channel.  If the user provides an empty
 string for the channelLabel, the current base channel and all child channels will
 be removed from the system.
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

    string channelLabel
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
Subscribe the given server to the child channels provided.  This
 method will unsubscribe the server from any child channels that the server
 is currently subscribed to, but that are not included in the list.  The user may
 provide either a list of channel ids (int) or a list of channel labels (string) as
 input.
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
    <li>int (deprecated) or string - channelId (deprecated)
 or channelLabel</li>
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

<h3> <a name="setCustomValues" href="#top">Method: setCustomValues</a></h3>
Description:<br />
Set custom values for the specified server.
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

	     struct - Map of custom labels to custom values
	<ul>
      	<li> string "custom info label"</li>
      	<li> string "value"</li>
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

<h3> <a name="setDetails" href="#top">Method: setDetails</a></h3>
Description:<br />
Set server details. All arguments are optional and will only be modified
 if included in the struct.
<p />




Parameters:<br />
<ul>
<li>

    string sessionKey
 </li>
<li>

    int serverId - ID of server to lookup details for.
 </li>
<li>

	     struct - server details
	<ul>
              <li> string "profile_name" - System's profile name </li>
              <li> string "base_entitlement" - System's base entitlement label.
                      (enterprise_entitled or unentitle) </li>
               <li> boolean "auto_errata_update" - True if system has
                          auto errata updates enabled </li>
               <li> string "description" - System description </li>
               <li> string "address1" - System's address line 1. </li>
               <li> string "address2" - System's address line 2. </li>
           	<li> string "city"</li>
           	<li> string "state"</li>
           	<li> string "country"</li>
           	<li> string "building"</li>
           	<li> string "room"</li>
           	<li> string "rack"</li>
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

<h3> <a name="setGroupMembership" href="#top">Method: setGroupMembership</a></h3>
Description:<br />
Set a servers membership in a given group.
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

    int serverGroupId
 </li>
<li>

    boolean member - '1' to assign the given server to
 the given server group, '0' to remove the given server from the given server
 group.
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

<h3> <a name="setGuestCpus" href="#top">Method: setGuestCpus</a></h3>
Description:<br />
Schedule an action of a guest's host, to set that guest's CPU
          allocation
<p />




Parameters:<br />
<ul>
<li>

        string sessionKey
 </li>
<li>

    int sid - The guest's system id
 </li>
<li>

    int numOfCpus - The number of virtual cpus to
          allocate to the guest
 </li>
</ul>
<p />
Returns:
<code><ul><li>


int actionID - the action Id for the schedule action
              on the host system. 
 
</li></ul>
</code>
<p />
<hr />

<h3> <a name="setGuestMemory" href="#top">Method: setGuestMemory</a></h3>
Description:<br />
Schedule an action of a guest's host, to set that guest's memory
          allocation
<p />




Parameters:<br />
<ul>
<li>

        string sessionKey
 </li>
<li>

    int sid - The guest's system id
 </li>
<li>

    int memory - The amount of memory to
          allocate to the guest
 </li>
</ul>
<p />
Returns:
<code><ul><li>


int actionID - the action Id for the schedule action
              on the host system. 
 
</li></ul>
</code>
<p />
<hr />

<h3> <a name="setLockStatus" href="#top">Method: setLockStatus</a></h3>
Description:<br />
Set server lock status.
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

    boolean lockStatus - true to lock the system,
 false to unlock the system.
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

<h3> <a name="setPrimaryInterface" href="#top">Method: setPrimaryInterface</a></h3>
Description:<br />
Sets new primary network interface
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

    string interfaceName
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

<h3> <a name="setProfileName" href="#top">Method: setProfileName</a></h3>
Description:<br />
Set the profile name for the server.
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

    string name - Name of the profile.
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
Sets a list of kickstart variables in the cobbler system record
 for the specified server.
  Note: This call assumes that a system record exists in cobbler for the
  given system and will raise an XMLRPC fault if that is not the case.
  To create a system record over xmlrpc use system.createSystemRecord

  To create a system record in the Web UI  please go to
  System -&gt; &lt;Specified System&gt; -&gt; Provisioning -&gt;
  Select a Kickstart profile -&gt; Create Cobbler System Record.
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

    boolean netboot
 </li>
<li>

array:
  <ul>
   <li>
          	     struct - kickstart variable
	<ul>
              	<li> string "key"</li>
              	<li> string or int "value"</li>
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

<h3> <a name="tagLatestSnapshot" href="#top">Method: tagLatestSnapshot</a></h3>
Description:<br />
Tags latest system snapshot
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

    string tagName
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

<h3> <a name="unentitle" href="#top">Method: unentitle</a></h3>
Description:<br />
Unentitle the system completely
<p />




Parameters:<br />
<ul>
<li>

    string systemid - systemid file
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

<h3> <a name="upgradeEntitlement" href="#top">Method: upgradeEntitlement</a></h3>
Description:<br />
Adds an entitlement to a given server.
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

    string entitlementName - One of:
          'enterprise_entitled' or 'virtualization_host'.
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

<h3> <a name="whoRegistered" href="#top">Method: whoRegistered</a></h3>
Description:<br />
Returns information about the user who registered the system
<p />




Parameters:<br />
<ul>
<li>

    string sessionKey
 </li>
<li>

    int sid - Id of the system in question
 </li>
</ul>
<p />
Returns:
<code><ul><li>




	     struct - user
	<ul>
              	<li> int "id"</li>
              	<li> string "login"</li>
                  <li> string "login_uc" - upper case version of the login </li>
                  <li> boolean "enabled" - true if user is enabled,
                         false if the user is disabled </li>
      	</ul>
  
 
</li></ul>
</code>
<p />
<hr />
</body>
</html>
