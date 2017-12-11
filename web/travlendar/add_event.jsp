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
        <!--<script src="http://code.jquery.com/jquery-latest.min.js"></script> -->
        <script src="js/jquery.min.js"></script>
        <!-- untuk parse tanggal -->
        <script src="js/moment.min.js"></script>
        <!-- GMaps Library -->
        <script src="js/gmaps.js"></script>
        
        <!-- GMaps Custom Setting for This Page -->
        <script src="js/mapsdefault.js"></script>
        
        <link href='calendar-event/fullcalendar.min.css' rel='stylesheet' />
        <link href='calendar-event/fullcalendar.print.min.css' rel='stylesheet' media='print' />
        <script src='calendar-event/lib/moment.min.js'></script>
        <script src='calendar-event/lib/jquery.min.js'></script>
        <script src='calendar-event/fullcalendar.min.js'></script>
        <script>

                $(document).ready(function() {

                    $.ajax({
                        dataType : "json",
                        contentType : "application/json",
                        url: "${pageContext.request.contextPath}/index?action=getlistEvent",
                        success: function(data)
                        {
                            var lastDate;

                            $('#calendar').fullCalendar({
                                header: {
                                        left: 'prev,next today',
                                        center: 'title',
                                        right: 'month,agendaWeek,agendaDay,listWeek'
                                },
                                defaultDate: '2009-09-22',
                                navLinks: true, // can click day/week names to navigate views
                                editable: true,
                                eventLimit: true, // allow "more" link when too many events
                                events: $.map(data, function(item,i)
                                        {
                                            var event = new Object();
                                            event.title = item.title;
                                            event.start = moment(item.start).utc();
                                            event.end = moment(item.end).utc();
                                            event.id = item.id;
                                            lastDate = moment(item.start).format('YYYY-MM-DD');
                                            return event;
                                        })

                                });

                                $('#calendar').fullCalendar('gotoDate', lastDate);
                        }   
                    });
                });	
        </script>
<style>

	#calendar {
		max-width: 900px;
		margin: 0 auto;
	}

</style>
        
    </head>
<body>
	
    <div class="jarak-atas">

    </div> <!--jarak-atas-->
    <a href="add_event.jsp"></a>

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
                  <a href="setting.jsp">Setting Account</a>
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
                          <button class="tablinks" onclick="openCity(event, 'Tasik')" id="defaultOpen">Calendar</button>
			  <button class="tablinks" id="getList">List Event</button>
			  <button class="tablinks" onclick="openCity(event, 'London')" id="defaultOpen">Add New Event</button>
                          <!--<input class="search-ev" type="text" placeholder="Search Event ... "/>-->
	</div>
	</div> <!--container-t-->

    </div> <!--induk1-->

        <div class="induk2">

            <div class="container">
                
                <div id="Tasik" class="tabcontent">
                   <div id='calendar'></div>
                 
		</div>
                
                

		<div id="London" class="tabcontent">
		  <input class="ev-name" id="eventName" type="text" placeholder="What Your Event ??.. "/>

			<div class="main">
				<div class="left">
					<input class="ev" id="orig" type="text" placeholder="Event Location ...">
					<div class="text-ev"> From </div>
					<input class="tgl-ev" id="origDate" type="date" value="2017-11-28">
					<input class="time-ev" id="origTime" type="time" value="00:00"/>
                                        <div class="text-ev"> Until </div>
					<input class="tgl-ev" id="destDate" type="date" value="2017-11-28">
                                        <input class="time-ev" id="destTime" type="time" value="00:00"/>
                                        
                                        
				</div>
				
				
				<div class="right">
					<input class="ev" id="dest" type="text" placeholder="Previeous Location ...">
					<div class="text-ev"> Departure Time </div>
                                        <input class="tgl-ev" id="departureDate" type="date" value="2017-11-28">
                                        <input class="time-ev" id="departureTime" class="departure" type="time" value="00:00"/>
                                        
				</div>
                                
                                <input class="ev-name" id="noteDesc" type="text" placeholder="Note .. " style="height:75px;"/>
                            
                                 <div class="i-save" >
                <button class="submit" id="myBtn">Submit</button>
				<!-- The Modal -->
				<div id="myModal" class="modal">

				  <!-- Modal content -->
				  <div class="modal-content">
				    	
							  <div class="form">
							    <div class="modal-header">
							      <span class="close">&times;</span>
							      <h4>Select Your Transportation Mode</h4>
                                                              
							    </div>
                                                              <div class="k-popup">
                                                                  <form action="#" method="POST">
                                                                  <div class="k-transport">
                                                                      <div class="trans"> <img src="icon/air2.png"> </div>
                                                                      <br> ⭙
                                                                  </div>
                                                                   <div class="k-transport">
                                                                       <div class="trans"> <img src="icon/train.png"></div>
                                                                       <input type="radio" id="radio" name="transportation" class="transportation" value="TRANSIT">
                                                                      <input id="transit" type="text">
                                                                      <br>
                                                                  </div>
                                                                   <div class="k-transport">
                                                                      <div class="trans"> <img src="icon/car.png"> </div>
                                                                      <input type="radio" id="radio2" name="transportation" class="transportation" value="DRIVING" >
                                                                      <input id="driving" type="text">
                                                                  </div>
                                                                   <div class="k-transport">
                                                                      <div class="trans"> <img src="icon/motor3.png"> </div>
                                                                      <input type="radio" id="radio3" name="transportation" class="transportation" value="BICYCLING" >
                                                                      <input id="bicycling" type="text">
                                                                  </div>
                                                                   <div class="k-transport">
                                                                      <div class="trans"> <img src="icon/walk.png"> </div>
                                                                      <input type="radio" id="radio1" name="transportation" class="transportation" value="WALKING" >
                                                                      <input id="walking" type="text">
                                                                  </div>
                                                                  
                                                                  <button id="TombolSave">Save</button>
                                                                  </form>
                                                              </div>
							    
							  </div>
							
				  </div> <!--modal content-->
				</div>
                                
            </div> <!--i-save-->

				
			</div> <!--/ .main -->
		</div>
                
		<div id="Paris" class="tabcontent">
                    <!--<button id="viewList">View</button>-->
                                        <table id="tableEvent">
						<thead>
						<tr>
                                                    <th style="display:none"></th>
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

        <div class="container">
            <div class="main">
                <div id="map">Maps Event</div>
            </div> <!--/ .main -->
        </div> <!--container-->


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
