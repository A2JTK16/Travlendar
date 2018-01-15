/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


      $(document).ready( function()  // Ketika web udah siap
            {
                $('#modalMessage').hide(); // default ga nampil
                
                $('#modalClose').click(function() // jika klik tombol close
                {
                    $('#modalMessage').hide();
                });
                
                $('#tblOk').click(function(){
                    $('#modalMessage').hide();
                });
                
                $('#tblHome').click(function(){
                    window.location = "../";
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
                function objectifyForm(formArray)
                {
                    var retObj = {};
                    for(var field in formArray)
                    {
                        retObj[field['name']] = field['value'];
                    }
                    return retObj;
                }
                
                $('#tblSignup').click(function(){
                    // Serialize form to JSON Array
                    var formData = getFormData($('#regForm'));
                    var isValid = true; //diisi enggaknya
  
                    // cek kosong enggaknya
                    $('.wajibdiisi').each(function()
                    {
                       var eldt = $(this);
                       if(eldt.val() === "")
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
                            data: {action: 'registerUser', json: JSON.stringify(formData) },
                            async: false, // dikirim ketika semua beres
                            timeout: 5000,
                            success: function(msgStatus)
                            {
                                $('#messageTitle').html(msgStatus.title);
                                $('#messagePoint').html(msgStatus.message);
                                $('#modalMessage').show();
                                
                                if(msgStatus.status === "OK")
                                {
                                    $('#tblHome').show();
                                    $('#tblOk').hide();
                                   // confirm(msgStatus.title + "\n" + msgStatus.message);
    //                                $('.modal-content').html('<a href="../"><button class="b-signin">' + msgStatus.message +' </button></a>');
                                   // window.location = "../";
                                }
                                else 
                                {
                                    $('#tblHome').hide();
                                    $('#tblOk').show();
                                   // confirm(msgStatus.title + "\n" + msgStatus.message);
                                } 
                            },
                            failure: function(errMsg) {
                                confirm(errMsg);
                            }
                        });
                    }
                    else
                    {
                        $('#messageTitle').html("Wajib Diisi!");
                        $('#messagePoint').html("Please fill the field fullname, username, email, and password!");
                        $('#modalMessage').show(); // tampilkan modal
                        $('#tblHome').hide(); // kembali ke home
                        $('#tblOk').show(); // klik ok
                        //confirm("Mohon fullname, username, email, password Wajib Diisi!");
                    }
                });
            });
            