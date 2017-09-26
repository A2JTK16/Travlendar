<%-- 
    Document   : edit
    Created on : Sep 21, 2017, 4:58:15 PM
    Author     : Diana
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/Assets2/css/styletraveller.css">
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/Assets2/css/styledistance.css">
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/Assets2/css/responsive.css">
        <title>JSP Page</title>
    </head>
    <body>

<%@include file="../Header/header.jsp" %>

<div class="wadah">
	
	<div class="main">
		
		<%@include file="../Sidebar/sidebar.jsp" %>

		<div class="middle">
				<div class="judul-manage"> MANAGE DATA SCHEDULE </div>
		

		</div> <!--middle-->
		
		<div class="middle">
		
			<div class="kotak-traveller">
				<h4> Edit Data Schedule </h4>	
			</div> <!--kotak-traveller-->
	
			<div class="kotak-distance">
                                 <div class="text-edit"> Edit Event Name </div>
					<input class="edtp" type="text" placeholder="">
				<div class="text-edit"> Edit Start Location </div>
					<input class="edtp" type="text" placeholder="">
				<div class="text-edit"> Edit Destination Location </div>
					<input class="edtp" type="text" placeholder="">
				<div class="text-edit"> Edit Started Time </div>
					<input class="edtp" type="text" placeholder="">
                                <div class="text-edit"> Edit Ended Time </div>
                                        <input class="edtp" type="text" placeholder="">'
                                        <br/>
				 <select class="edit-dl">
                                    <option value="Destination">Edit Transportation Mode ...</option>
                                    <option value="DLocation1">Car</option>
                                    <option value="DLocation2">Motorcycle</option>
                                    <option value="DLocation3">Bus</option>
                                    <option value="DLocation4">Wagon</option>
                                    <option value="DLocation4">Working</option>
                                 </select>
					<br/>
				<a href="index.jsp"><button class="update-distance"> Update </button></a>
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