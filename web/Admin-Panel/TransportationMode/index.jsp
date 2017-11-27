 <%-- 
    Document   : index
    Created on : Sep 21, 2017, 4:59:43 PM
    Author     : Nia
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/Admin-Panel/Assets2/css/styletraveller.css">
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/Admin-Panel/Assets2/css/responsive.css">
        <title>JSP Page</title>
    </head>
    <body>
        <%@include file="/Admin-Panel/Teamplate/Header/header.jsp" %>
<div class="wadah">
	
	<div class="main">
		
		<%@include file="/Admin-Panel/Teamplate/Sidebar/sidebar.jsp" %>

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

							    <form class="distance-form" action="${pageContext.request.contextPath}/Admin-Panel/moda?input=baru" method="post">
                                                               <input type="text" name="kode_trans" placeholder="Transportation Code (char)"/>
							       <input type="text" name="nama_trans" placeholder="Transportation Mode (string)"/>
                                                               <input type="text" name="kecepatan" placeholder="Average Speed in km/h (float)"/>
                                                               <button type="submit"> Save </button>
							    </form>
							  </div> <!--jenis transportasion-->
							
				  </div> <!--modal content-->

				</div>

		</div> <!--middle-->
		
		<div class="middle">
		
			<div class="kotak-traveller">
				<h4> Transportation List </h4>
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
						
                                                <c:forEach items="${modaTransList}" var="modaTrans">
                                                    <tr>           
                                                        <td><c:out value="${modaTrans.getKodeTransportasi()}"/></td>
                                                        <td><c:out value="${modaTrans.getNamaTransportasi()}"/></td>
                                                        <td><c:out value="${modaTrans.getKecepatan()}"/> km/h</td>
                                                        <td><a class="action" href="${pageContext.request.contextPath}/Admin-Panel/TransportationMode/edit.jsp">Edit</a>
                                                            <form  action = "${pageContext.request.contextPath}/Admin-Panel/moda?input=delete" method="post">
                                                                <input type="hidden" name="kd_trans" value="${modaTrans.getKodeTransportasi()}">
                                                                <input class="action2" type="submit" value="Delete">
                                                            </form>
                                                        </td>
                              
                                                          
                                                    </tr>
                                                </c:forEach>
                                                    
                                                
                                                
                                                
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

<%@include file="/Admin-Panel/Teamplate/Footer/footer.jsp" %>
    </body>
</html>