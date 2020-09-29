<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form method="post" action="calculate3.jsp">
		<input type="text" name="input1">
		<select name=operation>
		<option value="+">+</option>
		<option value="-">-</option>
		<option value="*">*</option>
		<option value="/">/</option>
		</select>
		<input type="text" name="input2">
		<button type="submit" name="submit"  id=btn1>=</button>
	</form>
</body>
</html>
