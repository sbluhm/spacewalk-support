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
channel.software
</p>
<p>Provides methods to access and modify many aspects of a channel.</p>
<span class="small-text">( <a href="/rhn/apidoc/index.jsp">Return to API Overview</a> )</span>
<hr />

<div class="rounded-box">
<h2><a name="top">Available methods</a></h2>
<ul class="apidoc">

<li><a href="#addPackages"/>addPackages</a></li>
<li><a href="#addRepoFilter"/>addRepoFilter</a></li>
<li><a href="#associateRepo"/>associateRepo</a></li>
<li><a href="#clearRepoFilters"/>clearRepoFilters</a></li>
<li><a href="#clone"/>clone</a></li>
<li><a href="#create"/>create</a></li>
<li><a href="#create"/>create</a></li>
<li><a href="#create"/>create</a></li>
<li><a href="#createRepo"/>createRepo</a></li>
<li><a href="#createRepo"/>createRepo</a></li>
<li><a href="#delete"/>delete</a></li>
<li><a href="#disassociateRepo"/>disassociateRepo</a></li>
<li><a href="#getChannelLastBuildById"/>getChannelLastBuildById</a></li>
<li><a href="#getDetails"/>getDetails</a></li>
<li><a href="#getDetails"/>getDetails</a></li>
<li><a href="#getRepoDetails"/>getRepoDetails</a></li>
<li><a href="#getRepoDetails"/>getRepoDetails</a></li>
<li><a href="#getRepoSyncCronExpression"/>getRepoSyncCronExpression</a></li>
<li><a href="#isGloballySubscribable"/>isGloballySubscribable</a></li>
<li><a href="#isUserManageable"/>isUserManageable</a></li>
<li><a href="#isUserSubscribable"/>isUserSubscribable</a></li>
<li><a href="#listAllPackages"/>listAllPackages</a></li>
<li><a href="#listAllPackages"/>listAllPackages</a></li>
<li><a href="#listAllPackages"/>listAllPackages</a></li>
<li><a href="#listAllPackages"/>listAllPackages</a></li>
<li><a href="#listAllPackages"/>listAllPackages</a></li>
<li><a href="#listAllPackagesByDate"/>listAllPackagesByDate</a></li>
<li><a href="#listAllPackagesByDate"/>listAllPackagesByDate</a></li>
<li><a href="#listAllPackagesByDate"/>listAllPackagesByDate</a></li>
<li><a href="#listArches"/>listArches</a></li>
<li><a href="#listChannelRepos"/>listChannelRepos</a></li>
<li><a href="#listChildren"/>listChildren</a></li>
<li><a href="#listErrata"/>listErrata</a></li>
<li><a href="#listErrata"/>listErrata</a></li>
<li><a href="#listErrata"/>listErrata</a></li>
<li><a href="#listErrata"/>listErrata</a></li>
<li><a href="#listErrata"/>listErrata</a></li>
<li><a href="#listErrata"/>listErrata</a></li>
<li><a href="#listErrataByType"/>listErrataByType</a></li>
<li><a href="#listErrataNeedingSync"/>listErrataNeedingSync</a></li>
<li><a href="#listLatestPackages"/>listLatestPackages</a></li>
<li><a href="#listPackagesWithoutChannel"/>listPackagesWithoutChannel</a></li>
<li><a href="#listRepoFilters"/>listRepoFilters</a></li>
<li><a href="#listSubscribedSystems"/>listSubscribedSystems</a></li>
<li><a href="#listSystemChannels"/>listSystemChannels</a></li>
<li><a href="#listUserRepos"/>listUserRepos</a></li>
<li><a href="#mergeErrata"/>mergeErrata</a></li>
<li><a href="#mergeErrata"/>mergeErrata</a></li>
<li><a href="#mergeErrata"/>mergeErrata</a></li>
<li><a href="#mergePackages"/>mergePackages</a></li>
<li><a href="#regenerateNeededCache"/>regenerateNeededCache</a></li>
<li><a href="#regenerateNeededCache"/>regenerateNeededCache</a></li>
<li><a href="#regenerateYumCache"/>regenerateYumCache</a></li>
<li><a href="#removeErrata"/>removeErrata</a></li>
<li><a href="#removePackages"/>removePackages</a></li>
<li><a href="#removeRepo"/>removeRepo</a></li>
<li><a href="#removeRepo"/>removeRepo</a></li>
<li><a href="#removeRepoFilter"/>removeRepoFilter</a></li>
<li><a href="#setContactDetails"/>setContactDetails</a></li>
<li><a href="#setDetails"/>setDetails</a></li>
<li><a href="#setDetails"/>setDetails</a></li>
<li><a href="#setGloballySubscribable"/>setGloballySubscribable</a></li>
<li><a href="#setRepoFilters"/>setRepoFilters</a></li>
<li><a href="#setSystemChannels"/>setSystemChannels</a></li>
<li><a href="#setUserManageable"/>setUserManageable</a></li>
<li><a href="#setUserSubscribable"/>setUserSubscribable</a></li>
<li><a href="#subscribeSystem"/>subscribeSystem</a></li>
<li><a href="#syncErrata"/>syncErrata</a></li>
<li><a href="#syncRepo"/>syncRepo</a></li>
<li><a href="#syncRepo"/>syncRepo</a></li>
<li><a href="#syncRepo"/>syncRepo</a></li>
<li><a href="#syncRepo"/>syncRepo</a></li>
<li><a href="#updateRepo"/>updateRepo</a></li>
<li><a href="#updateRepoLabel"/>updateRepoLabel</a></li>
<li><a href="#updateRepoLabel"/>updateRepoLabel</a></li>
<li><a href="#updateRepoSsl"/>updateRepoSsl</a></li>
<li><a href="#updateRepoSsl"/>updateRepoSsl</a></li>
<li><a href="#updateRepoUrl"/>updateRepoUrl</a></li>
<li><a href="#updateRepoUrl"/>updateRepoUrl</a></li>
</ul>
</div>
<hr />

<h3> <a name="addPackages" href="#top">Method: addPackages</a></h3>
Description:<br />
Adds a given list of packages to the given channel.
<p />




Parameters:<br />
<ul>
<li>

        string sessionKey
 </li>
<li>

    string channelLabel - target channel.
 </li>
<li>

array:
<ul>
    <li>int - packageId -  id of a package to
                                   add to the channel.</li>
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

<h3> <a name="addRepoFilter" href="#top">Method: addRepoFilter</a></h3>
Description:<br />
Adds a filter for a given repo.
<p />




Parameters:<br />
<ul>
<li>

    string sessionKey 
 </li>
<li>

    string label - repository label
 </li>
<li>

	     struct - filter_map
	<ul>
              <li> string "filter" - string to filter on </li>
              <li> string "flag" - + for include, - for exclude </li>
  	</ul>
 </li>
</ul>
<p />
Returns:
<code><ul><li>


int sort order for new filter 
 
</li></ul>
</code>
<p />
<hr />

<h3> <a name="associateRepo" href="#top">Method: associateRepo</a></h3>
Description:<br />
Associates a repository with a channel
<p />




Parameters:<br />
<ul>
<li>

        string sessionKey
 </li>
<li>

    string channelLabel - channel label
 </li>
<li>

    string repoLabel - repository label
 </li>
