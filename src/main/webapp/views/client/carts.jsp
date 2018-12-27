<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<div class="container">
	<div class="content">
		<div class="shopping_cart">
				<table style="width: 100%">
				<tr>
					<th>Product name</th>
					<th>Quantity</th>
					<th>Price</th>
				</tr>
				<c:forEach items="${cartDetails}" var="cartDetail">
					<c:forEach var="product" items="${products}">

						<tr>
							<td>${product.name}</td>
							<td>${cartDetail.quantity}</td>
							<td>${product.price}</td>
						</tr>

					</c:forEach>
				</c:forEach>
			</table>
		</div>
		<div class="total">
			<div class="total_right">Free Shipping</div>
			<div class="clearfix"></div>
			<%-- <div class="total_right">Total: $<c:out value="${sessionScope.myCartTotal}"/></div>
                    <div class="clearfix"> </div>
                    <div class="total_right">VAT (10%): <c:out value="${sessionScope.myCartTotal * 0.1}"/></div>
                    <div class="clearfix"> </div>
                    <div class="total_right">Pay: $<c:out value="${sessionScope.myCartTotal + (sessionScope.myCartTotal * 0.1)}"/></div> --%>
			<div class="clearfix"></div>
		</div>
		<div class="login_buttons">
			<div class="check_button">
				<a href="checkout.html">Check out</a>
			</div>
			<div class="clearfix"></div>
		</div>
		<div class="clearfix"></div>
	</div>
	<div class="clearfix"></div>

</div>
