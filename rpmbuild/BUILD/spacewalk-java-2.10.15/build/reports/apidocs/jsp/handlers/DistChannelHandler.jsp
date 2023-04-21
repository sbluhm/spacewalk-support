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
distchannel
</p>
<p>Provides methods to access and modify distribution channel information</p>
<span class="small-text">( <a href="/rhn/apidoc/index.jsp">Return to API Overview</a> )</span>
<hr />

<div class="rounded-box">
<h2><a name="top">Available methods</a></h2>
<ul class="apidoc">

<li><a href="#listDefaultMaps"/>listDefaultMaps</a></li>
<li><a href="#listMapsForOrg"/>listMapsForOrg</a></li>
<li><a href="#listMapsForOrg"/>listMapsForOrg</a></li>
<li><a href="#setMapForOrg"/>setMapForOrg</a></li>
</ul>
</div>
<hr />

<h3> <a name="listDefaultMaps" href="#top">Method: listDefaultMaps</a></h3>
Description:<br />
Lists the default distribution channel maps
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
      

	     struct - distChannelMap
	<ul>
              <li> string "os" - Operationg System </li>
              <li> string "release" - OS Relase </li>
              <li> string "arch_name" - Channel architecture </li>
              <li> string "channel_label" - Channel label </li>
              <li> string "org_specific" - 'Y' organization specific, 'N' default </li>
     	</ul>
 
   </li></ul>
 
</li></ul>
</code>
<p />
<hr />

<h3> <a name="listMapsForOrg" href="#top">Method: listMapsForOrg</a></h3>
Description:<br />
Lists distribution channel maps valid for the user's organization
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
      

	     struct - distChannelMap
	<ul>
              <li> string "os" - Operationg System </li>
              <li> string "release" - OS Relase </li>
              <li> string "arch_name" - Channel architecture </li>
              <li> string "channel_label" - Channel label </li>
              <li> string "org_specific" - 'Y' organization specific, 'N' default </li>
     	</ul>
 
   </li></ul>
 
</li></ul>
</code>
<p />
<hr />

<h3> <a name="listMapsForOrg" href="#top">Method: listMapsForOrg</a></h3>
Description:<br />
Lists distribution channel maps valid for an organization,
 satellite admin right needed
<p />




Parameters:<br />
<ul>
<li>

        string sessionKey
 </li>
<li>

    int orgId
 </li>
</ul>
<p />
Returns:
<code><ul><li>


array:
  <ul>
   <li>
      

	     struct - distChannelMap
	<ul>
              <li> string "os" - Operationg System </li>
              <li> string "release" - OS Relase </li>
              <li> string "arch_name" - Channel architecture </li>
              <li> string "channel_label" - Channel label </li>
              <li> string "org_specific" - 'Y' organization specific, 'N' default </li>
     	</ul>
 
   </li></ul>
 
</li></ul>
</code>
<p />
<hr />

<h3> <a name="setMapForOrg" href="#top">Method: setMapForOrg</a></h3>
Description:<br />
Sets, overrides (/removes if channelLabel empty)
 a distribution channel map within an organization
<p />




Parameters:<br />
<ul>
<li>

        string sessionKey
 </li>
<li>

    string os
 </li>
<li>

    string release
 </li>
<li>

    string archName
 </li>
<li>

    string channelLabel
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
