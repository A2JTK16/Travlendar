<%-- 
    Document   : index
    Created on : Sep 15, 2017, 5:01:23 PM
    Author     : diana
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<html>
	<head>
		<title> Travelander A2 </title>
		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/Assets1/css/style.css">
	</head>
	
	<body>
	<div class="induk borrad col-5 col-m-8">
		<div class="login col-11 col-m-11">
		<h2 class="borrad col-m-12"> Login Travelander A2 </h2>
		<form action="daftar.html">
			<input class="kotak col-m-12 borrad" type="text" name="email" placeholder="Masukan Username...." />
			<input class="kotak col-m-12 borrad" type="password" name="password" placeholder="Masukan Password...." />
			<input type="button" class="submit" value="login" href="daftar.html">
			<input type="button" class="daf borrad" value="Daftar Heula">
		</form>
		</div> <!--login-->
	</div> <!--induk-->
	</body>
</html>
