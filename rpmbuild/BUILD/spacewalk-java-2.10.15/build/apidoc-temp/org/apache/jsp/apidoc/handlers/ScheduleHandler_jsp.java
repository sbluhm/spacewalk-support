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

public final class ScheduleHandler_jsp extends org.apache.jasper.runtime.HttpJspBase
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

      out.write("<html>\n<head>\n<meta http-equiv=\"cache-control\" content=\"no-cache\" />\n\n<style type=\"text/css\">\nul.apidoc {\n   list-style-image: url('/img/parent_node.gif');\n}\n\n.deprecated {\n   text-decoration: line-through;\n}\n</style>\n</head>\n<body>\n<div class=\"spacewalk-toolbar-h1\">\n<h1><i class=\"fa fa-gears\"></i>API Overview</h1>\n</div>\n\n<h2>Description</h2>\n<p><strong>Namespace</strong>:\nschedule\n</p>\n<p>Methods to retrieve information about scheduled actions.</p>\n<span class=\"small-text\">( <a href=\"/rhn/apidoc/index.jsp\">Return to API Overview</a> )</span>\n<hr />\n\n<div class=\"rounded-box\">\n<h2><a name=\"top\">Available methods</a></h2>\n<ul class=\"apidoc\">\n\n<li><a href=\"#archiveActions\"/>archiveActions</a></li>\n<li><a href=\"#cancelActions\"/>cancelActions</a></li>\n<li><a href=\"#deleteActions\"/>deleteActions</a></li>\n<li><a href=\"#failSystemAction\"/>failSystemAction</a></li>\n<li><a href=\"#failSystemAction\"/>failSystemAction</a></li>\n<li><a href=\"#listAllActions\"/>listAllActions</a></li>\n<li><a href=\"#listArchivedActions\"/>listArchivedActions</a></li>\n");
      out.write("<li><a href=\"#listCompletedActions\"/>listCompletedActions</a></li>\n<li><a href=\"#listCompletedSystems\"/>listCompletedSystems</a></li>\n<li><a href=\"#listFailedActions\"/>listFailedActions</a></li>\n<li><a href=\"#listFailedSystems\"/>listFailedSystems</a></li>\n<li><a href=\"#listInProgressActions\"/>listInProgressActions</a></li>\n<li><a href=\"#listInProgressSystems\"/>listInProgressSystems</a></li>\n<li><a href=\"#rescheduleActions\"/>rescheduleActions</a></li>\n</ul>\n</div>\n<hr />\n\n<h3> <a name=\"archiveActions\" href=\"#top\">Method: archiveActions</a></h3>\nDescription:<br />\nArchive all actions in the given list.\n<p />\n\n\n\n\nParameters:<br />\n<ul>\n<li>\n\n        string sessionKey\n </li>\n<li>\n\narray:\n<ul>\n    <li>int - action id</li>\n</ul>\n </li>\n</ul>\n<p />\nReturns:\n<code><ul><li>\n\n\n    int - 1 on success, exception thrown otherwise.\n \n</li></ul>\n</code>\n<p />\n<hr />\n\n<h3> <a name=\"cancelActions\" href=\"#top\">Method: cancelActions</a></h3>\nDescription:<br />\nCancel all actions in given list. If an invalid action is provided,\n none of the actions given will canceled.\n");
      out.write("<p />\n\n\n\n\nParameters:<br />\n<ul>\n<li>\n\n        string sessionKey\n </li>\n<li>\n\narray:\n<ul>\n    <li>int - action id</li>\n</ul>\n </li>\n</ul>\n<p />\nReturns:\n<code><ul><li>\n\n\n    int - 1 on success, exception thrown otherwise.\n \n</li></ul>\n</code>\n<p />\n<hr />\n\n<h3> <a name=\"deleteActions\" href=\"#top\">Method: deleteActions</a></h3>\nDescription:<br />\nDelete all archived actions in the given list.\n<p />\n\n\n\n\nParameters:<br />\n<ul>\n<li>\n\n        string sessionKey\n </li>\n<li>\n\narray:\n<ul>\n    <li>int - action id</li>\n</ul>\n </li>\n</ul>\n<p />\nReturns:\n<code><ul><li>\n\n\n    int - 1 on success, exception thrown otherwise.\n \n</li></ul>\n</code>\n<p />\n<hr />\n\n<h3> <a name=\"failSystemAction\" href=\"#top\">Method: failSystemAction</a></h3>\nDescription:<br />\nFail specific event on specified system\n<p />\n\n\n\n\nParameters:<br />\n<ul>\n<li>\n\n        string sessionKey\n </li>\n<li>\n\n    int serverId\n </li>\n<li>\n\n    int actionId\n </li>\n</ul>\n<p />\nReturns:\n<code><ul><li>\n\n\n    int - 1 on success, exception thrown otherwise.\n \n</li></ul>\n</code>\n");
      out.write("<p />\n<hr />\n\n<h3> <a name=\"failSystemAction\" href=\"#top\">Method: failSystemAction</a></h3>\nDescription:<br />\nFail specific event on specified system\n<p />\n\n\n\n\nParameters:<br />\n<ul>\n<li>\n\n        string sessionKey\n </li>\n<li>\n\n    int serverId\n </li>\n<li>\n\n    int actionId\n </li>\n<li>\n\n    string message\n </li>\n</ul>\n<p />\nReturns:\n<code><ul><li>\n\n\n    int - 1 on success, exception thrown otherwise.\n \n</li></ul>\n</code>\n<p />\n<hr />\n\n<h3> <a name=\"listAllActions\" href=\"#top\">Method: listAllActions</a></h3>\nDescription:<br />\nReturns a list of all actions.  This includes completed, in progress,\n failed and archived actions.\n<p />\n\n\n\n\nParameters:<br />\n<ul>\n<li>\n\n        string sessionKey\n </li>\n</ul>\n<p />\nReturns:\n<code><ul><li>\n\n\narray:\n  <ul>\n   <li>\n   \n\n\t     struct - action\n\t<ul>\n       <li> int \"id\" - Action Id. </li>\n       <li> string \"name\" - Action name. </li>\n       <li> string \"type\" - Action type. </li>\n       <li> string \"scheduler\" - The user that scheduled the action. (optional) </li>\n       <li> dateTime.iso8601 \"earliest\" - The earliest date and time the action\n");
      out.write("   will be performed </li>\n       <li> int \"completedSystems\" - Number of systems that completed the action. </li>\n       <li> int \"failedSystems\" - Number of systems that failed the action. </li>\n       <li> int \"inProgressSystems\" - Number of systems that are in progress. </li>\n \t</ul>\n \n </li></ul>\n \n</li></ul>\n</code>\n<p />\n<hr />\n\n<h3> <a name=\"listArchivedActions\" href=\"#top\">Method: listArchivedActions</a></h3>\nDescription:<br />\nReturns a list of actions that have been archived.\n<p />\n\n\n\n\nParameters:<br />\n<ul>\n<li>\n\n        string sessionKey\n </li>\n</ul>\n<p />\nReturns:\n<code><ul><li>\n\n\narray:\n  <ul>\n   <li>\n   \n\n\t     struct - action\n\t<ul>\n       <li> int \"id\" - Action Id. </li>\n       <li> string \"name\" - Action name. </li>\n       <li> string \"type\" - Action type. </li>\n       <li> string \"scheduler\" - The user that scheduled the action. (optional) </li>\n       <li> dateTime.iso8601 \"earliest\" - The earliest date and time the action\n   will be performed </li>\n       <li> int \"completedSystems\" - Number of systems that completed the action. </li>\n");
      out.write("       <li> int \"failedSystems\" - Number of systems that failed the action. </li>\n       <li> int \"inProgressSystems\" - Number of systems that are in progress. </li>\n \t</ul>\n \n </li></ul>\n \n</li></ul>\n</code>\n<p />\n<hr />\n\n<h3> <a name=\"listCompletedActions\" href=\"#top\">Method: listCompletedActions</a></h3>\nDescription:<br />\nReturns a list of actions that have completed successfully.\n<p />\n\n\n\n\nParameters:<br />\n<ul>\n<li>\n\n        string sessionKey\n </li>\n</ul>\n<p />\nReturns:\n<code><ul><li>\n\n\narray:\n  <ul>\n   <li>\n   \n\n\t     struct - action\n\t<ul>\n       <li> int \"id\" - Action Id. </li>\n       <li> string \"name\" - Action name. </li>\n       <li> string \"type\" - Action type. </li>\n       <li> string \"scheduler\" - The user that scheduled the action. (optional) </li>\n       <li> dateTime.iso8601 \"earliest\" - The earliest date and time the action\n   will be performed </li>\n       <li> int \"completedSystems\" - Number of systems that completed the action. </li>\n       <li> int \"failedSystems\" - Number of systems that failed the action. </li>\n");
      out.write("       <li> int \"inProgressSystems\" - Number of systems that are in progress. </li>\n \t</ul>\n \n </li></ul>\n \n</li></ul>\n</code>\n<p />\n<hr />\n\n<h3> <a name=\"listCompletedSystems\" href=\"#top\">Method: listCompletedSystems</a></h3>\nDescription:<br />\nReturns a list of systems that have completed a specific action.\n<p />\n\n\n\n\nParameters:<br />\n<ul>\n<li>\n\n        string sessionKey\n </li>\n<li>\n\n    string actionId\n </li>\n</ul>\n<p />\nReturns:\n<code><ul><li>\n\n\narray:\n  <ul>\n   <li>\n   \n\n\t     struct - system\n\t<ul>\n   \t<li> int \"server_id\"</li>\n       <li> string \"server_name\" - Server name. </li>\n       <li> string \"base_channel\" - Base channel used by the server. </li>\n       <li> dateTime.iso8601 \"timestamp\" - The time the action was completed </li>\n       <li> string \"message\" - Optional message containing details\n   on the execution of the action.  For example, if the action failed,\n   this will contain the failure text. </li>\n \t</ul>\n \n </li></ul>\n \n</li></ul>\n</code>\n<p />\n<hr />\n\n<h3> <a name=\"listFailedActions\" href=\"#top\">Method: listFailedActions</a></h3>\n");
      out.write("Description:<br />\nReturns a list of actions that have failed.\n<p />\n\n\n\n\nParameters:<br />\n<ul>\n<li>\n\n        string sessionKey\n </li>\n</ul>\n<p />\nReturns:\n<code><ul><li>\n\n\narray:\n  <ul>\n   <li>\n   \n\n\t     struct - action\n\t<ul>\n       <li> int \"id\" - Action Id. </li>\n       <li> string \"name\" - Action name. </li>\n       <li> string \"type\" - Action type. </li>\n       <li> string \"scheduler\" - The user that scheduled the action. (optional) </li>\n       <li> dateTime.iso8601 \"earliest\" - The earliest date and time the action\n   will be performed </li>\n       <li> int \"completedSystems\" - Number of systems that completed the action. </li>\n       <li> int \"failedSystems\" - Number of systems that failed the action. </li>\n       <li> int \"inProgressSystems\" - Number of systems that are in progress. </li>\n \t</ul>\n \n </li></ul>\n \n</li></ul>\n</code>\n<p />\n<hr />\n\n<h3> <a name=\"listFailedSystems\" href=\"#top\">Method: listFailedSystems</a></h3>\nDescription:<br />\nReturns a list of systems that have failed a specific action.\n");
      out.write("<p />\n\n\n\n\nParameters:<br />\n<ul>\n<li>\n\n        string sessionKey\n </li>\n<li>\n\n    string actionId\n </li>\n</ul>\n<p />\nReturns:\n<code><ul><li>\n\n\narray:\n  <ul>\n   <li>\n   \n\n\t     struct - system\n\t<ul>\n   \t<li> int \"server_id\"</li>\n       <li> string \"server_name\" - Server name. </li>\n       <li> string \"base_channel\" - Base channel used by the server. </li>\n       <li> dateTime.iso8601 \"timestamp\" - The time the action was completed </li>\n       <li> string \"message\" - Optional message containing details\n   on the execution of the action.  For example, if the action failed,\n   this will contain the failure text. </li>\n \t</ul>\n \n </li></ul>\n \n</li></ul>\n</code>\n<p />\n<hr />\n\n<h3> <a name=\"listInProgressActions\" href=\"#top\">Method: listInProgressActions</a></h3>\nDescription:<br />\nReturns a list of actions that are in progress.\n<p />\n\n\n\n\nParameters:<br />\n<ul>\n<li>\n\n        string sessionKey\n </li>\n</ul>\n<p />\nReturns:\n<code><ul><li>\n\n\narray:\n  <ul>\n   <li>\n   \n\n\t     struct - action\n\t<ul>\n       <li> int \"id\" - Action Id. </li>\n");
      out.write("       <li> string \"name\" - Action name. </li>\n       <li> string \"type\" - Action type. </li>\n       <li> string \"scheduler\" - The user that scheduled the action. (optional) </li>\n       <li> dateTime.iso8601 \"earliest\" - The earliest date and time the action\n   will be performed </li>\n       <li> int \"completedSystems\" - Number of systems that completed the action. </li>\n       <li> int \"failedSystems\" - Number of systems that failed the action. </li>\n       <li> int \"inProgressSystems\" - Number of systems that are in progress. </li>\n \t</ul>\n \n </li></ul>\n \n</li></ul>\n</code>\n<p />\n<hr />\n\n<h3> <a name=\"listInProgressSystems\" href=\"#top\">Method: listInProgressSystems</a></h3>\nDescription:<br />\nReturns a list of systems that have a specific action in progress.\n<p />\n\n\n\n\nParameters:<br />\n<ul>\n<li>\n\n        string sessionKey\n </li>\n<li>\n\n    string actionId\n </li>\n</ul>\n<p />\nReturns:\n<code><ul><li>\n\n\narray:\n  <ul>\n   <li>\n   \n\n\t     struct - system\n\t<ul>\n   \t<li> int \"server_id\"</li>\n       <li> string \"server_name\" - Server name. </li>\n");
      out.write("       <li> string \"base_channel\" - Base channel used by the server. </li>\n       <li> dateTime.iso8601 \"timestamp\" - The time the action was completed </li>\n       <li> string \"message\" - Optional message containing details\n   on the execution of the action.  For example, if the action failed,\n   this will contain the failure text. </li>\n \t</ul>\n \n </li></ul>\n \n</li></ul>\n</code>\n<p />\n<hr />\n\n<h3> <a name=\"rescheduleActions\" href=\"#top\">Method: rescheduleActions</a></h3>\nDescription:<br />\nReschedule all actions in the given list.\n<p />\n\n\n\n\nParameters:<br />\n<ul>\n<li>\n\n        string sessionKey\n </li>\n<li>\n\narray:\n<ul>\n    <li>int - action id</li>\n</ul>\n </li>\n<li>\n\n    boolean onlyFailed - True to only reschedule failed actions, False to reschedule all\n </li>\n</ul>\n<p />\nReturns:\n<code><ul><li>\n\n\n    int - 1 on success, exception thrown otherwise.\n \n</li></ul>\n</code>\n<p />\n<hr />\n</body>\n</html>\n");
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
