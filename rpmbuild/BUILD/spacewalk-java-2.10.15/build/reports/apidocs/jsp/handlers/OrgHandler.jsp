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
org
</p>
<p>Contains methods to access common organization management
 functions available from the web interface.</p>
<span class="small-text">( <a href="/rhn/apidoc/index.jsp">Return to API Overview</a> )</span>
<hr />

<div class="rounded-box">
<h2><a name="top">Available methods</a></h2>
<ul class="apidoc">

<li><a href="#create"/>create</a></li>
<li><a href="#delete"/>delete</a></li>
<li><a href="#getCrashFileSizeLimit"/>getCrashFileSizeLimit</a></li>
<li><a href="#getDetails"/>getDetails</a></li>
<li><a href="#getDetails"/>getDetails</a></li>
<li><a href="#getPolicyForScapFileUpload"/>getPolicyForScapFileUpload</a></li>
<li><a href="#getPolicyForScapResultDeletion"/>getPolicyForScapResultDeletion</a></li>
<li><a href="#isCrashReportingEnabled"/>isCrashReportingEnabled</a></li>
<li><a href="#isCrashfileUploadEnabled"/>isCrashfileUploadEnabled</a></li>
<li><a href="#isErrataEmailNotifsForOrg"/>isErrataEmailNotifsForOrg</a></li>
<li><a href="#isOrgConfigManagedByOrgAdmin"/>isOrgConfigManagedByOrgAdmin</a></li>
<li><a href="#listOrgs"/>listOrgs</a></li>
<li><a href="#listUsers"/>listUsers</a></li>
<li><a href="#migrateSystems"/>migrateSystems</a></li>
<li><a href="#setCrashFileSizeLimit"/>setCrashFileSizeLimit</a></li>
<li><a href="#setCrashReporting"/>setCrashReporting</a></li>
<li><a href="#setCrashfileUpload"/>setCrashfileUpload</a></li>
<li><a href="#setErrataEmailNotifsForOrg"/>setErrataEmailNotifsForOrg</a></li>
<li><a href="#setOrgConfigManagedByOrgAdmin"/>setOrgConfigManagedByOrgAdmin</a></li>
<li><a href="#setPolicyForScapFileUpload"/>setPolicyForScapFileUpload</a></li>
<li><a href="#setPolicyForScapResultDeletion"/>setPolicyForScapResultDeletion</a></li>
<li><a href="#updateName"/>updateName</a></li>
</ul>
</div>
<hr />

<h3> <a name="create" href="#top">Method: create</a></h3>
Description:<br />
Create a new organization and associated administrator account.
<p />




Parameters:<br />
<ul>
<li>

    string sessionKey
 </li>
<li>

    string orgName - Organization name. Must meet same
 criteria as in the web UI.
 </li>
<li>

    string adminLogin - New administrator login name.
 </li>
<li>

    string adminPassword - New administrator password.
 </li>
<li>

    string prefix - New administrator's prefix. Must
 match one of the values available in the web UI. (i.e. Dr., Mr., Mrs., Sr., etc.)
 </li>
<li>

    string firstName - New administrator's first name.
 </li>
<li>

    string lastName - New administrator's first name.
 </li>
<li>

    string email - New administrator's e-mail.
 </li>
<li>

    boolean usePamAuth - True if PAM authentication
 should be used for the new administrator account.
 </li>
</ul>
<p />
Returns:
<code><ul><li>




	     struct - organization info
	<ul>
   	<li> int "id"</li>
   	<li> string "name"</li>
       <li> int "active_users" - Number of active users in the organization. </li>
       <li> int "systems" - Number of systems in the organization. </li>
       <li> int "trusts" - Number of trusted organizations. </li>
       <li> int "system_groups" - Number of system groups in the organization. (optional) </li>
       <li> int "activation_keys" - Number of activation keys in the organization. (optional) </li>
       <li> int "kickstart_profiles" - Number of kickstart profiles in the organization. (optional) </li>
       <li> int "configuration_channels" - Number of configuration channels in the organization. (optional) </li>
       <li> boolean "staging_content_enabled" - Is staging content enabled in organization. (optional) </li>
 	</ul>
  
 
</li></ul>
</code>
<p />
<hr />

<h3> <a name="delete" href="#top">Method: delete</a></h3>
Description:<br />
Delete an organization. The default organization
 (i.e. orgId=1) cannot be deleted.
<p />




Parameters:<br />
<ul>
<li>

    string sessionKey
 </li>
