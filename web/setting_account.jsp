<%-- 
    Document   : setting_account
    Created on : Oct 16, 2017, 6:03:35 AM
    Author     : NIA
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" type="text/css" href="Assets/css/userstyle.css">
        <link rel="stylesheet" type="text/css" href="Assets/css/calendar.css">
        <link rel="stylesheet" type="text/css" href="Assets/css/userresponsive.css">
        <title>JSP Page</title>
    </head>
    <body>
         
           
   
              <%@include file="header.jsp" %>
        
           <div class="middle-center" > 
        
                          <div class="kotak-traveller">
                               <div class="kotakna">
                                <div class="k-text">
                                    <div class="k-textna">Name</div>
                                    <div class="k-textna">Username</div>
                                    <div class="k-textna">E-maill</div>
                                     <div class="k-textna">Password</div>
                                     <div class="k-textna">Home address</div>
                                   </div>
                                   
                                     
                                    <input class="k-event" type="text" style="width: 300px">
                                    <br>
                                    <input class="k-event" type="text" style="width:300px"> 
                                    <br>
                                    <input class="k-event"type="text" style="width: 300px" >
                                    <br>
                                     <input class="k-event" type="text"style="width: 300px">
                                     <br>
                           
                                    <input class="k-event" type="text" style="width: 300px; height: 200px">
                                  
                                    <br>
                                    <br>
                                    <a href="halaman_utama.jsp"> <button class="back" style="float: right"> Save Changes </button></a>
                                
                                <br>
                                
                            </div>
                                   
                                   
                                   
                                   
                                </div> <!--kotakna-->
	
			
		</div> <!--/ .Kotak-traveller -->
           </div>
           
           
    </body>
</html>
