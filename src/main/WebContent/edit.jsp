<%@ page language="java" contentType="text/html; charset=windows-1256"
    pageEncoding="windows-1256"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="windows-1256">
<title>Updating Product Info</title>
</head>
<body>
	<jsp:include page="header.jsp"></jsp:include>
	<br/>
	<form action="update" method="get">
		
		<input type="hidden" name="id" id="id"  value="<c:out value='${pro.prID}'/>">
		Product Name: <input type="text" name="pname" id="pname" value="<c:out value='${pro.prName}'/>"><br/>
		Price : <input type="number" name="pprice" id="pprice" value="<c:out value='${pro.prPrice}'/>"><br/>
		<input type="submit" value="Update">
		
		<br/>
	</form>
	<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>