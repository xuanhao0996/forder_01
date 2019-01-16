<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

	<div class="container">
			<div class="products">
			<h1 class=" products-in">${category.name}</h1>
					<br>
					<br>
					<div class=" top-products">
					
					<c:forEach items="${products}" var="product">
						<div class="col-md-3 md-col">
							<div class="col-md">
								<a href="${pageContext.request.contextPath}/products/show/${product.id}" class="compare-in"><img  src="${product.image}" alt="" />	
								<!-- <div class="compare">
									<span>Add to Compare</span>
									<span>Add to Whislist</span>
								</div> -->
								</a>
								<div class="top-content">
									<h5><a href="single.html">"${product.name}"</a></h5>
									<div class="white">
										<a href="${pageContext.request.contextPath}/cartDetail/add/${product.id}" class="hvr-shutter-in-vertical hvr-shutter-in-vertical2">ADD TO CART</a>
										<p class="dollar"><span class="in-dollar">$</span><span>4</span><span>0</span></p>
										<div class="clearfix"></div>
									</div>
								</div>							
							</div>
						</div>
					</c:forEach>
					<div class="clearfix"></div>
					</div>
			</div>
		</div>