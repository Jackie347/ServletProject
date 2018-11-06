<%-- 
    Document   : failure
    Created on : Nov 5, 2018, 1:46:08 AM
    Author     : jackie
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Failure</title>
    </head>
    <body>
        <jsp:useBean id="user" class="mbs.User" scope="session" />
        <h3><jsp:getProperty name="user" property="status" /></h3>
         <a href="index.jsp">Log in</a>
    </body>
</html>
