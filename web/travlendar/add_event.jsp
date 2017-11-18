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
        <!-- Google Maps JS API -->
        <script src="https://maps.googleapis.com/maps/api/js?key=AIzaSyDkmRXiWxa2lmWdsxjcqahurk8g_rtHM1s"></script>
        
        <!-- JQuery Library -->
        <script src="http://code.jquery.com/jquery-latest.min.js"></script> 
        
        <!-- GMaps Library -->
        <script src="gmaps.js"></script>
	<link rel="stylesheet" href="css/style.css">
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

<div class="back-gamb">
   
</div> <!--back-gamb-->
    
<div class="induk1">

	<div class="container-t">
	<div class="tab">
			  <button class="tablinks" onclick="openCity(event, 'London')" id="defaultOpen">Add New Event</button>
			  <button class="tablinks" onclick="openCity(event, 'Paris')">View List Event</button>
			  <button class="tablinks" onclick="openCity(event, 'Tokyo')">Calendar Event</button>
			  
			  <!--<input class="search-ev" type="text" placeholder="Search Event ... "/>-->
	</div>
	</div> <!--container-t-->

</div> <!--induk1-->

<div class="induk2">

	<div class="container">

		<div id="London" class="tabcontent">
		  <input class="ev-name" id="desc" type="text" placeholder="What Your Event ??.. "/>

			<div class="main">
				<div class="left">
					<input class="ev" id="orig" type="text" placeholder="Origin ...">
					<div class="text-ev"> Start Event </div>
					<input class="tgl-ev" id="date" type="date" value="2017-09-08">
					<input class="time-ev" id="time" type="time" value="00:00"/>
				</div>
				
				
				<div class="right">
					<input class="ev" id="dest" type="text" placeholder="Destination ...">
					<div class="text-ev"> End Event </div>
					<input class="tgl-ev" id="date" type="date" value="2017-09-08">
                                        <input class="time-ev" id="time" type="time" value="00:00"/>
                                        <div class="text-ev"> Distance </div>
                                        <input class="time-ev" id="dist" type="text" placeholder="Km ..."/>
				</div>
				
			</div> <!--/ .main -->
		</div>

		<div id="Paris" class="tabcontent">
		  <h3>List My Event</h3>
		  <p></p> 
		</div>

		<div id="Tokyo" class="tabcontent">
		  <h3>Tokyo</h3>
		  <p>Tokyo is the capital of Japan.</p>
		</div>

		<script>
		function openCity(evt, cityName) {
			var i, tabcontent, tablinks;
			tabcontent = document.getElementsByClassName("tabcontent");
			for (i = 0; i < tabcontent.length; i++) {
				tabcontent[i].style.display = "none";
			}
			tablinks = document.getElementsByClassName("tablinks");
			for (i = 0; i < tablinks.length; i++) {
				tablinks[i].className = tablinks[i].className.replace(" active", "");
			}
			document.getElementById(cityName).style.display = "block";
			evt.currentTarget.className += " active";
		}

		// Get the element with id="defaultOpen" and click on it
		document.getElementById("defaultOpen").click();
		</script>
	</div> <!--container-->

	<div class="i-save">
		<button class="save-ev"> Save Event </button>
	</div> <!--i-save-->
	
</div> <!--induk2-->



<div class="container">
	<div class="main">
        <div id="map">Maps Event</div>
	<script>
        // JQuery
         $(document).ready( function()  // Ketika web udah siap
         {       
                //var listJson;
		var m1 = null, m2 = null;
		var m1pos, m2pos;
		var corvo = false, attano = true;
		var mapObj = new GMaps({
			el: '#map',
			lat: -6.914744,
			lng: 107.609810,
			zoom: 16,
			click: function(e) 
                            {
				if (corvo) 
                                {
                                    mapObj.removeMarker((attano) ? m1 : m2);
                                    mapObj.removePolylines();
				}

				if (attano) {
					m1 = mapObj.addMarker({
						lat: e.latLng.lat(),
						lng: e.latLng.lng()//,
						//icon: sourceIcon
					});
					m1pos = m1.getPosition();
				} 
				else {
					m2 = mapObj.addMarker({
						lat: e.latLng.lat(),
						lng: e.latLng.lng()//,
						//icon: destinationIcon
					});
					m2pos = m2.getPosition();
				}
                                

				// If two markers have been placed
				if (m1 !== null && m2 !== null) {
					corvo = true;
					mapObj.drawRoute({
						origin: [m1pos.lat(), m1pos.lng()],
						destination: [m2pos.lat(), m2pos.lng()],
						travelMode: 'driving',
						strokeColor: '#131540',
						strokeOpacity: 0.6,
						strokeWeight: 6
					});
					//$('#trace_route').prop('disabled', false);
                                        //listJson = [m1.getPosition(), m2.getPosition()];
                                        
                                        $.ajax({
                                            type: "POST", // method post
                                            url: "json", // url controller
                                            dataType:'JSON',
                                         //   data: {listjson: JSON.stringify(listJson)},
                                            data: {latitude: m2pos.lat(), longitude: m2pos.lng(), desc: document.getElementById("desc").value},
                                            async: false, // dikirim ketika semua beres
                                            success: function(data){alert(data);},
                                            failure: function(errMsg) {
                                                alert(errMsg);
                                            }
                                        });
				}
				attano = !attano;
			
                                var origin = new google.maps.LatLng(m1pos.lat(),m1pos.lng()),
                                destination = new google.maps.LatLng(m2pos.lat(),m2pos.lng()),
                                service = new google.maps.DistanceMatrixService();

                                service.getDistanceMatrix(
                                    {
                                        origins: [origin],
                                        destinations: [destination],
                                        travelMode: google.maps.TravelMode.DRIVING,
                                        avoidHighways: false,
                                        avoidTolls: false
                                    }, 
                                    callback
                                );

                                function callback(response, status) 
                                {
                                    var orig = document.getElementById("orig"),
                                    dest = document.getElementById("dest"),
                                    dist = document.getElementById("dist");

                                    if(status=="OK") {
                                        dest.value = response.destinationAddresses[0];
                                        orig.value = response.originAddresses[0];
                                        dist.value = response.rows[0].elements[0].distance.text;
                                    } 
                                    else {
                                        alert("Error: " + status);
                                    }
                                }

                            } // tutup fungsi e ketika klik
		}); // tutup instansiasi gmaps         
                
            }); // tutup JQuery    
	</script>
	

	</div> <!--/ .main -->
 
</div> <!--container-->


<div class="induk-footer">
	<div class="footer">
		<h4>Footer</h4>
		<p>Copyright &copy; 2017 <a href="#">Travlendar 2A JTK with Tutorial-webdesign.com</a></p>
	</div> <!--/ .footer -->
</div> <!--induk-footer-->

</body>
</html>