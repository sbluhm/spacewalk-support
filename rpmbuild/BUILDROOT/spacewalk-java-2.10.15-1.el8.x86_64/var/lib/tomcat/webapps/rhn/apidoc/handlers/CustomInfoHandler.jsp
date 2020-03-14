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
system.custominfo
</p>
<p>Provides methods to access and modify custom system information.</p>
<span class="small-text">( <a href="/rhn/apidoc/index.jsp">Return to API Overview</a> )</span>
<hr />

<div class="rounded-box">
<h2><a name="top">Available methods</a></h2>
<ul class="apidoc">

<li><a href="#createKey"/>createKey</a></li>
<li><a href="#deleteKey"/>deleteKey</a></li>
<li><a href="#listAllKeys"/>listAllKeys</a></li>
<li><a href="#updateKey"/>updateKey</a></li>
</ul>
</div>
<hr />

<h3> <a name="createKey" href="#top">Method: createKey</a></h3>
Description:<br />
Create a new custom key
<p />




Parameters:<br />
<ul>
<li>

        string sessionKey
 </li>
<li>

    string keyLabel - new key's label
 </li>
<li>

    string keyDescription - new key's description
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

<h3> <a name="deleteKey" href="#top">Method: deleteKey</a></h3>
Description:<br />
Delete an existing custom key and all systems' values for the key.
<p />




Parameters:<br />
<ul>
<li>

        string sessionKey
 </li>
<li>

    string keyLabel - new key's label
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

<h3> <a name="listAllKeys" href="#top">Method: listAllKeys</a></h3>
Description:<br />
List the custom information keys defined for the user's organization.
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
          

	     struct - custom info
	<ul>
          	<li> int "id"</li>
          	<li> string "label"</li>
          	<li> string "description"</li>
          	<li> int "system_count"</li>
          	<li> dateTime.iso8601 "last_modified"</li>
      	</ul>
 
      </li></ul>
 
</li></ul>
</code>
<p />
<hr />

<h3> <a name="updateKey" href="#top">Method: updateKey</a></h3>
Description:<br />
Update description of a custom key
<p />




Parameters:<br />
<ul>
<li>

        string sessionKey
 </li>
<li>

    string keyLabel - key to change
 </li>
<li>

    string keyDescription - new key's description
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
