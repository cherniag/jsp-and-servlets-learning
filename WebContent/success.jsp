<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="com.gc.domain.UserDetails" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Success</title>
</head>
<body>
<h1>Login successful!</h1>
<br>
<%-- First method:
Hello <%=((UserDetails)session.getAttribute("userDetails")).getFullName() %>
--%>
<%-- Second - using forward--%>
Hello <%=((UserDetails)request.getAttribute("userDetails")).getFullName() %>
</body>
</html>