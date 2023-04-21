<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script src="https://code.jquery.com/jquery-3.6.3.min.js"></script>
<link href="/resources/css/common/style.css" rel="stylesheet">
<link rel="stylesheet" href="https://unicons.iconscout.com/release/v4.0.0/css/line.css" />
<title>로그인</title>
</head>
<body>
<%@ include file="/WEB-INF/views/common/layout.jsp" %>
    <!-- Home -->
	<section class="home">
		<div class="form_container">
			<i class="uil uil-times form_close"></i>
			<!-- Login From -->
			<div class="form login_form">
				<form action="#">
					<h2>Login</h2>
					<div class="input_box">
						<input type="email" placeholder="Enter your email" required />
						<i class="uil uil-envelope-alt email"></i>
					</div>
					<div class="input_box">
						<input type="password" placeholder="Enter your password" required />
						<i class="uil uil-lock password"></i>
						<i class="uil uil-eye-slash pw_hide"></i>
					</div>
					<div class="option_field">
						<span class="checkbox">
							<input type="checkbox" id="check" />
							<label for="check">Remember me</label>
						</span>
						<a href="#" class="forgot_pw">Forgot password?</a>
					</div>
					<button class="button">Login Now</button>
					<div class="login_signup">Don't have an account? <a href="#" id="signup">Signup</a></div>
				</form>
			</div>

        <!-- Signup From -->
			<div class="form signup_form">
				<form action="#">
					<h2>Signup</h2>
					<div class="input_box">
						<input type="email" placeholder="Enter your email" required />
						<i class="uil uil-envelope-alt email"></i>
					</div>
					<div class="input_box">
						<input type="password" placeholder="Create password" required />
						<i class="uil uil-lock password"></i>
						<i class="uil uil-eye-slash pw_hide"></i>
					</div>
					<div class="input_box">
						<input type="password" placeholder="Confirm password" required />
						<i class="uil uil-lock password"></i>
						<i class="uil uil-eye-slash pw_hide"></i>
					</div>
					<button class="button">Signup Now</button>
					<div class="login_signup">Already have an account? <a href="#" id="login">Login</a></div>
				</form>
			</div>
		</div>
	</section>
    
<script src="/resources/js/user/sign_in.js"></script>
</body>
</html>