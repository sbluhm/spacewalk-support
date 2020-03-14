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
packages
</p>
<p>Methods to retrieve information about the Packages contained
 within this server.</p>
<span class="small-text">( <a href="/rhn/apidoc/index.jsp">Return to API Overview</a> )</span>
<hr />

<div class="rounded-box">
<h2><a name="top">Available methods</a></h2>
<ul class="apidoc">

<li><a href="#findByNvrea"/>findByNvrea</a></li>
<li><a href="#getDetails"/>getDetails</a></li>
<li><a href="#getPackage"/>getPackage</a></li>
<li><a href="#getPackageUrl"/>getPackageUrl</a></li>
<li><a href="#listChangelog"/>listChangelog</a></li>
<li><a href="#listDependencies"/>listDependencies</a></li>
<li><a href="#listFiles"/>listFiles</a></li>
<li><a href="#listProvidingChannels"/>listProvidingChannels</a></li>
<li><a href="#listProvidingErrata"/>listProvidingErrata</a></li>
<li><a href="#listSourcePackages"/>listSourcePackages</a></li>
<li><a href="#removePackage"/>removePackage</a></li>
<li><a href="#removeSourcePackage"/>removeSourcePackage</a></li>
</ul>
</div>
<hr />

<h3> <a name="findByNvrea" href="#top">Method: findByNvrea</a></h3>
Description:<br />
Lookup the details for packages with the given name, version,
          release, architecture label, and (optionally) epoch.
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

    string version
 </li>
<li>

    string release
 </li>
<li>

    string epoch - If set to something other than empty string,
          strict matching will be used and the epoch string must be correct.
          If set to an empty string, if the epoch is null or there is only one
          NVRA combination, it will be returned.  (Empty string is recommended.)
 </li>
<li>

    string archLabel
 </li>
</ul>
<p />
Returns:
<code><ul><li>


array:
  <ul>
   <li>
     

	     struct - package
	<ul>
      	<li> string "name"</li>
      	<li> string "version"</li>
      	<li> string "release"</li>
      	<li> string "epoch"</li>
      	<li> int "id"</li>
      	<li> string "arch_label"</li>
          <li> string "path" - The path on that file system that the package
             resides </li>
          <li> string "provider" - The provider of the package, determined by
              the gpg key it was signed with. </li>
      	<li> dateTime.iso8601 "last_modified"</li>
  	</ul>
 
   </li></ul>
 
</li></ul>
</code>
<p />
<hr />

<h3> <a name="getDetails" href="#top">Method: getDetails</a></h3>
Description:<br />
Retrieve details for the package with the ID.
<p />




Parameters:<br />
<ul>
<li>

        string sessionKey
 </li>
<li>

    int packageId
 </li>
</ul>
<p />
Returns:
<code><ul><li>


	     struct - package
	<ul>
       	<li> int "id"</li>
       	<li> string "name"</li>
       	<li> string "epoch"</li>
       	<li> string "version"</li>
       	<li> string "release"</li>
       	<li> string "arch_label"</li>
           <li>array "providing_channels"
        <ul>
            <li>string Channel label providing this package.</li>
        </ul>
    </li>
       	<li> string "build_host"</li>
       	<li> string "description"</li>
       	<li> string "checksum"</li>
       	<li> string "checksum_type"</li>
       	<li> string "vendor"</li>
       	<li> string "summary"</li>
       	<li> string "cookie"</li>
       	<li> string "license"</li>
       	<li> string "file"</li>
       	<li> string "build_date"</li>
       	<li> string "last_modified_date"</li>
       	<li> string "size"</li>
           <li> string "path" - The path on the Satellite's file system that
              the package resides. </li>
       	<li> string "payload_size"</li>
    	</ul>
 
</li></ul>
</code>
<p />
<hr />

<h3> <a name="getPackage" href="#top">Method: getPackage</a></h3>
Description:<br />
Retrieve the package file associated with a package.
 (Consider using <a href ="#getPackageUrl">packages.getPackageUrl</a>
 for larger files.)
<p />




Parameters:<br />
<ul>
<li>

        string sessionKey
 </li>
<li>

    int package_id
 </li>
</ul>
<p />
Returns:
<code><ul><li>


binary object - package file 
 
</li></ul>
</code>
<p />
<hr />

<h3> <a name="getPackageUrl" href="#top">Method: getPackageUrl</a></h3>
Description:<br />
Retrieve the url that can be used to download a package.
      This will expire after a certain time period.
