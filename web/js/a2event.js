/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 *  
 * Materi OOP di Javascript 
 * http://codelikethis.com/lessons/javascript/object_oriented_javascript
 * 
*/

// JQuery
$(document).ready( function()  // Ketika web udah siap
{
    /**
     * Objek untuk Tab baru
     * @param {type} objMap
     * @returns {TabView}
     */
    var TabView = function(objMap)
    {
        /**
         * Marker GMaps
         * @type type
         */
        var markerView1, markerView2;
        
        /**
         * Method untuk membuka tab
         * @param {type} cssIdTabContent css id konten tabnya
         * @param {type} cssIdTab css id tabnya
         * @returns {undefined}
         */
        this.openTab = function(cssIdTabContent, cssIdTab)
        {
           $('.tabcontent').hide();
           $('.tablinks').removeClass('.active');
           $(cssIdTabContent).show();
           $(cssIdTab).addClass('.active');
        };

       /**
        * Method untuk menampilkan tampilan view more
        * @param {type} eventE
        * @param {type} mapEvent
        * @returns {undefined}
        */
        this.viewMore = function(eventE, mapEvent){
           // set ke tampilan baru
           $('#moreTitle').val(eventE.title.toString());
           $('#moreStart').val(eventE.start); 
           $('#moreMode').val(eventE.transportation);
           $('#moreDepature').val(moment(eventE.depature_time).format());
           $('#moreAddress').val(eventE.address);
           $('#moreNote').val(eventE.note);
           // buka tab
           this.openTab('#MoreEvent','#MoreEvent');
           // pindahkan peta
           $('#map').appendTo('#moreLeft');
           $('#mapInstruction').appendTo('#moreLeft');
           // setting maps ke tengah lokasi event
           if( typeof eventE.latitude !== 'undefined' || typeof eventE.longitude !== 'undefined')
           {
               // clean routes
                mapEvent.cleanRoutes();
                mapEvent.objMaps.removeMarkers();
                
                mapEvent.objMaps.setCenter(eventE.latitude, eventE.longitude);
                
                
                mapEvent.objMaps.drawRoute({
                    origin: [eventE.start_latitude, eventE.start_longitude],
                    destination: [eventE.latitude, eventE.longitude],
                    travelMode: eventE.transportation.toString(),
                    strokeColor: '#131540',
                    strokeOpacity: 0.7,
                    trokeWeight: 6
                });
                
                
                
                // hilangkan marker
                if( this.markerView1 !== 'undefined' )
                    mapEvent.objMaps.removeMarker(this.markerView1);
                
                if( this.markerView2 !== 'undefined' )
                    mapEvent.objMaps.removeMarker(this.markerView2);
                
                // tambah marker
                this.markerView1 = mapEvent.objMaps.addMarker({
                    lat: eventE.latitude,
                    lng: eventE.longitude,
                    title : 'event location',
                    icon: 'http://maps.google.com/mapfiles/ms/icons/red-dot.png'
                });
                
                this.markerView2 = mapEvent.objMaps.addMarker({
                    lat: eventE.start_latitude,
                    lng: eventE.start_longitude,                          
                    icon: 'http://maps.google.com/mapfiles/ms/icons/green-dot.png',
                    title: 'previous location'
                });
           }
       };

    };
    
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
                type: 'GET',
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
                type: 'POST', // method post
                url: urlController,
                data: {action: 'addEvent', json: JSON.stringify(dataJson)},
                async: false, // dikirim ketika semua beres
                success: function(msgStatus)
                {
                    confirm(msgStatus);
                },
                error: function(xmlhttprequest, textstatus, message)
                {
                    confirm(textstatus + message);
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
                data: {action: 'deleteEvent', event_id: idEvent },
                async: false, // dikirim ketika semua beres
                success: function(msgStatus)
                {
                   
                    if(msgStatus.status === "OK")
                    {
                        currentRow.remove();
                       // objCal.deleteEvent(idEvent);
                        $("#calendar").fullCalendar( 'removeEvents', [idEvent] );
                        delete pathi[rowIndex];
                    }
                    confirm(msgStatus.message);
                   // alert(msgStatus);
                   // alert(idEvent);
                },
                error: function(xmlhttprequest, textstatus, message)
                {
                    confirm(textstatus + message);
                }
            });
        };
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
         * @param {type} row html
         * @returns {undefined}
         */
        this.appendRow = function(row)
        {
            $( cssIdTable +' > tbody').append(row);
        };
        
        /**
         * Method untuk menambahkan isi body tabel
         * @param {type} item objek json
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
        
        /**
         * Mendapatkan event berdasarkan id atau fungsi filter
         * @param {type} idOrFilter
         * @returns {unresolved}
         */
        this.getEvent = function(idOrFilter)
        {
            var sEvent;
            sEvent = $(cssIdCalendar).fullCalendar('clientEvents', idOrFilter);
            return sEvent;
        };
        
        /**
         * Mengubah tampilan calendar
         * @param {type} viewName berupa 
         * month, basicWeek, basicDay, agendaWeek, agendaDay, 
         * listYear, listMonth, listWeek, atau listDay
         * @returns {undefined}
         */
        this.changeCalView =  function(viewName)
        {
            $(cssIdCalendar).fullCalendar('changeView', viewName);
        };
    };

    /**
     * apakah bisa ditambah marker atau tidak
     * @type Boolean
     */
    var isAddableMarker = false;
    
    /**
     * Posisi Dua Marker 
     * simple singleton
     * @type type
     *
    var objectPosition = {
        // isi marker 1 atau marker 2
        isMarker1 : true,
        
        **
         * Mendapatkan object marker 
         * @returns {unresolved} markerP
         *
        getMarker : function()
        {
            var markerP;
            // mendapatkan posisi marker 1 atau marker 2
            if(this.isMarker1)
            {
                markerP = this.m1.getPosition();
            }
            else
            {
                markerP = this.m2.getPosition();
            }
            return markerP;
        },
        
        **
         * Setter Marker
         * @param {type} markerMap
         * @returns {undefined}
         *
        setMarker : function(markerMap)
        {
            if(this.isMarker1)
                this.m1 = markerMap;
            else
                this.m2 = markerMap;
            
            this.isMarker1 = !this.isMarker1;
        }

    };
    *
    var delegateClickMap = function(e)
    {
        var lastMarker = objectPosition.getMarker();
        objMap.removeMarker(lastMarker);
        objMap.removePolylines();
        
        var markerAdd = objMap.addMarker({
            lat: e.latLng.lat
        });
    };
    */
           /**
         * 
         * @type markerP
         */
    /**
     * Google Maps
     * @param {type} newObjMap
     * @returns {a2eventL#12.A2Gmaps}
     */
    var A2Gmaps = function(newObjMap)
    {            
        /**
         * Atribut Public Maps Nya
         * Konstruktor
         */
        this.objMaps = newObjMap;
        
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
            var mapR = this.objMaps;
            GMaps.geolocate({
                success: function(position) {
                  mapR.setCenter(position.coords.latitude, position.coords.longitude);
                },
                error: function(error) {
                  confirm('Geolocation failed: '+error.message);
                },
                not_supported: function() {
                  confirm("Your browser is not supported Geolocation");
                }
            });
        };
        
        /**
         * Untuk menambahkan marker
         * @param {type} latitude
         * @param {type} longitude
         * @param {type} titleEv
         * @param {type} infoContent
         * @param {type} clickFunc
         * @returns {undefined}
         */
        this.addMarker = function(latitude, longitude, titleEv, infoContent, clickFunc)
        {
            this.objMaps.addMarker({
                lat: latitude,
                lng: longitude,
                title: titleEv,
                info: infoContent,
                click: clickFunc
            });
        };
        
        /**
         * Menambahkan aksi pada peta 
         * @param {type} eventAction aksi apa, clik, center_changed, dll
         * @param {type} actionFunc fungsi dijalankan ketika aksi tsb
         * @returns {undefined}
         */
        this.addListener = function(eventAction, actionFunc)
        {
            if(typeof google !== "undefined")
            {
                // objMaps.map pada libray gmaps.js mengembalikan nilai google.maps.Map
                var gmapsO = this.objMaps.map;
                google.maps.event.addListener(gmapsO, eventAction, actionFunc);
                //this.objMaps.map = gmapsO;
                //alert('Sukses listener');
            };
        };
        
        /**
         * Menghilagkan aksi pada peta lih google docs
         * @param {type} eventAction
         * @returns {undefined}
         */
        this.clearListeners = function(eventAction)
        {
            if(typeof google !== 'undefined')
            {
                // objMaps.map pada libray gmaps.js mengembalikan nilai google.maps.Map
                google.maps.event.clearListeners(this.objMaps.map, eventAction);
            };
        };
        
        /**
         * Eksekusi distance matrix service google
         * @param {type} objSetting
         * @param {type} callbackFunc
         * @returns {undefined}
         */
        this.distanceMatrix = function(objSetting, callbackFunc)
        {
            if(typeof google !== 'undefined')
            {
                var service = new google.maps.DistanceMatrixService();
                service.getDistanceMatrix(objSetting, callbackFunc);
            };
        };
        
        /**
         * Mengubah lat,lng menjadi string
         * @param {type} latLng
         * @returns {String}
         */
        this.reverseGeocode = function(latLng)
        {
            // menyimpan alamat
            var faddress;
            // geocoding
            GMaps.geocode({
                location: latLng,
                callback: function(result, status)
                {
                    if(status == "OK")
                    {
                        faddress = result[0].formatted_address.toString();
                    }
                    else
                    {
                        faddress = "Error! not found";
                    }
                }
            });
            // mengembalikan string alamat
            return faddress;
        };
        
        /**
         * Mendapatkan lat, lng dari alamat
         * @param {type} addressStr
         * @returns {unresolved}
         */
        this.geocodeLatLng = function(addressStr)
        {
            // menyimpan alamat
            var latLng;
            // geocoding
            GMaps.geocode({
                address: addressStr,
                callback: function(result, status)
                {
                    if(status == "OK")
                    {
                        latLng = result[0].geometry.location;
                    }
                    else
                    {
                        latLng = {};
                    }
                }
            });
            // mengembalikan string alamat
            return latLng;
        };
        
        /**
         * Menggambar Rute dengan Animasi
         * @param {type} travelMode
         * @param {type} arrLatLngOrig
         * @param {type} arrLatLngDest
         * @returns {undefined}
         */
        this.drawRoutesAnimated = function(travelMode, arrLatLngOrig, arrLatLngDest)
        {
            this.drawRoutes(
                arrLatLngOrig, 
                arrLatLngDest, 
                travelMode, 
                function(e){
                    // tampilkan instruksi
                    $('#mapInstruction').html('<h1>' + travelMode + '</h1>');
                    $('#mapInstruction').append('<li>' + e.instructions + '</li>');
                    // animasi polyline
                    $('#mapInstruction li:eq(' + e.step_number + ')').delay(450 * e.step_number).fadeIn(
                    200,
                    function()
                    {
                        mapObj.objMaps.drawPolyline({
                            path: e.path,
                            strokeColor: '#131540',
                            strokeOpacity: 0.6,
                            strokeWeight: 6
                        });
                    });
                });  
        };
        
        /**
         * Menghapus rute
         * @returns {undefined}
         */
        this.cleanRoutes = function()
        {
            this.objMaps.removePolylines();
        };
    };
    
   /**
    * Mencari selisih dua Date dalam format seconds
    * dengan cara Date 1 - Date 2 tanpa absolut (dapat negatif)
    * @param {type} datetime1
    * @param {type} datetime2
    * @returns {Number}
    */
    var timeDiff = function(datetime1, datetime2)
    {
        // selisih milisecond
        var timed = (datetime1.getTime() - datetime2.getTime());
        // convert ke second
        var second = (timed / 1000);
        // kembalikan
        return second;
    };
    
   
   var markersArray = [];
   
   function clearOverlays() {
    for (var i = 0; i < markersArray.length; i++ ) {
     markersArray[i].setMap(null);
  }
}
    
    // yg bertugas kurirnya controller
    var objAccess = new ControllerAccesser("index");
    
    // array path untuk polylines
    var pathi = [];
    
    // table event
    var objTableEvent = new TableEvent("#tableEvent");
    
    // calendar
    var objCalendar = new FullCalendar("#calendar");
    
    // view tab
    var tabView = new TabView({});
    
    // maps nya
    var mapObj; 
    
    tabView.openTab('#Tasik','#defaultOpen');
    
    //klik tombol back
    $('#moreBack').click(function(){
        isAddableMarker = false;
        
        var view = $('#calendar').fullCalendar('getView');
        
        tabView.openTab('#Tasik','#getList');
        
        $('#calendar').fullCalendar('changeView', view.name, {
            start: view.start,
            end: view.end
        });
    }); 
    
    // marker 1,2
    var m1 = null, m2 = null;
    var m1pos, m2pos; // posisi
    var domarker1 = false, domarker2 = true;
    
    var objMapP = new GMaps({
        el: '#map',
        lat: -6.872034,
        lng: 107.574794,
        zoom: 14,
               
        /*click: function(e) 
        {
            if(isAddableMarker){
                if (domarker1) 
                {
                    objMapP.removeMarker((domarker2) ? m1 : m2);
                    objMapP.removePolylines();
		}

		if (domarker2) 
                {
                    m1 = objMapP.addMarker({
                        lat: e.latLng.lat(),
			lng: e.latLng.lng(),
                        title: 'event location',
			icon: 'http://maps.google.com/mapfiles/ms/icons/red-dot.png'
                    });
                    m1pos = {lat: e.latLng.lat(), lng: e.latLng.lng()};
                } 
		else 
                {
                    m2 = objMapP.addMarker({
			lat: e.latLng.lat(),
			lng: e.latLng.lng(),                          
			icon: 'http://maps.google.com/mapfiles/ms/icons/green-dot.png',
                        title: 'previous location'
                    });
                    m2pos = {lat: e.latLng.lat(), lng: e.latLng.lng()};
		}
                                
                if (m1 !== null && m2 !== null) 
                    {
                        domarker1 = true;
                        
                        objMapP.drawRoute({
                            origin: [m1pos.lat, m1pos.lng],
                            destination: [m2pos.lat, m2pos.lng],
                            travelMode: 'driving',
                            strokeColor: '#131540',
                            strokeOpacity: 0.6,
                            strokeWeight: 6
                        });
                    }
                                
                domarker2 = !domarker2;
                
                if(m1 !== null && m2 !== null)
                {
                    var origin = new google.maps.LatLng(m1pos.lat, m1pos.lng),
                    destination = new google.maps.LatLng(m2pos.lat, m2pos.lng);

                    service = new google.maps.DistanceMatrixService();    

                    service.getDistanceMatrix(
                        {
                            origins: [origin],
                            destinations: [destination],
                            travelMode: "DRIVING",
                            avoidHighways: false,
                            avoidTolls: false
                        }, 
                        callback
                    );

                    function callback(response, status) 
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
                    
                }
            }//tutup isaddablemarker
        } // tutup e click
        */
    }); // tutup instansiasi gmaps 
    
    mapObj = new A2Gmaps(objMapP);
    var isNotCal = true;
    
    // mendapatkan json dari controller
    objAccess.getJson(function(content){        
        //// memasukkan data kedalam kalendar
        objCalendar.writeCal(content.listEvent,function(calEvent, jsEvent, view){
            // ketika event kalender di klik buka tab view more
            tabView.viewMore(calEvent, mapObj);
        });
        // Set Center ke akhir
        var lastEventObj = content.listEvent[content.listEvent.length - 1];
        mapObj.objMaps.setCenter(lastEventObj.latitude, lastEventObj.longitude);
        
        isNotCal = false;
        
        // masukkan html ke table
        objTableEvent.appendRow(content.htmlTable);
        $('#jv-notif').append(content.notif);
        delete content.htmlTable;
        delete content.notif;
        
        // loop list
        var count = 0;
        $.map(content.listEvent, function(item,i)
        {
            // array lat lng
            pathi.push([item.latitude, item.longitude]);

            count++;
            mapObj.objMaps.addMarker({
                lat: item.latitude,
                lng: item.longitude,
                title: item.title,
                infoWindow: {
                    content: '<p>'+ count + '. ' + item.title +'</p>'
                },
                label: count.toString()
            });
            
        });
        
        mapObj.drawPolylines(pathi);
        
        // zoom
        mapObj.objMaps.zoomIn(4);
        
        // set aksi view more
        $("#tableEvent").on('click', '.v-more', function()
        {
            var currentRow = $(this).closest("tr");
            // mendapatkan data2 
            var event = {};
            event.id = currentRow.find("td:eq(0)").html();
            
            event = objCalendar.getEvent(event.id)[0];
            // tampilkan tab baru
            tabView.viewMore(event, mapObj);
        });
        
    });
    
  //  if(isNotCal)
  //      confirm("Welcome to Travlendar2A!")
    
    mapObj.drawPolylines(pathi);
        
    /**
     * Klik menu tab List
     */
    $('#getList').click(function()
    {
        isAddableMarker = false;
        
        //mapObj.clearListeners('click');
        mapObj.cleanRoutes();
            
       /* mapObj.drawPolylines({
            path: pathi,
            strokeColor: '#0000FF', //warna line
            strokeOpacity: 1, //transparansi
            strokeWeight: 10 //lebar line
        });
            */
        // draw polyline event2
        mapObj.drawPolylines(pathi);
        //mapObj.objMaps.setCenter([pathi.length - 1][0], [pathi.length - 1][1]);
        
        $('#map').appendTo('#mainBottom');
        $('#mapInstruction').appendTo('#mainBottom');
            
        //openCity(event, 'Paris');
        tabView.openTab('#Paris','#getList');
    });
    
    // 
    mapObj.drawPolylines(pathi);
    
    /**
     * Menampilkan View More
     * @param {type} event
     * @returns {undefined}
     */
    function viewMoreFind(event)
    {
        //$('#findEvent').val('');
        // mendapatkan data2 
        event = objCalendar.getEvent(event.id)[0];
        // tampilkan tab baru
        tabView.viewMore(event, mapObj);
    }
    
    // search
    $('#findEvent').on("keyup", function() 
    {
        // mendapatkan string inputan 
        var value = $(this).val();
        // jika lebih dari dua
        if(value.length > 2)
        {
            $('#findResult').html('<ul>'); // tambahkan tabel
            $("#tableEvent tr").each(function(index) 
            {
                if (index >= 0) 
                {

                    $row = $(this);

                    var titleEvent = $row.find("td:eq(1)").text().toLowerCase();
                    var idEvent = parseInt($row.find("td:eq(0)").text());
                    var indexStr = titleEvent.indexOf(value.toString().toLowerCase());
                    if (indexStr !== 0 && indexStr < 0){                     
                    }
                    else
                    {
                        $('#findResult').append('<li class="findResultMore"><button style="padding: 6px 37px; border: none;background:none;font: 14px Arial;font-weight:bold;color:#757575;">'+ titleEvent +'</button></li>');
                       // $('#moreTitle').val(titleEvent);
                        $('.findResultMore').click({id: idEvent}, viewMoreFind);
                    }  
                }
            });
            $('#findResult').append('</ul>');
                    
        }
        else
            $('#findResult').html('');
        
    });
    
    /**
     * Klik menu add new event
     */
    $('#defaultOpenNew').click(function()
    {
        
        var currPos;
        //mapObj.removeMarkers();
        // Bersihkan map dari rute
        mapObj.cleanRoutes();
        // brsihkan listener
        //mapObj.clearListeners('click');
        // Geolokasi
        mapObj.setGeolocate();
        // tambahkan listener
        isAddableMarker = true;
        
        $('#map').appendTo('#mapNewEvent');
        $('#mapInstruction').appendTo('#mapNewEvent');
        
      
     
        //openCity(event, 'London');
        tabView.openTab('#London','#defaultOpenNew');
        
    });
    
    /**
     * Klik Default
     */
    $('#defaultOpen').click(function()
    {
        mapObj.cleanRoutes();
        
        isAddableMarker = false;
        
        mapObj.drawPolylines(pathi);    
       /* mapObj.objMaps.drawPolyline({
            path: pathi,
            strokeColor: '#0000FF', //warna line
            strokeOpacity: 0.5, //transparansi
            strokeWeight: 6 //lebar line
        });
         */   
        //mapObj.setCenter([pathi.length - 1][0], [pathi.length - 1][1]);
        
        $('#map').appendTo('#mapsBottom');
            
        tabView.openTab('#Tasik','#defaultOpen');
    });
    
    /**
     * Klik tobol delete
     */
   /* objTableEvent.actionListener('click','.v-del', function(currentRow, rowIndex){
        var idEvent = currentRow.find("td:eq(0)").html();
        objAccess.deleteEvent(idEvent, currentRow, rowIndex, objCalendar);
        $('#map').appendTo('#moreLeft');
        $('#mapInstruction').appendTo('#moreLeft');
    });
    */
    var idCEvent;
    $(objTableEvent.getCssId()).on('click','.v-del', function(e){
        var currentRow = $(this).closest("tr");
        var rowIndex = $(this).parent().index();
        var titleEvent = currentRow.find("td:eq(1)").html();  
        var isdelete = confirm('Delete '+ titleEvent +' ?');
        if(isdelete)
        {
            var idEvent = currentRow.find("td:eq(0)").html();
            e.preventDefault();
            objAccess.deleteEvent(idEvent, currentRow, rowIndex, objCalendar);
            $('#map').appendTo('#moreLeft');
            $('#mapInstruction').appendTo('#moreLeft');
                    // currentRow.remove();
        }
    });
    var m1 = null, m2 = null;
    
    
    /**
     * Mengubah second to hh hours mm mins 
     * @param {type} sec
     * @returns {String}
     */
    function secToHHMM(sec) 
    {
        var sec_num = parseInt(sec, 10); 
        var hours   = Math.floor(sec_num / 3600);
        var minutes = Math.floor((sec_num - (hours * 3600)) / 60);

        if (hours   < 10) {hours   = "0"+hours;}
        if (minutes < 10) {minutes = "0"+minutes;}
        
        if(hours !== "00")
            return hours+' hours '+ minutes +' mins';
        else if(minutes !== "00") // jika pembulatan hasil bagi tidak samadengan 00
            return minutes +' mins';
        else // pembulatan keatas
            return " 1 mins";
    }

    /**
     * untuk memilih transportation mode dari marker m1 dan m2
     * m1 dan m2 tidk boleh null
     * @param {type} tmdifference selisih waktu
     * @param {type} travelMode mode nya transit, bicycling, travel, dll
     * @param {type} cssIdRadio
     * @param {type} cssIdMsg
     * @param {type} avoidHT
     * @returns {undefined}
     */
    var chooseTransportAct = function(tmdifference, travelMode, cssIdRadio, cssIdMsg, avoidHT)
    {
        //if(m1 != null || m2 != null)
        var origin = $('#orig').val().toString();
        var dest = $('#dest').val().toString();
        var eventName = $('#eventName').val().toString();
        
        //alert(travelMode.toString().toUpperCase());
        
        if(origin !== "" && dest !== "" && eventName !== "")
        mapObj.distanceMatrix(
            {
                origins: [origin],
                destinations: [dest],
                travelMode: travelMode.toString().toUpperCase(),
                avoidHighways: avoidHT,
                avoidTolls: avoidHT
            },
            function(response,status)
            {
                if(status !== 'OK')
                {
                    alert('Error Mendapatkan Data');
                }
                else
                {
                    origin = response.originAddresses[0];
                    dest = response.destinationAddresses[0];
                    
                    var traveltime = 0;
                    // alert(JSON.stringify(response));
                    for (var i = 0; i < response.rows.length; i++) 
                    {
                        var elementsArr = response.rows[i].elements;
                        for (var j = 0; j < elementsArr.length; j++) 
                        {
                            if(elementsArr[j].status === 'OK')
                                traveltime += elementsArr[j].duration.value;
                        }
                    }
                    //alert(tmdifference + ' | ' + traveltime);
                    if(traveltime > tmdifference)
                    {
                        $(cssIdRadio).hide();
                        $(cssIdMsg).val(travelMode + " can't be used");
                    }
                    else if(tmdifference !== 0)
                    {
                        $(cssIdRadio).show().click(function(){
                          
                            
                            //objMapP.drawRoutesAnimated(travelMode, [m1pos.lat, m1pos.lng], [m2pos.lat, m2pos.lng]);
                           objMapP.drawRoute({
                                        origin: [m2poslat,m2poslng],
                                        destination: [m1poslat,m1poslng],
                                        travelMode: travelMode,
                                        strokeColor: '#131540',
                                        strokeOpacity: 0.7,
                                        trokeWeight: 6
                                        });
                                        
                           mapObj.cleanRoutes();
                        });
                        
                        $(cssIdMsg).val( secToHHMM(traveltime) );     
                    }
                }
        });
        else
           
            confirm('Mohon isi lokasi dan Event Anda!...');
    };
    
    /**
     * Klik tombol submit
     */
    $('.submit').click(function()
    {
        // parse date dari form input
        var dateTimeOrigin = new Date($('#origDate').val() +" "+$('#origTime').val());
        var dateTimeDepature = new Date($('#departureDate').val() +" "+$('#departureTime').val());
        //alert(dateTimeOrigin.toString());
        //alert(dateTimeDest.toString());
        // dateTimeOrigin dikurangi dateTimeDest bentuk second
        var tmdifference = timeDiff(dateTimeOrigin, dateTimeDepature);
        //alert(tmdifference);
        chooseTransportAct(tmdifference, 'transit', '#radio', '#transit', false);
        chooseTransportAct(tmdifference, 'walking', '#radio1', '#walking', false);
        chooseTransportAct(tmdifference, 'driving', '#radio2', '#driving', false);
        chooseTransportAct(tmdifference, 'bicycling', '#radio3', '#bicycling', true);
   
    });
       /*    // If two markers have been placed
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
            
    }); */
        
    /**
     * Klik Tombol view more
     */

    var eventDesc = {};
    /**
     * Klik tombol save
     */
    $('#TombolSave').click(function(){
                    
        var event = {};
        var eventLoc = {};
        var eventTravel = {};
                    
        var eventStartLoc = {};
        var value;
        var radios = document.getElementsByName('transportation');
        for (var i = 0, length = radios.length; i < length; i++)
        {
            if (radios[i].checked)
            {
            // do whatever you want with the checked radio
            value = radios[i].value.toString().toLowerCase();
            }
        }
                   
        if(m1pos !== 'undefined' || m2pos !== 'undefined')
        {
            event['title'] = $('#eventName').val();
            event['start'] = new Date($('#origDate').val() +" "+$('#origTime').val());
            event['end'] = new Date($('#destDate').val() +" "+$('#destTime').val());
            event['note'] = $('#noteDesc').val();
                       
            eventTravel['transportation']= value;
            eventTravel['departure_time']= new Date($('#departureDate').val() +" "+$('#departureTime').val());
            //eventTraveller['traveller_id'] = 1;
                        
            eventLoc['latitude'] = m1poslat;
            eventLoc['longitude'] = m1poslng;
            eventLoc['address'] = ($('#orig').val()).substring(0, 59);
                        
            eventStartLoc['latitude'] = m2poslat;
            eventStartLoc['longitude'] = m2poslng;
            eventStartLoc['address'] = ($('#dest').val()).substring(0, 59);
                        
            eventDesc.event = event;
            eventDesc.travel = eventTravel;
            eventDesc.startLocation =  eventStartLoc;
            eventDesc.endLocation = eventLoc;
            
            //eventDesc = jQuery.parseJSON(JSON.stringify(eventDesc));
            //alert(JSON.stringify(eventDesc));
            $.ajax({
                type: 'POST', // method post
                url: 'index',
                data: {action: 'addEvent', json: JSON.stringify(eventDesc)},
                async: false, // dikirim ketika semua beres
                timeout: 6000,
                success: function(msgStatus)
                        {                   
                            if(msgStatus.status == "OK")
                            {
                                event.id = msgStatus.generatedKey;
                                event.address = eventLoc.address;
                                event.depature_time = eventTravel.departure_time;
                                event.transportation = eventTravel.transportation;
                                event.latitude = eventLoc.latitude;
                                event.longitude = eventLoc.longitude;
                                event.start_latitude = eventStartLoc.latitude;
                                event.start_longitude = eventStartLoc.longitude;
                                
                                var timeDiff = Math.abs(new Date().getDay() - event.start.getDay());
                                var diffDays = Math.ceil(timeDiff / (1000 * 3600 * 24));
                                // tulis ke table
                                objTableEvent.writeRow(event);
                                // tambah event
                                $('#calendar').fullCalendar( 'renderEvent', event);
                                $('#jv-notif').append(event.title + " : The Next " + diffDays + " Days");
                                //location.reload();
                                tabView.openTab('#Tasik','#defaultOpen');
                                // draw polyline event baru
                                pathi.push([eventLoc.latitude, eventLoc.longitude]);
                                mapObj.drawPolylines(pathi);
                            }
                            else
                            {
                                confirm(msgStatus.title + '\n' + msgStatus.message);
                            }
                        },
                        error: function(xmlhttprequest, textstatus, message)
                        {
                            confirm(textstatus + message);
                        }
                    });
                    
            if(isNotCal)
                location.reload(true);
                               
        }
        else
            confirm("Mohon klik tujuan anda!");
    });
    
    $('#signout').click(function(){
        $.ajax({
            type: 'POST', // method post
            url: 'index',
            data: {action: 'logout'},
            async: false, // dikirim ketika semua beres
                success: function(msgStatus)
                {
                    location.reload(true);
                },
                error: function(xmlhttprequest, textstatus, message)
                {
                    alert(textstatus + message);
                }
            });  
    });
    /**
     * Klik tombol save
     */
    $('#MoreEdit').click(function(){
                    
        var event = {};
        var eventLoc = {};
        var eventTravel = {};
                    
        var eventStartLoc = {};
       
        //if(m2 !== null)
        //{
            event['title'] = $('#moreTitle').val();
            event['start'] = new Date($('#moreStart').val());
            event['note'] = $('#noteDesc').val();
                       
            eventTravel['transportation']= $('#moreMode').val();
            eventTravel['departure_time']= new Date($('moreDepature').val());
            //eventTraveller['traveller_id'] = 1;
                   
            eventDesc.event = event;
            eventDesc.travel = eventTravel;
            
            $.ajax({
                type: 'POST', // method post
                url: 'index',
                data: {action: 'editEvent', json: JSON.stringify(eventDesc)},
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
                   // }
                   //else
                      //  alert("Mohon klik tujuan anda!");
    });
                                
    $('#myBtn').click(function(){
        $('#mapInstruction').appendTo('#mapPopup');
        $('#map').appendTo('#mapPopup');
        $('#myModal').show();
    });
                                 
    $('.close').click(function(){
        $('#map').appendTo('#mapNewEvent');
        $('#mapInstruction').appendTo('#mapNewEvent');
        $('#myModal').hide();
        $('#mapInstruction').html('');
    });

    /*window.onclick = function(event) {
        if (event.target == modal) {
            modal.style.display = "none";
        }
    }
    */
                   
    /*               
    function initAutocomplete() {
    var map = objMapP;

    var input = document.getElementById('searchmap');
    var searchBox = new google.maps.places.SearchBox(input);
    map.controls[google.maps.ControlPosition.TOP_LEFT].push(input);

  
    searchBox.addListener('places_changed', function () {
        var places = searchBox.getPlaces();

        if (places.length == 0) {
            return;
        }
   
        var bounds = new google.maps.LatLngBounds();
        places.forEach(function (place) {
           
            if (place.geometry.viewport) {
                // Only geocodes have viewport.
                bounds.union(place.geometry.viewport);
            } else {
                bounds.extend(place.geometry.location);
            }
        });
        map.fitBounds(bounds);
    });
    
}
    */
    /*function initializeAutocomplete()
    {
        
        
        if(google !== 'undefined')
        {
            google.maps.event.addDomListener(window, 'load', function () 
            {
                var places = new google.maps.places.Autocomplete($('#searchmap')[0]);

                google.maps.event.addListener(places, 'place_changed', function () {
                    var place = places.getPlace();
                    var address = place.formatted_address;
                    var latitude = place.geometry.location.lat();
                    var longitude = place.geometry.location.lng();

                    if (domarker1) 
                    {
                        objMapP.removeMarker((domarker2) ? m1 : m2);
                        objMapP.removePolylines();
                    }

                    if (domarker2) 
                    {
                            m1 = objMapP.addMarker({
                                lat: latitude,
                                lng: longitude,
                                title : 'event location',
                                icon: 'http://maps.google.com/mapfiles/ms/icons/red-dot.png'
                            });
                            m1pos = {lat: latitude, lng: longitude};
                            
                            $('#orig').val(address);
                    } 
                    else 
                    {
                            m2 = objMapP.addMarker({
                               lat: latitude,
                                lng: longitude,                                    
                                icon: 'http://maps.google.com/mapfiles/ms/icons/green-dot.png',
                                title: 'previous location'
                            });
                            m2pos = {lat: latitude, lng: longitude};
                            
                            $('#dest').val(address);
                    }

                    if (m1 !== null && m2 !== null) 
                    {
                        domarker1 = true;
                        
                        objMapP.drawRoute({
                            origin: [m1pos.lat, m1pos.lng],
                            destination: [m2pos.lat, m2pos.lng],
                            travelMode: 'driving',
                            strokeColor: '#131540',
                            strokeOpacity: 0.6,
                            strokeWeight: 6
                        });
                    }

                    domarker2 = !domarker2;
                    
                    objMapP.setCenter(latitude,longitude);
                    
                    
                    
                });
            });

        };
    };
    
    
    
    // PANGGIL
    initializeAutocomplete();
    */
   
            var geocoder = new google.maps.Geocoder();       
            var m1poslat=null,m1poslng=null,m2poslat=null,m2poslng=null;
            function geocodePosition(pos) {
                geocoder.geocode({
                    latLng: pos
                }, function(responses) {
                    if (responses && responses.length > 0) {
                        updateMarkerAddress(responses[0].formatted_address);
                    } else {
                        updateMarkerAddress('Tidak ada koordinat yang ditemukan!');
                    }
                });
            }
            


            function updateMarkerPosition(latLng) {
                
                m1poslat = latLng.lat();
                m1poslng = latLng.lng();
                
            }

            

            function updateMarkerAddress(str) {
                document.getElementById('orig').value = str;
            }



            
            function geocodePosition1(pos) {
                geocoder.geocode({
                    latLng: pos
                }, function(responses) {
                    if (responses && responses.length > 0) {
                        updateMarkerAddress1(responses[0].formatted_address);
                    } else {
                        updateMarkerAddress1('Tidak ada koordinat yang ditemukan!');
                    }
                });
            }

            
            



            
            function updateMarkerPosition1(latLng) {
                
                m2poslat =   latLng.lat();
                m2poslng =   latLng.lng();
            }
            
            //document.getElementById('info').value=m1pos;

            function updateMarkerAddress1(str) {
                document.getElementById('dest').value = str;
            }

            var marker,marker1;

            function initialize() {
                var latLng = new google.maps.LatLng(-6.872034,107.574794);
                 marker = objMapP.addMarker({
                                lat: latLng.lat(),
                                lng: latLng.lng(),
                                title : 'event location',
                                draggable : true,
                                icon: 'http://maps.google.com/mapfiles/ms/icons/red-dot.png'
                            });
                            
                            m1pos = {lat: latLng.lat(), lng: latLng.lng()};

                 marker1 = objMapP.addMarker({
                                lat: latLng.lat(),
                                lng: latLng.lng(),
                                title : 'previous location',
                                draggable : true,
                                icon: 'http://maps.google.com/mapfiles/ms/icons/green-dot.png'
                            });
                            m2pos = {lat: latLng.lat(), lng: latLng.lng()};


                var input = document.getElementById('orig');
                var autocomplete = new google.maps.places.Autocomplete(input);

                var input1 = document.getElementById('dest');
                var autocomplete1 = new google.maps.places.Autocomplete(input1);

                autocomplete.bindTo('bounds', objMapP);
                autocomplete1.bindTo('bounds', objMapP);

                // Update current position info.
                updateMarkerPosition(latLng);
                updateMarkerPosition1(latLng);
                //geocodePosition(latLng);

                // Add dragging event listeners.
                google.maps.event.addListener(marker, 'dragstart', function() {
                    updateMarkerAddress('Dragging...');
                });

                google.maps.event.addListener(marker, 'drag', function() {
                    updateMarkerPosition(marker.getPosition());
                });
                

                google.maps.event.addListener(marker, 'dragend', function() {
                    geocodePosition(marker.getPosition());
                });


                google.maps.event.addListener(marker1, 'dragstart', function() {
                    updateMarkerAddress1('Dragging...');
                });

                
                google.maps.event.addListener(marker1, 'drag', function() {
                    updateMarkerPosition1(marker1.getPosition());
                });
                

                google.maps.event.addListener(marker1, 'dragend', function() {
                    geocodePosition1(marker1.getPosition());
                });

                google.maps.event.addListener(autocomplete, 'place_changed', function() {
                input.className = '';
                var place = autocomplete.getPlace();
                if (!place.geometry) {
                // Inform the user that the place was not found and return.
                input.className = 'notfound';
                return;
                }

                // If the place has a geometry, then present it on a map.
                if (place.geometry.viewport) {
                objMapP.fitBounds(place.geometry.viewport);
                } else {
                objMapP.setCenter(place.geometry.location);
                objMapP.setZoom(17);  // Why 17? Because it looks good.
                }
                marker.setPosition(place.geometry.location);
                updateMarkerPosition(marker.getPosition());
                geocodePosition(marker.getPosition());

              });



                google.maps.event.addListener(autocomplete1, 'place_changed', function() {
                    input.className = '';
                var place = autocomplete1.getPlace();
                if (!place.geometry) {
                // Inform the user that the place was not found and return.
                input.className = 'notfound';
                return;
                }

                // If the place has a geometry, then present it on a map.
                if (place.geometry.viewport) {
                objMapP.fitBounds(place.geometry.viewport);
                } else {
                objMapP.setCenter(place.geometry.location);
                objMapP.setZoom(17);  // Why 17? Because it looks good.
                }
                marker1.setPosition(place.geometry.location);
                updateMarkerPosition1(marker1.getPosition());
                geocodePosition1(marker1.getPosition());

        });
            }

            // Onload handler to fire off the app.
            google.maps.event.addDomListener(window, 'load', initialize);
            
    $('.downloadPdf').html('<a href="index?action=downloadPdf">Download Plan</a>');
    
}); // tutup JQuery    

/*                        			
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
*/                                              
