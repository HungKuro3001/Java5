/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/9.0.60
 * Generated at: 2022-04-21 17:07:40 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.Views.user;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class index_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.HashMap<java.lang.String,java.lang.Long>(2);
    _jspx_dependants.put("/WEB-INF/lib/jstl-1.2.jar", Long.valueOf(1647390950154L));
    _jspx_dependants.put("jar:file:/D:/Java4/.metadata/.plugins/org.eclipse.wst.server.core/tmp0/wtpwebapps/ASM_Java4/WEB-INF/lib/jstl-1.2.jar!/META-INF/c.tld", Long.valueOf(1153359882000L));
  }

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.HashSet<>();
    _jspx_imports_packages.add("javax.servlet");
    _jspx_imports_packages.add("javax.servlet.http");
    _jspx_imports_packages.add("javax.servlet.jsp");
    _jspx_imports_classes = null;
  }

  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fc_005fif_0026_005ftest;
  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fc_005fforEach_0026_005fvar_005fitems;

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
    _005fjspx_005ftagPool_005fc_005fif_0026_005ftest = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _005fjspx_005ftagPool_005fc_005fforEach_0026_005fvar_005fitems = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
  }

  public void _jspDestroy() {
    _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.release();
    _005fjspx_005ftagPool_005fc_005fforEach_0026_005fvar_005fitems.release();
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
      response.setContentType("text/html; charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<!DOCTYPE HTML>\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<title>LeoShop</title>\r\n");
      out.write("<meta name=\"viewport\"\r\n");
      out.write("	content=\"width=device-width, initial-scale=1, maximum-scale=1\">\r\n");
      out.write("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\" />\r\n");
      out.write("<link href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("/Views/css/style.css\"\r\n");
      out.write("	rel=\"stylesheet\" type=\"text/css\" media=\"all\" />\r\n");
      out.write("<link href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("/Views/css/form.css\"\r\n");
      out.write("	rel=\"stylesheet\" type=\"text/css\" media=\"all\" />\r\n");
      out.write("<link href='http://fonts.googleapis.com/css?family=Exo+2'\r\n");
      out.write("	rel='stylesheet' type='text/css'>\r\n");
      out.write("<link\r\n");
      out.write("	href=\"https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/css/bootstrap.min.css\"\r\n");
      out.write("	rel=\"stylesheet\"\r\n");
      out.write("	integrity=\"sha384-+0n0xVW2eSR5OomGNYDnhzAbDsOXxcvSN1TPprVMTNDbiYZCxYbOOl7+AMvyTG2x\"\r\n");
      out.write("	crossorigin=\"anonymous\">\r\n");
      out.write("<link\r\n");
      out.write("	href=\"https://cdn.jsdelivr.net/npm/bootstrap-icons@1.5.0/font/bootstrap-icons.css\"\r\n");
      out.write("	rel=\"stylesheet\" />\r\n");
      out.write("<script\r\n");
      out.write("	src=\"https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/js/bootstrap.bundle.min.js\"\r\n");
      out.write("	integrity=\"sha384-gtEjrD/SeCtmISkJkNUaaKMoLD0//ElJ19smozuHV6z3Iehds+3Ulb9Bn9Plx0x4\"\r\n");
      out.write("	crossorigin=\"anonymous\"></script>\r\n");
      out.write("<script type=\"text/javascript\"\r\n");
      out.write("	src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("/Views/js/jquery1.min.js\"></script>\r\n");
      out.write("\r\n");
      out.write("<!-- start menu -->\r\n");
      out.write("<link href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("/Views/css/megamenu.css\"\r\n");
      out.write("	rel=\"stylesheet\" type=\"text/css\" media=\"all\" />\r\n");
      out.write("<script type=\"text/javascript\"\r\n");
      out.write("	src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("/Views/js/megamenu.js\"></script>\r\n");
      out.write("<script>\r\n");
      out.write("	$(document).ready(function() {\r\n");
      out.write("		$(\".megamenu\").megamenu();\r\n");
      out.write("	});\r\n");
      out.write("</script>\r\n");
      out.write("<!--start slider -->\r\n");
      out.write("<link rel=\"stylesheet\"\r\n");
      out.write("	href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("/Views/css/fwslider.css\"\r\n");
      out.write("	media=\"all\">\r\n");
      out.write("<script\r\n");
      out.write("	src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("/Views/js/jquery-ui.min.js\"></script>\r\n");
      out.write("<script\r\n");
      out.write("	src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("/Views/js/css3-mediaqueries.js\"></script>\r\n");
      out.write("<script src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("/Views/js/fwslider.js\"></script>\r\n");
      out.write("<!--end slider -->\r\n");
      out.write("<script\r\n");
      out.write("	src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("/Views/js/jquery.easydropdown.js\"></script>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("	<div class=\"header-top\">\r\n");
      out.write("		<div class=\"wrap\">\r\n");
      out.write("			<div class=\"header-top-left\">\r\n");
      out.write("				<div class=\"box\">\r\n");
      out.write("					<select tabindex=\"4\" class=\"dropdown\">\r\n");
      out.write("						<option value=\"\" class=\"label\" value=\"\">Language :</option>\r\n");
      out.write("						<option value=\"1\">English</option>\r\n");
      out.write("						<option value=\"2\">French</option>\r\n");
      out.write("						<option value=\"3\">German</option>\r\n");
      out.write("					</select>\r\n");
      out.write("				</div>\r\n");
      out.write("				<div class=\"box1\">\r\n");
      out.write("					<select tabindex=\"4\" class=\"dropdown\">\r\n");
      out.write("						<option value=\"\" class=\"label\" value=\"\">Currency :</option>\r\n");
      out.write("						<option value=\"1\">$ Dollar</option>\r\n");
      out.write("						<option value=\"2\">€ Euro</option>\r\n");
      out.write("					</select>\r\n");
      out.write("				</div>\r\n");
      out.write("				<div class=\"clear\"></div>\r\n");
      out.write("			</div>\r\n");
      out.write("			<div class=\"cssmenu\">\r\n");
      out.write("				<ul>\r\n");
      out.write("					");
      if (_jspx_meth_c_005fif_005f0(_jspx_page_context))
        return;
      out.write("\r\n");
      out.write("					");
      if (_jspx_meth_c_005fif_005f1(_jspx_page_context))
        return;
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("				</ul>\r\n");
      out.write("			</div>\r\n");
      out.write("			<div class=\"clear\"></div>\r\n");
      out.write("		</div>\r\n");
      out.write("	</div>\r\n");
      out.write("	<div class=\"header-bottom\">\r\n");
      out.write("		<div class=\"wrap\">\r\n");
      out.write("			<div class=\"header-bottom-left\">\r\n");
      out.write("				<div class=\"logo\">\r\n");
      out.write("					<a href=\"/ASM_Java4/users/index\"><img\r\n");
      out.write("						src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("/Views/images/logo.png\"\r\n");
      out.write("						alt=\"\" /></a>\r\n");
      out.write("				</div>\r\n");
      out.write("				<div class=\"menu\">\r\n");
      out.write("					<ul class=\"megamenu skyblue\">\r\n");
      out.write("						<li class=\"active grid\"><a href=\"/ASM_Java4/users/index\">Home</a></li>\r\n");
      out.write("						");
      if (_jspx_meth_c_005fforEach_005f0(_jspx_page_context))
        return;
      out.write("\r\n");
      out.write("					</ul>\r\n");
      out.write("				</div>\r\n");
      out.write("			</div>\r\n");
      out.write("			<div class=\"header-bottom-right\">\r\n");
      out.write("				<div class=\"search\">\r\n");
      out.write("					<input type=\"text\" name=\"s\" class=\"textbox\" value=\"Search\"\r\n");
      out.write("						onfocus=\"this.value = '';\"\r\n");
      out.write("						onblur=\"if (this.value == '') {this.value = 'Search';}\"> <input\r\n");
      out.write("						type=\"submit\" value=\"Subscribe\" id=\"submit\" name=\"submit\">\r\n");
      out.write("					<div id=\"response\"></div>\r\n");
      out.write("				</div>\r\n");
      out.write("				<div class=\"tag-list\">\r\n");
      out.write("					<ul class=\"last\">\r\n");
      out.write("						<li><a href=\"/ASM_Java4/users/formcart\">Cart</a></li>\r\n");
      out.write("					</ul>\r\n");
      out.write("				</div>\r\n");
      out.write("			</div>\r\n");
      out.write("			<div class=\"clear\"></div>\r\n");
      out.write("		</div>\r\n");
      out.write("	</div>\r\n");
      out.write("	<div class=\"mens\">\r\n");
      out.write("		<div class=\"main\">\r\n");
      out.write("			");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, (java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${view}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null), out, false);
      out.write("\r\n");
      out.write("		</div>\r\n");
      out.write("	</div>\r\n");
      out.write("	<div class=\"footer\">\r\n");
      out.write("		<div class=\"footer-top\">\r\n");
      out.write("			<div class=\"wrap\">\r\n");
      out.write("				<div class=\"section group example\">\r\n");
      out.write("					<div class=\"col_1_of_2 span_1_of_2\">\r\n");
      out.write("						<ul class=\"f-list\">\r\n");
      out.write("							<li><img\r\n");
      out.write("								src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("/Views/images/2.png\"><span\r\n");
      out.write("								class=\"f-text\">Free Shipping on orders over $ 100</span>\r\n");
      out.write("								<div class=\"clear\"></div></li>\r\n");
      out.write("						</ul>\r\n");
      out.write("					</div>\r\n");
      out.write("					<div class=\"col_1_of_2 span_1_of_2\">\r\n");
      out.write("						<ul class=\"f-list\">\r\n");
      out.write("							<li><img\r\n");
      out.write("								src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("/Views/images/3.png\"><span\r\n");
      out.write("								class=\"f-text\">Call us! toll free-222-555-6666 </span>\r\n");
      out.write("								<div class=\"clear\"></div></li>\r\n");
      out.write("						</ul>\r\n");
      out.write("					</div>\r\n");
      out.write("					<div class=\"clear\"></div>\r\n");
      out.write("				</div>\r\n");
      out.write("			</div>\r\n");
      out.write("		</div>\r\n");
      out.write("		<div class=\"footer-middle\">\r\n");
      out.write("			<div class=\"wrap\">\r\n");
      out.write("				<div class=\"section group example\">\r\n");
      out.write("					<div class=\"col_1_of_f_1 span_1_of_f_1\">\r\n");
      out.write("						<div class=\"section group example\">\r\n");
      out.write("							<div class=\"col_1_of_f_2 span_1_of_f_2\">\r\n");
      out.write("								<h3>Facebook</h3>\r\n");
      out.write("								<script>\r\n");
      out.write("									(function(d, s, id) {\r\n");
      out.write("										var js, fjs = d.getElementsByTagName(s)[0];\r\n");
      out.write("										if (d.getElementById(id))\r\n");
      out.write("											return;\r\n");
      out.write("										js = d.createElement(s);\r\n");
      out.write("										js.id = id;\r\n");
      out.write("										js.src = \"//connect.facebook.net/en_US/all.js#xfbml=1\";\r\n");
      out.write("										fjs.parentNode.insertBefore(js, fjs);\r\n");
      out.write("									}(document, 'script', 'facebook-jssdk'));\r\n");
      out.write("								</script>\r\n");
      out.write("								<div class=\"like_box\">\r\n");
      out.write("									<div class=\"fb-like-box\"\r\n");
      out.write("										data-href=\"http://www.facebook.com/w3layouts\"\r\n");
      out.write("										data-colorscheme=\"light\" data-show-faces=\"true\"\r\n");
      out.write("										data-header=\"true\" data-stream=\"false\" data-show-border=\"true\"></div>\r\n");
      out.write("								</div>\r\n");
      out.write("							</div>\r\n");
      out.write("							<div class=\"col_1_of_f_2 span_1_of_f_2\">\r\n");
      out.write("								<h3>From Twitter</h3>\r\n");
      out.write("								<div class=\"recent-tweet\">\r\n");
      out.write("									<div class=\"recent-tweet-icon\">\r\n");
      out.write("										<span> </span>\r\n");
      out.write("									</div>\r\n");
      out.write("									<div class=\"recent-tweet-info\">\r\n");
      out.write("										<p>\r\n");
      out.write("											Ds which don't look even slightly believable. If you are <a\r\n");
      out.write("												href=\"#\">going to use nibh euismod</a> tincidunt ut laoreet\r\n");
      out.write("											adipisicing\r\n");
      out.write("										</p>\r\n");
      out.write("									</div>\r\n");
      out.write("									<div class=\"clear\"></div>\r\n");
      out.write("								</div>\r\n");
      out.write("								<div class=\"recent-tweet\">\r\n");
      out.write("									<div class=\"recent-tweet-icon\">\r\n");
      out.write("										<span> </span>\r\n");
      out.write("									</div>\r\n");
      out.write("									<div class=\"recent-tweet-info\">\r\n");
      out.write("										<p>\r\n");
      out.write("											Ds which don't look even slightly believable. If you are <a\r\n");
      out.write("												href=\"#\">going to use nibh euismod</a> tincidunt ut laoreet\r\n");
      out.write("											adipisicing\r\n");
      out.write("										</p>\r\n");
      out.write("									</div>\r\n");
      out.write("									<div class=\"clear\"></div>\r\n");
      out.write("								</div>\r\n");
      out.write("							</div>\r\n");
      out.write("							<div class=\"clear\"></div>\r\n");
      out.write("						</div>\r\n");
      out.write("					</div>\r\n");
      out.write("					<div class=\"col_1_of_f_1 span_1_of_f_1\">\r\n");
      out.write("						<div class=\"section group example\">\r\n");
      out.write("							<div class=\"col_1_of_f_2 span_1_of_f_2\">\r\n");
      out.write("								<h3>Information</h3>\r\n");
      out.write("								<ul class=\"f-list1\">\r\n");
      out.write("									<li><a href=\"#\">Duis autem vel eum iriure </a></li>\r\n");
      out.write("									<li><a href=\"#\">anteposuerit litterarum formas </a></li>\r\n");
      out.write("									<li><a href=\"#\">Tduis dolore te feugait nulla</a></li>\r\n");
      out.write("									<li><a href=\"#\">Duis autem vel eum iriure </a></li>\r\n");
      out.write("									<li><a href=\"#\">anteposuerit litterarum formas </a></li>\r\n");
      out.write("									<li><a href=\"#\">Tduis dolore te feugait nulla</a></li>\r\n");
      out.write("								</ul>\r\n");
      out.write("							</div>\r\n");
      out.write("							<div class=\"col_1_of_f_2 span_1_of_f_2\">\r\n");
      out.write("								<h3>Contact us</h3>\r\n");
      out.write("								<div class=\"company_address\">\r\n");
      out.write("									<p>500 Lorem Ipsum Dolor Sit,</p>\r\n");
      out.write("									<p>22-56-2-9 Sit Amet, Lorem,</p>\r\n");
      out.write("									<p>USA</p>\r\n");
      out.write("									<p>Phone:(00) 222 666 444</p>\r\n");
      out.write("									<p>Fax: (000) 000 00 00 0</p>\r\n");
      out.write("									<p>\r\n");
      out.write("										Email: <span>mail[at]leoshop.com</span>\r\n");
      out.write("									</p>\r\n");
      out.write("\r\n");
      out.write("								</div>\r\n");
      out.write("								<div class=\"social-media\">\r\n");
      out.write("									<ul>\r\n");
      out.write("										<li><span class=\"simptip-position-bottom simptip-movable\"\r\n");
      out.write("											data-tooltip=\"Google\"><a href=\"#\" target=\"_blank\">\r\n");
      out.write("											</a></span></li>\r\n");
      out.write("										<li><span class=\"simptip-position-bottom simptip-movable\"\r\n");
      out.write("											data-tooltip=\"Linked in\"><a href=\"#\" target=\"_blank\">\r\n");
      out.write("											</a> </span></li>\r\n");
      out.write("										<li><span class=\"simptip-position-bottom simptip-movable\"\r\n");
      out.write("											data-tooltip=\"Rss\"><a href=\"#\" target=\"_blank\"> </a></span></li>\r\n");
      out.write("										<li><span class=\"simptip-position-bottom simptip-movable\"\r\n");
      out.write("											data-tooltip=\"Facebook\"><a href=\"#\" target=\"_blank\">\r\n");
      out.write("											</a></span></li>\r\n");
      out.write("									</ul>\r\n");
      out.write("								</div>\r\n");
      out.write("							</div>\r\n");
      out.write("							<div class=\"clear\"></div>\r\n");
      out.write("						</div>\r\n");
      out.write("					</div>\r\n");
      out.write("					<div class=\"clear\"></div>\r\n");
      out.write("				</div>\r\n");
      out.write("			</div>\r\n");
      out.write("		</div>\r\n");
      out.write("		<div class=\"footer-bottom\">\r\n");
      out.write("			<div class=\"wrap\">\r\n");
      out.write("				<div class=\"copy\">\r\n");
      out.write("					<p>\r\n");
      out.write("						© 2014 Template by <a href=\"http://w3layouts.com\" target=\"_blank\">w3layouts</a>\r\n");
      out.write("					</p>\r\n");
      out.write("				</div>\r\n");
      out.write("				<div class=\"f-list2\">\r\n");
      out.write("					<ul>\r\n");
      out.write("						<li class=\"active\"><a href=\"about.html\">About Us</a></li> |\r\n");
      out.write("						<li><a href=\"delivery.html\">Delivery & Returns</a></li> |\r\n");
      out.write("						<li><a href=\"delivery.html\">Terms & Conditions</a></li> |\r\n");
      out.write("						<li><a href=\"contact.html\">Contact Us</a></li>\r\n");
      out.write("					</ul>\r\n");
      out.write("				</div>\r\n");
      out.write("				<div class=\"clear\"></div>\r\n");
      out.write("			</div>\r\n");
      out.write("		</div>\r\n");
      out.write("	</div>\r\n");
      out.write("	</div>\r\n");
      out.write("</body>\r\n");
      out.write("</html>");
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

  private boolean _jspx_meth_c_005fif_005f0(javax.servlet.jsp.PageContext _jspx_page_context)
          throws java.lang.Throwable {
    javax.servlet.jsp.PageContext pageContext = _jspx_page_context;
    javax.servlet.jsp.JspWriter out = _jspx_page_context.getOut();
    //  c:if
    org.apache.taglibs.standard.tag.rt.core.IfTag _jspx_th_c_005fif_005f0 = (org.apache.taglibs.standard.tag.rt.core.IfTag) _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.get(org.apache.taglibs.standard.tag.rt.core.IfTag.class);
    boolean _jspx_th_c_005fif_005f0_reused = false;
    try {
      _jspx_th_c_005fif_005f0.setPageContext(_jspx_page_context);
      _jspx_th_c_005fif_005f0.setParent(null);
      // /Views/user/index.jsp(79,5) name = test type = boolean reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
      _jspx_th_c_005fif_005f0.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${empty sessionScope.taikhoan }", boolean.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null)).booleanValue());
      int _jspx_eval_c_005fif_005f0 = _jspx_th_c_005fif_005f0.doStartTag();
      if (_jspx_eval_c_005fif_005f0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write("\r\n");
          out.write("						<li><a href=\"/ASM_Java4/login\">Log In</a></li> |\r\n");
          out.write("                        <li><a href=\"/ASM_Java4/login\">Sign Up</a></li>\r\n");
          out.write("					");
          int evalDoAfterBody = _jspx_th_c_005fif_005f0.doAfterBody();
          if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
            break;
        } while (true);
      }
      if (_jspx_th_c_005fif_005f0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        return true;
      }
      _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.reuse(_jspx_th_c_005fif_005f0);
      _jspx_th_c_005fif_005f0_reused = true;
    } finally {
      org.apache.jasper.runtime.JspRuntimeLibrary.releaseTag(_jspx_th_c_005fif_005f0, _jsp_getInstanceManager(), _jspx_th_c_005fif_005f0_reused);
    }
    return false;
  }

  private boolean _jspx_meth_c_005fif_005f1(javax.servlet.jsp.PageContext _jspx_page_context)
          throws java.lang.Throwable {
    javax.servlet.jsp.PageContext pageContext = _jspx_page_context;
    javax.servlet.jsp.JspWriter out = _jspx_page_context.getOut();
    //  c:if
    org.apache.taglibs.standard.tag.rt.core.IfTag _jspx_th_c_005fif_005f1 = (org.apache.taglibs.standard.tag.rt.core.IfTag) _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.get(org.apache.taglibs.standard.tag.rt.core.IfTag.class);
    boolean _jspx_th_c_005fif_005f1_reused = false;
    try {
      _jspx_th_c_005fif_005f1.setPageContext(_jspx_page_context);
      _jspx_th_c_005fif_005f1.setParent(null);
      // /Views/user/index.jsp(83,5) name = test type = boolean reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
      _jspx_th_c_005fif_005f1.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${!empty sessionScope.taikhoan }", boolean.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null)).booleanValue());
      int _jspx_eval_c_005fif_005f1 = _jspx_th_c_005fif_005f1.doStartTag();
      if (_jspx_eval_c_005fif_005f1 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write("\r\n");
          out.write("						<li><a href=\"\">Xin chào ");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${sessionScope.taikhoan.hoTen }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
          out.write("</a></li> |\r\n");
          out.write("                        <li><a href=\"/ASM_Java4/users/history\">Lịch sử đơn hàng</a></li>\r\n");
          out.write("                        <li><a href=\"/ASM_Java4/logout\">Đăng xuất</a></li>\r\n");
          out.write("					");
          int evalDoAfterBody = _jspx_th_c_005fif_005f1.doAfterBody();
          if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
            break;
        } while (true);
      }
      if (_jspx_th_c_005fif_005f1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        return true;
      }
      _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.reuse(_jspx_th_c_005fif_005f1);
      _jspx_th_c_005fif_005f1_reused = true;
    } finally {
      org.apache.jasper.runtime.JspRuntimeLibrary.releaseTag(_jspx_th_c_005fif_005f1, _jsp_getInstanceManager(), _jspx_th_c_005fif_005f1_reused);
    }
    return false;
  }

  private boolean _jspx_meth_c_005fforEach_005f0(javax.servlet.jsp.PageContext _jspx_page_context)
          throws java.lang.Throwable {
    javax.servlet.jsp.PageContext pageContext = _jspx_page_context;
    javax.servlet.jsp.JspWriter out = _jspx_page_context.getOut();
    //  c:forEach
    org.apache.taglibs.standard.tag.rt.core.ForEachTag _jspx_th_c_005fforEach_005f0 = (org.apache.taglibs.standard.tag.rt.core.ForEachTag) _005fjspx_005ftagPool_005fc_005fforEach_0026_005fvar_005fitems.get(org.apache.taglibs.standard.tag.rt.core.ForEachTag.class);
    boolean _jspx_th_c_005fforEach_005f0_reused = false;
    try {
      _jspx_th_c_005fforEach_005f0.setPageContext(_jspx_page_context);
      _jspx_th_c_005fforEach_005f0.setParent(null);
      // /Views/user/index.jsp(106,6) name = var type = java.lang.String reqTime = false required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
      _jspx_th_c_005fforEach_005f0.setVar("item");
      // /Views/user/index.jsp(106,6) name = items type = javax.el.ValueExpression reqTime = true required = false fragment = false deferredValue = true expectedTypeName = java.lang.Object deferredMethod = false methodSignature = null
      _jspx_th_c_005fforEach_005f0.setItems(new org.apache.jasper.el.JspValueExpression("/Views/user/index.jsp(106,6) '${categories }'",_jsp_getExpressionFactory().createValueExpression(_jspx_page_context.getELContext(),"${categories }",java.lang.Object.class)).getValue(_jspx_page_context.getELContext()));
      int[] _jspx_push_body_count_c_005fforEach_005f0 = new int[] { 0 };
      try {
        int _jspx_eval_c_005fforEach_005f0 = _jspx_th_c_005fforEach_005f0.doStartTag();
        if (_jspx_eval_c_005fforEach_005f0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
          do {
            out.write("\r\n");
            out.write("							<li><a class=\"color5\"\r\n");
            out.write("								href=\"/ASM_Java4/users/categories?id=");
            out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${item.id}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
            out.write('"');
            out.write('>');
            out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${item.ten}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
            out.write("</a></li>\r\n");
            out.write("						");
            int evalDoAfterBody = _jspx_th_c_005fforEach_005f0.doAfterBody();
            if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
              break;
          } while (true);
        }
        if (_jspx_th_c_005fforEach_005f0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
          return true;
        }
      } catch (java.lang.Throwable _jspx_exception) {
        while (_jspx_push_body_count_c_005fforEach_005f0[0]-- > 0)
          out = _jspx_page_context.popBody();
        _jspx_th_c_005fforEach_005f0.doCatch(_jspx_exception);
      } finally {
        _jspx_th_c_005fforEach_005f0.doFinally();
      }
      _005fjspx_005ftagPool_005fc_005fforEach_0026_005fvar_005fitems.reuse(_jspx_th_c_005fforEach_005f0);
      _jspx_th_c_005fforEach_005f0_reused = true;
    } finally {
      org.apache.jasper.runtime.JspRuntimeLibrary.releaseTag(_jspx_th_c_005fforEach_005f0, _jsp_getInstanceManager(), _jspx_th_c_005fforEach_005f0_reused);
    }
    return false;
  }
}
