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
                //var listJson;
                var destination, service;
		var m1 = null, m2 = null;
		var m1pos, m2pos;
		var corvo = false, attano = true;
                
              document.getElementById("defaultOpen").click();
              
		var mapObj = new GMaps({
			el: '#map',
			lat: -6.914744,
			lng: 107.609810,
			zoom: 16,
			click: function(e) 
                            {
				if (corvo) 
                                {
                                    mapObj.removeMarker((attano) ? m1 : m2);
                                    mapObj.removePolylines();
				}

				if (attano) {
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
                                

				// If two markers have been placed
				if (m1 !== null && m2 !== null) {
					corvo = true;
					mapObj.drawRoute({
						origin: [m1pos.lat(), m1pos.lng()],
						destination: [m2pos.lat(), m2pos.lng()],
						travelMode: 'driving',
						strokeColor: '#131540',
						strokeOpacity: 0.6,
						strokeWeight: 6
					});
					//$('#trace_route').prop('disabled', false);
                                        
                                        
				}
				attano = !attano;
			
                                var origin = new google.maps.LatLng(m1pos.lat(),m1pos.lng()),
                                destination = new google.maps.LatLng(m2pos.lat(),m2pos.lng()),
                                service = new google.maps.DistanceMatrixService();

                                service.getDistanceMatrix(
                                    {
                                        origins: [origin],
                                        destinations: [destination],
                                        travelMode: google.maps.TravelMode.DRIVING,
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

                                    if(status=="OK") {
                                        dest.value = response.destinationAddresses[0];
                                        orig.value = response.originAddresses[0];
                                        dist.value = response.rows[0].elements[0].distance.text;
                                    } 
                                    else {
                                        alert("Error: " + status);
                                    }
                                }

                            } // tutup fungsi e ketika klik
		}); // tutup instansiasi gmaps         
                
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
                        attano = !attano;
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
                    if(m2 !== null)
                        $.ajax({
                            type: "POST", // method post
                            url: "http://localhost:8080/Travlendar2A/json",
                            dataType:'JSON',
                            //   data: {listjson: JSON.stringify(listJson)},
                            data: {latitude: m2pos.lat(), longitude: m2pos.lng(), desc: document.getElementById("desc").value},
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
                    else
                        alert("Mohon klik tujuan anda!");
                });
                
            }); // tutup JQuery    