package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class index_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <link rel=\"stylesheet\" type=\"text/css\" href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${pageContext.request.contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/css/style.css\">\n");
      out.write("        <title>JSP Page</title>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <div class=\"wadah\">\n");
      out.write("\t<div class=\"header\">\n");
      out.write("            <div class=\"SignOrLog\">\n");
      out.write("                        <input type=\"submit\" class=\"sign\" value=\"Sign Up\">\n");
      out.write("                        <text> OR </text>\n");
      out.write("                        <input type=\"submit\" class=\"log\" value=\"Login\">\n");
      out.write("            </div>\n");
      out.write("\t</div> <!--header-->\n");
      out.write("\n");
      out.write("\t<div class=\"content\">\n");
      out.write("\n");
      out.write("\t\t<div class=\"kotak\">\n");
      out.write("\n");
      out.write("\t\t</div>\n");
      out.write("\t\t<div class=\"kotak\">\n");
      out.write("\n");
      out.write("\t\t</div>\n");
      out.write("\n");
      out.write("\n");
      out.write("\t\t<div class=\"kotak-login\">            \n");
      out.write("\t\t\t<div class=\"login\">\n");
      out.write("\t\t\t\t<form action=\"#\">\n");
      out.write("\t\t\t\t\t<input class=\"b\" type=\"text\" placeholder=\"Masukan Username.....\">\n");
      out.write("\t\t\t\t\t<input class=\"b\" type=\"password\" placeholder=\"Masukan Password.....\">\n");
      out.write("\t\t\t\t\t<input class=\"button\" type=\"submit\" value=\"Login\"> \n");
      out.write("\t\t\t\t</form>\n");
      out.write("\t\t\t</div>\n");
      out.write("\t\t</div> <!--kotak-->\n");
      out.write("\n");
      out.write("\t\t<div class=\"kotak\">\n");
      out.write("                    <div class=\"desk\">\n");
      out.write("\t\t\t<p>\n");
      out.write("\t\t\t\tTravel is the movement of people between relatively distant geographical locations, and can involve travel by foot, bicycle, automobile, train, boat, bus, airplane, or other means, with or without luggage, and can be one way or round trip\n");
      out.write("\t\t\t</p>\n");
      out.write("                    </div> <!--desk-->\n");
      out.write("\t\t</div> <!--kiri-->\n");
      out.write("\n");
      out.write("\t\t<div class=\"kotak\">\n");
      out.write("                    <div class=\"kalimat\">\n");
      out.write("\t\t\t<h2> Travlendar </h2>\n");
      out.write("                    </div>\n");
      out.write("\t\t</div> <!--tengah-->\n");
      out.write("\n");
      out.write("\t\t<div class=\"kotak\">\n");
      out.write("\t\t\t<p>\n");
      out.write("\t\t\tTravel is the movement of people between relatively distant geographical locations, and can involve travel by foot, bicycle, automobile, train, boat, bus, airplane, or other means, with or without luggage, and can be one way or round trip\n");
      out.write("\t\t\t</p>\n");
      out.write("\t\t</div> <!--kanan-->\n");
      out.write("\t</div>\n");
      out.write("\n");
      out.write("\t<div class=\"footer\">\n");
      out.write("            <div class=\"cpyright\"> Copyright &copy; Travlendar 2017 </div> \n");
      out.write("\t</div> <!--footer-->\n");
      out.write("</div>\n");
      out.write("    </body>\n");
      out.write("</html>\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
