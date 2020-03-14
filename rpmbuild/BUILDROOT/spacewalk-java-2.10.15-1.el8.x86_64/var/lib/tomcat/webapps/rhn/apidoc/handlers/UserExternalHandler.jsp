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
user.external
</p>
<p>If you are using IPA integration to allow authentication of users from
 an external IPA server (rare) the users will still need to be created in the Satellite
 database. Methods in this namespace allow you to configure some specifics of how this
 happens, like what organization they are created in or what roles they will have.
 These options can also be set in the web admin interface.</p>
<span class="small-text">( <a href="/rhn/apidoc/index.jsp">Return to API Overview</a> )</span>
<hr />

<div class="rounded-box">
<h2><a name="top">Available methods</a></h2>
<ul class="apidoc">

<li><a href="#createExternalGroupToRoleMap"/>createExternalGroupToRoleMap</a></li>
<li><a href="#createExternalGroupToSystemGroupMap"/>createExternalGroupToSystemGroupMap</a></li>
<li><a href="#deleteExternalGroupToRoleMap"/>deleteExternalGroupToRoleMap</a></li>
<li><a href="#deleteExternalGroupToSystemGroupMap"/>deleteExternalGroupToSystemGroupMap</a></li>
<li><a href="#getDefaultOrg"/>getDefaultOrg</a></li>
<li><a href="#getExternalGroupToRoleMap"/>getExternalGroupToRoleMap</a></li>
<li><a href="#getExternalGroupToSystemGroupMap"/>getExternalGroupToSystemGroupMap</a></li>
<li><a href="#getKeepTemporaryRoles"/>getKeepTemporaryRoles</a></li>
<li><a href="#getUseOrgUnit"/>getUseOrgUnit</a></li>
<li><a href="#listExternalGroupToRoleMaps"/>listExternalGroupToRoleMaps</a></li>
<li><a href="#listExternalGroupToSystemGroupMaps"/>listExternalGroupToSystemGroupMaps</a></li>
<li><a href="#setDefaultOrg"/>setDefaultOrg</a></li>
<li><a href="#setExternalGroupRoles"/>setExternalGroupRoles</a></li>
<li><a href="#setExternalGroupSystemGroups"/>setExternalGroupSystemGroups</a></li>
<li><a href="#setKeepTemporaryRoles"/>setKeepTemporaryRoles</a></li>
<li><a href="#setUseOrgUnit"/>setUseOrgUnit</a></li>
</ul>
</div>
<hr />

<h3> <a name="createExternalGroupToRoleMap" href="#top">Method: createExternalGroupToRoleMap</a></h3>
Description:<br />
Externally authenticated users may be members of external groups. You
 can use these groups to assign additional roles to the users when they log in.
 Can only be called by a satellite_admin.
<p />




Parameters:<br />
<ul>
<li>

    string sessionKey
 </li>
<li>

    string name - Name of the external group. Must be
 unique.
 </li>
<li>

array:
<ul>
    <li>string - role - Can be any of:
 satellite_admin, org_admin (implies all other roles except for satellite_admin),
 channel_admin, config_admin, system_group_admin, or
 activation_key_admin.</li>
</ul>
 </li>
</ul>
<p />
Returns:
<code><ul><li>




	     struct - externalGroup
	<ul>
      	<li> string "name"</li>
          <li>array "roles"
        <ul>
            <li>string role</li>
        </ul>
    </li>
  	</ul>
  
 
</li></ul>
</code>
<p />
<hr />

<h3> <a name="createExternalGroupToSystemGroupMap" href="#top">Method: createExternalGroupToSystemGroupMap</a></h3>
Description:<br />
Externally authenticated users may be members of external groups. You
 can use these groups to give access to server groups to the users when they log in.
 Can only be called by an org_admin.
<p />




Parameters:<br />
<ul>
<li>

    string sessionKey
 </li>
<li>

    string name - Name of the external group. Must be
 unique.
 </li>
<li>

array:
<ul>
    <li>string - groupName - The names of the server
 groups to grant access to.</li>
</ul>
 </li>
</ul>
<p />
Returns:
<code><ul><li>




	     struct - externalGroup
	<ul>
      	<li> string "name"</li>
          <li>array "roles"
        <ul>
            <li>string role</li>
        </ul>
    </li>
  	</ul>
  
 
</li></ul>
</code>
<p />
<hr />

<h3> <a name="deleteExternalGroupToRoleMap" href="#top">Method: deleteExternalGroupToRoleMap</a></h3>
Description:<br />
Delete the role map for an external group. Can only be called
 by a satellite_admin.
<p />




Parameters:<br />
<ul>
<li>

    string sessionKey
 </li>
<li>

    string name - Name of the external group.
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

<h3> <a name="deleteExternalGroupToSystemGroupMap" href="#top">Method: deleteExternalGroupToSystemGroupMap</a></h3>
Description:<br />
Delete the server group map for an external group. Can only be called
 by an org_admin.
<p />




Parameters:<br />
<ul>
<li>

    string sessionKey
 </li>
<li>

    string name - Name of the external group.
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

<h3> <a name="getDefaultOrg" href="#top">Method: getDefaultOrg</a></h3>
Description:<br />
Get the default org that users should be added in if orgunit from
 IPA server isn't found or is disabled. Can only be called by a satellite_admin.
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


int - Id of the default organization. 0 if there is no default. 
 
</li></ul>
</code>
<p />
<hr />

<h3> <a name="getExternalGroupToRoleMap" href="#top">Method: getExternalGroupToRoleMap</a></h3>
Description:<br />
Get a representation of the role mapping for an external group.
 Can only be called by a satellite_admin.
