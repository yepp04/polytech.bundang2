<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<html>
<head>
<title>Calculator</title>
</head>
<body>
	<form action="Calculate.do" method="post">
			<input type="text" name="num1">
		<select name=operation>
		<option value="+">+</option>
		<option value="-">-</option>
		<option value="*">*</option>
		<option value="/">/</option>
		</select>
		<input type="text" name="num2">
		<button type="submit" name="submit">=</button>
	</form>
</body>
</html>
