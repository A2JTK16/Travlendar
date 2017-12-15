/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 *  
 * Materi OOP di Javascript 
 * http://codelikethis.com/lessons/javascript/object_oriented_javascript
 * 
*/

/**
 * Objek ListEvent
 * @param {type} list harus array
 * @returns {ListEvent}
 */
var ListEvent = function(list)
{
    /**
     * Setter List
     * @param {type} listTravellerEvent
     * @returns {undefined}
     */
    this.setList = function(listTravellerEvent)
    {
        list = listTravellerEvent;
    };
    
    /**
     * Method untuk menambahkan row ke list
     * @param {type} rowEvent
     * @returns {undefined}
     */   
    this.addEvent = function(rowEvent)
    {
        list.push(rowEvent);
    };
    
    /**
     * Getter List
     * @returns {type|@var;listTravellerEvent}
     */
    this.getList = function()
    {
        return list;
    };
    
    /**
     * Method untuk mendapatkan event terkhir
     * @returns {ListEvent.list|@var;listTravellerEvent|type}
     */
    this.getLastEvent = function()
    {
        return list[list.length-1];
    };
    
    /**
     * Method untuk mendapatkan objek event yg tersimpan di event sebelumnya
     * @param {type} curIndexRow
     * @returns {ListEvent.list|@var;listTravellerEvent|type}
     */
    this.getLastEvent = function(curIndexRow)
    {
        var singleEvent;
        
        if(curIndexRow > 0)
        {
            singleEvent = list[curIndexRow-1];
        }
        else
        {
            singleEvent = {};
        }
        return singleEvent;
    };
    
    /**
     * Method untuk mengembalikan tanggal event terakhir
     * format YYYY-MM-DD
     * wajib pakai momentjs library
     * @returns {unresolved} karena momentjs belum include disini
     */
    this.getLastEventDate = function()
    {
        var singleEvent;
        var lastdt;
        
        if(list.length > 0)
        {
            singleEvent = list[list.length-1];
        }
        else
        {
            singleEvent = {};
            singleEvent.start = "2017-12-12";
        }
        
        lastdt = moment(singleEvent.start).format("YYYY-MM-DD");
        return lastdt;
    };
    
};

