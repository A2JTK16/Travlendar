<%-- 
    Document   : cityAndProvince
    Created on : Oct 19, 2017, 12:58:12 PM
    Author     : Reza Dwi Kurniawan
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<h1>List Agenda</h1>
    <table>
        <tr>
            <th>City Code</th>
            <th>City Name</th>
        </tr>
        
        <c:forEach items="${provinceList}" var="province">
        <tr>           
            <td><c:out value="${province.getProvince_code()}"/></td>
            <td><c:out value="${province.getProvince_name()}"/></td>
        </tr>
        </c:forEach>
        
        <c:forEach items="${cityList}" var="city">
        <tr>           
            <td><c:out value="${city.getCityCode()}"/></td>
            <td><c:out value="${city.getCityName()}"/></td>
        </tr>
        </c:forEach>
        
    </table>