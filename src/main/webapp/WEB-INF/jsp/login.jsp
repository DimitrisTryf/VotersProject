<%-- 
    Document   : login
    Created on : Feb 26, 2020, 2:46:08 PM
    Author     : dimit
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
        <title>JSP Page</title>
        
        <style>
            .error{
                background-color: red;
            }
        </style>
    </head>
    <body>
        <div class="container">
    <form:form method="POST" action="/login" modelAttribute="LoginUserDto">
        <div class="form-group">
            <form:label path="lousername">Username</form:label>
            <form:input class="form-control" type="text" path="lousername" />
            <form:errors path="lousername" class="error"/>
        </div>
        <div class="form-group">
            <form:label path="lopassword">Password</form:label>
            <form:input class="form-control" type="text" path="lopassword"/>
            <form:errors path="lopassword" class="error"/>
        </div>
        <div  class="row">
            <div  class="row">
                <div class="col-md-5"></div>
                <div class="col-md-2"><button id="submitbtn" class="btn btn-primary" type="submit" value="Submit"/>Submit</button>
                    <div class="col-md-5"></div>
                </div>
            </div>
        </div>
    </form:form>
        </div>
</body>
</html>