</ul>
<p />
Returns:
<code><ul><li>




	     struct - channel
	<ul>
      	<li> int "id"</li>
      	<li> string "name"</li>
      	<li> string "label"</li>
      	<li> string "arch_name"</li>
      	<li> string "arch_label"</li>
      	<li> string "summary"</li>
      	<li> string "description"</li>
      	<li> string "checksum_label"</li>
      	<li> dateTime.iso8601 "last_modified"</li>
      	<li> string "maintainer_name"</li>
      	<li> string "maintainer_email"</li>
      	<li> string "maintainer_phone"</li>
      	<li> string "support_policy"</li>
      	<li> string "gpg_key_url"</li>
      	<li> string "gpg_key_id"</li>
      	<li> string "gpg_key_fp"</li>
          <li> dateTime.iso8601 "yumrepo_last_sync" - (optional) </li>
      	<li> string "end_of_life"</li>
      	<li> string "parent_channel_label"</li>
      	<li> string "clone_original"</li>
      array:
  <ul>
   <li>
          	     struct - contentSources
	<ul>
              	<li> int "id"</li>
              	<li> string "label"</li>
              	<li> string "sourceUrl"</li>
              	<li> string "type"</li>
          	</ul>
      </li></ul>
  	</ul>
  
 
</li></ul>
</code>
<p />
<hr />

<h3> <a name="clearRepoFilters" href="#top">Method: clearRepoFilters</a></h3>
Description:<br />
Removes the filters for a repo
<p />




Parameters:<br />
<ul>
<li>

        string sessionKey
 </li>
<li>

    string label - repository label
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

<h3> <a name="clone" href="#top">Method: clone</a></h3>
Description:<br />
Clone a channel.  If arch_label is omitted, the arch label of the
      original channel will be used. If parent_label is omitted, the clone will be
      a base channel.
<p />




Parameters:<br />
<ul>
<li>

        string sessionKey
 </li>
<li>

    string original_label
 </li>
<li>

	     struct - channel details
	<ul>
          	<li> string "name"</li>
          	<li> string "label"</li>
          	<li> string "summary"</li>
              <li> string "parent_label" - (optional) </li>
              <li> string "arch_label" - (optional) </li>
              <li> string "gpg_key_url" - (optional),
              gpg_url might be used as well </li>
              <li> string "gpg_key_id" - (optional),
              gpg_id might be used as well </li>
              <li> string "gpg_key_fp" - (optional),
              gpg_fingerprint might be used as well </li>
              <li> string "description" - (optional) </li>
              <li> string "checksum" - either sha1 or sha256 </li>
      	</ul>
 </li>
<li>

    boolean original_state
 </li>
</ul>
<p />
Returns:
<code><ul><li>


int the cloned channel ID 
 
</li></ul>
</code>
<p />
<hr />

<h3> <a name="create" href="#top">Method: create</a></h3>
Description:<br />
Creates a software channel
<p />




Parameters:<br />
<ul>
<li>

        string sessionKey
 </li>
<li>

    string label - label of the new channel
 </li>
<li>

    string name - name of the new channel
 </li>
<li>

    string summary - summary of the channel
 </li>
<li>

    string archLabel - the label of the architecture the channel corresponds to,
              see channel.software.listArches API for complete listing
 </li>
<li>

    string parentLabel - label of the parent of this
              channel, an empty string if it does not have one
 </li>
<li>

    string checksumType - checksum type for this channel,
              used for yum repository metadata generation
      	<ul>
          	<li>sha1 - Offers widest compatibility  with clients</li>
          	<li>sha256 - Offers highest security, but is compatible
                        only with newer clients: Fedora 11 and newer,
                        or Enterprise Linux 6 and newer.</li>
      	</ul>
 </li>
<li>

	     struct - gpgKey
	<ul>
              <li> string "url" - GPG key URL </li>
              <li> string "id" - GPG key ID </li>
              <li> string "fingerprint" - GPG key Fingerprint </li>
      	</ul>
 </li>
</ul>
<p />
Returns:
<code><ul><li>


int - 1 if the creation operation succeeded, 0 otherwise 
 
</li></ul>
</code>
<p />
Available since: 10.9 <p />
<hr />

<h3> <a name="create" href="#top">Method: create</a></h3>
Description:<br />
Creates a software channel
<p />




Parameters:<br />
<ul>
<li>

        string sessionKey
 </li>
<li>

    string label - label of the new channel
 </li>
<li>

    string name - name of the new channel
 </li>
<li>

    string summary - summary of the channel
 </li>
<li>

    string archLabel - the label of the architecture the channel corresponds to,
              see channel.software.listArches API for complete listing
 </li>
<li>

    string parentLabel - label of the parent of this
              channel, an empty string if it does not have one
 </li>
<li>

    string checksumType - checksum type for this channel,
              used for yum repository metadata generation
      	<ul>
          	<li>sha1 - Offers widest compatibility  with clients</li>
          	<li>sha256 - Offers highest security, but is compatible
                        only with newer clients: Fedora 11 and newer,
                        or Enterprise Linux 6 and newer.</li>
      	</ul>
 </li>
</ul>
<p />
Returns:
<code><ul><li>


int - 1 if the creation operation succeeded, 0 otherwise 
 
</li></ul>
</code>
<p />
Available since: 10.9 <p />
<hr />

<h3> <a name="create" href="#top">Method: create</a></h3>
Description:<br />
Creates a software channel
<p />




Parameters:<br />
<ul>
<li>

        string sessionKey
 </li>
<li>

    string label - label of the new channel
 </li>
<li>

    string name - name of the new channel
 </li>
<li>

    string summary - summary of the channel
 </li>
<li>

    string archLabel - the label of the architecture the channel corresponds to,
              see channel.software.listArches API for complete listing
 </li>
<li>

    string parentLabel - label of the parent of this
              channel, an empty string if it does not have one
 </li>
</ul>
<p />
Returns:
<code><ul><li>


int - 1 if the creation operation succeeded, 0 otherwise 
 
</li></ul>
</code>
<p />
<hr />

<h3> <a name="createRepo" href="#top">Method: createRepo</a></h3>
Description:<br />
Creates a repository
<p />




Parameters:<br />
<ul>
<li>

        string sessionKey
 </li>
<li>

    string label - repository label
 </li>
<li>

    string type - repository type (yum, uln...)
 </li>
<li>

    string url - repository url
 </li>
</ul>
<p />
Returns:
<code><ul><li>




	     struct - channel
	<ul>
      	<li> int "id"</li>
      	<li> string "label"</li>
      	<li> string "sourceUrl"</li>
      	<li> string "type"</li>
                              	<li> string "sslCaDesc"</li>
              	<li> string "sslCertDesc"</li>
              	<li> string "sslKeyDesc"</li>
          	</ul>
      </li></ul>
  	</ul>
  
 
</li></ul>
</code>
<p />
<hr />

<h3> <a name="createRepo" href="#top">Method: createRepo</a></h3>
Description:<br />
Creates a repository
<p />




Parameters:<br />
<ul>
<li>

        string sessionKey
 </li>
<li>

    string label - repository label
 </li>
<li>

    string type - repository type (yum, uln...)
 </li>
<li>

    string url - repository url
 </li>
<li>

    string sslCaCert - SSL CA cert description
 </li>
<li>

    string sslCliCert - SSL Client cert description
 </li>
<li>

    string sslCliKey - SSL Client key description
 </li>
</ul>
<p />
Returns:
<code><ul><li>




	     struct - channel
	<ul>
      	<li> int "id"</li>
      	<li> string "label"</li>
      	<li> string "sourceUrl"</li>
      	<li> string "type"</li>
                              	<li> string "sslCaDesc"</li>
              	<li> string "sslCertDesc"</li>
              	<li> string "sslKeyDesc"</li>
          	</ul>
      </li></ul>
  	</ul>
  
 
</li></ul>
</code>
<p />
<hr />

<h3> <a name="delete" href="#top">Method: delete</a></h3>
Description:<br />
Deletes a custom software channel
<p />




Parameters:<br />
<ul>
<li>

        string sessionKey
 </li>
<li>

    string channelLabel - channel to delete
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

<h3> <a name="disassociateRepo" href="#top">Method: disassociateRepo</a></h3>
Description:<br />
Disassociates a repository from a channel
<p />




Parameters:<br />
<ul>
<li>

        string sessionKey
 </li>
