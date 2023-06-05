package controller;

import java.io.IOException;
import java.sql.Connection;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.sql.DataSource;

import org.eclipse.jdt.internal.compiler.ast.IfStatement;

import model.*;
import model.dao.*;
import model.bean.*;

/**
 * Servlet Filter implementation class LoginFilter
 */
@WebFilter(urlPatterns= {"/view/cart.jsp","/view/ordini.jsp"})
public class LoginFilter extends HttpFilter implements Filter {
       
    /**
     * @see HttpFilter#HttpFilter()
     */
    public LoginFilter() {
        super();
    }

  /**
   * @see Filter#destroy()
   */
  public void destroy() {

  }

  /**
   * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
   */
  public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
    HttpServletRequest r=(HttpServletRequest) request;
    HttpSession s = r.getSession(false);
    HttpServletResponse resp=(HttpServletResponse) response;
    String uri =r.getRequestURI();
    if(r.getQueryString()!=null) {
      uri=uri+"?"+r.getQueryString();
    }
    if(s==null){
      s=r.getSession();
      s.setAttribute("previous",uri);
      resp.sendRedirect("/ArborVitae/view/login.jsp");
      return;
    }else {
      if(s.getAttribute("logged")==null) {
        s.setAttribute("previous", uri);
        resp.sendRedirect("/ArborVitae/view/login.jsp");
        return;
      }
      if(s.getAttribute("logged").equals("true")){
        chain.doFilter(request, response);
        return;
      }else {
        resp.sendRedirect("/ArborVitae/view/login.jsp");
        return;
      }
    }
    
    
  }

  /**
   * @see Filter#init(FilterConfig)
   */
  public void init(FilterConfig fConfig) throws ServletException {
    
  }

}