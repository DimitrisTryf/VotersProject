<%-- 
    Document   : voteForm
    Created on : Feb 28, 2020, 7:08:05 PM
    Author     : dimit
--%>

<%@page import="com.example.VotersProject.models.Pollrole"%>
<%@page import="com.example.VotersProject.models.Polluser"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>

<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

	<script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>

	<title>JSP Page</title>

	<style>
		.wrapper {
			display: inline-block;
		}

		.wrapper * {
			float: right;
		}

		input {
			display: none;
		}

		label {
			font-size: 30px;
		}
	</style>

	<script>
		$(document).ready(function () {
			$('#l1').click(function () {
				$('#l1').css("color", "orange");
				$('#l2,#l3,#l4,#l5').css("color", "black");
				$('#ratval').text('1');
			});
			$('#l2').click(function () {
				$('#l1,#l2').css("color", "orange");
				$('#l3,#l4,#l5').css("color", "black");
				$('#ratval').text('2');
			});
			$('#l3').click(function () {
				$('#l1,#l2,#l3').css("color", "orange");
				$('#l4,#l5').css("color", "black");
				$('#ratval').text('3');
			});
			$('#l4').click(function () {
				$('#l1,#l2,#l3,#l4').css("color", "orange");
				$('#l5').css("color", "black");
				$('#ratval').text('4');
			});
			$('#l5').click(function () {
				$('#l1,#l2,#l3,#l4,#l5').css("color", "orange");
				$('#ratval').text('5');
			});
		});

	</script>
</head>

<body>
	<h1>Welcome ${user.UName} ${user.USurname} from ${user.UCountry}</h1>
	<c:choose>
		<c:when test="${!(voted == true)}">
			<form method="post" action="/vote" id="votesubmitform">
				<div>
					<select name="candidate">
						<c:forEach items="${candidatesList}" var="cand">
							<option value="${cand.UId}">${cand.UName} ${cand.USurname}
							</option>
						</c:forEach>
					</select>
					<br />
					<div class="wrapper">
					    <input type="radio" id="s5" name="rating" value="5">
						<label for="s5" id="l5">&#10038;</label>
						<input type="radio" id="s4" name="rating" value="4">
						<label for="s4" id="l4">&#10038;</label>
						<input type="radio" id="s3" name="rating" value="3">
						<label for="s3" id="l3">&#10038;</label>
						<input type="radio" id="s2" name="rating" value="2">
						<label for="s2" id="l2">&#10038;</label>
						<input type="radio" id="s1" name="rating" value="1">
						<label for="s1" id="l1">&#10038;</label>
					</div>
					<span id="ratval"></span>
				</div>
				<button type="submit">Submit vote</button>
			</form>
			<br />
		</c:when>
		<c:otherwise>
			<div>You have already voted</div>
		</c:otherwise>
	</c:choose>

	<%Polluser user = (Polluser) session.getAttribute("user");
            Pollrole role = user.getURoleId();
            if (role.getRoleId() == 2) {%>
	<a href="/showVotes">show my votes</a><%}%>
    </body>
</html>