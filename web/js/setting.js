/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


            $(document).ready( function()  // Ketika web udah siap
            {   
                $.post("../index?action=findUser", function(responseJson) 
                    {          // Eksekusi URL Controller
                        //alert(responseJson.traveller_fullname);
                        $('#input0').val(responseJson.user);
                        $('#input1').val(responseJson.fullname);
                        $('#input2').val(responseJson.email);
                        $('#input3').val(responseJson.pass);
                        $('#input5').val(responseJson.address);
                    });       
                /*
                
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
                */
                $('#tblEdit').click(function(){
                    // Serialize form to JSON Array
                   // var formData = getFormData($('#regForm'));
                    var isValid = true; //diisi enggaknya
  
                    // cek kosong enggaknya
                    $('.ev').each(function()
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
                        var pass1, pass2;
                        pass1 =  $('#input3').val();
                        pass2 = $('#input4').val();
                        
                        if(pass1 == pass2)
                        {
                            var traveller = {};
                            traveller['fullname'] = $('#input1').val();
                            traveller['email'] = $('#input2').val();
                            traveller['pass'] = $('#input3').val();
                            traveller['address'] = $('#input5').val();

                            $.ajax({
                                type: "POST", // method post
                                url: "../index",
                                dataType:'JSON',
                                data: {action: 'editUser', json: JSON.stringify(traveller) },
                                async: false, // dikirim ketika semua beres
                                success: function(msgStatus)
                                {
                                    confirm(msgStatus.title + "\n" + msgStatus.message);
                                    if(msgStatus.status === "OK")
                                        confirm();
                                },
                                failure: function(errMsg) {
                                    alert(errMsg);
                                }
                            });
                        }
                        else
                            confirm('Confirm Pass is not same!');
                    }
                    else
                        confirm("Please fill the field fullname, username, email, password!");
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