<li>

    int orgId
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

<h3> <a name="getCrashFileSizeLimit" href="#top">Method: getCrashFileSizeLimit</a></h3>
Description:<br />
Get the organization wide crash file size limit. The limit value
 must be a non-negative number, zero means no limit.
<p />




Parameters:<br />
<ul>
<li>

    string sessionKey
 </li>
<li>

    int orgId
 </li>
</ul>
<p />
Returns:
<code><ul><li>


int - Crash file size limit. 
 
</li></ul>
</code>
<p />
<hr />

<h3> <a name="getDetails" href="#top">Method: getDetails</a></h3>
Description:<br />
The detailed information about an organization given
 the organization ID.
<p />




Parameters:<br />
<ul>
<li>

    string sessionKey
 </li>
<li>

    int orgId
 </li>
</ul>
<p />
Returns:
<code><ul><li>




	     struct - organization info
	<ul>
   	<li> int "id"</li>
   	<li> string "name"</li>
       <li> int "active_users" - Number of active users in the organization. </li>
       <li> int "systems" - Number of systems in the organization. </li>
       <li> int "trusts" - Number of trusted organizations. </li>
       <li> int "system_groups" - Number of system groups in the organization. (optional) </li>
       <li> int "activation_keys" - Number of activation keys in the organization. (optional) </li>
       <li> int "kickstart_profiles" - Number of kickstart profiles in the organization. (optional) </li>
       <li> int "configuration_channels" - Number of configuration channels in the organization. (optional) </li>
       <li> boolean "staging_content_enabled" - Is staging content enabled in organization. (optional) </li>
 	</ul>
  
 
</li></ul>
</code>
<p />
<hr />

<h3> <a name="getDetails" href="#top">Method: getDetails</a></h3>
Description:<br />
The detailed information about an organization given
 the organization name.
<p />




Parameters:<br />
<ul>
<li>

    string sessionKey
 </li>
<li>

    string name
 </li>
</ul>
<p />
Returns:
<code><ul><li>




	     struct - organization info
	<ul>
   	<li> int "id"</li>
   	<li> string "name"</li>
       <li> int "active_users" - Number of active users in the organization. </li>
       <li> int "systems" - Number of systems in the organization. </li>
       <li> int "trusts" - Number of trusted organizations. </li>
       <li> int "system_groups" - Number of system groups in the organization. (optional) </li>
       <li> int "activation_keys" - Number of activation keys in the organization. (optional) </li>
       <li> int "kickstart_profiles" - Number of kickstart profiles in the organization. (optional) </li>
       <li> int "configuration_channels" - Number of configuration channels in the organization. (optional) </li>
       <li> boolean "staging_content_enabled" - Is staging content enabled in organization. (optional) </li>
 	</ul>
  
 
</li></ul>
</code>
<p />
<hr />

<h3> <a name="getPolicyForScapFileUpload" href="#top">Method: getPolicyForScapFileUpload</a></h3>
Description:<br />
Get the status of SCAP detailed result file upload settings
 for the given organization.
<p />




Parameters:<br />
<ul>
<li>

        string sessionKey
 </li>
<li>

    int orgId
 </li>
</ul>
<p />
Returns:
<code><ul><li>


	     struct - scap_upload_info
	<ul>
             <li> boolean "enabled" - Aggregation of detailed SCAP results is enabled. </li>
             <li> int "size_limit" - Limit (in Bytes) for a single SCAP file upload. </li>
     	</ul>
 
</li></ul>
</code>
<p />
<hr />

<h3> <a name="getPolicyForScapResultDeletion" href="#top">Method: getPolicyForScapResultDeletion</a></h3>
Description:<br />
Get the status of SCAP result deletion settings for the given
 organization.
<p />




Parameters:<br />
<ul>
<li>

        string sessionKey
 </li>
<li>

    int orgId
 </li>
</ul>
<p />
Returns:
<code><ul><li>


	     struct - scap_deletion_info
	<ul>
             <li> boolean "enabled" - Deletion of SCAP results is enabled </li>
             <li> int "retention_period" - Period (in days) after which a scan can be deleted (if enabled). </li>
     	</ul>
 
</li></ul>
</code>
<p />
<hr />

<h3> <a name="isCrashReportingEnabled" href="#top">Method: isCrashReportingEnabled</a></h3>
Description:<br />
Get the status of crash reporting settings for the given organization.
 Returns true if enabled, false otherwise.
