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

<%@include file="../Header/header.jsp" %>

<div class="wadah">
	
	<div class="main">
		
		<%@include file="../Sidebar/sidebar.jsp" %>

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
                                                                     <option value="SLocation1">Bandung</option>
                                                                     <option value="SLocation2">Bekasi</option>
                                                                     <option value="SLocation3">Bogor</option>
                                                                     <option value="SLocation4">Ciamis</option>
                                                                     <option value="SLocation5">Cirebon</option>
                                                                     <option value="SLocation6">Indramayu</option>
                                                                     <option value="SLocation7">Kuningan</option>
                                                                     <option value="SLocation8">Majalengka</option>
                                                                     <option value="SLocation9">Pangandaran</option>
                                                                     <option value="SLocation11">Purwakarta</option>
                                                                     <option value="SLocation12">Subang</option>
                                                                     <option value="SLocation13">Sukabumi</option>
                                                                     <option value="SLocation14">Sumedang</option>
                                                                     <option value="SLocation15">Tasikmalaya</option>
                                                                </select>
							        <select class="dropdown-location">
                                                                     <option value="Destination">Destination ...</option>
                                                                     <option value="DLocation1">Bandung</option>
                                                                     <option value="DLocation2">Bekasi</option>
                                                                     <option value="DLocation3">Bogor</option>
                                                                     <option value="DLocation4">Ciamis</option>
                                                                     <option value="DLocation5">Cirebon</option>
                                                                     <option value="DLocation6">Indramayu</option>
                                                                     <option value="DLocation7">Kuningan</option>
                                                                     <option value="DLocation8">Majalengka</option>
                                                                     <option value="DLocation9">Pangandaran</option>
                                                                     <option value="DLocation11">Purwakarta</option>
                                                                     <option value="DLocation12">Subang</option>
                                                                     <option value="DLocation13">Sukabumi</option>
                                                                     <option value="DLocation14">Sumedang</option>
                                                                     <option value="DLocation15">Tasikmalaya</option>
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
                                <div class="kotak-search">
					<div class="icon-search">
						<img src="${pageContext.request.contextPath}/Assets2/icon/search.png">
					</div> <!--icon-search-->
					<input class="search "type="text" placeholder="Search Here ... "/>
				</div> <!--kotak-search-->
			</div> <!--kotak-traveller-->
	
			<div class="kotak-traveller">
					<table>
						<thead>
						<tr>
							<th>Starting Location</th>
							<th>Destination</th>
							<th>Distance (km)</th>
							<th style="width: 125px">Action</th>
						</tr>
						</thead>
						<tbody>
						<tr>
							<td>Bandung</td>
							<td>Bekasi</td>
							<td>40</td>
                                                	<td> <a class="action" href="edit.jsp">Edit </a> <a class="action2" onclick="return konfirmasi()"> Delete </a> </td>
						</tr>
						
						<tr>
							<td>Bandung</td>
							<td>Bogor</td>
							<td>98</td>
							<td> <a class="action" href="edit.jsp">Edit </a> <a class="action2" onclick="return konfirmasi()"> Delete </a> </td>
						</tr>
						
						<tr>
							<td>Bandung</td>
							<td>Ciamis</td>
							<td>847</td>
							<td> <a class="action" href="edit.jsp">Edit </a> <a class="action2" onclick="return konfirmasi()"> Delete </a> </td>
						</tr>
						
						<tr>
							<td>Bandung</td>
							<td>Pangandaran</td>
							<td>875.3</td>
							<td> <a class="action" href="edit.jsp">Edit </a> <a class="action2" onclick="return konfirmasi()"> Delete </a> </td>
						</tr>
						
						
						<tr>
							<td>Bandung</td>
							<td>Cirebon</td>
							<td>904.6</td>
							<td> <a class="action" href="edit.jsp">Edit </a> <a class="action2" onclick="return konfirmasi()"> Delete </a> </td>
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
			</div> <!--kotak-distance-->
                        
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