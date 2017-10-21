<%-- 
    Document   : header
    Created on : Sep 24, 2017, 9:32:16 AM
    Author     : Diana
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" type="text/css" href="Assets/css/userstyle.css">
        <link rel="stylesheet" type="text/css" href="Assets/css/userresponsive.css">
        <link rel="stylesheet" type="text/css" href="Assets/css/calendar.css">
        <title><c:out value="${content}"/> Trav2A</title>
    </head>
    <body>
                
    <div class="jarak-atas">

    </div> <!--jarak-atas-->

    <div class="menu-atas">
	<div class="header">
            <div class="logonya">
                <img src="Assets/icon/logo3.png">
            </div>
            <div class="logo">
                <h1>Travelendar</h1>
            </div> <!--logo-->
            
            <div class="dropdown" style="float:right;">
                <button class="dropbtn">
                    <a class="icon-account">
                            <img src="Assets/icon/akun1.png">
                    </a>
                </button>
                <div class="dropdown-content">
                  <a href="#">Link 1</a>
                  <a href="#">Link 2</a>
                  <a href="#">Link 3</a>
                </div>
            </div>
            
            <div class="dropdown" style="float:right;">
                <button class="dropbtn">
                    <a class="icon-account">
                            <img src="Assets/icon/notif2.png">
                    </a>
                </button>
                <div class="dropdown-content">
                  <a href="#">Notif 1</a>
                  <a href="#">Notif 2</a>
                  <a href="#">Notif 3</a>
                </div>
            </div>
                  
            <div class="kotak-cari">
                <div class="icon-cari">
                    <img src="Assets/icon/search.png">
                </div>
                <input class="cari" type="text" placeholder="Find Event ..."/>
            </div> <!--kotak-cari-->
          
	</div> <!--header-->
     
    </div> <!--menu-atas-->

    <!-- Isi kontennya di sini, ketika di include otomatis nyambung dengan konten -->
    
    <!-- Isi footernya termasuk tutup tag html dan body di sini, ketika di include otomatis nyambung dengan konten -->