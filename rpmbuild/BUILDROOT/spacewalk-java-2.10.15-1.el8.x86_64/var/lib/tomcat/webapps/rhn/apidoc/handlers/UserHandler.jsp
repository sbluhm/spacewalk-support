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
user
</p>
<p>User namespace contains methods to access common user functions
 available from the web user interface.</p>
<span class="small-text">( <a href="/rhn/apidoc/index.jsp">Return to API Overview</a> )</span>
<hr />

<div class="rounded-box">
<h2><a name="top">Available methods</a></h2>
<ul class="apidoc">

<li><a href="#addAssignedSystemGroup"/>addAssignedSystemGroup</a></li>
<li><a href="#addAssignedSystemGroups"/>addAssignedSystemGroups</a></li>
<li><a href="#addDefaultSystemGroup"/>addDefaultSystemGroup</a></li>
<li><a href="#addDefaultSystemGroups"/>addDefaultSystemGroups</a></li>
<li><a href="#addRole"/>addRole</a></li>
<li><a href="#create"/>create</a></li>
<li><a href="#create"/>create</a></li>
<li><a href="#delete"/>delete</a></li>
<li><a href="#disable"/>disable</a></li>
<li><a href="#enable"/>enable</a></li>
<li><a href="#getCreateDefaultSystemGroup"/>getCreateDefaultSystemGroup</a></li>
<li><a href="#getDetails"/>getDetails</a></li>
<li><a href="#getLoggedInTime"/>getLoggedInTime</a></li>
<li><a href="#listAssignableRoles"/>listAssignableRoles</a></li>
<li><a href="#listAssignedSystemGroups"/>listAssignedSystemGroups</a></li>
<li><a href="#listDefaultSystemGroups"/>listDefaultSystemGroups</a></li>
<li><a href="#listRoles"/>listRoles</a></li>
<li><a href="#listUsers"/>listUsers</a></li>
<li><a href="#removeAssignedSystemGroup"/>removeAssignedSystemGroup</a></li>
<li><a href="#removeAssignedSystemGroups"/>removeAssignedSystemGroups</a></li>
<li><a href="#removeDefaultSystemGroup"/>removeDefaultSystemGroup</a></li>
<li><a href="#removeDefaultSystemGroups"/>removeDefaultSystemGroups</a></li>
<li><a href="#removeRole"/>removeRole</a></li>
<li><a href="#setCreateDefaultSystemGroup"/>setCreateDefaultSystemGroup</a></li>
<li><a href="#setDetails"/>setDetails</a></li>
<li><a href="#setErrataNotifications"/>setErrataNotifications</a></li>
<li><a href="#setReadOnly"/>setReadOnly</a></li>
<li><a href="#usePamAuthentication"/>usePamAuthentication</a></li>
</ul>
</div>
<hr />

<h3> <a name="addAssignedSystemGroup" href="#top">Method: addAssignedSystemGroup</a></h3>
Description:<br />
Add system group to user's list of assigned system groups.
<p />




Parameters:<br />
<ul>
<li>

    string sessionKey
 </li>
<li>

    string login - User's login name.
 </li>
<li>

    string serverGroupName
 </li>
<li>

    boolean setDefault - Should system group also be
 added to user's list of default system groups.
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

<h3> <a name="addAssignedSystemGroups" href="#top">Method: addAssignedSystemGroups</a></h3>
Description:<br />
Add system groups to user's list of assigned system groups.
<p />




Parameters:<br />
<ul>
<li>

    string sessionKey
 </li>
<li>

    string login - User's login name.
 </li>
<li>

array:
<ul>
    <li>string - serverGroupName</li>
</ul>
 </li>
<li>

    boolean setDefault - Should system groups also be
 added to user's list of default system groups.
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

<h3> <a name="addDefaultSystemGroup" href="#top">Method: addDefaultSystemGroup</a></h3>
Description:<br />
Add system group to user's list of default system groups.
<p />




Parameters:<br />
<ul>
<li>

    string sessionKey
 </li>
<li>

    string login - User's login name.
 </li>
<li>

    string serverGroupName
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

<h3> <a name="addDefaultSystemGroups" href="#top">Method: addDefaultSystemGroups</a></h3>
Description:<br />
Add system groups to user's list of default system groups.
<p />




Parameters:<br />
<ul>
<li>

    string sessionKey
 </li>
<li>

    string login - User's login name.
 </li>
<li>

array:
<ul>
    <li>string - serverGroupName</li>
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

<h3> <a name="addRole" href="#top">Method: addRole</a></h3>
Description:<br />
Adds a role to a user.
<p />




Parameters:<br />
<ul>
<li>

    string sessionKey
 </li>
<li>

    string login - User login name to update.
 </li>
<li>

    string role - Role label to add.  Can be any of:
 satellite_admin, org_admin, channel_admin, config_admin, system_group_admin, or
 activation_key_admin.
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

