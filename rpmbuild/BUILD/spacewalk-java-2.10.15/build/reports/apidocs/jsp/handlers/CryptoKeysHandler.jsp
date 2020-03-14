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
kickstart.keys
</p>
<p>Provides methods to manipulate kickstart keys.</p>
<span class="small-text">( <a href="/rhn/apidoc/index.jsp">Return to API Overview</a> )</span>
<hr />

<div class="rounded-box">
<h2><a name="top">Available methods</a></h2>
<ul class="apidoc">

<li><a href="#create"/>create</a></li>
<li><a href="#delete"/>delete</a></li>
<li><a href="#getDetails"/>getDetails</a></li>
<li><a href="#listAllKeys"/>listAllKeys</a></li>
<li><a href="#update"/>update</a></li>
</ul>
</div>
<hr />

<h3> <a name="create" href="#top">Method: create</a></h3>
Description:<br />
creates a new key with the given parameters
<p />




Parameters:<br />
<ul>
<li>

    string session_key
 </li>
<li>

    string description
 </li>
<li>

    string type - valid values are GPG or SSL
 </li>
<li>

    string content
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
deletes the key identified by the given parameters
<p />




Parameters:<br />
<ul>
<li>

    string session_key
 </li>
<li>

    string description
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
returns all of the data associated with the given key
<p />




Parameters:<br />
<ul>
<li>

    string session_key
 </li>
<li>

    string description
 </li>
</ul>
<p />
Returns:
<code><ul><li>


	     struct - key
	<ul>
          	<li> string "description"</li>
          	<li> string "type"</li>
          	<li> string "content"</li>
      	</ul>
 
</li></ul>
</code>
<p />
<hr />

<h3> <a name="listAllKeys" href="#top">Method: listAllKeys</a></h3>
Description:<br />
list all keys for the org associated with the user logged into the
             given session
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
          	     struct - key
	<ul>
              	<li> string "description"</li>
              	<li> string "type"</li>
          	</ul>
      </li></ul>
 
</li></ul>
</code>
<p />
<hr />

<h3> <a name="update" href="#top">Method: update</a></h3>
Description:<br />
Updates type and content of the key identified by the description
<p />




Parameters:<br />
<ul>
<li>

    string session_key
 </li>
<li>

    string description
 </li>
<li>

    string type - valid values are GPG or SSL
 </li>
<li>

    string content
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
