<%@ page language="java" contentType="text/html; charset=utf-8"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles-extras"
	prefix="tilesx"%>
<!DOCTYPE html>
<html>
<head>
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	
	<tilesx:useAttribute name="client-css" id="listCss" classname="java.util.List" />
	<tilesx:useAttribute name="client-js" id="listJs" classname="java.util.List" />
	<tilesx:useAttribute name="client-fonts" id="listFonts" classname="java.util.List" />
	
	<c:forEach items="${listCss}" var="item">
		<link rel="stylesheet" href="<c:url value='${item}'/>" type="text/css"
			media="screen" />
	</c:forEach>

	<c:forEach items="${listJs}" var="item">
		<link rel="stylesheet" href="<c:url value='${item}'/>" type="text/css"
			media="screen" />
	</c:forEach>
	
	<c:forEach items="${listFonts}" var="item">
		<link rel="stylesheet" href="<c:url value='${item}'/>" type="text/css"
			media="screen" />
	</c:forEach>
</head>

<body>
	
	<tiles:insertAttribute name="header" />
	
	<tiles:insertAttribute name="body" />
	
	<tiles:insertAttribute name="footer" />
	
</body>
</html>