<%-- 
    Document   : index
    Created on : Sep 21, 2017, 1:52:12 PM
    Author     : Alpin J
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
				<div class="judul-manage"> MANAGE LOCATION </div>
				<button id="myBtn"> + Add New Location </button>
				<!-- The Modal -->
				<div id="myModal" class="modal">

				  <!-- Modal content -->
				  <div class="modal-content">
				    	
							  <div class="form">
							  	<div class="modal-header">
							      <span class="close">&times;</span>
							      <h5>Add New Location</h5>
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
                                                                    <option value="SLocation0">Jawa Barat</option>
                                                                    <option value="SLocation1">Jakarta</option>
                                                                    <option value="SLocation2">Banten</option>
                                                                    <option value="SLocation3">Jawa Tengah</option>
                                                                    <option value="SLocation4">Jawa TImur</option>
                                                                </select>
							      <input type="text" placeholder="City Name ..."/>
							      <button> Save </button>
                                                              <%--<p class="message">Not registered? <a href="#">Create an account</a></p>--%>
							    </form>
							  </div>
							
				  </div> <!--modal content-->

				</div>

		</div> <!--middle-->
		
		<div class="middle">
		
			<div class="kotak-traveller">
				<h4> List Of Location </h4>
                                <select class="dropdown-location-choose">
                                    <option value="SLocation0">Jawa Barat</option>
                                    <option value="SLocation1">Jakarta</option>
                                    <option value="SLocation2">Banten</option>
                                    <option value="SLocation3">Jawa Tengah</option>
                                    <option value="SLocation4">Jawa TImur</option>
                                </select>
				<!--<div class="kotak-search">
					<div class="icon-search">
						<img src="../Assets2/icon/search.png">
					</div> 
					<input class="search "type="text" placeholder="Search Traveller ... "/>
				</div> -->
			</div> <!--kotak-traveller-->
	
			<div class="kotak-traveller">
					<table>
						<thead>
						<tr>
							<th>ID</th>
                                                        <th>City</th>
							<th>Action</th>
						</tr>
						</thead>
						<tbody>
						<tr>
							<td>001</td>
							<td>Bandung</td>							
							<td> <a class="action" href="edit.jsp">Edit </a> <a class="action2" onclick="return konfirmasi()" href="#"> Delete </a> </td>
						</tr>
                                                
                                                <tr>
							<td>002</td>
							<td>Garut</td>
							<td> <a class="action" href="edit.jsp">Edit </a> <a class="action2" onclick="return konfirmasi()" href="#"> Delete </a> </td>
                                                
                                                <tr>
							<td>003</td>
							<td>Tasikmalaya</td>
							<td> <a class="action" href="edit.jsp">Edit </a> <a class="action2" onclick="return konfirmasi()" href="#"> Delete </a> </td>
						</tr>
						
                                                <tr>
							<td>004</td>
							<td>Sumedang</td>
							<td> <a class="action" href="edit.jsp">Edit </a> <a class="action2" onclick="return konfirmasi()" href="#"> Delete </a> </td>
						</tr>
                                                
                                                <tr>
							<td>005</td>
							<td>Cirebon</td>
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

<%@include file="../Teamplate/Footer/footer.jsp" %>
    </body>
</html>
