<%-- 
    Document   : transrecomendation
    Created on : Oct 31, 2017, 9:13:54 AM
    Author     : Reza Dwi Kurniawan
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<h1>List Agenda</h1>
    <table>
        <tr>
            <th>Nama Kendaraan<br/>Estimasi</th>
        </tr>
        
        <c:forEach items="${recomendationList}" var="recObj">
        <tr>           
            <td><c:out value="${recObj}"/></td>
        </tr>
        </c:forEach>
        
    </table>

    <!--<div class="pagination">
        <a href="index.html" class="page active">first</a>
        <a href="index.html" class="page"> 3 </a>
        <a href="index.html" class="page"> 5 </a>
        <a href="index.html" class="page"> 6 </a>
        <a href="index.html" class="page">last</a>
    </div>-->