<h3> <a name="create" href="#top">Method: create</a></h3>
Description:<br />
Create a new user.
<p />




Parameters:<br />
<ul>
<li>

    string sessionKey
 </li>
<li>

    string desiredLogin - Desired login name, will fail if
 already in use.
 </li>
<li>

    string desiredPassword
 </li>
<li>

    string firstName
 </li>
<li>

    string lastName
 </li>
<li>

    string email - User's e-mail address.
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

<h3> <a name="create" href="#top">Method: create</a></h3>
Description:<br />
Create a new user.
<p />




Parameters:<br />
<ul>
<li>

    string sessionKey
 </li>
<li>

    string desiredLogin - Desired login name,
 will fail if already in use.
 </li>
<li>

    string desiredPassword
 </li>
<li>

    string firstName
 </li>
<li>

    string lastName
 </li>
<li>

    string email - User's e-mail address.
 </li>
<li>

    int usePamAuth - 1 if you wish to use PAM
 authentication for this user, 0 otherwise.
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
Delete a user.
<p />




Parameters:<br />
<ul>
<li>

    string sessionKey
 </li>
<li>

    string login - User login name to delete.
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

<h3> <a name="disable" href="#top">Method: disable</a></h3>
Description:<br />
Disable a user.
<p />




Parameters:<br />
<ul>
<li>

    string sessionKey
 </li>
<li>

    string login - User login name to disable.
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

<h3> <a name="enable" href="#top">Method: enable</a></h3>
Description:<br />
Enable a user.
<p />




Parameters:<br />
<ul>
<li>

    string sessionKey
 </li>
<li>

    string login - User login name to enable.
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

<h3> <a name="getCreateDefaultSystemGroup" href="#top">Method: getCreateDefaultSystemGroup</a></h3>
Description:<br />
Returns the current value of the CreateDefaultSystemGroup setting.
 If True this will cause there to be a system group created (with the same name
 as the user) every time a new user is created, with the user automatically given
 permission to that system group and the system group being set as the default
 group for the user (so every time the user registers a system it will be
 placed in that system group by default). This can be useful if different
 users will administer different groups of servers in the same organization.
 Can only be called by an org_admin.
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


    int - 1 on success, exception thrown otherwise.
 
</li></ul>
</code>
<p />
<hr />

<h3> <a name="getDetails" href="#top">Method: getDetails</a></h3>
Description:<br />
Returns the details about a given user.
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


	     struct - user details
	<ul>
         <li> string "first_names" - deprecated, use first_name </li>
     	<li> string "first_name"</li>
     	<li> string "last_name"</li>
     	<li> string "email"</li>
     	<li> int "org_id"</li>
     	<li> string "org_name"</li>
     	<li> string "prefix"</li>
     	<li> string "last_login_date"</li>
     	<li> string "created_date"</li>
         <li> boolean "enabled" - true if user is enabled,
     false if the user is disabled </li>
         <li> boolean "use_pam" - true if user is configured to use
     PAM authentication </li>
         <li> boolean "read_only" - true if user is readonly </li>
         <li> boolean "errata_notification" - true if errata e-mail notification
     is enabled for the user </li>
   	</ul>
 
</li></ul>
</code>
<p />
<hr />

<h3 class="deprecated"><a name="getLoggedInTime" href="#top">Method: getLoggedInTime</a></h3>
Description:<br />
Returns the time user last logged in.
<p />


Deprecated - Never returned usable value. <p />


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


dateTime.iso8601 
 
</li></ul>
</code>
<p />
<hr />

<h3> <a name="listAssignableRoles" href="#top">Method: listAssignableRoles</a></h3>
Description:<br />
Returns a list of user roles that this user can assign to others.
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
    <li>string - (role label)</li>
</ul>
 
</li></ul>
</code>
<p />
<hr />

<h3> <a name="listAssignedSystemGroups" href="#top">Method: listAssignedSystemGroups</a></h3>
Description:<br />
Returns the system groups that a user can administer.
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
     	     struct - system group
	<ul>
       	<li> int "id"</li>
       	<li> string "name"</li>
       	<li> string "description"</li>
       	<li> int "system_count"</li>
           <li> int "org_id" - Organization ID for this system group. </li>
     	</ul>
   </li></ul>
 
</li></ul>
</code>
<p />
<hr />

<h3> <a name="listDefaultSystemGroups" href="#top">Method: listDefaultSystemGroups</a></h3>
Description:<br />
Returns a user's list of default system groups.
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
     	     struct - system group
	<ul>
       	<li> int "id"</li>
       	<li> string "name"</li>
       	<li> string "description"</li>
       	<li> int "system_count"</li>
           <li> int "org_id" - Organization ID for this system group. </li>
     	</ul>
   </li></ul>
 
</li></ul>
</code>
<p />
<hr />

