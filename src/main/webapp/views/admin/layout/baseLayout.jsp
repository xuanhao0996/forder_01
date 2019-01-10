<%@ page language="java" contentType="text/html; charset=utf-8"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles-extras"
	prefix="tilesx"%>
<!DOCTYPE html>
<html lang="en">
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<meta http-equiv="X-UA-Compatible" content="IE=edge">
		<meta name="description" content="">
		<meta name="author" content="">
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<spring:url value="/assets/admin/css/bootstrap.min.css" var="bootstrapCss" />
		<spring:url value="/assets/admin/js/bootstrap.min.js" var="bootstrapJs" />
		<spring:url value="/assets/admin/js/jquery.min.js" var="jquery" />
		
		<link rel="stylesheet" href="${bootstrapCss}" />
		<script src="${jquery}" type="text/javascript"></script>
		<script src="${bootstrapJs}" type="text/javascript"></script>
		
			<tilesx:useAttribute name="admin-css" id="listCss"
		classname="java.util.List" />
	<tilesx:useAttribute name="admin-js" id="listJs"
		classname="java.util.List" />

	
	<c:forEach items="${listCss}" var="item">
		<link rel="stylesheet" href="<c:url value='${item}'/>" type="text/css"
			media="screen" />
	</c:forEach>
	
	<c:forEach items="${listJs}" var="item">
		<script src="<c:url value='${item}'/>" type="text/javascript"></script>
	</c:forEach>
	
		<title><tiles:insertAttribute name="title" ignore="true" /></title>
	</head>
	<body>
		<nav class="navbar navbar-default">
			<tiles:insertAttribute name="header" />
		</nav>
	
		<tiles:insertAttribute name="body" />
	
		<footer>
			<tiles:insertAttribute name="footer" />
		</footer>
	
	</body>
</html>
