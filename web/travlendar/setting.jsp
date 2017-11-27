<%-- 
    Document   : setting
    Created on : Nov 27, 2017, 10:14:27 PM
    Author     : Alpin J
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" href="css/style.css">
    </head>
    <body>
        <%@include file="headerhome.jsp" %>
        <div class="main">
        <div class="sidebar">
            
        </div>
        
        <div class="setting">
            <div class="text-ev">Date Format</div>
            <select class="dropdown" type="text">
                <option>dd/mm/yyyy</option>
                <option>mm/dd/yyyy</option>
                <option>yyyy/mm/dd</option>
            </select>
            <div class="text-ev">Time Format</div>
            <select class="dropdown" type="text">
                <option>24-Hour</option>
                <option>12-Hour</option>
            </select>
            <div class="text-ev">Notification</div>
            <select class="dropdown" type="text">
                <option>1 Day</option>
                <option>3 Days</option>
                <option>1 Week</option>
            </select>
            <div class="text-ev">Before Event</div>
        </div>
        </div>
        
        <%@include file="footer.jsp" %>
    </body>
</html>
