<%-- 
    Document   : index
    Created on : Sep 11, 2017, 11:01:29 AM
    Author     : Diana
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/style.css">
        <title>JSP Page</title>
    </head>
    <body>
        <div class="wadah">
	<div class="header">
            <div class="SignOrLog">
                        <input type="submit" class="sign" value="Sign Up">
                        <text> OR </text>
                        <input type="submit" class="log" value="Login">
            </div>
	</div> <!--header-->

	<div class="content">

		<div class="kotak">

		</div>
		<div class="kotak">

		</div>


		<div class="kotak-login">            
			<div class="login">
				<form action="#">
					<input class="b" type="text" placeholder="Masukan Username.....">
					<input class="b" type="password" placeholder="Masukan Password.....">
					<input class="button" type="submit" value="Login"> 
				</form>
			</div>
		</div> <!--kotak-->

		<div class="kotak">
                    <div class="desk">
			<p>
				Travel is the movement of people between relatively distant geographical locations, and can involve travel by foot, bicycle, automobile, train, boat, bus, airplane, or other means, with or without luggage, and can be one way or round trip
			</p>
                    </div> <!--desk-->
		</div> <!--kiri-->

		<div class="kotak">
                    <div class="kalimat">
			<h2> Travlendar </h2>
                    </div>
		</div> <!--tengah-->

		<div class="kotak">
			<p>
			Travel is the movement of people between relatively distant geographical locations, and can involve travel by foot, bicycle, automobile, train, boat, bus, airplane, or other means, with or without luggage, and can be one way or round trip
			</p>
		</div> <!--kanan-->
	</div>

	<div class="footer">
            <div class="cpyright"> Copyright &copy; Travlendar 2017 </div> 
	</div> <!--footer-->
</div>
    </body>
</html>
