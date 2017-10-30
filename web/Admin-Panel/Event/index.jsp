<%-- 
    Document   : index
    Created on : Sep 21, 2017, 12:03:59 PM
    Author     : Diana
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/Assets2/css/styletraveller.css">
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/Assets2/css/responsive.css">
        <title>JSP Page</title>
    </head>
    <body>
        
        <%@include file="../Teamplate/Header/header.jsp" %>

<div class="wadah">
	
	<div class="main">
		
            <%@include file="../Teamplate/Sidebar/sidebar.jsp" %>
          
		<div class="middle">
                    <div class="judul-manage"> MANAGE TRAVELLER </div>   

		</div> <!--middle-->
		
		<div class="middle">
                        
                    <div class="kotak-traveller">
                        <h4> Add New Event Maryam </h4>
                    </div>
                    
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
                                    <input class="k-event" type="text" name="EVENT_NAME" style="width: 300px">
                                    <br>
                                    <input class="k-event" id="date" type="date" name="START_EVENT" value="2017-09-08" style="float:left"/> 
                                    <div class="lendar"> <img src="../Assets2/icon/calendar-event.png"> </div>
                                    <br>
                                    <input class="k-event" id="time" type="time" style="width: 120px" value="00:00"/>
                                    <br>
                                    
                                    <input class="k-event" id="date" type="date" name="END_EVENT" value="2017-09-08" style="float:left;"/>
                                    <div class="lendar"> <img src="../Assets2/icon/calendar-event.png"> </div>
                                    <br>
                                    <input class="k-event" id="time" type="time" style="width: 120px" value="00:00"/>
                                    <br>
                                    <input class="k-event" type="text" name="PLACE" style="width: 300px">
                                    <br>
                                    <input class="k-event" type="text" name="NOTE" style="width: 300px; height: 100px">
                                </div>
                                <br>
                                <a href="../CalendarEvent/index.jsp"> <button class="back"> Back </button></a>
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
                                        <option value="StartingLocation" type="text" name="PROVINCE_NAME">Province ...</option>
                                        <option value="SLocation1">Jawa Barat</option>
                                        <option value="SLocation2">Jakarta</option>
                                        <option value="SLocation3">Bangka</option>
                                    </select>
                                    
                                    <select class="k-event">
                                        <option value="StartingLocation" type="text" name="CITY_NAME">City ...</option>
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
                                        <option value="StartingLocation" type="text" name="PROVINCE_NAME">Province ...</option>
                                        <option value="SLocation1">Jawa Barat</option>
                                        <option value="SLocation2">Jakarta</option>
                                        <option value="SLocation3">Bangka</option>
                                    </select>
                                    
                                    <select class="k-event">
                                        <option value="StartingLocation" type="text" name="CITY_NAME">City ...</option>
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
                                    <input class="k-event" type="text" name="DISTANCE" placeholder=""/> Km
                                    <br>
                                    <br>
                                    <br>
                                    <br>
                                    <br>
                                    <br>
                                    <br>
                                    <br>
                                <button id="myBtnnext" style="float: right"> Next → </button>
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
                                                                      <div class="trans"> <img src="../Assets2/icon/air2.png"> </div>
                                                                      <br> ⭙
                                                                  </div>
                                                                   <div class="k-transport">
                                                                      <div class="trans"> <img src="../Assets2/icon/train.png"> </div>
                                                                      <br> ⭙
                                                                  </div>
                                                                   <div class="k-transport">
                                                                      <div class="trans"> <img src="../Assets2/icon/car.png"> </div>
                                                                      <div class="radiona"><input type="radio" name="transtime" value="cartime"> 40m</div> 
                                                                  </div>
                                                                   <div class="k-transport">
                                                                      <div class="trans"> <img src="../Assets2/icon/motor3.png"> </div>
                                                                      <div class="radiona"><input type="radio" name="transtime" value="motortime"> 25m</div>
                                                                  </div>
                                                                   <div class="k-transport">
                                                                      <div class="trans"> <img src="../Assets2/icon/walk.png"> </div>
                                                                      <div class="radiona"><input type="radio" name="transtime" value="walktime"> 4h 15m</div>
                                                                  </div>                                                                  
                                                                  <button id="myBtnsave">Save</button>
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
				var btn = document.getElementById("myBtnnext");

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
                                
			</div> <!--kotakna-->
	
			
		</div> <!--/ .Kotak-traveller -->

		
	</div> <!--/ .middle -->
        </div> <!--/ .main--> 
        </div>		
 
</div> <!--wadah-->

<%@include file="../Teamplate/Footer/footer.jsp" %>

    </body>
</html>
