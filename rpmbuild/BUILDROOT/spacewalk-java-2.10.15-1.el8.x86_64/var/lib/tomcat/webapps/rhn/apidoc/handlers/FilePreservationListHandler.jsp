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
kickstart.filepreservation
</p>
<p>Provides methods to retrieve and manipulate kickstart file
 preservation lists.</p>
<span class="small-text">( <a href="/rhn/apidoc/index.jsp">Return to API Overview</a> )</span>
<hr />

<div class="rounded-box">
<h2><a name="top">Available methods</a></h2>
<ul class="apidoc">

<li><a href="#create"/>create</a></li>
<li><a href="#delete"/>delete</a></li>
<li><a href="#getDetails"/>getDetails</a></li>
<li><a href="#listAllFilePreservations"/>listAllFilePreservations</a></li>
</ul>
</div>
<hr />

<h3> <a name="create" href="#top">Method: create</a></h3>
Description:<br />
Create a new file preservation list.
<p />




Parameters:<br />
<ul>
<li>

    string session_key
 </li>
<li>

    string name - name of the file list to create
 </li>
<li>

array:
<ul>
    <li>string - name - file names to include</li>
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

<h3> <a name="delete" href="#top">Method: delete</a></h3>
Description:<br />
Delete a file preservation list.
<p />




Parameters:<br />
<ul>
<li>

    string session_key
 </li>
<li>

    string name - name of the file list to delete
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
Returns all of the data associated with the given file preservation
 list.
<p />




Parameters:<br />
<ul>
<li>

    string session_key
 </li>
<li>

    string name - name of the file list to retrieve
 details for
 </li>
</ul>
<p />
Returns:
<code><ul><li>




	     struct - file list
	<ul>
     	<li> string "name"</li>
         <li>array "file_names"
        <ul>
            <li>string name</li>
        </ul>
    </li>
   	</ul>
  
 
</li></ul>
</code>
<p />
<hr />

<h3> <a name="listAllFilePreservations" href="#top">Method: listAllFilePreservations</a></h3>
Description:<br />
List all file preservation lists for the organization
 associated with the user logged into the given session
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
        

	     struct - file preservation
	<ul>
      	<li> int "id"</li>
      	<li> string "name"</li>
      	<li> dateTime.iso8601 "created"</li>
      	<li> dateTime.iso8601 "last_modified"</li>
   	</ul>
 
      </li></ul>
 
</li></ul>
</code>
<p />
<hr />
</body>
</html>
