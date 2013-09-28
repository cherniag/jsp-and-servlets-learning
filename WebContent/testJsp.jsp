<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Test JSP</title>
</head>
<body>
	<%!
		public int add(int a, int b) {
			return a + b;
		}
	%>
	<h2>
		<%
			out.println("Hello from JSP");
			int i = 5;
		%>
	</h2>
	The value of i is :
	<%=i%>
	<br>
	Test of declared method : 45 + 88 = <%=add(45, 88) %>
</body>
</html>