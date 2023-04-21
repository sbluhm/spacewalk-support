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
kickstart.snippet
</p>
<p>Provides methods to create kickstart files</p>
<span class="small-text">( <a href="/rhn/apidoc/index.jsp">Return to API Overview</a> )</span>
<hr />

<div class="rounded-box">
<h2><a name="top">Available methods</a></h2>
<ul class="apidoc">

<li><a href="#createOrUpdate"/>createOrUpdate</a></li>
<li><a href="#delete"/>delete</a></li>
<li><a href="#listAll"/>listAll</a></li>
<li><a href="#listCustom"/>listCustom</a></li>
<li><a href="#listDefault"/>listDefault</a></li>
</ul>
</div>
<hr />

<h3> <a name="createOrUpdate" href="#top">Method: createOrUpdate</a></h3>
Description:<br />
Will create a snippet with the given name and contents if it
      doesn't exist. If it does exist, the existing snippet will be updated.
<p />




Parameters:<br />
<ul>
<li>

    string sessionKey
 </li>
<li>

    string name
 </li>
<li>

    string contents
 </li>
</ul>
<p />
Returns:
<code><ul><li>




	     struct - snippet
	<ul>
     	<li> string "name"</li>
     	<li> string "contents"</li>
         <li> string "fragment" - The string to include in a kickstart
                          file that will generate this snippet. </li>
         <li> string "file" - The local path to the file containing this snippet. </li>
   	</ul>
  
 
</li></ul>
</code>
<p />
<hr />

<h3> <a name="delete" href="#top">Method: delete</a></h3>
Description:<br />
Delete the specified snippet.
      If the snippet is not found, 0 is returned.
<p />




Parameters:<br />
<ul>
<li>

    string sessionKey
 </li>
<li>

    string name
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

<h3> <a name="listAll" href="#top">Method: listAll</a></h3>
Description:<br />
List all cobbler snippets for the logged in user
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
            

	     struct - snippet
	<ul>
     	<li> string "name"</li>
     	<li> string "contents"</li>
         <li> string "fragment" - The string to include in a kickstart
                          file that will generate this snippet. </li>
         <li> string "file" - The local path to the file containing this snippet. </li>
   	</ul>
 
          </li></ul>
 
</li></ul>
</code>
<p />
<hr />

<h3> <a name="listCustom" href="#top">Method: listCustom</a></h3>
Description:<br />
List only custom snippets for the logged in user.
    These snipppets are editable.
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
            

	     struct - snippet
	<ul>
     	<li> string "name"</li>
     	<li> string "contents"</li>
         <li> string "fragment" - The string to include in a kickstart
                          file that will generate this snippet. </li>
         <li> string "file" - The local path to the file containing this snippet. </li>
   	</ul>
 
          </li></ul>
 
</li></ul>
</code>
<p />
<hr />

<h3> <a name="listDefault" href="#top">Method: listDefault</a></h3>
Description:<br />
List only pre-made default snippets for the logged in user.
    These snipppets are not editable.
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
            

	     struct - snippet
	<ul>
     	<li> string "name"</li>
     	<li> string "contents"</li>
         <li> string "fragment" - The string to include in a kickstart
                          file that will generate this snippet. </li>
         <li> string "file" - The local path to the file containing this snippet. </li>
   	</ul>
 
          </li></ul>
 
</li></ul>
</code>
<p />
<hr />
</body>
</html>
