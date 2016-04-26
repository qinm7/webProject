<%-- 
    Document   : liste_tache
    Created on : 26 avr. 2016, 18:08:53
    Author     : demaegdb
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<head>
    <meta name="viewport" content="initial-scale=1.0, user-scalable=no">
    <meta charset="utf-8">
    <title>LIJE : Google Maps JavaScript API v3</title>
    <style>
    html, body { margin:50px 0; padding:0; }
    #map { 
        height: 300px; width:80%; margin:0 auto;
        -webkit-box-shadow: 0 2px 3px 3px rgba(0,0,0,0.2);
        box-shadow: 0 2px 3px 3px rgba(0,0,0,0.2);
        -webkit-border-radius: 5px;
        border-radius: 5px;
    }
    </style>
    <script src="https://maps.googleapis.com/maps/api/js?sensor=false"></script>
</head>
<body>

    <div id="map"></div>
    <script type="text/javascript">
        var mapOptions = {
            zoom: 13,
            center: new google.maps.LatLng(48.853, 2.35),
            mapTypeId: google.maps.MapTypeId.ROADMAP,
			disableDefaultUI: true,
			scrollwheel: false,
			draggable: false
        }
        var map = new google.maps.Map(document.getElementById('map'), mapOptions);
    
        var myLatLng = new google.maps.LatLng(48.804128, 7.776792);
        var marker = new google.maps.Marker({
            position: myLatLng,
            map: map,
            title: 'LIJE Creative'
        });	
    </script>
</body>
</html>
