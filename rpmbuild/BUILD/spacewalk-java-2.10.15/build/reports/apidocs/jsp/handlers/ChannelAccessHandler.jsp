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
channel.access
</p>
<p>Provides methods to retrieve and alter channel access restrictions.</p>
<span class="small-text">( <a href="/rhn/apidoc/index.jsp">Return to API Overview</a> )</span>
<hr />

<div class="rounded-box">
<h2><a name="top">Available methods</a></h2>
<ul class="apidoc">

<li><a href="#disableUserRestrictions"/>disableUserRestrictions</a></li>
<li><a href="#enableUserRestrictions"/>enableUserRestrictions</a></li>
<li><a href="#getOrgSharing"/>getOrgSharing</a></li>
<li><a href="#setOrgSharing"/>setOrgSharing</a></li>
</ul>
</div>
<hr />

<h3> <a name="disableUserRestrictions" href="#top">Method: disableUserRestrictions</a></h3>
Description:<br />
Disable user restrictions for the given channel.  If disabled,
 all users within the organization may subscribe to the channel.
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


    int - 1 on success, exception thrown otherwise.
 
</li></ul>
</code>
<p />
<hr />

<h3> <a name="enableUserRestrictions" href="#top">Method: enableUserRestrictions</a></h3>
Description:<br />
Enable user restrictions for the given channel. If enabled, only
 selected users within the organization may subscribe to the channel.
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


    int - 1 on success, exception thrown otherwise.
 
</li></ul>
</code>
<p />
<hr />

<h3> <a name="getOrgSharing" href="#top">Method: getOrgSharing</a></h3>
Description:<br />
Get organization sharing access control.
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


string - The access value (one of the following: 'public',
 'private', or 'protected'. 
 
</li></ul>
</code>
<p />
<hr />

<h3> <a name="setOrgSharing" href="#top">Method: setOrgSharing</a></h3>
Description:<br />
Set organization sharing access control.
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

    string access - Access (one of the
                  following: 'public', 'private', or 'protected'
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
