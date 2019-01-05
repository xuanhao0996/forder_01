<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>


<div class="container">
	<div class="single">
		<div class="col-md-9 top-in-single">
			<div class="col-md-5 single-top">

				<img class="etalage_thumb_image img-responsive" src="${product.image}" style="display: inline; width: 550x; height: 350px; opacity: 1;">

			</div>
			<div class="col-md-7 single-top-in">
				<div class="single-para">

					<h4>${product.name}</h4>
					<div class="para-grid">
						<span class="add-to">$ ${product.price}</span> <a href="#"
							class="hvr-shutter-in-vertical cart-to">Add to Cart</a>
						<div class="clearfix"></div>
					</div>
					<h5>${product.code}</h5>
					<div class="available">
						<h6>Available Options :</h6>
						<ul>
							<li>Color: <select>
									<option>Silver</option>
									<option>Black</option>
									<option>Dark Black</option>
									<option>Red</option>
							</select></li>
							<li>Size:<select>
									<option>Large</option>
									<option>Medium</option>
									<option>small</option>
									<option>Large</option>
									<option>small</option>
							</select></li>
							<li>Quality:<select>
									<option>1</option>
									<option>2</option>
									<option>3</option>
									<option>4</option>
									<option>5</option>
							</select></li>
						</ul>
					</div>
					<p>${product.desciption}</p>

					<a href="#" class="hvr-shutter-in-vertical ">More details</a>

				</div>
			</div>
			<div class="clearfix"></div>
			<div class="content-top-in">
				<div class="clearfix"></div>
			</div>
		</div>
		<div class="col-md-3">
			<div class="single-bottom">
				<h4>Categories</h4>
				<ul>
					<li><a href="#"><i> </i>Fusce feugiat</a></li>
					<li><a href="#"><i> </i>Mascot Kitty</a></li>
					<li><a href="#"><i> </i>Fusce feugiat</a></li>
					<li><a href="#"><i> </i>Mascot Kitty</a></li>
					<li><a href="#"><i> </i>Fusce feugiat</a></li>
				</ul>
			</div>
			<div class="single-bottom">
				<h4>Product Categories</h4>
				<ul>
					<li><a href="#"><i> </i>feugiat(5)</a></li>
					<li><a href="#"><i> </i>Fusce (4)</a></li>
					<li><a href="#"><i> </i> feugiat (4)</a></li>
					<li><a href="#"><i> </i>Fusce (4)</a></li>
					<li><a href="#"><i> </i> feugiat(2)</a></li>
				</ul>
			</div>
			<div class="single-bottom">
				<h4>Same Product</h4>
				<%-- <c:forEach items="${products}" var="product" varStatus="count">
					<c:if test="${count.index < 3}">
						<div class="product">
							<img class="img-responsive fashion" src="${product.image}" alt="">
							<div class="grid-product">
								<a href="#" class="elit">${product.name}</a> <span
									class="price price-in"><small>$${product.price}</small> $${product.price}</span>
							</div>
							<div class="clearfix"></div>
						</div>
					</c:if>
				</c:forEach> --%>
			</div>
		</div>
		<div class="clearfix"></div>
	</div>
</div>
<!---->