<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<div class="banner-mat">
		<div class="container">
			<div class="banner">
	
				<!-- Slideshow 4 -->
			   <div class="slider">
			<ul class="rslides" id="slider1">
			  <li><img src="/forder_01/assets/images/banner.jpg" alt="">
			  </li>
			  <li><img src="/forder_01/assets/images/banner1.jpg" alt="">
			  </li>
			  <li><img src="/forder_01/assets/images/banner.jpg" alt="">
			  </li>
			  <li><img src="/forder_01/assets/images/banner2.jpg" alt="">
			  </li>
			</ul>
		</div>

				<div class="banner-bottom">
					<div class="banner-matter">
						<p>Childish Gambino - Camp Now Available for just $9.99</p> 
						<a href="single.html" class="hvr-shutter-in-vertical ">Purchase</a>
					</div>
					<div class="purchase">
						<a href="single.html" class="hvr-shutter-in-vertical hvr-shutter-in-vertical2 ">Purchase</a>
					</div>
					<div class="clearfix"></div>
				</div>
			</div>				
			<!-- //slider-->
		</div>
	</div>
		<!---->
		<div class="container">
			<div class="content">
				<div class="content-top">
					<h3 class="future">FEATURED</h3>
					<div class="content-top-in">
					
					<c:forEach items="${products}" var="product">
						<div class="col-md-3 md-col">
							<div class="col-md">
								<a href="single.html"><img  src="${product.image}" alt="" /></a>	
								<div class="top-content">
									<h5><a href="single.html">"${product.name}"</a></h5>
									<div class="white">
										<a href="single.html" class="hvr-shutter-in-vertical hvr-shutter-in-vertical2 ">ADD TO CART</a>
										<p class="dollar"><span class="in-dollar">$</span><span>2</span><span>0</span></p>
										<div class="clearfix"></div>
									</div>

								</div>							
							</div>
						</div>
					</c:forEach>
					<div class="clearfix"></div>
					</div>
				</div>
				<!---->
				<div class="content-middle">
					<h3 class="future">BRANDS</h3>
					<div class="content-middle-in">
					<ul id="flexiselDemo1">			 
						<li><img src="/forder_01/assets/images/ap.png"/></li>
						<li><img src="/forder_01/assets/images/ap1.png"/></li>
						<li><img src="/forder_01/assets/images/ap2.png"/></li>
						<li><img src="/forder_01/assets/images/ap3.png"/></li>
					
					</ul>
            		<script type="text/javascript">
		$(window).load(function() {
			$("#flexiselDemo1").flexisel({
				visibleItems: 4,
				animationSpeed: 1000,
				autoPlay: true,
				autoPlaySpeed: 3000,    		
				pauseOnHover: true,
				enableResponsiveBreakpoints: true,
		    	responsiveBreakpoints: { 
		    		portrait: { 
		    			changePoint:480,
		    			visibleItems: 1
		    		}, 
		    		landscape: { 
		    			changePoint:640,
		    			visibleItems: 2
		    		},
		    		tablet: { 
		    			changePoint:768,
		    			visibleItems: 3
		    		}
		    	}
		    });
		    
		});
	</script>

					</div>
				</div>
				<!---->
				<div class="content-bottom">
					<h3 class="future">LATEST</h3>
					<div class="content-bottom-in">
					
				
					<ul id="flexiselDemo2">	
					<c:forEach items="${products}" var="product">		
						<li><div class="col-md men">
								<a href="single.html" class="compare-in "><img  src="${product.image}" alt="" />
								<div class="compare in-compare">
									<span>Add to Compare</span>
									<span>Add to Whislist</span>
								</div></a>
								<div class="top-content bag">
									<h5><a href="single.html">"${product.name}"</a></h5>
									<div class="white">
										<a href="single.html" class="hvr-shutter-in-vertical hvr-shutter-in-vertical2">ADD TO CART</a>
										<p class="dollar"><span class="in-dollar">$</span><span>4</span><span>0</span></p>
										<div class="clearfix"></div>
									</div>
								</div>							
							</div></li>
					</c:forEach>	
					</ul>

					<script type="text/javascript">
		$(window).load(function() {
			$("#flexiselDemo2").flexisel({
				visibleItems: 4,
				animationSpeed: 1000,
				autoPlay: true,
				autoPlaySpeed: 3000,    		
				pauseOnHover: true,
				enableResponsiveBreakpoints: true,
		    	responsiveBreakpoints: { 
		    		portrait: { 
		    			changePoint:480,
		    			visibleItems: 1
		    		}, 
		    		landscape: { 
		    			changePoint:640,
		    			visibleItems: 2
		    		},
		    		tablet: { 
		    			changePoint:768,
		    			visibleItems: 3
		    		}
		    	}
		    });
		    
		});
	</script>
					</div>
				</div>
				<ul class="start">
					<li ><a href="#"><i></i></a></li>
					<li><span>1</span></li>
					<li class="arrow"><a href="#">2</a></li>
					<li class="arrow"><a href="#">3</a></li>
					<li class="arrow"><a href="#">4</a></li>
					<li class="arrow"><a href="#">5</a></li>
					<li ><a href="#"><i  class="next"> </i></a></li>
				</ul>
			</div>
		</div>
		<!---->

