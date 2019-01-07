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

         <div class="contact">
             <h2 class=" contact-in">CHECKOUT </h2>

            <%--  <div class="col-md-6 contact-top">
                 <form method="POST" action="${pageContext.request.contextPath}/checkout">
                     <h3>Want to work with me?</h3>
                     <div>
                         <span>Your Name</span>
                         <input name="userName"  />
                     </div>
                     <div>
                         <span>Your Email</span>	
                         <input name="userEmail"  />
                     </div>
                     <div>
                         <span>Your Address</span>	
                         <input name="userAddress"  />
                     </div>
                     <input type="submit" value="SEND" >	
                 </form>
             </div> --%>
             
             <br><br>
             <a href="${pageContext.request.contextPath}/checkout/acceptCheckout" >Checkout Now</a>
             <br><br>
             <a href="${pageContext.request.contextPath}">Continue Buy</a>
             <br><br>
             <div class="clearfix"> </div>
         </div>

     </div>

     <br/><br/>
