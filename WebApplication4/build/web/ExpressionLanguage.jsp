<%-- 
    Document   : ExpressionLanguage
    Created on : Oct 9, 2022, 3:06:36 PM
    Author     : MY
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="/WEB-INF/tlds/TLD_library.tld" prefix="f" %>
<!DOCTYPE html>
<html>
    <head>  
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
        ${empty Name}
        ${param}
        <br><!-- comment -->
        ${paramValues.address[0]}
        ${paramValues.address[1]}
        <br>
        <!-- header -->
        header:${header["host"]}
        ___${header["user-agent"]}
        <br>
        <!-- headerValues -->
        headerValues: ${headerValues}
        
        <br>
        <!-- cookie -->
        ${cookie.name}
        
        <br>
        <!-- myCustomTag -->
        myCustomTag: ${f:average()}
        
    </body>
</html>
