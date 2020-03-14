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

public final class ChannelOrgHandler_jsp extends org.apache.jasper.runtime.HttpJspBase
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

      out.write("<html>\n<head>\n<meta http-equiv=\"cache-control\" content=\"no-cache\" />\n\n<style type=\"text/css\">\nul.apidoc {\n   list-style-image: url('/img/parent_node.gif');\n}\n\n.deprecated {\n   text-decoration: line-through;\n}\n</style>\n</head>\n<body>\n<div class=\"spacewalk-toolbar-h1\">\n<h1><i class=\"fa fa-gears\"></i>API Overview</h1>\n</div>\n\n<h2>Description</h2>\n<p><strong>Namespace</strong>:\nchannel.org\n</p>\n<p>Provides methods to retrieve and alter organization trust\n relationships for a channel.</p>\n<span class=\"small-text\">( <a href=\"/rhn/apidoc/index.jsp\">Return to API Overview</a> )</span>\n<hr />\n\n<div class=\"rounded-box\">\n<h2><a name=\"top\">Available methods</a></h2>\n<ul class=\"apidoc\">\n\n<li><a href=\"#disableAccess\"/>disableAccess</a></li>\n<li><a href=\"#enableAccess\"/>enableAccess</a></li>\n<li><a href=\"#list\"/>list</a></li>\n</ul>\n</div>\n<hr />\n\n<h3> <a name=\"disableAccess\" href=\"#top\">Method: disableAccess</a></h3>\nDescription:<br />\nDisable access to the channel for the given organization.\n<p />\n\n\n\n\nParameters:<br />\n<ul>\n");
      out.write("<li>\n\n        string sessionKey\n </li>\n<li>\n\n    string channelLabel - label of the channel\n </li>\n<li>\n\n    int orgId - id of org being removed access\n </li>\n</ul>\n<p />\nReturns:\n<code><ul><li>\n\n\n    int - 1 on success, exception thrown otherwise.\n \n</li></ul>\n</code>\n<p />\n<hr />\n\n<h3> <a name=\"enableAccess\" href=\"#top\">Method: enableAccess</a></h3>\nDescription:<br />\nEnable access to the channel for the given organization.\n<p />\n\n\n\n\nParameters:<br />\n<ul>\n<li>\n\n        string sessionKey\n </li>\n<li>\n\n    string channelLabel - label of the channel\n </li>\n<li>\n\n    int orgId - id of org being granted access\n </li>\n</ul>\n<p />\nReturns:\n<code><ul><li>\n\n\n    int - 1 on success, exception thrown otherwise.\n \n</li></ul>\n</code>\n<p />\n<hr />\n\n<h3> <a name=\"list\" href=\"#top\">Method: list</a></h3>\nDescription:<br />\nList the organizations associated with the given channel\n that may be trusted.\n<p />\n\n\n\n\nParameters:<br />\n<ul>\n<li>\n\n        string sessionKey\n </li>\n<li>\n\n    string channelLabel - label of the channel\n </li>\n");
      out.write("</ul>\n<p />\nReturns:\n<code><ul><li>\n\n\narray:\n  <ul>\n   <li>\n      \t     struct - org\n\t<ul>\n          \t<li> int \"org_id\"</li>\n          \t<li> string \"org_name\"</li>\n          \t<li> boolean \"access_enabled\"</li>\n     \t</ul>\n  </li></ul>\n \n</li></ul>\n</code>\n<p />\n<hr />\n</body>\n</html>\n");
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
