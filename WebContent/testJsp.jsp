<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Test JSP</title>
</head>
<body>
<%@ include file="/hello.jsp" %>
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
	Test of declared method : 45 + 88 = <%=add(45, 88) %><br>
	<%
		if(request.getParameter("user")!=null && !request.getParameter("user").isEmpty()){
			session.setAttribute("user", request.getParameter("user"));
			application.setAttribute("user", request.getParameter("user"));
			pageContext.setAttribute("user", request.getParameter("user"));
			pageContext.setAttribute("userFromPageContextForApplication", request.getParameter("user"), PageContext.APPLICATION_SCOPE);
			pageContext.setAttribute("userFromPageContextForSession", request.getParameter("user"), PageContext.SESSION_SCOPE);
			pageContext.setAttribute("userFromPageContextForPageContext", request.getParameter("user"), PageContext.PAGE_SCOPE);
		}
	%>
	<br>
	HttpRequest in JSP: request.getParameter("user") = <%=request.getParameter("user") %>
	<br>
	HttpSession in JSP: session.getAttribute("user") = <%=session.getAttribute("user") %>
	<br>
	ServletContext in JSP: application.getAttribute("user") = <%=application.getAttribute("user") %>
	<br>
	PageContext in JSP doesn't have analogs in Servlets: pageContext.getAttribute("user") = <%=pageContext.getAttribute("user") %>
	<br>But it can be used for setting parameters in other objects:
	<br>PageContext.APPLICATION_SCOPE: application.getAttribute("userFromPageContextForApplication") = 
	<%=application.getAttribute("userFromPageContextForApplication") %>
	<br>PageContext.SESSION_SCOPE: session.getAttribute("userFromPageContextForSession") = 
	<%=session.getAttribute("userFromPageContextForSession") %>
	<br>PageContext.PAGE_SCOPE: pageContext.getAttribute("userFromPageContextForPageContext") = 
	<%=pageContext.getAttribute("userFromPageContextForPageContext") %>
</body>
</html>