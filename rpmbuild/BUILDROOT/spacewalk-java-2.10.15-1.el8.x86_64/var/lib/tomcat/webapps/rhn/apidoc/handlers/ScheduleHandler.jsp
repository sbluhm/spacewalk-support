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
schedule
</p>
<p>Methods to retrieve information about scheduled actions.</p>
<span class="small-text">( <a href="/rhn/apidoc/index.jsp">Return to API Overview</a> )</span>
<hr />

<div class="rounded-box">
<h2><a name="top">Available methods</a></h2>
<ul class="apidoc">

<li><a href="#archiveActions"/>archiveActions</a></li>
<li><a href="#cancelActions"/>cancelActions</a></li>
<li><a href="#deleteActions"/>deleteActions</a></li>
<li><a href="#failSystemAction"/>failSystemAction</a></li>
<li><a href="#failSystemAction"/>failSystemAction</a></li>
<li><a href="#listAllActions"/>listAllActions</a></li>
<li><a href="#listArchivedActions"/>listArchivedActions</a></li>
<li><a href="#listCompletedActions"/>listCompletedActions</a></li>
<li><a href="#listCompletedSystems"/>listCompletedSystems</a></li>
<li><a href="#listFailedActions"/>listFailedActions</a></li>
<li><a href="#listFailedSystems"/>listFailedSystems</a></li>
<li><a href="#listInProgressActions"/>listInProgressActions</a></li>
<li><a href="#listInProgressSystems"/>listInProgressSystems</a></li>
<li><a href="#rescheduleActions"/>rescheduleActions</a></li>
</ul>
</div>
<hr />

<h3> <a name="archiveActions" href="#top">Method: archiveActions</a></h3>
Description:<br />
Archive all actions in the given list.
<p />




Parameters:<br />
<ul>
<li>

        string sessionKey
 </li>
<li>

array:
<ul>
    <li>int - action id</li>
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

<h3> <a name="cancelActions" href="#top">Method: cancelActions</a></h3>
Description:<br />
Cancel all actions in given list. If an invalid action is provided,
 none of the actions given will canceled.
<p />




Parameters:<br />
<ul>
<li>

        string sessionKey
 </li>
<li>

array:
<ul>
    <li>int - action id</li>
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

<h3> <a name="deleteActions" href="#top">Method: deleteActions</a></h3>
Description:<br />
Delete all archived actions in the given list.
<p />




Parameters:<br />
<ul>
<li>

        string sessionKey
 </li>
<li>

array:
<ul>
    <li>int - action id</li>
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

<h3> <a name="failSystemAction" href="#top">Method: failSystemAction</a></h3>
Description:<br />
Fail specific event on specified system
<p />




Parameters:<br />
<ul>
<li>

        string sessionKey
 </li>
<li>

    int serverId
 </li>
<li>

    int actionId
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

<h3> <a name="failSystemAction" href="#top">Method: failSystemAction</a></h3>
Description:<br />
Fail specific event on specified system
<p />




Parameters:<br />
<ul>
<li>

        string sessionKey
 </li>
<li>

    int serverId
 </li>
<li>

    int actionId
 </li>
<li>

    string message
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

<h3> <a name="listAllActions" href="#top">Method: listAllActions</a></h3>
Description:<br />
Returns a list of all actions.  This includes completed, in progress,
 failed and archived actions.
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
   

	     struct - action
	<ul>
       <li> int "id" - Action Id. </li>
       <li> string "name" - Action name. </li>
       <li> string "type" - Action type. </li>
       <li> string "scheduler" - The user that scheduled the action. (optional) </li>
       <li> dateTime.iso8601 "earliest" - The earliest date and time the action
   will be performed </li>
       <li> int "completedSystems" - Number of systems that completed the action. </li>
       <li> int "failedSystems" - Number of systems that failed the action. </li>
       <li> int "inProgressSystems" - Number of systems that are in progress. </li>
 	</ul>
 
 </li></ul>
 
</li></ul>
</code>
<p />
<hr />

<h3> <a name="listArchivedActions" href="#top">Method: listArchivedActions</a></h3>
Description:<br />
Returns a list of actions that have been archived.
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
   

	     struct - action
	<ul>
       <li> int "id" - Action Id. </li>
       <li> string "name" - Action name. </li>
       <li> string "type" - Action type. </li>
       <li> string "scheduler" - The user that scheduled the action. (optional) </li>
       <li> dateTime.iso8601 "earliest" - The earliest date and time the action
   will be performed </li>
       <li> int "completedSystems" - Number of systems that completed the action. </li>
       <li> int "failedSystems" - Number of systems that failed the action. </li>
       <li> int "inProgressSystems" - Number of systems that are in progress. </li>
 	</ul>
 
 </li></ul>
 
</li></ul>
</code>
<p />
<hr />

