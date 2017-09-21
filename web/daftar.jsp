<%-- 
    Document   : daftar
    Created on : Sep 15, 2017, 5:01:23 PM
    Author     : diana
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<html>
	<head>
		<title> Travelander A2 </title>
		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/assets/css/style.css">
	</head>
	
	<body>
	<div class="induk borrad col-m-8 col-5">
		<div class="login col-11 col-m-11">
		<h2 class="borrad col-m-12"> Silahkan Isi From Travelander A2 </h2>
		<form action="daftar.html">
			<input class="kotak borrad col-m-12" type="text" name="kotak" placeholder="Nama Lengkap...." />
			<input class="kotak borrad col-m-12" type="text" name="kotak" placeholder="Username...." />
			<input class="kotak borrad col-m-12" type="text" name="kotak" placeholder="Email...." />
			<input class="kotak borrad col-m-12" type="text" name="kotak" placeholder="Password...." />
			<input class="kotak borrad col-m-12" type="text" name="kotak" placeholder="Alamat Rumah...." />
			<input class="kotak borrad col-m-12" type="text" name="kotak" placeholder="Kendaraan Yang Dimiliki...." />
			<input type="button" class="daf borrad" value="Daftar Yaa">
		</form>
		</div> <!--login-->
	</div> <!--induk-->
	</body>
</html>