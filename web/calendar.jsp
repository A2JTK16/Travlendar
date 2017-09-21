<%-- 
    Document   : index
    Created on : Sep 15, 2017, 5:01:23 PM
    Author     : diana

--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/style-calendar.css">

        <title>JSP Page</title>
    </head>
    <body>
        <div class="wadah">
	<div class="header">
             <div class="logo">
                <img src="logo/logo.png">
             </div> <!-logo-->
             
             <div class="find">
                 <img src="icon/acount.png">
             </div>
             
             <div class="find">
                 <img src="icon/notif.png">
             </div>
             
             <div class="find">
                <img src="icon/search.png">
                <text> Find Event </text>
             </div>
          
	</div> <!--header-->
       
	<div class="content">

		<div class="kotak">
                    <div class="dayy">
                        <p> Hi ! To Day Is : </p>
                        <p> Friday, 8 </p>
                        <p> September </p>
                        <p> 2017 </p>
                    </div> <!--day-->
                     
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
                    
                    <div class="dayy">
                        <p> GO TO A DATE </p>
                    </div>
		</div>
            
            <div class="isi">
                <main>
                    
                    <input id="tab1" type="radio" name="tabs" checked>
                      <label for="tab1">Calendar</label>
                    <input id="tab2" type="radio" name="tabs">
                      <label for="tab2">View List Event</label>
                      
                      <button type="button"> Add New Event + </button>

                    <section id="content1">
                      <h3>Calendar</h3>
                      
                      <table border="1px" width="600px">
                          <tr>
                              <th> Time </th>
                              <th> Event Name </th>
                              <th> Location </th>
                              <th> Note </th>
                          </tr>
                          
                          <tr>
                              <td> 07:00 </td>
                              <td> Kuliah </td>
                              <td> POLBAN </td>
                              <td> Matematika Diskrit </td>
                          </tr>
                          
                          <tr>
                              <td height="300px"> </td>
                              <td> </td>
                              <td> </td>
                              <td> </td>
                          </tr>
                          
                      </table>

                    </section>
                    <section id="content2">
                      <h3>View List Event</h3>
                        <table border="1px" width="600px">
                          <tr>
                              <th> Event Name </th>
                              <th> Date </th>
                              <th> Location </th>
                              <th> Note </th>
                          </tr>
                          
                          <tr>
                              <td> Lele's Brithday  </td>
                              <td> 20-Februari-2017 </td>
                              <td> Ciwaruga </td>
                              <td> Dont Forget to Bring Present ! </td>
                          </tr>
                          
                          <tr>
                              <td height="300px"> </td>
                              <td> </td>
                              <td> </td>
                              <td> </td>
                          </tr>
                          
                      </table>
                    </section>
                    
               
            </div> <!--isi-->
           
	</div>

	<div class="footer">
            <div class="cpyright"> Copyright &copy; Travlendar 2017 </div> 
	</div> <!--footer-->
</div>
    </body>
</html>
