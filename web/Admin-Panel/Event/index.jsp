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
        
        <%@include file="../Header/header.jsp" %>

<div class="wadah">
	
	<div class="main">
		
            <%@include file="../Sidebar/sidebar.jsp" %>
          
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
                                    <input class="k-event" type="text" style="width: 300px">
                                    <br>
                                    <input class="k-event" id="date" type="date" value="2017-09-08" style="float:left"/> 
                                    <div class="lendar"> <img src="../Assets2/icon/calendar-event.png"> </div>
                                    <br>
                                    <input class="k-event" id="time" type="time" style="width: 120px" value="00:00"/>:
                                    <input class="k-event" id="time" type="time" style="width: 120px" value="00:00"/>
                                    <br>
                                    
                                    <input class="k-event" id="date" type="date" value="2017-09-08" style="float:left;"/>
                                    <div class="lendar"> <img src="../Assets2/icon/calendar-event.png"> </div>
                                    <br>
                                    <input class="k-event" id="time" type="time" style="width: 120px" value="00:00"/>:
                                    <input class="k-event" id="time" type="time" style="width: 120px" value="00:00"/>
                                    <br>
                                    <input class="k-event" type="text" style="width: 300px">
                                    <br>
                                    <input class="k-event" type="text" style="width: 300px; height: 100px">
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
                                    <div class="k-textna">Arrival Time</div>
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
                                    <input class="k-event" id="time" type="time" style="width: 120px" value="00:00"/>:
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
                                    <input class="k-event" id="time" type="time" style="width: 120px" value="00:00"/>:
                                    <input class="k-event" id="time" type="time" style="width: 120px" value="00:00"/>
                                    <br>
                                    <input class="k-event" type="text" placeholder=""/> Km
                                    <br>
                                    <br>
                                    <br>
                                    <br>
                                    <br>
                                <a href="../CalendarEvent/index.jsp"> <button class="save"> Save </button></a>
                            </div>
                                
			</div> <!--kotakna-->
	
			
		</div> <!--/ .Kotak-traveller -->

		
	</div> <!--/ .middle -->
        </div> <!--/ .main--> 
 			
 
</div> <!--wadah-->

<%@include file="../Footer/footer.jsp" %>

    </body>
</html>
