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
            <th>ID</th>
            <th>Nama Traveller</th>
            <th>Email Traveller</th>
            <th>Password Traveller</th>
            <th>Traveller FullName</th>
            <th></th>
            <th></th>
        </tr>
        
        <c:forEach items="${travellerList}" var="traveller">
        <tr>           
            <td><c:out value="${traveller.getTraveller_id()}"/></td>
            <td><c:out value="${traveller.getTraveller_name()}"/></td>
            <td><c:out value="${traveller.getTraveller_email()}"/></td>
            <td><c:out value="${traveller.getTraveller_password()}"/></td>
            <td><c:out value="${traveller.getTraveller_fullName()}"/></td>
            <td><a href="   <c:url value="traveller">
                                <c:param name="action" value="edit"/>
                                <c:param name="code" value="${traveller.getTraveller_id()}"/>
                            </c:url>
                        ">Edit</a></td>
            <td><a href="<c:url value="traveller">
                                <c:param name="action" value="delete"/>
                                <c:param name="code" value="${traveller.getTraveller_id()}"/>
                            </c:url>    
                   ">Delete</a></td>
        </tr>
        </c:forEach>
        
    </table>

    <div class="pagination">
        <a href="index.html" class="page active">first</a>
        <a href="index.html" class="page"> 3 </a>
        <a href="index.html" class="page"> 5 </a>
        <a href="index.html" class="page"> 6 </a>
        <a href="index.html" class="page">last</a>
    </div>