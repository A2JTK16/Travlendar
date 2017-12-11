<%-- 
    Document   : add_event
    Created on : Nov 17, 2017, 4:55:25 PM
    Author     : Lenovo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
	<meta charset="UTF-8">
	<title>Welcome Travlendar</title>
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<link rel="stylesheet" href="css/style.css">
        <link rel="stylesheet" href="css/responsive.css">
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
			  <button class="tablinks" onclick="openCity(event, 'London')" id="defaultOpen">View More</button>
			  <!--<input class="search-ev" type="text" placeholder="Search Event ... "/>-->
	</div>
	</div> <!--container-t-->

    </div> <!--induk1-->

        <div class="induk2">

            <div class="container">
                
                <div id="Hari" class="tabcontent">
                                        <table id="tableEvent">
						<thead>
						<tr>
						    <th>Time</th>
                                                    <th>Evnet Name</th>
                                                    <th>Use</th>
                                                    <th>At</th>
                                                    <th>Location</th>
                                                    <th> Note </th>
						</tr>
						</thead>
                                                
                                                <tr>
                                                    <td> </td>
                                                    <td> </td>
                                                    <td> </td>
                                                    <td> </td>
                                                    <td> </td>
                                                    <td> </td>
                                                </tr>
						<tbody>
                                                	
						
						</tbody>
					</table>
		</div>


		<div id="London" class="tabcontent">
			<div class="main">
                            <form action="add_event.jsp" method="POST">
				<div class="left">
                                    <div class="text-ev"> Ke Kantor </div>
                                    <div id="map">Maps Event</div>
				</div>
				
				
				<div class="right">
                                        <div class="text-ev"> Start </div>
					<input class="ev" id="dest" type="text" placeholder="Ke ...">
					<div class="text-ev"> Event Locations </div>
					<input class="ev" id="dest" type="text" placeholder="Ke ...">
                                        <div class="text-ev"> Use </div>
                                        <div class="icon-more">
                                            <img src="icon/car.png">
                                        </div>
                                        <div class="text-ev"> At </div>
                                        <input class="time-ev" id="time" type="time" value="00:00"/>
				</div>
                                 
                                <input class="ev-name" id="desc" type="text" placeholder="Note .. " style="height:75px;"/>

                                <div class="i-save" >
                                    <button class="save-ev" id="myBtn"> Edit </button>            
                                </div> <!--i-save-->
                            </form>
				
			</div> <!--/ .main -->
		</div>
                
		<div id="Paris" class="tabcontent">
                    <button id="viewList">View</button>
                                        <table id="tableEvent">
						<thead>
						<tr>
						    <th>Event Name</th>
                                                    <th>Date & Time</th>
                                                    <th>Use</th>
                                                    <th>At</th>
                                                    <th>Location</th>
                                                    <th>Action</th>
						</tr>   
						</thead>
                                                
                                                <tbody>
                                                
	
						
						</tbody>
					</table>
		</div>

		<div id="Tokyo" class="tabcontent">
                  
		  <h3>Tokyo</h3>
                  
                      <p> huuhhh </p>
	          
		</div>

            </div> <!--container-->

           	
        </div> <!--induk2-->



        <div class="footer-atas">
	
        </div> <!--footer-atas-->

	<div class="footer-bawah">
            <div class="footer">
                <div class="copyright">
                    Travelendar
                </div> <!--copyright-->

                <div class="copyright2">
                    Copyright &copy; 2017 travlendar | Designed by A2 JTK Polban
                </div>
            </div>
        </div> <!--footer-bawah-->
        
    </body>
</html>