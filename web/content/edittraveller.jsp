<%-- 
    Document   : editmodatransportasi
    Created on : Oct 21, 2017, 11:48:41 AM
    Author     : mufidjamaluddin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    
<h1 class="judul-manage">Edit Traveller</h1>

<table>
    <tr>
        <td>ID Lama</td>
        <td>Nama Lama</td>
        <td>Email Lama</td>
        <td>Password Lama</td>
        <td>Traveller Lama</td>
    </tr>
    
    <tr>
        <td><c:out value="${travellerObj.getTraveller_id()}"/></td>
        <td><c:out value="${travellerObj.getTraveller_name()}"/></td>
        <td><c:out value="${travellerObj.getTraveller_email()}"/></td>
        <td><c:out value="${travellerObj.getTraveller_password()}"/></td>
        <td><c:out value="${travellerObj.getTraveller_fullName()}"/></td>
    </tr>>
    
</table>

<center><h1 class="judul-manage">Edit Traveller</h1></center>
<!--<form action="${pageContext.request.contextPath}/traveller?input=edit" method="post">-->
<div class="kotakna">
    <form>
        <table style="margin:20px auto;">
		<tr>
                    <td>ID Traveller</td>
                    <td><input type="text" name="id_trav" placeholder="<c:out value="${travellerObj.getTraveller_id()}"/>"></td>
		</tr>
		<tr>
                    <td>Nama Traveller (string)</td>
                    <td><input type="text" name="nama_trav" placeholder="<c:out value="${travellerObj.getTraveller_name()}"/>"></td>
		</tr>
                <tr>
                    <td>Email Traveller</td>
                    <td><input type="text" name="email_trav" placeholder="<c:out value="${travellerObj.getTraveller_email()}"/>"></td>
		</tr>
                <tr>
                    <td>Password Traveller</td>
                    <td><input type="text" name="password_trav" placeholder="<c:out value="${travellerObj.getTraveller_password()}"/>"></td>
		</tr>
                <tr>
                    <td>FullName Traveller</td>
                    <td><input type="text" name="fullname_trav" placeholder="<c:out value="${travellerObj.getTraveller_fullName()}"/>"></td>
		</tr>
		<tr>
                    <td></td>
                    <td><input type="submit" value="Edit"></td>
		</tr>
        </table>
    </form>
</div