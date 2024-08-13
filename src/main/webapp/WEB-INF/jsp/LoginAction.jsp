<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="com.luminar.onlinebookstore.entity.UserEntity"%>
<%@page import="com.luminar.onlinebookstore.controller.UserController"%>
<%
String email = request.getParameter("email");

String pass = request.getParameter("pass");
UserEntity usr = new UserEntity();
usr.setUserEmail(email);
usr.setUserPassword(pass);
String role = UserController.getAllUsers(usr);

if (role != null) {
	// Set session attribute with the logged-in user's role
	session.setAttribute("userRole", role);

	// Redirect to the appropriate page based on user's role
	if (role.equals("Admin")) {
		response.sendRedirect("AdminViewToDoList.jsp");
	} else if (role.equals("User")) {
		response.sendRedirect("ViewToDoList.jsp");
	} else {
		response.sendRedirect("Login.jsp");
	}
} else {
	response.sendRedirect("error.jsp");
}
%>