<h3> <a name="listRoles" href="#top">Method: listRoles</a></h3>
Description:<br />
Returns a list of the user's roles.
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
    <li>string - (role label)</li>
</ul>
 
</li></ul>
</code>
<p />
<hr />

<h3> <a name="listUsers" href="#top">Method: listUsers</a></h3>
Description:<br />
Returns a list of users in your organization.
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

<h3> <a name="removeAssignedSystemGroup" href="#top">Method: removeAssignedSystemGroup</a></h3>
Description:<br />
Remove system group from the user's list of assigned system groups.
<p />




Parameters:<br />
<ul>
<li>

    string sessionKey
 </li>
<li>

    string login - User's login name.
 </li>
<li>

    string serverGroupName
 </li>
<li>

    boolean setDefault - Should system group also
 be removed from the user's list of default system groups.
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

<h3> <a name="removeAssignedSystemGroups" href="#top">Method: removeAssignedSystemGroups</a></h3>
Description:<br />
Remove system groups from a user's list of assigned system groups.
<p />




Parameters:<br />
<ul>
<li>

    string sessionKey
 </li>
<li>

    string login - User's login name.
 </li>
<li>

array:
<ul>
    <li>string - serverGroupName</li>
</ul>
 </li>
<li>

    boolean setDefault - Should system groups also be
 removed from the user's list of default system groups.
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

<h3> <a name="removeDefaultSystemGroup" href="#top">Method: removeDefaultSystemGroup</a></h3>
Description:<br />
Remove a system group from user's list of default system groups.
<p />




Parameters:<br />
<ul>
<li>

    string sessionKey
 </li>
<li>

    string login - User's login name.
 </li>
<li>

    string serverGroupName
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

<h3> <a name="removeDefaultSystemGroups" href="#top">Method: removeDefaultSystemGroups</a></h3>
Description:<br />
Remove system groups from a user's list of default system groups.
<p />




Parameters:<br />
<ul>
<li>

    string sessionKey
 </li>
<li>

    string login - User's login name.
 </li>
<li>

array:
<ul>
    <li>string - serverGroupName</li>
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

<h3> <a name="removeRole" href="#top">Method: removeRole</a></h3>
Description:<br />
Remove a role from a user.
<p />




Parameters:<br />
<ul>
<li>

    string sessionKey
 </li>
<li>

    string login - User login name to update.
 </li>
<li>

    string role - Role label to remove.  Can be any of:
 satellite_admin, org_admin, channel_admin, config_admin, system_group_admin, or
 activation_key_admin.
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

<h3> <a name="setCreateDefaultSystemGroup" href="#top">Method: setCreateDefaultSystemGroup</a></h3>
Description:<br />
Sets the value of the CreateDefaultSystemGroup setting.
 If True this will cause there to be a system group created (with the same name
 as the user) every time a new user is created, with the user automatically given
 permission to that system group and the system group being set as the default
 group for the user (so every time the user registers a system it will be
 placed in that system group by default). This can be useful if different
 users will administer different groups of servers in the same organization.
 Can only be called by an org_admin.
<p />




Parameters:<br />
<ul>
<li>

    string sessionKey
 </li>
<li>

    boolean createDefaultSystemGruop - True if we should automatically create system groups, false otherwise.
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
Updates the details of a user.
<p />




Parameters:<br />
<ul>
<li>

    string sessionKey
 </li>
<li>

    string login - User's login name.
 </li>
<li>

	     struct - user details
	<ul>
         <li> string "first_names" - deprecated, use first_name </li>
     	<li> string "first_name"</li>
     	<li> string "last_name"</li>
     	<li> string "email"</li>
     	<li> string "prefix"</li>
     	<li> string "password"</li>
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

<h3> <a name="setErrataNotifications" href="#top">Method: setErrataNotifications</a></h3>
Description:<br />
Enables/disables errata mail notifications for a specific user.
<p />




Parameters:<br />
<ul>
<li>

    string sessionKey
 </li>
<li>

    string login - User's login name.
 </li>
<li>

    boolean value - True for enabling
 errata notifications, False for disabling
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

<h3> <a name="setReadOnly" href="#top">Method: setReadOnly</a></h3>
Description:<br />
Sets whether the target user should have only read-only API access or
 standard full scale access.
<p />




Parameters:<br />
<ul>
<li>

    string sessionKey
 </li>
<li>

    string login - User's login name.
 </li>
<li>

    boolean readOnly - Sets whether the target user should
 have only read-only API access or standard full scale access.
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

<h3> <a name="usePamAuthentication" href="#top">Method: usePamAuthentication</a></h3>
Description:<br />
Toggles whether or not a user uses PAM authentication or
 basic Satellite authentication.
<p />




Parameters:<br />
<ul>
<li>

    string sessionKey
 </li>
<li>

    string login - User's login name.
 </li>
<li>

    int pam_value
   	<ul>
     	<li>1 to enable PAM authentication</li>
     	<li>0 to disable.</li>
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
