/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: JspC/ApacheTomcat9
 * Generated at: 2020-03-09 19:26:49 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.apidoc;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class scripts_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.HashSet<>();
    _jspx_imports_packages.add("javax.servlet");
    _jspx_imports_packages.add("javax.servlet.http");
    _jspx_imports_packages.add("javax.servlet.jsp");
    _jspx_imports_classes = null;
  }

  private volatile javax.el.ExpressionFactory _el_expressionfactory;
  private volatile org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public java.util.Set<java.lang.String> getPackageImports() {
    return _jspx_imports_packages;
  }

  public java.util.Set<java.lang.String> getClassImports() {
    return _jspx_imports_classes;
  }

  public javax.el.ExpressionFactory _jsp_getExpressionFactory() {
    if (_el_expressionfactory == null) {
      synchronized (this) {
        if (_el_expressionfactory == null) {
          _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
        }
      }
    }
    return _el_expressionfactory;
  }

  public org.apache.tomcat.InstanceManager _jsp_getInstanceManager() {
    if (_jsp_instancemanager == null) {
      synchronized (this) {
        if (_jsp_instancemanager == null) {
          _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
        }
      }
    }
    return _jsp_instancemanager;
  }

  public void _jspInit() {
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
      throws java.io.IOException, javax.servlet.ServletException {

    if (!javax.servlet.DispatcherType.ERROR.equals(request.getDispatcherType())) {
      final java.lang.String _jspx_method = request.getMethod();
      if ("OPTIONS".equals(_jspx_method)) {
        response.setHeader("Allow","GET, HEAD, POST, OPTIONS");
        return;
      }
      if (!"GET".equals(_jspx_method) && !"POST".equals(_jspx_method) && !"HEAD".equals(_jspx_method)) {
        response.setHeader("Allow","GET, HEAD, POST, OPTIONS");
        response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED, "JSPs only permit GET, POST or HEAD. Jasper also permits OPTIONS");
        return;
      }
    }

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("<html>\n<head>\n  <meta http-equiv=\"cache-control\" content=\"no-cache\" />\n<style type=\"text/css\">\nul.apidoc {\n   list-style-image: url('/img/parent_node.gif');\n}\n</style>\n\n</head>\n<body>\n<h1><i class=\"fa fa-gears\"></i>Sample Scripts</h1>\n<h2>Sample Scripts</h2>\n<h3>Perl example:</h3><BR>\nThis Perl example shows the system.listUserSystems call being used to get a list of systems a user has access to.  In the example below, the name of each system will be printed.\nThe Frontier::Client Perl module can be found in the \"perl-Frontier-RPC\" rpm contained in the newest Satellite channel on http://rhn.redhat.com.\n<p />\n\n<code>\n#!/usr/bin/perl<br/>\nuse Frontier::Client;<br />\n<br />\nmy $HOST = 'satellite.example.com';<br />\nmy $user = 'username';<br />\nmy $pass = 'password';<br />\n<br />\nmy $client = new Frontier::Client(url => \"http://$HOST/rpc/api\");<br />\nmy $session = $client->call('auth.login',$user, $pass);<br />\n<br />\nmy $systems = $client->call('system.listUserSystems', $session);<br />\nforeach my $system (@$systems) {<br />\n");
      out.write("&nbsp;&nbsp;&nbsp;print $system->{'name'}.\"\\n\";<br />\n}<br />\n$client->call('auth.logout', $session);</br>\n</code>\n<hr />\n<p />\n<h3>Python example:</h3><br />\nBelow is an example of the user.listUsers call being used.  Only the login of each user is printed. \n<p />\n\n<code>\n#!/usr/bin/python<br />\nimport xmlrpclib<br />\n<br />\nSATELLITE_URL = \"http://satellite.example.com/rpc/api\"<br />\nSATELLITE_LOGIN = \"username\"<br />\nSATELLITE_PASSWORD = \"password\"<br />\n<br />\nclient = xmlrpclib.Server(SATELLITE_URL, verbose=0)<br />\n<br />\nkey = client.auth.login(SATELLITE_LOGIN, SATELLITE_PASSWORD)<br />\nlist = client.user.list_users(key)<br />\nfor user in list:<br />\n&nbsp;&nbsp;&nbsp;print user.get('login')<br />\n<br />\nclient.auth.logout(key)<br />\n</code>\n<p />\nThe following code shows how to use date-time parameters. This code will schedule\nimmediate installation of package rhnlib-2.5.22.9.el6.noarch to system with\nid 1000000001.\n<p />\n\n<code>\n#!/usr/bin/python<br />\nfrom datetime import datetime<br />\nimport time<br />\n");
      out.write("import xmlrpclib<br />\n<br />\nSATELLITE_URL = \"http://satellite.example.com/rpc/api\"<br />\nSATELLITE_LOGIN = \"username\"<br />\nSATELLITE_PASSWORD = \"password\"<br />\n<br />\nclient = xmlrpclib.Server(SATELLITE_URL, verbose=0)<br />\n<br />\nkey = client.auth.login(SATELLITE_LOGIN, SATELLITE_PASSWORD)<br />\npackage_list = client.packages.findByNvrea(key, 'rhnlib', '2.5.22', '9.el6', '', 'noarch')<br />\ntoday = datetime.today()<br />\nearliest_occurrence = xmlrpclib.DateTime(today)<br />\nclient.system.schedulePackageInstall(key, 1000000001, package_list[0]['id'],\nearliest_occurrence)<br />\n<br />\nclient.auth.logout(key)<br />\n</code>\n<p />\n<hr />\n\n<p />\n<h3>Ruby example:</h3><br />\nBelow is an example of the channel.listAllChannels API call. List of channel labels is printed.\n<p />\n\n<code>\n#!/usr/bin/ruby<br />\nrequire \"xmlrpc/client\"<br />\n<br />\n@SATELLITE_URL = \"http://satellite.example.com/rpc/api\"<br />\n@SATELLITE_LOGIN = \"username\"<br />\n@SATELLITE_PASSWORD = \"password\"<br />\n<br />\n@client = XMLRPC::Client.new2(@SATELLITE_URL)<br />\n");
      out.write("<br />\n@key = @client.call('auth.login', @SATELLITE_LOGIN, @SATELLITE_PASSWORD)<br />\nchannels = @client.call('channel.listAllChannels', @key)<br />\nfor channel in channels do<br />\n&nbsp;&nbsp;&nbsp;p channel[\"label\"]<br />\nend<br />\n<br />\n@client.call('auth.logout', @key)<br />\n</code>\n<hr />\n\nFor more examples visit the <a href=\"https://github.com/spacewalkproject/spacewalk/\">Spacewalk community page</a>.\n\n<p />\n</body><p />\n</html><p />\n");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try {
            if (response.isCommitted()) {
              out.flush();
            } else {
              out.clearBuffer();
            }
          } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
