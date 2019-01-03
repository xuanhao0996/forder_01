<%@page import="com.framgia.bean.CategoryInfo"%>
<%@page import="java.util.List"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<spring:url value="/assets/alertify/js/alertifyLog.js" var="alertifyLog"/>

<div class="header">
	<div class="header-top">
		<div class="container">
			<div class="header-top-in">
				<div class="logo">
					<a href="index.html"><img
						src="/forder_01/assets/images/logo.png" alt=" "></a> <a
						href="?lang=en">English </a> | <a href="?lang=vi">Vietnamese</a>

				</div>

				<div class="header-in">
					<ul class="icon1 sub-icon1">
						<li><a href="wishlist.html"><spring:message code="list" />
								(0)</a></li>
						<li><a href="account.html"> <spring:message
									code="account" /></a></li>
						<li><a href="#"> <spring:message code="cart" /></a></li>
						<li><a href="checkout.html"><spring:message
									code="checkout" /></a></li>
						<li><div class="cart">
								<a href="#" class="cart-in"> </a> <span> 0</span>
							</div>
							<ul class="sub-icon1 list">
								<h3>
									<spring:message code="additems" />
									(2)
								</h3>
								<div class="shopping_cart">
									<div class="cart_box">
										<div class="message">
											<div class="alert-close"></div>
											<div class="list_img">
												<img src="/forder_01/assets/images/14.jpg"
													class="img-responsive" alt="">
											</div>
											<div class="list_desc">
												<h4>
													<a href="#">velit esse molestie</a>
												</h4>
												1 x<span class="actual"> $12.00</span>
											</div>
											<div class="clearfix"></div>
										</div>
									</div>
									<div class="cart_box1">
										<div class="message1">
											<div class="alert-close1"></div>
											<div class="list_img">
												<img src="/forder_01/assets/images/15.jpg"
													class="img-responsive" alt="">
											</div>
											<div class="list_desc">
												<h4>
													<a href="#">velit esse molestie</a>
												</h4>
												1 x<span class="actual"> $12.00</span>
											</div>
											<div class="clearfix"></div>
										</div>
									</div>
								</div>
								<div class="total">
									<div class="total_left">
										<spring:message code="cartsubtotal" />
										:
									</div>
									<div class="total_right">$250.00</div>
									<div class="clearfix"></div>
								</div>
								<div class="login_buttons">
									<div class="check_button">
										<a href="checkout.html"><spring:message code="checkout" /></a>
									</div>
									<div class="clearfix"></div>
								</div>
								<div class="clearfix"></div>
							</ul></li>
					</ul>
				</div>
				<div class="clearfix"></div>
			</div>
		</div>
	</div>
	<div class="header-bottom">
		<div class="container">
			<div class="h_menu4">
				<a class="toggleMenu" href="#"><spring:message code="menu" /></a>
				<ul class="nav">
					<li class="active"><a href="index.html"><i> </i>Desktops</a></li>
					<li><a href="#"><spring:message code="fruits" /></a>
						<ul class="drop">
							<c:forEach items="${categories}" var="category">
								<li><a
									href="${pageContext.request.contextPath}/categories/${category.id}">${category.name}</a></li>
							</c:forEach>
						</ul></li>
					<li><a href="products.html"> Tablets</a></li>
					<li><a href="products.html">Components</a></li>
					<li><a href="products.html">Software</a></li>
					<li><a href="products.html">Phones & PDAs </a></li>
					<li><a href="products.html"> Cameras </a></li>
					<li><a href="contact.html">Contact </a></li>

				</ul>
				<script type="text/javascript" src="/forder_01/assets/js/nav.js"></script>
			</div>
		</div>
	</div>
	<div class="header-bottom-in">
		<div class="container">
			<div class="header-bottom-on">
			<input value=" ${email}" type="hidden" id="emailLogin">
				<c:choose>
					<c:when test="${email != null }">
						<h5>Welcome: ${email}</h5>
						<form action="<c:url value="/j_spring_security_logout" />"
							method="post">
							<input type="hidden" name="${_csrf.parameterName}"
								value="${_csrf.token}" /> <input type="submit" value="Logout" />
						</form>
					</c:when>
					<c:when test="${userSession != null }">
						<h5>Welcome: ${userSession.email}</h5>
						<form action="<c:url value="/j_spring_security_logout" />"
							method="post">
							<input type="hidden" name="${_csrf.parameterName}"
								value="${_csrf.token}" /> <input type="submit" value="Logout" />
						</form>
					</c:when>
					<c:otherwise>
						<form class="col-md-4" name='loginForm'
							action="<c:url value='j_spring_security_login' />" method='POST'>
							<table>
								<tr>
									<td>User:</td>
									<td><input type='text' name='username'></td>
								</tr>
								<tr>
									<td>Password:</td>
									<td><input type='password' name='password' /></td>
								</tr>
								<tr>
									<td id="confirmLogin" colspan='2'><input name="submit" type="submit"
										value="login" /></td>
								</tr>
							</table>
							<input type="hidden" name="${_csrf.parameterName}"
								value="${_csrf.token}" />
						</form>
					</c:otherwise>
				</c:choose>


				<div class="col-md-8 header-can">
					<ul class="social-in">
						<li><a href="#"><i class="facebook"> </i></a></li>
						<li><a href="#"><i class="twitter"> </i></a></li>
						
						<li><a href="https://accounts.google.com/o/oauth2/auth?scope=email&redirect_uri=http://localhost:8083/forder_01/login-google&response_type=code&client_id=650605713330-9s9j72fd23vgfqdlc380mh0re75mj7cm.apps.googleusercontent.com&approval_prompt=force">Gmail</a></li>
					</ul>
					<div class="down-top">
						<select class="in-drop">
							<option value="Dollars" class="in-of">Dollars</option>
							<option value="Euro" class="in-of">Euro</option>
							<option value="Yen" class="in-of">Yen</option>
						</select>
					</div>
					<div class="search">
						<form>
							<input type="text" value="Search" onfocus="this.value = '';"
								onblur="if (this.value == '') {this.value = '';}"> <input
								type="submit" value="">
						</form>
					</div>

					<div class="clearfix"></div>
				</div>
				<div class="clearfix"></div>
			</div>
		</div>
	</div>
</div>
<div hidden id="messageLogin" >${alertLogin}</div>
<script src="${alertifyLog }"></script>