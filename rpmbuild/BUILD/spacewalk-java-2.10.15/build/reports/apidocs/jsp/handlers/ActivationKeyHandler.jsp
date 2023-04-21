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
activationkey
</p>
<p>Contains methods to access common activation key functions
 available from the web interface.</p>
<span class="small-text">( <a href="/rhn/apidoc/index.jsp">Return to API Overview</a> )</span>
<hr />

<div class="rounded-box">
<h2><a name="top">Available methods</a></h2>
<ul class="apidoc">

<li><a href="#addChildChannels"/>addChildChannels</a></li>
<li><a href="#addConfigChannels"/>addConfigChannels</a></li>
<li><a href="#addEntitlements"/>addEntitlements</a></li>
<li><a href="#addPackageNames"/>addPackageNames</a></li>
<li><a href="#addPackages"/>addPackages</a></li>
<li><a href="#addServerGroups"/>addServerGroups</a></li>
<li><a href="#checkConfigDeployment"/>checkConfigDeployment</a></li>
<li><a href="#clone"/>clone</a></li>
<li><a href="#create"/>create</a></li>
<li><a href="#create"/>create</a></li>
<li><a href="#delete"/>delete</a></li>
<li><a href="#disableConfigDeployment"/>disableConfigDeployment</a></li>
<li><a href="#enableConfigDeployment"/>enableConfigDeployment</a></li>
<li><a href="#getDetails"/>getDetails</a></li>
<li><a href="#listActivatedSystems"/>listActivatedSystems</a></li>
<li><a href="#listActivationKeys"/>listActivationKeys</a></li>
<li><a href="#listConfigChannels"/>listConfigChannels</a></li>
<li><a href="#removeChildChannels"/>removeChildChannels</a></li>
<li><a href="#removeConfigChannels"/>removeConfigChannels</a></li>
<li><a href="#removeEntitlements"/>removeEntitlements</a></li>
<li><a href="#removePackageNames"/>removePackageNames</a></li>
<li><a href="#removePackages"/>removePackages</a></li>
<li><a href="#removeServerGroups"/>removeServerGroups</a></li>
<li><a href="#setConfigChannels"/>setConfigChannels</a></li>
<li><a href="#setDetails"/>setDetails</a></li>
</ul>
</div>
<hr />

<h3> <a name="addChildChannels" href="#top">Method: addChildChannels</a></h3>
Description:<br />
Add child channels to an activation key.
<p />




Parameters:<br />
<ul>
<li>

    string sessionKey
 </li>
<li>

    string key
 </li>
<li>

array:
<ul>
    <li>string - childChannelLabel</li>
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

<h3> <a name="addConfigChannels" href="#top">Method: addConfigChannels</a></h3>
Description:<br />
Given a list of activation keys and configuration channels,
 this method adds given configuration channels to either the top or
 the bottom (whichever you specify) of an activation key's
 configuration channels list. The ordering of the configuration channels
 provided in the add list is maintained while adding.
 If one of the configuration channels in the 'add' list
 already exists in an activation key, the
 configuration  channel will be re-ranked to the appropriate place.
<p />




Parameters:<br />
<ul>
<li>

        string sessionKey
 </li>
<li>

array:
<ul>
    <li>string - activationKey</li>
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
          	<li>true - To prepend the given channels to the beginning of
                                 the activation key's config channel list</li>
          	<li>false - To append the given channels to the end of
                                     the activation key's config channel list</li>
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

<h3> <a name="addEntitlements" href="#top">Method: addEntitlements</a></h3>
Description:<br />
Add entitlements to an activation key. Currently only
 virtualization_host add-on entitlement is permitted.
<p />




Parameters:<br />
<ul>
<li>

    string sessionKey
 </li>
<li>

    string key
 </li>
<li>

array:
  <ul>
   <li>string - entitlement label
   	<ul>
     	<li>virtualization_host</li>
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

<h3 class="deprecated"><a name="addPackageNames" href="#top">Method: addPackageNames</a></h3>
Description:<br />
Add packages to an activation key using package name only.
<p />


Deprecated - being replaced by addPackages(string sessionKey, string key,
 array[packages]) <p />


Parameters:<br />
<ul>
<li>

    string sessionKey
 </li>
<li>

    string key
 </li>
<li>

array:
<ul>
    <li>string - packageName</li>
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
Available since: 10.2 <p />
<hr />

<h3> <a name="addPackages" href="#top">Method: addPackages</a></h3>
Description:<br />
Add packages to an activation key.
<p />




Parameters:<br />
<ul>
<li>

    string sessionKey
 </li>
<li>

    string key
 </li>
<li>

array:
  <ul>
   <li>
      	     struct - packages
	<ul>
              <li> string "name" - Package name </li>
              <li> string "arch" - Arch label - Optional </li>
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

