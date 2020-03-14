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
api
</p>
<p>Methods providing information about the API.</p>
<span class="small-text">( <a href="/rhn/apidoc/index.jsp">Return to API Overview</a> )</span>
<hr />

<div class="rounded-box">
<h2><a name="top">Available methods</a></h2>
<ul class="apidoc">

<li><a href="#getApiCallList"/>getApiCallList</a></li>
<li><a href="#getApiNamespaceCallList"/>getApiNamespaceCallList</a></li>
<li><a href="#getApiNamespaces"/>getApiNamespaces</a></li>
<li><a href="#getVersion"/>getVersion</a></li>
<li><a href="#systemVersion"/>systemVersion</a></li>
</ul>
</div>
<hr />

<h3> <a name="getApiCallList" href="#top">Method: getApiCallList</a></h3>
Description:<br />
Lists all available api calls grouped by namespace
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


	     struct - method_info
	<ul>
           <li> string "name" - method name </li>
           <li> string "parameters" - method parameters </li>
           <li> string "exceptions" - method exceptions </li>
           <li> string "return" - method return type </li>
   	</ul>
 
</li></ul>
</code>
<p />
<hr />

<h3> <a name="getApiNamespaceCallList" href="#top">Method: getApiNamespaceCallList</a></h3>
Description:<br />
Lists all available api calls for the specified namespace
<p />




Parameters:<br />
<ul>
<li>

    string sessionKey
 </li>
<li>

    string namespace
 </li>
</ul>
<p />
Returns:
<code><ul><li>


	     struct - method_info
	<ul>
            <li> string "name" - method name </li>
            <li> string "parameters" - method parameters </li>
            <li> string "exceptions" - method exceptions </li>
            <li> string "return" - method return type </li>
   	</ul>
 
</li></ul>
</code>
<p />
<hr />

<h3> <a name="getApiNamespaces" href="#top">Method: getApiNamespaces</a></h3>
Description:<br />
Lists available API namespaces
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


	     struct - namespace
	<ul>
            <li> string "namespace" - API namespace </li>
            <li> string "handler" - API Handler </li>
   	</ul>
 
</li></ul>
</code>
<p />
<hr />

<h3> <a name="getVersion" href="#top">Method: getVersion</a></h3>
Description:<br />
Returns the version of the API. Since Spacewalk 0.4
 (Satellite 5.3) it is no more related to server version.
<p />




Parameters:<br />
<ul>
</ul>
<p />
Returns:
<code><ul><li>


string 
 
</li></ul>
</code>
<p />
<hr />

<h3> <a name="systemVersion" href="#top">Method: systemVersion</a></h3>
Description:<br />
Returns the server version.
<p />




Parameters:<br />
<ul>
</ul>
<p />
Returns:
<code><ul><li>


string 
 
</li></ul>
</code>
<p />
<hr />
</body>
</html>
