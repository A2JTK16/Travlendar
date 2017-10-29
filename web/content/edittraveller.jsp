<%-- 
    Document   : editmodatransportasi
    Created on : Oct 21, 2017, 11:48:41 AM
    Author     : mufidjamaluddin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    
<h1 class="judul-manage">Edit Moda Transportasi</h1>

<table>
    <tr>
        <td>Kode Lama</td>
        <td>Nama Lama</td>
        <td>Kecepatan Lama</td>
    </tr>
    <tr>
        <td><c:out value="${modaTransObj.getKodeTransportasi()}"/></td>
        <td><c:out value="${modaTransObj.getNamaTransportasi()}"/></td>
        <td><c:out value="${modaTransObj.getKecepatan()}"/></td>
    </tr>>
</table>

<center><h1 class="judul-manage">Edit Moda Transportasi</h1></center>
<!--<form action="${pageContext.request.contextPath}/moda?input=edit" method="post">-->
<div class="kotakna">
    <form>
        <table style="margin:20px auto;">
		<tr>
                    <td>Kode Transportasi (char2)</td>
                    <td><input type="text" name="kode_trans" placeholder="<c:out value="${modaTransObj.getKodeTransportasi()}"/>"></td>
		</tr>
		<tr>
                    <td>Nama Transportasi (string)</td>
                    <td><input type="text" name="nama_trans" placeholder="<c:out value="${modaTransObj.getNamaTransportasi()}"/>"></td>
		</tr>
                <tr>
                    <td>Kecepatan (float)</td>
                    <td><input type="text" name="kecepatan" placeholder="<c:out value="${modaTransObj.getKecepatan()}"/>"></td>
		</tr>

		<tr>
                    <td></td>
                    <td><input type="submit" value="Edit"></td>
		</tr>
        </table>
    </form>
</div>