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
        <link rel="stylesheet" type="text/css" href="css/home.css">
        <title>Travelendar</title>
    </head>
    <body>
        
        <div class="menu-atas">
            <div class="header">
                <div class="logonya">
                    <img src="images/travelendar2.png">

                </div>
                <div class="logo">
                    <img src="images/logo.png">
                </div> <!--logo-->


                <div class="tombol" style="float:right;">
                        <div class="sign-in">
                            <button id="myBtn">Sign In</button>
                        </div>
                </div>
            </div>
        </div> <!--menu-atas-->

        
        <div class="wadah1">
        <!-- Modal content -->
            <div class="modal-content">	
                             
		<div class="form">
                    
                    <div class="modal-header">
                        <h1> Create Your Account </h1>
                    </div>
                    
                    <form class="register-form" id="regForm">
                        <input id="input0" class="wajibdiisi" type="hidden" name="traveller_id" />
                        <input id="input1" class="wajibdiisi" type="text" name="traveller_fullname" placeholder="Fullname ..."/>
			<input id="input2" class="wajibdiisi" type="text" name="traveller_name" placeholder="Username ..."/>
                        <input id="input3" class="wajibdiisi" type="text" name="traveller_email" placeholder="Email ..."/>
			<input id="input4" class="wajibdiisi" type="password" name="traveller_password" placeholder="Password ..."/>
                        <input type="text" name="traveller_address" placeholder="Your Home Address ..."/>
                        <br>	
                    </form>
                    <button class="b-signup" id="tblSignup">Edit Profil</button>
                    <a href="index.jsp"><button class="b-back">Back</button></a>
                    <!--<a href="listuser.html"><button class="b-back">Show List User</button></a>-->
                    <!--<button class="b-signup" id="deleteAkun">Delete Akun</button>-->
		</div>			
            </div> <!--modal content-->
        </div>           
        <%@include file="footer.jsp" %>
        
        <script src="js/jquery.min.js"></script>
        <script>
            $(document).ready( function()  // Ketika web udah siap
            {   
                
                $.get("http://localhost:8080/Travlendar2A/index?action=findUser&fullname=Maryam", function(responseJson) 
                    {          // Eksekusi URL Controller
                        //alert(responseJson.traveller_fullname);
                        $('#input0').val(responseJson.traveller_id);
                        $('#input1').val(responseJson.traveller_fullname);
                        $('#input2').val(responseJson.traveller_name);
                        $('#input3').val(responseJson.traveller_email);
                        $('#input4').val(responseJson.traveller_password);
                    });       
                
                
                function getFormData($form)
                {
                    var unindexedArray = $form.serializeArray();
                    var indexedArray = {};
                    $.map(unindexedArray, function(n,i)
                    {
                        indexedArray[n['name']] = n['value'];
                    });
                    return indexedArray;
                }
                //ubah jsonarray form hasil serialize jadi json obj
                
                $('#tblSignup').click(function(){
                    // Serialize form to JSON Array
                    var formData = getFormData($('#regForm'));
                    var isValid = true; //diisi enggaknya
  
                    // cek kosong enggaknya
                    $('.wajibdiisi').each(function()
                    {
                       var eldt = $(this);
                       if(eldt.val() == "")
                       {
                           isValid = false;
                       }                           
                    });
                    
                    // jika diisi maka
                    if(isValid)
                    {
                        $.ajax({
                            type: "POST", // method post
                            url: "http://localhost:8084/Travlendar2A/index",
                            dataType:'JSON',
                            data: {action: 'editUser', json: JSON.stringify(formData) },
                            async: false, // dikirim ketika semua beres
                            complete: function(msgStatus)
                            {
                                var successMessage = JSON.stringify(msgStatus.responseText);
                                if(successMessage)
                                {
                                    alert(successMessage);
                                }
                            },
                            failure: function(errMsg) {
                                alert(errMsg);
                            }
                        });
                    }
                    else
                        alert("Mohon fullname, username, email, password Wajib Diisi!");
                });
            
                $('#deleteAkun').click(function(){
                    
                    var isValid = false; 
  
                    // cek kosong enggaknya
                    if($('#input0').val() != "")
                        isValid = true;
                    alert('Anda Yakin Menghapus Akun? \n Semua Data Event Anda Akan Terhapus\nTidak Dapat Kembali')
                    // jika diisi maka
                    if(isValid)
                    {
                        $.ajax({
                            type: "POST", // method post
                            url: "http://localhost:8084/Travlendar2A/index",
                            dataType:'JSON',
                            data: {action: 'deleteUser', traveller_id: $('#input0').val() },
                            async: false, // dikirim ketika semua beres
                            complete: function(msgStatus)
                            {
                                var successMessage = JSON.stringify(msgStatus.responseText);
                                if(successMessage)
                                {
                                    alert(successMessage);
                                }
                            },
                            failure: function(errMsg) {
                                alert(errMsg);
                            }
                        });
                    }
                    else
                        alert("Gagal Delete Akun!!");
                });
            });
        </script>
        
    </body>
</html>

