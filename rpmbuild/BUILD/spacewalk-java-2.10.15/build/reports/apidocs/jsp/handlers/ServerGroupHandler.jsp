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
systemgroup
</p>
<p>Provides methods to access and modify system groups.</p>
<span class="small-text">( <a href="/rhn/apidoc/index.jsp">Return to API Overview</a> )</span>
<hr />

<div class="rounded-box">
<h2><a name="top">Available methods</a></h2>
<ul class="apidoc">

<li><a href="#addOrRemoveAdmins"/>addOrRemoveAdmins</a></li>
<li><a href="#addOrRemoveSystems"/>addOrRemoveSystems</a></li>
<li><a href="#create"/>create</a></li>
<li><a href="#delete"/>delete</a></li>
<li><a href="#getDetails"/>getDetails</a></li>
<li><a href="#getDetails"/>getDetails</a></li>
<li><a href="#listActiveSystemsInGroup"/>listActiveSystemsInGroup</a></li>
<li><a href="#listAdministrators"/>listAdministrators</a></li>
<li><a href="#listAllGroups"/>listAllGroups</a></li>
<li><a href="#listGroupsWithNoAssociatedAdmins"/>listGroupsWithNoAssociatedAdmins</a></li>
<li><a href="#listInactiveSystemsInGroup"/>listInactiveSystemsInGroup</a></li>
<li><a href="#listInactiveSystemsInGroup"/>listInactiveSystemsInGroup</a></li>
<li><a href="#listSystems"/>listSystems</a></li>
<li><a href="#listSystemsMinimal"/>listSystemsMinimal</a></li>
<li><a href="#scheduleApplyErrataToActive"/>scheduleApplyErrataToActive</a></li>
<li><a href="#scheduleApplyErrataToActive"/>scheduleApplyErrataToActive</a></li>
<li><a href="#update"/>update</a></li>
</ul>
</div>
<hr />

<h3> <a name="addOrRemoveAdmins" href="#top">Method: addOrRemoveAdmins</a></h3>
Description:<br />
Add or remove administrators to/from the given group. Satellite and
 Organization administrators are granted access to groups within their organization
 by default; therefore, users with those roles should not be included in the array
 provided. Caller must be an organization administrator.
<p />




Parameters:<br />
<ul>
<li>

        string sessionKey
 </li>
<li>

    string systemGroupName
 </li>
<li>

array:
<ul>
    <li>string - loginName - User's loginName</li>
</ul>
 </li>
<li>

    int add - 1 to add administrators, 0 to remove.
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

<h3> <a name="addOrRemoveSystems" href="#top">Method: addOrRemoveSystems</a></h3>
Description:<br />
Add/remove the given servers to a system group.
<p />




Parameters:<br />
<ul>
<li>

        string sessionKey
 </li>
<li>

    string systemGroupName
 </li>
<li>

array:
<ul>
    <li>int - serverId</li>
</ul>
 </li>
<li>

    boolean add - True to add to the group,
              False to remove.
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
Create a new system group.
<p />




Parameters:<br />
<ul>
<li>

        string sessionKey
 </li>
<li>

    string name - Name of the system group.
 </li>
<li>

    string description - Description of the
                  system group.
 </li>
</ul>
<p />
Returns:
<code><ul><li>




	     struct - Server Group
	<ul>
          	<li> int "id"</li>
          	<li> string "name"</li>
          	<li> string "description"</li>
          	<li> int "org_id"</li>
          	<li> int "system_count"</li>
      	</ul>
  
 
</li></ul>
</code>
<p />
<hr />

<h3> <a name="delete" href="#top">Method: delete</a></h3>
Description:<br />
Delete a system group.
<p />




Parameters:<br />
<ul>
<li>

        string sessionKey
 </li>
<li>

    string systemGroupName
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
Retrieve details of a ServerGroup based on it's id
<p />




Parameters:<br />
<ul>
<li>

        string sessionKey
 </li>
<li>

    int systemGroupId
 </li>
</ul>
<p />
Returns:
<code><ul><li>




	     struct - Server Group
	<ul>
          	<li> int "id"</li>
          	<li> string "name"</li>
          	<li> string "description"</li>
          	<li> int "org_id"</li>
          	<li> int "system_count"</li>
      	</ul>
  
 
</li></ul>
</code>
<p />
<hr />

<h3> <a name="getDetails" href="#top">Method: getDetails</a></h3>
Description:<br />
Retrieve details of a ServerGroup based on it's name
<p />




Parameters:<br />
<ul>
<li>

        string sessionKey
 </li>
<li>

    string systemGroupName
 </li>
</ul>
<p />
Returns:
<code><ul><li>




	     struct - Server Group
	<ul>
          	<li> int "id"</li>
          	<li> string "name"</li>
          	<li> string "description"</li>
          	<li> int "org_id"</li>
          	<li> int "system_count"</li>
      	</ul>
  
 
</li></ul>
</code>
<p />
<hr />

