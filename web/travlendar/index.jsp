<%-- 
    Document   : index
    Created on : Nov 17, 2017, 4:55:08 PM
    Author     : Lenovo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" type="text/css" href="css/home.min.css">
        <link rel="stylesheet" type="text/css" href="css/responsivehome.min.css">
        <link href="https://fonts.googleapis.com/css?family=Roboto+Slab" rel="stylesheet">
        <title>Travelendar</title>
        <script src="js/jquery.min.js"></script>
        <sccript src="js/home.min.js"></sccript>
    </head>
    <body>  
       <img class="logoup" src="images/trav.svg">
        <a href="signup" class="signup">Create An Account</a>
                        <div class="sign-in">
                        <button id="myBtn">Sign In</button>
			<!-- The Modal -->
				<div id="myModal" class="modal">

				  <!-- Modal content -->
				  <div class="modal-content2">
				    	
					<div class="form">
							  	<div class="modal-header">
							      <span class="close">&times;</span>
                                                              <div class="plogo"><img src="images/fix.png"></div>
							    </div>
					    <form class="register-form">
					      <input type="text" id="username" placeholder="Username"/>
					      <input type="password" id="password" placeholder="Password"/>
                                              <br>
					    </form>
                                            <button class="b-signin" id="tombolLogin">Sign In</button>
					</div>
							
				  </div> <!--modal content-->

				</div>
        
                                <script>
    
    $(document).ready( function()  // Ketika web udah siap
    {	
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
                                
        $("#tombolLogin").on('click', function() 
        {    
                    $.ajax({
                            type: "POST", // method post
                            url: "index",
                            data: {action: "login", username: $('#username').val(), password: $('#password').val() },
                            async: false, // dikirim ketika semua beres
                            timeout: 6000, // set timeout jadi 6 detik
                            complete: function(msgStatus)
                            {
                                var successMessage = msgStatus.responseText;
                                var submsg = successMessage.substring(0, 6); 
                               /* if(successMessage)
                                {
                                    alert(successMessage);
                                }; */
                                if(submsg == "Sukses")
                                {
                                    location.reload();
                                    //toUserPanel();
                                    //$('#myModal').html('<a href="index.jsp"><button class="b-signin">Sukses Login, Silakan Masuk</button></a>');
                                    //$('header').append('<meta http-equiv="refresh" content="0; url=http://localhost:8080/Travlendar2A/travlendar/add_event.jsp" />');
                                }
                                else if(submsg == "Gagal ")
                                {
                                    confirm(successMessage);
                                }
                            },
                            failure: function(errMsg) {
                                alert(errMsg);
                            }
                    });
        });      
    });
			</script>	

                    </div>
        <div class="kotak-deskripsi">
            <div class="deskripsi">Make a Better Plan.</div>
        </div>
  </body>
</html>

