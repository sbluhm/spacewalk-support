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
actionchain
</p>
<p>Provides the namespace for the Action Chain methods.</p>
<span class="small-text">( <a href="/rhn/apidoc/index.jsp">Return to API Overview</a> )</span>
<hr />

<div class="rounded-box">
<h2><a name="top">Available methods</a></h2>
<ul class="apidoc">

<li><a href="#addConfigurationDeployment"/>addConfigurationDeployment</a></li>
<li><a href="#addErrataUpdate"/>addErrataUpdate</a></li>
<li><a href="#addPackageInstall"/>addPackageInstall</a></li>
<li><a href="#addPackageRemoval"/>addPackageRemoval</a></li>
<li><a href="#addPackageUpgrade"/>addPackageUpgrade</a></li>
<li><a href="#addPackageVerify"/>addPackageVerify</a></li>
<li><a href="#addScriptRun"/>addScriptRun</a></li>
<li><a href="#addSystemReboot"/>addSystemReboot</a></li>
<li><a href="#createChain"/>createChain</a></li>
<li><a href="#deleteChain"/>deleteChain</a></li>
<li><a href="#listChainActions"/>listChainActions</a></li>
<li><a href="#listChains"/>listChains</a></li>
<li><a href="#removeAction"/>removeAction</a></li>
<li><a href="#renameChain"/>renameChain</a></li>
<li><a href="#scheduleChain"/>scheduleChain</a></li>
</ul>
</div>
<hr />

<h3> <a name="addConfigurationDeployment" href="#top">Method: addConfigurationDeployment</a></h3>
Description:<br />
Adds an action to deploy a configuration file to an Action Chain.
<p />




Parameters:<br />
<ul>
<li>

    string sessionKey - Session token, issued at login
 </li>
<li>

    string chainLabel - Label of the chain
 </li>
<li>

    int System ID - System ID
 </li>
<li>

array:
<ul>
    <li>int - Revision ID</li>
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

<h3> <a name="addErrataUpdate" href="#top">Method: addErrataUpdate</a></h3>
Description:<br />
Adds Errata update to an Action Chain.
<p />




Parameters:<br />
<ul>
<li>

    string sessionKey - Session token, issued at login
 </li>
<li>

    int serverId - System ID
 </li>
<li>

array:
<ul>
    <li>int - Errata ID</li>
</ul>
 </li>
<li>

    string chainLabel - Label of the chain
 </li>
</ul>
<p />
Returns:
<code><ul><li>


int actionId - The action id of the scheduled action 
 
</li></ul>
</code>
<p />
<hr />

<h3> <a name="addPackageInstall" href="#top">Method: addPackageInstall</a></h3>
Description:<br />
Adds package installation action to an Action Chain.
<p />




Parameters:<br />
<ul>
<li>

    string sessionKey - Session token, issued at login
 </li>
<li>

    int serverId - System ID
 </li>
<li>

array:
<ul>
    <li>int - Package ID</li>
</ul>
 </li>
<li>

    string chainLabel
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

<h3> <a name="addPackageRemoval" href="#top">Method: addPackageRemoval</a></h3>
Description:<br />
Adds an action to remove installed packages on the system to an Action
 Chain.
<p />




Parameters:<br />
<ul>
<li>

    string sessionKey - Session token, issued at login
 </li>
<li>

    int serverId - System ID
 </li>
<li>

array:
<ul>
    <li>int - Package ID</li>
</ul>
 </li>
<li>

    string chainLabel - Label of the chain
 </li>
</ul>
<p />
Returns:
<code><ul><li>


int actionId - The action id of the scheduled action or exception 
 
</li></ul>
</code>
<p />
<hr />

<h3> <a name="addPackageUpgrade" href="#top">Method: addPackageUpgrade</a></h3>
Description:<br />
Adds an action to upgrade installed packages on the system to an Action
 Chain.
<p />




Parameters:<br />
<ul>
<li>

    string sessionKey - Session token, issued at login
 </li>
<li>

    int serverId - System ID
 </li>
<li>

array:
<ul>
    <li>int - packageId</li>
</ul>
 </li>
<li>

    string chainLabel - Label of the chain
 </li>
</ul>
<p />
Returns:
<code><ul><li>


int actionId - The id of the action or throw an exception 
 
</li></ul>
</code>
<p />
<hr />

<h3> <a name="addPackageVerify" href="#top">Method: addPackageVerify</a></h3>
Description:<br />
Adds an action to verify installed packages on the system to an Action
 Chain.
<p />




Parameters:<br />
<ul>
<li>

    string sessionKey - Session token, issued at login
 </li>
<li>

    int serverId - System ID
 </li>
<li>

array:
<ul>
    <li>int - packageId</li>
