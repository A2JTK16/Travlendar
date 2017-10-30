<%-- 
    Document   : editevent
    Created on : Oct 30, 2017, 4:42:34 PM
    Author     : AGS
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    
<h1 class="judul-manage">Edit Event</h1>

<table>
    <tr>
        <td>Nama Event Lama</td>
        <td>Start Event Lama</td>
        <td>End Event Lama</td>
        <td>Note Lama</td>
        <td>Place Lama</td>
    </tr>
    <tr>
        <td><c:out value="${eventObj.getEvent_name()}"/></td>
        <td><c:out value="${eventObj.getStart_event()}"/></td>
        <td><c:out value="${eventObj.getEnd_event()}"/></td>
        <td><c:out value="${eventObj.getNote()}"/></td>
        <td><c:out value="${eventObj.getPlace()}"/></td>
    </tr>>
</table>

<center><h1 class="judul-manage">Edit Event</h1></center>

<div class="kotakna">
    <form action="${pageContext.request.contextPath}/event?input=terbaru" method="post">
        <table style="margin:20px auto;">
		<tr>
                    <td>Location ID (sama)</td>
                    <td><input type="text" name="location_id" value="<c:out value="${eventObj.getLocation_id()}"/>"></td>
		</tr>
		<tr>
                    <td>Event ID (sama)</td>
                    <td><input type="text" name="event_id" value="<c:out value="${eventObj.getEvent_id()}"/>"></td>
		</tr>
                <tr>
                    <td>Traveller ID (sama))</td>
                    <td><input type="text" name="traveller_id" value="<c:out value="${eventObj.getTraveller_id()}"/>"></td>
		</tr>
                <tr>
                    <td>Event Name</td>
                    <td><input type="text" name="event_name" value="<c:out value="${eventObj.getEvent_name()}"/>"></td>
		</tr>
                <tr>
                    <td>Start Event</td>
                    <td><input type="text" name="start_event" value="<c:out value="${eventObj.getStart_event()}"/>"></td>
		</tr>
                <tr>
                    <td>End Event</td>
                    <td><input type="text" name="end_event" value="<c:out value="${eventObj.getEnd_event()}"/>"></td>
		</tr>
                <tr>
                    <td>Note</td>
                    <td><input type="text" name="note" value="<c:out value="${eventObj.getNote()}"/>"></td>
		</tr>
                <tr>
                    <td>Place</td>
                    <td><input type="text" name="place" value="<c:out value="${eventObj.getPlace()}"/>"></td>
		</tr>
		<tr>
                    <td></td>
                    <td><input type="submit" value="Edit"></td>
		</tr>
        </table>
    </form>
</div>