<p />




Parameters:<br />
<ul>
<li>

    string sessionKey
 </li>
<li>

    int orgId
 </li>
</ul>
<p />
Returns:
<code><ul><li>


boolean - Get the status of crash reporting settings. 
 
</li></ul>
</code>
<p />
<hr />

<h3> <a name="isCrashfileUploadEnabled" href="#top">Method: isCrashfileUploadEnabled</a></h3>
Description:<br />
Get the status of crash file upload settings for the given organization.
 Returns true if enabled, false otherwise.
<p />




Parameters:<br />
<ul>
<li>

    string sessionKey
 </li>
<li>

    int orgId
 </li>
</ul>
<p />
Returns:
<code><ul><li>


boolean - Get the status of crash file upload settings. 
 
</li></ul>
</code>
<p />
<hr />

<h3> <a name="isErrataEmailNotifsForOrg" href="#top">Method: isErrataEmailNotifsForOrg</a></h3>
Description:<br />
Returns whether errata e-mail notifications are enabled
 for the organization
<p />




Parameters:<br />
<ul>
<li>

    string sessionKey
 </li>
<li>

    int orgId
 </li>
</ul>
<p />
Returns:
<code><ul><li>


boolean - Returns the status of the errata e-mail notification
 setting for the organization 
 
</li></ul>
</code>
<p />
<hr />

<h3> <a name="isOrgConfigManagedByOrgAdmin" href="#top">Method: isOrgConfigManagedByOrgAdmin</a></h3>
Description:<br />
Returns whether Organization Administrator is able to manage his
 organization configuration. This organization configuration may have a high impact
 on the whole Spacewalk/Satellite performance
<p />




Parameters:<br />
<ul>
<li>

    string sessionKey
 </li>
<li>

    int orgId
 </li>
</ul>
<p />
Returns:
<code><ul><li>


boolean - Returns the status org admin management setting 
 
</li></ul>
</code>
<p />
<hr />

<h3> <a name="listOrgs" href="#top">Method: listOrgs</a></h3>
Description:<br />
Returns the list of organizations.
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
     

	     struct - organization info
	<ul>
   	<li> int "id"</li>
   	<li> string "name"</li>
       <li> int "active_users" - Number of active users in the organization. </li>
       <li> int "systems" - Number of systems in the organization. </li>
       <li> int "trusts" - Number of trusted organizations. </li>
       <li> int "system_groups" - Number of system groups in the organization. (optional) </li>
       <li> int "activation_keys" - Number of activation keys in the organization. (optional) </li>
       <li> int "kickstart_profiles" - Number of kickstart profiles in the organization. (optional) </li>
       <li> int "configuration_channels" - Number of configuration channels in the organization. (optional) </li>
       <li> boolean "staging_content_enabled" - Is staging content enabled in organization. (optional) </li>
 	</ul>
 
   </li></ul>
 
</li></ul>
</code>
<p />
<hr />

<h3> <a name="listUsers" href="#top">Method: listUsers</a></h3>
Description:<br />
Returns the list of users in a given organization.
<p />




Parameters:<br />
<ul>
<li>

    string sessionKey
 </li>
<li>

    int orgId
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
   	<li> string "login"</li>
   	<li> string "login_uc"</li>
   	<li> string "name"</li>
   	<li> string "email"</li>
   	<li> boolean "is_org_admin"</li>
 	</ul>
 
   </li></ul>
 
</li></ul>
</code>
<p />
<hr />

<h3> <a name="migrateSystems" href="#top">Method: migrateSystems</a></h3>
Description:<br />
Migrate systems from one organization to another.  If executed by
 a Satellite administrator, the systems will be migrated from their current
 organization to the organization specified by the toOrgId.  If executed by
 an organization administrator, the systems must exist in the same organization
 as that administrator and the systems will be migrated to the organization
 specified by the toOrgId. In any scenario, the origination and destination
 organizations must be defined in a trust.
<p />




Parameters:<br />
<ul>
<li>

    string sessionKey
 </li>
<li>

    int toOrgId - ID of the organization where the
 system(s) will be migrated to.
 </li>
<li>

array:
<ul>
    <li>int - systemId</li>
</ul>
 </li>
</ul>
<p />
Returns:
<code><ul><li>


array:
<ul>
    <li>int - serverIdMigrated</li>
</ul>
 
</li></ul>
</code>
<p />
<hr />