<p />




Parameters:<br />
<ul>
<li>

    string sessionKey
 </li>
<li>

    string name - Name of the external group.
 </li>
</ul>
<p />
Returns:
<code><ul><li>




	     struct - externalGroup
	<ul>
      	<li> string "name"</li>
          <li>array "roles"
        <ul>
            <li>string role</li>
        </ul>
    </li>
  	</ul>
  
 
</li></ul>
</code>
<p />
<hr />

<h3> <a name="getExternalGroupToSystemGroupMap" href="#top">Method: getExternalGroupToSystemGroupMap</a></h3>
Description:<br />
Get a representation of the server group mapping for an external
 group. Can only be called by an org_admin.
<p />




Parameters:<br />
<ul>
<li>

    string sessionKey
 </li>
<li>

    string name - Name of the external group.
 </li>
</ul>
<p />
Returns:
<code><ul><li>




	     struct - externalGroup
	<ul>
      	<li> string "name"</li>
          <li>array "roles"
        <ul>
            <li>string role</li>
        </ul>
    </li>
  	</ul>
  
 
</li></ul>
</code>
<p />
<hr />

<h3> <a name="getKeepTemporaryRoles" href="#top">Method: getKeepTemporaryRoles</a></h3>
Description:<br />
Get whether we should keeps roles assigned to users because of
 their IPA groups even after they log in through a non-IPA method. Can only be
 called by a satellite_admin.
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


boolean - True if we should keep roles
 after users log in through non-IPA method, false otherwise. 
 
</li></ul>
</code>
<p />
<hr />

<h3> <a name="getUseOrgUnit" href="#top">Method: getUseOrgUnit</a></h3>
Description:<br />
Get whether we place users into the organization that corresponds
 to the "orgunit" set on the IPA server. The orgunit name must match exactly the
 Satellite organization name. Can only be called by a satellite_admin.
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


boolean - True if we should use the IPA
 orgunit to determine which organization to create the user in, false otherwise. 
 
</li></ul>
</code>
<p />
<hr />

<h3> <a name="listExternalGroupToRoleMaps" href="#top">Method: listExternalGroupToRoleMaps</a></h3>
Description:<br />
List role mappings for all known external groups. Can only be called
 by a satellite_admin.
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
     

	     struct - externalGroup
	<ul>
      	<li> string "name"</li>
          <li>array "roles"
        <ul>
            <li>string role</li>
        </ul>
    </li>
  	</ul>
 
 </li></ul>
 
</li></ul>
</code>
<p />
<hr />

<h3> <a name="listExternalGroupToSystemGroupMaps" href="#top">Method: listExternalGroupToSystemGroupMaps</a></h3>
Description:<br />
List server group mappings for all known external groups. Can only be
 called by an org_admin.
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
     

	     struct - externalGroup
	<ul>
      	<li> string "name"</li>
          <li>array "roles"
        <ul>
            <li>string role</li>
        </ul>
    </li>
  	</ul>
 
 </li></ul>
 
</li></ul>
</code>
<p />
<hr />

<h3> <a name="setDefaultOrg" href="#top">Method: setDefaultOrg</a></h3>
Description:<br />
Set the default org that users should be added in if orgunit from
 IPA server isn't found or is disabled. Can only be called by a satellite_admin.
<p />




Parameters:<br />
<ul>
<li>

    string sessionKey
 </li>
<li>

    int defaultOrg - Id of the organization to set
 as the default org. 0 if there should not be a default organization.
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

<h3> <a name="setExternalGroupRoles" href="#top">Method: setExternalGroupRoles</a></h3>
Description:<br />
Update the roles for an external group. Replace previously set roles
 with the ones passed in here. Can only be called by a satellite_admin.
<p />




Parameters:<br />
<ul>
<li>

    string sessionKey
 </li>
<li>

    string name - Name of the external group.
 </li>
<li>

array:
<ul>
    <li>string - role - Can be any of:
 satellite_admin, org_admin (implies all other roles except for satellite_admin),
 channel_admin, config_admin, system_group_admin, or
 activation_key_admin.</li>
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

<h3> <a name="setExternalGroupSystemGroups" href="#top">Method: setExternalGroupSystemGroups</a></h3>
Description:<br />
Update the server groups for an external group. Replace previously set
 server groups with the ones passed in here. Can only be called by an org_admin.
<p />




Parameters:<br />
<ul>
<li>

    string sessionKey
 </li>
<li>

    string name - Name of the external group.
 </li>
<li>

array:
<ul>
    <li>string - groupName - The names of the
 server groups to grant access to.</li>
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

<h3> <a name="setKeepTemporaryRoles" href="#top">Method: setKeepTemporaryRoles</a></h3>
Description:<br />
Set whether we should keeps roles assigned to users because of
 their IPA groups even after they log in through a non-IPA method. Can only be
 called by a satellite_admin.
<p />




Parameters:<br />
<ul>
<li>

    string sessionKey
 </li>
<li>

    boolean keepRoles - True if we should keep roles
 after users log in through non-IPA method, false otherwise.
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

<h3> <a name="setUseOrgUnit" href="#top">Method: setUseOrgUnit</a></h3>
Description:<br />
Set whether we place users into the organization that corresponds
 to the "orgunit" set on the IPA server. The orgunit name must match exactly the
 Satellite organization name. Can only be called by a satellite_admin.
<p />




Parameters:<br />
<ul>
<li>

    string sessionKey
 </li>
<li>

    boolean useOrgUnit - True if we should use the IPA
 orgunit to determine which organization to create the user in, false otherwise.
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
