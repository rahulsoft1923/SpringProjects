<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page isELIgnored="false" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Jobs</title>
	</head>
	<body style="font-family: consolas; font-size: 20px;">
		<h2>Jobs</h2>
		<table>
			<tr>
				<td style="color: blue;" align="center">
					<c:if test="${param.created eq '1'}">
						Your job ${job.title} posted successfully
					</c:if>
					<c:if test="${param.edited eq '1'}">
						Your job has been edited successfully
					</c:if>
				</td>
			</tr>
			<tr>
				<td align="right">
					<a href="${pageContext.request.contextPath}/create-job.htm">post job</a>
				</td>
			</tr>
			<tr>
				<td>
					<table>
						<tr>
							<th>Job No</th>
							<th>Title</th>
							<th>Location</th>
						</tr>
						<c:forEach items="${jobs}" var="job">
							<tr>
								<td><a
									href="${pageContext.request.contextPath}/edit-job.htm?jobNo=${job.jobNo}">${job.jobNo}</a></td>
								<td>${job.title}</td>
								<td>${job.city.cityName}</td>
							</tr>
						</c:forEach>
					</table>
				</td>
			</tr>
		</table>
	</body>
</html>


















