<%-- 
    Document   : modatransportasi
    Created on : Oct 15, 2017, 8:55:39 PM
    Author     : Reza Dwi Kurniawan
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<h1>List Agenda</h1>
    <table>
        <tr>
            <th>Kode</th>
            <th>Nama Kendaraan</th>
            <th>Kecepatan</th>
        </tr>
        
        <c:forEach items="${modaTransList}" var="modaTrans">
        <tr>           
            <td><c:out value="${modaTrans.getKodeTransportasi()}"/></td>
            <td><c:out value="${modaTrans.getNamaTransportasi()}"/></td>
            <td><c:out value="${modaTrans.getKecepatan()}"/></td>
        </tr>
        </c:forEach>
        
    </table>