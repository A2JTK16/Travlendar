<%-- 
    Document   : agenda
    Created on : Oct 13, 2017, 3:07:10 PM
    Author     : mufidjamaluddin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>
            <c:out value="${content}"/> Travlendar A2
        </title>
    </head>
    <body>
        <h1>Travlendar A2</h1>
        <p><c:out value="${message}"/></p>
        
        <c:set var="content" scope="request" value="${content}"/>
        <c:choose>
            <c:when test="${content == null}">
                <c:out value="Masukkan URL Controller yg Benar"/>
            </c:when>
            <c:otherwise>
                <jsp:include page="content/${content}.jsp"/>
            </c:otherwise>
        </c:choose>
        
    </body>
</html>
