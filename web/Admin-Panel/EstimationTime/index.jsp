<%-- 
    Document   : index
    Created on : Sep 21, 2017, 4:09:59 PM
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
    
    <%@include file="../Header/header.jsp" %>
        
<div class="wadah">
	
	<div class="main">
		
		<%@include file="../Sidebar/sidebar.jsp" %>

		
		
		<div class="middle">
		
			<div class="kotak-traveller">
				<h4> Estimation Time </h4>
                                
			</div> <!--kotak-traveller-->
	
			<div class="kotak-traveller">
					<table>
						<thead>
						<tr>
							<th>Starting Location</th>
							<th>Destination</th>
							<th>Distance (km)</th>
                                                        <th>Estimation Time (Speed rate 40 km/h)</th>
							<th>Action</th>
						</tr>
						</thead>
						<tbody>
						<tr>
							<td>Rumah</td>
							<td>Kantor DPRD Bangka Tengah</td>
							<td>40</td>
                                                        <td>60 minute</td>
							<td> <a class="action" href="edit.jsp">Edit </a> <a class="action2" onclick="return konfirmasi()"> Delete </a> </td>
						</tr>
						
						<tr>
							<td>Rumah</td>
							<td>Bandara Depati Amir</td>
							<td>98</td>
                                                        <td>147 minute</td>
							<td> <a class="action" href="edit.jsp">Edit </a> <a class="action2" onclick="return konfirmasi()"> Delete </a> </td>
						</tr>
						
						<tr>
							<td>Bandara Depati Amir</td>
							<td>Bandara Soekarno Hatta</td>
							<td>749</td>
                                                        <td>1124 minute</td>
							<td> <a class="action" href="edit.jsp">Edit </a> <a class="action2" onclick="return konfirmasi()"> Delete </a> </td>
						</tr>
						
						<tr>
							<td>Bandara Soekarno Hatta</td>
							<td>Kantor DPRD Jakarta</td>
							<td>28.3</td>
                                                        <td>43 minute</td>
							<td> <a class="action" href="edit.jsp">Edit </a> <a class="action2" onclick="return konfirmasi()"> Delete </a> </td>
						</tr>
						
						
						<tr>
							<td>Bandara Soekarno Hatta</td>
							<td>Tanggerang</td>
							<td>35.4</td>
                                                        <td>54 minute</td>
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
