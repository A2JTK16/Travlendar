<%-- 
    Document   : login
    Created on : Sep 3, 2017, 8:41:38 PM
    Author     : Lenovo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/Assets2/css/login.css">
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/Assets2/css/responsive.css">
        <title>JSP Page</title>
    </head>
    <body>
        <%@ page import ="java.sql.*" %>
 
        <div class="notif-login">
            <%
                String userid = request.getParameter("username");    
                String pwd = request.getParameter("password");
                Class.forName("com.mysql.jdbc.Driver");
                Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/belajar",
                        "root", "");
                Statement st = con.createStatement();
                ResultSet rs;
                rs = st.executeQuery("select * from admin where username='" + userid + "' and password='" + pwd + "'");
                if (rs.next()) {
                    session.setAttribute("userid", userid);
                    out.println("welcome " + userid);
                    out.println("<a href='logout.jsp'>Log out</a>");
                    response.sendRedirect("Traveller");
                } else {
                    out.println("<span class='gagal'> Invalid password </span><a class='try-again' href='index.jsp'>try again</a>");
                }
            %>
        </div>
    </body>
</html>
