/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/9.0.59
 * Generated at: 2022-07-07 09:22:56 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.view;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.ArrayList;
import model.bean.Tree;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpServletRequest;
import model.bean.ShoppingCart;
import model.dao.ShoppingCartDao;
import java.util.ArrayList;
import model.bean.Tree;

public final class catalog_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

int i;
  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.HashMap<java.lang.String,java.lang.Long>(2);
    _jspx_dependants.put("/html/homeNavbar.jsp", Long.valueOf(1657099948000L));
    _jspx_dependants.put("/html/footer.html", Long.valueOf(1656400984000L));
  }

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.HashSet<>();
    _jspx_imports_packages.add("javax.servlet");
    _jspx_imports_packages.add("javax.servlet.http");
    _jspx_imports_packages.add("javax.servlet.jsp");
    _jspx_imports_classes = new java.util.HashSet<>();
    _jspx_imports_classes.add("javax.servlet.http.HttpSession");
    _jspx_imports_classes.add("javax.servlet.http.HttpServletRequest");
    _jspx_imports_classes.add("model.bean.Tree");
    _jspx_imports_classes.add("model.bean.ShoppingCart");
    _jspx_imports_classes.add("java.util.ArrayList");
    _jspx_imports_classes.add("model.dao.ShoppingCartDao");
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
      response.setContentType("text/html; charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write(" <head>\n");
      out.write("  <meta charset=\"UTF-8\">\n");
      out.write("  <title>Catalogo</title>\n");
      out.write("    <link rel=\"icon\" href=\"/ArborVitae/img/homepage_images/logo.ico\" type=\"image/x-icon\">\n");
      out.write("  <link href=\"https://maxcdn.bootstrapcdn.com/font-awesome/4.3.0/css/font-awesome.min.css\" rel=\"stylesheet\" />\n");
      out.write("  <link rel=\"stylesheet\" type=\"text/css\" href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("/style/catalog.css\"/>  \n");
      out.write("\n");
      out.write("  <style type=\"text/css\"> \n");
      out.write("     .dropbtn1 {\n");
      out.write("    background-color: #46dd2c !important;\n");
      out.write("    color: white;\n");
      out.write("    padding: 8px;\n");
      out.write("    font-size: 25px;\n");
      out.write("    border: none;\n");
      out.write("    float: right;\n");
      out.write("    margin: -50px -50px 300px 2px;\n");
      out.write("     border-radius: 20%\n");
      out.write("   }\n");
      out.write("   \n");
      out.write("   .dropdown {\n");
      out.write("     position: relative;\n");
      out.write("     display: inline-block;\n");
      out.write("   }\n");
      out.write("   \n");
      out.write("   .dropdown-content {\n");
      out.write("     display: none;\n");
      out.write("     position: absolute;\n");
      out.write("     background-color: white;\n");
      out.write("     min-width: 160px;\n");
      out.write("     box-shadow: 0px 8px 16px 0px rgba(0,0,0,0.2);\n");
      out.write("     z-index: 1;\n");
      out.write("   }\n");
      out.write("   \n");
      out.write("   .dropdown-content a {\n");
      out.write("     color: gray;\n");
      out.write("     padding: 3.5px;\n");
      out.write("     text-decoration: none;\n");
      out.write("     display: block;\n");
      out.write("   }\n");
      out.write("   \n");
      out.write("   .dropdown-content a:hover {background-color: #ddd; border-radius: 10px}\n");
      out.write("   \n");
      out.write("   .dropdown:hover .dropdown-content {display: block; border-radius: 10px}\n");
      out.write("   \n");
      out.write("   .dropdown:hover .dropbtn {background-color: #46dd2c; border-radius: 10px}\n");
      out.write("   \n");
      out.write("  \n");
      out.write("   .navbar-space {\n");
      out.write("     border: 40px solid white;\n");
      out.write("     background-color: white;\n");
      out.write("   }\n");
      out.write("   \n");
      out.write("   \n");
      out.write("  .inclusive-container{\n");
      out.write("  	 text-align: center;\n");
      out.write("  }\n");
      out.write("  \n");
      out.write("  .products-container{\n");
      out.write("     background-color: inherit;\n");
      out.write("     padding: 1.5em;\n");
      out.write("     margin: 0px 10px 35px 10px;\n");
      out.write("     width: 300px;\n");
      out.write("     height: 450px;\n");
      out.write("     vertical-align: bottom;\n");
      out.write("     display: inline-block;\n");
      out.write("   }\n");
      out.write("  .searchcontainer{\n");
      out.write("      margin: 70px;\n");
      out.write("      padding: 0;\n");
      out.write("  }\n");
      out.write(" \n");
      out.write("    .search-box{\n");
      out.write("        position:absolute;\n");
      out.write("        top: 50%;\n");
      out.write("        left: 50%;\n");
      out.write("        transform: translate(-50%, -50%);\n");
      out.write("        background-color: #46dd2c;\n");
      out.write("        height: 40px;\n");
      out.write("        border-radius: 30px;\n");
      out.write("        padding:10px;\n");
      out.write("    }\n");
      out.write("\n");
      out.write("    .formsearch:hover > .search-txt{\n");
      out.write("        width: 500px;\n");
      out.write("        padding: 0 6px;\n");
      out.write("    }\n");
      out.write("\n");
      out.write("    .formsearch:hover > .search-btn{\n");
      out.write("        background: #46dd2c;\n");
      out.write("        \n");
      out.write("    }\n");
      out.write("\n");
      out.write("    .search-btn{\n");
      out.write("        background-color: #46dd2c;\n");
      out.write("        color: none;\n");
      out.write("        float: center;\n");
      out.write("        width: 0;\n");
      out.write("        height: 20px;\n");
      out.write("        border-radius: 90%;\n");
      out.write("        visibility: hidden;\n");
      out.write("        display: center;\n");
      out.write("        align-items: center;\n");
      out.write("    }\n");
      out.write("\n");
      out.write("    .search-txt{\n");
      out.write("        border: none;\n");
      out.write("        background: none;\n");
      out.write("        outline: none;\n");
      out.write("        float: right;\n");
      out.write("        padding:0;\n");
      out.write("        color: gray;\n");
      out.write("        font-size: 30px;\n");
      out.write("        transition: 0.7s;\n");
      out.write("        list-style: 40px;\n");
      out.write("        width: 0px;\n");
      out.write("    }\n");
      out.write("   \n");
      out.write("   \n");
      out.write("   \n");
      out.write("  .products-container{\n");
      out.write("     background-color: inherit;\n");
      out.write("     padding: 1.5em;\n");
      out.write("     margin: 0px 10px 35px 10px;\n");
      out.write("     width: 300px;\n");
      out.write("     height: 450px;\n");
      out.write("     vertical-align: bottom;\n");
      out.write("     display: inline-block;\n");
      out.write("   }\n");
      out.write("   /*\n");
      out.write("  .searchcontainer{\n");
      out.write("      padding-bottom: 15%;\n");
      out.write("  }\n");
      out.write(" */\n");
      out.write("    .search-box{\n");
      out.write("        position: relative;\n");
      out.write("        top: 50%;\n");
      out.write("        left: 50%;\n");
      out.write("        transform: translate(-50%, -50%);\n");
      out.write("        background-color: #46dd2c;\n");
      out.write("        height: 40%;\n");
      out.write("        width: 40%;\n");
      out.write("        border-radius: 30px;\n");
      out.write("        padding:10px;\n");
      out.write("    }\n");
      out.write("    \n");
      out.write("    .search-btn{\n");
      out.write("        background-color: #46dd2c;\n");
      out.write("        color: none;\n");
      out.write("        width: 0;\n");
      out.write("        height: 20px;\n");
      out.write("        border-radius: 90%;\n");
      out.write("        visibility: hidden;\n");
      out.write("        display: center;\n");
      out.write("        align-items: center;\n");
      out.write("    }\n");
      out.write("\n");
      out.write("    .search-txt{\n");
      out.write("        border: none;\n");
      out.write("        background: none;\n");
      out.write("        outline: none;\n");
      out.write("        color: gray;\n");
      out.write("        font-size: 30px;\n");
      out.write("        list-style: 40px;\n");
      out.write("\n");
      out.write("    }\n");
      out.write("\n");
      out.write("  h2{\n");
      out.write("   font-size: 40px;\n");
      out.write("    color: #46dd2c;\n");
      out.write("    font-family: fantasy;\n");
      out.write("   }\n");
      out.write(" \n");
      out.write(" a:hover{\n");
      out.write("    color: #46dd2c;\n");
      out.write("  } \n");
      out.write(" \n");
      out.write("  h2{\n");
      out.write("   font-size: 50px;\n");
      out.write("    color: #46dd2c;\n");
      out.write("    font-family: fantasy;\n");
      out.write("\n");
      out.write("  }\n");
      out.write(" \n");
      out.write("  p{\n");
      out.write("     font-size:20px;\n");
      out.write("   color: black;\n");
      out.write("      text-align: center;\n");
      out.write("      margin-top: 30px;\n");
      out.write("  }\n");
      out.write("  \n");
      out.write("   .text-p{\n");
      out.write("    font-size: 25px;\n");
      out.write("    color: black;\n");
      out.write("    text-align: center;\n");
      out.write("    margin-top: 30px;\n");
      out.write("    background-color: #F5F5F5;\n");
      out.write("    border-radius: 10px;\n");
      out.write("   }\n");
      out.write("   \n");
      out.write("   	nav ul {\n");
      out.write("		display: flex;\n");
      out.write("	}\n");
      out.write("\n");
      out.write("</style>\n");
      out.write(" </head>\n");
      out.write(" <body>\n");
      out.write("   ");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write(" <head>\n");
      out.write("  <meta charset=\"UTF-8\">\n");
      out.write("  <title>Arbor Vitae</title>\n");
      out.write("  <link rel=\"stylesheet\" type=\"text/css\" href=\"/ArborVitae/style/homepage.css\">\n");
      out.write("  <style>\n");
      out.write("    .cart-button{\n");
      out.write("      border: none;\n");
      out.write("      background-color: white;\n");
      out.write("      padding: 0px !important;\n");
      out.write("    }\n");
      out.write("      \n");
      out.write("    .profile-button{\n");
      out.write("      border: none;\n");
      out.write("      background-color: white;\n");
      out.write("    }\n");
      out.write("    \n");
      out.write("   .dropbtn {\n");
      out.write("    background-color: none !important;\n");
      out.write("    color: white;\n");
      out.write("    padding: 8px;\n");
      out.write("    font-size: 10px;\n");
      out.write("    border: none;\n");
      out.write("    float: right;\n");
      out.write("    margin: -5px 0px 3px 0px;\n");
      out.write("   }\n");
      out.write("   \n");
      out.write("   .dropdown {\n");
      out.write("     position: relative;\n");
      out.write("     display: inline-block;\n");
      out.write("   }\n");
      out.write("   \n");
      out.write("   .dropdown-content {\n");
      out.write("     display: none;\n");
      out.write("     position: absolute;\n");
      out.write("     background-color: white;\n");
      out.write("     min-width: 160px;\n");
      out.write("     box-shadow: 0px 8px 16px 0px rgba(0,0,0,0.2);\n");
      out.write("     z-index: 1;\n");
      out.write("   }\n");
      out.write("   \n");
      out.write("   .dropdown-content a {\n");
      out.write("     color: gray;\n");
      out.write("     padding: 3.5px;\n");
      out.write("     text-decoration: none;\n");
      out.write("     display: block;\n");
      out.write("   }\n");
      out.write("   \n");
      out.write("   .dropdown-content a:hover {background-color: #ddd; border-radius: 10px}\n");
      out.write("   \n");
      out.write("   .dropdown:hover .dropdown-content {display: block; border-radius: 10px}\n");
      out.write("   \n");
      out.write("   .dropdown:hover .dropbtn {background-color: #46dd2c; border-radius: 10px}\n");
      out.write("   \n");
      out.write("  </style>\n");
      out.write(" </head>\n");
      out.write(" \n");
      out.write(" <body>\n");
      out.write("  <header>\n");
      out.write("   <div class=\"logo\">\n");
      out.write("    <div class=\"navbar-item img-navbar-item\">\n");
      out.write("     <img src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("/img/homepage_images/logo.png\" alt=\"Arbor Vitae's logo\" />\n");
      out.write("    </div>\n");
      out.write("    <div class=\"navbar-item\">\n");
      out.write("     <h1 class=\"site-title\"> Arbor Vitae</h1>\n");
      out.write("    </div>\n");
      out.write("   </div>\n");
      out.write("   \n");
      out.write("   <input type=\"checkbox\" id=\"nav-toggle\" class=\"nav-toggle\">\n");
      out.write("   \n");
      out.write("   <nav>\n");
      out.write("   <div>\n");
      out.write("    <ul>\n");
      out.write("    <li><a href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("/view/homepage.jsp\" class=\"link-elements\">Home</a></li>\n");
      out.write("    <li><a href=\"/ArborVitae/catalogoServlet?ordinamento=");
      out.print(1);
      out.write("\" class=\"link-elements\">Catalogo</a></li>\n");
      out.write("    <li><a href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("/view/homepage.jsp#project\" class=\"link-elements\">Progetto</a></li>\n");
      out.write("    <li><a href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("/view/homepage.jsp#aboutus\" class=\"link-elements\">Team</a></li>\n");
      out.write("    <li><a href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("/view/homepage.jsp#footer\" class=\"link-elements\">Contatti</a></li>\n");
      out.write("   \n");
      out.write("    \n");
      out.write("    ");
 if(request.getSession(false)==null || session.getAttribute("logged")==null || session.getAttribute("logged").equals("false")){
      out.write("\n");
      out.write("        <li><a href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("/view/login.jsp\"><button type=\"button\" class=\"login-signup-buttons\">Login</button></a></li>\n");
      out.write("        <li><a href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("/view/signup.jsp\"><button type=\"button\" class=\"login-signup-buttons\">Sign Up</button></a></li>\n");
      out.write("       ");
}else{
      out.write("\n");
      out.write("        <li id=\"prev-count\"><a href=\"/ArborVitae/view/cart.jsp\"><button type=\"button\" class=\"cart-button\"><img src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("/img/homepage_images/cart.png\" width=\"45px\" height= \"45px\"></button></a></li>\n");
      out.write("        ");
 ShoppingCartDao scd=new ShoppingCartDao();
         ShoppingCart sc= scd.doRetrieveByKey((String)session.getAttribute("email"));
         if(sc!=null){
          ArrayList<Tree> list= scd.doRetrieveTrees(sc.getcodeCart());
          if(list!=null){ 
           int x=list.size();
           if(x>0){
      out.write("\n");
      out.write("            <li><p class=\"cart-elements-count\" id=\"count\">");
      out.print(x);
      out.write("</p></li>\n");
      out.write("           ");
}
      out.write("\n");
      out.write("          ");
}
      out.write("\n");
      out.write("       ");
}
      out.write("\n");
      out.write("     <li><div class=\"dropdown\">\n");
      out.write("          \n");
      out.write("           <button type=\"button\" class=\"profile-button dropbtn\">\n");
      out.write("            <img src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("/img/homepage_images/profile.png\" width=\"35px\" height=\"35px\">\n");
      out.write("            <div class=\"dropdown-content\">\n");
      out.write("            <a href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("/view/ordini.jsp\">I miei Ordini</a>\n");
      out.write("            <a href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("/logout\" >Log out</a>\n");
      out.write("        </div>\n");
      out.write("           </button>\n");
      out.write("      \n");
      out.write("         </div></li>\n");
      out.write("   ");
}
      out.write("\n");
      out.write("    </ul>\n");
      out.write("    \n");
      out.write("   </div>\n");
      out.write("   </nav>\n");
      out.write("   \n");
      out.write("   <label for=\"nav-toggle\" class=\"nav-toggle-label\">\n");
      out.write("    <span></span>\n");
      out.write("   </label>\n");
      out.write("\n");
      out.write("  </header>\n");
      out.write(" </body>\n");
      out.write("</html>");
      out.write("\n");
      out.write("   \n");
      out.write("   <div class=\"navbar-space\">\n");
      out.write("    <h2 align=\"center\"><br>Benvenuto\n");
      out.write("    ");
 if(request.getSession(false)==null || session.getAttribute("logged")==null || session.getAttribute("logged").equals("false")){
      out.write("\n");
      out.write("    ");
}else{ 
      out.write("\n");
      out.write("    	");
      out.print(session.getAttribute("isName") );
      out.write("\n");
      out.write("    ");
} 
      out.write("\n");
      out.write("    ,<br> scegli il tuo albero da piantare<br></h2>\n");
      out.write("    <p align=\"center\">\n");
      out.write("       Piantare un albero è davvero un gesto semplice, ma prima di effettuare la tua scelta ti consigliamo <a href=\"http://www.conalpa.it/perche-piantare-alberi-ecco-un-decalogo-dei-benefici/\" target=\"_blank\"> questo articolo</a> in cui vengono dati ben 10 motivi per i quali piantare un albero è vantaggioso per noi ed il nostro pianeta.\n");
      out.write("       </p> \n");
      out.write("   </div>\n");
      out.write("   \n");
      out.write(" \n");
      out.write("   \n");
      out.write("   <div class=\"searchcontainer\" style='display:inline; position:relative'>\n");
      out.write("        <div class=\"search-box\">\n");
      out.write("            <form action=\"/ArborVitae/catalogoServlet\" class=\"formsearch\"> &nbsp&nbsp\n");
      out.write("            <input  class=\"search-txt\" type=\"text\" name=\"ricerca\" placeholder=\"Ricerca albero...\">\n");
      out.write("            <img src=\"/ArborVitae/img/homepage_images/magnifier.png\" width=\"35\" height= \"35\">\n");
      out.write("            <button type=\"submit\"  class=\"search-btn\">            \n");
      out.write("            </button>\n");
      out.write("        </form>\n");
      out.write("        </div>\n");
      out.write("    </div>\n");
      out.write("    \n");
      out.write("    <div class=\"dropdown\" style='display:inline; position:relative; right:18%; bottom: 1.8em'>\n");
      out.write("		          \n");
      out.write("           <button type=\"button\" class=\"profile-button dropbtn1\">Ordina\n");
      out.write("            <div class=\"dropdown-content\">\n");
      out.write("            <a href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("/catalogoServlet?ordinamento=1\">Alfabetico</a>\n");
      out.write("            <a href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("/catalogoServlet?ordinamento=2\" >Co2</a>\n");
      out.write("            <a href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("/catalogoServlet?ordinamento=3\" >Prezzo</a>\n");
      out.write("        </div>\n");
      out.write("           </button>\n");
      out.write("      \n");
      out.write("         </div>\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("	\n");
      out.write("		\n");
      out.write("	\n");
      out.write("   \n");
      out.write("   <div class='inclusive-container'>\n");
      out.write("     ");
if(session.getAttribute("tree")!=null){
      out.write("\n");
      out.write("      \n");
      out.write("      ");
      out.write("\n");
      out.write("      ");
ArrayList<Tree>listTree=(ArrayList<Tree>)session.getAttribute("tree");
      out.write("\n");
      out.write("       ");
 for(i=0;i<listTree.size();i++){
      out.write("\n");
      out.write("       ");
 Tree currentTree=listTree.get(i);
      out.write("\n");
      out.write("       <div class=\"products-container\">\n");
      out.write("        <div class=\"row product-list\">\n");
      out.write("            <div class=\"col-md-4\">\n");
      out.write("              <section class=\"panel\">\n");
      out.write("                  <div class=\"pro-img-box\">\n");
      out.write("                      <img src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("/img/trees_img/");
      out.print(currentTree.getName().toLowerCase()+"1.jpg" );
      out.write("\" alt=\"\" />\n");
      out.write("                         <!-- <a href=\"#\" class=\"adtocart\">\n");
      out.write("                            <i class=\"fa fa-shopping-cart\"></i>\n");
      out.write("                         </a>-->\n");
      out.write("                  </div>\n");
      out.write("   \n");
      out.write("                  <div class=\"panel-body text-center\">\n");
      out.write("                     <h4>\n");
      out.write("                        <a href=\"/ArborVitae/catalogItemServlet?treeName=");
      out.print(currentTree.getName() );
      out.write("\" class=\"pro-title\"> \n");
      out.write("                          ");
      out.print(currentTree.getName());
      out.write("</a>\n");
      out.write("                     </h4>\n");
      out.write("                     <p class=\"price\">\n");
      out.write("                      €");
      out.print(currentTree.getPrice());
      out.write("\n");
      out.write("                     </p>\n");
      out.write("                  </div>\n");
      out.write("           </section>\n");
      out.write("          </div>\n");
      out.write("\n");
      out.write("      <!-- fine prodotto i-esimo -->\n");
      out.write("        </div>  \n");
      out.write("     </div>\n");
      out.write("      ");
 }
      out.write("\n");
      out.write("     ");
} 
      out.write("\n");
      out.write(" </div>\n");
      out.write(" \n");
      out.write(" \n");
      out.write("   <section>\n");
      out.write("    <div id=\"footer\" >\n");
      out.write("     ");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write(" <head>\n");
      out.write("  <meta charset=\"UTF-8\">\n");
      out.write("  <title>Footer</title>\n");
      out.write("  <link rel=\"stylesheet\" type=\"text/css\" href=\"../style/homepage.css\">\n");
      out.write("  <style>\n");
      out.write("   .container9{\n");
      out.write("     background-color: #F5F5F5;\n");
      out.write("     text-align: center;\n");
      out.write("   }\n");
      out.write("   \n");
      out.write("   h6{\n");
      out.write("     font-family: 'Work Sans', sans-serif;\n");
      out.write("     font-weight: 400;\n");
      out.write("   }\n");
      out.write("   \n");
      out.write("      \n");
      out.write("   .footer-text{\n");
      out.write("     border: 3px solid #46dd2c;\n");
      out.write("     background-color: #46dd2c;\n");
      out.write("     text-align: center;\n");
      out.write("   }\n");
      out.write("   \n");
      out.write("   .info-container {\n");
      out.write("     display: grid;\n");
      out.write("        grid-template-columns: repeat(3, 1fr);\n");
      out.write("     grid-template-rows: 1fr;\n");
      out.write("     grid-column-gap: 50px;\n");
      out.write("     grid-row-gap: 0px;\n");
      out.write("     padding: 1em;\n");
      out.write("   }\n");
      out.write("    \n");
      out.write("   .item1 { grid-area: 1 / 1 / 2 / 2; background: white; border-radius: 20px; outline: 2px solid #46dd2c; font-size: 25px}\n");
      out.write("   .item2 { grid-area: 1 / 2 / 2 / 3; background:  white; border-radius: 20px; outline: 2px solid #46dd2c; font-size: 25px}\n");
      out.write("   .item3 { grid-area: 1 / 3 / 2 / 4; background: white; border-radius: 20px; outline: 2px solid #46dd2c; font-size: 25px}\n");
      out.write("    \n");
      out.write("   .item1,.item2,.item3 {padding: 0rem;}\n");
      out.write("   \n");
      out.write("   ul {\n");
      out.write("     display: block;\n");
      out.write("     list-style-type: none;\n");
      out.write("     margin: 0;\n");
      out.write("     padding: 0;\n");
      out.write("   }\n");
      out.write("   \n");
      out.write("   .social-container {\n");
      out.write("     display: grid;\n");
      out.write("     grid-template-columns: repeat(4, 1fr);\n");
      out.write("     grid-template-rows: 0fr;\n");
      out.write("     grid-column-gap: 5px;\n");
      out.write("     grid-row-gap: 0px;\n");
      out.write("     padding: 1em;\n");
      out.write("   }\n");
      out.write("   \n");
      out.write("   .footer-div-copyright {\n");
      out.write("     border: 15px solid #46dd2c;\n");
      out.write("     background-color: #46dd2c;\n");
      out.write("     text-align: center;\n");
      out.write("   }\n");
      out.write("   \n");
      out.write("   h8{\n");
      out.write("    font-size: 25px;\n");
      out.write("    color: white;\n");
      out.write("   }\n");
      out.write("   \n");
      out.write("   h9{\n");
      out.write("    font-size: 25px;\n");
      out.write("    color: #46dd2c;\n");
      out.write("   }\n");
      out.write("   \n");
      out.write("  </style>\n");
      out.write(" </head>\n");
      out.write(" \n");
      out.write(" <body>\n");
      out.write("  <footer>\n");
      out.write("     <!-- Sezione Testo fine pagina //metti uno spazio sotto-->\n");
      out.write("       <div  class=\"footer-text\">\n");
      out.write("         <p>\n");
      out.write("    <h8>Per qualsiasi informazione e soprattutto se vorresti diventare membro del team non esitare a contattarci!<h8>\n");
      out.write("         </p>\n");
      out.write("       </div>\n");
      out.write("     <!-- Grid container -->\n");
      out.write("       <div class=\"container9\">\n");
      out.write("    <br>   \n");
      out.write("       <!-- Contatti -->\n");
      out.write("        <div class=\"info-container\">\n");
      out.write("      <div class=\"item1\">\n");
      out.write("       <h9><br>Indirizzo</h9>\n");
      out.write("      <ul>\n");
      out.write("       <li>\n");
      out.write("        <h6> Universit&agrave; degli Studi di Salerno <br> Via Giovanni Paolo II, 132 </br>84084 Fisciano (SA)</h6>\n");
      out.write("       </li>\n");
      out.write("      </div>\n");
      out.write("      <div class=\"item2\">\n");
      out.write("       <h9><br>E-mail</h9>\n");
      out.write("      <ul>\n");
      out.write("       <li>\n");
      out.write("        <h6>c.sorrentino82@studenti.unisa.it</h6>\n");
      out.write("       </li>\n");
      out.write("      <li>\n");
      out.write("       <h6>m.colella20@studenti.unisa.it</h6>\n");
      out.write("      </li>\n");
      out.write("      <li>\n");
      out.write("       <h6>f.monzillo2@studenti.unisa.it</h6>\n");
      out.write("      </li>\n");
      out.write("      </ul>\n");
      out.write("      </div>\n");
      out.write("      <div class=\"item3\">\n");
      out.write("       <h9><br>Telefono</h9>\n");
      out.write("      <ul>\n");
      out.write("       <li>\n");
      out.write("        <h6>+39 334 709 0726</h6>\n");
      out.write("       </li>\n");
      out.write("       <li>\n");
      out.write("        <h6>+39 392 399 0242</h6>\n");
      out.write("       </li>\n");
      out.write("       <li>\n");
      out.write("        <h6>+39 342 779 7976</h6>\n");
      out.write("       </li>\n");
      out.write("      </ul>\n");
      out.write("      </div>\n");
      out.write("     </div>\n");
      out.write("  \n");
      out.write("      <!-- Sezione Social media -->\n");
      out.write("          <div class=\"social-container\">\n");
      out.write("           <!-- Facebook -->\n");
      out.write("             <a href=\"#!\"><img src=\"../img/homepage_images/facebooklogo.png\" height=\"30\"></a>\n");
      out.write("\n");
      out.write("           <!-- Twitter -->\n");
      out.write("             <a href=\"#!\"><img src=\"../img/homepage_images/twitter.png\" height=\"30\"></a>\n");
      out.write("\n");
      out.write("           <!-- Google -->\n");
      out.write("             <a href=\"#!\" role=\"button\"><img src=\"../img/homepage_images/google.png\" height=\"30\"></a>\n");
      out.write("\n");
      out.write("           <!-- Instagram -->\n");
      out.write("             <a href=\"#!\"><img src=\"../img/homepage_images/instagram-logo-tumb.png\" height=\"30\"></a>\n");
      out.write("           </div>\n");
      out.write("     </div>\n");
      out.write("  \n");
      out.write("   <div class=\"footer-div-copyright\">\n");
      out.write("    @Arbor_Vitae_2022\n");
      out.write("   </div>\n");
      out.write("   \n");
      out.write("  </footer>\n");
      out.write("\n");
      out.write(" </body>\n");
      out.write("</html>");
      out.write("\n");
      out.write("    </div>\n");
      out.write("   </section>\n");
      out.write(" </body>\n");
      out.write("</html>\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
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
