<%-- 
    Document   : headerhome
    Created on : Oct 16, 2017, 5:50:36 PM
    Author     : Fadhlan
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" type="text/css" href="css/home.css">
        <link rel="stylesheet" type="text/css" href="css/responsive.css">
        <!-- JQuery Library -->
        <!--<script src="http://code.jquery.com/jquery-latest.min.js"></script> -->
        <script src="js/jquery.min.js"></script>
        <title>Header</title>
    </head>
    <body>
                
<div class="jarak-atas">

</div> <!--jarak-atas-->

<div class="menu-atas">
	<div class="header">
            <div class="logonya">
                <img src="images/travelendar2.png">
                
            </div>
            <div class="logo">
                <img src="images/logo.png">
            </div> <!--logo-->
            
            <div class="tombol" style="float:right;">
                            <a href="signup.jsp"><div class="sign-up">Create An Account</div></a>                   
            </div>
            
            <div class="tombol" style="float:right;">
                    <div class="sign-in">
                        <button id="myBtn">Sign In</button>
			<!-- The Modal -->
				<div id="myModal" class="modal">

				  <!-- Modal content -->
				  <div class="modal-content">
				    	
					<div class="form">
							  	<div class="modal-header">
							      <span class="close">&times;</span>
                                                              <div class="plogo"><img src="images/logo-sign.png"></div>
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
                            url: "http://localhost:8080/Travlendar2A/index",
                            dataType:'JSON',
                            data: {action: 'login', username: $('#username').val(), password: $('#password').val() },
                            async: false, // dikirim ketika semua beres
                            complete: function(msgStatus)
                            {
                                var successMessage = msgStatus.responseText;
                                var submsg = successMessage.substring(0, 6); 
                                if(successMessage)
                                {
                                    alert(successMessage);
                                }
                                if(submsg == "Sukses")
                                {
                                    $('#myModal').html('<a href="add_event.jsp"><button class="b-signin">Sukses Login, Silakan Masuk</button></a>');
                                    //$('header').append('<meta http-equiv="refresh" content="0; url=http://localhost:8080/Travlendar2A/travlendar/add_event.jsp" />');
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
            </div>  
	</div> <!--header-->
        
         			
     
</div> <!--menu-atas-->

