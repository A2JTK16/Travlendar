<%-- 
    Document   : sidebar
    Created on : Sep 25, 2017, 8:38:32 PM
    Author     : Lenovo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

		<div class="left">
		
                        <div class="menu-admin"> 
				<div class="icon-setting">
                                    <img src="${pageContext.request.contextPath}/Admin-Panel/Assets2/icon/welcome.png">
				</div> <!--icon-setting-->
                            
				<h2 class="text-admin">Administrator</h2>
                            
                        </div> <!--menu-admin-->
                        
                        
			<div class="hides">			
				<button onclick="javascript:show()">
                                    <div class="turun">
                                        <img src="${pageContext.request.contextPath}/Admin-Panel/Assets2/icon/responsive.png">
                                    </div>
				</button>
			</div>

			
			<div id="hidden-mobile">
			
                        
                        <a href="${pageContext.request.contextPath}/Admin-Panel/traveller?action=show">
			<div class="menu-manage">
				<div class="icon-setting">
					<img src="${pageContext.request.contextPath}/Admin-Panel/Assets2/icon/traveller.png">
				</div> <!--icon-setting-->
				<h2>Traveller</h2>
	
			</div> <!--menu-manage-->
                        </a>
                        
                        <a href="${pageContext.request.contextPath}/Admin-Panel/Location/index.jsp">
			<div class="menu-manage">
				<div class="icon-setting">
					<img src="${pageContext.request.contextPath}/Admin-Panel/Assets2/icon/lokasi.png">
				</div> <!--icon-setting-->
                                <h2>Location</h2>
			</div>
                        </a>
			
                        <a href="${pageContext.request.contextPath}/Admin-Panel/moda?action=show">
			<div class="menu-manage">
				<div class="icon-setting">
					<img src="${pageContext.request.contextPath}/Admin-Panel/Assets2/icon/car.png">
				</div> <!--icon-setting-->
                                <h2>Transportation Mode</h2>
			</div> <!--menu-manage-->
                        </a>
			
                        <a href="${pageContext.request.contextPath}/Admin-Panel/DistanceMatrix/index.jsp">
			<div class="menu-manage">
				<div class="icon-setting">
					<img src="${pageContext.request.contextPath}/Admin-Panel/Assets2/icon/jarak.png">
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
