/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: JspC/ApacheTomcat9
 * Generated at: 2020-03-09 19:26:49 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.apidoc.handlers;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class SatelliteHandler_jsp extends org.apache.jasper.runtime.HttpJspBase
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

      out.write("<html>\n<head>\n<meta http-equiv=\"cache-control\" content=\"no-cache\" />\n\n<style type=\"text/css\">\nul.apidoc {\n   list-style-image: url('/img/parent_node.gif');\n}\n\n.deprecated {\n   text-decoration: line-through;\n}\n</style>\n</head>\n<body>\n<div class=\"spacewalk-toolbar-h1\">\n<h1><i class=\"fa fa-gears\"></i>API Overview</h1>\n</div>\n\n<h2>Description</h2>\n<p><strong>Namespace</strong>:\nsatellite\n</p>\n<p>Provides methods to obtain details on the Satellite.</p>\n<span class=\"small-text\">( <a href=\"/rhn/apidoc/index.jsp\">Return to API Overview</a> )</span>\n<hr />\n\n<div class=\"rounded-box\">\n<h2><a name=\"top\">Available methods</a></h2>\n<ul class=\"apidoc\">\n\n<li><a href=\"#isMonitoringEnabled\"/>isMonitoringEnabled</a></li>\n<li><a href=\"#isMonitoringEnabledBySystemId\"/>isMonitoringEnabledBySystemId</a></li>\n<li><a href=\"#listProxies\"/>listProxies</a></li>\n</ul>\n</div>\n<hr />\n\n<h3> <a name=\"isMonitoringEnabled\" href=\"#top\">Method: isMonitoringEnabled</a></h3>\nDescription:<br />\nIndicates if monitoring is enabled on the satellite\n<p />\n");
      out.write("\n\n\n\nParameters:<br />\n<ul>\n<li>\n\n    string sessionKey\n </li>\n</ul>\n<p />\nReturns:\n<code><ul><li>\n\n\n    boolean True if monitoring is enabled\n \n</li></ul>\n</code>\n<p />\n<hr />\n\n<h3> <a name=\"isMonitoringEnabledBySystemId\" href=\"#top\">Method: isMonitoringEnabledBySystemId</a></h3>\nDescription:<br />\nIndicates if monitoring is enabled on the satellite\n<p />\n\n\n\n\nParameters:<br />\n<ul>\n<li>\n\n    string systemid - systemid file\n </li>\n</ul>\n<p />\nReturns:\n<code><ul><li>\n\n\n    boolean True if monitoring is enabled\n \n</li></ul>\n</code>\n<p />\n<hr />\n\n<h3> <a name=\"listProxies\" href=\"#top\">Method: listProxies</a></h3>\nDescription:<br />\nList the proxies within the user's organization.\n<p />\n\n\n\n\nParameters:<br />\n<ul>\n<li>\n\n    string sessionKey\n </li>\n</ul>\n<p />\nReturns:\n<code><ul><li>\n\n\narray:\n  <ul>\n   <li>\n   \n\n\t     struct - system\n\t<ul>\n      \t<li> int \"id\"</li>\n      \t<li> string \"name\"</li>\n           <li> dateTime.iso8601 \"last_checkin\" - Last time server\n              successfully checked in </li>\n           <li> dateTime.iso8601 \"last_boot\" - Last server boot time </li>\n");
      out.write("           <li> dateTime.iso8601 \"created\" - Server registration time </li>\n\n \t</ul>\n \n </li></ul>\n \n</li></ul>\n</code>\n<p />\n<hr />\n</body>\n</html>\n");
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
