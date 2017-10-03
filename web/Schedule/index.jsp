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
				<div class="judul-manage"> MANAGE SCHEDULE </div>
				<button id="myBtn"> + Add New Schedule </button>
				<!-- The Modal -->
				<div id="myModal" class="modal">

				  <!-- Modal content -->
				  <div class="modal-content">
				    	
							  <div class="form">
							  	<div class="modal-header">
							      <span class="close">&times;</span>
							      <h5>Add New Schedule</h5>
							    </div>
							    <form class="register-form" action="utama.html" method="POST">
							      <input type="text" placeholder="name"/>
							      <input type="password" placeholder="password"/>
							      <input type="text" placeholder="email address"/>
							      <button>create</button>
							      <p class="message">Already registered? <a href="#">Sign In</a></p>
							    </form>
							    <form class="login-form">
                                                              <select class="dropdown-location">
                                                                     <option value="StartingLocation">Starting Location ...</option>
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
							        <select class="dropdown-location">
                                                                     <option value="StartingLocation">Destination Location ...</option>
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
							      <input type="text" placeholder="Start Date..."/>
                                                              <select class="dropdown-time">
                                                                     <option value="StartingLocation">Hours</option>
                                                                     <option value="SLocation1">01</option>
                                                                     <option value="SLocation2">02</option>
                                                                     <option value="SLocation3">03</option>
                                                                     <option value="SLocation4">04</option>
                                                                     <option value="SLocation5">05</option>
                                                                     <option value="SLocation6">06</option>
                                                                     <option value="SLocation6">07</option>
                                                                     <option value="SLocation6">08</option>
                                                                     <option value="SLocation6">09</option>
                                                                     <option value="SLocation6">10</option>
                                                                     <option value="SLocation6">11</option>
                                                                     <option value="SLocation6">12</option>
                                                              </select>
                                                              
                                                              <select class="dropdown-time">
                                                                     <option value="StartingLocation">Minute</option>
                                                                     <option value="SLocation1">01</option>
                                                                     <option value="SLocation2">02</option>
                                                                     <option value="SLocation3">03</option>
                                                                     <option value="SLocation4">04</option>
                                                                     <option value="SLocation5">05</option>
                                                                     <option value="SLocation6">06</option>
                                                                     <option value="SLocation6">07</option>
                                                                     <option value="SLocation6">08</option>
                                                                     <option value="SLocation6">09</option>
                                                                     <option value="SLocation6">10</option>
                                                                     <option value="SLocation6">11</option>
                                                                     <option value="SLocation6">12</option>
                                                              </select>
                                                              
							      <input type="text" placeholder="End Date..."/>
                                                                     <select class="dropdown-time">
                                                                     <option value="StartingLocation">Hours</option>
                                                                     <option value="SLocation1">01</option>
                                                                     <option value="SLocation2">02</option>
                                                                     <option value="SLocation3">03</option>
                                                                     <option value="SLocation4">04</option>
                                                                     <option value="SLocation5">05</option>
                                                                     <option value="SLocation6">06</option>
                                                                     <option value="SLocation6">07</option>
                                                                     <option value="SLocation6">08</option>
                                                                     <option value="SLocation6">09</option>
                                                                     <option value="SLocation6">10</option>
                                                                     <option value="SLocation6">11</option>
                                                                     <option value="SLocation6">12</option>
                                                              </select>
                                                              
                                                              <select class="dropdown-time">
                                                                     <option value="StartingLocation">Minute</option>
                                                                     <option value="SLocation1">01</option>
                                                                     <option value="SLocation2">02</option>
                                                                     <option value="SLocation3">03</option>
                                                                     <option value="SLocation4">04</option>
                                                                     <option value="SLocation5">05</option>
                                                                     <option value="SLocation6">06</option>
                                                                     <option value="SLocation6">07</option>
                                                                     <option value="SLocation6">08</option>
                                                                     <option value="SLocation6">09</option>
                                                                     <option value="SLocation6">10</option>
                                                                     <option value="SLocation6">11</option>
                                                                     <option value="SLocation6">12</option>
                                                              </select>
							      <button> Save </button>							     
							    </form>
							  </div>
							
				  </div> <!--modal content-->

				</div>

		</div> <!--middle-->
		
		<div class="middle">
		
			<div class="kotak-traveller">
				<h4> List Of Schedule </h4>
				<div class="kotak-search">
					<div class="icon-search">
						<img src="${pageContext.request.contextPath}/Assets2/icon/search.png">
					</div> <!--icon-search-->
					<input class="search "type="text" placeholder="Search Schedule ... "/>
				</div> <!--kotak-search-->
			</div> <!--kotak-traveller-->
	
			<div class="kotak-traveller">
					<table>
						<thead>
						<tr>
							<th>ID</th>
							<th>Event Name</th>
							<th>Start Location</th>
							<th>Destination Location</th>
                                                        <th>Started Time</th>
                                                        <th>Ended Time</th>
							<th>Action</th>
						</tr>
						</thead>
						<tbody>
						<tr>
							<td>01</td>
                                                        <td>Pergi ke Kantor</td>
							<td>Home</td>
                                                        <td>Kantor DPRD Jakarta</td>
                                                        <td>05:20</td>
                                                        <td>06:30</td>
							<td> <a class="action" href="edit.jsp">Edit </a> <a class="action2" onclick="return konfirmasi()" href="#"> Delete </a> </td>
						</tr>
						
                                                
                                                <tr>
							<td>02</td>
                                                        <td>Menjemput Bapak</td>
							<td>Nobu Ramen & Sushi</td>
                                                        <td>Terminal Leuwipanjang</td>
                                                        <td>07:30</td>
                                                        <td>10:00</td>
							<td> <a class="action" href="edit.jsp">Edit </a> <a class="action2" onclick="return konfirmasi()" href="#"> Delete </a> </td>
						</tr>
						
                                                <tr>
							<td>03</td>
                                                        <td>Seminar Multimedia</td>
							<td>Home</td>
                                                        <td>UPI</td>
                                                        <td>08:00</td>
                                                        <td>09:30</td>
							<td> <a class="action" href="edit.jsp">Edit </a> <a class="action2" onclick="return konfirmasi()" href="#"> Delete </a> </td>
						</tr>
                                                
                                                 <tr>
							<td>04</td>
                                                        <td>Web Design Competition</td>
							<td>Polban</td>
                                                        <td>UI</td>
                                                        <td>05:20</td>
                                                        <td>10:00</td>
							<td> <a class="action" href="edit.jsp">Edit </a> <a class="action2" onclick="return konfirmasi()" href="#"> Delete </a> </td>
						</tr>
						
                                                
                                                 <tr>
							<td>05</td>
                                                        <td>Rapat</td>
							<td>Home</td>
                                                        <td>Kantor DPR</td>
                                                        <td>06:20</td>
                                                        <td>09:00</td>
							<td> <a class="action" href="edit.jsp">Edit </a> <a class="action2" onclick="return konfirmasi()" href="#"> Delete </a> </td>
						</tr>
                                                
                                                <script type="text/javascript" language="JavaScript">
                                                function konfirmasi()
                                                {
                                                tanya = confirm("Anda Yakin Akan Menghapus Data ?");
                                                if (tanya == true) return true;
                                                else return false;
                                                }</script>
									
						
						</tbody>
					</table>
			</div> <!--kotak-traveller-->
                        
                        <div class="kotak-traveller">
					<div class="pagination">
						<a href="index.html" class="page active">first</a><a href="#" class=
						"page"> 2 </a><a href="index.html" class="page"> 3 </a><span
						class="page"> 4 </span><a href="index.html" class=
						"page"> 5 </a><a href="index.html" class="page"> 6 </a><a href="index.html"
						class="page">last</a>
					</div>
			</div> <!--kotak-traveller-->
			
			
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

<%@include file="../Footer/footer.jsp" %>

    </body>
</html>
