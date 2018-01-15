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
        <link rel="stylesheet" type="text/css" href="../css/home.css">
        <link rel="stylesheet" type="text/css" href="../css/responsivehome.css">
        <link href="https://fonts.googleapis.com/css?family=Roboto+Slab" rel="stylesheet">
        <script src="../js/jquery.min.js"></script>
        <script src="../js/signup.js"></script>
        <title>Create Your Account</title>
    </head>
    <body>
        <div class="logoup">
            <img src="../images/trav.svg">
        </div><!--menu-atas-->
        <div class="wadah1">
        <!-- Modal content -->
            <div class="modal-content">			    	
		<div class="form2">
                    
                    <div class="modal-header">
                        <h1> Create Your Account </h1>
                    </div>
                    
                    <form class="register-form" id="regForm">
                        <input class="wajibdiisi" type="text" name="fullname" placeholder="Fullname ..."/>
			<input class="wajibdiisi" type="text" name="user" placeholder="Username ..."/>
                        <input class="wajibdiisi" type="text" name="email" placeholder="Email ..."/>
			<input class="wajibdiisi" type="password" name="pass" placeholder="Password ..."/>
                        <input type="text" name="address" placeholder="Your Home Address ..."/>
                        <br>	
                    </form>
                    <button class="b-signup" id="tblSignup">Sign Up</button>
                    <a href="../"><button class="b-back">Back</button></a>
                    <!--<a href="listuser.html"><button class="b-back">Show List User</button></a>-->
		</div>			
            </div> <!--modal content-->
        </div>           
        <%--<%@include file="footer.jsp" %>--%>
        
        <div id="modalMessage" class="modal">
            <!-- Modal content -->
            <div class="modal-content2">
	  	
                <div class="form">
                    <div class="modal-header">
                        <span class="close" id="modalClose">&times;</span>
                        <h3 id="messageTitle"></h3>
                    </div>
                    <div>
                        <a id="messagePoint"></a>
                    </div>
                    <button class="b-signup" id="tblHome">Go Home</button>
                    <button class="b-signup" id="tblOk">Okay</button>
                </div>
            </div> <!--modal content-->
        </div>
        

        
    </body>
</html>

