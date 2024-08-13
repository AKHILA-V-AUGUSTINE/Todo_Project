<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>

<link href="css/stylelogin.css" rel="stylesheet" type="text/css" />
<!-- <script language="javascript">
	document.onmousedown = disableclick;
	status = "Welcome to Demo Project";
	function disableclick(event) {
		if (event.button == 2) {
			alert(status);
			return false;
		}
	}
</script>
<script type="text/javascript">
	function preventBack() {
		window.history.forward();
	}
	setTimeout("preventBack()", 0);
	window.onunload = function() {
		null
	};
</script>-->
<script type="text/javascript">
	function valForm() {
		if (document.login.email.value == "") {
			alert("Please Enter your email");
			document.login.email.focus();
			return false;
		}
		if (document.login.pass.value == "") {
			alert("Please Enter your password");
			document.login.pass.focus();
			return false;
		}
		return true;
		document.login.submit();
	}
</script>
</head>

<body>
	<div class="login">
		<h2>Login</h2>
		<form name="login" id="login" method="post" action="${pageContext.request.contextPath}/Login">
			
			<input type="text" name="email" placeholder="Enter your email" /> <br>
			<br> <input type="password" name="pass"
				placeholder="Enter your password" /> <br>
			<!-- <br> <a href="">Forgot Password</a><br> -->
			<br> <input type="submit" name="log" value="Login"
				onclick="return valForm()" /><br> <br>
			<%-- <div class="sign-up">
				<label>Don't have an account?</label> <a
					href="${pageContext.request.contextPath}/Register">Signup</a>


			</div><br>
			
				<a href="${pageContext.request.contextPath}/">BackPage</a> --%>
			
		</form>
	</div>
</body>
</html>