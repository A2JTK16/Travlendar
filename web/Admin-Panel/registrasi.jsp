<%-- 
    Document   : registrasi
    Created on : Sep 3, 2017, 8:44:58 PM
    Author     : Diana
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/Assets2/css/login.css">
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/Assets2/css/responsive.css">
        <title>Registration</title>
    </head>
    <body>
        
				  <!-- Modal content -->
				  <div class="modal-content">
				    	
							  <div class="form">
							  	<div class="modal-header">
							      
							      <h2> Create Acount </h2>
							    </div>
							    <form class="login-form" method="post" action="prosesregis.jsp">
							      <input type="text" name="username" value="" placeholder="name"/>
							      <input type="password" name="password" value="" placeholder="password"/>
							      <input type="text" name="email" value="" placeholder="email address"/>
							      <button>create</button>
							      <p class="message">Already registered? <a href="index.jsp">Sign In</a></p>
							    </form>
								
							  </div>
							
				  </div> <!--modal content-->

    </body>
</html>