<p />




Parameters:<br />
<ul>
<li>

        string sessionKey
 </li>
<li>

    int package_id
 </li>
</ul>
<p />
Returns:
<code><ul><li>


string - the download url 
 
</li></ul>
</code>
<p />
<hr />

<h3> <a name="listChangelog" href="#top">Method: listChangelog</a></h3>
Description:<br />
List the change log for a package.
<p />




Parameters:<br />
<ul>
<li>

        string sessionKey
 </li>
<li>

    int packageId
 </li>
</ul>
<p />
Returns:
<code><ul><li>


string 
 
</li></ul>
</code>
<p />
<hr />

<h3> <a name="listDependencies" href="#top">Method: listDependencies</a></h3>
Description:<br />
List the dependencies for a package.
<p />




Parameters:<br />
<ul>
<li>

        string sessionKey
 </li>
<li>

    int packageId
 </li>
</ul>
<p />
Returns:
<code><ul><li>


array:
  <ul>
   <li>
     	     struct - dependency
	<ul>
       	<li> string "dependency"</li>
           <li> string "dependency_type" - One of the following: </li>
         	<ul>
           	<li>requires</li>
           	<li>conflicts</li>
           	<li>obsoletes</li>
           	<li>provides</li>
           	<li>recommends</li>
           	<li>suggests</li>
           	<li>supplements</li>
           	<li>enhances</li>
         	</ul>
       	<li> string "dependency_modifier"</li>
     	</ul>
   </li></ul>
 
</li></ul>
</code>
<p />
<hr />

<h3> <a name="listFiles" href="#top">Method: listFiles</a></h3>
Description:<br />
List the files associated with a package.
<p />




Parameters:<br />
<ul>
<li>

        string sessionKey
 </li>
<li>

    int packageId
 </li>
</ul>
<p />
Returns:
<code><ul><li>


array:
  <ul>
   <li>
     	     struct - file info
	<ul>
       	<li> string "path"</li>
       	<li> string "type"</li>
       	<li> string "last_modified_date"</li>
       	<li> string "checksum"</li>
       	<li> string "checksum_type"</li>
       	<li> int "size"</li>
       	<li> string "linkto"</li>
     	</ul>
   </li></ul>
 
</li></ul>
</code>
<p />
<hr />

<h3> <a name="listProvidingChannels" href="#top">Method: listProvidingChannels</a></h3>
Description:<br />
List the channels that provide the a package.
<p />




Parameters:<br />
<ul>
<li>

        string sessionKey
 </li>
<li>

    int packageId
 </li>
</ul>
<p />
Returns:
<code><ul><li>


array:
  <ul>
   <li>
   	     struct - channel
	<ul>
     	<li> string "label"</li>
     	<li> string "parent_label"</li>
     	<li> string "name"</li>
   	</ul>
 </li></ul>
 
</li></ul>
</code>
<p />
<hr />

<h3> <a name="listProvidingErrata" href="#top">Method: listProvidingErrata</a></h3>
Description:<br />
List the errata providing the a package.
<p />




Parameters:<br />
<ul>
<li>

        string sessionKey
 </li>
<li>

    int packageId
 </li>
</ul>
<p />
Returns:
<code><ul><li>


array:
  <ul>
   <li>
   	     struct - errata
	<ul>
     	<li> string "advisory"</li>
     	<li> string "issue_date"</li>
     	<li> string "last_modified_date"</li>
     	<li> string "update_date"</li>
     	<li> string "synopsis"</li>
     	<li> string "type"</li>
   	</ul>
 </li></ul>
 
</li></ul>
</code>
<p />
<hr />

<h3> <a name="listSourcePackages" href="#top">Method: listSourcePackages</a></h3>
Description:<br />
List all source packages in user's organization.
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
   	     struct - source_package
	<ul>
     	<li> int "id"</li>
     	<li> string "name"</li>
   	</ul>
 </li></ul>
 
</li></ul>
</code>
<p />
<hr />

<h3> <a name="removePackage" href="#top">Method: removePackage</a></h3>
Description:<br />
Remove a package from the satellite.
<p />




Parameters:<br />
<ul>
<li>

        string sessionKey
 </li>
<li>

    int packageId
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

<h3> <a name="removeSourcePackage" href="#top">Method: removeSourcePackage</a></h3>
Description:<br />
Remove a source package.
<p />




Parameters:<br />
<ul>
<li>

        string sessionKey
 </li>
<li>

    int packageSourceId
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
