/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: JspC/ApacheTomcat9
 * Generated at: 2020-03-09 19:26:44 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.WEB_002dINF.pages.admin;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class catalina_jsp extends org.apache.jasper.runtime.HttpJspBase
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

  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005frhn_005frequire_0026_005facl_005fnobody;
  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005frhn_005ftoolbar_0026_005ficon_005fbase;
  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005frhn_005fcsrf_005fnobody;
  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fbean_005fmessage_0026_005fkey_005fnobody;
  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005frhn_005fsubmitted_005fnobody;

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
    _005fjspx_005ftagPool_005frhn_005frequire_0026_005facl_005fnobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _005fjspx_005ftagPool_005frhn_005ftoolbar_0026_005ficon_005fbase = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _005fjspx_005ftagPool_005frhn_005fcsrf_005fnobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _005fjspx_005ftagPool_005fbean_005fmessage_0026_005fkey_005fnobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _005fjspx_005ftagPool_005frhn_005fsubmitted_005fnobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
  }

  public void _jspDestroy() {
    _005fjspx_005ftagPool_005frhn_005frequire_0026_005facl_005fnobody.release();
    _005fjspx_005ftagPool_005frhn_005ftoolbar_0026_005ficon_005fbase.release();
    _005fjspx_005ftagPool_005frhn_005fcsrf_005fnobody.release();
    _005fjspx_005ftagPool_005fbean_005fmessage_0026_005fkey_005fnobody.release();
    _005fjspx_005ftagPool_005frhn_005fsubmitted_005fnobody.release();
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

      out.write("\n\n\n<html>\n    <body>\n        ");
      if (_jspx_meth_rhn_005frequire_005f0(_jspx_page_context))
        return;
      out.write("\n        ");
      if (_jspx_meth_rhn_005ftoolbar_005f0(_jspx_page_context))
        return;
      out.write("\n        <form action=\"/rhn/admin/Catalina.do\">\n            ");
      if (_jspx_meth_rhn_005fcsrf_005f0(_jspx_page_context))
        return;
      out.write("\n            <div class=\"panel panel-default\">\n                <div class=\"panel-heading\">\n                    ");
      if (_jspx_meth_bean_005fmessage_005f0(_jspx_page_context))
        return;
      out.write("\n                </div>\n                <div class=\"panel-body\">\n                    <textarea readonly rows=\"24\" class=\"form-control\">");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${contents}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("</textarea>\n                </div>\n            </div>\n            ");
      if (_jspx_meth_rhn_005fsubmitted_005f0(_jspx_page_context))
        return;
      out.write("\n        </form>\n    </body>\n</html>\n");
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

  private boolean _jspx_meth_rhn_005frequire_005f0(javax.servlet.jsp.PageContext _jspx_page_context)
          throws java.lang.Throwable {
    javax.servlet.jsp.PageContext pageContext = _jspx_page_context;
    javax.servlet.jsp.JspWriter out = _jspx_page_context.getOut();
    //  rhn:require
    com.redhat.rhn.frontend.taglibs.RequireTag _jspx_th_rhn_005frequire_005f0 = (com.redhat.rhn.frontend.taglibs.RequireTag) _005fjspx_005ftagPool_005frhn_005frequire_0026_005facl_005fnobody.get(com.redhat.rhn.frontend.taglibs.RequireTag.class);
    boolean _jspx_th_rhn_005frequire_005f0_reused = false;
    try {
      _jspx_th_rhn_005frequire_005f0.setPageContext(_jspx_page_context);
      _jspx_th_rhn_005frequire_005f0.setParent(null);
      // /WEB-INF/pages/admin/catalina.jsp(6,8) name = acl type = null reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
      _jspx_th_rhn_005frequire_005f0.setAcl("user_role(satellite_admin)");
      int _jspx_eval_rhn_005frequire_005f0 = _jspx_th_rhn_005frequire_005f0.doStartTag();
      if (_jspx_th_rhn_005frequire_005f0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        return true;
      }
      _005fjspx_005ftagPool_005frhn_005frequire_0026_005facl_005fnobody.reuse(_jspx_th_rhn_005frequire_005f0);
      _jspx_th_rhn_005frequire_005f0_reused = true;
    } finally {
      org.apache.jasper.runtime.JspRuntimeLibrary.releaseTag(_jspx_th_rhn_005frequire_005f0, _jsp_getInstanceManager(), _jspx_th_rhn_005frequire_005f0_reused);
    }
    return false;
  }

  private boolean _jspx_meth_rhn_005ftoolbar_005f0(javax.servlet.jsp.PageContext _jspx_page_context)
          throws java.lang.Throwable {
    javax.servlet.jsp.PageContext pageContext = _jspx_page_context;
    javax.servlet.jsp.JspWriter out = _jspx_page_context.getOut();
    //  rhn:toolbar
    com.redhat.rhn.frontend.taglibs.ToolbarTag _jspx_th_rhn_005ftoolbar_005f0 = (com.redhat.rhn.frontend.taglibs.ToolbarTag) _005fjspx_005ftagPool_005frhn_005ftoolbar_0026_005ficon_005fbase.get(com.redhat.rhn.frontend.taglibs.ToolbarTag.class);
    boolean _jspx_th_rhn_005ftoolbar_005f0_reused = false;
    try {
      _jspx_th_rhn_005ftoolbar_005f0.setPageContext(_jspx_page_context);
      _jspx_th_rhn_005ftoolbar_005f0.setParent(null);
      // /WEB-INF/pages/admin/catalina.jsp(7,8) name = base type = java.lang.String reqTime = false required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
      _jspx_th_rhn_005ftoolbar_005f0.setBase("h1");
      // /WEB-INF/pages/admin/catalina.jsp(7,8) name = icon type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
      _jspx_th_rhn_005ftoolbar_005f0.setIcon("header-list");
      int _jspx_eval_rhn_005ftoolbar_005f0 = _jspx_th_rhn_005ftoolbar_005f0.doStartTag();
      if (_jspx_eval_rhn_005ftoolbar_005f0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write("Tomcat");
          int evalDoAfterBody = _jspx_th_rhn_005ftoolbar_005f0.doAfterBody();
          if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
            break;
        } while (true);
      }
      if (_jspx_th_rhn_005ftoolbar_005f0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        return true;
      }
      _005fjspx_005ftagPool_005frhn_005ftoolbar_0026_005ficon_005fbase.reuse(_jspx_th_rhn_005ftoolbar_005f0);
      _jspx_th_rhn_005ftoolbar_005f0_reused = true;
    } finally {
      org.apache.jasper.runtime.JspRuntimeLibrary.releaseTag(_jspx_th_rhn_005ftoolbar_005f0, _jsp_getInstanceManager(), _jspx_th_rhn_005ftoolbar_005f0_reused);
    }
    return false;
  }

  private boolean _jspx_meth_rhn_005fcsrf_005f0(javax.servlet.jsp.PageContext _jspx_page_context)
          throws java.lang.Throwable {
    javax.servlet.jsp.PageContext pageContext = _jspx_page_context;
    javax.servlet.jsp.JspWriter out = _jspx_page_context.getOut();
    //  rhn:csrf
    com.redhat.rhn.frontend.taglibs.CsrfTag _jspx_th_rhn_005fcsrf_005f0 = (com.redhat.rhn.frontend.taglibs.CsrfTag) _005fjspx_005ftagPool_005frhn_005fcsrf_005fnobody.get(com.redhat.rhn.frontend.taglibs.CsrfTag.class);
    boolean _jspx_th_rhn_005fcsrf_005f0_reused = false;
    try {
      _jspx_th_rhn_005fcsrf_005f0.setPageContext(_jspx_page_context);
      _jspx_th_rhn_005fcsrf_005f0.setParent(null);
      int _jspx_eval_rhn_005fcsrf_005f0 = _jspx_th_rhn_005fcsrf_005f0.doStartTag();
      if (_jspx_th_rhn_005fcsrf_005f0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        return true;
      }
      _005fjspx_005ftagPool_005frhn_005fcsrf_005fnobody.reuse(_jspx_th_rhn_005fcsrf_005f0);
      _jspx_th_rhn_005fcsrf_005f0_reused = true;
    } finally {
      org.apache.jasper.runtime.JspRuntimeLibrary.releaseTag(_jspx_th_rhn_005fcsrf_005f0, _jsp_getInstanceManager(), _jspx_th_rhn_005fcsrf_005f0_reused);
    }
    return false;
  }

  private boolean _jspx_meth_bean_005fmessage_005f0(javax.servlet.jsp.PageContext _jspx_page_context)
          throws java.lang.Throwable {
    javax.servlet.jsp.PageContext pageContext = _jspx_page_context;
    javax.servlet.jsp.JspWriter out = _jspx_page_context.getOut();
    //  bean:message
    org.apache.struts.taglib.bean.MessageTag _jspx_th_bean_005fmessage_005f0 = (org.apache.struts.taglib.bean.MessageTag) _005fjspx_005ftagPool_005fbean_005fmessage_0026_005fkey_005fnobody.get(org.apache.struts.taglib.bean.MessageTag.class);
    boolean _jspx_th_bean_005fmessage_005f0_reused = false;
    try {
      _jspx_th_bean_005fmessage_005f0.setPageContext(_jspx_page_context);
      _jspx_th_bean_005fmessage_005f0.setParent(null);
      // /WEB-INF/pages/admin/catalina.jsp(12,20) name = key type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
      _jspx_th_bean_005fmessage_005f0.setKey("catalina.jsp.show");
      int _jspx_eval_bean_005fmessage_005f0 = _jspx_th_bean_005fmessage_005f0.doStartTag();
      if (_jspx_th_bean_005fmessage_005f0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        return true;
      }
      _005fjspx_005ftagPool_005fbean_005fmessage_0026_005fkey_005fnobody.reuse(_jspx_th_bean_005fmessage_005f0);
      _jspx_th_bean_005fmessage_005f0_reused = true;
    } finally {
      org.apache.jasper.runtime.JspRuntimeLibrary.releaseTag(_jspx_th_bean_005fmessage_005f0, _jsp_getInstanceManager(), _jspx_th_bean_005fmessage_005f0_reused);
    }
    return false;
  }

  private boolean _jspx_meth_rhn_005fsubmitted_005f0(javax.servlet.jsp.PageContext _jspx_page_context)
          throws java.lang.Throwable {
    javax.servlet.jsp.PageContext pageContext = _jspx_page_context;
    javax.servlet.jsp.JspWriter out = _jspx_page_context.getOut();
    //  rhn:submitted
    com.redhat.rhn.frontend.taglibs.SubmittedTag _jspx_th_rhn_005fsubmitted_005f0 = (com.redhat.rhn.frontend.taglibs.SubmittedTag) _005fjspx_005ftagPool_005frhn_005fsubmitted_005fnobody.get(com.redhat.rhn.frontend.taglibs.SubmittedTag.class);
    boolean _jspx_th_rhn_005fsubmitted_005f0_reused = false;
    try {
      _jspx_th_rhn_005fsubmitted_005f0.setPageContext(_jspx_page_context);
      _jspx_th_rhn_005fsubmitted_005f0.setParent(null);
      int _jspx_eval_rhn_005fsubmitted_005f0 = _jspx_th_rhn_005fsubmitted_005f0.doStartTag();
      if (_jspx_th_rhn_005fsubmitted_005f0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        return true;
      }
      _005fjspx_005ftagPool_005frhn_005fsubmitted_005fnobody.reuse(_jspx_th_rhn_005fsubmitted_005f0);
      _jspx_th_rhn_005fsubmitted_005f0_reused = true;
    } finally {
      org.apache.jasper.runtime.JspRuntimeLibrary.releaseTag(_jspx_th_rhn_005fsubmitted_005f0, _jsp_getInstanceManager(), _jspx_th_rhn_005fsubmitted_005f0_reused);
    }
    return false;
  }
}
