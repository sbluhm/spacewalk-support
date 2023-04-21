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
sync.slave
</p>
<p>Contains methods to set up information about allowed-"slaves", for use
 on the "master" side of ISS</p>
<span class="small-text">( <a href="/rhn/apidoc/index.jsp">Return to API Overview</a> )</span>
<hr />

<div class="rounded-box">
<h2><a name="top">Available methods</a></h2>
<ul class="apidoc">

<li><a href="#create"/>create</a></li>
<li><a href="#delete"/>delete</a></li>
<li><a href="#getAllowedOrgs"/>getAllowedOrgs</a></li>
<li><a href="#getSlave"/>getSlave</a></li>
<li><a href="#getSlaveByName"/>getSlaveByName</a></li>
<li><a href="#getSlaves"/>getSlaves</a></li>
<li><a href="#setAllowedOrgs"/>setAllowedOrgs</a></li>
<li><a href="#update"/>update</a></li>
</ul>
</div>
<hr />

<h3> <a name="create" href="#top">Method: create</a></h3>
Description:<br />
Create a new Slave, known to this Master.
<p />




Parameters:<br />
<ul>
<li>

    string sessionKey
 </li>
<li>

    string slave - Slave's fully-qualified domain name
 </li>
<li>

    boolean enabled - Let this slave talk to us?
 </li>
<li>

    boolean allowAllOrgs - Export all our orgs to this slave?
 </li>
</ul>
<p />
Returns:
<code><ul><li>




	     struct - IssSlave info
	<ul>
   	<li> int "id"</li>
   	<li> string "slave"</li>
   	<li> boolean "enabled"</li>
   	<li> boolean "allowAllOrgs"</li>
 	</ul>
  
 
</li></ul>
</code>
<p />
<hr />

<h3> <a name="delete" href="#top">Method: delete</a></h3>
Description:<br />
Remove the specified Slave
<p />




Parameters:<br />
<ul>
<li>

    string sessionKey
 </li>
<li>

    int id - Id of the Slave to remove
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

<h3> <a name="getAllowedOrgs" href="#top">Method: getAllowedOrgs</a></h3>
Description:<br />
Get all orgs this Master is willing to export to the specified Slave
<p />




Parameters:<br />
<ul>
<li>

    string sessionKey
 </li>
<li>

    int id - Id of the desired Slave
 </li>
</ul>
<p />
Returns:
<code><ul><li>


array:
<ul>
    <li>int - ids of allowed organizations</li>
</ul>
 
</li></ul>
</code>
<p />
<hr />

<h3> <a name="getSlave" href="#top">Method: getSlave</a></h3>
Description:<br />
Find a Slave by specifying its ID
<p />




Parameters:<br />
<ul>
<li>

    string sessionKey
 </li>
<li>

    int id - Id of the desired Slave
 </li>
</ul>
<p />
Returns:
<code><ul><li>




	     struct - IssSlave info
	<ul>
   	<li> int "id"</li>
   	<li> string "slave"</li>
   	<li> boolean "enabled"</li>
   	<li> boolean "allowAllOrgs"</li>
 	</ul>
  
 
</li></ul>
</code>
<p />
<hr />

<h3> <a name="getSlaveByName" href="#top">Method: getSlaveByName</a></h3>
Description:<br />
Find a Slave by specifying its Fully-Qualified Domain Name
<p />




Parameters:<br />
<ul>
<li>

    string sessionKey
 </li>
<li>

    string fqdn - Domain-name of the desired Slave
 </li>
</ul>
<p />
Returns:
<code><ul><li>




	     struct - IssSlave info
	<ul>
   	<li> int "id"</li>
   	<li> string "slave"</li>
   	<li> boolean "enabled"</li>
   	<li> boolean "allowAllOrgs"</li>
 	</ul>
  
 
</li></ul>
</code>
<p />
<hr />

<h3> <a name="getSlaves" href="#top">Method: getSlaves</a></h3>
Description:<br />
Get all the Slaves this Master knows about
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
          

	     struct - IssSlave info
	<ul>
   	<li> int "id"</li>
   	<li> string "slave"</li>
   	<li> boolean "enabled"</li>
   	<li> boolean "allowAllOrgs"</li>
 	</ul>
 
      </li></ul>
 
</li></ul>
</code>
<p />
<hr />

<h3> <a name="setAllowedOrgs" href="#top">Method: setAllowedOrgs</a></h3>
Description:<br />
Set the orgs this Master is willing to export to the specified Slave
<p />




Parameters:<br />
<ul>
<li>

    string sessionKey
 </li>
<li>

    int id - Id of the desired Slave
 </li>
<li>

array:
<ul>
    <li>int - List of org-ids we're willing to export</li>
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

<h3> <a name="update" href="#top">Method: update</a></h3>
Description:<br />
Updates attributes of the specified Slave
<p />




Parameters:<br />
<ul>
<li>

    string sessionKey
 </li>
<li>

    int id - Id of the Slave to update
 </li>
<li>

    string slave - Slave's fully-qualified domain name
 </li>
<li>

    boolean enabled - Let this slave talk to us?
 </li>
<li>

    boolean allowAllOrgs - Export all our orgs to this Slave?
 </li>
</ul>
<p />
Returns:
<code><ul><li>




	     struct - IssSlave info
	<ul>
   	<li> int "id"</li>
   	<li> string "slave"</li>
   	<li> boolean "enabled"</li>
   	<li> boolean "allowAllOrgs"</li>
 	</ul>
  
 
</li></ul>
</code>
<p />
<hr />
</body>
</html>
