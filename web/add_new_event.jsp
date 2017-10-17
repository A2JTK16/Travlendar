<%--
    Document   : add_new_event
    Created on : Oct 15, 2017, 7:34:17 PM
    Author     : Agit
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

<div class="wadah2">
	
	<div class="main">
		
        	<div class="middle-center">
                    <div class="judul-manage"> MANAGE TRAVELLER </div>   

		</div> <!--middle-->
		
		<div class="middle-center">

                    
			<div class="kotak-traveller">
                            <div class="kotakna">
                                <div class="k-text">
                                    <div class="k-textna">Event Name</div>
                                    <div class="k-textna">Start Event</div>
                                    <div class="k-textna"> </div>
                                    <div class="k-textna"> </div>
                                    <div class="k-textna">End Event</div>
                                    <div class="k-textna"> </div>
                                    <div class="k-textna"> </div>
                                    <div class="k-textna">Event Location</div>
                                    <div class="k-textna">Note</div>
                                </div>
                                <div class="k-input">
                                    <input class="k-event" type="text" style="width: 300px">
                                    <br>
                                    <input class="k-event" id="date" type="date" value="2017-09-08" style="float:left"/> 
                                    <div class="lendar"> <img src="Assets/icon/calendar-event.png"> </div>
                                    <br>
                                    <input class="k-event" id="time" type="time" style="width: 120px" value="00:00"/>
                                    <br>
                                    
                                    <input class="k-event" id="date" type="date" value="2017-09-08" style="float:left;"/>
                                    <div class="lendar"> <img src="Assets/icon/calendar-event.png"> </div>
                                    <br>
                                    <input class="k-event" id="time" type="time" style="width: 120px" value="00:00"/>
                                    <br>
                                    <input class="k-event" type="text" style="width: 300px">
                                    <br>
                                    <input class="k-event" type="text" style="width: 300px; height: 100px">
                                  
                                    <br>
                                    <br>
                                    <a href="halaman_utama.jsp"> <button class="back" style="float: left"> Back </button></a>
                                </div>
                                <br>
                                
                            </div>
                            
                            <div class="kotakna">
                                <div class="k-text">
                                    <div class="k-textna">Initial Location</div>
                                    <div class="k-textna"> </div>
                                    <div class="k-textna"> </div>
                                    <div class="k-textna">Departure Time</div>
                                    <div class="k-textna">Destination</div>
                                    <div class="k-textna"> </div>
                                    <div class="k-textna"> </div>
                                    <div class="k-textna">Distance</div>
                                </div>
                                
                                <div class="k-input">
                                    <select class="k-event">
                                        <option value="StartingLocation">Province ...</option>
                                        <option value="SLocation1">Jawa Barat</option>
                                        <option value="SLocation2">Jakarta</option>
                                        <option value="SLocation3">Bangka</option>
                                    </select>
                                    
                                    <select class="k-event">
                                        <option value="StartingLocation">City ...</option>
                                        <option value="SLocation1">Bandung</option>
                                                                     <option value="SLocation2">Bekasi</option>
                                                                     <option value="SLocation3">Bogor</option>
                                                                     <option value="SLocation4">Ciamis</option>
                                                                     <option value="SLocation5">Cirebon</option>
                                                                     <option value="SLocation6">Indramayu</option>
                                                                     <option value="SLocation6">Kuningan</option>
                                                                     <option value="SLocation6">Kuningan</option>
                                                                     <option value="SLocation6">Majalengka</option>
                                                                     <option value="SLocation6">Pangandaran</option>
                                                                     <option value="SLocation6">Purwakarta</option>
                                                                     <option value="SLocation6">Subang</option>
                                                                     <option value="SLocation6">Sukabumi</option>
                                                                     <option value="SLocation6">Sumedang</option>
                                                                     <option value="SLocation6">Tasikmalaya</option>
                                    </select>
                                    <br>
                                    <input class="k-event" type="text" placeholder="detail ..."/>
                                    <br>
                                    <input class="k-event" id="time" type="time" style="width: 120px" value="00:00"/>
                                    <br>
                                    <select class="k-event">
                                        <option value="StartingLocation">Province ...</option>
                                        <option value="SLocation1">Jawa Barat</option>
                                        <option value="SLocation2">Jakarta</option>
                                        <option value="SLocation3">Bangka</option>
                                    </select>
                                    
                                    <select class="k-event">
                                        <option value="StartingLocation">City ...</option>
                                        <option value="SLocation1">Bandung</option>
                                                                     <option value="SLocation2">Bekasi</option>
                                                                     <option value="SLocation3">Bogor</option>
                                                                     <option value="SLocation4">Ciamis</option>
                                                                     <option value="SLocation5">Cirebon</option>
                                                                     <option value="SLocation6">Indramayu</option>
                                                                     <option value="SLocation6">Kuningan</option>
                                                                     <option value="SLocation6">Kuningan</option>
                                                                     <option value="SLocation6">Majalengka</option>
                                                                     <option value="SLocation6">Pangandaran</option>
                                                                     <option value="SLocation6">Purwakarta</option>
                                                                     <option value="SLocation6">Subang</option>
                                                                     <option value="SLocation6">Sukabumi</option>
                                                                     <option value="SLocation6">Sumedang</option>
                                                                     <option value="SLocation6">Tasikmalaya</option>
                                    </select>
                                    <br>
                                    <input class="k-event" type="text" placeholder="detail ..."/>
                                    <br>
                                    <input class="k-event" type="text" placeholder=""/> Km
                                    <br>
                                    <br>
                                    <br>
                                    <br>
                                    <br>
                                    <button id="myBtn" style="float: right"> Next → </button>
				<!-- The Modal -->
				<div id="myModal" class="modal">

				  <!-- Modal content -->
				  <div class="modal-content">
				    	
							  <div class="form">
							    <div class="modal-header">
							      <span class="close">&times;</span>
							      <h5>Select Your Transportation Mode</h5>
                                                              
							    </div>
                                                              <div class="k-popup">
                                                                  <div class="k-transport">
                                                                      <div class="trans"> <img src="Assets/icon/air2.png"> </div>
                                                                      <br> ⭙
                                                                  </div>
                                                                   <div class="k-transport">
                                                                      <div class="trans"> <img src="Assets/icon/train.png"> </div>
                                                                      <br> ⭙
                                                                  </div>
                                                                   <div class="k-transport">
                                                                      <div class="trans"> <img src="Assets/icon/car.png"> </div>
                                                                      <form> <input type="radio" name="transtime" value="cartime"> 40m </form>
                                                                  </div>
                                                                   <div class="k-transport">
                                                                      <div class="trans"> <img src="Assets/icon/motor3.png"> </div>
                                                                      <form> <input type="radio" name="transtime" value="motortime"> 25m </form>
                                                                  </div>
                                                                   <div class="k-transport">
                                                                      <div class="trans"> <img src="Assets/icon/walk.png"> </div>
                                                                      <form> <input type="radio" name="transtime" value="walktime"> 4h 15m </form>
                                                                  </div>                                                                  
                                                                  
                                                              </div>
							    
							  </div>
							
				  </div> <!--modal content-->

                                  <script>
			
				function show()
				{
					if(document.getElementById("hidden-mobile").style.display == 'none')
						document.getElementById("hidden-mobile").style.display = 'block';
					else
						document.getElementById("hidden-mobile").style.display = 'none';
				}
				
				// Get the modal
				var modal = document.getElementById('myModal');

				// Get the button that opens the modal
				var btn = document.getElementById("myBtn");

				// Get the <span> element that closes the modal
				var span = document.getElementsByClassName("close")[0];

				// When the user clicks the button, open the modal 
				btn.onclick = function() {
				    modal.style.display = "block";
				}

				// When the user clicks on <span> (x), close the modal
				span.onclick = function() {
				    modal.style.display = "none";
				}

				// When the user clicks anywhere outside of the modal, close it
				window.onclick = function(event) {
				    if (event.target == modal) {
				        modal.style.display = "none";
				    }
				}
			</script>
 
                                  
	           </div>
                                
                                            <div class="modal-body">
                                                <p> </p>
                                                <p> </p>
                                                <p> </p>
                                                <p> </p>
                                                <p> </p>
                                            </div>
                                        </div>
                                    </div>
                                    
                            </div>
                                
			</div> <!--kotakna-->
	
			
		</div> <!--/ .Kotak-traveller -->


</div> <!--wadah-->

<%@include file="footer.jsp" %>

    </body>
</html>
