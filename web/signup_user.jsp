<%-- 
    Document   : signup_user
    Created on : Oct 17, 2017, 11:23:13 AM
    Author     : Fadhlan
--%>


<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>        
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" type="text/css" href="Assets/css/stylehome.css">
        <link rel="stylesheet" type="text/css" href="Assets/css/calendar.css">
        <link rel="stylesheet" type="text/css" href="Assets/css/userresponsive.css">

    </head>
    <body>
        
         <!-- Modal content -->
				  <div class="modal-content">
				    	
							  <div class="form">
							  	<div class="modal-header">
							      
							      <h2> Login Administrator </h2>
							    </div>
							    
							 <div class="sulogo"><img src="Assets/images/logo.png"></div>	
							    <form class="login-form" action="index.jsp" method="POST">
							      <input type="text" placeholder="Fullname ..."/>
							      <input type="text" placeholder="Username ..."/>
							      <input type="text" placeholder="Email ..."/>
							      <input type="password" placeholder="Password ..."/>
                                                              <button value="Login">Sign up</button>
							    </form>
							  </div>
							
				  </div> <!--modal content-->

        
    </body>
</html>
