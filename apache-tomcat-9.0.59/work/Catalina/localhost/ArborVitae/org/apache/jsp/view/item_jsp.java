/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/9.0.59
 * Generated at: 2022-07-07 09:22:59 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.view;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import model.bean.ShoppingCart;
import model.dao.ShoppingCartDao;
import java.util.ArrayList;
import model.bean.Tree;
import model.bean.ShoppingCart;
import model.dao.ShoppingCartDao;
import java.util.ArrayList;
import model.bean.Tree;

public final class item_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.HashMap<java.lang.String,java.lang.Long>(1);
    _jspx_dependants.put("/html/homeNavbar.jsp", Long.valueOf(1657099948000L));
  }

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.HashSet<>();
    _jspx_imports_packages.add("javax.servlet");
    _jspx_imports_packages.add("javax.servlet.http");
    _jspx_imports_packages.add("javax.servlet.jsp");
    _jspx_imports_classes = new java.util.HashSet<>();
    _jspx_imports_classes.add("model.bean.Tree");
    _jspx_imports_classes.add("model.bean.ShoppingCart");
    _jspx_imports_classes.add("model.dao.ShoppingCartDao");
    _jspx_imports_classes.add("java.util.ArrayList");
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
      response.setContentType("text/html;charset=ISO-8859-1");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("<head>\n");
      out.write("<meta charset=\"ISO-8859-1\">\n");
      out.write("<link rel=\"stylesheet\" type=\"text/css\" href=\"/ArborVitae/style/item.css\"/>\n");
      out.write("<link rel=\"icon\" href=\"/ArborVitae/img/homepage_images/logo.ico\" type=\"image/x-icon\">\n");
