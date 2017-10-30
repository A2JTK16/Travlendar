<%-- 
    Document   : addevent
    Created on : Oct 19, 2017, 3:06:18 PM
    Author     : AGS
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
    <center><h1 class="judul-manage">Input Agenda</h1></center>
        <form action="${pageContext.request.contextPath}/event?input=baru" method="post">
            <table style="margin:20px auto;">
                <tr>
                    <td>
                        <select name="location_id">
                            
                            <option value="">Select...</option>
                            
                             <c:forEach items="${locationList}" var="location">
                                 <option value="<c:out value="${ location.getCityCode() }"/>"/> <!-- Saat submit, diisi dg code city -->
                                     <c:out value="${ location.getCityName() }"/> <!-- Ditampilan, hanya ditampilkan nama nya doang -->
                                 </option>
                            </c:forEach>
                             
                        </select>
                    </td>
		</tr>
                <tr>
                    <td>Event ID</td>
                    <td><input type="text" name="event_id"></td>
		</tr>
                <tr>
                    <td>Traveller ID</td>
                    <td><input type="text" name="traveller_id"></td>
		</tr>
		<tr>
                    <td>Event Name</td>
                    <td><input type="text" name="event_name"></td>
		</tr>
		<tr>
                    <td>Start Event (dd-MM-yyyy HH:mm:ss)</td>
                    <td><input type="text" name="start_event"></td>
		</tr>
                <tr>
                    <td>End Event(dd-MM-yyyy HH:mm:ss)</td>
                    <td><input type="text" name="end_event"></td>
		</tr>
                <tr>
                    <td>Note</td>
                    <td><input type="text" name="note"></td>
		</tr>
                <tr>
                    <td>Place</td>
                    <td><input type="text" name="place"></td>
		</tr>
		<tr>
                    <td></td>
                    <td><input type="submit" value="Tambah"></td>
		</tr>
            </table>
	</form>