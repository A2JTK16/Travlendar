<%-- 
    Document   : index
    Created on : Sep 21, 2017, 1:52:12 PM
    Author     : Alpin J
--%>


<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.DriverManager"%>
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
      <%@include file="../Teamplate/Header/header.jsp" %>

<div class="wadah">
	
	<div class="main">
		
		<%@include file="../Teamplate/Sidebar/sidebar.jsp" %>

		<div class="middle">
				<div class="judul-manage"> MANAGE LOCATION </div>
				<button id="myBtn"> + Add New Location </button>
				<!-- The Modal -->
				<div id="myModal" class="modal">

				  <!-- Modal content -->
				  <div class="modal-content">
				    	
							  <div class="form">
							  	<div class="modal-header">
							      <span class="close">&times;</span>
							      <h5>Add New Location</h5>
							    </div>
							    <form class="register-form" action="utama.html" method="POST">
							      <input type="text" placeholder="name"/>
							      <input type="password" placeholder="password"/>
							      <input type="text" placeholder="email address"/>
							      <button>create</button>
							      <p class="message">Already registered? <a href="#">Sign In</a></p>
							    </form>
							    <form class="login-form">
                                                                <select class="dropdown-location" type="text" name="PROVINCE_NAME">
                                                                    <c:forEach items="${provinceList}" var="province">
                                                                        <option> <c:out value="${province.getProvince_code()}"/>${province.getProvince_name()}</option>
                                                                    </c:forEach>
                                                                </select>
							      <input type="text" name="CITY_NAME" placeholder="City Name ..."/>
							      <button> Save </button>
                                                              <%--<p class="message">Not registered? <a href="#">Create an account</a></p>--%>
							    </form>
							  </div>
							
				  </div> <!--modal content-->

				</div>

		</div> <!--middle-->
		
		<div class="middle">
		
			<div class="kotak-traveller">
				<h4> List Of Location </h4>
                                <select id="PROVINCE_CODE" class="dropdown-location-choose" type="text" name="PROVINCE_NAME" onchange="getSelectValue()">
                                    <option>Select Province</option>
                                    <%
                                        try
                                        {
                                            String Query="select * from province";
                                            Class.forName("com.mysql.jdbc.Driver").newInstance();
                                            Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/travlendardb","root","");
                                            Statement stm=conn.createStatement();
                                            ResultSet rs=stm.executeQuery("select distinct PROVINCE_CODE, PROVINCE_NAME from province");
                                            while(rs.next())
                                            {
                                                
                                                %>
                                                <option value="<%=rs.getString("PROVINCE_CODE")%>"><%=rs.getString("PROVINCE_NAME")%></option>
                                                <%
                                                 out.println("KODE : " + rs.getString("PROVINCE_CODE"));
                                                 
                                            }
                                           // conn.close();
                                           // rs.close();
                                        }
                                        catch (Exception ex)
                                        {
                                            ex.printStackTrace();
                                            out.println("Error" + ex.getMessage());
                                        }

                                    %>
                                </select>
                                
                                <script>
                                    function getSelectValue()
                                    {
                                        var selectedValue = document.getElementById("PROVINCE_CODE").value;
                                        console.log(selectedValue)
                                    }
                                </script>    
				<!--<div class="kotak-search">
					<div class="icon-search">
						<img src="../Assets2/icon/search.png">
					</div> 
					<input class="search "type="text" placeholder="Search Traveller ... "/>
				</div> -->
			</div> <!--kotak-traveller-->
	
			<div class="kotak-traveller">
					<table>
						<thead>
						<tr>
							<th>ID</th>
                                                        <th>City</th>
							<th>Action</th>
						</tr>
						</thead>
						<tbody>
                                                    
                                                <%
                                                        String kode=request.getParameter("PROVINCE_NAME");
                                                      try
                                                        {
                                                            
                                                            String SQL = "Select CITY_CODE,CITY_NAME from city where PROVINCE_CODE='"+kode+"'";
                                                            out.println(request.getParameter("PROVINCE_NAME"));
                                                            out.println(request.getParameter("PROVINCE_CODE"));
                                                            //out.println("kode: " + kode);
                                                            String sql = "Select CITY_CODE,CITY_NAME from city where PROVINCE_CODE=32";
                                                            Class.forName("com.mysql.jdbc.Driver").newInstance();
                                                            Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/travlendardb","root","");
                                                            Statement stmt=con.createStatement();
                                                            ResultSet resultset=stmt.executeQuery(sql);
                                                            out.println(resultset=stmt.executeQuery(sql));
                                                            while(resultset.next())
                                                            {
                                                                %>
                                                              
                                                                <tr>
                                                                    <td><%=resultset.getString("CITY_CODE")%></td>
                                                                    <td><%=resultset.getString("CITY_NAME")%></td>
                                                                    <td> <a class="action" href="edit.jsp">Edit </a> <a class="action2" onclick="return konfirmasi()" href="#"> Delete </a> </td>
                                                                </tr>
                                                                <%
                                                            }
                                                            resultset.close();
                                                            con.close();
                                                        }
                                                        catch (Exception ex)
                                                        {
                                                            ex.printStackTrace();
                                                            out.println("Sorry " + ex.getMessage());
                                                        }
                                                    %>
						
						
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

<%@include file="../Teamplate/Footer/footer.jsp" %>
    </body>
</html>
