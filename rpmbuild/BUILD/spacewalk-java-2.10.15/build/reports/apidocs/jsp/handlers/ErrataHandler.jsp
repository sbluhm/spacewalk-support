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
errata
</p>
<p>Provides methods to access and modify errata.</p>
<span class="small-text">( <a href="/rhn/apidoc/index.jsp">Return to API Overview</a> )</span>
<hr />

<div class="rounded-box">
<h2><a name="top">Available methods</a></h2>
<ul class="apidoc">

<li><a href="#addPackages"/>addPackages</a></li>
<li><a href="#applicableToChannels"/>applicableToChannels</a></li>
<li><a href="#bugzillaFixes"/>bugzillaFixes</a></li>
<li><a href="#clone"/>clone</a></li>
<li><a href="#cloneAsOriginal"/>cloneAsOriginal</a></li>
<li><a href="#cloneAsOriginalAsync"/>cloneAsOriginalAsync</a></li>
<li><a href="#cloneAsync"/>cloneAsync</a></li>
<li><a href="#create"/>create</a></li>
<li><a href="#delete"/>delete</a></li>
<li><a href="#findByCve"/>findByCve</a></li>
<li><a href="#getDetails"/>getDetails</a></li>
<li><a href="#listAffectedSystems"/>listAffectedSystems</a></li>
<li><a href="#listByDate"/>listByDate</a></li>
<li><a href="#listCves"/>listCves</a></li>
<li><a href="#listKeywords"/>listKeywords</a></li>
<li><a href="#listPackages"/>listPackages</a></li>
<li><a href="#listUnpublishedErrata"/>listUnpublishedErrata</a></li>
<li><a href="#publish"/>publish</a></li>
<li><a href="#publishAsOriginal"/>publishAsOriginal</a></li>
<li><a href="#removePackages"/>removePackages</a></li>
<li><a href="#setDetails"/>setDetails</a></li>
</ul>
</div>
<hr />

<h3> <a name="addPackages" href="#top">Method: addPackages</a></h3>
Description:<br />
Add a set of packages to an erratum
 with the given advisory name. This method will only allow for modification
 of custom errata created either through the UI or API.
<p />




Parameters:<br />
<ul>
<li>

        string sessionKey
 </li>
<li>

    string advisoryName
 </li>
<li>

array:
<ul>
    <li>int - packageId</li>
</ul>
 </li>
</ul>
<p />
Returns:
<code><ul><li>


int - representing the number of packages added,
 exception otherwise 
 
</li></ul>
</code>
<p />
<hr />

<h3> <a name="applicableToChannels" href="#top">Method: applicableToChannels</a></h3>
Description:<br />
Returns a list of channels applicable to the erratum
 with the given advisory name.
<p />




Parameters:<br />
<ul>
<li>

        string sessionKey
 </li>
<li>

    string advisoryName
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
              	<li> int "channel_id"</li>
              	<li> string "label"</li>
              	<li> string "name"</li>
              	<li> string "parent_channel_label"</li>
          	</ul>
       </li></ul>
 
</li></ul>
</code>
<p />
<hr />

<h3> <a name="bugzillaFixes" href="#top">Method: bugzillaFixes</a></h3>
Description:<br />
Get the Bugzilla fixes for an erratum matching the given
 advisoryName. The bugs will be returned in a struct where the bug id is
 the key.  i.e. 208144="errata.bugzillaFixes Method Returns different
 results than docs say"
<p />




Parameters:<br />
<ul>
<li>

        string sessionKey
 </li>
<li>

    string advisoryName
 </li>
</ul>
<p />
Returns:
<code><ul><li>


	     struct - Bugzilla info
	<ul>
              <li> string "bugzilla_id" - actual bug number is the key into the
                      struct </li>
              <li> string "bug_summary" - summary who's key is the bug id </li>
      	</ul>
 
</li></ul>
</code>
<p />
<hr />

<h3> <a name="clone" href="#top">Method: clone</a></h3>
Description:<br />
Clone a list of errata into the specified channel.
<p />




Parameters:<br />
<ul>
<li>

        string sessionKey
 </li>
<li>

    string channel_label
 </li>
<li>

array:
<ul>
    <li>string -  advisory - The advisory name of the errata to clone.</li>
</ul>
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
              <li> int "id" - Errata Id </li>
              <li> string "date" - Date erratum was created. </li>
              <li> string "advisory_type" - Type of the advisory. </li>
              <li> string "advisory_name" - Name of the advisory. </li>
              <li> string "advisory_synopsis" - Summary of the erratum. </li>
     	</ul>
 
          </li></ul>
 
</li></ul>
</code>
<p />
<hr />

<h3> <a name="cloneAsOriginal" href="#top">Method: cloneAsOriginal</a></h3>
Description:<br />
Clones a list of errata into a specified cloned channel
 according the original erratas.
