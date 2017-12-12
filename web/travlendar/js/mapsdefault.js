/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
			
		


                /* global moment, google, GMaps */

function openCity(evt, cityName) 
                {
			var i, tabcontent, tablinks;
			tabcontent = document.getElementsByClassName("tabcontent");
			for (i = 0; i < tabcontent.length; i++) {
				tabcontent[i].style.display = "none";
			}
			tablinks = document.getElementsByClassName("tablinks");
			for (i = 0; i < tablinks.length; i++) {
				tablinks[i].className = tablinks[i].className.replace("active", "");
			}
			document.getElementById(cityName).style.display = "block";
			evt.currentTarget.className += " active";
		}



        // JQuery
    $(document).ready( function()  // Ketika web udah siap
    {
        var pathi = new Array();
        // Calendar Event
        $.ajax({
            dataType : "json",
            contentType : "application/json",
            url: "http://localhost:8080/Travlendar2A/index?action=getlistEvent",
            success: function(data)
                {
                    var lastDate;

                    $('#calendar').fullCalendar({
                        header: {
                            left: 'prev,next today',
                            center: 'title',
                            right: 'month,agendaWeek,agendaDay,listWeek'
                        },
                        defaultDate: '2017-09-22',
                        navLinks: true, // can click day/week names to navigate views
                        editable: true,
                        eventLimit: true, // allow "more" link when too many events
                        events: $.map(data, function(item,i)
                            {
                                var event = new Object();
                                event.title = item.title;
                                event.start = moment(item.start).format();
                                event.end = moment(item.end).format();
                                event.id = item.id;
                                lastDate = moment(item.start).format('YYYY-MM-DD');
        
                                var row = '<tr><td style="display:none">'+ item.id 
                                        + '</td><td>'+ item.title 
                                        + '</td><td>'+ moment(item.start).format("ddd DD-MM-YYYY hh:mm a") 
                                        + '</td><td>'+ item.transportation 
                                        + '</td><td>'+ moment(item.departure_time).format("ddd DD-MM-YYYY hh:mm a")
                                        + '</td><td>'+ item.address +'</td><td> \n\
                                    <button class="v-more"> View More </button> <button class="v-del"> Delete </button></td></tr>';
                                    $('#tableEvent > tbody').append(row);
                                
                                pathi.push([item.latitude, item.longitude]);
                                
                                return event;
                            })
                        });

                    $('#calendar').fullCalendar('gotoDate', lastDate);
                }   
        });
        
        // Google Maps
        var lastPosition = {};
             
        var destination, service;
	var m1 = null, m2 = null;
	var m1pos, m2pos;
        var geocoder = new google.maps.Geocoder;
        
        document.getElementById("defaultOpen").click();
                   
	var mapObj = new GMaps({
            el: '#map',
            lat: -6.914744,
            lng: 107.609810,
            zoom: 16,
            click: 
                function(e) 
                {
                    if (m2 != null) 
                    {
                        mapObj.removeMarker(m2);
                        mapObj.removePolylines();
                    }

                    if ( m1 == null) 
                    {
                        var eLat, eLng;
                        if(pathi.length > 0)
                        {
                            eLat = pathi[pathi.length - 1][0];
                            eLng = pathi[pathi.length - 1][1];
                        }
                        else
                        {
                            eLat = e.latLng.lat();
                            eLng = e.latLng.lng();
                        }
                        
			m1 = mapObj.addMarker({
                            lat: eLat,
                            lng: eLng//,
					//icon: sourceIcon
                        });
                        
			m1pos = m1.getPosition();
                    } 
                    else 
                    {
			m2 = mapObj.addMarker({
                            lat: e.latLng.lat(),
                            lng: e.latLng.lng()//,
                            //icon: destinationIcon
			});
			m2pos = m2.getPosition();
                    }
                               
                    var origin = new google.maps.LatLng(m1pos.lat(),m1pos.lng()),
                    destination = new google.maps.LatLng(m2pos.lat(),m2pos.lng()),        
                    orig = document.getElementById("orig"),
                    dest = document.getElementById("dest"),
            
            
                     service = new google.maps.DistanceMatrixService();
                    
                    
                    service.getDistanceMatrix(
                        {
                            origins: [origin],
                            destinations: [destination],
                            travelMode: "TRANSIT",
                            avoidHighways: false,
                            avoidTolls: false
                        }, 
                        callback_transit
                    );

                    function callback_transit(response, status) 
                    {

                        
                        var dist = document.getElementById("dist"),
                        transit = document.getElementById("transit");

                        if(status=="OK") 
                        {
                            var origins = response.originAddresses;
                            var destinations = response.destinationAddresses;
                            orig.value = origins;
                            dest.value = destinations;
                           
                        } 
                        else 
                        {
                            alert("Error: " + status);
                        }
                    } // end of callback
                      
                    
                                
            } // tutup fungsi e ketika klik
        }); // tutup instansiasi gmaps    
        
        $('#getList').click(function()
        {
            mapObj.cleanRoute();
            
            mapObj.drawPolyline({
                path: pathi,
                strokeColor: '#0000FF', //warna line
                strokeOpacity: 1, //transparansi
                strokeWeight: 10 //lebar line
            });
            
            //mapObj.setCenter([pathi.length - 1][0], [pathi.length - 1][1]);
        
            $('#map').appendTo('#mainBottom');
            
            openCity(event, 'Paris');
        });
        
        $('.submit').click(function()
        {
            // If two markers have been placed
            var origtime = document.getElementById("origTime");
            var departure = document.getElementById("departureTime");
            var origin = new google.maps.LatLng(m1pos.lat(),m1pos.lng()),
            destination = new google.maps.LatLng(m2pos.lat(),m2pos.lng()),
            service_walking = new google.maps.DistanceMatrixService(),
            service_Driving = new google.maps.DistanceMatrixService(),
            service_bicycling = new google.maps.DistanceMatrixService(),
            service_transit = new google.maps.DistanceMatrixService(),
            
            coba = document.getElementById("coba");
                      
            var timesplit = origtime.value.split(""),
            hours,hours1,minutes,minutes1,hasil,hasilmenit,hasilseluruh,meridian;
            hours = timesplit[0];
            hours1 = timesplit[1];
            minutes = timesplit[3];
            minutes1 = timesplit[4];
            if(meridian = 'PM'){
                hasil = (hours+hours1);
            }
            else if (meridian = 'AM'){
                hasil = hours1;
            }
            hasilmenit = (minutes+minutes1);
            hasilmenit = (hasilmenit *1)*60;
            hasil = (hasil *1)*3600;
            hasilseluruh = hasil + hasilmenit;
                     
            var timesplit1 = departure.value.split(""),
            hoursdeparture,hoursdeparture1,minutesdeparture,minutesdeparture1,hasildeparture,hasilmenitdeparture,hasilseluruhdeparture,meridiandeparture;
            hoursdeparture = timesplit1[0];
            hoursdeparture1 = timesplit1[1];
            minutesdeparture = timesplit1[3];
            minutesdeparture1 = timesplit1[4];
            if(meridiandeparture = 'PM'){
                hasildeparture = (hoursdeparture+hoursdeparture1);
            }
            else if (meridiandeparture = 'AM'){
                hasildeparture = hoursdeparture1;
            }
            hasilmenitdeparture = (minutesdeparture+minutesdeparture1);
            hasilmenitdeparture = (hasilmenitdeparture *1)*60;
            hasildeparture = (hasildeparture *1)*3600;
            hasilseluruhdeparture = hasildeparture + hasilmenitdeparture;
                    
            var estimate = hasilseluruh - hasilseluruhdeparture;
            if(estimate < 1){
                estimate = estimate * -1;
            }
                    
            service_transit.getDistanceMatrix(
                {
                    origins: [origin],
                    destinations: [destination],
                    travelMode: "TRANSIT",
                    avoidHighways: false,
                    avoidTolls: false
                }, 
                callback_transit
            );

            function callback_transit(response, status) 
            {
                var dist = document.getElementById("dist"),
                transit = document.getElementById("transit");
                
                if(status=="OK") 
                {
                    var origins = response.originAddresses;
                    var destinations = response.destinationAddresses;
                          
                    for (var i = 0; i < origins.length; i++) 
                    {
                        var results = response.rows[i].elements;
                        for (var j = 0; j < results.length; j++) 
                        {
                            var element = results[j];
                            var duration = element.duration.text;
                            var comparation = element.duration.value;
                            if(comparation > estimate){
                                document.getElementById('radio').style.visibility = 'hidden';
                                transit.value = "tidak dapat digunakan";
                            }
                            else if (comparation < estimate){
                                document.getElementById('radio').style.visibility = 'visible';
                                transit.value=duration;
                            }
                                    
                        }
                    }
                } 
                else 
                {
                    alert("Error: " + status);
                }
            } // end of callback
    
            service_walking.getDistanceMatrix(
                {
                    origins: [origin],
                    destinations: [destination],
                    travelMode: "WALKING",
                    avoidHighways: false,
                    avoidTolls: false
                }, 
                callback_walking
            );

            function callback_walking(response, status) 
            { 
                var  dist = document.getElementById("dist"),
                walking = document.getElementById("walking");

                if(status=="OK") 
                {
                    var origins = response.originAddresses;
                    var destinations = response.destinationAddresses;
                    for (var i = 0; i < origins.length; i++) 
                    {
                        var results = response.rows[i].elements;
                        for (var j = 0; j < results.length; j++) 
                        {
                            var element = results[j];
                            var duration = element.duration.text;
                            var comparation = element.duration.value;
                            if(comparation > estimate){
                                walking.value = "tidak dapat digunakan";
                                document.getElementById('radio1').style.visibility = 'hidden';
                            }
                            else if(comparation<estimate){
                                document.getElementById('radio1').style.visibility = 'visible';
                                walking.value=duration;
                            }
                        }
                    }
                } 
                else 
                {
                    alert("Error: " + status);
                }
            } // end of callback
              
            service_Driving.getDistanceMatrix(
                {
                    origins: [origin],
                    destinations: [destination],
                    travelMode: "DRIVING",
                    avoidHighways: false,
                    avoidTolls: false
                }, 
                callback_driving
            );

            function callback_driving(response, status) 
            {
                var dist = document.getElementById("dist"),
                driving = document.getElementById("driving");

                if(status=="OK") 
                {
                    var origins = response.originAddresses;
                    var destinations = response.destinationAddresses;
                          
                    for (var i = 0; i < origins.length; i++) 
                    {
                        var results = response.rows[i].elements;
                        for (var j = 0; j < results.length; j++) 
                        {
                            var element = results[j];
                            var duration = element.duration.text;
                            var comparation = element.duration.value;
                                  
                            if(comparation > estimate){
                                document.getElementById('radio2').style.visibility = 'hidden';
                                driving.value = "tidak dapat digunakan";
                            }
                            else if(comparation<estimate){
                                document.getElementById('radio2').style.visibility = 'visible';
                                driving.value=duration;
                            }
                        }
                    }
                } 
                else 
                {
                    alert("Error: " + status);
                }
            } // end of callaback        
                    
            service_bicycling.getDistanceMatrix(
                {
                    origins: [origin],
                    destinations: [destination],
                    travelMode: "BICYCLING",
                    avoidHighways: false,
                    avoidTolls: false
                }, 
                callback_bicycling
            );

            function callback_bicycling(response, status) 
            {            
                var dist = document.getElementById("dist"),
                bicycling = document.getElementById("bicycling");

                if(status=="OK") 
                {
                    var origins = response.originAddresses;
                    var destinations = response.destinationAddresses;
                           
                    for (var i = 0; i < origins.length; i++) 
                    {
                        var results = response.rows[i].elements;
                        for (var j = 0; j < results.length; j++) 
                        {
                            var element = results[j];
                            var duration = element.duration.text;
                            var comparation = element.duration.value;
                            if(comparation < 1){
                                document.getElementById('radio3').style.visibility = 'hidden';
                                bicycling.value = "tidak tersedia";
                            }
                            else if(comparation > estimate){
                                document.getElementById('radio3').style.visibility = 'hidden';
                                bicycling.value = "tidak dapat digunakan";
                            }
                            else if(comparation<estimate){
                                document.getElementById('radio3').style.visibility = 'visible';
                                bicycling.value=duration;
                            }
                        }
                    }
                } 
                else 
                {
                    alert("Error: " + status);
                }
            }
        });
        
        // tombol view more
        $("#tableEvent").on('click', '.v-more', function()
        {
            var currentRow = $(this).closest("tr");
            var rowIndex = parseInt($(this).parent().index());
            // mendapatkan data2 
            var eventId = currentRow.find("td:eq(0)").html();
            var eventTitle = currentRow.find("td:eq(1)").html();
            var eventStart = currentRow.find("td:eq(2)").html();
            var eventMode = currentRow.find("td:eq(3)").html();
            var eventDepature = currentRow.find("td:eq(4)").html();
            var eventAddress = currentRow.find("td:eq(5)").html();;
            // set ke tampilan baru
            $('#moreTitle').val(eventTitle);
            $('#moreStart').val(eventStart);
            $('#moreMode').val(eventMode);
            $('#moreDepature').val(eventDepature);
            $('#moreAddress').val(eventAddress);
            // buka tab
            openCity(event, 'MoreEvent');
            // pindahkan peta
            $('#map').appendTo('#moreLeft');
            // hapus polylines
            mapObj.removePolylines();
            // tambahkan rute
            if(rowIndex > 1)
            {
                var latlngStr = eventAddress.split(',', 2);
                var partpath = [];
                partpath.push([-6.872034, 107.574794]);
                partpath.push([latlngStr[0], latlngStr[1]]);
                //mapObj.addMarker({
                //    lat: parseFloat(latlngStr[0]),
                //    lng: parseFloat(latlngStr[1]),
                //    title: eventTitle
                //  });
                
               // mapObj.drawRoute({
               //     origin: new google.maps.LatLng(-6.872034, 107.574794),
               //     destination: new google.maps.LatLng(parseFloat(latlngStr[0]), parseFloat(latlngStr[1])),
               //     travelMode: String(eventMode),
               //     strokeColor: '#131540',
               //     strokeOpacity: 0.6,
               //     strokeWeight: 6
               // });
               
                mapObj.drawPolyline({
                    path: partpath,
                    strokeColor: '#0000FF', //warna line
                    strokeOpacity: 1, //transparansi
                    strokeWeight: 6 //lebar line
                });
               
                mapObj.setCenter(parseFloat(latlngStr[0]), parseFloat(latlngStr[1]));
            }
        });
        
        GMaps.geolocate({
            success: function(position) 
            {
                mapObj.setCenter(position.coords.latitude, position.coords.longitude);
                    m1 = mapObj.addMarker({
                       lat: position.coords.latitude,
                       lng: position.coords.longitude,
                       title: 'Your current position'
                });
                m1pos = m1.getPosition();
                
            },
            error: function(error) 
            {
                alert('Geolocation failed: ' + error.message);
            },
            not_supported: function() 
            {
                        alert("Your browser does not support geolocation");
            }
        });
        
        
                
                $('#TombolSave').click(function(){
                    
                    var eventTraveller = {};
                    var eventLoc = {};
                    var eventDesc = {};
                    var value;
                    var radios = document.getElementsByName('transportation');
                    for (var i = 0, length = radios.length; i < length; i++)
                    {
                        if (radios[i].checked)
                    {
                        // do whatever you want with the checked radio
                        value = radios[i].value;
                    }
                    }
                   
                    if(m2 !== null)
                    {
                        eventTraveller['title'] = $('#eventName').val();
                        eventTraveller['start'] = new Date($('#origDate').val() +" "+$('#origTime').val());
                        eventTraveller['end'] = new Date($('#destDate').val() +" "+$('#destTime').val());
                        eventTraveller['note'] = $('#noteDesc').val();
                        eventTraveller['transportation']= value;
                        eventTraveller['departure_time']= new Date($('#departureDate').val() +" "+$('#departureTime').val());
                        //eventTraveller['traveller_id'] = 1;
                        
                        eventLoc['latitude'] = m2.getPosition().lat();
                        eventLoc['longitude'] = m2.getPosition().lng();
                        eventLoc['address'] = ($('#orig').val()).substring(0, 59);
                        
                        eventDesc['event'] = eventTraveller;
                        eventDesc['location'] = eventLoc;
                        
                        alert(JSON.stringify(eventDesc));
                        
                        $.ajax({
                            type: "POST", // method post
                            url: "http://localhost:8080/Travlendar2A/index",
                            dataType:'JSON',
                            //   data: {listjson: JSON.stringify(listJson)},
                            data: {action: 'addEvent', json: JSON.stringify(eventDesc)},
                            async: false, // dikirim ketika semua beres
                            complete: function(msgStatus)
                            {
                                alert(msgStatus.responseText);
                            },
                            failure: function(errMsg) {
                                alert(errMsg);
                            }
                        });
                    }
                    else
                        alert("Mohon klik tujuan anda!");
                });
                
                                              
                $("#tableEvent").on('click', '.v-del', function() {                
                    var currentRow = $(this).closest("tr");
                    var col1 = currentRow.find("td:eq(0)").html();
                    var rowIndex = $(this).parent().index();
                    var idEvent = col1;
                    $.ajax({
                            type: "POST", // method post
                            url: "http://localhost:8080/Travlendar2A/index",
                            dataType:'JSON',
                            data: {action: 'deleteEvent', event_id: idEvent },
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
                                    currentRow.remove();
                                    $('#calendar').fullCalendar( 'removeEvents', [col1] );
                                    delete pathi[rowIndex];
                                }
                            },
                            failure: function(errMsg) {
                                alert(errMsg);
                            }
                        });
                });
        
                // Get the modal
				var modal = document.getElementById('myModal');

				// Get the button that opens the modal
				//var btn = document.getElementById("myBtn");

				// Get the <span> element that closes the modal
				//var span = document.getElementsByClassName("close")[0];

				// When the user clicks the button, open the modal 
				//btn.onclick = function() {
				   // modal.style.display = "block";
				//}
                                
                                 $('#myBtn').click(function(){
                                     modal.style.display = "block";
                                 });
                                 
                                 $('.close').click(function(){
                                     modal.style.display = "none";
                                 });
				// When the user clicks on <span> (x), close the modal
				//span.onclick = function() {
				   // modal.style.display = "none";
				//}

				// When the user clicks anywhere outside of the modal, close it
				window.onclick = function(event) {
				    if (event.target == modal) {
				        modal.style.display = "none";
				    }
				}

                
        }); // tutup JQuery    
            
            
            			
				function show()
				{
					if(document.getElementById("hidden-mobile").style.display == 'none')
						document.getElementById("hidden-mobile").style.display = 'block';
					else
						document.getElementById("hidden-mobile").style.display = 'none';
				}
				
				
                                
                                function konfirmasi()
                                                {
                                                tanya = confirm("Anda Yakin Akan Menghapus Data ?");
                                                if (tanya == true) return true;
                                                else return false;
                                                }
                                                
                                                
                                                
                                             
