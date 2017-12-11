/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
			
		


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
        var path = [];
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

                    if ( m1 == null) {
			m1 = mapObj.addMarker({
                            lat: e.latLng.lat(),
                            lng: e.latLng.lng()//,
					//icon: sourceIcon
                        });
			m1pos = m1.getPosition();
                    } 
                    else {
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
                            orig.value=origins;
                            dest.value=destinations;
                           
                        } 
                        else 
                        {
                            alert("Error: " + status);
                        }
                    } // end of callback
                      
                    
                                
            } // tutup fungsi e ketika klik
        }); // tutup instansiasi gmaps         
                
        function geocodeLatLng(latlng) 
        {
            var address;
            
            geocoder.geocode({'location': latlng}, function(results, status) 
            {
                if (status === 'OK') 
                {
                    if (results[0]) 
                    {
                        address = results[0].formatted_address;              
                    } 
                    else 
                    {
                          window.alert('No results found');
                    }
                } 
                else 
                {
                    window.alert('Geocoder failed due to: ' + status);
                }
            });
            
            return address;
        }
        
        
        
       
        
        $('#getList').click(function()
        {
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
                    service_transit = new google.maps.DistanceMatrixService();
                    
                 
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
        
        
        
        var pathLocs = [];
        
            $.get("http://localhost:8084/Travlendar2A/index?action=getlistLocation", function(responseJson) 
            {   // Eksekusi URL Controller
                var locLatLng;
                //alert(responseJson);
                $.each(responseJson, function(index, location) 
                {    // Loop pakai Json
                    var lcd = JSON.stringify(location);//alert(lcd);
                    locLatLng = {lat: parseFloat(lcd.lat), lng: parseFloat(lcd.lng)};
                    pathLocs.push(locLatLng);
                });
                
                m1 = mapObj.addMarker(locLatLng);
                m1pos = m1.getPosition();
            }); 
            
            $.get("http://localhost:8084/Travlendar2A/index?action=getlistEvent", function(responseJson) 
            {   // Eksekusi URL Controller
                var locId;
                $.each(responseJson, function(index, event) 
                {    // Loop pakai Json
                    locId = event.location_id - 1;
                    //var address = geocodeLatLng(path[locId]); 
                    var address = JSON.stringify(pathLocs[locId].lat);
                    var row = '<tr><td style="display:none">'+ event.id +'</td><td>'+ event.title +'</td><td>'+ moment(event.start).format("ddd DD-MM-YYYY hh:mm a")
                             +'</td><td>' + event.transportation + '</td><td>'+moment(event.departure_time).format("ddd DD-MM-YYYY hh:mm a")+ '</td><td></td>'+ address +'<td> \n\
                             <a href="view-more.jsp"><button class="v-more"> View More </button></a> <button class="v-del"> Delete </button></td></tr>';
                             $('#tableEvent > tbody').append(row);
                });	
            }); 
        //});       
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
                        eventTraveller['departure_time']=new Date($('#departureDate').val() +" "+$('#departureTime').val());
                        eventTraveller['traveller_id'] = 1;
                    
                        eventDesc['event'] = eventTraveller;
                        eventDesc['location'] = m2.getPosition();
                        
                       // alert(JSON.stringify(eventDesc));
                        
                        $.ajax({
                            type: "POST", // method post
                            url: "http://localhost:8084/Travlendar2A/index",
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
                
                               
                $('#viewList').click(function(){
                    
                    if(m1 !== null)
                        mapObj.removeMarker(m1);
                    if(m2 !== null)
                        mapObj.removeMarker(m2);
                    mapObj.removePolylines();
                    
                    $.get("http://localhost:8084/Travlendar2A/index?action=getlistLocation", function(responseJson) 
                    {          // Eksekusi URL Controller
                        $.each(responseJson, function(index, location) {    // Loop pakai Json
                            for(i=0; i<location.length; i++)
                            {
                                path.push([location[i].lat, location[i].lng]);
                                var row = '<tr><td>'+ location[i].lat +'</td><td> 2017-11-28 1' + i +':00 </td><td> </td><td> </td></td>'+'</td><td></td><td> \n\
                                <a href="view-more.jsp"><button class="v-more"> View More </button></a> <button class="v-del"> Delete </button></td></tr>';
                                $('#tableEvent > tbody').append(row);
                                
                                mapObj.addMarker({
				   lat: location[i].lat,
				   lng: location[i].lng//,
				//icon: destinationIcon
				});
                            }
                        });
                
                        var pl = mapObj.drawPolyline({
                            path: path,
                            strokeColor: '#0000FF', //warna line
                            strokeOpacity: 1, //transparansi
                            strokeWeight: 10 //lebar line
                        });
                    }); 
                    
                });                
                
                $("#tableEvent").on('click', '.v-del', function() {                
                    var currentRow = $(this).closest("tr");
                    var col1 = currentRow.find("td:eq(0)").html();
                    var idEvent = col1;
                    $.ajax({
                            type: "POST", // method post
                            url: "http://localhost:8084/Travlendar2A/index",
                            dataType:'JSON',
                            data: {action: 'deleteEvent', event_id: idEvent },
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
                                                
                                                
                                                
                                             
