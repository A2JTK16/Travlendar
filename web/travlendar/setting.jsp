<%-- 
    Document   : setting
    Created on : Nov 27, 2017, 10:14:27 PM
    Author     : Alpin J
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" href="../css/style.css">
        <!-- Google Maps JS API -->
        <!--<script src="https://maps.googleapis.com/maps/api/js?key=AIzaSyDkmRXiWxa2lmWdsxjcqahurk8g_rtHM1s"></script>-->
        
        <!-- JQuery Library -->
        <!--<script src="http://code.jquery.com/jquery-latest.min.js"></script> -->
        
        <!-- GMaps Library -->
        <!--<script src="../js/gmaps.js"></script>-->
        
    </head>
    <body>
        <div class="jarak-atas">

    </div> <!--jarak-atas-->

    <div class="menu-atas">
	<div class="header">
             <div class="logonya">
                <img src="../images/travelendar2.png">
                
            </div>
            <div class="logo">
                <img src="../images/logo.png">
            </div> <!--logo-->
            
            <div class="dropdown" style="float:right;">
                <button class="dropbtn">
                    <a class="icon-account">
                            <img src="../icon/akun1.png">
                    </a>
                </button>
                <div class="dropdown-content">
                    <a href="../">My Plan</a>
                  <a id="signout">Sign Out</a>
                </div>
            </div>
            
            <div class="dropdown" style="float:right;">
                <button class="dropbtn">
                    <a class="icon-account">
                            <img src="../icon/notif2.png">
                    </a>
                </button>
                <div class="dropdown-content">
                  <a href="#">Welcome to Travelendar ! by A2 JTK</a>
                  <a href="#">Don't Forget to Make a Better Plan ! by A2 JTK</a>
                  <a href="#">Our Plan Will Get Big Things! by A2 JTK</a>
                </div>
            </div>
                  
            <div class="kotak-cari">
                <div class="icon-cari">
                    <img src="../icon/search.png">
                </div>
                <input class="cari" type="text" placeholder="Find Event ..."/>
            </div> <!--kotak-cari-->
          
	</div> <!--header-->
     
    </div> <!--menu-atas-->
        
    
    <div class="wadah-gamb">
        <div class="slogan">
        <div class="sukses">
        <h2> Make Your Plan Be Batter ! </h2>
        </div>
        </div>
    </div>
    
    <div class="induk1">
        
        <div class="container-t">
            <div class="tab">
                <button class="tablinks" id="Account">Account</button>
                <button class="tablinks" id="General">General</button>
            </div>
        </div>
    </div> <!--induk1-->
    
    <div class="induk2">
         <div class="container">
     
             <div id="London" class="tabcontent">
                <div class="main">
                    <input class="ev" type="hidden" id="input0" name="traveller_id">
                    <div class="text-ev"> Fullname </div>
                     <input class="ev" type="text" id="input1" name="traveller_fullname">
                     <div class="text-ev"> E-mail </div>
                     <input class="ev" type="text" id="input2" name="traveller_email">
                     <div class="text-ev"> Username </div>
                     <input class="ev" type="text" id="input3" name="traveller_username">
                     <div class="text-ev"> Password </div>
                     <input class="ev" type="password" id="input4" name="traveller_password">
                 </div>
             </div>
 
            <div id="Paris" class="tabcontent">
                 <div class="main">
                     <div class="left">
                         <div class="text-ev"> Date format </div>
                         <select class="time-ev" type="text">
                            <option>dd/mm/yyyy</option>
                            <option>mm/dd/yyyy</option>
                            <option>yyyy/mm/dd</option>
                        </select>
                        <div class="text-ev"> Time format </div>
                        <select class="time-ev" type="text">
                            <option>24-Hour</option>
                            <option>12-Hour</option>
                         </select>
                         <div class="text-ev">  Notification </div>
                         <select class="time-ev" type="text">
                             <option>1 day</option>
                             <option>3 days</option>
                             <option>1 week</option>
                         </select>
                     </div>
                     <div class="right">
                         <button class="save-ev" id="myBtn">Save changes</button>
                     </div>
                 </div>
             </div>
          </div>
          
     </div>
    
    
        
        <%@include file="../travlendar/footer.jsp" %>
        
        <script src="../js/jquery.min.js"></script>
        <script>
            $(document).ready( function()  // Ketika web udah siap
            {   
                $.post("../index?action=findUser", function(responseJson) 
                    {          // Eksekusi URL Controller
                        //alert(responseJson.traveller_fullname);
                        $('#input0').val(responseJson.traveller_id);
                        $('#input1').val(responseJson.traveller_fullname);
                        $('#input2').val(responseJson.traveller_email);
                        $('#input3').val(responseJson.traveller_username);
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
                            url: "../index",
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
                            url: "../index",
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
                
                function openTab(cssIdTabContent, cssIdTab)
                {
                    $('.tabcontent').hide();
                    $('.tablinks').removeClass('.active');
                    $(cssIdTabContent).show();
                    $(cssIdTab).addClass('.active');
                }
                
                openTab('#London', '#London');
                
                $('#Account').click(function(){
                    openTab('#London', '#London');
                });
                
                $('#General').click(function(){
                    openTab('#Paris', '#Paris');
                });
                
                $('#signout').click(function(){
                       $.ajax({
                            type: 'GET', // method post
                            url: '../index',
                            data: {action: 'logout'},
                            async: false, // dikirim ketika semua beres
                            success: function(msgStatus)
                            {
                                location.reload(true)
                            },
                            error: function(xmlhttprequest, textstatus, message)
                            {
                                alert(textstatus + message);
                            }
                        });  
                   });
                   
            });
        </script>
    </body>
</html>