<p />




Parameters:<br />
<ul>
<li>

        string sessionKey
 </li>
<li>

    string channel_label
 </li>
<li>

array:
<ul>
    <li>string -  advisory - The advisory name of the errata to clone.</li>
</ul>
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
              <li> int "id" - Errata Id </li>
              <li> string "date" - Date erratum was created. </li>
              <li> string "advisory_type" - Type of the advisory. </li>
              <li> string "advisory_name" - Name of the advisory. </li>
              <li> string "advisory_synopsis" - Summary of the erratum. </li>
     	</ul>
 
          </li></ul>
 
</li></ul>
</code>
<p />
<hr />

<h3> <a name="cloneAsOriginalAsync" href="#top">Method: cloneAsOriginalAsync</a></h3>
Description:<br />
Asynchronously clones a list of errata into a specified cloned channel
 according the original erratas
<p />




Parameters:<br />
<ul>
<li>

        string sessionKey
 </li>
<li>

    string channel_label
 </li>
<li>

array:
<ul>
    <li>string -  advisory - The advisory name of the errata to clone.</li>
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

<h3> <a name="cloneAsync" href="#top">Method: cloneAsync</a></h3>
Description:<br />
Asynchronously clone a list of errata into the specified channel.
<p />




Parameters:<br />
<ul>
<li>

        string sessionKey
 </li>
<li>

    string channel_label
 </li>
<li>

array:
<ul>
    <li>string -  advisory - The advisory name of the errata to clone.</li>
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

<h3> <a name="create" href="#top">Method: create</a></h3>
Description:<br />
Create a custom errata.  If "publish" is set to true,
      the errata will be published as well
<p />




Parameters:<br />
<ul>
<li>

        string sessionKey
 </li>
