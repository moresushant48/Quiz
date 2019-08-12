<%@page import="java.sql.Statement"%>
<%@page import="java.sql.DriverManager"%>
<%@taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql"%>
<%-- 
    Document   : quiz
    Created on : Aug 11, 2019, 1:52:51 PM
    Author     : moresushant48
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="css/basic.css" rel="stylesheet" type="text/css"/>
        <link href="css/w3.css" rel="stylesheet" type="text/css"/>
        <link href="https://fonts.googleapis.com/css?family=Ubuntu|Oxygen|Lobster&display=swap" rel="stylesheet">
        <title>Home</title>
    </head>
    <body>
        <header class="w3-container w3-bar w3-border w3-white">
                <span class="w3-mobile w3-lobster w3-xxlarge w3-margin-left w3-hover-text-amber" style="color: #767676">Take a Quiz!</span>
                <a href="Aboutus" class="w3-mobile w3-bar-item w3-padding-16 w3-right w3-amber w3-hover-text-white">About Us</a>
                <a href="Register" class="w3-mobile w3-bar-item w3-padding-16 w3-right w3-hover-text-amber">Register</a>
                <a href="Login" class="w3-mobile w3-bar-item w3-padding-16 w3-right w3-hover-text-amber">Login</a>
        </header>
        
        <section id="content" class="w3-mobile w3-container w3-auto w3-margin-top">
            <form action="QuizPage" method="post" class="w3-mobile w3-container w3-margin-bottom">
                <table class="w3-mobile w3-table w3-bordered w3-striped w3-large">
                    <c:forEach items="${questions}" var="que">
                        <tr>
                            <td><c:out value="${que.id}"/></td>
                            <td><c:out value="${que.question}"/><br>
                                <input type="radio" name="${que.id}" value="${que.sol1}"><c:out value=" ${que.sol1}"/><br>
                                <input type="radio" name="${que.id}" value="${que.sol2}"><c:out value=" ${que.sol2}"/><br>
                                <input type="radio" name="${que.id}" value="${que.sol3}"><c:out value=" ${que.sol3}"/><br>
                                <input type="radio" name="${que.id}" value="${que.sol4}"><c:out value=" ${que.sol4}"/>
                            </td>
                        </tr>
                    </c:forEach>
                        <tr>
                            <td colspan="2">
                                <c:if test="${result != null}">                             
                                    <div class="w3-green w3-text-white w3-container w3-center">
                                        <p>Your score is <c:out value="${result}" />/5.</p>
                                    </div>
                                </c:if>
                            </td>
                        </tr>
                        <tr>                            
                            <td class="w3-center" colspan="2">
                                <input type="submit" class="w3-mobile w3-button w3-hover-amber">
                                <input type="reset" class="w3-mobile w3-button w3-hover-amber">
                            </td>
                        </tr>
                </table>                
            </form>
        </section>
        
    </body>
</html>
