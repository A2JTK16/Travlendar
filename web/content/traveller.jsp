<%-- 
    Document   : traveller
    Created on : Oct 17, 2017, 10:32:20 AM
    Author     : Reza Dwi Kurniawan
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<h1>List Agenda</h1>
    <table>
        <tr>
            <th>Traveller ID</th>
            <th>Traveller Full Name</th>
        </tr>
        
        <c:forEach items="${travellerList}" var="traveller">
        <tr>           
            <td><c:out value="${traveller.getTraveller_id()}"/></td>
            <td><c:out value="${traveller.getTraveller_fullName()}"/></td>
        </tr>
        </c:forEach>
        
    </table>