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
kickstart.profile.keys
</p>
<p>Provides methods to access and modify the list of activation keys
 associated with a kickstart profile.</p>
<span class="small-text">( <a href="/rhn/apidoc/index.jsp">Return to API Overview</a> )</span>
<hr />

<div class="rounded-box">
<h2><a name="top">Available methods</a></h2>
<ul class="apidoc">

<li><a href="#addActivationKey"/>addActivationKey</a></li>
<li><a href="#getActivationKeys"/>getActivationKeys</a></li>
<li><a href="#removeActivationKey"/>removeActivationKey</a></li>
</ul>
</div>
<hr />

<h3> <a name="addActivationKey" href="#top">Method: addActivationKey</a></h3>
Description:<br />
Add an activation key association to the kickstart profile
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

    string key - the activation key
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

<h3> <a name="getActivationKeys" href="#top">Method: getActivationKeys</a></h3>
Description:<br />
Lookup the activation keys associated with the kickstart
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
<hr />

<h3> <a name="removeActivationKey" href="#top">Method: removeActivationKey</a></h3>
Description:<br />
Remove an activation key association from the kickstart profile
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

    string key - the activation key
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
