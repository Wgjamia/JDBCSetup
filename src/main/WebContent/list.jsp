<%@ page language="java" contentType="text/html; charset=windows-1256"
	pageEncoding="windows-1256"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<style>
th, tr, td, table {
	border: 2 solid red;
	width=100%;
	height=100%;
}
</style>
<meta charset="windows-1256">
<title>Insert title here</title>
</head>
<body>
<jsp:include page="header.jsp"></jsp:include>
	<table>
		<tr>
			<th>ID</th>
			<th>Name of Product</th>
			<th>Price   </th>
			<th>Date</th>
			<th>Action</th>
		<tr>
			<c:forEach var="pro" items="${list}">
				<tr>
					<td><c:out value="${pro.prID}" /></td>
					<td><c:out value="${pro.prName}" /></td>
					<td><c:out value="${pro.prPrice}" /></td>
					<td><c:out value="${pro.prDate}" /></td>
					<td><a href="view?id=<c:out value='${pro.prID}' />">Edit</a>
						&nbsp;&nbsp;&nbsp;&nbsp; <a
						href="delete?id=<c:out value='${pro.prID}' />">Delete</a></td>
				</tr>
			</c:forEach>




	</table>
	<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>