<h3> <a name="listCompletedActions" href="#top">Method: listCompletedActions</a></h3>
Description:<br />
Returns a list of actions that have completed successfully.
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
   

	     struct - action
	<ul>
       <li> int "id" - Action Id. </li>
       <li> string "name" - Action name. </li>
       <li> string "type" - Action type. </li>
       <li> string "scheduler" - The user that scheduled the action. (optional) </li>
       <li> dateTime.iso8601 "earliest" - The earliest date and time the action
   will be performed </li>
       <li> int "completedSystems" - Number of systems that completed the action. </li>
       <li> int "failedSystems" - Number of systems that failed the action. </li>
       <li> int "inProgressSystems" - Number of systems that are in progress. </li>
 	</ul>
 
 </li></ul>
 
</li></ul>
</code>
<p />
<hr />

<h3> <a name="listCompletedSystems" href="#top">Method: listCompletedSystems</a></h3>
Description:<br />
Returns a list of systems that have completed a specific action.
<p />




Parameters:<br />
<ul>
<li>

        string sessionKey
 </li>
<li>

    string actionId
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
   	<li> int "server_id"</li>
       <li> string "server_name" - Server name. </li>
       <li> string "base_channel" - Base channel used by the server. </li>
       <li> dateTime.iso8601 "timestamp" - The time the action was completed </li>
       <li> string "message" - Optional message containing details
   on the execution of the action.  For example, if the action failed,
   this will contain the failure text. </li>
 	</ul>
 
 </li></ul>
 
</li></ul>
</code>
<p />
<hr />

<h3> <a name="listFailedActions" href="#top">Method: listFailedActions</a></h3>
Description:<br />
Returns a list of actions that have failed.
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
   

	     struct - action
	<ul>
       <li> int "id" - Action Id. </li>
       <li> string "name" - Action name. </li>
       <li> string "type" - Action type. </li>
       <li> string "scheduler" - The user that scheduled the action. (optional) </li>
       <li> dateTime.iso8601 "earliest" - The earliest date and time the action
   will be performed </li>
       <li> int "completedSystems" - Number of systems that completed the action. </li>
       <li> int "failedSystems" - Number of systems that failed the action. </li>
       <li> int "inProgressSystems" - Number of systems that are in progress. </li>
 	</ul>
 
 </li></ul>
 
</li></ul>
</code>
<p />
<hr />

<h3> <a name="listFailedSystems" href="#top">Method: listFailedSystems</a></h3>
Description:<br />
Returns a list of systems that have failed a specific action.
<p />




Parameters:<br />
<ul>
<li>

        string sessionKey
 </li>
<li>

    string actionId
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
   	<li> int "server_id"</li>
       <li> string "server_name" - Server name. </li>
       <li> string "base_channel" - Base channel used by the server. </li>
       <li> dateTime.iso8601 "timestamp" - The time the action was completed </li>
       <li> string "message" - Optional message containing details
   on the execution of the action.  For example, if the action failed,
   this will contain the failure text. </li>
 	</ul>
 
 </li></ul>
 
</li></ul>
</code>
<p />
<hr />

<h3> <a name="listInProgressActions" href="#top">Method: listInProgressActions</a></h3>
Description:<br />
Returns a list of actions that are in progress.
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
   

	     struct - action
	<ul>
       <li> int "id" - Action Id. </li>
       <li> string "name" - Action name. </li>
       <li> string "type" - Action type. </li>
       <li> string "scheduler" - The user that scheduled the action. (optional) </li>
       <li> dateTime.iso8601 "earliest" - The earliest date and time the action
   will be performed </li>
       <li> int "completedSystems" - Number of systems that completed the action. </li>
       <li> int "failedSystems" - Number of systems that failed the action. </li>
       <li> int "inProgressSystems" - Number of systems that are in progress. </li>
 	</ul>
 
 </li></ul>
 
</li></ul>
</code>
<p />
<hr />

<h3> <a name="listInProgressSystems" href="#top">Method: listInProgressSystems</a></h3>
Description:<br />
Returns a list of systems that have a specific action in progress.
<p />




Parameters:<br />
<ul>
<li>

        string sessionKey
 </li>
<li>

    string actionId
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
   	<li> int "server_id"</li>
       <li> string "server_name" - Server name. </li>
       <li> string "base_channel" - Base channel used by the server. </li>
       <li> dateTime.iso8601 "timestamp" - The time the action was completed </li>
       <li> string "message" - Optional message containing details
   on the execution of the action.  For example, if the action failed,
   this will contain the failure text. </li>
 	</ul>
 
 </li></ul>
 
</li></ul>
</code>
<p />
<hr />

<h3> <a name="rescheduleActions" href="#top">Method: rescheduleActions</a></h3>
Description:<br />
Reschedule all actions in the given list.
<p />




Parameters:<br />
<ul>
<li>

        string sessionKey
 </li>
<li>

array:
<ul>
    <li>int - action id</li>
</ul>
 </li>
<li>

    boolean onlyFailed - True to only reschedule failed actions, False to reschedule all
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
