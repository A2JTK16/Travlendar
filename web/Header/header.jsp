<%-- 
    Document   : header
    Created on : Sep 24, 2017, 9:32:16 AM
    Author     : Lenovo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/Assets2/css/styletraveller.css">
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/Assets2/css/responsive.css">
        <title>Header</title>
    </head>
    <body>
                
<div class="jarak-atas">

</div> <!--jarak-atas-->

<div class="menu-atas">
	<div class="header">
            <div class="logonya">
                <img src="${pageContext.request.contextPath}/Assets2/icon/logo.png">
            </div>
            <div class="logo">
                <h1>Travelendar</h1>
            </div> <!--logo-->
                
          
                <div class="kotak-acount">
                   <div  class="acount-nama">
                        Admin Acount    
                   </div>  
                    
                   <div class="dropdown">
                       <button onclick="myFunction()" class="dropbtn">
                           
                           <div class="icon-account">
                            <img src="${pageContext.request.contextPath}/Assets2/icon/Account.png">
                           </div>
                           
                       </button>
                      <div id="myDropdown" class="dropdown-content">
                        <a href="#home">Home</a>
                        <a href="#about">Profile</a>
                        <a href="../index.jsp">Logout</a>
                      </div>
                    </div>
                </div> <!--kotak-acount-->

                    <script>
                    /* When the user clicks on the button, 
                    toggle between hiding and showing the dropdown content */
                    function myFunction() {
                        document.getElementById("myDropdown").classList.toggle("show");
                    }

                    // Close the dropdown if the user clicks outside of it
                    window.onclick = function(event) {
                      if (!event.target.matches('.dropbtn')) {

                        var dropdowns = document.getElementsByClassName("dropdown-content");
                        var i;
                        for (i = 0; i < dropdowns.length; i++) {
                          var openDropdown = dropdowns[i];
                          if (openDropdown.classList.contains('show')) {
                            openDropdown.classList.remove('show');
                          }
                        }
                      }
                    }
                    </script>                    
              <!-->  </div>
                </div> <!--kotak-acount-->
	</div> <!--header-->
        
     
</div> <!--menu-atas-->



    </body>
</html>
