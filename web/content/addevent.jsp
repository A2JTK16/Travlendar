<%-- 
    Document   : addevent
    Created on : Oct 19, 2017, 3:06:18 PM
    Author     : AGS
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
    <center><h1 class="judul-manage">Input Agenda</h1></center>
        <form action="${pageContext.request.contextPath}/event?input=baru" method="post">
            <table style="margin:20px auto;">
		<tr>
                    <td>Event Name</td>
                    <td><input type="text" name="event_name"></td>
		</tr>
		<tr>
                    <td>Start Event (dd-MM-yyyy HH.mm)</td>
                    <td><input type="text" name="start_event"></td>
		</tr>
                <tr>
                    <td>End Event(dd-MM-yyyy HH.mm)</td>
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