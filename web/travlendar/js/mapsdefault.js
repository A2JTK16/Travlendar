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
            click: function(e) 
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
                                
                    var selectedMode = document.getElementById('transportMode').value;
                                
				// If two markers have been placed
                    if (m1 !== null && m2 !== null) 
                    {
                        
                        mapObj.drawRoute({
                            origin: [m1pos.lat(), m1pos.lng()],
                            destination: [m2pos.lat(), m2pos.lng()],
                            travelMode: google.maps.TravelMode[selectedMode],
                            strokeColor: '#131540',
                            strokeOpacity: 0.6,
                            strokeWeight: 6
                        });
			//$('#trace_route').prop('disabled', false);
                    }
			
                    var origin = new google.maps.LatLng(m1pos.lat(),m1pos.lng()),
                    destination = new google.maps.LatLng(m2pos.lat(),m2pos.lng()),
                    service = new google.maps.DistanceMatrixService();

                    service.getDistanceMatrix(
                        {
                            origins: [origin],
                            destinations: [destination],
                            travelMode: google.maps.TravelMode[selectedMode],
                            avoidHighways: false,
                            avoidTolls: false
                        }, 
                        callback
                    );

                    function callback(response, status) 
                    {
                        var orig = document.getElementById("orig"),
                        dest = document.getElementById("dest"),
                        dist = document.getElementById("dist");
                        if(status=="OK") 
                        {
                            dest.value = response.destinationAddresses[0];
                            orig.value = response.originAddresses[0];
                            dist.value = response.rows[0].elements[0].distance.text;
                        } 
                        else 
                        {
                            alert("Error: " + status);
                        }
                    }
                                
                             

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
                    var row = '<tr><td>'+ event.title +'</td><td>'+ moment(event.start).format("ddd DD-MM-YYYY hh:mm a")
                             +'</td><td> </td><td> </td><td></td>'+ address +'<td> \n\
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
                   
                    if(m2 !== null)
                    {
                        eventTraveller['title'] = $('#eventName').val();
                        eventTraveller['start'] = new Date($('#origDate').val() +" "+$('#origTime').val());
                        eventTraveller['end'] = new Date($('#destDate').val() +" "+$('#destTime').val());
                        eventTraveller['note'] = $('#noteDesc').val();
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