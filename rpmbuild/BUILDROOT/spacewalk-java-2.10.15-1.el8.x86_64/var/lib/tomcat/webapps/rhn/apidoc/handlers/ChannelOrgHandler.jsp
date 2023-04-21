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
channel.org
</p>
<p>Provides methods to retrieve and alter organization trust
 relationships for a channel.</p>
<span class="small-text">( <a href="/rhn/apidoc/index.jsp">Return to API Overview</a> )</span>
<hr />

<div class="rounded-box">
<h2><a name="top">Available methods</a></h2>
<ul class="apidoc">

<li><a href="#disableAccess"/>disableAccess</a></li>
<li><a href="#enableAccess"/>enableAccess</a></li>
<li><a href="#list"/>list</a></li>
</ul>
</div>
<hr />

<h3> <a name="disableAccess" href="#top">Method: disableAccess</a></h3>
Description:<br />
Disable access to the channel for the given organization.
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

    int orgId - id of org being removed access
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

<h3> <a name="enableAccess" href="#top">Method: enableAccess</a></h3>
Description:<br />
Enable access to the channel for the given organization.
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

    int orgId - id of org being granted access
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
List the organizations associated with the given channel
 that may be trusted.
<p />




Parameters:<br />
<ul>
<li>

        string sessionKey
 </li>
<li>

    string channelLabel - label of the channel
 </li>
</ul>
<p />
Returns:
<code><ul><li>


array:
  <ul>
   <li>
      	     struct - org
	<ul>
          	<li> int "org_id"</li>
          	<li> string "org_name"</li>
          	<li> boolean "access_enabled"</li>
     	</ul>
  </li></ul>
 
</li></ul>
</code>
<p />
<hr />
</body>
</html>
