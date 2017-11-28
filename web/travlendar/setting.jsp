<%-- 
    Document   : setting
    Created on : Nov 27, 2017, 10:14:27 PM
    Author     : Alpin J
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" href="css/style.css">
        <!-- Google Maps JS API -->
        <script src="https://maps.googleapis.com/maps/api/js?key=AIzaSyDkmRXiWxa2lmWdsxjcqahurk8g_rtHM1s"></script>
        
        <!-- JQuery Library -->
        <script src="http://code.jquery.com/jquery-latest.min.js"></script> 
        
        <!-- GMaps Library -->
        <script src="js/gmaps.js"></script>
        
        <!-- GMaps Custom Setting for This Page -->
        <script src="js/mapsdefault.js"></script>
    </head>
    <body>
        <div class="jarak-atas">

    </div> <!--jarak-atas-->

    <div class="menu-atas">
	<div class="header">
             <div class="logonya">
                <img src="images/travelendar2.png">
                
            </div>
            <div class="logo">
                <img src="images/logo.png">
            </div> <!--logo-->
            
            <div class="dropdown" style="float:right;">
                <button class="dropbtn">
                    <a class="icon-account">
                            <img src="icon/akun1.png">
                    </a>
                </button>
                <div class="dropdown-content">
                  <a href="#">My Account</a>
                  <a href="#">Add Account</a>
                  <a href="index.jsp">Sign Out</a>
                </div>
            </div>
            
            <div class="dropdown" style="float:right;">
                <button class="dropbtn">
                    <a class="icon-account">
                            <img src="icon/notif2.png">
                    </a>
                </button>
                <div class="dropdown-content">
                  <a href="#">Notif 1</a>
                  <a href="#">Notif 2</a>
                  <a href="#">Notif 3</a>
                </div>
            </div>
                  
            <div class="kotak-cari">
                <div class="icon-cari">
                    <img src="icon/search.png">
                </div>
                <input class="cari" type="text" placeholder="Find Event ..."/>
            </div> <!--kotak-cari-->
          
	</div> <!--header-->
     
    </div> <!--menu-atas-->
        
    
    <div class="wadah-gamb">
        <div class="slogan">
        <div class="sukses">
        <h2> Make Your Plan Be Batter ! </h2>
        </div>
        </div>
    </div>
    
    <div class="induk1">
        
        <div class="container-t">
            <div class="tab">
                <button class="tablinks" onclick="openCity(event, 'London')" id="defaultOpen">Account</button>
                <button class="tablinks" onclick="openCity(event, 'Paris')">General</button>
            </div>
        </div>
    </div> <!--induk1-->
    
    <div class="induk2">
        <div class="container">
            <div id="London" class="tabcontent">
                <div class="main">
                    <div class="text-ev"> Fullname </div>
                    <input class="ev" id="orig" type="text" placeholder="Ira Kusnindi">
                    <div class="text-ev"> E-mail </div>
                    <input class="ev" id="orig" type="text" placeholder="irakusnindi18@gmail.com">
                    <div class="text-ev"> Username </div>
                    <input class="ev" id="orig" type="text" placeholder="irakusnindi">
                    <div class="text-ev"> Password </div>
                    <input class="ev" id="orig" type="password" placeholder="********">
                </div>
            </div>
            <div id="Paris" class="tabcontent">
                <div class="main">
                    <div class="left">
                        <div class="text-ev"> Date format </div>
                        <select class="time-ev" type="text">
                            <option>dd/mm/yyyy</option>
                            <option>mm/dd/yyyy</option>
                            <option>yyyy/mm/dd</option>
                        </select>
                        <div class="text-ev"> Time format </div>
                        <select class="time-ev" type="text">
                            <option>24-Hour</option>
                            <option>12-Hour</option>
                        </select>
                        <div class="text-ev">  Notification </div>
                        <select class="time-ev" type="text">
                            <option>1 day</option>
                            <option>3 days</option>
                            <option>1 week</option>
                        </select>
                    </div>
                    <div class="right">
                        <button class="save-ev" id="myBtn">Save changes</button>
                    </div>
                </div>
            </div>
        </div>
        
    </div>
    
    
        
        <%@include file="footer.jsp" %>
    </body>
</html>