<h3> <a name="addServerGroups" href="#top">Method: addServerGroups</a></h3>
Description:<br />
Add server groups to an activation key.
<p />




Parameters:<br />
<ul>
<li>

    string sessionKey
 </li>
<li>

    string key
 </li>
<li>

array:
<ul>
    <li>int - serverGroupId</li>
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

<h3> <a name="checkConfigDeployment" href="#top">Method: checkConfigDeployment</a></h3>
Description:<br />
Check configuration file deployment status for the
 activation key specified.
<p />




Parameters:<br />
<ul>
<li>

    string sessionKey
 </li>
<li>

    string key
 </li>
</ul>
<p />
Returns:
<code><ul><li>


1 if enabled, 0 if disabled, exception thrown otherwise. 
 
</li></ul>
</code>
<p />
<hr />

<h3> <a name="clone" href="#top">Method: clone</a></h3>
Description:<br />
Clone an existing activation key.
<p />




Parameters:<br />
<ul>
<li>

    string sessionKey
 </li>
<li>

    string key - Key to be cloned.
 </li>
<li>

    string cloneDescription - Description of the cloned key.
 </li>
</ul>
<p />
Returns:
<code><ul><li>


string - The new activation key. 
 
</li></ul>
</code>
<p />
<hr />

<h3> <a name="create" href="#top">Method: create</a></h3>
Description:<br />
Create a new activation key.
 The activation key parameter passed
 in will be prefixed with the organization ID, and this value will be
 returned from the create call.

 Eg. If the caller passes in the key "foo" and belong to an organization with
 the ID 100, the actual activation key will be "100-foo".

 This call allows for the setting of a usage limit on this activation key.
 If unlimited usage is desired see the similarly named API method with no
 usage limit argument.
<p />




Parameters:<br />
<ul>
<li>

    string sessionKey
 </li>
<li>

    string key - Leave empty to have new key autogenerated.
 </li>
<li>

    string description
 </li>
<li>

    string baseChannelLabel - Leave empty to accept
 default.
 </li>
<li>

    int usageLimit - If unlimited usage is desired,
 use the create API that does not include the parameter.
 </li>
<li>

array:
  <ul>
   <li>string - Add-on entitlement label to associate with the
 key.
   	<ul>
     	<li>virtualization_host</li>
   	</ul>
 </li></ul>
 </li>
<li>

    boolean universalDefault
 </li>
</ul>
<p />
Returns:
<code><ul><li>


string - The new activation key. 
 
</li></ul>
</code>
<p />
<hr />

<h3> <a name="create" href="#top">Method: create</a></h3>
Description:<br />
Create a new activation key with unlimited usage.
 The activation key parameter passed
 in will be prefixed with the organization ID, and this value will be
 returned from the create call.

 Eg. If the caller passes in the key "foo" and belong to an organization with
 the ID 100, the actual activation key will be "100-foo".
<p />




Parameters:<br />
<ul>
<li>

    string sessionKey
 </li>
<li>

    string key - Leave empty to have new key autogenerated.
 </li>
<li>

    string description
 </li>
<li>

    string baseChannelLabel - Leave empty to accept
 default.
 </li>
<li>

array:
  <ul>
   <li>string - Add-on entitlement label to associate with the
 key.
   	<ul>
     	<li>virtualization_host</li>
   	</ul>
 </li></ul>
 </li>
<li>

    boolean universalDefault
 </li>
</ul>
<p />
Returns:
<code><ul><li>


string - The new activation key. 
 
</li></ul>
</code>
<p />
<hr />

<h3> <a name="delete" href="#top">Method: delete</a></h3>
Description:<br />
Delete an activation key.
<p />




Parameters:<br />
<ul>
<li>

    string sessionKey
 </li>
<li>

    string key
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

<h3> <a name="disableConfigDeployment" href="#top">Method: disableConfigDeployment</a></h3>
Description:<br />
Disable configuration file deployment for the specified activation key.
<p />




Parameters:<br />
<ul>
<li>

    string sessionKey
 </li>
<li>

    string key
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

<h3> <a name="enableConfigDeployment" href="#top">Method: enableConfigDeployment</a></h3>
Description:<br />
Enable configuration file deployment for the specified activation key.
<p />




Parameters:<br />
<ul>
<li>

    string sessionKey
 </li>
<li>

    string key
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
Lookup an activation key's details.
<p />




Parameters:<br />
<ul>
<li>

    string sessionKey
 </li>
<li>

    string key
 </li>
</ul>
<p />
Returns:
<code><ul><li>




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
</code>
<p />
Available since: 10.2 <p />
<hr />

