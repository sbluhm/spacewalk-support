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
sync.master
</p>
<p>Contains methods to set up information about known-"masters", for use
 on the "slave" side of ISS</p>
<span class="small-text">( <a href="/rhn/apidoc/index.jsp">Return to API Overview</a> )</span>
<hr />

<div class="rounded-box">
<h2><a name="top">Available methods</a></h2>
<ul class="apidoc">

<li><a href="#addToMaster"/>addToMaster</a></li>
<li><a href="#create"/>create</a></li>
<li><a href="#delete"/>delete</a></li>
<li><a href="#getDefaultMaster"/>getDefaultMaster</a></li>
<li><a href="#getMaster"/>getMaster</a></li>
<li><a href="#getMasterByLabel"/>getMasterByLabel</a></li>
<li><a href="#getMasterOrgs"/>getMasterOrgs</a></li>
<li><a href="#getMasters"/>getMasters</a></li>
<li><a href="#makeDefault"/>makeDefault</a></li>
<li><a href="#mapToLocal"/>mapToLocal</a></li>
<li><a href="#setCaCert"/>setCaCert</a></li>
<li><a href="#setMasterOrgs"/>setMasterOrgs</a></li>
<li><a href="#unsetDefaultMaster"/>unsetDefaultMaster</a></li>
<li><a href="#update"/>update</a></li>
</ul>
</div>
<hr />

<h3> <a name="addToMaster" href="#top">Method: addToMaster</a></h3>
Description:<br />
Add a single organizations to the list of those the specified Master has
 exported to this Slave
<p />




Parameters:<br />
<ul>
<li>

    string sessionKey
 </li>
<li>

    int id - Id of the desired Master
 </li>
<li>

	     struct - master-org details
	<ul>
          	<li> int "masterOrgId"</li>
          	<li> string "masterOrgName"</li>
          	<li> int "localOrgId"</li>
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

<h3> <a name="create" href="#top">Method: create</a></h3>
Description:<br />
Create a new Master, known to this Slave.
<p />




Parameters:<br />
<ul>
<li>

    string sessionKey
 </li>
<li>

    string label - Master's fully-qualified domain name
 </li>
</ul>
<p />
Returns:
<code><ul><li>




	     struct - IssMaster info
	<ul>
   	<li> int "id"</li>
   	<li> string "label"</li>
   	<li> string "caCert"</li>
   	<li> boolean "isCurrentMaster"</li>
 	</ul>
  
 
</li></ul>
</code>
<p />
<hr />

<h3> <a name="delete" href="#top">Method: delete</a></h3>
Description:<br />
Remove the specified Master
<p />




Parameters:<br />
<ul>
<li>

    string sessionKey
 </li>
<li>

    int id - Id of the Master to remove
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

<h3> <a name="getDefaultMaster" href="#top">Method: getDefaultMaster</a></h3>
Description:<br />
Return the current default-Master for this Slave
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




	     struct - IssMaster info
	<ul>
   	<li> int "id"</li>
   	<li> string "label"</li>
   	<li> string "caCert"</li>
   	<li> boolean "isCurrentMaster"</li>
 	</ul>
  
 
</li></ul>
</code>
<p />
<hr />

<h3> <a name="getMaster" href="#top">Method: getMaster</a></h3>
Description:<br />
Find a Master by specifying its ID
<p />




Parameters:<br />
<ul>
<li>

    string sessionKey
 </li>
<li>

    int id - Id of the desired Master
 </li>
</ul>
<p />
Returns:
<code><ul><li>




	     struct - IssMaster info
	<ul>
   	<li> int "id"</li>
   	<li> string "label"</li>
   	<li> string "caCert"</li>
   	<li> boolean "isCurrentMaster"</li>
 	</ul>
  
 
</li></ul>
</code>
<p />
<hr />

<h3> <a name="getMasterByLabel" href="#top">Method: getMasterByLabel</a></h3>
Description:<br />
Find a Master by specifying its label
<p />




Parameters:<br />
<ul>
<li>

    string sessionKey
 </li>
