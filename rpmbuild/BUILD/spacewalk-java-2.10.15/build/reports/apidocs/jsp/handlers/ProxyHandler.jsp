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
proxy
</p>
<p>Provides methods to activate/deactivate a proxy
 server.</p>
<span class="small-text">( <a href="/rhn/apidoc/index.jsp">Return to API Overview</a> )</span>
<hr />

<div class="rounded-box">
<h2><a name="top">Available methods</a></h2>
<ul class="apidoc">

<li><a href="#activateProxy"/>activateProxy</a></li>
<li><a href="#createMonitoringScout"/>createMonitoringScout</a></li>
<li><a href="#deactivateProxy"/>deactivateProxy</a></li>
<li><a href="#isProxy"/>isProxy</a></li>
<li><a href="#listAvailableProxyChannels"/>listAvailableProxyChannels</a></li>
</ul>
</div>
<hr />

<h3> <a name="activateProxy" href="#top">Method: activateProxy</a></h3>
Description:<br />
Activates the proxy identified by the given client
 certificate i.e. systemid file.
<p />




Parameters:<br />
<ul>
<li>

    string systemid - systemid file
 </li>
<li>

    string version - Version of proxy to be
 registered.
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

<h3> <a name="createMonitoringScout" href="#top">Method: createMonitoringScout</a></h3>
Description:<br />
Create Monitoring Scout for proxy.
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


string 
 
</li></ul>
</code>
<p />
Available since: 10.7 <p />
<hr />

<h3> <a name="deactivateProxy" href="#top">Method: deactivateProxy</a></h3>
Description:<br />
Deactivates the proxy identified by the given client
 certificate i.e. systemid file.
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


    int - 1 on success, exception thrown otherwise.
 
</li></ul>
</code>
<p />
<hr />

<h3> <a name="isProxy" href="#top">Method: isProxy</a></h3>
Description:<br />
Test, if the system identified by the given client
 certificate i.e. systemid file, is proxy.
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


    int - 1 on success, exception thrown otherwise.
 
</li></ul>
</code>
<p />
<hr />

<h3> <a name="listAvailableProxyChannels" href="#top">Method: listAvailableProxyChannels</a></h3>
Description:<br />
List available version of proxy channel for system
 identified by the given client certificate i.e. systemid file.
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


array:
<ul>
    <li>string - version</li>
</ul>
 
</li></ul>
</code>
<p />
Available since: 10.5 <p />
<hr />
</body>
</html>
