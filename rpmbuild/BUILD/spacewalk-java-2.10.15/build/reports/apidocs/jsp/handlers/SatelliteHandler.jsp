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
satellite
</p>
<p>Provides methods to obtain details on the Satellite.</p>
<span class="small-text">( <a href="/rhn/apidoc/index.jsp">Return to API Overview</a> )</span>
<hr />

<div class="rounded-box">
<h2><a name="top">Available methods</a></h2>
<ul class="apidoc">

<li><a href="#isMonitoringEnabled"/>isMonitoringEnabled</a></li>
<li><a href="#isMonitoringEnabledBySystemId"/>isMonitoringEnabledBySystemId</a></li>
<li><a href="#listProxies"/>listProxies</a></li>
</ul>
</div>
<hr />

<h3> <a name="isMonitoringEnabled" href="#top">Method: isMonitoringEnabled</a></h3>
Description:<br />
Indicates if monitoring is enabled on the satellite
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


    boolean True if monitoring is enabled
 
</li></ul>
</code>
<p />
<hr />

<h3> <a name="isMonitoringEnabledBySystemId" href="#top">Method: isMonitoringEnabledBySystemId</a></h3>
Description:<br />
Indicates if monitoring is enabled on the satellite
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


    boolean True if monitoring is enabled
 
</li></ul>
</code>
<p />
<hr />

<h3> <a name="listProxies" href="#top">Method: listProxies</a></h3>
Description:<br />
List the proxies within the user's organization.
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
</body>
</html>