<h3> <a name="setCrashFileSizeLimit" href="#top">Method: setCrashFileSizeLimit</a></h3>
Description:<br />
Set the organization wide crash file size limit. The limit value
 must be non-negative, zero means no limit.
<p />




Parameters:<br />
<ul>
<li>

    string sessionKey
 </li>
<li>

    int orgId
 </li>
<li>

    int limit - The limit to set (non-negative value).
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

<h3> <a name="setCrashReporting" href="#top">Method: setCrashReporting</a></h3>
Description:<br />
Set the status of crash reporting settings for the given organization.
 Disabling crash reporting will automatically disable crash file upload.
<p />




Parameters:<br />
<ul>
<li>

    string sessionKey
 </li>
<li>

    int orgId
 </li>
<li>

    boolean enable - Use true/false to enable/disable
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

<h3> <a name="setCrashfileUpload" href="#top">Method: setCrashfileUpload</a></h3>
Description:<br />
Set the status of crash file upload settings for the given organization.
 Modifying the settings is possible as long as crash reporting is enabled.
<p />




Parameters:<br />
<ul>
<li>

    string sessionKey
 </li>
<li>

    int orgId
 </li>
<li>

    boolean enable - Use true/false to enable/disable
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

<h3> <a name="setErrataEmailNotifsForOrg" href="#top">Method: setErrataEmailNotifsForOrg</a></h3>
Description:<br />
Dis/enables errata e-mail notifications for the organization
<p />




Parameters:<br />
<ul>
<li>

    string sessionKey
 </li>
<li>

    int orgId
 </li>
<li>

    boolean enable - Use true/false to enable/disable
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

<h3> <a name="setOrgConfigManagedByOrgAdmin" href="#top">Method: setOrgConfigManagedByOrgAdmin</a></h3>
Description:<br />
Sets whether Organization Administrator can manage his organization
 configuration. This organization configuration may have a high impact
 on the whole Spacewalk/Satellite performance
<p />




Parameters:<br />
<ul>
<li>

    string sessionKey
 </li>
<li>

    int orgId
 </li>
<li>

    boolean enable - Use true/false to enable/disable
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

<h3> <a name="setPolicyForScapFileUpload" href="#top">Method: setPolicyForScapFileUpload</a></h3>
Description:<br />
Set the status of SCAP detailed result file upload settings
 for the given organization.
<p />




Parameters:<br />
<ul>
<li>

        string sessionKey
 </li>
<li>

    int orgId
 </li>
<li>

	     struct - scap_upload_info
	<ul>
             <li> boolean "enabled" - Aggregation of detailed SCAP results is enabled. </li>
             <li> int "size_limit" - Limit (in Bytes) for a single SCAP file upload. </li>
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

<h3> <a name="setPolicyForScapResultDeletion" href="#top">Method: setPolicyForScapResultDeletion</a></h3>
Description:<br />
Set the status of SCAP result deletion settins for the given
 organization.
<p />




Parameters:<br />
<ul>
<li>

        string sessionKey
 </li>
<li>

    int orgId
 </li>
<li>

	     struct - scap_deletion_info
	<ul>
             <li> boolean "enabled" - Deletion of SCAP results is enabled </li>
             <li> int "retention_period" - Period (in days) after which a scan can be deleted (if enabled). </li>
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

<h3> <a name="updateName" href="#top">Method: updateName</a></h3>
Description:<br />
Updates the name of an organization
<p />




Parameters:<br />
<ul>
<li>

    string sessionKey
 </li>
<li>

    int orgId
 </li>
<li>

    string name - Organization name. Must meet same
 criteria as in the web UI.
 </li>
</ul>
<p />
Returns:
<code><ul><li>




	     struct - organization info
	<ul>
   	<li> int "id"</li>
   	<li> string "name"</li>
       <li> int "active_users" - Number of active users in the organization. </li>
       <li> int "systems" - Number of systems in the organization. </li>
       <li> int "trusts" - Number of trusted organizations. </li>
       <li> int "system_groups" - Number of system groups in the organization. (optional) </li>
       <li> int "activation_keys" - Number of activation keys in the organization. (optional) </li>
       <li> int "kickstart_profiles" - Number of kickstart profiles in the organization. (optional) </li>
       <li> int "configuration_channels" - Number of configuration channels in the organization. (optional) </li>
       <li> boolean "staging_content_enabled" - Is staging content enabled in organization. (optional) </li>
 	</ul>
  
 
</li></ul>
</code>
<p />
<hr />
</body>
</html>
