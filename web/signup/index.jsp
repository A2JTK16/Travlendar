<%-- 
    Document   : index
    Created on : Nov 18, 2017, 11:43:07 PM
    Author     : mufidjamaluddin
--%>


<% 
    if(session.getAttribute("username") == null) 
        request.getRequestDispatcher("../travlendar/signup.jsp").forward(request, response);
    else
        response.sendRedirect("../");
%>
