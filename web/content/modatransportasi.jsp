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
            <th></th>
            <th></th>
        </tr>
        
        <c:forEach items="${modaTransList}" var="modaTrans">
        <tr>           
            <td><c:out value="${modaTrans.getKodeTransportasi()}"/></td>
            <td><c:out value="${modaTrans.getNamaTransportasi()}"/></td>
            <td><c:out value="${modaTrans.getKecepatan()}"/></td>
            <td><a href="   <c:url value="moda">
                                <c:param name="action" value="edit"/>
                                <c:param name="code" value="${modaTrans.getKodeTransportasi()}"/>
                            </c:url>
                        ">Edit</a></td>
            <td><a href="#">Delete</a></td>
        </tr>
        </c:forEach>
        
    </table>