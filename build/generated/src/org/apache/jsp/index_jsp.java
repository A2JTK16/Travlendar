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
      out.write("             <div class=\"logo\">\n");
      out.write("                <img src=\"logo/logo.png\">\n");
      out.write("             </div> <!-logo-->\n");
      out.write("             \n");
      out.write("             <input class=\"cari\" type=\"text\" placeholder=\"Find Event\">\n");
      out.write("          \n");
      out.write("\t</div> <!--header-->\n");
      out.write("       \n");
      out.write("\t<div class=\"content\">\n");
      out.write("\n");
      out.write("\t\t<div class=\"kotak\">\n");
      out.write("                    <div class=\"dayy\">\n");
      out.write("                        <p> Hi ! To Day Is : </p>\n");
      out.write("                        <p> Friday, 8 </p>\n");
      out.write("                        <p> September </p>\n");
      out.write("                        <p> 2017 </p>\n");
      out.write("                    </div> <!--day-->\n");
      out.write("                     \n");
      out.write("                    <div class=\"dayy\">\n");
      out.write("                     \n");
      out.write("                        <div class=\"month\">      \n");
      out.write("                          <ul>\n");
      out.write("                            <li class=\"prev\">&#10094;</li>\n");
      out.write("                            <li class=\"next\">&#10095;</li>\n");
      out.write("                            <li>\n");
      out.write("                              August<br>\n");
      out.write("                              <span style=\"font-size:18px\">2017</span>\n");
      out.write("                            </li>\n");
      out.write("                          </ul>\n");
      out.write("                        </div>\n");
      out.write("\n");
      out.write("                        <ul class=\"weekdays\">\n");
      out.write("                          <li>M</li>\n");
      out.write("                          <li>Tu</li>\n");
      out.write("                          <li>W</li>\n");
      out.write("                          <li>Th</li>\n");
      out.write("                          <li>F</li>\n");
      out.write("                          <li>Sa</li>\n");
      out.write("                          <li>Su</li>\n");
      out.write("                        </ul>\n");
      out.write("\n");
      out.write("                        <ul class=\"days\">  \n");
      out.write("                          <li>1</li>\n");
      out.write("                          <li>2</li>\n");
      out.write("                          <li>3</li>\n");
      out.write("                          <li>4</li>\n");
      out.write("                          <li>5</li>\n");
      out.write("                          <li>6</li>\n");
      out.write("                          <li>7</li>\n");
      out.write("                          <li>8</li>\n");
      out.write("                          <li>9</li>\n");
      out.write("                          <li><span class=\"active\">10</span></li>\n");
      out.write("                          <li>11</li>\n");
      out.write("                          <li>12</li>\n");
      out.write("                          <li>13</li>\n");
      out.write("                          <li>14</li>\n");
      out.write("                          <li>15</li>\n");
      out.write("                          <li>16</li>\n");
      out.write("                          <li>17</li>\n");
      out.write("                          <li>18</li>\n");
      out.write("                          <li>19</li>\n");
      out.write("                          <li>20</li>\n");
      out.write("                          <li>21</li>\n");
      out.write("                          <li>22</li>\n");
      out.write("                          <li>23</li>\n");
      out.write("                          <li>24</li>\n");
      out.write("                          <li>25</li>\n");
      out.write("                          <li>26</li>\n");
      out.write("                          <li>27</li>\n");
      out.write("                          <li>28</li>\n");
      out.write("                          <li>29</li>\n");
      out.write("                          <li>30</li>\n");
      out.write("                          <li>31</li>\n");
      out.write("                        </ul>\n");
      out.write("\n");
      out.write("                    </div>\n");
      out.write("                    \n");
      out.write("                    <div class=\"dayy\">\n");
      out.write("                        <p> GO TO A DATE </p>\n");
      out.write("                    </div>\n");
      out.write("\t\t</div>\n");
      out.write("            \n");
      out.write("            <div class=\"isi\">\n");
      out.write("                <main>\n");
      out.write("                    \n");
      out.write("                    <input id=\"tab1\" type=\"radio\" name=\"tabs\" checked>\n");
      out.write("                      <label for=\"tab1\">Calendar</label>\n");
      out.write("                    <input id=\"tab2\" type=\"radio\" name=\"tabs\">\n");
      out.write("                      <label for=\"tab2\">View List Event</label>\n");
      out.write("                    <input id=\"tab3\" type=\"radio\" name=\"tabs\">\n");
      out.write("                      <label for=\"tab3\">Add New Event</label>\n");
      out.write(" \n");
      out.write("\n");
      out.write("                    <section id=\"content1\">\n");
      out.write("                      <h3>Calendar</h3>\n");
      out.write("                      \n");
      out.write("                      <table border=\"1px\" width=\"600px\">\n");
      out.write("                          <tr>\n");
      out.write("                              <th> Time </th>\n");
      out.write("                              <th> Event Name </th>\n");
      out.write("                              <th> Location </th>\n");
      out.write("                              <th> Note </th>\n");
      out.write("                          </tr>\n");
      out.write("                          \n");
      out.write("                          <tr>\n");
      out.write("                              <td> 07:00 </td>\n");
      out.write("                              <td> Kuliah </td>\n");
      out.write("                              <td> POLBAN </td>\n");
      out.write("                              <td> Matematika Diskrit </td>\n");
      out.write("                          </tr>\n");
      out.write("                          \n");
      out.write("                          <tr>\n");
      out.write("                              <td height=\"300px\"> </td>\n");
      out.write("                              <td> </td>\n");
      out.write("                              <td> </td>\n");
      out.write("                              <td> </td>\n");
      out.write("                          </tr>\n");
      out.write("                          \n");
      out.write("                      </table>\n");
      out.write("\n");
      out.write("                    </section>\n");
      out.write("                    <section id=\"content2\">\n");
      out.write("                      <h3>View List Event</h3>\n");
      out.write("                        <table border=\"1px\" width=\"600px\">\n");
      out.write("                          <tr>\n");
      out.write("                              <th> Event Name </th>\n");
      out.write("                              <th> Date </th>\n");
      out.write("                              <th> Location </th>\n");
      out.write("                              <th> Note </th>\n");
      out.write("                          </tr>\n");
      out.write("                          \n");
      out.write("                          <tr>\n");
      out.write("                              <td> Lele's Brithday  </td>\n");
      out.write("                              <td> 20-Februari-2017 </td>\n");
      out.write("                              <td> Ciwaruga </td>\n");
      out.write("                              <td> Dont Forget to Bring Present ! </td>\n");
      out.write("                          </tr>\n");
      out.write("                          \n");
      out.write("                          <tr>\n");
      out.write("                              <td height=\"300px\"> </td>\n");
      out.write("                              <td> </td>\n");
      out.write("                              <td> </td>\n");
      out.write("                              <td> </td>\n");
      out.write("                          </tr>\n");
      out.write("                          \n");
      out.write("                      </table>\n");
      out.write("                    </section>\n");
      out.write("                    <section id=\"content3\">\n");
      out.write("                       <h3>Add New Event</h3>\n");
      out.write("                       \n");
      out.write("                    </section>\n");
      out.write("                      \n");
      out.write("            </div> <!--isi-->\n");
      out.write("           \n");
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
