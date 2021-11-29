<%@ page language="java" contentType="text/html; charset=windows-1256"
    pageEncoding="windows-1256"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="windows-1256">
<title>Adding Product Info</title>
</head>
<body>
	<jsp:include page="header.jsp"></jsp:include>
	<br/>
	<form action="add" method="get">
		Product Name: <input type="text" name="pname" id="pname"><br/>
		Price : <input type="number" name="pprice" id="pprice"><br/>
		<input type="submit" value="Save">
		
		<br/>
	</form>
	<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>