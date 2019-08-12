<%-- 
    Document   : Result
    Created on : Aug 12, 2019, 4:42:22 PM
    Author     : moresushant48
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
        <%= request.getAttribute("msg") %>
    </body>
</html>
