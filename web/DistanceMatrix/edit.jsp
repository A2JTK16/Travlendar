<%-- 
    Document   : edit
    Created on : Sep 21, 2017, 4:58:15 PM
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
		

		</div> <!--middle-->
		
		<div class="middle">
		
			<div class="kotak-traveller">
				<h4> Edit Distance Matrix </h4>	
			</div> <!--kotak-traveller-->
	
			<div class="kotak-distance">
				 <select class="edit-dl">
                                    <option value="StartingLocation">Location A ...</option>
                                    <option value="SLocation1">Universitas Kristen Maranatha</option>
                                    <option value="SLocation2">Politeknik Negeri Bandung</option>
                                    <option value="SLocation3">Bosscha Observatory</option>
                                    <option value="SLocation4">Maribaya Waterfall</option>
                                    <option value="SLocation5">Saung Angklung Udjo</option>
                                    <option value="SLocation6">Paris Van Java</option>
                                 </select>
                                 <select class="edit-dl">
                                    <option value="Destination">Location B ...</option>
                                    <option value="DLocation1">Universitas Kristen Maranatha</option>
                                    <option value="DLocation2">Politeknik Negeri Bandung</option>
                                    <option value="DLocation3">Bosscha Observatory</option>
                                    <option value="DLocation4">Maribaya Waterfall</option>
                                    <option value="DLocation5">Saung Angklung Udjo</option>
                                    <option value="DLocation6">Paris Van Java</option>
                                 </select>
				<div class="text-edit"> Edit Distance </div>
					<input class="edtp" type="text" placeholder="(in kilometer)">
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
