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
auth
</p>
<p>This namespace provides methods to authenticate with the system's
 management server.</p>
<span class="small-text">( <a href="/rhn/apidoc/index.jsp">Return to API Overview</a> )</span>
<hr />

<div class="rounded-box">
<h2><a name="top">Available methods</a></h2>
<ul class="apidoc">

<li><a href="#login"/>login</a></li>
<li><a href="#login"/>login</a></li>
<li><a href="#logout"/>logout</a></li>
</ul>
</div>
<hr />

<h3> <a name="login" href="#top">Method: login</a></h3>
Description:<br />
Login using a username and password. Returns the session key
 used by most other API methods.
<p />




Parameters:<br />
<ul>
<li>

    string username
 </li>
<li>

    string password
 </li>
</ul>
<p />
Returns:
<code><ul><li>


    string sessionKey
 
</li></ul>
</code>
<p />
<hr />

<h3> <a name="login" href="#top">Method: login</a></h3>
Description:<br />
Login using a username and password. Returns the session key
 used by other methods.
<p />




Parameters:<br />
<ul>
<li>

    string username
 </li>
<li>

    string password
 </li>
<li>

    int duration - Length of session.
 </li>
</ul>
<p />
Returns:
<code><ul><li>


    string sessionKey
 
</li></ul>
</code>
<p />
<hr />

<h3> <a name="logout" href="#top">Method: logout</a></h3>
Description:<br />
Logout the user with the given session key.
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
</body>
</html>
