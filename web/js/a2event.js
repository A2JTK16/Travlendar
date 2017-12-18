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
        * @param {type} event
        * @param {type} mapEvent
        * @returns {undefined}
        */
        this.viewMore = function(event, mapEvent){
           // set ke tampilan baru
           $('#moreTitle').val(event.title);
           $('#moreStart').val(event.start); 
           $('#moreMode').val(event.transportation);
           $('#moreDepature').val(event.depature_time);
           $('#moreAddress').val(event.address);
           $('#moreNote').val(event.note);
           // buka tab
           this.openTab('#MoreEvent','#MoreEvent');
           // pindahkan peta
           $('#map').appendTo('#moreLeft');
           $('#mapInstruction').appendTo('#moreLeft');
           // setting maps ke tengah lokasi event
           if( typeof event.latitude !== 'undefined' || typeof event.longitude !== 'undefined')
           {
                mapEvent.objMaps.setCenter(event.latitude, event.longitude);
                // tambah marker
                mapEvent.addMarker(event.latitude, event.longitude, event.title, event.start, function(){
                   alert(event.title);
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
    };
    
   /**
    * Mencari selisih dua Date dalam format seconds
    * dengan cara Date 2 - Date 1 tanpa absolut (dapat negatif)
    * @param {type} datetime1
    * @param {type} datetime2
    * @returns {Number}
    */
    var timeDiff = function(datetime1, datetime2)
    {
        // selisih milisecond
        var timed = (datetime2.getTime() - datetime1.getTime());
        // convert ke second
        var second = (timed / 1000);
        // kembalikan
        return second;
    };
      
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
        
        tabView.openTab('#Tasik','#defaultOpen');
        
        $('#calendar').fullCalendar('changeView', view.name, {
            start: view.start,
            end: view.end
        });
    }); 
    
    // marker 1,2
    var m1 = null, m2 = null;
    var m1pos, m2pos; // posisi
    var domarker1 = false, domarker2 = true;
    
    // mendapatkan json dari controller
    objAccess.getJson(function(data){
        var lastEventObj = data[data.length - 1];
        
        var objMapP = new GMaps({
            el: '#map',
            lat: lastEventObj.latitude,
            lng: lastEventObj.longitude,
            zoom: 14,

            click: function(e) 
            {
                if(isAddableMarker)
                {
                    if (domarker1) 
                    {
                        mapObj.removeMarker((domarker1) ? m1 : m2);
                        mapObj.removePolylines();
                    }
                    if (domarker2) {
			m1 = mapObj.addMarker({	lat: e.latLng.lat(),
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
			domarker1 = true;
			mapObj.drawRoute({
					origin: [m1pos.lat(), m1pos.lng()],
					destination: [m2pos.lat(), m2pos.lng()],
                                        travelMode: 'driving',
					strokeColor: '#131540',
					strokeOpacity: 0.6,
                                        strokeWeight: 6
					});
                    }
                    domarker2 = !domarker2;
                    
                    if(typeof google !== 'undefined')
                    {
                        var origin = new google.maps.LatLng(m1pos.lat(),m1pos.lng());
                        var destination = new google.maps.LatLng(m2pos.lat(),m2pos.lng());
                        var service = new google.maps.DistanceMatrixService();

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
                            var orig = $("orig"),
                            dest = $("dest");
                           //         dist = $("dist");

                            if(status=="OK") {
                                dest.value = response.destinationAddresses[0];
                                orig.value = response.originAddresses[0];
                         //               dist.value = response.rows[0].elements[0].distance.text;
                            } 
                            else {
                                        alert("Error: " + status);
                            }
                        }
                    } // tutup fungsi e ketika klik
                }
            }
        }); // tutup instansiasi gmaps         

        
        mapObj = new A2Gmaps(objMapP);
        
        // memasukkan data kedalam kalendar
        objCalendar.writeCal(data,function(calEvent, jsEvent, view){
            // ketika event kalender di klik buka tab view more
            tabView.viewMore(calEvent, mapObj);
        });
        
        // loop list
        $.map(data, function(item,i)
        {
            item.start = moment(item.start).format();
            item.end = moment(item.end).format();
            item.depature_time = moment(item.departure_time).format("ddd DD-MM-YYYY hh:mm a");
            // memasukkan dan menampilkan dalam tabel
            objTableEvent.writeRow(item);
            // array lat lng
            pathi.push([item.latitude, item.longitude]);
            
            mapObj.addMarker(item.latitude, item.longitude, item.title, item.start, function(){
               alert('Title :'+ item.title +'\nDepature Time : ' + item.departure_time + '\n Start Event : '+ item.start);
            });
            
        });
        
        // draw polyline event2
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
        
    /**
     * Klik menu tab List
     */
    $('#getList').click(function()
    {
        isAddableMarker = false;
        
        mapObj.clearListeners('click');
        //mapObj.objMaps.cleanRoute();
            
        mapObj.drawPolylines({
            path: pathi,
            strokeColor: '#0000FF', //warna line
            strokeOpacity: 1, //transparansi
            strokeWeight: 10 //lebar line
        });
            
        //mapObj.setCenter([pathi.length - 1][0], [pathi.length - 1][1]);
        
        $('#map').appendTo('#mainBottom');
        $('#mapInstruction').appendTo('#mainBottom');
            
        //openCity(event, 'Paris');
        tabView.openTab('#Paris','#getList');
    });
    
    // search
    $('#findEvent').on("keyup", function() {
        // mendapatkan string inputan 
        var value = $(this).val();
        // jika lebih dari dua
        if(value.length > 2)
        {
            $('#findResult').html('<table id="tableEvent"><tbody>'); // tambahkan tabel
            $("#tableEvent tr").each(function(index) {
                if (index >= 0) {

                    $row = $(this);

                    var titleEvent = $row.find("td:eq(1)").text().toLowerCase();
                    var indexStr = titleEvent.indexOf(value.toString().toLowerCase());
                    if (indexStr !== 0 && indexStr < 0){                     
                    }
                    else
                        $('#findResult').append($row.clone());
                }
            });
            $('#findResult').append('</tbody></table>');
                        
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
        // Bersihkan map dari rute
        //mapObj.objMaps.cleanRoute();
        // brsihkan listener
        //mapObj.clearListeners('click');
        // Geolokasi
        mapObj.setGeolocate();
        // tambahkan listener
        isAddableMarker = true;
        /*mapObj.addListener('click', function(e) // dipindah keatas
        {
            if(isAddableMarker)
            {
                var addressStr;
                var cssIdForm;
                var markerP;
                //alert(e);
                var isOrigin = objectPosition.isMarker1;

                if(isOrigin)
                {
                    addressStr = 'Origin';
                    cssIdForm = '#orig';
                }
                else
                {    
                    addressStr = 'Destination';
                    cssIdForm = '#dest';
                }

                markerP = mapObj.addMarker(e.latLng.lat(), e.latLng.lng(), addressStr, addressStr, function(){
                    alert(addressStr);
                });

                objectPosition.setMarker(markerP);

                addressStr = mapObj.reverseGeocode(markerP.getPosition());

                $(cssIdForm).val(addressStr);
            }
        });
        */
       /* AUTOCOMPLETE BELUMBERES
       if(typeof google != 'undefined')
       {
            google.maps.event.addDomListener(window, 'load', function(){
                var input = document.getElementById('fname');
                var autocomplete = new google.maps.places.Autocomplete(input);
            });
       };
        */
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
        //mapObj.objMaps.cleanRoute();
        
        isAddableMarker = false;
        
        mapObj.objMaps.drawPolyline({
            path: pathi,
            strokeColor: '#0000FF', //warna line
            strokeOpacity: 0.5, //transparansi
            strokeWeight: 6 //lebar line
        });
            
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
   
    $(objTableEvent.getCssId()).on('click','.v-del', function(currentRow, rowIndex){
        var titleEvent = currentRow.find("td:eq(1)").html();  
        var isdelete = confirm('Delete '+ titleEvent +' ?');
        if(isdelete)
        {
            var idEvent = currentRow.find("td:eq(0)").html();
            objAccess.deleteEvent(idEvent, currentRow, rowIndex, objCalendar);
            $('#map').appendTo('#moreLeft');
            $('#mapInstruction').appendTo('#moreLeft');
        }
    });
    var m1 = null, m2 = null;
    
    /**
     * untuk memilih transportation mode dari marker m1 dan m2
     * m1 dan m2 tidk boleh null
     * @param {type} tmdifference selisih waktu
     * @param {type} travelMode mode nya transit, bicycling, travel, dll
     * @param {type} cssIdRadio
     * @param {type} cssIdMsg
     * @returns {undefined}
     */
    var chooseTransportAct = function(tmdifference, travelMode, cssIdRadio, cssIdMsg)
    {
        //if(m1 != null || m2 != null)
        var origin = $('#orig').val().toString();
        var dest = $('#dest').val().toString();
        //alert(travelMode.toString().toUpperCase());
        
        if(origin !== "" || dest !== "")
        mapObj.distanceMatrix(
            {
                origins: [origin],
                destinations: [dest],
                travelMode: travelMode.toString().toUpperCase(),
                avoidHighways: false,
                avoidTolls: false
            },
            function(response,status)
            {
                if(status != 'OK')
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
                    
                    if(traveltime > tmdifference)
                    {
                        $(cssIdRadio).hide();
                        $(cssIdMsg).val(travelMode + " can't be used");
                    }
                    else
                    {
                        $(cssIdRadio).show().click(function(){
                            mapObj.drawRoutesAnimated(travelMode, [-6.872034, 107.574794], [-6.926131, 107.636561]);
                        });
                        
                        $(cssIdMsg).val(((tmdifference - traveltime) / 60) + ' mins');     
                    }
                }
        });
        else
            alert('Mohon isi lokasi Anda!...');
    };
    
    /**
     * Klik tombol submit
     */
    $('.submit').click(function()
    {
        // parse date dari form input
        var dateTimeOrigin = new Date($('#origDate').val() +" "+$('#origTime').val());
        var dateTimeDest = new Date($('#destDate').val() +" "+$('#destTime').val());
        // dateTimeOrigin dikurangi dateTimeDest bentuk second
        var tmdifference = timeDiff(dateTimeOrigin, dateTimeDest);

        chooseTransportAct(tmdifference, 'transit', '#radio', '#transit');
        chooseTransportAct(tmdifference, 'walking', '#radio1', '#walking');
        chooseTransportAct(tmdifference, 'driving', '#radio2', '#driving');
        chooseTransportAct(tmdifference, 'bicycling', '#radio3', '#bicycling');
   
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
           
    
    /**
     * Klik tombol save
     */
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
                   
                    //if(m2 !== null)
                    //{
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
                   // }
                    //else
                      //  alert("Mohon klik tujuan anda!");
                });

                // Get the modal
                var modal = document.getElementById('myModal');
                                
                $('#myBtn').click(function(){
                    $('#map').appendTo('#mapPopup');
                    $('#mapInstruction').appendTo('#mapPopup');
                    modal.style.display = "block";
                });
                                 
                $('.close').click(function(){
                    $('#map').appendTo('#mapNewEvent');
                    $('#mapInstruction').appendTo('#mapNewEvent');
                    modal.style.display = "none";
                });

        	window.onclick = function(event) {
		    if (event.target == modal) {
		        modal.style.display = "none";
		    }
		}

                
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