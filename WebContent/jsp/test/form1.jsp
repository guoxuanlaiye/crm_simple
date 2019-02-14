<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="${pageContext.request.contextPath}/test/DemoAction" method="post">
		姓	 名:<input type="text" name="user.name" /><br>
		年	 龄:<input type="text" name="user.age" /><br>
		出生日期:<input type="text" name="user.birthday" /><br>
		<input type="submit" value="提交"/>
	</form>
</body>
</html>