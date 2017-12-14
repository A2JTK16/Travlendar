<%-- 
    Document   : index
    Created on : Nov 18, 2017, 11:43:07 PM
    Author     : mufidjamaluddin
--%>


<% 
    if(session.getAttribute("username") != null) 
        request.getRequestDispatcher("travlendar/add_event.jsp").forward(request, response);
    else
        request.getRequestDispatcher("travlendar/index.jsp").forward(request, response);
%>
