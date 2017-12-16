<%-- 
    Document   : break
    Created on : Dec 14, 2017, 11:22:41 AM
    Author     : mufidjamaluddin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    request.getSession().invalidate();
    response.sendRedirect("");
%>
