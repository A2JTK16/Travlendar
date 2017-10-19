<%-- 
    Document   : sidebar
    Created on : Sep 25, 2017, 8:38:32 PM
    Author     : Lenovo
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
		<div class="left">
		
                        <div class="menu-admin"> 
				<div class="icon-setting">
                                    <img src="../Assets2/icon/welcome.png">
				</div> <!--icon-setting-->
                            
				<h2 class="text-admin">Administrator</h2>
                            
                        </div> <!--menu-admin-->
                        
                        
			<div class="hides">			
				<button onclick="javascript:show()">
                                    <div class="turun">
                                        <img src="../Assets2/icon/responsive.png">
                                    </div>
				</button>
			</div>

			
			<div id="hidden-mobile">
			
                        
                        <a href="../Traveller/index.jsp">
			<div class="menu-manage">
				<div class="icon-setting">
					<img src="../Assets2/icon/traveller.png">
				</div> <!--icon-setting-->
				<h2>Traveller</h2>
	
			</div> <!--menu-manage-->
                        </a>
                        
                        <a href="../Location/index.jsp">
			<div class="menu-manage">
				<div class="icon-setting">
					<img src="../Assets2/icon/lokasi.png">
				</div> <!--icon-setting-->
                                <h2>Location</h2>
			</div>
                        </a>
			
                        <a href="../TransportationMode/index.jsp">
			<div class="menu-manage">
				<div class="icon-setting">
					<img src="../Assets2/icon/car.png">
				</div> <!--icon-setting-->
                                <h2>Transportation Mode</h2>
			</div> <!--menu-manage-->
                        </a>
			
                        <a href="../DistanceMatrix/index.jsp">
			<div class="menu-manage">
				<div class="icon-setting">
					<img src="../Assets2/icon/jarak.png">
				</div> <!--icon-setting-->
				<h2>Distance</h2>
			</div>
                        </a>
			
                        <!--<a href="../EstimationTime/index.jsp">
			<div class="menu-manage">
				<div class="icon-setting">
					<img src="../Assets2/icon/time.png">
				</div> <!--icon-setting-->
                                <!--<h2>Estimation Time</h2>
			</div> <!--menu-manage-->
                        <!--</a>-->
                        
                        
                                
			</div>
			
		</div> <!--/ .left -->

    </body>
</html>
