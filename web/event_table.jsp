<%-- 
    Document   : calendar_table
    Created on : Oct 15, 2017, 1:59:25 PM
    Author     : Lenovo
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
        
        <table>
            
				
           
						<thead>
						<tr>
							<th style="text-align: center;">Event Name</th>
							<th style="text-align: center;">Date & time </th>
                                                        <th style="text-align: center;">Transportation<br>Mode</th>
                                                        <th style="text-align: center;">Departure<br>Time</th>
                                                        <th style="text-align: center;">Location</th>
                                                        <th style="text-align: center;">Action</th>
						</tr>
						</thead>
						<tbody>
						<tr>
							<td>Ke Kantor</td>
                                                        <td>11 September 2017, 06:30</td>
                                                        <td style="text-align: center;">
                                                            <div class="moda">
                                                            <img src="Assets/icon/motor2.png">
                                                            </div>
                                                        </td>
                                                        <td style="text-align: center;">06:30</td>
                                                        <td>Kantor DPRD Bangka Tengah</td>
                                                        <td>
                                                            <button id="myBtnview"> View More </button>
                                                            <button class="deletelist"> Delete </button>
                                                            <!-- The Modal -->
                                                                <div id="myModal" class="modal">

                                                                  <!-- Modal content -->
                                                                  <div class="modal-content">

                                                                                          <div class="form">
                                                                                                <div class="modal-header">
                                                                                              <span class="close">&times;</span>
                                                                                              <h5>Event Info</h5>
                                                                                            </div>

                                                                                          </div>

                                                                  </div> <!--modal content-->

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
                                                                  var btn = document.getElementById("myBtnview");

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
                          
                                                        </td>
                                                </tr>
                                                
                                                <tr>
							<td>Check In Pesawat</td>
                                                        <td>11 September 2017, 08:00</td>
                                                        <td style="text-align: center;">
                                                            <div class="moda">
                                                            <img src="Assets/icon/air2.png">
                                                            </div>
                                                        </td>
                                                        <td style="text-align: center;">08:00</td>
                                                        <td>Bandara Depati Amir</td>
                                                        <td>
                                                            <button id="myBtnview2"> View More </button>
                                                            <button class="deletelist"> Delete </button>
                                                            <!-- The Modal -->
                                                                <div id="myModal" class="modal">

                                                                  <!-- Modal content -->
                                                                  <div class="modal-content">

                                                                                          <div class="form">
                                                                                                <div class="modal-header">
                                                                                              <span class="close">&times;</span>
                                                                                              <h5>Event Info</h5>
                                                                                            </div>

                                                                                          </div>

                                                                  </div> <!--modal content-->

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
                                                                  var btn = document.getElementById("myBtnview2");

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
                                                        </td>
                                                </tr>
                                                
                                                <tr>
							<td>Check Out Pesawat</td>
                                                        <td>11 September 2017, 09:15</td>
                                                        <td style="text-align: center;">
                                                            <div class="moda">
                                                            <img src="Assets/icon/air2.png">
                                                            </div>
                                                        </td>
                                                        <td style="text-align: center;">09:15</td>
                                                        <td>Bandara Soekarno Hata</td>
                                                        <td>
                                                            <button id="myBtnview3"> View More </button>
                                                            <button class="deletelist"> Delete </button>
                                                            <!-- The Modal -->
                                                                <div id="myModal" class="modal">

                                                                  <!-- Modal content -->
                                                                  <div class="modal-content">

                                                                                          <div class="form">
                                                                                                <div class="modal-header">
                                                                                              <span class="close">&times;</span>
                                                                                              <h5>Event Info</h5>
                                                                                            </div>

                                                                                          </div>

                                                                  </div> <!--modal content-->

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
                                                                  var btn = document.getElementById("myBtnview3");

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
                                                        </td>
                                                </tr>
                                                
                                                <tr>
							<td>Rapat</td>
                                                        <td>11 September 2017, 13:10</td>
                                                        <td style="text-align: center;">
                                                            <div class="moda">
                                                            <img src="Assets/icon/car.png">
                                                            </div>
                                                        </td>
                                                        <td style="text-align: center;">13:10</td>
                                                        <td>Kantor DPRD Jakarta</td>
                                                        <td>
                                                            <button id="myBtnview4"> View More </button>
                                                            <button class="deletelist"> Delete </button>
                                                            <!-- The Modal -->
                                                                <div id="myModal" class="modal">

                                                                  <!-- Modal content -->
                                                                  <div class="modal-content">

                                                                                          <div class="form">
                                                                                                <div class="modal-header">
                                                                                              <span class="close">&times;</span>
                                                                                              <h5>Add New Travlendar</h5>
                                                                                            </div>

                                                                                          </div>

                                                                  </div> <!--modal content-->

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
                                                                  var btn = document.getElementById("myBtnview4");

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
                                                        </td>
                                                </tr>
                                                
                                                <tr>
                                                    <td height="50px"></td>
                                                    <td></td>
                                                    <td></td>
                                                    <td></td>
                                                    <td></td>
                                                    <td></td>
                                                </tr>
                                                
                                                <tr>
                                                    <td height="50px"></td>
                                                    <td></td>
                                                    <td></td>
                                                    <td></td>
                                                    <td></td>
                                                    <td></td>
                                                </tr>
                                                
                                                <tr>
                                                    <td height="50px"></td>
                                                    <td></td>
                                                    <td></td>
                                                    <td></td>
                                                    <td></td>
                                                    <td></td>
                                                </tr>
                                                
                                                <tr>
                                                    <td height="50px"></td>
                                                    <td></td>
                                                    <td></td>
                                                    <td></td>
                                                    <td></td>
                                                    <td></td>
                                                </tr>
                                                
                                                <tr>
                                                    <td height="50px"></td>
                                                    <td></td>
                                                    <td></td>
                                                    <td></td>
                                                    <td></td>
                                                    <td></td>
                                                </tr>
                                                
                                                <tr>
                                                    <td height="50px"></td>
                                                    <td></td>
                                                    <td></td>
                                                    <td></td>
                                                    <td></td>
                                                    <td></td>
                                                </tr>
                                                
                                                <tr>
                                                    <td height="50px"></td>
                                                    <td></td>
                                                    <td></td>
                                                    <td></td>
                                                    <td></td>
                                                    <td></td>
                                                </tr>
                                                
                                               
						</tbody>
					</table>
                                
    </body>
</html>