<h3> <a name="listActiveSystemsInGroup" href="#top">Method: listActiveSystemsInGroup</a></h3>
Description:<br />
Lists active systems within a server group
<p />




Parameters:<br />
<ul>
<li>

        string sessionKey
 </li>
<li>

    string systemGroupName
 </li>
</ul>
<p />
Returns:
<code><ul><li>


array:
<ul>
    <li>int - server_id</li>
</ul>
 
</li></ul>
</code>
<p />
<hr />

<h3> <a name="listAdministrators" href="#top">Method: listAdministrators</a></h3>
Description:<br />
Returns the list of users who can administer the given group.
 Caller must be a system group admin or an organization administrator.
<p />




Parameters:<br />
<ul>
<li>

        string sessionKey
 </li>
<li>

string systemGroupName 
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

<h3> <a name="listAllGroups" href="#top">Method: listAllGroups</a></h3>
Description:<br />
Retrieve a list of system groups that are accessible by the logged
      in user.
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
          

	     struct - Server Group
	<ul>
          	<li> int "id"</li>
          	<li> string "name"</li>
          	<li> string "description"</li>
          	<li> int "org_id"</li>
          	<li> int "system_count"</li>
      	</ul>
 
      </li></ul>
 
</li></ul>
</code>
<p />
<hr />

<h3> <a name="listGroupsWithNoAssociatedAdmins" href="#top">Method: listGroupsWithNoAssociatedAdmins</a></h3>
Description:<br />
Returns a list of system groups that do not have an administrator.
 (who is not an organization administrator, as they have implicit access to
 system groups) Caller must be an organization administrator.
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
          

	     struct - Server Group
	<ul>
          	<li> int "id"</li>
          	<li> string "name"</li>
          	<li> string "description"</li>
          	<li> int "org_id"</li>
          	<li> int "system_count"</li>
      	</ul>
 
      </li></ul>
 
</li></ul>
</code>
<p />
<hr />

<h3> <a name="listInactiveSystemsInGroup" href="#top">Method: listInactiveSystemsInGroup</a></h3>
Description:<br />
Lists inactive systems within a server group using a
          specified inactivity time.
<p />




Parameters:<br />
<ul>
<li>

        string sessionKey
 </li>
<li>

    string systemGroupName
 </li>
<li>

    int daysInactive - Number of days a system
           must not check in to be considered inactive.
 </li>
</ul>
<p />
Returns:
<code><ul><li>


array:
<ul>
    <li>int - server_id</li>
</ul>
 
</li></ul>
</code>
<p />
<hr />

<h3> <a name="listInactiveSystemsInGroup" href="#top">Method: listInactiveSystemsInGroup</a></h3>
Description:<br />
Lists inactive systems within a server group using the default
          1 day threshold.
<p />




Parameters:<br />
<ul>
<li>

        string sessionKey
 </li>
<li>

    string systemGroupName
 </li>
</ul>
<p />
Returns:
<code><ul><li>


array:
<ul>
    <li>int - server_id</li>
</ul>
 
</li></ul>
</code>
<p />
<hr />

<h3> <a name="listSystems" href="#top">Method: listSystems</a></h3>
Description:<br />
Return a list of systems associated with this system group.
 User must have access to this system group.
<p />




Parameters:<br />
<ul>
<li>

        string sessionKey
 </li>
<li>

    string systemGroupName
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
 
</li></ul>
</code>
<p />
<hr />

<h3> <a name="listSystemsMinimal" href="#top">Method: listSystemsMinimal</a></h3>
Description:<br />
Return a list of systems associated with this system group.
 User must have access to this system group.
<p />




Parameters:<br />
<ul>
<li>

        string sessionKey
 </li>
<li>

    string systemGroupName
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

<h3> <a name="scheduleApplyErrataToActive" href="#top">Method: scheduleApplyErrataToActive</a></h3>
Description:<br />
Schedules an action to apply errata updates to active systems
 from a group.
<p />




Parameters:<br />
<ul>
<li>

    string sessionKey
 </li>
<li>

    string systemGroupName
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

<h3> <a name="scheduleApplyErrataToActive" href="#top">Method: scheduleApplyErrataToActive</a></h3>
Description:<br />
Schedules an action to apply errata updates to active systems
 from a group at a given date/time.
<p />




Parameters:<br />
<ul>
<li>

    string sessionKey
 </li>
<li>

    string systemGroupName
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

<h3> <a name="update" href="#top">Method: update</a></h3>
Description:<br />
Update an existing system group.
<p />




Parameters:<br />
<ul>
<li>

        string sessionKey
 </li>
<li>

    string systemGroupName
 </li>
<li>

    string description
 </li>
</ul>
<p />
Returns:
<code><ul><li>




	     struct - Server Group
	<ul>
          	<li> int "id"</li>
          	<li> string "name"</li>
          	<li> string "description"</li>
          	<li> int "org_id"</li>
          	<li> int "system_count"</li>
      	</ul>
  
 
</li></ul>
</code>
<p />
<hr />
</body>
</html>
