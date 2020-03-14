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
kickstart.profile.software
</p>
<p>Provides methods to access and modify the software list
 associated with a kickstart profile.</p>
<span class="small-text">( <a href="/rhn/apidoc/index.jsp">Return to API Overview</a> )</span>
<hr />

<div class="rounded-box">
<h2><a name="top">Available methods</a></h2>
<ul class="apidoc">

<li><a href="#appendToSoftwareList"/>appendToSoftwareList</a></li>
<li><a href="#getSoftwareDetails"/>getSoftwareDetails</a></li>
<li><a href="#getSoftwareList"/>getSoftwareList</a></li>
<li><a href="#setSoftwareDetails"/>setSoftwareDetails</a></li>
<li><a href="#setSoftwareList"/>setSoftwareList</a></li>
<li><a href="#setSoftwareList"/>setSoftwareList</a></li>
</ul>
</div>
<hr />

<h3> <a name="appendToSoftwareList" href="#top">Method: appendToSoftwareList</a></h3>
Description:<br />
Append the list of software packages to a kickstart profile.
 Duplicate packages will be ignored.
<p />




Parameters:<br />
<ul>
<li>

        string sessionKey
 </li>
<li>

    string ksLabel - The label of a kickstart
 profile.
 </li>
<li>

    string[] packageList - A list of package
 names to be added to the profile.
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

<h3> <a name="getSoftwareDetails" href="#top">Method: getSoftwareDetails</a></h3>
Description:<br />
Gets kickstart profile software details.
<p />




Parameters:<br />
<ul>
<li>

        string sessionKey
 </li>
<li>

    string ksLabel - Label of the kickstart profile
 </li>
</ul>
<p />
Returns:
<code><ul><li>


	     struct - Kickstart packages info
	<ul>
                  <li> string "noBase" - Install @Base package group </li>
                  <li> string "ignoreMissing" - Ignore missing packages </li>
          	</ul>
 
</li></ul>
</code>
<p />
<hr />

<h3> <a name="getSoftwareList" href="#top">Method: getSoftwareList</a></h3>
Description:<br />
Get a list of a kickstart profile's software packages.
<p />




Parameters:<br />
<ul>
<li>

        string sessionKey
 </li>
<li>

    string ksLabel - The label of a kickstart
 profile.
 </li>
</ul>
<p />
Returns:
<code><ul><li>


string[] - Get a list of a kickstart profile's
 software packages. 
 
</li></ul>
</code>
<p />
<hr />

<h3> <a name="setSoftwareDetails" href="#top">Method: setSoftwareDetails</a></h3>
Description:<br />
Sets kickstart profile software details.
<p />




Parameters:<br />
<ul>
<li>

        string sessionKey
 </li>
<li>

    string ksLabel - Label of the kickstart profile
 </li>
<li>

	     struct - Kickstart packages info
	<ul>
                  <li> string "noBase" - Install @Base package group </li>
                  <li> string "ignoreMissing" - Ignore missing packages </li>
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

<h3> <a name="setSoftwareList" href="#top">Method: setSoftwareList</a></h3>
Description:<br />
Set the list of software packages for a kickstart profile.
<p />




Parameters:<br />
<ul>
<li>

        string sessionKey
 </li>
<li>

    string ksLabel - The label of a kickstart
 profile.
 </li>
<li>

    string[] packageList - A list of package
 names to be set on the profile.
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

<h3> <a name="setSoftwareList" href="#top">Method: setSoftwareList</a></h3>
Description:<br />
Set the list of software packages for a kickstart profile.
<p />




Parameters:<br />
<ul>
<li>

        string sessionKey
 </li>
<li>

    string ksLabel - The label of a kickstart
 profile.
 </li>
<li>

    string[] packageList - A list of package
 names to be set on the profile.
 </li>
<li>

    boolean ignoremissing - Ignore missing packages
 if true
 </li>
<li>

    boolean nobase - Don't install @Base package group
 if true
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