<li>

    string channelLabel - channel label
 </li>
<li>

    string repoLabel - repository label
 </li>
</ul>
<p />
Returns:
<code><ul><li>




	     struct - channel
	<ul>
      	<li> int "id"</li>
      	<li> string "name"</li>
      	<li> string "label"</li>
      	<li> string "arch_name"</li>
      	<li> string "arch_label"</li>
      	<li> string "summary"</li>
      	<li> string "description"</li>
      	<li> string "checksum_label"</li>
      	<li> dateTime.iso8601 "last_modified"</li>
      	<li> string "maintainer_name"</li>
      	<li> string "maintainer_email"</li>
      	<li> string "maintainer_phone"</li>
      	<li> string "support_policy"</li>
      	<li> string "gpg_key_url"</li>
      	<li> string "gpg_key_id"</li>
      	<li> string "gpg_key_fp"</li>
          <li> dateTime.iso8601 "yumrepo_last_sync" - (optional) </li>
      	<li> string "end_of_life"</li>
      	<li> string "parent_channel_label"</li>
      	<li> string "clone_original"</li>
      array:
  <ul>
   <li>
          	     struct - contentSources
	<ul>
              	<li> int "id"</li>
              	<li> string "label"</li>
              	<li> string "sourceUrl"</li>
              	<li> string "type"</li>
          	</ul>
      </li></ul>
  	</ul>
  
 
</li></ul>
</code>
<p />
<hr />

<h3> <a name="getChannelLastBuildById" href="#top">Method: getChannelLastBuildById</a></h3>
Description:<br />
Returns the last build date of the repomd.xml file
 for the given channel as a localised string.
<p />




Parameters:<br />
<ul>
<li>

        string sessionKey
 </li>
<li>

    int id - id of channel wanted
 </li>
</ul>
<p />
Returns:
<code><ul><li>


the last build date of the repomd.xml file
 as a localised string 
 
</li></ul>
</code>
<p />
<hr />

<h3> <a name="getDetails" href="#top">Method: getDetails</a></h3>
Description:<br />
Returns details of the given channel as a map
<p />




Parameters:<br />
<ul>
<li>

        string sessionKey
 </li>
<li>

    string channelLabel - channel to query
 </li>
</ul>
<p />
Returns:
<code><ul><li>




	     struct - channel
	<ul>
      	<li> int "id"</li>
      	<li> string "name"</li>
      	<li> string "label"</li>
      	<li> string "arch_name"</li>
      	<li> string "arch_label"</li>
      	<li> string "summary"</li>
      	<li> string "description"</li>
      	<li> string "checksum_label"</li>
      	<li> dateTime.iso8601 "last_modified"</li>
      	<li> string "maintainer_name"</li>
      	<li> string "maintainer_email"</li>
      	<li> string "maintainer_phone"</li>
      	<li> string "support_policy"</li>
      	<li> string "gpg_key_url"</li>
      	<li> string "gpg_key_id"</li>
      	<li> string "gpg_key_fp"</li>
          <li> dateTime.iso8601 "yumrepo_last_sync" - (optional) </li>
      	<li> string "end_of_life"</li>
      	<li> string "parent_channel_label"</li>
      	<li> string "clone_original"</li>
      array:
  <ul>
   <li>
          	     struct - contentSources
	<ul>
              	<li> int "id"</li>
              	<li> string "label"</li>
              	<li> string "sourceUrl"</li>
              	<li> string "type"</li>
          	</ul>
      </li></ul>
  	</ul>
  
 
</li></ul>
</code>
<p />
<hr />

<h3> <a name="getDetails" href="#top">Method: getDetails</a></h3>
Description:<br />
Returns details of the given channel as a map
<p />




Parameters:<br />
<ul>
<li>

        string sessionKey
 </li>
<li>

    int id - channel to query
 </li>
</ul>
<p />
Returns:
<code><ul><li>




	     struct - channel
	<ul>
      	<li> int "id"</li>
      	<li> string "name"</li>
      	<li> string "label"</li>
      	<li> string "arch_name"</li>
      	<li> string "arch_label"</li>
      	<li> string "summary"</li>
      	<li> string "description"</li>
      	<li> string "checksum_label"</li>
      	<li> dateTime.iso8601 "last_modified"</li>
      	<li> string "maintainer_name"</li>
      	<li> string "maintainer_email"</li>
      	<li> string "maintainer_phone"</li>
      	<li> string "support_policy"</li>
      	<li> string "gpg_key_url"</li>
      	<li> string "gpg_key_id"</li>
      	<li> string "gpg_key_fp"</li>
          <li> dateTime.iso8601 "yumrepo_last_sync" - (optional) </li>
      	<li> string "end_of_life"</li>
      	<li> string "parent_channel_label"</li>
      	<li> string "clone_original"</li>
      array:
  <ul>
   <li>
          	     struct - contentSources
	<ul>
              	<li> int "id"</li>
              	<li> string "label"</li>
              	<li> string "sourceUrl"</li>
              	<li> string "type"</li>
          	</ul>
      </li></ul>
  	</ul>
  
 
</li></ul>
</code>
<p />
<hr />

<h3> <a name="getRepoDetails" href="#top">Method: getRepoDetails</a></h3>
Description:<br />
Returns details of the given repository
<p />




Parameters:<br />
<ul>
<li>

        string sessionKey
 </li>
<li>

    string repoLabel - repo to query
 </li>
</ul>
<p />
Returns:
<code><ul><li>




	     struct - channel
	<ul>
      	<li> int "id"</li>
      	<li> string "label"</li>
      	<li> string "sourceUrl"</li>
      	<li> string "type"</li>
                              	<li> string "sslCaDesc"</li>
              	<li> string "sslCertDesc"</li>
              	<li> string "sslKeyDesc"</li>
          	</ul>
      </li></ul>
  	</ul>
  
 
</li></ul>
</code>
<p />
<hr />

<h3> <a name="getRepoDetails" href="#top">Method: getRepoDetails</a></h3>
Description:<br />
Returns details of the given repo
<p />




Parameters:<br />
<ul>
<li>

        string sessionKey
 </li>
<li>

    string repoLabel - repo to query
 </li>
</ul>
<p />
Returns:
<code><ul><li>




	     struct - channel
	<ul>
      	<li> int "id"</li>
      	<li> string "label"</li>
      	<li> string "sourceUrl"</li>
      	<li> string "type"</li>
                              	<li> string "sslCaDesc"</li>
              	<li> string "sslCertDesc"</li>
              	<li> string "sslKeyDesc"</li>
          	</ul>
      </li></ul>
  	</ul>
  
 
</li></ul>
</code>
<p />
<hr />

<h3> <a name="getRepoSyncCronExpression" href="#top">Method: getRepoSyncCronExpression</a></h3>
Description:<br />
Returns repo synchronization cron expression
<p />




Parameters:<br />
<ul>
<li>

        string sessionKey
 </li>
<li>

    string channelLabel - channel label
 </li>
</ul>
<p />
Returns:
<code><ul><li>


string quartz expression 
 
</li></ul>
</code>
<p />
<hr />

<h3> <a name="isGloballySubscribable" href="#top">Method: isGloballySubscribable</a></h3>
Description:<br />
Returns whether the channel is subscribable by any user
 in the organization
<p />




Parameters:<br />
<ul>
<li>

        string sessionKey
 </li>
<li>

    string channelLabel - channel to query
 </li>
</ul>
<p />
Returns:
<code><ul><li>


int - 1 if true, 0 otherwise 
 
</li></ul>
</code>
<p />
<hr />

<h3> <a name="isUserManageable" href="#top">Method: isUserManageable</a></h3>
Description:<br />
Returns whether the channel may be managed by the given user.
<p />




Parameters:<br />
<ul>
<li>

        string sessionKey
 </li>
<li>

    string channelLabel - label of the channel
 </li>
