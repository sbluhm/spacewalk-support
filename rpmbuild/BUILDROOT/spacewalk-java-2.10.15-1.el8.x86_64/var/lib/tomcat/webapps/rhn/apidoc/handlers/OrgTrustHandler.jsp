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
org.trusts
</p>
<p>Contains methods to access common organization trust information
 available from the web interface.</p>
<span class="small-text">( <a href="/rhn/apidoc/index.jsp">Return to API Overview</a> )</span>
<hr />

<div class="rounded-box">
<h2><a name="top">Available methods</a></h2>
<ul class="apidoc">

<li><a href="#addTrust"/>addTrust</a></li>
<li><a href="#getDetails"/>getDetails</a></li>
<li><a href="#listChannelsConsumed"/>listChannelsConsumed</a></li>
<li><a href="#listChannelsProvided"/>listChannelsProvided</a></li>
<li><a href="#listOrgs"/>listOrgs</a></li>
<li><a href="#listSystemsAffected"/>listSystemsAffected</a></li>
<li><a href="#listTrusts"/>listTrusts</a></li>
<li><a href="#removeTrust"/>removeTrust</a></li>
</ul>
</div>
<hr />

<h3> <a name="addTrust" href="#top">Method: addTrust</a></h3>
Description:<br />
Add an organization to the list of trusted organizations.
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

    int trustOrgId
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
The trust details about an organization given
 the organization's ID.
<p />




Parameters:<br />
<ul>
<li>

    string sessionKey
 </li>
<li>

    int trustOrgId - Id of the trusted organization
 </li>
</ul>
<p />
Returns:
<code><ul><li>


	     struct - org trust details
	<ul>
              <li> dateTime.iso8601 "created" - Date the organization was
          created </li>
              <li> dateTime.iso8601 "trusted_since" - Date the organization was
          defined as trusted </li>
              <li> int "channels_provided" - Number of channels provided by
          the organization. </li>
              <li> int "channels_consumed" - Number of channels consumed by
          the organization. </li>
              <li> int "systems_migrated_to" - Number of systems migrated to
          the organization. </li>
              <li> int "systems_migrated_from" - Number of systems migrated
          from the organization. </li>
     	</ul>
 
</li></ul>
</code>
<p />
<hr />

<h3> <a name="listChannelsConsumed" href="#top">Method: listChannelsConsumed</a></h3>
Description:<br />
Lists all software channels that the organization given may consume
 from the user's organization.
<p />




Parameters:<br />
<ul>
<li>

        string sessionKey
 </li>
<li>

    int trustOrgId - Id of the trusted organization
 </li>
</ul>
<p />
Returns:
<code><ul><li>


array:
  <ul>
   <li>
         	     struct - channel info
	<ul>
             	<li> int "channel_id"</li>
             	<li> string "channel_name"</li>
             	<li> int "packages"</li>
             	<li> int "systems"</li>
         	</ul>
     </li></ul>
 
</li></ul>
</code>
<p />
<hr />

<h3> <a name="listChannelsProvided" href="#top">Method: listChannelsProvided</a></h3>
Description:<br />
Lists all software channels that the organization given is providing to
 the user's organization.
<p />




Parameters:<br />
<ul>
<li>

        string sessionKey
 </li>
<li>

    int trustOrgId - Id of the trusted organization
 </li>
</ul>
<p />
Returns:
<code><ul><li>


array:
  <ul>
   <li>
         	     struct - channel info
	<ul>
             	<li> int "channel_id"</li>
             	<li> string "channel_name"</li>
             	<li> int "packages"</li>
             	<li> int "systems"</li>
         	</ul>
     </li></ul>
 
</li></ul>
</code>
<p />
<hr />

<h3> <a name="listOrgs" href="#top">Method: listOrgs</a></h3>
Description:<br />
List all organanizations trusted by the user's organization.
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
         

	     struct - trusted organizations
	<ul>
       	<li> int "org_id"</li>
       	<li> string "org_name"</li>
       	<li> int "shared_channels"</li>
     	</ul>
 
     </li></ul>
 
</li></ul>
</code>
<p />
<hr />

<h3> <a name="listSystemsAffected" href="#top">Method: listSystemsAffected</a></h3>
Description:<br />
Get a list of systems within the  <i>trusted</i> organization
   that would be affected if the <i>trust</i> relationship was removed.
   This basically lists systems that are sharing at least (1) package.
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

    string trustOrgId
 </li>
</ul>
<p />
Returns:
<code><ul><li>


array:
  <ul>
   <li>
     	     struct - affected systems
	<ul>
       	<li> int "systemId"</li>
       	<li> string "systemName"</li>
     	</ul>
   </li></ul>
 
</li></ul>
</code>
<p />
<hr />

<h3> <a name="listTrusts" href="#top">Method: listTrusts</a></h3>
Description:<br />
Returns the list of trusted organizations.
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
     	     struct - trusted organizations
	<ul>
       	<li> int "orgId"</li>
       	<li> string "orgName"</li>
       	<li> bool "trustEnabled"</li>
     	</ul>
   </li></ul>
  
 
</li></ul>
</code>
<p />
<hr />

<h3> <a name="removeTrust" href="#top">Method: removeTrust</a></h3>
Description:<br />
Remove an organization to the list of trusted organizations.
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

    int trustOrgId
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