var TabView = function(objMap)
{
    this.viewMore = function(event){
        // set ke tampilan baru
            $('#moreTitle').val(event.title);
            $('#moreStart').val(event.start);
            $('#moreMode').val(event.transportation);
            $('#moreDepature').val(event.depature_time);
            $('#moreAddress').val(event.address);
            // buka tab
            openCity(event, 'MoreEvent');
            // pindahkan peta
        /*    $('#map').appendTo('#moreLeft'); */
            // hapus polylines
       /*     objMap.removePolylines();
            // tambahkan rute
            
            
                var partpath = [];
                partpath.push([-6.872034, 107.574794]);
                partpath.push([event.latitude, event.longitude]);
                
                objMap.addMarker({
                    lat: event.latitude,
                    lng: event.longitude,
                    title: event.title
                });
               
                objMap.drawPolyline({
                    path: partpath,
                    strokeColor: '#0000FF', //warna line
                    strokeOpacity: 1, //transparansi
                    strokeWeight: 6 //lebar line
                });

                objMap.setCenter(event.latitude, event.longitude);  */
    };

};
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
    /**
     * Untuk Akses Controller
     * @param {type} urlController
     * @returns {mapsdefaultL#119.ControllerAccesser}
     */
    var ControllerAccesser = function(urlController)
    {
        /**
         * Method untuk mendapatkan list json
         * @param {type} successFunc
         * @returns {undefined}          
         */
        this.getJson = function(successFunc)
        {
            $.ajax({
                type: "GET",
                dataType : 'JSON',
                data: {action: 'getlistEvent'},
                contentType : "application/json",
                url: urlController,
                success: successFunc,
                error: function(xmlhttprequest, textstatus, message)
                {
                    alert(textstatus + message);
                }
            });
        };
        
        /**
         * Method untuk mengirimkan event json ke controller
         * @param {type} dataJson
         * @returns {undefined}
         */
        this.sendEvent = function(dataJson){
            $.ajax({
                type: "POST", // method post
                url: urlController,
                dataType:'JSON',
                data: {action: 'addEvent', json: JSON.stringify(dataJson)},
                async: false, // dikirim ketika semua beres
                success: function(msgStatus)
                {
                    alert(msgStatus);
                },
                error: function(xmlhttprequest, textstatus, message)
                {
                    alert(textstatus + message);
                }
            });  
        };
        
        /**
         * Method untuk delete data
         * @param {type} idEvent
         * @param {type} currentRow
         * @param {type} rowIndex
         * @param {type} objCal
         * @returns {undefined}
         */
        this.deleteEvent = function(idEvent, currentRow, rowIndex, objCal)
        {
            $.ajax({
                type: "POST", // method post
                url: urlController,
                dataType:'JSON',
                data: {action: 'deleteEvent', event_id: idEvent },
                async: false, // dikirim ketika semua beres
                success: function(msgStatus)
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
                        objCal.deleteEvent(idEvent);
                        delete pathi[rowIndex];
                    }
                },
                error: function(xmlhttprequest, textstatus, message)
                {
                    alert(textstatus + message);
                }
            });
        }
    };
    
    /**
     * Table Event
     * @param {type} cssIdTable
     * @returns {mapsdefaultL#119.TableEvent}
     */
    var TableEvent = function(cssIdTable)
    {  
        /**
         * Method untuk menambahkan isi body tabel
         * @param {type} item
         * @returns {undefined}
         */
        this.writeRow = function(item)
        {
            var row =  '<tr><td style="display:none">'+ item.id +'</td>\n\
                            <td>'+ item.title + '</td>\n\
                            <td>'+ moment(item.start).format("ddd DD-MM-YYYY hh:mm a") + '</td>\n\
                            <td>'+ item.transportation + '</td>\n\
                            <td>'+ moment(item.departure_time).format("ddd DD-MM-YYYY hh:mm a") + '</td>\n\
                            <td>'+ item.address +'</td>\n\
                            <td><button class="v-more"> View More </button> <button class="v-del"> Delete </button></td>\n\
                        </tr>';
            $( cssIdTable +' > tbody').append(row);
        };
        
        /**
         * Menentukan aksi thd id
         * @param {type} action misal 'click'
         * @param {type} cssId misal 'btn-del'
         * @param {type} actionFunc isi fungsi aksinya dg parameter currentRow dan rowIndex
         * @returns {undefined}
         */
        this.actionListener = function(action, cssId, actionFunc)
        {
            $(cssIdTable).on(action, cssId, function() 
            {
                var currentRow = $(this).closest("tr");
                var rowIndex = $(this).parent().index();
                actionFunc(currentRow, rowIndex);
            });
        };
        
        /**
         * Mendapatkan ID CSS Table
         * @returns {type}
         */
        this.getCssId = function()
        {
            return cssIdTable;
        };
    };
    
    /**
     * Kalender
     * @param {type} cssIdCalendar
     * @returns {mapsdefaultL#119.FullCalendar}
     */
    var FullCalendar = function(cssIdCalendar)
    {
        /**
         * 
         * @param {type} list
         * @param {type} funcClick
         * @returns {undefined}
         */
        this.writeCal = function(list, funcClick)
        {
            $(cssIdCalendar).fullCalendar({
                header: {
                    left: 'prev,next today',
                    center: 'title',
                    right: 'month,agendaWeek,agendaDay,listWeek'
                },
                navLinks: false, 
                editable: false,
                eventLimit: true, // allow "more" link when too many events
                events: list,
                eventClick: funcClick
            });
        };
        
        /**
         * Method untuk mengarahkan kalender ke tanggal tertentu
         * @param {type} gdate
         * @returns {undefined}
         */
        this.gotoDate = function(gdate)
        {
            $(cssIdCalendar).fullCalendar('gotoDate', gdate);
        };
        
        /**
         * Method untuk menghapus event di kalender dengan ID
         * @param {type} idEvent
         * @returns {undefined}
         */
        this.deleteEvent = function(idEvent)
        {
            $(cssIdCalendar).fullCalendar( 'removeEvents', [idEvent] );
        };
    };
    
    /**
     * Objek Maps
     * @param {type} cssIdMap
     * @param {type} clickFunc
     * @returns {a2eventL#160.GmapsEvent}
     */
    var GmapsEvent = function(cssIdMap, clickFunc)
    {
        /**
         * Atribut Public Maps Nya
         */
        this.objMaps = new GMaps({
            el: cssIdMap,
            click: clickFunc
        });
        
        /**
         * Untuk Menggambar Rute
         * @param {type} arrLatLngOrigin
         * @param {type} arrLatLngDest
         * @param {type} mode
         * @param {type} stepJsonFunc
         * @returns {undefined}
         */
        this.drawRoutes = function(arrLatLngOrigin, arrLatLngDest, mode, stepJsonFunc)
        {
            this.objMaps.travelRoute({
                origin: arrLatLngOrigin,
                destination: arrLatLngDest,
                travelMode: mode,
                step: stepJsonFunc
            });
        };
        
        /**
         * Untuk Menggambar Polylines
         * @param {type} arrayObjLatLng
         * @returns {undefined}
         */
        this.drawPolylines = function(arrayObjLatLng)
        {
            this.objMaps.drawPolyline({
                path: arrayObjLatLng,
                strokeColor: '#131540',
                strokeOpacity: 0.6,
                strokeWeight: 6
            });
        };
        
        /**
         * Untuk Mengarahkan Geolocation
         * @returns {undefined}
         */
        this.setGeolocate = function()
        {
            GMaps.geolocate({
                success: function(position) {
                  this.objMaps.setCenter(position.coords.latitude, position.coords.longitude);
                },
                error: function(error) {
                  alert('Geolocation failed: '+error.message);
                },
                not_supported: function() {
                  alert("Ga support euy");
                },
                always: function() {
                  alert("Beres");
                }
            });
        };
        
        /**
         * Untuk Mengubah Orientasi Maps
         * @param {type} latitude
         * @param {type} longitude
         * @returns {undefined}
         */
        this.setCenter = function(latitude, longitude)
        {
            this.objMaps.setCenter(latitude, longitude);
        };
        
    };
    
    // yg bertugas kurirnya controller
    var objAccess = new ControllerAccesser("http://localhost:8080/Travlendar2A/index");
    
    // array path untuk polylines
    var pathi = new Array();
    
    // array obj event
    var objListEvent = new ListEvent(new Array());
    
    // table event
    var objTableEvent = new TableEvent("#tableEvent");
    
    // calendar
    var objCalendar = new FullCalendar("#calendar");
    
    // view tab
    var tabView = new TabView({});
    
    // maps nya
    //var mapObj = new GmapsEvent('#map');
    
    //var lastLat, lastLng;
    // mendapatkan json dari controller
    objAccess.getJson(function(data){
        // loop list
        $.map(data, function(item,i)
            {
                item.start = moment(item.start).format();
                item.end = moment(item.end).format();
                item.depature_time = moment(item.departure_time).format("ddd DD-MM-YYYY hh:mm a");
                // memasukkan kedalam list json
                objListEvent.addEvent(item);
                // memasukkan dan menampilkan dalam tabel
                objTableEvent.writeRow(item);
                // array lat lng
                pathi.push([item.latitude, item.longitude]);
                
               // lastLat = item.latitude;
               // lastLng = item.longitude;
            });
            
            // memasukkan data kedalam kalendar
            objCalendar.writeCal(objListEvent.getList(),function(calEvent, jsEvent, view){
                tabView.viewMore(calEvent);
            });

            // set ke event terakhir
            objCalendar.gotoDate(objListEvent.getLastEventDate());
    });
                     
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
			m1 = mapObj.addMarker({
                            lat: e.latLng.lat(),
                            lng: e.latLng.lat()//,
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
                            travelMode: 'transit',
                            avoidHighways: false,
                            avoidTolls: false
                        }, 
                        callback_transit
                    );

                    function callback_transit(response, status) 
                    {

                        
                        var dist = document.getElementById("dest"),
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
        
        //mapObj.setCenter(lastLat, lastLng);
        
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
        
        $('#defaultOpenNew').click(function()
        {
            mapObj.cleanRoute();
            
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
            
            mapObj.drawPolyline({
                path: pathi,
                strokeColor: '#0000FF', //warna line
                strokeOpacity: 1, //transparansi
                strokeWeight: 10 //lebar line
            });
            
            //mapObj.setCenter([pathi.length - 1][0], [pathi.length - 1][1]);
        
            $('#map').appendTo('#mapNewEvent');
            
            openCity(event, 'London');
        });
        
        function showInstructions(stepsJson)
        {
           // $('#mapInstuctions').append(stepsJson.html_instructions);
        }
        
        $('#defaultOpen').click(function()
        {
            mapObj.cleanRoute();
            
            mapObj.drawPolyline({
                path: pathi,
                strokeColor: '#0000FF', //warna line
                strokeOpacity: 1, //transparansi
                strokeWeight: 10 //lebar line
            });
            
            //mapObj.setCenter([pathi.length - 1][0], [pathi.length - 1][1]);
        
            $('#map').appendTo('#mapsBottom');
            
            openCity(event, 'Tasik');
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
                    travelMode: 'transit',
                    avoidHighways: false,
                    avoidTolls: false
                }, 
                callback_transit
            );

            function callback_transit(response, status)  // JANGAN DIULANG2, JADIIN FUNGSI AJA
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
                            if(comparation > estimate){ // GAK SALAH IF DI LOOP ???
                                document.getElementById('radio').style.visibility = 'hidden';
                                transit.value = "can't be used";
                            }
                            else if (comparation < estimate){
                                document.getElementById('radio').style.visibility = 'visible';
                                transit.value=duration;
                            }
                            showInstructions(element,'transit');        
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
                                walking.value = "can't be used";
                                document.getElementById('radio1').style.visibility = 'hidden';
                            }
                            else if(comparation<estimate){
                                document.getElementById('radio1').style.visibility = 'visible';
                                walking.value=duration;
                            }
                            showInstructions(element, 'walking');  
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
                                driving.value = "can't be used";
                            }
                            else if(comparation<estimate){
                                document.getElementById('radio2').style.visibility = 'visible';
                                driving.value=duration;
                            }
                            showInstructions(element, 'driving');   
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
                                bicycling.value = "can't be used";
                            }
                            else if(comparation<estimate){
                                document.getElementById('radio3').style.visibility = 'visible';
                                bicycling.value=duration;
                            }
                            showInstructions(element, 'bicycling');  
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
            var eventAddress = currentRow.find("td:eq(5)").html();

            
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
                        
                        objAccess.sendEvent(eventDesc);
                    }
                    else
                        alert("Mohon klik tujuan anda!");
                });
                
    objTableEvent.actionListener('click','.v-del', function(currentRow, rowIndex){
        var idEvent = currentRow.find("td:eq(0)").html();
        objAccess.deleteEvent(idEvent, currentRow, rowIndex, objCalendar);
        $('#map').appendTo('#moreLeft');
    });                                 
        
                // Get the modal
                var modal = document.getElementById('myModal');
                                
                $('#myBtn').click(function(){
                    $('#map').appendTo('#mapPopup');
                    modal.style.display = "block";
                });
                                 
                $('.close').click(function(){
                    $('#map').appendTo('#mapNewEvent');
                    modal.style.display = "none";
                });

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
                                                
                                                
                                                
                                             