<li>

    string login - login of the target user
 </li>
</ul>
<p />
Returns:
<code><ul><li>


int - 1 if manageable, 0 if not 
 
</li></ul>
</code>
<p />
<hr />

<h3> <a name="isUserSubscribable" href="#top">Method: isUserSubscribable</a></h3>
Description:<br />
Returns whether the channel may be subscribed to by the given user.
<p />




Parameters:<br />
<ul>
<li>

        string sessionKey
 </li>
<li>

    string channelLabel - label of the channel
 </li>
<li>

    string login - login of the target user
 </li>
</ul>
<p />
Returns:
<code><ul><li>


int - 1 if subscribable, 0 if not 
 
</li></ul>
</code>
<p />
<hr />

<h3> <a name="listAllPackages" href="#top">Method: listAllPackages</a></h3>
Description:<br />
Lists all packages in the channel, regardless of package version,
 between the given dates.
<p />




Parameters:<br />
<ul>
<li>

        string sessionKey
 </li>
<li>

    string channelLabel - channel to query
 </li>
<li>

    dateTime.iso8601 startDate
 </li>
<li>

    dateTime.iso8601 endDate
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
      	<li> string "checksum"</li>
      	<li> string "checksum_type"</li>
      	<li> int "id"</li>
      	<li> string "arch_label"</li>
      	<li> string "last_modified_date"</li>
          <li> string "last_modified" - (Deprecated) </li>
  	</ul>
 
      </li></ul>
 
</li></ul>
</code>
<p />
<hr />

<h3> <a name="listAllPackages" href="#top">Method: listAllPackages</a></h3>
Description:<br />
Lists all packages in the channel, regardless of version whose last
 modified date is greater than given date.
<p />




Parameters:<br />
<ul>
<li>

        string sessionKey
 </li>
<li>

    string channelLabel - channel to query
 </li>
<li>

    dateTime.iso8601 startDate
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
      	<li> string "checksum"</li>
      	<li> string "checksum_type"</li>
      	<li> int "id"</li>
      	<li> string "arch_label"</li>
      	<li> string "last_modified_date"</li>
          <li> string "last_modified" - (Deprecated) </li>
  	</ul>
 
      </li></ul>
 
</li></ul>
</code>
<p />
<hr />

<h3> <a name="listAllPackages" href="#top">Method: listAllPackages</a></h3>
Description:<br />
Lists all packages in the channel, regardless of the package version
<p />




Parameters:<br />
<ul>
<li>

        string sessionKey
 </li>
<li>

    string channelLabel - channel to query
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
      	<li> string "checksum"</li>
      	<li> string "checksum_type"</li>
      	<li> int "id"</li>
      	<li> string "arch_label"</li>
      	<li> string "last_modified_date"</li>
          <li> string "last_modified" - (Deprecated) </li>
  	</ul>
 
      </li></ul>
 
</li></ul>
</code>
<p />
<hr />

<h3 class="deprecated"><a name="listAllPackages" href="#top">Method: listAllPackages</a></h3>
Description:<br />
Lists all packages in the channel, regardless of package version,
 between the given dates.
 Example Date:  '2008-08-20 08:00:00'
<p />


Deprecated - being replaced by listAllPackages(string sessionKey,
 string channelLabel, dateTime.iso8601 startDate, dateTime.iso8601 endDate) <p />


Parameters:<br />
<ul>
<li>

        string sessionKey
 </li>
<li>

    string channelLabel - channel to query
 </li>
<li>

    string startDate
 </li>
<li>

    string endDate
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
      	<li> string "checksum"</li>
      	<li> string "checksum_type"</li>
      	<li> int "id"</li>
      	<li> string "arch_label"</li>
      	<li> string "last_modified_date"</li>
          <li> string "last_modified" - (Deprecated) </li>
  	</ul>
 
      </li></ul>
 
</li></ul>
</code>
<p />
<hr />

<h3 class="deprecated"><a name="listAllPackages" href="#top">Method: listAllPackages</a></h3>
Description:<br />
Lists all packages in the channel, regardless of version whose last
 modified date is greater than given date. Example Date: '2008-08-20 08:00:00'
<p />


Deprecated - being replaced by listAllPackages(string sessionKey,
 string channelLabel, dateTime.iso8601 startDate) <p />


Parameters:<br />
<ul>
<li>

        string sessionKey
 </li>
<li>

    string channelLabel - channel to query
 </li>
<li>

    string startDate
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
      	<li> string "checksum"</li>
      	<li> string "checksum_type"</li>
      	<li> int "id"</li>
      	<li> string "arch_label"</li>
      	<li> string "last_modified_date"</li>
          <li> string "last_modified" - (Deprecated) </li>
  	</ul>
 
      </li></ul>
 
</li></ul>
</code>
<p />
<hr />

<h3 class="deprecated"><a name="listAllPackagesByDate" href="#top">Method: listAllPackagesByDate</a></h3>
Description:<br />
Lists all packages in the channel, regardless of the package version,
 between the given dates. Example Date: '2008-08-20 08:00:00'
<p />


Deprecated - being replaced by listAllPackages(string sessionKey,
 string channelLabel, dateTime.iso8601 startDate, dateTime.iso8601 endDate) <p />


Parameters:<br />
<ul>
<li>

        string sessionKey
 </li>
<li>

    string channelLabel - channel to query
 </li>
<li>

    string startDate
 </li>
<li>

    string endDate
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
              	<li> string "id"</li>
              	<li> string "arch_label"</li>
              	<li> string "last_modified"</li>
          	</ul>
      </li></ul>
 
</li></ul>
</code>
<p />
<hr />

<h3 class="deprecated"><a name="listAllPackagesByDate" href="#top">Method: listAllPackagesByDate</a></h3>
Description:<br />
Lists all packages in the channel, regardless of the package version,
 whose last modified date is greater than given date.
 Example Date:  '2008-08-20 08:00:00'
<p />


Deprecated - being replaced by listAllPackages(string sessionKey,
 string channelLabel, dateTime.iso8601 startDate) <p />


Parameters:<br />
<ul>
<li>

        string sessionKey
 </li>
<li>

    string channelLabel - channel to query
 </li>
<li>

    string startDate
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
              	<li> string "id"</li>
              	<li> string "arch_label"</li>
              	<li> string "last_modified"</li>
          	</ul>
      </li></ul>
 
</li></ul>
</code>
<p />
<hr />

<h3 class="deprecated"><a name="listAllPackagesByDate" href="#top">Method: listAllPackagesByDate</a></h3>
Description:<br />
Lists all packages in the channel, regardless of the package version
<p />


Deprecated - being replaced by listAllPackages(string sessionKey,
 string channelLabel) <p />


Parameters:<br />
<ul>
<li>

        string sessionKey
 </li>
<li>

    string channelLabel - channel to query
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
              	<li> string "id"</li>
              	<li> string "arch_label"</li>
              	<li> string "last_modified"</li>
          	</ul>
      </li></ul>
 
</li></ul>
</code>
<p />
<hr />

<h3> <a name="listArches" href="#top">Method: listArches</a></h3>
Description:<br />
Lists the potential software channel architectures that can be created
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
              

	     struct - channel arch
	<ul>
          	<li> string "name"</li>
          	<li> string "label"</li>
      	</ul>
 
          </li></ul>
 
</li></ul>
</code>
<p />
<hr />

<h3> <a name="listChannelRepos" href="#top">Method: listChannelRepos</a></h3>
Description:<br />
Lists associated repos with the given channel
<p />




Parameters:<br />
<ul>
<li>

        string sessionKey
 </li>
<li>

    string channelLabel - channel label
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
      	<li> int "id"</li>
      	<li> string "label"</li>
      	<li> string "sourceUrl"</li>
      	<li> string "type"</li>
                              	<li> string "sslCaDesc"</li>
              	<li> string "sslCertDesc"</li>
              	<li> string "sslKeyDesc"</li>
          	</ul>
      </li></ul>
  	</ul>
 
      </li></ul>
 
