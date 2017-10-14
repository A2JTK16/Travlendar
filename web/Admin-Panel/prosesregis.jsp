<%-- 
    Document   : prosesregis
    Created on : Sep 3, 2017, 8:45:34 PM
    Author     : Diana
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%@ page import ="java.sql.*" %>
        <%
            String user = request.getParameter("username");    
            String pwd = request.getParameter("password");
            String email = request.getParameter("email");
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/belajar",
                    "root", "");
            Statement st = con.createStatement();
            //ResultSet rs;
            int i = st.executeUpdate("insert into admin( email, username, password, regdate) values ('" + email + "','" + user + "','" + pwd + "', CURDATE())");
            if (i > 0) {
                //session.setAttribute("userid", user);
                response.sendRedirect("welcome.jsp");
               // out.print("Registration Successfull!"+"<a href='index.jsp'>Go to Login</a>");
            } else {
                response.sendRedirect("index.jsp");
            }
        %>
    </body>
</html>
