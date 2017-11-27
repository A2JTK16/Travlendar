<%-- 
    Document   : index
    Created on : Nov 17, 2017, 4:55:08 PM
    Author     : Lenovo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" type="text/css" href="css/home.css">
        <title>Travelendar</title>
    </head>
    <body>
        
        <div class="menu-atas">
	<div class="header">
            <div class="logonya">
                <img src="images/travelendar2.png">
                
            </div>
            <div class="logo">
                <img src="images/logo.png">
            </div> <!--logo-->
            
            
            <div class="tombol" style="float:right;">
                    <div class="sign-in">
                        <button id="myBtn">Sign In</button>
                    </div>
            </div>
        </div>
        </div> <!--menu-atas-->

        
           <div class="wadah1">
               <!-- Modal content -->
				  <div class="modal-content">
				    	
							 <div class="form">
							  	<div class="modal-header">
                                                                    <h1> Create Your Account </h1>
                                                                </div>
							    <form class="register-form" action="signup-sukses.jsp" method="POST">
                                                              <input type="text" placeholder="Fullname ..."/>
							      <input type="text" placeholder="Username ..."/>
                                                              <input type="text" placeholder="Email ..."/>
							      <input type="password" placeholder="Password ..."/>
                                                              <br>
							      <button class="b-signup">Sign Up Now</button>
							    </form>
                                                             <a href="index.jsp"><button class="b-back">Back</button></a>
							  </div>
							
				  </div> <!--modal content-->
           </div>           
        <%@include file="footer.jsp" %>
    </body>
</html>

