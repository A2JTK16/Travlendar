<%-- 
    Document   : index
    Created on : Sep 21, 2017, 12:03:59 PM
    Author     : Diana
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" type="text/css" href="Assets/css/userstyle.css">
        <link rel="stylesheet" type="text/css" href="Assets/css/calendar.css">
        <link rel="stylesheet" type="text/css" href="Assets/css/userresponsive.css">
        <title>JSP Page</title>
    </head>
    <body>
        
        <%@include file="header.jsp" %>

<div class="wadah">
	
    <div class="main">
        <div class="left">
            <div class="kotak-sidebar">
                <h3> Hi ! Today Is </h3>
                <div class="text-notif">
                    <span class="judul"> Friday , </span> <br>
                    8 September <br>
                    2017
                </div>
            </div>
            
            <div class="kotak-sidebar">
                <h3> Calendar </h3>
                <div class="dayy">
                     
                        <div class="month">      
                          <ul>
                            <li class="prev">&#10094;</li>
                            <li class="next">&#10095;</li>
                            <li>
                              August<br>
                              <span style="font-size:18px">2017</span>
                            </li>
                          </ul>
                        </div>

                        <ul class="weekdays">
                          <li>M</li>
                          <li>Tu</li>
                          <li>W</li>
                          <li>Th</li>
                          <li>F</li>
                          <li>Sa</li>
                          <li>Su</li>
                        </ul>

                        <ul class="days">  
                          <li>1</li>
                          <li>2</li>
                          <li>3</li>
                          <li>4</li>
                          <li>5</li>
                          <li>6</li>
                          <li>7</li>
                          <li>8</li>
                          <li>9</li>
                          <li><span class="active">10</span></li>
                          <li>11</li>
                          <li>12</li>
                          <li>13</li>
                          <li>14</li>
                          <li>15</li>
                          <li>16</li>
                          <li>17</li>
                          <li>18</li>
                          <li>19</li>
                          <li>20</li>
                          <li>21</li>
                          <li>22</li>
                          <li>23</li>
                          <li>24</li>
                          <li>25</li>
                          <li>26</li>
                          <li>27</li>
                          <li>28</li>
                          <li>29</li>
                          <li>30</li>
                          <li>31</li>
                        </ul>

                    </div>
                
            </div>
            
             <div class="kotak-sidebar">
                    <h4> Go to a Date </h4>
             </div>
        </div> <!--left-->
        
    
        <div class="middle">
            <div id="wrapper">

            <!-- start navigation -->
            <nav role="dropdown">
            <input type="checkbox" id="show-menu" role="button">
            <label for="show-menu" class="show-menu"></label>
                    <ul id="menu">
                            <li class="active"><a href="#">Calendar</a></li>
                            <li><a href="#">View List Event</a>
                            <li><a href="#">Add New Event</a></li>
                    </ul>
            </nav>
            <!-- end navigation -->

            </div>
        </div> <!--middle-->
        
        <div class="middle">
            <table>
						<thead>
						<tr>
							<th>Time</th>
							<th>Event Name</th>
							<th>Location</th>
							<th>Note</th>
						</tr>
						</thead>
						<tbody>
						<tr>
							<td>06</td>
                                                        <td> </td>
                                                        <td> </td>
                                                        <td> </td>
                                                </tr>
						
						<tr>
							<td>07</td>
							<td>Absensi dan Mengambil Surat Tugas</td>
							<td>Kantor DPRD Banka Tengah</td>
							<td></td>
						</tr>
						
						<tr>
							<td>08</td>
							<td></td>
							<td></td>
							<td></td>
							
                                                </tr>
						
						<tr>
							<td>09</td>
							<td>Check In</td>
							<td>Bandara Depati Amir</td>
							<td></td>
                                                </tr>
						
						
						<tr>
							<td>10</td>
							<td></td>
							<td></td>
							<td></td>
							
                                                </tr>
                                                
                                                <tr>
							<td>11</td>
							<td>Check Out</td>
							<td>Bandara Soekarno Hatta</td>
							<td></td>		
                                                </tr>
                                                
                                                <tr>
							<td>12</td>
							<td></td>
							<td></td>
							<td></td>		
                                                </tr>
                                                
                                                <tr>
							<td>13</td>
							<td>Rapat</td>
							<td>Kantor DPRD Jakarta</td>
							<td>Tidak boleh terlambat ! </td>		
                                                </tr>
						
                                                <tr>
							<td>13</td>
							<td></td>
							<td></td>
							<td></td>		
                                                </tr>
                                                
                                                <tr>
							<td>14</td>
							<td></td>
							<td></td>
							<td></td>		
                                                </tr>
                                                
                                                <tr>
							<td>15</td>
							<td></td>
							<td></td>
							<td></td>		
                                                </tr>
                                                
                                                <tr>
							<td>16</td>
							<td></td>
							<td></td>
							<td></td>		
                                                </tr>
                                                
                                                <tr>
							<td>17</td>
							<td></td>
							<td></td>
							<td></td>		
                                                </tr>
                                                
                                                <tr>
							<td>18</td>
							<td></td>
							<td></td>
							<td></td>		
                                                </tr>
                                                
                                                <tr>
							<td>19</td>
							<td></td>
							<td></td>
							<td></td>		
                                                </tr>
                                                
                                                <tr>
							<td>20</td>
							<td></td>
							<td></td>
							<td></td>		
                                                </tr>
						
						</tbody>
					</table>
        </div>
    </div> <!--main-->
 
</div> <!--wadah-->

<%@include file="footer.jsp" %>

    </body>
</html>
