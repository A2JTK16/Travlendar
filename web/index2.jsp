<%-- 
    Document   : agenda
    Created on : Oct 13, 2017, 3:07:10 PM
    Author     : mufidjamaluddin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!-- Include Header, termasuk CSS nya -->
<jsp:include page="header.jsp"/>

<div class="wadah">
    <div class="main">
        
        <p class="message"><c:out value="${message}"/></p>
        
        <c:set var="content" scope="request" value="${content}"/>
        <c:choose>
            <c:when test="${content == null}">
                <h1 class="judul">Menu Admin</h1>
                <a href="   <c:url value="moda">
                                <c:param name="action" value="show"/>
                            </c:url>
                        ">Daftar List Moda Transportasi</a><br/>
                <a href="   <c:url value="moda">
                                <c:param name="action" value="add"/>
                            </c:url>
                        ">Add List Moda Transportasi</a><br/>
                <a href="   <c:url value="traveller">
                                <c:param name="action" value="show"/>
                            </c:url>
                        ">Daftar List Traveller</a><br/>
                <a href="   <c:url value="traveller">
                                <c:param name="action" value="add"/>
                            </c:url>
                        ">Add List Traveller</a><br/>
            </c:when>
            <c:otherwise>
                <jsp:include page="content/${content}.jsp"/>
            </c:otherwise>
        </c:choose>
    </div>
</div>                 
                        
<!-- Include Footer, termasuk Tutup Tag Body dan Tutup tag Html nya -->   
<jsp:include page="footer.jsp"/>
