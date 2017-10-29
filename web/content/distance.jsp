<%-- 
    Document   : distance
    Created on : Oct 29, 2017, 1:53:33 PM
    Author     : faiza
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<h1>List Distance</h1>
    <table>
        <tr>
            <th>No</th>
            <th>Start Location</th>
            <th>End Location</th>
            <th>Distance</th>
            
        </tr>
        
        <c:set var="count" value="0" scope="page" />
        <c:forEach items="${distanceList}" var="distance">
        <tr>
            <c:set var="count" value="${count + 1}" scope="page"/>
            <td><c:out value="${count}"/></td>
            <td><c:out value="${distance.getStart_location_id()}"/></td>
            <td><c:out value="${distance.getEnd_location_id()}"/></td>
            <td><c:out value="${distance.getDistance()}"/></td>
        </tr>
        </c:forEach>
    </table>    
