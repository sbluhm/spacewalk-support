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
system.scap
</p>
<p>Provides methods to schedule SCAP scans and access the results.</p>
<span class="small-text">( <a href="/rhn/apidoc/index.jsp">Return to API Overview</a> )</span>
<hr />

<div class="rounded-box">
<h2><a name="top">Available methods</a></h2>
<ul class="apidoc">

<li><a href="#deleteXccdfScan"/>deleteXccdfScan</a></li>
<li><a href="#getXccdfScanDetails"/>getXccdfScanDetails</a></li>
<li><a href="#getXccdfScanRuleResults"/>getXccdfScanRuleResults</a></li>
<li><a href="#listXccdfScans"/>listXccdfScans</a></li>
<li><a href="#scheduleXccdfScan"/>scheduleXccdfScan</a></li>
<li><a href="#scheduleXccdfScan"/>scheduleXccdfScan</a></li>
<li><a href="#scheduleXccdfScan"/>scheduleXccdfScan</a></li>
<li><a href="#scheduleXccdfScan"/>scheduleXccdfScan</a></li>
</ul>
</div>
<hr />

<h3> <a name="deleteXccdfScan" href="#top">Method: deleteXccdfScan</a></h3>
Description:<br />
Delete OpenSCAP XCCDF Scan from Spacewalk database. Note that
 only those SCAP Scans can be deleted which have passed their retention period.
<p />




Parameters:<br />
<ul>
<li>

        string sessionKey
 </li>
<li>

    int Id of XCCDF scan (xid).
 </li>
</ul>
<p />
Returns:
<code><ul><li>


boolean - indicates success of the operation. 
 
</li></ul>
</code>
<p />
<hr />

<h3> <a name="getXccdfScanDetails" href="#top">Method: getXccdfScanDetails</a></h3>
Description:<br />
Get details of given OpenSCAP XCCDF scan.
<p />




Parameters:<br />
<ul>
<li>

        string sessionKey
 </li>
<li>

    int Id of XCCDF scan (xid).
 </li>
</ul>
<p />
Returns:
<code><ul><li>




	     struct - OpenSCAP XCCDF Scan
	<ul>
       <li> int "xid" - XCCDF TestResult id </li>
       <li> int "sid" - serverId </li>
       <li> int "action_id" - Id of the parent action. </li>
       <li> string "path" - Path to XCCDF document </li>
       <li> string "oscap_parameters" - oscap command-line arguments. </li>
       <li> string "test_result" - Identifier of XCCDF TestResult. </li>
       <li> string "benchmark" - Identifier of XCCDF Benchmark. </li>
       <li> string "benchmark_version" - Version of the Benchmark. </li>
       <li> string "profile" - Identifier of XCCDF Profile. </li>
       <li> string "profile_title" - Title of XCCDF Profile. </li>
       <li> dateTime.iso8601 "start_time" - Client machine time of scan start. </li>
       <li> dateTime.iso8601 "end_time" - Client machine time of scan completion. </li>
       <li> string "errors" - Stderr output of scan. </li>
       <li> bool "deletable" - Indicates whether the scan can be deleted. </li>
 	</ul>
  
 
</li></ul>
</code>
<p />
<hr />

<h3> <a name="getXccdfScanRuleResults" href="#top">Method: getXccdfScanRuleResults</a></h3>
Description:<br />
Return a full list of RuleResults for given OpenSCAP XCCDF scan.
<p />




Parameters:<br />
<ul>
<li>

        string sessionKey
 </li>
<li>

    int Id of XCCDF scan (xid).
 </li>
</ul>
<p />
Returns:
<code><ul><li>


array:
  <ul>
   <li>
   

	     struct - OpenSCAP XCCDF RuleResult
	<ul>
       <li> string "idref" - idref from XCCDF document. </li>
       <li> string "result" - Result of evaluation. </li>
       <li> string "idents" - Comma separated list of XCCDF idents. </li>
 	</ul>
 
 </li></ul>
 
</li></ul>
</code>
<p />
<hr />

<h3> <a name="listXccdfScans" href="#top">Method: listXccdfScans</a></h3>
Description:<br />
Return a list of finished OpenSCAP scans for a given system.
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
   

	     struct - OpenSCAP XCCDF Scan
	<ul>
       <li> int "xid" - XCCDF TestResult ID </li>
       <li> string "profile" - XCCDF Profile </li>
       <li> string "path" - Path to XCCDF document </li>
       <li> dateTime.iso8601 "completed" - Scan completion time </li>
 	</ul>
 
 </li></ul>
 
</li></ul>
</code>
<p />
<hr />

<h3> <a name="scheduleXccdfScan" href="#top">Method: scheduleXccdfScan</a></h3>
Description:<br />
Schedule OpenSCAP scan.
<p />




Parameters:<br />
<ul>
<li>

        string sessionKey
 </li>
<li>

array:
<ul>
    <li>int - serverId</li>
</ul>
 </li>
<li>

    string Path to xccdf content on targeted systems.
 </li>
<li>

    string Additional parameters for oscap tool.
 </li>
</ul>
<p />
Returns:
<code><ul><li>


int - ID if SCAP action created. 
 
</li></ul>
</code>
<p />
<hr />

<h3> <a name="scheduleXccdfScan" href="#top">Method: scheduleXccdfScan</a></h3>
Description:<br />
Schedule OpenSCAP scan.
<p />




Parameters:<br />
<ul>
<li>

        string sessionKey
 </li>
<li>

array:
<ul>
    <li>int - serverId</li>
</ul>
 </li>
<li>

    string Path to xccdf content on targeted systems.
 </li>
<li>

    string Additional parameters for oscap tool.
 </li>
<li>

    dateTime.iso8601 date - The date to schedule the action
 </li>
</ul>
<p />
Returns:
<code><ul><li>


int - ID if SCAP action created. 
 
</li></ul>
</code>
<p />
<hr />

<h3> <a name="scheduleXccdfScan" href="#top">Method: scheduleXccdfScan</a></h3>
Description:<br />
Schedule Scap XCCDF scan.
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

    string Path to xccdf content on targeted system.
 </li>
<li>

    string Additional parameters for oscap tool.
 </li>
</ul>
<p />
Returns:
<code><ul><li>


int - ID of the scap action created. 
 
</li></ul>
</code>
<p />
<hr />

<h3> <a name="scheduleXccdfScan" href="#top">Method: scheduleXccdfScan</a></h3>
Description:<br />
Schedule Scap XCCDF scan.
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

    string Path to xccdf content on targeted system.
 </li>
<li>

    string Additional parameters for oscap tool.
 </li>
<li>

    dateTime.iso8601 date - The date to schedule the action
 </li>
</ul>
<p />
Returns:
<code><ul><li>


int - ID of the scap action created. 
 
</li></ul>
</code>
<p />
<hr />
</body>
</html>
