<%-- 
    Document   : index
    Created on : Sep 21, 2017, 12:03:59 PM
    Author     : Diana
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
				<div class="judul-manage"> MANAGE EVENT </div>
				<button id="myBtn"> + Add New Event </button>
				<!-- The Modal -->
				<div id="myModal" class="modal">

				  <!-- Modal content -->
				  <div class="modal-content">
				    	
							  <div class="form">
							  	<div class="modal-header">
							      <span class="close">&times;</span>
							      <h5>Add New Event</h5>
							    </div>
							    
							    <form class="login-form" action="${pageContext.request.contextPath}/Admin-Panel/event?input=baru" method="post">
							      <input type="text" name="event_id" placeholder="Event ID ..."/>
							      <input type="text" name="location_id" placeholder="Location ID ..."/>
                                                              <input type="text" name="traveller_id" placeholder="Traveller ID ..."/>
							      <input type="text" name="event_name" placeholder="Event Name ..."/>
							      <input type="text" name="start_event" placeholder="Start Event (dd-MM-yyyy HH:mm:ss) ..."/>
                                                              <input type="text" name="end_event" placeholder="End Event (dd-MM-yyyy HH:mm:ss) ..."/>
                                                              <input type="text" name="note" placeholder="Note ..."/>
                                                              <input type="text" name="place" placeholder="Place ..."/>
                                                              <button type="submit"> Save </button>							     
							    </form>
							  </div>
							
				  </div> <!--modal content-->

				</div>

		</div> <!--middle-->
		
		<div class="middle">
		
			<div class="kotak-traveller">
				<h4> List Of Event </h4>
			
			</div> <!--kotak-traveller-->
	
			<div class="kotak-traveller">
					<table>
						<thead>
						<tr>
                                                        <th>No</th>                                                    
                                                        <th> ID Traveller </th>
							<th> Event Name </th>
                                                        <th> Start Event </th>
                                                        <th> End Event </th>
                                                        <th> Place </th>
                                                        <th> Note </th>
                                                        <th> Action</th>
                                                   
						</tr>
						</thead>
						<tbody>
                                                 
                                               
                                                    <c:forEach items="${eventList}" var="event">
        <tr>
            <c:set var="count" value="${count + 1}" scope="page"/>
            <td><c:out value="${count}"/></td>
            <td><c:out value="${event.getTraveller_id()}"/></td>
            <td><c:out value="${event.getEvent_name()}"/></td>
            <td><c:out value="${event.getStart_event()}"/></td>
            <td><c:out value="${event.getEnd_event()}"/></td>
            <td><c:out value="${event.getPlace()}"/></td>
            <td><c:out value="${event.getNote()}"/></td>
            <td><a class="action" href="http://localhost:8080/Travlendar/event?action=edit&code=<c:out value="${event.getEvent_id()}"/>">Edit</a></td>
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

<%@include file="/Admin-Panel/Teamplate/Footer/footer.jsp" %>

    </body>
</html>
/