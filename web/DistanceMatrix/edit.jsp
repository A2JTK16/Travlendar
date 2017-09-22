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
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/Assets2/css/styledistance.css">
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
				<div class="judul-manage"> MANAGE DISTANCE MATRIX </div>
		</div>

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
