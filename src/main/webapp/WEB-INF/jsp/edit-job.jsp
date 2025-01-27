<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page isELIgnored="false" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Edit Job</title>
	</head>
	<body style="font-family: consolas; font-size: 20px;">
		<h2>Edit Job</h2>
		<form:form modelAttribute="jobForm">
			<span style="color: red;">
				<form:errors path="*"/>
			</span><br/>
			Job No: <form:input path="jobNo" readonly="true"/> <br/>
			Title: <form:input path="title"/> <br/>
			Description: <form:input path="description"/> <br/>
			Company Name: <form:input path="companyName"/><br/>
			Experience:
			<form:select path="experience">
				<c:forEach begin="0" end="10" var="exp">
					<form:option value="${exp}">${exp}</form:option>
				</c:forEach>
			</form:select><br/>
			Opening Date :<form:input path="openingDate"/> -
			Closing Date : <form:input path="closingDate"/><br/>
			Skills : <form:input path="skills"/><br/>
			Job Category: 
			<form:select path="jobCategoryNo">
				<c:forEach items="${jobCategories}" var="jobCategory">
					<form:option value="${jobCategory.jobCategoryNo}">${jobCategory.categoryName}</form:option>
				</c:forEach>
			</form:select><br/>
			City:
			<form:select path="cityNo">
				<c:forEach items="${cities}" var="city">
					<form:option value="${city.cityNo}">${city.cityName}</form:option>
				</c:forEach>
			</form:select>
			State:
			<form:select path="stateNo">
				<c:forEach items="${states}" var="state">
					<form:option value="${state.stateNo}">${state.stateName}</form:option>
				</c:forEach>
			</form:select><br/>
			Country : <form:input path="country"/> <br/>
			<input type="submit" value="create"/>
		</form:form>
	</body>
</html>