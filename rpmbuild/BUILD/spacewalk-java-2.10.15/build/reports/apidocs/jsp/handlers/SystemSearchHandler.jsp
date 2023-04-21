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
system.search
</p>
<p>Provides methods to perform system search requests using the search server.</p>
<span class="small-text">( <a href="/rhn/apidoc/index.jsp">Return to API Overview</a> )</span>
<hr />

<div class="rounded-box">
<h2><a name="top">Available methods</a></h2>
<ul class="apidoc">

<li><a href="#deviceDescription"/>deviceDescription</a></li>
<li><a href="#deviceDriver"/>deviceDriver</a></li>
<li><a href="#deviceId"/>deviceId</a></li>
<li><a href="#deviceVendorId"/>deviceVendorId</a></li>
<li><a href="#hostname"/>hostname</a></li>
<li><a href="#ip"/>ip</a></li>
<li><a href="#nameAndDescription"/>nameAndDescription</a></li>
<li><a href="#uuid"/>uuid</a></li>
</ul>
</div>
<hr />

<h3> <a name="deviceDescription" href="#top">Method: deviceDescription</a></h3>
Description:<br />
List the systems which match the device description.
<p />




Parameters:<br />
<ul>
<li>

        string sessionKey
 </li>
<li>

    string searchTerm
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
      	<li> string "hostname"</li>
      	<li> string "ip"</li>
          <li> string "hw_description" - hw description if not null </li>
          <li> string "hw_device_id" - hw device id if not null </li>
          <li> string "hw_vendor_id" - hw vendor id if not null </li>
          <li> string "hw_driver" - hw driver if not null </li>
 	</ul>
 
     </li></ul>
 
</li></ul>
</code>
<p />
<hr />

<h3> <a name="deviceDriver" href="#top">Method: deviceDriver</a></h3>
Description:<br />
List the systems which match this device driver.
<p />




Parameters:<br />
<ul>
<li>

        string sessionKey
 </li>
<li>

    string searchTerm
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
      	<li> string "hostname"</li>
      	<li> string "ip"</li>
          <li> string "hw_description" - hw description if not null </li>
          <li> string "hw_device_id" - hw device id if not null </li>
          <li> string "hw_vendor_id" - hw vendor id if not null </li>
          <li> string "hw_driver" - hw driver if not null </li>
 	</ul>
 
     </li></ul>
 
</li></ul>
</code>
<p />
<hr />

<h3> <a name="deviceId" href="#top">Method: deviceId</a></h3>
Description:<br />
List the systems which match this device id
<p />




Parameters:<br />
<ul>
<li>

        string sessionKey
 </li>
<li>

    string searchTerm
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
      	<li> string "hostname"</li>
      	<li> string "ip"</li>
          <li> string "hw_description" - hw description if not null </li>
          <li> string "hw_device_id" - hw device id if not null </li>
          <li> string "hw_vendor_id" - hw vendor id if not null </li>
          <li> string "hw_driver" - hw driver if not null </li>
 	</ul>
 
     </li></ul>
 
</li></ul>
</code>
<p />
<hr />

<h3> <a name="deviceVendorId" href="#top">Method: deviceVendorId</a></h3>
Description:<br />
List the systems which match this device vendor_id
<p />




Parameters:<br />
<ul>
<li>

        string sessionKey
 </li>
<li>

    string searchTerm
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
      	<li> string "hostname"</li>
      	<li> string "ip"</li>
          <li> string "hw_description" - hw description if not null </li>
          <li> string "hw_device_id" - hw device id if not null </li>
          <li> string "hw_vendor_id" - hw vendor id if not null </li>
          <li> string "hw_driver" - hw driver if not null </li>
 	</ul>
 
     </li></ul>
 
</li></ul>
</code>
<p />
<hr />

<h3> <a name="hostname" href="#top">Method: hostname</a></h3>
Description:<br />
List the systems which match this hostname
<p />




Parameters:<br />
<ul>
<li>

        string sessionKey
 </li>
<li>

    string searchTerm
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
      	<li> string "hostname"</li>
      	<li> string "ip"</li>
          <li> string "hw_description" - hw description if not null </li>
          <li> string "hw_device_id" - hw device id if not null </li>
          <li> string "hw_vendor_id" - hw vendor id if not null </li>
          <li> string "hw_driver" - hw driver if not null </li>
 	</ul>
 
     </li></ul>
 
</li></ul>
</code>
<p />
<hr />

<h3> <a name="ip" href="#top">Method: ip</a></h3>
Description:<br />
List the systems which match this ip.
<p />




Parameters:<br />
<ul>
<li>

        string sessionKey
 </li>
<li>

    string searchTerm
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
      	<li> string "hostname"</li>
      	<li> string "ip"</li>
          <li> string "hw_description" - hw description if not null </li>
          <li> string "hw_device_id" - hw device id if not null </li>
          <li> string "hw_vendor_id" - hw vendor id if not null </li>
          <li> string "hw_driver" - hw driver if not null </li>
 	</ul>
 
     </li></ul>
 
</li></ul>
</code>
<p />
<hr />

<h3> <a name="nameAndDescription" href="#top">Method: nameAndDescription</a></h3>
Description:<br />
List the systems which match this name or description
<p />




Parameters:<br />
<ul>
<li>

        string sessionKey
 </li>
<li>

    string searchTerm
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
      	<li> string "hostname"</li>
      	<li> string "ip"</li>
          <li> string "hw_description" - hw description if not null </li>
          <li> string "hw_device_id" - hw device id if not null </li>
          <li> string "hw_vendor_id" - hw vendor id if not null </li>
          <li> string "hw_driver" - hw driver if not null </li>
 	</ul>
 
     </li></ul>
 
</li></ul>
</code>
<p />
<hr />

<h3> <a name="uuid" href="#top">Method: uuid</a></h3>
Description:<br />
List the systems which match this UUID
<p />




Parameters:<br />
<ul>
<li>

        string sessionKey
 </li>
<li>

    string searchTerm
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
      	<li> string "hostname"</li>
      	<li> string "ip"</li>
          <li> string "hw_description" - hw description if not null </li>
          <li> string "hw_device_id" - hw device id if not null </li>
          <li> string "hw_vendor_id" - hw vendor id if not null </li>
          <li> string "hw_driver" - hw driver if not null </li>
 	</ul>
 
     </li></ul>
 
</li></ul>
</code>
<p />
<hr />
</body>
</html>
