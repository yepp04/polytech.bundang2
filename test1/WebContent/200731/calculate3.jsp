<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		request.setCharacterEncoding("utf-8");//인코딩
	String x = request.getParameter("input1");
	String y = request.getParameter("input2");
	String opr = request.getParameter("operation");
	int ans = 0;
	if ("+".equals(opr)) {
		ans = Integer.parseInt(x) + Integer.parseInt(y);
	} else if ("-".equals(opr)) {
		ans = Integer.parseInt(x) - Integer.parseInt(y);
	} else if ("*".equals(opr)) {
		ans = Integer.parseInt(x) * Integer.parseInt(y);
	} else if ("/".equals(opr)) {
		ans = Integer.parseInt(x) / Integer.parseInt(y);
	}
	out.println(ans);
	%>
</body>
</html>