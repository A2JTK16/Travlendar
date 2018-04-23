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
        <title>My Profile</title>
        <link rel="stylesheet" href="../css/style.min.css">
        <link rel="stylesheet" href="../css/responsive.min.css">
        <!--<script src="https://maps.googleapis.com/maps/api/js?key=AIzaSyDkmRXiWxa2lmWdsxjcqahurk8g_rtHM1s&libraries=places"></script>-->
        <!-- JQuery Library -->
        <!--<script src="http://code.jquery.com/jquery-latest.min.js"></script> -->
        <script src="../js/jquery.min.js"></script>
        <!-- untuk parse tanggal -->
        <script src="../js/moment.min.js"></script>
        <!-- GMaps Library -->
        <!--<script src="../js/gmaps.js"></script>-->
        <script src="../js/setting.min.js"></script>
        
    </head>
    <body>

    <div class="menu-atas">
	<div class="header">
             <div class="logonya">
                <img src="../images/travelendar2.svg">
                
            </div>
            <div class="logo">
                <img src="../images/logo.png">
            </div> <!--logo-->
            
            <div class="dropdown" style="float:right;">
                <button class="dropbtn">
                    <a class="icon-account">
                            <img src="../icon/akun1.png">
                    </a>
                </button>
                <div class="dropdown-content">
					<a>Hi, <%= session.getAttribute("username") %> </a>
                    <a href="../">My Plan</a>
                    <a href="https://goo.gl/forms/pfpqxLwGItxB30eX2"> Feedback </a>
					<a id="signout">Sign Out</a>
                </div>
            </div>
            
            <div class="dropdown" style="float:right;">
                <button class="dropbtn">
                    <a class="icon-account">
                            <img src="../icon/notif2.png">
                    </a>
                </button>
                <div class="dropdown-content">
                  <a href="#">Welcome to Travelendar ! by A2 JTK</a>
                  <a href="#">Don't Forget to Make a Better Plan ! by A2 JTK</a>
                  <a href="#">Our Plan Will Get Big Things! by A2 JTK</a>
                </div>
            </div>
                  
            <div class="kotak-cari">
                <div class="icon-cari">
                    <img src="../icon/search.png">
                </div>
                <input class="cari" id="findEvent" type="text" placeholder="Find Event ..."/>
                <div id="findResult" style="list-style:none"></div>
            </div> <!--kotak-cari-->
          
	</div> <!--header-->
     
    </div> <!--menu-atas-->
        
    
    <div class="wadah-atas">
	<img src="../images/bg1.jpg" alt="">
        <div class="slogan">
            <div class="logoku">
                <img src="../images/travelendar2.svg">
            </div>
            <h1 style="text-align:center">Welcome Travlendar</h1>
            <p style="text-align:center"> Make Your Plan Better ! </p>
        </div>
        
    </div> <!--wadah--atas-->
    
    
    <div class="induk1">
        
        <div class="container-t">
            <div class="tab">
                <button class="tablinks" id="Account">Account</button>
                <button class="tablinks" id="General">General</button>
            </div>
        </div>
    </div> <!--induk1-->
    
    <div class="induk2">
         <div class="container">
     
             <div id="London" class="tabcontent">
                <div class="main">
                    <div class="text-ev"> Username </div>
                    <input class="ev" type="text" id="input0" disabled>
                    <div class="text-ev"> Fullname </div>
                     <input class="ev" type="text" id="input1">
                     <div class="text-ev"> E-mail </div>
                     <input class="ev" type="text" id="input2">
                     <div class="text-ev"> Password </div>
                     <input class="ev" type="password" id="input3">
                     <div class="text-ev"> Confirm Password </div>
                     <input class="ev" type="password" id="input4">
                     <div class="text-ev"> Address </div>
                     <input class="ev" type="text" id="input5">
                     <br/>
                     <button class="save-ev" id="tblEdit">Edit Profile</button>
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
        <div class="footer-atas">
	
        </div> <!--footer-atas-->

	<div class="footer-bawah">
            <div class="footer">
            <div class="container-t">    
                <div class="copyright">
                    <h4>Travelendar</h4>
                    <div class="cpy"> Copyright &copy; 2017 travlendar | Designed by A2 JTK Polban</div>
                </div> <!--copyright-->
                
                <div class="share-sos">
                    <div class="sos">
                        <a href="https://www.facebook.com/travlendar.proyek.1"><img src="../icon/fb.png"></a>
                    </div>
                    
                    <div class="sos">
                        <a href="https://twitter.com/Travlendar2a"><img src="../icon/twt.png"></a>
                    </div>
                    
                    <div class="sos">
                        <a href="https://www.instagram.com/travelendara2proyek3/"><img src="../icon/inst.png">
                    </div>
                    
                    <div class="sos">
                        <a href="https://www.youtube.com/channel/UC4OTlsVRe7TTHzs8yc_eJkg"><img src="../icon/yt.png"></a>
                    </div>
                </div> <!--share-sos-->
            </div>    
            </div>
        </div> <!--footer-bawah-->
        
    </body>
</html>