<li>

    string label - Label of the desired Master
 </li>
</ul>
<p />
Returns:
<code><ul><li>




	     struct - IssMaster info
	<ul>
   	<li> int "id"</li>
   	<li> string "label"</li>
   	<li> string "caCert"</li>
   	<li> boolean "isCurrentMaster"</li>
 	</ul>
  
 
</li></ul>
</code>
<p />
<hr />

<h3> <a name="getMasterOrgs" href="#top">Method: getMasterOrgs</a></h3>
Description:<br />
List all organizations the specified Master has exported to this Slave
<p />




Parameters:<br />
<ul>
<li>

    string sessionKey
 </li>
<li>

    int id - Id of the desired Master
 </li>
</ul>
<p />
Returns:
<code><ul><li>


array:
  <ul>
   <li>
     

	     struct - IssMasterOrg info
	<ul>
   	<li> int "masterOrgId"</li>
   	<li> string "masterOrgName"</li>
   	<li> int "localOrgId"</li>
 	</ul>
 
   </li></ul>
 
</li></ul>
</code>
<p />
<hr />

<h3> <a name="getMasters" href="#top">Method: getMasters</a></h3>
Description:<br />
Get all the Masters this Slave knows about
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
          

	     struct - IssMaster info
	<ul>
   	<li> int "id"</li>
   	<li> string "label"</li>
   	<li> string "caCert"</li>
   	<li> boolean "isCurrentMaster"</li>
 	</ul>
 
      </li></ul>
 
</li></ul>
</code>
<p />
<hr />

<h3> <a name="makeDefault" href="#top">Method: makeDefault</a></h3>
Description:<br />
Make the specified Master the default for this Slave's satellite-sync
<p />




Parameters:<br />
<ul>
<li>

    string sessionKey
 </li>
<li>

    int id - Id of the Master to make the default
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

<h3> <a name="mapToLocal" href="#top">Method: mapToLocal</a></h3>
Description:<br />
Add a single organizations to the list of those the specified Master has
 exported to this Slave
<p />




Parameters:<br />
<ul>
<li>

    string sessionKey
 </li>
<li>

    int masterId - Id of the desired Master
 </li>
<li>

    int masterOrgId - Id of the desired Master
 </li>
<li>

    int localOrgId - Id of the desired Master
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

<h3> <a name="setCaCert" href="#top">Method: setCaCert</a></h3>
Description:<br />
Set the CA-CERT filename for specified Master on this Slave
<p />




Parameters:<br />
<ul>
<li>

    string sessionKey
 </li>
<li>

    int id - Id of the Master to affect
 </li>
<li>

    string caCertFilename - path to specified Master's CA cert
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

<h3> <a name="setMasterOrgs" href="#top">Method: setMasterOrgs</a></h3>
Description:<br />
Reset all organizations the specified Master has exported to this Slave
<p />




Parameters:<br />
<ul>
<li>

    string sessionKey
 </li>
<li>

    int id - Id of the desired Master
 </li>
<li>

array:
  <ul>
   <li>
      	     struct - master-org details
	<ul>
          	<li> int "masterOrgId"</li>
          	<li> string "masterOrgName"</li>
          	<li> int "localOrgId"</li>
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

<h3> <a name="unsetDefaultMaster" href="#top">Method: unsetDefaultMaster</a></h3>
Description:<br />
Make this slave have no default Master for satellite-sync
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

<h3> <a name="update" href="#top">Method: update</a></h3>
Description:<br />
Updates the label of the specified Master
<p />




Parameters:<br />
<ul>
<li>

    string sessionKey
 </li>
<li>

    int id - Id of the Master to update
 </li>
<li>

    string label - Desired new label
 </li>
</ul>
<p />
Returns:
<code><ul><li>




	     struct - IssMaster info
	<ul>
   	<li> int "id"</li>
   	<li> string "label"</li>
   	<li> string "caCert"</li>
   	<li> boolean "isCurrentMaster"</li>
 	</ul>
  
 
</li></ul>
</code>
<p />
<hr />
</body>
</html>
