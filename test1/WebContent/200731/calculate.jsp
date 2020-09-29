<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="mvc_200731.*,java.util.List"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
</head>
<body>
	<%
		ControllerCalculator1 cal = new ControllerCalculator1();
	request.setCharacterEncoding("utf-8");//인코딩
	String x = request.getParameter("input");
	//out.println(x);
		for (int i = 2; i < 10; i++) {
			int answer = Integer.parseInt(x) * i;
			out.println(x + " X " + i + " = " + answer);
			%><br><%
		}
	%>
</body>
</html>