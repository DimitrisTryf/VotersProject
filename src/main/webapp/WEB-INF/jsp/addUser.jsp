<%-- 
    Document   : addUser
    Created on : Feb 25, 2020, 11:25:14 AM
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

        <script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
        <script src="https://code.jquery.com/jquery-3.4.1.js" integrity="sha256-WpOohJOqMqqyKL9FccASB9O0KwACQJpFTUBLTYOVvVU=" crossorigin="anonymous"></script>
        <link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
        <title>JSP Page</title>

        <style>
            .error{
                background-color: red;
            }
        </style>

        <Script>
            //alert button if passwords dont match
            $(document).ready(function () {
                $('#password2').on("focusout", function () {
                    $('#errorsign').remove();
                    if ($('#password1').val() !== $('#password2').val()) {
                        $('#submitbtn').attr("disabled", true);
                        $('#pass2label').prepend('<i id="errorsign" class="material-icons" style="font-size:15px;color:red">warning</i>');
                    } else {
                        $('#submitbtn').removeAttr("disabled");
                    }
                });
            });

            //fernei boolean gia username
            $(document).ready(function () {
                var dd = $("#username");
                $(dd).on("focusout", function () {
                    var url = "/checkUsername/" + dd.val();
                    $('#errorsign1').remove();
                    $.ajax({
                        method: "POST",
                        url: url
                    }).then(function (data) {
                        if (data === true) {
                            $('#usernamelabel').prepend('<i id="errorsign1" class="material-icons" style="font-size:15px;color:red">warning</i>');
                        }
                    });
                });
            });

            //fernei countries
            $(document).ready(function () {
                var url = "https://geodata.gov.gr/api/3/action/datastore_search?resource_id=9a55cca2-751a-4725-a22a-1643ea739dc2";
                $.ajax({
                    url: url
                }).then(function (data) { // When it answers call this method
                    $.each(data.result.records, function (i, item) {
                        // for every result make an option in target dd
                        $('#countries').append($('<option></option>')
                                .attr("value", item.NAME)
                                .text(item.NAME));
                    });
                });
            });
        </script>

    </head>
    <body>
        <div class="container">
            <h2 align="center">Register</h2>
        </div>
        <div class="container">
            <form:form method="POST" action="/addUser" modelAttribute="newUser">
                <div class="form-group">
                    <form:label path="name">Name</form:label>
                    <form:input class="form-control" type="text" path="name" />
                    <form:errors path="name" class="error"/>
                </div>
                <div class="form-group">
                    <form:label path="surname">Surname</form:label>
                    <form:input class="form-control" type="text" path="surname"/>
                    <form:errors path="surname" class="error"/>
                </div>
                <div class="form-group">
                    <form:label path="username" id="usernamelabel">Username</form:label>
                    <form:input class="form-control" type="text" path="username" id="username" />
                    <form:errors path="username" class="error"/>
                </div>
                <div class="form-group">
                    <form:label path="password1">Password</form:label>
                    <form:input class="form-control" type="password" path="password1" id="password1"/>
                    <form:errors path="password1" class="error"/>
                </div>
                <div class="form-group" id="pass2div">
                    <form:label path="password2" id="pass2label">Confirm Password</form:label>
                    <form:input class="form-control" type="password" path="password2" id="password2"/>
                    <form:errors path="password2" class="error"/>
                </div>
                <div>
                    <form:label path="role">Role</form:label>
                    <form:select path="role"  class="form-control">
                        <c:forEach items="${roles}" var="ro">
                            <form:option value="${ro.roleId}">${ro.roleName}</form:option>
                        </c:forEach>
                    </form:select>
                </div>
                </br>
                <div>
                    <form:label path="country">Country</form:label>
                    <form:select path="country"  class="form-control" id="countries"></form:select>
                    </div>
                    </br>
                    <div  class="row">
                        <div  class="row">
                            <div class="col-md-5"></div>
                            <div class="col-md-2"><button id="submitbtn" class="btn btn-primary" type="submit" value="Submit" disabled/>Submit</button>
                                <div class="col-md-5"></div>
                            </div>
                        </div>
                    </div>
            </form:form>

        </div>
        <a href="/">back to index</a>
    </body>
</html>
