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
channel
</p>
<p>Provides method to get back a list of Software Channels.</p>
<span class="small-text">( <a href="/rhn/apidoc/index.jsp">Return to API Overview</a> )</span>
<hr />

<div class="rounded-box">
<h2><a name="top">Available methods</a></h2>
<ul class="apidoc">

<li><a href="#listAllChannels"/>listAllChannels</a></li>
<li><a href="#listManageableChannels"/>listManageableChannels</a></li>
<li><a href="#listMyChannels"/>listMyChannels</a></li>
<li><a href="#listPopularChannels"/>listPopularChannels</a></li>
<li><a href="#listRedHatChannels"/>listRedHatChannels</a></li>
<li><a href="#listRetiredChannels"/>listRetiredChannels</a></li>
<li><a href="#listSharedChannels"/>listSharedChannels</a></li>
<li><a href="#listSoftwareChannels"/>listSoftwareChannels</a></li>
<li><a href="#listVendorChannels"/>listVendorChannels</a></li>
</ul>
</div>
<hr />

<h3> <a name="listAllChannels" href="#top">Method: listAllChannels</a></h3>
Description:<br />
List all software channels that the user's organization is entitled to.
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
         

	     struct - channel info
	<ul>
     	<li> int "id"</li>
     	<li> string "label"</li>
     	<li> string "name"</li>
     	<li> string "provider_name"</li>
     	<li> int "packages"</li>
     	<li> int "systems"</li>
     	<li> string "arch_name"</li>
   	</ul>
 
     </li></ul>
 
</li></ul>
</code>
<p />
<hr />

<h3> <a name="listManageableChannels" href="#top">Method: listManageableChannels</a></h3>
Description:<br />
List all software channels that the user is entitled to manage.
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
         

	     struct - channel info
	<ul>
     	<li> int "id"</li>
     	<li> string "label"</li>
     	<li> string "name"</li>
     	<li> string "provider_name"</li>
     	<li> int "packages"</li>
     	<li> int "systems"</li>
     	<li> string "arch_name"</li>
   	</ul>
 
     </li></ul>
 
</li></ul>
</code>
<p />
<hr />

<h3> <a name="listMyChannels" href="#top">Method: listMyChannels</a></h3>
Description:<br />
List all software channels that belong to the user's organization.
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
         

	     struct - channel info
	<ul>
     	<li> int "id"</li>
     	<li> string "label"</li>
     	<li> string "name"</li>
     	<li> string "provider_name"</li>
     	<li> int "packages"</li>
     	<li> int "systems"</li>
     	<li> string "arch_name"</li>
   	</ul>
 
     </li></ul>
 
</li></ul>
</code>
<p />
<hr />

<h3> <a name="listPopularChannels" href="#top">Method: listPopularChannels</a></h3>
Description:<br />
List the most popular software channels.  Channels that have at least
 the number of systems subscribed as specified by the popularity count will be
 returned.
<p />




Parameters:<br />
<ul>
<li>

        string sessionKey
 </li>
<li>

    int popularityCount
 </li>
</ul>
<p />
Returns:
<code><ul><li>


array:
  <ul>
   <li>
         

	     struct - channel info
	<ul>
     	<li> int "id"</li>
     	<li> string "label"</li>
     	<li> string "name"</li>
     	<li> string "provider_name"</li>
     	<li> int "packages"</li>
     	<li> int "systems"</li>
     	<li> string "arch_name"</li>
   	</ul>
 
     </li></ul>
 
</li></ul>
</code>
<p />
<hr />

<h3 class="deprecated"><a name="listRedHatChannels" href="#top">Method: listRedHatChannels</a></h3>
Description:<br />
List all Red Hat software channels that the user's organization is
 entitled to.
<p />


Deprecated - being replaced by listVendorChannels(String sessionKey) <p />


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
         

	     struct - channel info
	<ul>
     	<li> int "id"</li>
     	<li> string "label"</li>
     	<li> string "name"</li>
     	<li> string "provider_name"</li>
     	<li> int "packages"</li>
     	<li> int "systems"</li>
     	<li> string "arch_name"</li>
   	</ul>
 
     </li></ul>
 
</li></ul>
</code>
<p />
<hr />

<h3> <a name="listRetiredChannels" href="#top">Method: listRetiredChannels</a></h3>
Description:<br />
List all retired software channels.  These are channels that the user's
 organization is entitled to, but are no longer supported because they have reached
 their 'end-of-life' date.
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
         

	     struct - channel info
	<ul>
     	<li> int "id"</li>
     	<li> string "label"</li>
     	<li> string "name"</li>
     	<li> string "provider_name"</li>
     	<li> int "packages"</li>
     	<li> int "systems"</li>
     	<li> string "arch_name"</li>
   	</ul>
 
     </li></ul>
 
</li></ul>
</code>
<p />
<hr />

<h3> <a name="listSharedChannels" href="#top">Method: listSharedChannels</a></h3>
Description:<br />
List all software channels that may be shared by the user's
 organization.
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
         

	     struct - channel info
	<ul>
     	<li> int "id"</li>
     	<li> string "label"</li>
     	<li> string "name"</li>
     	<li> string "provider_name"</li>
     	<li> int "packages"</li>
     	<li> int "systems"</li>
     	<li> string "arch_name"</li>
   	</ul>
 
     </li></ul>
 
</li></ul>
</code>
<p />
<hr />

<h3> <a name="listSoftwareChannels" href="#top">Method: listSoftwareChannels</a></h3>
Description:<br />
List all visible software channels.
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
      	     struct - channel
	<ul>
          	<li> string "label"</li>
          	<li> string "name"</li>
          	<li> string "parent_label"</li>
          	<li> string "end_of_life"</li>
          	<li> string "arch"</li>
      	</ul>
  </li></ul>
 
</li></ul>
</code>
<p />
<hr />

<h3> <a name="listVendorChannels" href="#top">Method: listVendorChannels</a></h3>
Description:<br />
Lists all the vendor software channels that the user's organization
 is entitled to.
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
         

	     struct - channel info
	<ul>
     	<li> int "id"</li>
     	<li> string "label"</li>
     	<li> string "name"</li>
     	<li> string "provider_name"</li>
     	<li> int "packages"</li>
     	<li> int "systems"</li>
     	<li> string "arch_name"</li>
   	</ul>
 
     </li></ul>
 
</li></ul>
</code>
<p />
<hr />
</body>
</html>
