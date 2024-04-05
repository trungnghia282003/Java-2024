<%-- 
    Document   : addPlayers
    Created on : Sep 27, 2022, 11:51:27 PM
    Author     : MY
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>New Player Record</h1>
        <form action="addPlayers">
            <table>
                <tr>
                    <td>Rank</td>
                    <td><input type="text" id="rank" name="rank"/></td>
                </tr>
                <tr>
                    <td>playerName</td>
                    <td><input type="text" id="playerName" name="playerName"/></td>
                </tr>
                <tr>
                    <td>Team</td>
                    <td><input type="text" id="team" name="team"/></td>
                </tr>
            </table>
            <input type="submit" value="CreateRecord">
        </form>
           
    </body>
</html>
