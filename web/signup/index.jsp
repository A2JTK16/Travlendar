<%-- 
    Document   : index
    Created on : Nov 18, 2017, 11:43:07 PM
    Author     : mufidjamaluddin
--%>


<% 
    if(session.getAttribute("username") == null) 
    {
        %>
        <%@include file="../WEB-INF/page/signup.html" %>
        <%
    }
    else
        response.sendRedirect("../");
%>
