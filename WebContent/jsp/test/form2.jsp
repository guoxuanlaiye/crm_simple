<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="${pageContext.request.contextPath}/test/Demo2Action">
		姓	 名:<input type="text" name="name" /><br>
		年	 龄:<input type="text" name="age" /><br>
		出生日期:<input type="text" name="birthday" /><br>
		List:<input type="text" name="list" /><br>
		Map:<input type="text" name="map['name']" /><br>
		
		<input type="submit" value="提交"/>
	</form>
</body>
</html>