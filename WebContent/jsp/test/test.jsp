<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>Test</h1>
<div>
	requestScope:${ requestScope.name }<br>
	sessionScope:${ sessionScope.name }<br>
	applicationScope:${ applicationScope.name }<br>
</div>
</body>
</html>