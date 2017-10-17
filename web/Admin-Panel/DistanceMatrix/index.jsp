<%-- 
    Document   : index
    Created on : Sep 21, 2017, 1:17:03 PM
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
				<button id="myBtn"> + Add New Distance Matrix </button>
				<!-- The Modal -->
				<div id="myModal" class="modal">

				  <!-- Modal content -->
				  <div class="modal-content">
				    	
							  <div class="form">
							  	<div class="modal-header">
							      <span class="close">&times;</span>
							      <h5>Add New Distance Matrix</h5>
							    </div>

							    <form class="distance-form">
                                                                <select class="dropdown-location">
                                                                     <option value="StartingLocation">Starting Location ...</option>
                                                                     <option value="SLocation1">Rumah</option>
                                                                     <option value="SLocation2">Kantor DPRD Bangka Tengah</option>
                                                                     <option value="SLocation3">Bandara Depati Amir</option>
                                                                     <option value="SLocation4">Bandara Soekarno Hatta</option>
                                                                     <option value="SLocation5">Kantor DPRD Jakarta</option>
                                                                     <option value="SLocation6">Tanggerang</option>
                                                                </select>
							        <select class="dropdown-location">
                                                                     <option value="Destination">Destination ...</option>
                                                                     <option value="SLocation1">Rumah</option>
                                                                     <option value="SLocation2">Kantor DPRD Bangka Tengah</option>
                                                                     <option value="SLocation3">Bandara Depati Amir</option>
                                                                     <option value="SLocation4">Bandara Soekarno Hatta</option>
                                                                     <option value="SLocation5">Kantor DPRD Jakarta</option>
                                                                     <option value="SLocation6">Tanggerang</option>
                                                                </select>
							      <input style="margin-top: 5px; color: #535559" type="text" placeholder="Distance (km)    ..."/>
							      <button> Save </button>
							    </form>
							  </div>
							
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
					<input class="search "type="text" placeholder="Search Here ... "/>
				</div> <!--kotak-search-->
			</div> <!--kotak-traveller-->
	
			<div class="kotak-traveller">
					<table>
						<thead>
						<tr>
							<th>-</th>
							<th>Bandung</th>
                                                        <th>Bekasi</th>
                                                        <th>Bogor</th>
                                                        <th>Ciamis</th>
                                                        <th>Cianjur</th>
                                                        <th>Cirebon</th>
						</tr>
						</thead>
						<tbody>
                                                <tr>
                                                    <th>Bandung</th>
                                                    <td>0</td>
                                                    <td>134</td>
                                                    <td>177</td>
                                                    <td>135</td>
                                                    <td>160</td>
                                                    <td>209</td>
                                                </tr>
                                                
                                                <tr>
                                                    <th>Bekasi</th>
                                                    <td>132</td>
                                                    <td>0</td>
                                                    <td>62.2</td>
                                                    <td>248</td>
                                                    <td>208</td>
                                                    <td>200</td>
                                                </tr>
                                                
                                                <tr>
                                                    <th>Bogor</th>
                                                    <td>212</td>
                                                    <td>81.8</td>
                                                    <td>0</td>
                                                    <td>305</td>
                                                    <td>175</td>
                                                    <td>247</td>
                                                </tr>
                                                
                                                <tr>
                                                    <th>Ciamis</th>
                                                    <td>125</td>
                                                    <td>237</td>
                                                    <td>306</td>
                                                    <td>0</td>
                                                    <td>233</td>
                                                    <td>116</td>
                                                </tr>
                                                
                                                <tr>
                                                    <th>Cianjur</th>
                                                    <td>101</td>
                                                    <td>196</td>
                                                    <td>176</td>
                                                    <td>230</td>
                                                    <td>0</td>
                                                    <td>295</td>
                                                </tr>
						
                                                <tr>
                                                    <th>Cirebon</th>
                                                    <td>229</td>
                                                    <td>178</td>
                                                    <td>257</td>
                                                    <td>105</td>
                                                    <td>1345</td>
                                                    <td>0</td>
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