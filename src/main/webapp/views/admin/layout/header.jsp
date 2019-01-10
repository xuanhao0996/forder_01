<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<spring:url value="/" var="urlHome" />
<spring:url value="/admin" var="addActionUrl" />
<nav class="navbar navbar-inverse ">
	<div class="container">
		<div class="navbar-header">
			<a class="navbar-brand" href="${pageContext.request.contextPath}">F-Order</a>
		</div>
		<div id="navbar">
			<ul class="nav navbar-nav navbar-right">
				<li class="active"><a href="${addActionUrl}/users">Manager User</a></li>
				
			</ul>
			<ul class="nav navbar-nav navbar-right">
				<li class="active"><a href="${addActionUrl}/orders">Manager Order</a></li>
			</ul>
		</div>
	</div>
</nav>