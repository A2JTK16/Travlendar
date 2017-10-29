<%-- 
    Document   : addtraveller
    Created on : Oct 29, 2017, 3:12:20 PM
    Author     : Reza Dwi Kurniawan
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
        <center><h1 class="judul-manage">Input User</h1></center>
        <form action="${pageContext.request.contextPath}/traveller?input=baru" method="post">
            <table style="margin:20px auto;">
		<tr>
                    <td>ID Traveller </td>
                    <td><input type="text" name="id_trav" values=""></td>
		</tr>
		<tr>
                    <td>Nama Traveller </td>
                    <td><input type="text" name="nama_trav" values=""></td>
		</tr>
                <tr>
                    <td>Email Traveller </td>
                    <td><input type="text" name="email_trav" values=""></td>
		</tr>
                <tr>
                    <td>Password Traveller </td>
                    <td><input type="text" name="password_trav" values=""></td>
		</tr>
                <tr>
                    <td>Nama Lengkap Traveller </td>
                    <td><input type="text" name="fullname_trav" values=""></td>
		</tr>

		<tr>
                    <td></td>
                    <td><input type="submit" value="Tambah"></td>
		</tr>
            </table>
	</form>	
