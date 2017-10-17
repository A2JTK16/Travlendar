<%-- 
    Document   : index
    Created on : Sep 21, 2017, 4:59:43 PM
    Author     : Nia
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
				<div class="judul-manage">MANAGE TRANSPORTATION MODE</div>
				<button id="myBtn"> + Add New TransportationMode </button>
				<!-- The Modal -->
				<div id="myModal" class="modal">

				  <!-- Modal content -->
				  <div class="modal-content">
				    	
							  <div class="form">
							  	<div class="modal-header">
							      <span class="close">&times;</span>
							      <h5>List Of Transportation Mode</h5>
							    </div>

							    <form class="distance-form">
                                                                <select class="dropdown-location">
                                                                     <option value="StartingLocation">Add Transportation Name ...</option>
                                                                     <option value="SLocation1">Car</option>
                                                                     <option value="SLocation2">Motorcycle</option>
                                                                     <option value="SLocation3">Bus</option>
                                                                     <option value="SLocation4">Wagon</option>
                                                                </select>
							       <input type="text" placeholder="Average Speed (km/h) ..."/>
							      <button> Save </button>
							    </form>
							  </div> <!--jenis transportasion-->
							
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
					<input class="search "type="text" placeholder="Search Transportation ... "/>
				</div> <!--kotak-search-->
			</div> <!--kotak-traveller-->
	
			<div class="kotak-traveller">
					<table>
						<thead>
						<tr>
							<th>ID Tranportation</th>
							<th>Transportation Name</th>
                                                        <th>Average Speed</th>
							<th>Action</th>
						</tr>
						</thead>
						<tbody>
						
                                                    <!--
                                                <c:forEach items="{modaTransList}" var="modaTrans">
                                                <tr>           
                                                    
                                                    <td><c:out value="{modaTrans.getKodeTransportasi()}"/></td>
                                                    <td><c:out value="{modaTrans.getNamaTransportasi()}"/></td>
                                                    <td><c:out value="{modaTrans.getKecepatan()}"/></td>
                                                    <td> <a class="action" href="edit.jsp">Edit </a> <a class="action2" onclick="return konfirmasi()" href="#"> Delete </a> </td>
							
                                                </tr>
                                                    -->
                                                </c:forEach>
                                                    
                                                <tr>
							<td>001</td>
							<td>Car</td>
                                                        <td>50 km/jam</td>
							<td> <a class="action" href="edit.jsp">Edit </a> <a class="action2" onclick="return konfirmasi()" href="#"> Delete </a> </td>
							
						</tr>
						
						<tr>
							<td>002</td>
							<td>Motorcycle</td>
                                                        <td>60 km/jam</td>
							<td> <a class="action" href="edit.jsp">Edit </a> <a class="action2" onclick="return konfirmasi()" href="#"> Delete </a> </td>
						</tr>
                                                
                                                <tr>
							<td>003</td>
							<td>Bus</td>
                                                        <td>40 km/jam</td>
							<td> <a class="action" href="edit.jsp">Edit </a> <a class="action2" onclick="return konfirmasi()" href="#"> Delete </a> </td>
						</tr>
                                                
                                                <tr>
							<td>004</td>
							<td>Wagon</td>
                                                        <td>150 km/jam</td>
							<td> <a class="action" href="edit.jsp">Edit </a> <a class="action2" onclick="return konfirmasi()" href="#"> Delete </a> </td>
						</tr>
                                                
                                                <tr>
							<td>004</td>
							<td>Working</td>
                                                        <td>40 km/jam</td>
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