Tree t= (Tree) request.getAttribute("treeObject") ;
      out.write("\n");
      out.write("<title>");
      out.print(t.getName());
      out.write("</title>\n");
      out.write("</head>\n");
      out.write("<body>\n");
      out.write("\n");
      out.write(" ");
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
      out.write(" \n");
      out.write("    <div class=\"container\">\n");
      out.write("  <div class=\"card\">\n");
      out.write("   <div class=\"row\">\n");
      out.write("    <aside class=\"col-sm-5 border-right\">\n");
      out.write("     <article class=\"gallery-wrap\"> \n");
      out.write("      <div class=\"img-big-wrap\">\n");
      out.write("         <img src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("/img/trees_img/");
      out.print(t.getName().toLowerCase()+"1.jpg" );
      out.write("\" alt=\"\" id=\"main_img\"/>\n");
      out.write("      </div> <!-- slider-product.// -->\n");
      out.write("        <div class=\"img-small-wrap\">\n");
      out.write("         <div class=\"item-gallery\"> <img src=\"/ArborVitae/img/trees_img//");
      out.print(t.getName().toLowerCase()+"1.jpg");
      out.write("\" onclick=\"document.getElementById('main_img').setAttribute('src','/ArborVitae/img/trees_img/");
      out.print(t.getName().toLowerCase()+"1.jpg");
      out.write("')\"> </div>\n");
      out.write("         <div class=\"item-gallery\"> <img src=\"/ArborVitae/img/trees_img/");
      out.print(t.getName().toLowerCase()+"2.jpg");
      out.write("\" onclick=\"document.getElementById('main_img').setAttribute('src','/ArborVitae/img/trees_img/");
      out.print(t.getName().toLowerCase()+"2.jpg");
      out.write("')\"> </div>\n");
      out.write("         </div>  \n");
      out.write("       \n");
      out.write("     </article> \n");
      out.write("    </aside>\n");
      out.write("    <aside class=\"col-sm-7\">\n");
      out.write("     <article class=\"card-body p-5\">\n");
      out.write("      <h3 class=\"title mb-3\">");
      out.print(t.getName() );
      out.write("</h3>\n");
      out.write("       <p class=\"price-detail-wrap\"> \n");
      out.write("        <span class=\"price h3 text-warning\"> \n");
      out.write("         <span class=\"currency\">&euro;</span>\n");
      out.write("         <span class=\"num\">");
      out.print(t.getPrice() );
      out.write("</span>\n");
      out.write("        </span> \n");
      out.write("        <span></span> \n");
      out.write("       </p>\n");
      out.write("     \n");
      out.write("      <dl class=\"param param-feature\">\n");
      out.write("         <dt>Specie</dt>\n");
      out.write("         <dd>");
      out.print(t.getSpecies() );
      out.write("</dd>\n");
      out.write("      </dl>  <!-- item-property-hor .// -->\n");
      out.write("      <dl class=\"param param-feature\">\n");
      out.write("         <dt>Paese</dt>\n");
      out.write("         <dd>");
      out.print(t.getCountry() );
      out.write("</dd>\n");
      out.write("      </dl>  <!-- item-property-hor .// -->\n");
      out.write("\n");
      out.write("      <div class=\"intern-row\"> \n");
      out.write("       <div class=\"col-sm-5\">\n");
      out.write("        <dl class=\"param param-inline\">\n");
      out.write("           <dt>Co2: </dt>\n");
      out.write("            <dd>\n");
      out.write("              ");
      out.print(t.getCo2() );
      out.write("\n");
      out.write("            </dd>\n");
      out.write("           </dl>  <!-- item-property .// -->\n");
      out.write("           <hr>\n");
      out.write("       <dl class=\"item-property\">\n");
      out.write("         <dt class=\"mttlsam\">Descrizione</dt>\n");
      out.write("          <dd><p class=\"mttfam\">");
      out.print(t.getDescription() );
      out.write("\n");
      out.write("         </p>\n");
      out.write("        </dd>\n");
      out.write("      </dl>\n");
      out.write("       </div>\n");
      out.write("      <!-- <div class=\"col-sm-7\">\n");
      out.write("       <dl class=\"param param-inline\">\n");
      out.write("          <dt>Size: </dt>\n");
      out.write("           <dd>\n");
      out.write("            <label class=\"form-check form-check-inline\">\n");
      out.write("             <input class=\"form-check-input\" type=\"radio\" name=\"inlineRadioOptions\" id=\"inlineRadio2\" value=\"option2\">\n");
      out.write("              <span class=\"form-check-label\">SM</span>\n");
      out.write("          </label>\n");
      out.write("           <label class=\"form-check form-check-inline\">\n");
      out.write("              <input class=\"form-check-input\" type=\"radio\" name=\"inlineRadioOptions\" id=\"inlineRadio2\" value=\"option2\">\n");
      out.write("               <span class=\"form-check-label\">MD</span>\n");
      out.write("          </label>\n");
      out.write("       \n");
      out.write("          <label class=\"form-check form-check-inline\">\n");
      out.write("             <input class=\"form-check-input\" type=\"radio\" name=\"inlineRadioOptions\" id=\"inlineRadio2\" value=\"option2\">\n");
      out.write("             <span class=\"form-check-label\">XXL</span>\n");
      out.write("          </label>\n");
      out.write("           </dd>\n");
      out.write("       </dl>  <!-- item-property .// -->\n");
      out.write("     <!--  </div> -->\n");
      out.write("     </div> <!-- row.// -->\n");
      out.write("     <hr>\n");
      out.write("      <a class=\"btn btn-lg btn-primary text-uppercase\" onclick=\"buyElement()\"> Buy now </a> \n");
      out.write("      <a class=\"btn btn-lg btn-outline-primary text-uppercase\" onclick=\"addElement()\"> <i class=\"fas fa-shopping-cart\"></i> Add to cart </a>\n");
      out.write("    </article> <!-- card-body.// -->\n");
      out.write("   </aside> <!-- col.// -->\n");
      out.write("  </div> <!-- row.// -->\n");
      out.write(" </div> <!-- card.// -->\n");
      out.write("  <script>\n");
      out.write("  \n");
      out.write("   function buyElement(){\n");
      out.write("	   let ernesto = new XMLHttpRequest();\n");
      out.write("	   ernesto.onreadystatechange= function(){\n");
      out.write("		   console.log(this.readyState+\"\\n\"+this.status);\n");
      out.write("		   if(this.readyState==4 && this.status==200){\n");
      out.write("			   window.location.replace(\"http://localhost:8080/ArborVitae/view/attestati.jsp?treeName=\"+encodeURIComponent('");
      out.print(t.getName());
      out.write("'));\n");
      out.write("		       return;\n");
      out.write("		   }\n");
      out.write("		   if(this.readyState==4 && this.status==201) {\n");
      out.write("			   window.location.replace(\"http://localhost:8080/ArborVitae/redirectionServlet?urlName=\"+window.location.pathname+\"\"+window.location.search);\n");
      out.write("		       return;\n");
      out.write("		   }\n");
      out.write("	   }\n");
      out.write("	   ernesto.open(\"GET\",\"/ArborVitae/insertOrderServlet?treeName=\"+encodeURIComponent('");
      out.print(t.getName());
      out.write("'),true);\n");
      out.write("	   ernesto.send();\n");
      out.write("   }  \n");
      out.write("  \n");
      out.write("   function addElement(){\n");
      out.write("    let req = new XMLHttpRequest();\n");
      out.write("    req.onreadystatechange= function(){\n");
      out.write("     console.log(req.readyState+\"\\n\"+req.status);\n");
      out.write("     let x = document.querySelector(\"#count\");\n");
      out.write("     if(req.readyState==4 && req.status==200){\n");
      out.write("      	if(x==null){\n");
      out.write("       		let list=document.createElement(\"li\");\n");
      out.write("       		let para=document.createElement(\"p\");\n");
      out.write("       		let text=document.createTextNode(\"1\");\n");
      out.write("       		para.setAttribute(\"id\",\"count\");\n");
      out.write("       		para.classList.add(\"cart-elements-count\");\n");
      out.write("      		para.insertBefore(text,para.firstChild);\n");
      out.write("      		list.insertBefore(para,list.firstChild);\n");
      out.write("      		console.log(this.responseText);\n");
      out.write("      		let insertion=document.getElementById(\"prev-count\");\n");
      out.write("      	 	insertion.parentNode.insertBefore(list,insertion.nextSibling);\n");
      out.write("      	 	return;\n");
      out.write("      	}else{\n");
      out.write("      		 x.innerHTML=\"\"+this.responseText;\n");
      out.write("      	     console.log(\"\"+this.responseText);\n");
      out.write("      	}\n");
      out.write("      }else if(req.readyState==4 && req.status==201){\n");
      out.write("    	  window.location.replace(\"http://localhost:8080/ArborVitae/redirectionServlet?urlName=\"+window.location.pathname+\"\"+window.location.search);\n");
      out.write("     	  return;\n");
      out.write("      }\n");
      out.write("    }\n");
      out.write("    req.open(\"GET\",\"/ArborVitae/shoppingCartServlet?treeName=\"+encodeURIComponent('");
      out.print(t.getName());
      out.write("'),true);\n");
      out.write("    req.send();\n");
      out.write("   }\n");
      out.write("  </script>\n");
      out.write(" \n");
      out.write("\n");
      out.write("</div> <!--container.//-->\n");
      out.write("<div class=\"clearb\">&nbsp</div>\n");
      out.write("\n");
      out.write("</body>\n");
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
}