</li></ul>
</code>
<p />
<hr />

<h3> <a name="listChildren" href="#top">Method: listChildren</a></h3>
Description:<br />
List the children of a channel
<p />




Parameters:<br />
<ul>
<li>

        string sessionKey
 </li>
<li>

    string channelLabel - the label of the channel
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
      	<li> int "id"</li>
      	<li> string "name"</li>
      	<li> string "label"</li>
      	<li> string "arch_name"</li>
      	<li> string "arch_label"</li>
      	<li> string "summary"</li>
      	<li> string "description"</li>
      	<li> string "checksum_label"</li>
      	<li> dateTime.iso8601 "last_modified"</li>
      	<li> string "maintainer_name"</li>
      	<li> string "maintainer_email"</li>
      	<li> string "maintainer_phone"</li>
      	<li> string "support_policy"</li>
      	<li> string "gpg_key_url"</li>
      	<li> string "gpg_key_id"</li>
      	<li> string "gpg_key_fp"</li>
          <li> dateTime.iso8601 "yumrepo_last_sync" - (optional) </li>
      	<li> string "end_of_life"</li>
      	<li> string "parent_channel_label"</li>
      	<li> string "clone_original"</li>
      array:
  <ul>
   <li>
          	     struct - contentSources
	<ul>
              	<li> int "id"</li>
              	<li> string "label"</li>
              	<li> string "sourceUrl"</li>
              	<li> string "type"</li>
          	</ul>
      </li></ul>
  	</ul>
 
      </li></ul>
 
</li></ul>
</code>
<p />
<hr />

<h3> <a name="listErrata" href="#top">Method: listErrata</a></h3>
Description:<br />
List the errata applicable to a channel after given startDate
<p />




Parameters:<br />
<ul>
<li>

        string sessionKey
 </li>
<li>

    string channelLabel - channel to query
 </li>
<li>

    dateTime.iso8601 startDate
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
              <li> int "id" - Errata ID. </li>
              <li> string "date" - Date erratum was created. </li>
              <li> string "update_date" - Date erratum was updated. </li>
              <li> string "advisory_synopsis" - Summary of the erratum. </li>
              <li> string "advisory_type" - Type label such as Security, Bug Fix </li>
              <li> string "advisory_name" - Name such as RHSA, etc </li>
      	</ul>
 
      </li></ul>
 
</li></ul>
</code>
<p />
<hr />

<h3> <a name="listErrata" href="#top">Method: listErrata</a></h3>
Description:<br />
List the errata applicable to a channel between startDate and endDate.
<p />




Parameters:<br />
<ul>
<li>

        string sessionKey
 </li>
<li>

    string channelLabel - channel to query
 </li>
<li>

    dateTime.iso8601 startDate
 </li>
<li>

    dateTime.iso8601 endDate
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
              <li> int "id" - Errata ID. </li>
              <li> string "date" - Date erratum was created. </li>
              <li> string "update_date" - Date erratum was updated. </li>
              <li> string "advisory_synopsis" - Summary of the erratum. </li>
              <li> string "advisory_type" - Type label such as Security, Bug Fix </li>
              <li> string "advisory_name" - Name such as RHSA, etc </li>
      	</ul>
 
      </li></ul>
 
</li></ul>
</code>
<p />
<hr />

<h3> <a name="listErrata" href="#top">Method: listErrata</a></h3>
Description:<br />
List the errata applicable to a channel between startDate and endDate.
<p />




Parameters:<br />
<ul>
<li>

        string sessionKey
 </li>
<li>

    string channelLabel - channel to query
 </li>
<li>

    dateTime.iso8601 startDate
 </li>
<li>

    dateTime.iso8601 endDate
 </li>
<li>

    boolean lastModified - select by last modified or not
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
              <li> int "id" - Errata ID. </li>
              <li> string "date" - Date erratum was created. </li>
              <li> string "update_date" - Date erratum was updated. </li>
              <li> string "advisory_synopsis" - Summary of the erratum. </li>
              <li> string "advisory_type" - Type label such as Security, Bug Fix </li>
              <li> string "advisory_name" - Name such as RHSA, etc </li>
      	</ul>
 
      </li></ul>
 
</li></ul>
</code>
<p />
<hr />

<h3> <a name="listErrata" href="#top">Method: listErrata</a></h3>
Description:<br />
List the errata applicable to a channel
<p />




Parameters:<br />
<ul>
<li>

        string sessionKey
 </li>
<li>

    string channelLabel - channel to query
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
            <li> string "advisory_synopsis" - Summary of the erratum. </li>
            <li> string "advisory_type" - Type label such as Security, Bug Fix </li>
            <li> string "advisory_name" - Name such as RHSA, etc </li>
            <li> string "advisory" - name of the advisory (Deprecated) </li>
            <li> string "issue_date" - date format follows YYYY-MM-DD HH24:MI:SS (Deprecated) </li>
            <li> string "update_date" - date format follows YYYY-MM-DD HH24:MI:SS (Deprecated) </li>
        	<li> string "synopsis (Deprecated)"</li>
            <li> string "last_modified_date" - date format follows YYYY-MM-DD HH24:MI:SS (Deprecated) </li>
      	</ul>
    </li></ul>
 
</li></ul>
</code>
<p />
<hr />

<h3 class="deprecated"><a name="listErrata" href="#top">Method: listErrata</a></h3>
Description:<br />
List the errata applicable to a channel after given startDate
<p />


Deprecated - being replaced by listErrata(string sessionKey,
 string channelLabel, dateTime.iso8601 startDate) <p />


Parameters:<br />
<ul>
<li>

        string sessionKey
 </li>
<li>

    string channelLabel - channel to query
 </li>
<li>

    string startDate
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
                  <li> string "advisory" - name of the advisory </li>
                  <li> string "issue_date" - date format follows YYYY-MM-DD HH24:MI:SS </li>
                  <li> string "update_date" - date format follows YYYY-MM-DD HH24:MI:SS </li>
              	<li> string "synopsis"</li>
              	<li> string "advisory_type"</li>
                  <li> string "last_modified_date" - date format follows YYYY-MM-DD HH24:MI:SS </li>
          	</ul>
      </li></ul>
 
</li></ul>
</code>
<p />
<hr />

<h3 class="deprecated"><a name="listErrata" href="#top">Method: listErrata</a></h3>
Description:<br />
List the errata applicable to a channel between startDate and endDate.
<p />


Deprecated - being replaced by listErrata(string sessionKey,
 string channelLabel, dateTime.iso8601 startDate, dateTime.iso8601) <p />


Parameters:<br />
<ul>
<li>

        string sessionKey
 </li>
<li>

    string channelLabel - channel to query
 </li>
<li>

    string startDate
 </li>
<li>

    string endDate
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
                  <li> string "advisory" - name of the advisory </li>
                  <li> string "issue_date" - date format follows YYYY-MM-DD HH24:MI:SS </li>
                  <li> string "update_date" - date format follows YYYY-MM-DD HH24:MI:SS </li>
              	<li> string "synopsis"</li>
              	<li> string "advisory_type"</li>
                  <li> string "last_modified_date" - date format follows YYYY-MM-DD HH24:MI:SS </li>
          	</ul>
      </li></ul>
 
</li></ul>
</code>
<p />
<hr />

<h3> <a name="listErrataByType" href="#top">Method: listErrataByType</a></h3>
Description:<br />
List the errata of a specific type that are applicable to a channel
<p />




Parameters:<br />
<ul>
<li>

        string sessionKey
 </li>
<li>

    string channelLabel - channel to query
 </li>
