<%-- 
    Document   : index
    Created on : Nov 18, 2017, 11:43:07 PM
    Author     : mufidjamaluddin
--%>


<% 
    if(session.getAttribute("username") != null) 
        response.sendRedirect("travlendar/add_event.jsp");
    else
        response.sendRedirect("travlendar");
%>
