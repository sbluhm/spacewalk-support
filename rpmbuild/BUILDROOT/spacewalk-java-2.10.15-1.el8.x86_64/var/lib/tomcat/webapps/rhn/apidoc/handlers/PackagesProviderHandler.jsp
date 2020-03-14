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
packages.provider
</p>
<p>Methods to retrieve information about Package Providers associated with
      packages.</p>
<span class="small-text">( <a href="/rhn/apidoc/index.jsp">Return to API Overview</a> )</span>
<hr />

<div class="rounded-box">
<h2><a name="top">Available methods</a></h2>
<ul class="apidoc">

<li><a href="#associateKey"/>associateKey</a></li>
<li><a href="#list"/>list</a></li>
<li><a href="#listKeys"/>listKeys</a></li>
</ul>
</div>
<hr />

<h3> <a name="associateKey" href="#top">Method: associateKey</a></h3>
Description:<br />
Associate a package security key and with the package provider.
      If the provider or key doesn't exist, it is created. User executing the
      request must be a Satellite administrator.
<p />




Parameters:<br />
<ul>
<li>

        string sessionKey
 </li>
<li>

    string providerName - The provider name
 </li>
<li>

    string key - The actual key
 </li>
<li>

    string type - The type of the key. Currently,
 only 'gpg' is supported
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

<h3> <a name="list" href="#top">Method: list</a></h3>
Description:<br />
List all Package Providers.
 User executing the request must be a Satellite administrator.
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
      

	     struct - package provider
	<ul>
   	<li> string "name"</li>
       <li>array "keys"
        <ul>
            <li>
      

	     struct - package security key
	<ul>
     	<li> string "key"</li>
     	<li> string "type"</li>
   	</ul>
 
              </li>
        </ul>
    </li>
   	</ul>
 
  </li></ul>
 
</li></ul>
</code>
<p />
<hr />

<h3> <a name="listKeys" href="#top">Method: listKeys</a></h3>
Description:<br />
List all security keys associated with a package provider.
 User executing the request must be a Satellite administrator.
<p />




Parameters:<br />
<ul>
<li>

        string sessionKey
 </li>
<li>

    string providerName - The provider name
 </li>
</ul>
<p />
Returns:
<code><ul><li>


array:
  <ul>
   <li>
      

	     struct - package security key
	<ul>
     	<li> string "key"</li>
     	<li> string "type"</li>
   	</ul>
 
  </li></ul>
 
</li></ul>
</code>
<p />
<hr />
</body>
</html>
