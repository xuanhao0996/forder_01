<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>   


         <div class="container">
             <div class="content">
                 <div class="shopping_cart">
                 <c:forEach var="map" items="${sessionScope.myCartItems}">
                     <div class="cart_box">
                         <div class="message">
                             <div class="list_img"><img src="${map.value.product.image}" class="img-responsive" alt=""></div>
                             <div class="list_close"><a href="${pageContext.request.contextPath}/cartDetail/remove/${map.value.product.id}">Remove item</a></div> 
                             <div class="list_desc"><h4><a href="#"><c:out value="${map.value.product.name}"/></a></h4><c:out value="${map.value.quantity}"/> x
                                 $<c:out value="${map.value.product.price}"/> = <span class="actual"> $<c:out value="${map.value.quantity * map.value.product.price}"/></span></div>
                             <div class="clearfix"></div>
                         </div>
                     </div>
                 </c:forEach>
             </div>
             <div class="total">
                 <div class="total_right">Free Shipping</div>
                 <div class="clearfix"> </div>
                 <div class="total_right">Total: $<c:out value="${sessionScope.myCartTotal}"/></div>
                 <div class="clearfix"> </div>
                 <div class="total_right">VAT (10%): <c:out value="${sessionScope.myCartTotal * 0.1}"/></div>
                 <div class="clearfix"> </div>
                 <div class="total_right">Pay: $<c:out value="${sessionScope.myCartTotal + (sessionScope.myCartTotal * 0.1)}"/></div>
                 <div class="clearfix"> </div>
             </div>
             <div class="clearfix"></div>
         </div>
         <div class="clearfix"></div>
		
		<div>
			<h2>Confirm Infomation</h2>
			<br>
			<table style="width:100% ;border=1px solid black "  >
				<thead>
				<tr>
					<th scope="col">Email</th>
					<th scope="col">Username</th>
					<th scope="col">Phone</th>
				</tr>
			</thead>
				<tbody>
					<tr>
					<td>${sessionScope.currentUser.email}</td>
					<td>${sessionScope.currentUser.name}</td>
					<td>${sessionScope.currentUser.phone}</td>
					</tr>
				</tbody>
			</table>
		<br>
		<br>
		<h3><a href="#">Do you want change infomation ?</a></h3>
		</div>
		
         <div class="contact">
         
             <h2 class=" contact-in"><a href="${pageContext.request.contextPath}/checkout/acceptCheckout" >Checkout Now</a> </h2>
             <h2 class=" contact-in"><a href="${pageContext.request.contextPath}" >Continue Buy</a> </h2>
             
             <div class="clearfix"> </div>
         </div>

     </div>

     <br/><br/>
