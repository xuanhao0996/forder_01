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
	<meta name="keywords"
		content="Bonfire Responsive web template, Bootstrap Web Templates, Flat Web Templates, Andriod Compatible web template, 
			Smartphone Compatible web template, free webdesigns for Nokia, Samsung, LG, SonyErricsson, Motorola web design" />
	<!--fonts-->
	
	<link
		href='http://fonts.googleapis.com/css?family=Exo:100,200,300,400,500,600,700,800,900'
		rel='stylesheet' type='text/css'>
	<!--//fonts-->
	
	
	<tilesx:useAttribute name="client-css" id="listCss"
		classname="java.util.List" />
	<tilesx:useAttribute name="client-js" id="listJs"
		classname="java.util.List" />
	<tilesx:useAttribute name="client-fonts" id="listFonts"
		classname="java.util.List" />
	
	<c:forEach items="${listCss}" var="item">
		<link rel="stylesheet" href="<c:url value='${item}'/>" type="text/css"
			media="screen" />
	</c:forEach>
	
	<c:forEach items="${listJs}" var="item">
		<script src="<c:url value='${item}'/>" type="text/javascript"></script>
	</c:forEach>
	
	<c:forEach items="${listFonts}" var="item">
		<link rel="stylesheet" href="<c:url value='${item}'/>" type="text/css"
			media="screen" />
	</c:forEach>
	<script type="application/x-javascript">
		 addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } 
	</script>
	<script type="text/javascript">
		jQuery(document).ready(function($) {
			$(".scroll").click(function(event) {
				event.preventDefault();
				$('html,body').animate({
					scrollTop : $(this.hash).offset().top
				}, 1000);
			});
		});
	</script>
	<!--slider-script-->
	<script src="js/responsiveslides.min.js"></script>
	<script>
		$(function() {
			$("#slider1").responsiveSlides({
				auto : true,
				speed : 500,
				namespace : "callbacks",
				pager : true,
			});
		});
	</script>
	<!--//slider-script-->
	<script>
		$(document).ready(function(c) {
			$('.alert-close').on('click', function(c) {
				$('.message').fadeOut('slow', function(c) {
					$('.message').remove();
				});
			});
		});
	</script>
	<script>
		$(document).ready(function(c) {
			$('.alert-close1').on('click', function(c) {
				$('.message1').fadeOut('slow', function(c) {
					$('.message1').remove();
				});
			});
		});
	</script>
</head>

<body>
	<tiles:insertAttribute name="header" />

	<tiles:insertAttribute name="body" />

	<tiles:insertAttribute name="footer" />
</body>
</html>