<li>

	     struct - errata info
	<ul>
          	<li> string "synopsis"</li>
          	<li> string "advisory_name"</li>
          	<li> int "advisory_release"</li>
              <li> string "advisory_type" - Type of advisory (one of the
                  following: 'Security Advisory', 'Product Enhancement Advisory',
                  or 'Bug Fix Advisory' </li>
          	<li> string "product"</li>
          	<li> string "errataFrom"</li>
          	<li> string "topic"</li>
          	<li> string "description"</li>
          	<li> string "references"</li>
          	<li> string "notes"</li>
          	<li> string "solution"</li>
              <li> string "severity" - Severity of advisory (one of the
                  following: 'Low', 'Moderate', 'Important', 'Critical'
                  or 'Unspecified' </li>
       	</ul>
 </li>
<li>

array:
  <ul>
   <li>
              	     struct - bug
	<ul>
                      <li> int "id" - Bug Id </li>
                  	<li> string "summary"</li>
                  	<li> string "url"</li>
               	</ul>
       </li></ul>
 </li>
<li>

array:
<ul>
    <li>string - keyword - List of keywords to associate
              with the errata.</li>
</ul>
 </li>
<li>

array:
<ul>
    <li>int - packageId</li>
</ul>
 </li>
<li>

    boolean publish - Should the errata be published.
 </li>
<li>

array:
<ul>
    <li>string - channelLabel - list of channels the errata should be
                  published too, ignored if publish is set to false</li>
</ul>
 </li>
</ul>
<p />
Returns:
<code><ul><li>




	     struct - errata
	<ul>
              <li> int "id" - Errata Id </li>
              <li> string "date" - Date erratum was created. </li>
              <li> string "advisory_type" - Type of the advisory. </li>
              <li> string "advisory_name" - Name of the advisory. </li>
              <li> string "advisory_synopsis" - Summary of the erratum. </li>
     	</ul>
  
 
</li></ul>
</code>
<p />
<hr />

<h3> <a name="delete" href="#top">Method: delete</a></h3>
Description:<br />
Delete an erratum.  This method will only allow for deletion
 of custom errata created either through the UI or API.
<p />




Parameters:<br />
<ul>
<li>

        string sessionKey
 </li>
<li>

    string advisoryName
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

<h3> <a name="findByCve" href="#top">Method: findByCve</a></h3>
Description:<br />
Lookup the details for errata associated with the given CVE
 (e.g. CVE-2008-3270)
<p />




Parameters:<br />
<ul>
<li>

        string sessionKey
 </li>
<li>

    string cveName
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
              <li> int "id" - Errata Id </li>
              <li> string "date" - Date erratum was created. </li>
              <li> string "advisory_type" - Type of the advisory. </li>
              <li> string "advisory_name" - Name of the advisory. </li>
              <li> string "advisory_synopsis" - Summary of the erratum. </li>
     	</ul>
 
          </li></ul>
 
</li></ul>
</code>
<p />
<hr />

<h3> <a name="getDetails" href="#top">Method: getDetails</a></h3>
Description:<br />
Retrieves the details for the erratum matching the given
 advisory name.
<p />




Parameters:<br />
<ul>
<li>

        string sessionKey
 </li>
<li>

    string advisoryName
 </li>
</ul>
<p />
Returns:
<code><ul><li>


	     struct - erratum
	<ul>
          	<li> int "id"</li>
          	<li> string "issue_date"</li>
          	<li> string "update_date"</li>
              <li> string "last_modified_date" - This date is only included for
          published erratum and it represents the last time the erratum was
          modified. </li>
          	<li> string "synopsis"</li>
          	<li> int "release"</li>
          	<li> string "type"</li>
          	<li> string "product"</li>
          	<li> string "errataFrom"</li>
          	<li> string "topic"</li>
          	<li> string "description"</li>
          	<li> string "references"</li>
          	<li> string "notes"</li>
          	<li> string "solution"</li>
     	</ul>
 
</li></ul>
</code>
<p />
<hr />

<h3> <a name="listAffectedSystems" href="#top">Method: listAffectedSystems</a></h3>
Description:<br />
Return the list of systems affected by the erratum with
 advisory name.
<p />




Parameters:<br />
<ul>
<li>

        string sessionKey
 </li>
<li>

    string advisoryName
 </li>
</ul>
<p />
Returns:
<code><ul><li>


array:
  <ul>
   <li>
          

	     struct - system
	<ul>
      	<li> int "id"</li>
      	<li> string "name"</li>
           <li> dateTime.iso8601 "last_checkin" - Last time server
              successfully checked in </li>
           <li> dateTime.iso8601 "last_boot" - Last server boot time </li>
           <li> dateTime.iso8601 "created" - Server registration time </li>

 	</ul>
 
      </li></ul>
 
</li></ul>
</code>
<p />
<hr />

<h3 class="deprecated"><a name="listByDate" href="#top">Method: listByDate</a></h3>
Description:<br />
List errata that have been applied to a particular channel by date.
<p />


Deprecated - being replaced by channel.software.listErrata(User LoggedInUser,
 string channelLabel) <p />


Parameters:<br />
<ul>
<li>

        string sessionKey
 </li>
<li>

    string channelLabel
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
              <li> int "id" - Errata Id </li>
              <li> string "date" - Date erratum was created. </li>
              <li> string "advisory_type" - Type of the advisory. </li>
              <li> string "advisory_name" - Name of the advisory. </li>
              <li> string "advisory_synopsis" - Summary of the erratum. </li>
     	</ul>
 
          </li></ul>
 
</li></ul>
</code>
<p />
<hr />

<h3> <a name="listCves" href="#top">Method: listCves</a></h3>
Description:<br />
Returns a list of
 <a href="http://cve.mitre.org/" target="_blank">CVE</a>s
 applicable to the erratum with the given advisory name. CVEs may be associated
 only with published errata.
<p />




Parameters:<br />
<ul>
<li>

        string sessionKey
 </li>
<li>

    string advisoryName
 </li>
</ul>
<p />
Returns:
<code><ul><li>


array:
<ul>
    <li>string - cveName</li>
</ul>
 
</li></ul>
</code>
<p />
<hr />

<h3> <a name="listKeywords" href="#top">Method: listKeywords</a></h3>
Description:<br />
Get the keywords associated with an erratum matching the
 given advisory name.
<p />




Parameters:<br />
<ul>
<li>

        string sessionKey
 </li>
<li>

    string advisoryName
 </li>
</ul>
<p />
Returns:
<code><ul><li>


array:
<ul>
    <li>string - Keyword associated with erratum.</li>
</ul>
 
</li></ul>
</code>
<p />
<hr />

<h3> <a name="listPackages" href="#top">Method: listPackages</a></h3>
Description:<br />
Returns a list of the packages affected by the erratum
 with the given advisory name.
<p />




Parameters:<br />
<ul>
<li>

        string sessionKey
 </li>
<li>

    string advisoryName
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
                  	<li> int "id"</li>
                  	<li> string "name"</li>
                  	<li> string "epoch"</li>
                  	<li> string "version"</li>
                  	<li> string "release"</li>
                  	<li> string "arch_label"</li>
                      <li>array "providing_channels"
        <ul>
            <li>string - Channel label
                              providing this package.</li>
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
                  	<li> string "path"</li>
                  	<li> string "file"</li>
                  	<li> string "build_date"</li>
                  	<li> string "last_modified_date"</li>
                  	<li> string "size"</li>
                  	<li> string "payload_size"</li>
               	</ul>
           </li></ul>
 
</li></ul>
</code>
<p />
<hr />

<h3> <a name="listUnpublishedErrata" href="#top">Method: listUnpublishedErrata</a></h3>
Description:<br />
Returns a list of unpublished errata
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
          	     struct - erratum
	<ul>
              	<li> int "id"</li>
              	<li> int "published"</li>
              	<li> string "advisory"</li>
              	<li> string "advisory_name"</li>
              	<li> string "advisory_type"</li>
              	<li> string "synopsis"</li>
              	<li> dateTime.iso8601 "created"</li>
              	<li> dateTime.iso8601 "update_date"</li>
          	</ul>
      </li></ul>
 
</li></ul>
</code>
<p />
<hr />

<h3> <a name="publish" href="#top">Method: publish</a></h3>
Description:<br />
Publish an existing (unpublished) errata to a set of channels.
<p />




Parameters:<br />
<ul>
<li>

        string sessionKey
 </li>
<li>

    string advisoryName
 </li>
<li>

array:
<ul>
    <li>string - channelLabel - list of channel labels to publish to</li>
</ul>
 </li>
</ul>
<p />
Returns:
<code><ul><li>




	     struct - errata
	<ul>
              <li> int "id" - Errata Id </li>
              <li> string "date" - Date erratum was created. </li>
              <li> string "advisory_type" - Type of the advisory. </li>
              <li> string "advisory_name" - Name of the advisory. </li>
              <li> string "advisory_synopsis" - Summary of the erratum. </li>
     	</ul>
  
 
</li></ul>
</code>
<p />
<hr />

<h3> <a name="publishAsOriginal" href="#top">Method: publishAsOriginal</a></h3>
Description:<br />
Publishes an existing (unpublished) cloned errata to a set of cloned
 channels according to its original erratum
<p />




Parameters:<br />
<ul>
<li>

        string sessionKey
 </li>
<li>

    string advisoryName
 </li>
<li>

array:
<ul>
    <li>string - channelLabel - list of channel labels to publish to</li>
</ul>
 </li>
</ul>
<p />
Returns:
<code><ul><li>




	     struct - errata
	<ul>
              <li> int "id" - Errata Id </li>
              <li> string "date" - Date erratum was created. </li>
              <li> string "advisory_type" - Type of the advisory. </li>
              <li> string "advisory_name" - Name of the advisory. </li>
              <li> string "advisory_synopsis" - Summary of the erratum. </li>
     	</ul>
  
 
</li></ul>
</code>
<p />
<hr />

<h3> <a name="removePackages" href="#top">Method: removePackages</a></h3>
Description:<br />
Remove a set of packages from an erratum
 with the given advisory name.  This method will only allow for modification
 of custom errata created either through the UI or API.
<p />




Parameters:<br />
<ul>
<li>

        string sessionKey
 </li>
<li>

    string advisoryName
 </li>
<li>

array:
<ul>
    <li>int - packageId</li>
</ul>
 </li>
</ul>
<p />
Returns:
<code><ul><li>


int - representing the number of packages removed,
 exception otherwise 
 
</li></ul>
</code>
<p />
<hr />

<h3> <a name="setDetails" href="#top">Method: setDetails</a></h3>
Description:<br />
Set erratum details. All arguments are optional and will only be modified
 if included in the struct. This method will only allow for modification of custom
 errata created either through the UI or API.
<p />




Parameters:<br />
<ul>
<li>

    string sessionKey
 </li>
<li>

    string advisoryName
 </li>
<li>

	     struct - errata details
	<ul>
          	<li> string "synopsis"</li>
          	<li> string "advisory_name"</li>
          	<li> int "advisory_release"</li>
              <li> string "advisory_type" - Type of advisory (one of the
                  following: 'Security Advisory', 'Product Enhancement Advisory',
                  or 'Bug Fix Advisory' </li>
          	<li> string "product"</li>
          	<li> dateTime.iso8601 "issue_date"</li>
          	<li> dateTime.iso8601 "update_date"</li>
          	<li> string "errataFrom"</li>
          	<li> string "topic"</li>
          	<li> string "description"</li>
          	<li> string "references"</li>
          	<li> string "notes"</li>
          	<li> string "solution"</li>
              <li> string "severity" - Severity of advisory (one of the
                  following: 'Low', 'Moderate', 'Important', 'Critical'
                  or 'Unspecified' </li>
              <li> array "bugs" - 'bugs' is the key into the struct </li>
              array:
  <ul>
   <li>
                 	     struct - bug
	<ul>
                        <li> int "id" - Bug Id </li>
                    	<li> string "summary"</li>
                    	<li> string "url"</li>
                 	</ul>
              </li></ul>
              <li> array "keywords" - 'keywords' is the key into the struct </li>
              array:
<ul>
    <li>string - keyword - List of keywords to associate
                  with the errata.</li>
</ul>
              <li> array "CVEs" - 'cves' is the key into the struct </li>
              array:
<ul>
    <li>string - cves - List of CVEs to associate
                  with the errata. (valid only for published errata)</li>
</ul>
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
</body>
</html>
