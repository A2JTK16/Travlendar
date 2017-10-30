<%-- 
    Document   : index
    Created on : Sep 21, 2017, 1:17:03 PM
    Author     : Agit
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
				<div class="judul-manage"> MANAGE DISTANCE MATRIX </div>
				<button id="myBtn"> + Add New Distance Matrix </button>
				<!-- The Modal -->
				<div id="myModal" class="modal">

				  <!-- Modal content -->
				  <div class="modal-content">
				    	
							  <div class="form">
							  	<div class="modal-header">
							      <span class="close">&times;</span>
							      <h5>Add New Distance Matrix</h5>
							    </div>

							    <form class="distance-form">
                                                                <select class="dropdown-location">
                                                                     <option value="StartingLocation">Starting Location ...</option>
                                                                     <option value="SLocation1">Rumah</option>
                                                                     <option value="SLocation2">Kantor DPRD Bangka Tengah</option>
                                                                     <option value="SLocation3">Bandara Depati Amir</option>
                                                                     <option value="SLocation4">Bandara Soekarno Hatta</option>
                                                                     <option value="SLocation5">Kantor DPRD Jakarta</option>
                                                                     <option value="SLocation6">Tanggerang</option>
                                                                </select>
							        <select class="dropdown-location">
                                                                     <option value="Destination">Destination ...</option>
                                                                     <option value="SLocation1">Rumah</option>
                                                                     <option value="SLocation2">Kantor DPRD Bangka Tengah</option>
                                                                     <option value="SLocation3">Bandara Depati Amir</option>
                                                                     <option value="SLocation4">Bandara Soekarno Hatta</option>
                                                                     <option value="SLocation5">Kantor DPRD Jakarta</option>
                                                                     <option value="SLocation6">Tanggerang</option>
                                                                </select>
							      <input style="margin-top: 5px; color: #535559" type="text" placeholder="Distance (km)    ..."/>
							      <button> Save </button>
							    </form>
							  </div>
							
				  </div> <!--modal content-->

				</div>

		</div> <!--middle-->
		
		<div class="middle">
		
			<div class="kotak-traveller">
				<h4> Distance Matrix </h4>
                                <!--<div class="kotak-search">
					<div class="icon-search">
						<img src="../Assets2/icon/search.png">
					</div> 
					<input class="search "type="text" placeholder="Search Traveller ... "/>
				</div> -->
			</div> <!--kotak-traveller-->
	
			<div class="kotak-traveller">
                        
                            <div class="posisi-distance">
                            <div class="text-distance"> Province Name </div>
                                <select class="dropdown-location" type="text" name="PROVINCE_NAME" style="border:1px solid #ddd;">
                                                                    <option value="SLocation0">Jawa Barat</option>
                                                                    <option value="SLocation1">Jakarta</option>
                                                                    <option value="SLocation2">Banten</option>
                                                                    <option value="SLocation3">Jawa Tengah</option>
                                                                    <option value="SLocation4">Jawa TImur</option>
                                </select>
                            
                            <div class="text-distance"> City Name </div>
                            <select class="dropdown-location" type="text" name="PROVINCE_NAME" style="border:1px solid #ddd;">
                                                                    <option value="SLocation0">Bandung</option>
                                                                    <option value="SLocation1">Bekasi</option>
                                                                    <option value="SLocation2">Cirebon</option>
                                                                    <option value="SLocation3">Tasikmalaya</option>
                                                                    <option value="SLocation4">Kuningan</option>
                                </select>
                            </div> <!--posisi-distance-->
                            
                            <div class="To-distance"> To </div>
                            
                            <div class="posisi-distance">
                            <div class="text-distance"> Province Name </div>
                                <select class="dropdown-location" type="text" name="PROVINCE_NAME" style="border:1px solid #ddd;">
                                                                    <option value="SLocation0">Jawa Barat</option>
                                                                    <option value="SLocation1">Jakarta</option>
                                                                    <option value="SLocation2">Banten</option>
                                                                    <option value="SLocation3">Jawa Tengah</option>
                                                                    <option value="SLocation4">Jawa TImur</option>
                                </select>
                            
                            <div class="text-distance"> City Name </div>
                            <select class="dropdown-location" type="text" name="PROVINCE_NAME" style="border:1px solid #ddd;">
                                                                    <option value="SLocation0">Bandung</option>
                                                                    <option value="SLocation1">Bekasi</option>
                                                                    <option value="SLocation2">Cirebon</option>
                                                                    <option value="SLocation3">Tasikmalaya</option>
                                                                    <option value="SLocation4">Kuningan</option>
                                </select>
                            </div> <!--posisi-distance-->
                            
                            
                            <div class="posisi-distance">
                            <div class="text-distance"> Distance </div>
                                <input class="distancena" type="text" placeholder="                      ... Km"/> 
                            </div>
                            
                            
                            
			</div> <!--kotak-distance-->
                
			
		</div> <!--/ .middle -->

		
	</div> <!--/ .main -->

 
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
 
</div> <!--wadah-->

<%@include file="../Teamplate/Footer/footer.jsp" %>
    </body>
</html>