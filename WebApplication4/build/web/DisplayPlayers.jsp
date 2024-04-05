<%-- 
    Document   : DisplayPlayers
    Created on : Sep 27, 2022, 11:56:54 PM
    Author     : MY
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Player List</title>
    </head>
    <body>
        <h1>Player List</h1>
        <table>
            <tr>
            <th>Rank</th>
            <th>Player</th>
            <th>Team</th>
            </tr>
            <c:forEach var="crickete" begin="0" items="${requestScope.playerList}">
                <tr>
                    <td>${crickete.rank}&nbsp;&nbsp;</td><!-- comment -->
                     <td>${crickete.playerName}&nbsp;&nbsp;</td>
                      <td>${crickete.team}&nbsp;&nbsp;</td>
                </tr>
            </c:forEach>
        </table>
        <a href="addPlayers.jsp" ><br>Add new</b></a>
    </body>
</html>
