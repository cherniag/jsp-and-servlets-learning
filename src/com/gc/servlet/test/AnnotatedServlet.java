package com.gc.servlet.test;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Enumeration;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(
		urlPatterns={"/AnnotatedServletPath"},
		initParams={
				@WebInitParam(name="defaultUserId", value="Jonh Smith")
		}
)
public class AnnotatedServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		
		
		
		String userId = request.getParameter("userId");
		HttpSession httpSession = request.getSession();
		ServletContext servletContext = request.getServletContext();
		if(userId!=null && !userId.isEmpty()){
			httpSession.setAttribute("savedUserId", userId);
			servletContext.setAttribute("savedUserId", userId);
		}
		response.setContentType("text/html");
		PrintWriter writer = response.getWriter();
		writer.println("<h1>");
		writer.println("<br>Hello " + userId + " from the get");
		writer.println("<br>Saved in session is " + httpSession.getAttribute("savedUserId") + " from the get");
		writer.println("<br>Saved in context is " + servletContext.getAttribute("savedUserId") + " from the get");
		writer.println("<br>Saved in context as init param is " + getServletConfig().getInitParameter("defaultUserId") + " from the get");
		writer.println("</h1><br>Cookies:");
		if(request.getCookies()!=null){
			for(Cookie cookie:request.getCookies()){
				writer.println(new StringBuilder("<br>")
					.append("name=").append(cookie.getName())
					.append(" value=").append(cookie.getValue())
					.append(" path=").append(cookie.getPath())
					.append(" maxAge=").append(cookie.getMaxAge())
					.toString()
				);
			}
		}
		writer.println("<br><br>Headers:");
		if (request.getHeaderNames()!=null) {
			for (Enumeration<String> headers = request.getHeaderNames(); headers
					.hasMoreElements();) {
				String headerName = headers.nextElement();
				writer.println(new StringBuilder("<br>").append("name=")
						.append(headerName).append(" value=")
						.append(request.getHeader(headerName)).toString());
			}
		}
		writer.println("<br><br>Attributes:");
		for(Enumeration<String> attrNames = request.getAttributeNames();attrNames.hasMoreElements();){
			String attrName = attrNames.nextElement();
			writer.println(new StringBuilder("<br>")
				.append("name=").append(attrName)
				.append(" value=").append(request.getAttribute(attrName))
				.toString()
			);
		}
		writer.println("<br><br>Parameters:");
		for(Enumeration<String> parameters = request.getParameterNames();parameters.hasMoreElements();){
			String param = parameters.nextElement();
			writer.println(new StringBuilder("<br>")
				.append("name=").append(param)
				.append(" value=").append(request.getParameter(param))
				.toString()
			);
		}
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String userId = request.getParameter("userId");
		String fullName = request.getParameter("fullName");
		String prof = request.getParameter("prof");
		String[] ages = request.getParameterValues("age");
		response.setContentType("text/html");
		PrintWriter writer = response.getWriter();
		writer.println("<h1>");
		writer.println("<br>Hello " + userId + " / " + fullName + " from the post");
		writer.println("<br>You are " + prof);
		writer.println("<br>You like " + Arrays.toString(ages));
		writer.println("</h1>");
	}

}
