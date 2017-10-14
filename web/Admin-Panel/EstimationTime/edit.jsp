<%-- 
    Document   : edit
    Created on : Sep 24, 2017, 2:00:20 PM
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
				<div class="judul-manage"> MANAGE ESTIMATION TIME </div>
		</div>

		</div> <!--middle-->
		
		<div class="middle">
		
			<div class="kotak-traveller">
				<h4> Edit Estimation Time </h4>	
			</div> <!--kotak-traveller-->
	
			<div class="kotak-traveller">
                                 <select class="edit-dl">
                                    <option value="StartingLocation">Location A ...</option>
                                    <option value="SLocation1">Home</option>
                                    <option value="SLocation2">Polban</option>
                                    <option value="SLocation3">Nobu Ramen & Sushi</option>
                                    <option value="SLocation4">Terminal Leuwipanjang</option>
                                 </select>
                                 <select class="edit-dl">
                                    <option value="Destination">Location B ...</option>
                                    <option value="SLocation1">Home</option>
                                    <option value="SLocation2">Polban</option>
                                    <option value="SLocation3">Nobu Ramen & Sushi</option>
                                    <option value="SLocation4">Terminal Leuwipanjang</option>
                                 </select>
				<div class="text-edit"> Edit Estimation Time </div>
					<input class="edtp" type="text" placeholder="(in minute)">
					<br/>
				<a href="index.jsp"><button class="update-traveller"> Update </button></a>
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
