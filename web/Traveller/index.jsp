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
        <div class="jarak-atas">

</div> <!--jarak-atas-->

<div class="menu-atas">
	<div class="header">
		<h1> LOGO </h1>
	</div> <!--header-->
</div> <!--menu-atas-->

<div class="wadah">
	
	<div class="main">
		
		<div class="left">
			<h3>Administrator</h3>
			
			<div class="hides">
			
				<button onclick="javascript:show()">
				|||
				</button>
			
			</div>

			
			<div id="hidden-mobile">
			
			
			<div class="menu-manage">
				<div class="icon-setting">
					<img src="${pageContext.request.contextPath}/Assets2/icon/setting.png">
				</div> <!--icon-setting-->
				<h2><a href="../Traveller/index.jsp">Traveller</a></h2>
	
			</div> <!--menu-manage-->
			
			<div class="menu-manage">
				<div class="icon-setting">
					<img src="${pageContext.request.contextPath}/Assets2/icon/setting.png">
				</div> <!--icon-setting-->
                                <h2><a href="../Location/index.jsp">Location </a></h2>
			</div>
			
			<div class="menu-manage">
				<div class="icon-setting">
					<img src="${pageContext.request.contextPath}/Assets2/icon/setting.png">
				</div> <!--icon-setting-->
                                <h2><a href="../TransportationMode/index.jsp">Transportation Mode </a></h2>
			</div> <!--menu-manage-->
			
			<div class="menu-manage">
				<div class="icon-setting">
					<img src="${pageContext.request.contextPath}/Assets2/icon/setting.png">
				</div> <!--icon-setting-->
				<h2> <a href="../DistanceMatrix/index.jsp">Distance Matrix </a></h2>
			</div>
			
			<div class="menu-manage">
				<div class="icon-setting">
					<img src="${pageContext.request.contextPath}/Assets2/icon/setting.png">
				</div> <!--icon-setting-->
                                <h2><a href="../EstimationTime/index.jsp">Estimation Time</a></h2>
			</div> <!--menu-manage-->
			
			<div class="menu-manage">
				<div class="icon-setting">
					<img src="${pageContext.request.contextPath}/Assets2/icon/setting.png">
				</div> <!--icon-setting-->
                                <h2><a href="../CalendarEvent/index.jsp">Calendar Event</a></h2>
			</div>
			
			</div>
			
		</div> <!--/ .header -->

		<div class="middle">
				<div class="judul-manage"> MANAGE TRAVELLER </div>
				<button id="myBtn"> + Add New Traveller </button>
				<!-- The Modal -->
				<div id="myModal" class="modal">

				  <!-- Modal content -->
				  <div class="modal-content">
				    	
							  <div class="form">
							  	<div class="modal-header">
							      <span class="close">&times;</span>
							      <h5>Add New Travlendar</h5>
							    </div>
							    <form class="register-form" action="utama.html" method="POST">
							      <input type="text" placeholder="name"/>
							      <input type="password" placeholder="password"/>
							      <input type="text" placeholder="email address"/>
							      <button>create</button>
							      <p class="message">Already registered? <a href="#">Sign In</a></p>
							    </form>
							    <form class="login-form">
							      <input type="text" placeholder="Fullname ..."/>
							      <input type="text" placeholder="Username ..."/>
							      <input type="text" placeholder="Email ..."/>
							      <input type="text" placeholder="Password ..."/>
							      <button> Save </button>							     
							    </form>
							  </div>
							
				  </div> <!--modal content-->

				</div>

		</div> <!--middle-->
		
		<div class="middle">
		
			<div class="kotak-traveller">
				<h4> List Of Traveller </h4>
				<div class="kotak-search">
					<div class="icon-search">
						<img src="${pageContext.request.contextPath}/Assets2/icon/search.png">
					</div> <!--icon-search-->
					<input class="search "type="text" placeholder="Search Traveller ... "/>
				</div> <!--kotak-search-->
			</div> <!--kotak-traveller-->
	
			<div class="kotak-traveller">
					<table>
						<thead>
						<tr>
							<th>ID</th>
							<th>Fullname</th>
							<th>Username</th>
							<th>Email</th>
							<th>Action</th>
						</tr>
						</thead>
						<tbody>
						<tr>
							<td>01</td>
							<td>Faiz Abdusallam</td>
							<td>Faiz</td>
							<td>faiz@polban.ac.id</td>
							<td> <a class="action" href="edit.jsp">Edit </a> <a class="action2" onclick="myFunction()"> Delete </a> </td>
						</tr>
						
						<tr>
							<td>02</td>
							<td>Said Al Fakhri</td>
							<td>Said</td>
							<td>Said@polban.ac.id</td>
							<td> <a class="action" href="edit.jsp">Edit </a> <a class="action2" onclick="myFunction()"> Delete </a> </td>
						</tr>
						
						<tr>
							<td>03</td>
							<td>Dede Diana</td>
							<td>Diana</td>
							<td>diana@polban.ac.id</td>
							<td> <a class="action" href="edit.jsp">Edit </a> <a class="action2" onclick="myFunction()"> Delete </a> </td>
						</tr>
						
						<tr>
							<td>04</td>
							<td>Alfin Jastinera</td>
							<td>Alfin</td>
							<td>alfin@polban.ac.id</td>
							<td> <a class="action" href="edit.jsp">Edit </a> <a class="action2" onclick="myFunction()"> Delete </a> </td>
						</tr>
						
						
						<tr>
							<td>05</td>
							<td>Agit Prasetya</td>
							<td>Agit</td>
							<td>agit@polban.ac.id</td>
							<td> <a class="action" href="edit.jsp">Edit </a> <a class="action2" onclick="myFunction()"> Delete </a> </td>
						</tr>
						
						<tr>
							<td>06</td>
							<td>Maulana Ibrahim</td>
							<td>Maul</td>
							<td>maul@polban.ac.id</td>
							<td> <a class="action" href="edit.jsp">Edit </a> <a class="action2" onclick="myFunction()"> Delete </a> </td>
						</tr>
						
						<tr>
							<td>07</td>
							<td>Mufid Jamaluddin</td>
							<td>Mufid</td>
							<td>mufid@polban.ac.id</td>
							<td> <a class="action" href="edit.jsp">Edit </a> <a class="action2" onclick="myFunction()"> Delete </a> </td>
						</tr>
						
						<tr>
							<td>08</td>
							<td>Putri Dian</td>
							<td>Dian</td>
							<td>putridian@polban.ac.id</td>
							<td> <a class="action" href="edit.jsp">Edit </a> <a class="action2" onclick="myFunction()"> Delete </a> </td>
						</tr>
                                                
                                                <tr>
							<td>09</td>
							<td>Reza Dwi Kurniawan</td>
							<td>Reza</td>
							<td>reza@polban.ac.id</td>
							<td> <a class="action" href="edit.jsp">Edit </a> <a class="action2" onclick="myFunction()"> Delete </a> </td>
						</tr>
                                                
                                                <tr>
							<td>10</td>
							<td>Putri Dian</td>
							<td>Dian</td>
							<td>putridian@polban.ac.id</td>
							<td> <a class="action" href="edit.jsp">Edit </a> <a class="action2" onclick="myFunction()"> Delete </a> </td>
						</tr>
						
                                                <script>
						function myFunction() {
							alert("Delete Sucsess");
						}
						</script>
									
						
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

<div class="footer-atas">
	
	</div> <!--footer-atas-->

	<div class="footer-bawah">
    <div class="footer">
        <div class="copyright">
        travelendar.com
        </div> <!--copyright-->

        <div class="copyright2">
        Copyright &copy; 2017 travlendar.com | Designed by A2 JTK Polban
        </div>
    </div>
</div> <!--footer-bawah-->
    </body>
</html>
