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

    <!--<div class="waddah">
        <div class="slogan">
            <h6> Manage My Plan </h6>
        </div>
    </div> <!--wadah-->        
        
    <div class="wadah2">

        <div class="main">
            <div class="left" style="padding-top:45px;">
                <div class="kotak-sidebar">
                    <h3> Hi ! Today Is </h3>
                    <div class="text-notif">
                        <span class="judul"> Friday , </span> <br>
                        8 Oktober <br>
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
                                  Oktober<br>
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
                              <li><span class="active">8</span></li>
                              <li>9</li>
                              <li>10</li>
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



                <div id="wrapper">

                <!-- start navigation -->
                <nav role="dropdown">
                <input type="checkbox" id="show-menu" role="button">
                <label for="show-menu" class="show-menu"></label>
                        <ul id="menu">
                                <li><a href="#">Month</a></li>
                                <li><a href="halaman_utama.jsp">Day</a>
                                <li  class="active"><a href="list_event.jsp">List</a>
                                <li><a href="#">Add New Event +</a></li>
                        </ul>
                </nav>
                <!-- end navigation -->

                </div>



            <iframe class="middle" height="560px" src="event_table.jsp" scrolling="yes">

            </iframe>


        </div> <!--main-->

    </div> <!--wadah2-->

<%@include file="footer.jsp" %>

    </body>
</html>