<h3> <a name="listActivatedSystems" href="#top">Method: listActivatedSystems</a></h3>
Description:<br />
List the systems activated with the key provided.
<p />




Parameters:<br />
<ul>
<li>

    string sessionKey
 </li>
<li>

    string key
 </li>
</ul>
<p />
Returns:
<code><ul><li>


array:
  <ul>
   <li>
       	     struct - system structure
	<ul>
               <li> int "id" - System id </li>
           	<li> string "hostname"</li>
               <li> dateTime.iso8601 "last_checkin" - Last time server
               successfully checked in </li>
       	</ul>
   </li></ul>
 
</li></ul>
</code>
<p />
<hr />

<h3> <a name="listActivationKeys" href="#top">Method: listActivationKeys</a></h3>
Description:<br />
List activation keys that are visible to the
 user.
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
 
</li></ul>
</code>
<p />
Available since: 10.2 <p />
<hr />

<h3> <a name="listConfigChannels" href="#top">Method: listConfigChannels</a></h3>
Description:<br />
List configuration channels
 associated to an activation key.
<p />




Parameters:<br />
<ul>
<li>

    string sessionKey
 </li>
<li>

    string key
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

<h3> <a name="removeChildChannels" href="#top">Method: removeChildChannels</a></h3>
Description:<br />
Remove child channels from an activation key.
<p />




Parameters:<br />
<ul>
<li>

    string sessionKey
 </li>
<li>

    string key
 </li>
<li>

array:
<ul>
    <li>string - childChannelLabel</li>
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

<h3> <a name="removeConfigChannels" href="#top">Method: removeConfigChannels</a></h3>
Description:<br />
Remove configuration channels from the given activation keys.
<p />




Parameters:<br />
<ul>
<li>

    string sessionKey 
 </li>
<li>

array:
<ul>
    <li>string - activationKey</li>
</ul>
 </li>
<li>

array:
<ul>
    <li>string - configChannelLabel</li>
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

<h3> <a name="removeEntitlements" href="#top">Method: removeEntitlements</a></h3>
Description:<br />
Remove entitlements (by label) from an activation key.
 Currently only virtualization_host add-on entitlement is permitted.
<p />




Parameters:<br />
<ul>
<li>

    string sessionKey
 </li>
<li>

    string key
 </li>
<li>

array:
  <ul>
   <li>string - entitlement label
   	<ul>
     	<li>virtualization_host</li>
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

<h3 class="deprecated"><a name="removePackageNames" href="#top">Method: removePackageNames</a></h3>
Description:<br />
Remove package names from an activation key.
<p />


Deprecated - being replaced by removePackages(string sessionKey, string key,
 array[packages]) <p />


Parameters:<br />
<ul>
<li>

    string sessionKey
 </li>
<li>

    string key
 </li>
<li>

array:
<ul>
    <li>string - packageName</li>
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
Available since: 10.2 <p />
<hr />

<h3> <a name="removePackages" href="#top">Method: removePackages</a></h3>
Description:<br />
Remove package names from an activation key.
<p />




Parameters:<br />
<ul>
<li>

    string sessionKey
 </li>
<li>

    string key
 </li>
<li>

array:
  <ul>
   <li>
      	     struct - packages
	<ul>
              <li> string "name" - Package name </li>
              <li> string "arch" - Arch label - Optional </li>
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

<h3> <a name="removeServerGroups" href="#top">Method: removeServerGroups</a></h3>
Description:<br />
Remove server groups from an activation key.
<p />




Parameters:<br />
<ul>
<li>

    string sessionKey
 </li>
<li>

    string key
 </li>
<li>

array:
<ul>
    <li>int - serverGroupId</li>
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

<h3> <a name="setConfigChannels" href="#top">Method: setConfigChannels</a></h3>
Description:<br />
Replace the existing set of
 configuration channels on the given activation keys.
 Channels are ranked by their order in the array.
<p />




Parameters:<br />
<ul>
<li>

    string sessionKey 
 </li>
<li>

array:
<ul>
    <li>string - activationKey</li>
</ul>
 </li>
<li>

array:
<ul>
    <li>string - configChannelLabel</li>
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
Update the details of an activation key.
<p />




Parameters:<br />
<ul>
<li>

    string sessionKey
 </li>
<li>

    string key
 </li>
<li>

	     struct - activation key
	<ul>
       <li> string "description" - optional </li>
       <li> string "base_channel_label" - optional -
   to set default base channel set to empty string or 'none' </li>
       <li> int "usage_limit" - optional </li>
       <li> boolean "unlimited_usage_limit" - Set true
   for unlimited usage and to override usage_limit </li>
       <li> boolean "universal_default" - optional </li>
       <li> boolean "disabled" - optional </li>
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
