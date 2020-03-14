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
preferences.locale
</p>
<p>Provides methods to access and modify user locale information</p>
<span class="small-text">( <a href="/rhn/apidoc/index.jsp">Return to API Overview</a> )</span>
<hr />

<div class="rounded-box">
<h2><a name="top">Available methods</a></h2>
<ul class="apidoc">

<li><a href="#listLocales"/>listLocales</a></li>
<li><a href="#listTimeZones"/>listTimeZones</a></li>
<li><a href="#setLocale"/>setLocale</a></li>
<li><a href="#setTimeZone"/>setTimeZone</a></li>
</ul>
</div>
<hr />

<h3> <a name="listLocales" href="#top">Method: listLocales</a></h3>
Description:<br />
Returns a list of all understood locales. Can be
 used as input to setLocale.
<p />




Parameters:<br />
<ul>
</ul>
<p />
Returns:
<code><ul><li>


array:
<ul>
    <li>string - Locale code.</li>
</ul>
 
</li></ul>
</code>
<p />
<hr />

<h3> <a name="listTimeZones" href="#top">Method: listTimeZones</a></h3>
Description:<br />
Returns a list of all understood timezones. Results can be
 used as input to setTimeZone.
<p />




Parameters:<br />
<ul>
</ul>
<p />
Returns:
<code><ul><li>


array:
  <ul>
   <li>
   

	     struct - timezone
	<ul>
       <li> int "time_zone_id" - Unique identifier for timezone. </li>
       <li> string "olson_name" - Name as identified by the Olson database. </li>
 	</ul>
 
 </li></ul>
 
</li></ul>
</code>
<p />
<hr />

<h3> <a name="setLocale" href="#top">Method: setLocale</a></h3>
Description:<br />
Set a user's locale.
<p />




Parameters:<br />
<ul>
<li>

    string sessionKey
 </li>
<li>

    string login - User's login name.
 </li>
<li>

    string locale - Locale to set. (from listLocales)
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

<h3> <a name="setTimeZone" href="#top">Method: setTimeZone</a></h3>
Description:<br />
Set a user's timezone.
<p />




Parameters:<br />
<ul>
<li>

    string sessionKey
 </li>
<li>

    string login - User's login name.
 </li>
<li>

    int tzid - Timezone ID. (from listTimeZones)
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