</ul>
 </li>
<li>

    string chainLabel - Label of the chain
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

<h3> <a name="addScriptRun" href="#top">Method: addScriptRun</a></h3>
Description:<br />
Add an action to run a script to an Action Chain.
 NOTE: The script body must be Base64 encoded!
<p />




Parameters:<br />
<ul>
<li>

    string sessionKey - Session token, issued at login
 </li>
<li>

    int serverId - System ID
 </li>
<li>

    string chainLabel - Label of the chain
 </li>
<li>

    string uid - User ID on the particular system
 </li>
<li>

    string gid - Group ID on the particular system
 </li>
<li>

    int timeout - Timeout
 </li>
<li>

    string scriptBodyBase64 - Base64 encoded script body
 </li>
</ul>
<p />
Returns:
<code><ul><li>


int actionId - The id of the action or throw an
 exception 
 
</li></ul>
</code>
<p />
<hr />

<h3> <a name="addSystemReboot" href="#top">Method: addSystemReboot</a></h3>
Description:<br />
Add system reboot to an Action Chain.
<p />




Parameters:<br />
<ul>
<li>

    string sessionKey - Session token, issued at login
 </li>
<li>

    int serverId
 </li>
<li>

    string chainLabel - Label of the chain
 </li>
</ul>
<p />
Returns:
<code><ul><li>


int actionId - The action id of the scheduled action 
 
</li></ul>
</code>
<p />
<hr />

<h3> <a name="createChain" href="#top">Method: createChain</a></h3>
Description:<br />
Create an Action Chain.
<p />




Parameters:<br />
<ul>
<li>

    string sessionKey - Session token, issued at login
 </li>
<li>

    string chainLabel - Label of the chain
 </li>
</ul>
<p />
Returns:
<code><ul><li>


int actionId - The ID of the created action chain 
 
</li></ul>
</code>
<p />
<hr />

<h3> <a name="deleteChain" href="#top">Method: deleteChain</a></h3>
Description:<br />
Delete action chain by label.
<p />




Parameters:<br />
<ul>
<li>

    string sessionKey - Session token, issued at login
 </li>
<li>

    string chainLabel - Label of the chain
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

<h3> <a name="listChainActions" href="#top">Method: listChainActions</a></h3>
Description:<br />
List all actions in the particular Action Chain.
<p />




Parameters:<br />
<ul>
<li>

    string sessionKey - Session token, issued at login
 </li>
<li>

    string chainLabel - Label of the chain
 </li>
</ul>
<p />
Returns:
<code><ul><li>


array:
  <ul>
   <li>
                      	     struct - entry
	<ul>
                            <li> int "id" - Action ID </li>
                            <li> string "label" - Label of an Action </li>
                            <li> string "created" - Created date/time </li>
                            <li> string "earliest" - Earliest scheduled date/time </li>
                            <li> string "type" - Type of the action </li>
                            <li> string "modified" - Modified date/time </li>
                            <li> string "cuid" - Creator UID </li>
                      	</ul>
                    </li></ul>
 
</li></ul>
</code>
<p />
<hr />

<h3> <a name="listChains" href="#top">Method: listChains</a></h3>
Description:<br />
List currently available action chains.
<p />




Parameters:<br />
<ul>
<li>

    string sessionKey - Session token, issued at login
 </li>
</ul>
<p />
Returns:
<code><ul><li>


array:
  <ul>
   <li>
                      	     struct - chain
	<ul>
                            <li> string "label" - Label of an Action Chain </li>
                            <li> string "entrycount" - Number of entries in the Action Chain </li>
                      	</ul>
                    </li></ul>
 
</li></ul>
</code>
<p />
<hr />

<h3> <a name="removeAction" href="#top">Method: removeAction</a></h3>
Description:<br />
Remove an action from an Action Chain.
<p />




Parameters:<br />
<ul>
<li>

    string sessionKey - Session token, issued at login
 </li>
<li>

    string chainLabel - Label of the chain
 </li>
<li>

    int actionId - Action ID
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

<h3> <a name="renameChain" href="#top">Method: renameChain</a></h3>
Description:<br />
Rename an Action Chain.
<p />




Parameters:<br />
<ul>
<li>

    string sessionKey - Session token, issued at login
 </li>
<li>

    string previousLabel - Previous chain label
 </li>
<li>

    string newLabel - New chain label
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

<h3> <a name="scheduleChain" href="#top">Method: scheduleChain</a></h3>
Description:<br />
Schedule the Action Chain so that its actions will actually occur.
<p />




Parameters:<br />
<ul>
<li>

    string sessionKey - Session token, issued at login
 </li>
<li>

    string chainLabel - Label of the chain
 </li>
<li>

    dateTime.iso8601 Earliest date
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
