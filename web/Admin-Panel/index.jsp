<%-- 
    Document   : index
    Created on : Sep 3, 2017, 8:41:04 PM
    Author     : Diana
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" type="text/css" href="Assets2/css/login.css">
        <link rel="stylesheet" type="text/css" href="Assets2/css/responsive.css">
    </head>
    <body>
        
         <!-- Modal content -->
				  <div class="modal-content">
				    	
							  <div class="form">
							  	<div class="modal-header">
							      
							      <h2> Login Administrator </h2>
							    </div>
							    
								
							    <form class="login-form" action="login.jsp" method="POST">
							      <input type="text" name="username" value="" placeholder="username">
							      <input type="password" name="password" value="" placeholder="password">
							      <button value="Login">login</button>
							      <p class="message">Not registered? <a href="registrasi.jsp">Create an account</a></p>
							    </form>
							  </div>
							
				  </div> <!--modal content-->

        
    </body>
</html>
