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
packages.search
</p>
<p>Methods to interface to package search capabilities in search server..</p>
<span class="small-text">( <a href="/rhn/apidoc/index.jsp">Return to API Overview</a> )</span>
<hr />

<div class="rounded-box">
<h2><a name="top">Available methods</a></h2>
<ul class="apidoc">

<li><a href="#advanced"/>advanced</a></li>
<li><a href="#advancedWithActKey"/>advancedWithActKey</a></li>
<li><a href="#advancedWithChannel"/>advancedWithChannel</a></li>
<li><a href="#name"/>name</a></li>
<li><a href="#nameAndDescription"/>nameAndDescription</a></li>
<li><a href="#nameAndSummary"/>nameAndSummary</a></li>
</ul>
</div>
<hr />

<h3> <a name="advanced" href="#top">Method: advanced</a></h3>
Description:<br />
Advanced method to search lucene indexes with a passed in query written
 in Lucene Query Parser syntax.<br>
 Lucene Query Parser syntax is defined at
 <a href="http://lucene.apache.org/java/3_5_0/queryparsersyntax.html" target="_blank">
 lucene.apache.org</a>.<br>
 Fields searchable for Packages:
 name, epoch, version, release, arch, description, summary<br>
 Lucene Query Example: "name:kernel AND version:2.6.18 AND -description:devel"
<p />




Parameters:<br />
<ul>
<li>

        string sessionKey
 </li>
<li>

    string luceneQuery - a query written in the form of Lucene QueryParser Syntax
 </li>
</ul>
<p />
Returns:
<code><ul><li>


array:
  <ul>
   <li>
      

	     struct - package overview
	<ul>
   	<li> int "id"</li>
   	<li> string "name"</li>
   	<li> string "summary"</li>
   	<li> string "description"</li>
   	<li> string "version"</li>
   	<li> string "release"</li>
   	<li> string "arch"</li>
   	<li> string "epoch"</li>
   	<li> string "provider"</li>
   	</ul>
 
   </li></ul>
 
</li></ul>
</code>
<p />
<hr />

<h3> <a name="advancedWithActKey" href="#top">Method: advancedWithActKey</a></h3>
Description:<br />
Advanced method to search lucene indexes with a passed in query written
 in Lucene Query Parser syntax, additionally this method will limit results to those
 which are associated with a given activation key.<br>
 Lucene Query Parser syntax is defined at
 <a href="http://lucene.apache.org/java/3_5_0/queryparsersyntax.html" target="_blank">
 lucene.apache.org</a>.<br>
 Fields searchable for Packages:
 name, epoch, version, release, arch, description, summary<br>
 Lucene Query Example: "name:kernel AND version:2.6.18 AND -description:devel"
<p />




Parameters:<br />
<ul>
<li>

        string sessionKey
 </li>
<li>

    string luceneQuery - a query written in the form of Lucene QueryParser Syntax
 </li>
<li>

    string actKey - activation key to look for packages in
 </li>
</ul>
<p />
Returns:
<code><ul><li>


array:
  <ul>
   <li>
      

	     struct - package overview
	<ul>
   	<li> int "id"</li>
   	<li> string "name"</li>
   	<li> string "summary"</li>
   	<li> string "description"</li>
   	<li> string "version"</li>
   	<li> string "release"</li>
   	<li> string "arch"</li>
   	<li> string "epoch"</li>
   	<li> string "provider"</li>
   	</ul>
 
   </li></ul>
 
</li></ul>
</code>
<p />
<hr />

<h3> <a name="advancedWithChannel" href="#top">Method: advancedWithChannel</a></h3>
Description:<br />
Advanced method to search lucene indexes with a passed in query written
 in Lucene Query Parser syntax, additionally this method will limit results to those
 which are in the passed in channel label.<br>
 Lucene Query Parser syntax is defined at
 <a href="http://lucene.apache.org/java/3_5_0/queryparsersyntax.html" target="_blank">
 lucene.apache.org</a>.<br>
 Fields searchable for Packages:
 name, epoch, version, release, arch, description, summary<br>
 Lucene Query Example: "name:kernel AND version:2.6.18 AND -description:devel"
<p />




Parameters:<br />
<ul>
<li>

        string sessionKey
 </li>
<li>

    string luceneQuery - a query written in the form of Lucene QueryParser Syntax
 </li>
<li>

    string channelLabel - Channel Label
 </li>
</ul>
<p />
Returns:
<code><ul><li>


array:
  <ul>
   <li>
      

	     struct - package overview
	<ul>
   	<li> int "id"</li>
   	<li> string "name"</li>
   	<li> string "summary"</li>
   	<li> string "description"</li>
   	<li> string "version"</li>
   	<li> string "release"</li>
   	<li> string "arch"</li>
   	<li> string "epoch"</li>
   	<li> string "provider"</li>
   	</ul>
 
   </li></ul>
 
</li></ul>
</code>
<p />
<hr />

<h3> <a name="name" href="#top">Method: name</a></h3>
Description:<br />
Search the lucene package indexes for all packages which
          match the given name.
<p />




Parameters:<br />
<ul>
<li>

        string sessionKey
 </li>
<li>

    string name - package name to search for
 </li>
</ul>
<p />
Returns:
<code><ul><li>


array:
  <ul>
   <li>
   

	     struct - package overview
	<ul>
   	<li> int "id"</li>
   	<li> string "name"</li>
   	<li> string "summary"</li>
   	<li> string "description"</li>
   	<li> string "version"</li>
   	<li> string "release"</li>
   	<li> string "arch"</li>
   	<li> string "epoch"</li>
   	<li> string "provider"</li>
   	</ul>
 
 </li></ul>
 
</li></ul>
</code>
<p />
<hr />

<h3> <a name="nameAndDescription" href="#top">Method: nameAndDescription</a></h3>
Description:<br />
Search the lucene package indexes for all packages which
          match the given query in name or description
<p />




Parameters:<br />
<ul>
<li>

        string sessionKey
 </li>
<li>

    string query - text to match in package name or description
 </li>
</ul>
<p />
Returns:
<code><ul><li>


array:
  <ul>
   <li>
   

	     struct - package overview
	<ul>
   	<li> int "id"</li>
   	<li> string "name"</li>
   	<li> string "summary"</li>
   	<li> string "description"</li>
   	<li> string "version"</li>
   	<li> string "release"</li>
   	<li> string "arch"</li>
   	<li> string "epoch"</li>
   	<li> string "provider"</li>
   	</ul>
 
 </li></ul>
 
</li></ul>
</code>
<p />
<hr />

<h3> <a name="nameAndSummary" href="#top">Method: nameAndSummary</a></h3>
Description:<br />
Search the lucene package indexes for all packages which
          match the given query in name or summary.
<p />




Parameters:<br />
<ul>
<li>

        string sessionKey
 </li>
<li>

    string query - text to match in package name or summary
 </li>
</ul>
<p />
Returns:
<code><ul><li>


array:
  <ul>
   <li>
   

	     struct - package overview
	<ul>
   	<li> int "id"</li>
   	<li> string "name"</li>
   	<li> string "summary"</li>
   	<li> string "description"</li>
   	<li> string "version"</li>
   	<li> string "release"</li>
   	<li> string "arch"</li>
   	<li> string "epoch"</li>
   	<li> string "provider"</li>
   	</ul>
 
 </li></ul>
 
</li></ul>
</code>
<p />
<hr />
</body>
</html>