<li>

    string advisoryType - type of advisory (one of
 of the following: 'Security Advisory', 'Product Enhancement Advisory',
 'Bug Fix Advisory'
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
                  <li> string "advisory" - name of the advisory </li>
                  <li> string "issue_date" - date format follows YYYY-MM-DD HH24:MI:SS </li>
                  <li> string "update_date" - date format follows YYYY-MM-DD HH24:MI:SS </li>
              	<li> string "synopsis"</li>
              	<li> string "advisory_type"</li>
                  <li> string "last_modified_date" - date format follows YYYY-MM-DD HH24:MI:SS </li>
          	</ul>
      </li></ul>
 
</li></ul>
</code>
<p />
<hr />

<h3> <a name="listErrataNeedingSync" href="#top">Method: listErrataNeedingSync</a></h3>
Description:<br />
If you have satellite-synced a new channel then Red Hat
 Errata will have been updated with the packages that are in the newly
 synced channel. A cloned erratum will not have been automatically updated
 however. If you cloned a channel that includes those cloned errata and
 should include the new packages, they will not be included when they
 should. This method lists the errata that will be updated if you run the
 syncErrata method.
<p />




Parameters:<br />
<ul>
<li>

        string sessionKey
 </li>
<li>

    string channelLabel - channel to update
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
              <li> int "id" - Errata ID. </li>
              <li> string "date" - Date erratum was created. </li>
              <li> string "update_date" - Date erratum was updated. </li>
              <li> string "advisory_synopsis" - Summary of the erratum. </li>
              <li> string "advisory_type" - Type label such as Security, Bug Fix </li>
              <li> string "advisory_name" - Name such as RHSA, etc </li>
      	</ul>
 
      </li></ul>
 
</li></ul>
</code>
<p />
<hr />

<h3> <a name="listLatestPackages" href="#top">Method: listLatestPackages</a></h3>
Description:<br />
Lists the packages with the latest version (including release and
 epoch) for the given channel
<p />




Parameters:<br />
<ul>
<li>

        string sessionKey
 </li>
<li>

    string channelLabel - channel to query
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
          	</ul>
      </li></ul>
 
</li></ul>
</code>
<p />
<hr />

<h3> <a name="listPackagesWithoutChannel" href="#top">Method: listPackagesWithoutChannel</a></h3>
Description:<br />
Lists all packages that are not associated with a channel.  Typically
          these are custom packages.
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

<h3> <a name="listRepoFilters" href="#top">Method: listRepoFilters</a></h3>
Description:<br />
Lists the filters for a repo
<p />




Parameters:<br />
<ul>
<li>

        string sessionKey
 </li>
<li>

    string label - repository label
 </li>
</ul>
<p />
Returns:
<code><ul><li>


array:
  <ul>
   <li>
          

	     struct - filter
	<ul>
      	<li> int "sortOrder"</li>
      	<li> string "filter"</li>
      	<li> string "flag"</li>
  	</ul>
 
      </li></ul>
 
</li></ul>
</code>
<p />
<hr />

<h3> <a name="listSubscribedSystems" href="#top">Method: listSubscribedSystems</a></h3>
Description:<br />
Returns list of subscribed systems for the given channel label
<p />




Parameters:<br />
<ul>
<li>

        string sessionKey
 </li>
<li>

    string channelLabel - channel to query
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
              	</ul>
           </li></ul>
 
</li></ul>
</code>
<p />
<hr />

<h3> <a name="listSystemChannels" href="#top">Method: listSystemChannels</a></h3>
Description:<br />
Returns a list of channels that a system is subscribed to for the
 given system id
<p />




Parameters:<br />
<ul>
<li>

        string sessionKey
 </li>
<li>

    int serverId
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
                  	<li> string "id"</li>
                  	<li> string "label"</li>
                  	<li> string "name"</li>
              	</ul>
           </li></ul>
 
</li></ul>
</code>
<p />
<hr />

<h3> <a name="listUserRepos" href="#top">Method: listUserRepos</a></h3>
Description:<br />
Returns a list of ContentSource (repos) that the user can see
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
          	     struct - map
	<ul>
                  <li> long "id" - ID of the repo </li>
                  <li> string "label" - label of the repo </li>
                  <li> string "sourceUrl" - URL of the repo </li>
          	</ul>
      </li></ul>
 
</li></ul>
</code>
<p />
<hr />

<h3> <a name="mergeErrata" href="#top">Method: mergeErrata</a></h3>
Description:<br />
Merges all errata from one channel into another
<p />




Parameters:<br />
<ul>
<li>

        string sessionKey
 </li>
<li>

    string mergeFromLabel - the label of the
 channel to pull errata from
 </li>
<li>

    string mergeToLabel - the label to push the
 errata into
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

<h3> <a name="mergeErrata" href="#top">Method: mergeErrata</a></h3>
Description:<br />
Merges all errata from one channel into another based upon a
 given start/end date.
<p />




Parameters:<br />
<ul>
<li>

        string sessionKey
 </li>
<li>

    string mergeFromLabel - the label of the
 channel to pull errata from
 </li>
<li>

    string mergeToLabel - the label to push the
 errata into
 </li>
<li>

    string startDate
 </li>
<li>

    string endDate
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

<h3> <a name="mergeErrata" href="#top">Method: mergeErrata</a></h3>
Description:<br />
Merges a list of errata from one channel into another
<p />




Parameters:<br />
<ul>
<li>

        string sessionKey
 </li>
<li>

    string mergeFromLabel - the label of the
 channel to pull errata from
 </li>
<li>

    string mergeToLabel - the label to push the
 errata into
 </li>
<li>

array:
<ul>
    <li>string -  advisory - The advisory name of the errata to merge</li>
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

<h3> <a name="mergePackages" href="#top">Method: mergePackages</a></h3>
Description:<br />
Merges all packages from one channel into another
<p />




Parameters:<br />
<ul>
<li>

        string sessionKey
 </li>
<li>

    string mergeFromLabel - the label of the
          channel to pull packages from
 </li>
<li>

    string mergeToLabel - the label to push the
              packages into
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

<h3> <a name="regenerateNeededCache" href="#top">Method: regenerateNeededCache</a></h3>
Description:<br />
Completely clear and regenerate the needed Errata and Package
      cache for all systems subscribed to the specified channel.  This should
      be used only if you believe your cache is incorrect for all the systems
      in a given channel. This will schedule an asynchronous action to actually
      do the processing.
<p />




Parameters:<br />
<ul>
<li>

        string sessionKey
 </li>
<li>

    string channelLabel - the label of the
          channel
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

<h3> <a name="regenerateNeededCache" href="#top">Method: regenerateNeededCache</a></h3>
Description:<br />
Completely clear and regenerate the needed Errata and Package
      cache for all systems subscribed.  You must be a Satellite Admin to
      perform this action. This will schedule an asynchronous action to
      actually do the processing.
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

<h3> <a name="regenerateYumCache" href="#top">Method: regenerateYumCache</a></h3>
Description:<br />
Regenerate yum cache for the specified channel.
<p />




Parameters:<br />
<ul>
<li>

        string sessionKey
 </li>
<li>

    string channelLabel - the label of the
          channel
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

<h3> <a name="removeErrata" href="#top">Method: removeErrata</a></h3>
Description:<br />
Removes a given list of errata from the given channel.
<p />




Parameters:<br />
<ul>
<li>

        string sessionKey
 </li>
<li>

    string channelLabel - target channel.
 </li>
<li>

array:
<ul>
    <li>string - advisoryName - name of an erratum to remove</li>
</ul>
 </li>
<li>

    boolean removePackages - True to remove packages from the channel
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

<h3> <a name="removePackages" href="#top">Method: removePackages</a></h3>
Description:<br />
Removes a given list of packages from the given channel.
<p />




Parameters:<br />
<ul>
<li>

        string sessionKey
 </li>
<li>

    string channelLabel - target channel.
 </li>
<li>

array:
<ul>
    <li>int - packageId -  id of a package to
                                   remove from the channel.</li>
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

<h3> <a name="removeRepo" href="#top">Method: removeRepo</a></h3>
Description:<br />
Removes a repository
<p />




Parameters:<br />
<ul>
<li>

        string sessionKey
 </li>
<li>

    long id - ID of repo to be removed
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

<h3> <a name="removeRepo" href="#top">Method: removeRepo</a></h3>
Description:<br />
Removes a repository
<p />




Parameters:<br />
<ul>
<li>

        string sessionKey
 </li>
<li>

    string label - label of repo to be removed
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

<h3> <a name="removeRepoFilter" href="#top">Method: removeRepoFilter</a></h3>
Description:<br />
Removes a filter for a given repo.
<p />




Parameters:<br />
<ul>
<li>

    string sessionKey 
 </li>
<li>

    string label - repository label
 </li>
<li>

	     struct - filter_map
	<ul>
              <li> string "filter" - string to filter on </li>
              <li> string "flag" - + for include, - for exclude </li>
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

<h3> <a name="setContactDetails" href="#top">Method: setContactDetails</a></h3>
Description:<br />
Set contact/support information for given channel.
<p />




Parameters:<br />
<ul>
<li>

        string sessionKey
 </li>
<li>

    string channelLabel - label of the channel
 </li>
<li>

    string maintainerName - name of the channel
 maintainer
 </li>
<li>

    string maintainerEmail - email of the channel
 maintainer
 </li>
<li>

    string maintainerPhone - phone number of the channel
 maintainer
 </li>
<li>

    string supportPolicy - channel support policy
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

<h3> <a name="setDetails" href="#top">Method: setDetails</a></h3>
Description:<br />
Allows to modify channel attributes
<p />




Parameters:<br />
<ul>
<li>

        string sessionKey
 </li>
<li>

    int channelId - channel id
 </li>
<li>

	     struct - channel_map
	<ul>
          <li> string "checksum_label" - new channel repository checksum label
          (optional) </li>
          <li> string "name" - new channel name (optional) </li>
          <li> string "summary" - new channel summary (optional) </li>
          <li> string "description" - new channel description (optional) </li>
          <li> string "maintainer_name" - new channel maintainer name
          (optional) </li>
          <li> string "maintainer_email" - new channel email address
          (optional) </li>
          <li> string "maintainer_phone" - new channel phone number (optional) </li>
          <li> string "gpg_key_url" - new channel gpg key url (optional) </li>
          <li> string "gpg_key_id" - new channel gpg key id (optional) </li>
          <li> string "gpg_key_fp" - new channel gpg key fingerprint
          (optional) </li>
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

<h3> <a name="setDetails" href="#top">Method: setDetails</a></h3>
Description:<br />
Allows to modify channel attributes
<p />




Parameters:<br />
<ul>
<li>

        string sessionKey
 </li>
<li>

    int channelId - channel id
 </li>
<li>

	     struct - channel_map
	<ul>
          <li> string "checksum_label" - new channel repository checksum label
          (optional) </li>
          <li> string "name" - new channel name (optional) </li>
          <li> string "summary" - new channel summary (optional) </li>
          <li> string "description" - new channel description (optional) </li>
          <li> string "maintainer_name" - new channel maintainer name
          (optional) </li>
          <li> string "maintainer_email" - new channel email address
          (optional) </li>
          <li> string "maintainer_phone" - new channel phone number (optional) </li>
          <li> string "gpg_key_url" - new channel gpg key url (optional) </li>
          <li> string "gpg_key_id" - new channel gpg key id (optional) </li>
          <li> string "gpg_key_fp" - new channel gpg key fingerprint
          (optional) </li>
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

<h3> <a name="setGloballySubscribable" href="#top">Method: setGloballySubscribable</a></h3>
Description:<br />
Set globally subscribable attribute for given channel.
<p />




Parameters:<br />
<ul>
<li>

        string sessionKey
 </li>
<li>

    string channelLabel - label of the channel
 </li>
<li>

    boolean subscribable - true if the channel is to be
          globally subscribable.  False otherwise.
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

<h3> <a name="setRepoFilters" href="#top">Method: setRepoFilters</a></h3>
Description:<br />
Replaces the existing set of filters for a given repo.
 Filters are ranked by their order in the array.
<p />




Parameters:<br />
<ul>
<li>

    string sessionKey 
 </li>
<li>

    string label - repository label
 </li>
<li>

array:
  <ul>
   <li>
      	     struct - filter_map
	<ul>
              <li> string "filter" - string to filter on </li>
              <li> string "flag" - + for include, - for exclude </li>
      	</ul>
  </li></ul>
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

<h3 class="deprecated"><a name="setSystemChannels" href="#top">Method: setSystemChannels</a></h3>
Description:<br />
Change a systems subscribed channels to the list of channels passed in.
<p />


Deprecated - being replaced by system.setBaseChannel(string sessionKey,
 int serverId, string channelLabel) and system.setChildChannels(string sessionKey,
 int serverId, array[string channelLabel]) <p />


Parameters:<br />
<ul>
<li>

        string sessionKey
 </li>
<li>

    int serverId
 </li>
<li>

array:
<ul>
    <li>string - channelLabel - labels of the channels to
              subscribe the system to.</li>
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

<h3> <a name="setUserManageable" href="#top">Method: setUserManageable</a></h3>
Description:<br />
Set the manageable flag for a given channel and user.
 If value is set to 'true', this method will give the user
 manage permissions to the channel. Otherwise, that privilege is revoked.
<p />




Parameters:<br />
<ul>
<li>

        string sessionKey
 </li>
<li>

    string channelLabel - label of the channel
 </li>
<li>

    string login - login of the target user
 </li>
<li>

    boolean value - value of the flag to set
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

<h3> <a name="setUserSubscribable" href="#top">Method: setUserSubscribable</a></h3>
Description:<br />
Set the subscribable flag for a given channel and user.
 If value is set to 'true', this method will give the user
 subscribe permissions to the channel. Otherwise, that privilege is revoked.
<p />




Parameters:<br />
<ul>
<li>

        string sessionKey
 </li>
<li>

    string channelLabel - label of the channel
 </li>
<li>

    string login - login of the target user
 </li>
<li>

    boolean value - value of the flag to set
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

<h3 class="deprecated"><a name="subscribeSystem" href="#top">Method: subscribeSystem</a></h3>
Description:<br />
Subscribes a system to a list of channels.  If a base channel is
      included, that is set before setting child channels.  When setting child
      channels the current child channel subscriptions are cleared.  To fully
      unsubscribe the system from all channels, simply provide an empty list of
      channel labels.
<p />


Deprecated - being replaced by system.setBaseChannel(string sessionKey,
 int serverId, string channelLabel) and system.setChildChannels(string sessionKey,
 int serverId, array[string channelLabel]) <p />


Parameters:<br />
<ul>
<li>

        string sessionKey
 </li>
<li>

    int serverId
 </li>
<li>

array:
<ul>
    <li>string - label - channel label to subscribe
                  the system to.</li>
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

<h3> <a name="syncErrata" href="#top">Method: syncErrata</a></h3>
Description:<br />
If you have satellite-synced a new channel then Red Hat
 Errata will have been updated with the packages that are in the newly
 synced channel. A cloned erratum will not have been automatically updated
 however. If you cloned a channel that includes those cloned errata and
 should include the new packages, they will not be included when they
 should. This method updates all the errata in the given cloned channel
 with packages that have recently been added, and ensures that all the
 packages you expect are in the channel.
<p />




Parameters:<br />
<ul>
<li>

        string sessionKey
 </li>
<li>

    string channelLabel - channel to update
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

<h3> <a name="syncRepo" href="#top">Method: syncRepo</a></h3>
Description:<br />
Trigger immediate repo synchronization
<p />




Parameters:<br />
<ul>
<li>

        string sessionKey
 </li>
<li>

    string channelLabel - channel label
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

<h3> <a name="syncRepo" href="#top">Method: syncRepo</a></h3>
Description:<br />
Trigger immediate repo synchronization
<p />




Parameters:<br />
<ul>
<li>

        string sessionKey
 </li>
<li>

    string channelLabel - channel label
 </li>
<li>

	     struct - params_map
	<ul>
        <li> Boolean "sync-kickstart" - Create kickstartable tree - Optional </li>
        <li> Boolean "no-errata" - Do not sync errata - Optional </li>
        <li> Boolean "fail" - Terminate upon any error - Optional </li>
        <li> Boolean "latest" - Only download latest packages - Optional </li>
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

<h3> <a name="syncRepo" href="#top">Method: syncRepo</a></h3>
Description:<br />
Schedule periodic repo synchronization
<p />




Parameters:<br />
<ul>
<li>

        string sessionKey
 </li>
<li>

    string channelLabel - channel label
 </li>
<li>

    string cron expression - if empty all periodic schedules will be disabled
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

<h3> <a name="syncRepo" href="#top">Method: syncRepo</a></h3>
Description:<br />
Schedule periodic repo synchronization
<p />




Parameters:<br />
<ul>
<li>

        string sessionKey
 </li>
<li>

    string channelLabel - channel label
 </li>
<li>

    string cron expression - if empty all periodic schedules will be disabled
 </li>
<li>

	     struct - params_map
	<ul>
        <li> Boolean "sync-kickstart" - Create kickstartable tree - Optional </li>
        <li> Boolean "no-errata" - Do not sync errata - Optional </li>
        <li> Boolean "fail" - Terminate upon any error - Optional </li>
        <li> Boolean "latest" - Only download latest packages - Optional </li>
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

<h3> <a name="updateRepo" href="#top">Method: updateRepo</a></h3>
Description:<br />
Updates a ContentSource (repo)
<p />




Parameters:<br />
<ul>
<li>

        string sessionKey
 </li>
<li>

    int id - repository id
 </li>
<li>

    string label - new repository label
 </li>
<li>

    string url - new repository URL
 </li>
</ul>
<p />
Returns:
<code><ul><li>




	     struct - channel
	<ul>
      	<li> int "id"</li>
      	<li> string "label"</li>
      	<li> string "sourceUrl"</li>
      	<li> string "type"</li>
                              	<li> string "sslCaDesc"</li>
              	<li> string "sslCertDesc"</li>
              	<li> string "sslKeyDesc"</li>
          	</ul>
      </li></ul>
  	</ul>
  
 
</li></ul>
</code>
<p />
<hr />

<h3> <a name="updateRepoLabel" href="#top">Method: updateRepoLabel</a></h3>
Description:<br />
Updates repository label
<p />




Parameters:<br />
<ul>
<li>

        string sessionKey
 </li>
<li>

    int id - repository id
 </li>
<li>

    string label - new repository label
 </li>
</ul>
<p />
Returns:
<code><ul><li>




	     struct - channel
	<ul>
      	<li> int "id"</li>
      	<li> string "label"</li>
      	<li> string "sourceUrl"</li>
      	<li> string "type"</li>
                              	<li> string "sslCaDesc"</li>
              	<li> string "sslCertDesc"</li>
              	<li> string "sslKeyDesc"</li>
          	</ul>
      </li></ul>
  	</ul>
  
 
</li></ul>
</code>
<p />
<hr />

<h3> <a name="updateRepoLabel" href="#top">Method: updateRepoLabel</a></h3>
Description:<br />
Updates repository label
<p />




Parameters:<br />
<ul>
<li>

        string sessionKey
 </li>
<li>

    string label - repository label
 </li>
<li>

    string newLabel - new repository label
 </li>
</ul>
<p />
Returns:
<code><ul><li>




	     struct - channel
	<ul>
      	<li> int "id"</li>
      	<li> string "label"</li>
      	<li> string "sourceUrl"</li>
      	<li> string "type"</li>
                              	<li> string "sslCaDesc"</li>
              	<li> string "sslCertDesc"</li>
              	<li> string "sslKeyDesc"</li>
          	</ul>
      </li></ul>
  	</ul>
  
 
</li></ul>
</code>
<p />
<hr />

<h3> <a name="updateRepoSsl" href="#top">Method: updateRepoSsl</a></h3>
Description:<br />
Updates repository SSL certificates
<p />




Parameters:<br />
<ul>
<li>

        string sessionKey
 </li>
<li>

    int id - repository id
 </li>
<li>

    string sslCaCert - SSL CA cert description
 </li>
<li>

    string sslCliCert - SSL Client cert description
 </li>
<li>

    string sslCliKey - SSL Client key description
 </li>
</ul>
<p />
Returns:
<code><ul><li>




	     struct - channel
	<ul>
      	<li> int "id"</li>
      	<li> string "label"</li>
      	<li> string "sourceUrl"</li>
      	<li> string "type"</li>
                              	<li> string "sslCaDesc"</li>
              	<li> string "sslCertDesc"</li>
              	<li> string "sslKeyDesc"</li>
          	</ul>
      </li></ul>
  	</ul>
  
 
</li></ul>
</code>
<p />
<hr />

<h3> <a name="updateRepoSsl" href="#top">Method: updateRepoSsl</a></h3>
Description:<br />
Updates repository SSL certificates
<p />




Parameters:<br />
<ul>
<li>

        string sessionKey
 </li>
<li>

    string label - repository label
 </li>
<li>

    string sslCaCert - SSL CA cert description
 </li>
<li>

    string sslCliCert - SSL Client cert description
 </li>
<li>

    string sslCliKey - SSL Client key description
 </li>
</ul>
<p />
Returns:
<code><ul><li>




	     struct - channel
	<ul>
      	<li> int "id"</li>
      	<li> string "label"</li>
      	<li> string "sourceUrl"</li>
      	<li> string "type"</li>
                              	<li> string "sslCaDesc"</li>
              	<li> string "sslCertDesc"</li>
              	<li> string "sslKeyDesc"</li>
          	</ul>
      </li></ul>
  	</ul>
  
 
</li></ul>
</code>
<p />
<hr />

<h3> <a name="updateRepoUrl" href="#top">Method: updateRepoUrl</a></h3>
Description:<br />
Updates repository source URL
<p />




Parameters:<br />
<ul>
<li>

        string sessionKey
 </li>
<li>

    int id - repository id
 </li>
<li>

    string url - new repository url
 </li>
</ul>
<p />
Returns:
<code><ul><li>




	     struct - channel
	<ul>
      	<li> int "id"</li>
      	<li> string "label"</li>
      	<li> string "sourceUrl"</li>
      	<li> string "type"</li>
                              	<li> string "sslCaDesc"</li>
              	<li> string "sslCertDesc"</li>
              	<li> string "sslKeyDesc"</li>
          	</ul>
      </li></ul>
  	</ul>
  
 
</li></ul>
</code>
<p />
<hr />

<h3> <a name="updateRepoUrl" href="#top">Method: updateRepoUrl</a></h3>
Description:<br />
Updates repository source URL
<p />




Parameters:<br />
<ul>
<li>

        string sessionKey
 </li>
<li>

    string label - repository label
 </li>
<li>

    string url - new repository url
 </li>
</ul>
<p />
Returns:
<code><ul><li>




	     struct - channel
	<ul>
      	<li> int "id"</li>
      	<li> string "label"</li>
      	<li> string "sourceUrl"</li>
      	<li> string "type"</li>
                              	<li> string "sslCaDesc"</li>
              	<li> string "sslCertDesc"</li>
              	<li> string "sslKeyDesc"</li>
          	</ul>
      </li></ul>
  	</ul>
  
 
</li></ul>
</code>
<p />
<hr />
</body>
</html>
