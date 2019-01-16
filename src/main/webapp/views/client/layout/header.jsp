<%@page import="java.util.List"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<spring:url value="/assets/alertify/js/alertifyLog.js" var="alertifyLog" />

<div class="header">
	<div class="header-top">
		<div class="container">
			<div class="header-top-in">
				<div class="logo">
					<a href="${pageContext.request.contextPath}"><img
						src="/forder_01/assets/images/logo.png" alt=" "></a> <a
						href="?lang=en">English </a> | <a href="?lang=vi">Vietnamese</a>
				</div>

				<div class="header-in">
					<ul class="icon1 sub-icon1">
						<li><a href="${pageContext.request.contextPath}/order"><spring:message code="list" />
								(0)</a></li>
						<li><a href="${pageContext.request.contextPath}/account"> <spring:message
									code="account" /></a></li>
						<li><a href="#"> <spring:message code="cart" /></a></li>
						<li><a href="${pageContext.request.contextPath}/checkout"  onclick="checkLogin()"><spring:message
									code="checkout" /></a></li>
						<li>
							<div class="cart">
								<a href="#" class="cart-in"> </a> <span> <c:out
										value="${sessionScope.myCartNum}" /></span>
							</div>
							<ul class="sub-icon1 list">
            <h3>Recently added items (<c:out value="${sessionScope.myCartNum}"/>)</h3>
                <div class="shopping_cart">
                    <c:forEach var="map" items="${sessionScope.myCartItems}">
                        <div class="cart_box">
                            <div class="message">
                                <div class="alert-close"><a href="${pageContext.request.contextPath}/cartDetail/remove/${map.value.product.id}"></a></div> 
                                <div class="list_img"><img src="${map.value.product.image}" class="img-responsive" alt=""></div>
                                <div class="list_desc"><h4><a href="#"><c:out value="${map.value.product.name}"/></a></h4><c:out value="${map.value.quantity}"/> x
                                    <c:out value="${map.value.product.price}"/> $= <span class="actual"> <c:out value="${map.value.quantity * map.value.product.price}"/> $</span></div>
                                <div class="clearfix"></div>
                            </div>
                        </div>
                    </c:forEach>
                </div>
                <div class="total">
                    <div class="total_left">Total: </div>
                    <div class="total_right">$<c:out value="${sessionScope.myCartTotal}"/></div>
                    <div class="clearfix"> </div>
                </div>
                <div class="login_buttons">
                    <div class="check_button"><a href="${pageContext.request.contextPath}/checkout" onclick="checkLogin()">Check out</a></div>
                    <div class="clearfix"></div>
                </div>
                <div class="clearfix"></div>
    </ul>
							</li>
					</ul>
				</div>
				<div class="clearfix"></div>
			</div>
		</div>
	</div>
	<div class="header-bottom">
		<div class="container">
			<div class="h_menu4">
				<a class="toggleMenu" href="#"><spring:message code="menu" /></a>
				<ul class="nav">

					<li class="active"><a
						href="${pageContext.request.contextPath}"><i> </i>HOME</a></li>

					<li><a href="#">Fruits</a>

						<ul class="drop">
							<c:forEach items="${categories}" var="category">
								<li><a
									href="${pageContext.request.contextPath}/categories/${category.id}">${category.name}</a></li>
							</c:forEach>
						</ul></li>
					<li><a href="${pageContext.request.contextPath}/admin">ADMIN </a></li>

				</ul>
				<script type="text/javascript" src="/forder_01/assets/js/nav.js"></script>
			</div>
		</div>
	</div>
	<div class="header-bottom-in">
		<div class="container">
			<div class="header-bottom-on">
				<input value=" ${email}" type="hidden" id="emailLogin">
				<c:choose>
					<c:when test="${currentUser != null }">
						<h5>Welcome: ${currentUser.name}</h5>
						<form action="<c:url value="/j_spring_security_logout" />"
							method="post">
							<input type="hidden" name="${_csrf.parameterName}"
								value="${_csrf.token}" /> <input type="submit" value="Logout" />
						</form>
					</c:when>
					<c:when test="${userSession != null }">
						<h5>Welcome: ${userSession.email}</h5>
						<form action="<c:url value="/j_spring_security_logout" />"
							method="post">
							<input type="hidden" name="${_csrf.parameterName}"
								value="${_csrf.token}" /> <input type="submit" value="Logout" />
						</form>
					</c:when>
					<c:otherwise>
						<form class="col-md-4" name='loginForm'
							action="<c:url value='j_spring_security_login' />" method='POST'>
							<table>
								<tr>
									<td>User:</td>
									<td><input type='text' name='username'></td>
								</tr>
								<tr>
									<td>Password:</td>
									<td><input type='password' name='password' /></td>
								</tr>
								<tr>
									<td id="confirmLogin" colspan='2'><input name="submit"
										type="submit" value="login" /></td>
								</tr>
							</table>
							<input type="hidden" name="${_csrf.parameterName}"
								value="${_csrf.token}" />
						</form>
					</c:otherwise>
				</c:choose>
				<div class="col-md-8 header-can">
					<ul class="social-in">
						<li><a href="#"><i class="facebook"> </i></a></li>
						<li><a href="#"><i class="twitter"> </i></a></li>

						<li><a
							href="https://accounts.google.com/o/oauth2/auth?scope=email&redirect_uri=http://localhost:8080/forder_01/login-google&response_type=code&client_id=650605713330-9s9j72fd23vgfqdlc380mh0re75mj7cm.apps.googleusercontent.com&approval_prompt=force">Gmail</a></li>
					</ul>
					<div class="down-top">
						<select class="in-drop">
							<option value="Dollars" class="in-of">Dollars</option>
							<option value="Euro" class="in-of">Euro</option>
							<option value="Yen" class="in-of">Yen</option>
						</select>
					</div>
					<div ng-app="myAppSearch" ng-controller="ProductControllerSearch as ctrl"
						layout="column" ng-cloak="" class="autocompletedemoCustomTemplate">
						<md-content layout-padding="" class="fix-overflow" layout="column">						
						    <form ng-submit="$event.preventDefault()">
      				<md-autocomplete id="custom-template" ng-disabled="ctrl.isDisabled" md-no-cache="ctrl.noCache" 
      				md-selected-item="ctrl.selectedItem" md-search-text-change="ctrl.searchTextChange(ctrl.searchText)" 
     				md-search-text="ctrl.searchText" md-selected-item-change="ctrl.selectedItemChange(item)" 
     			    md-items="item in ctrl.querySearch(ctrl.searchText)" md-item-text="item.name" md-min-length="0" 
      				input-aria-label="Current Repository" placeholder="Search" md-menu-class="autocomplete-custom-template"
     				md-menu-container-class="custom-container">
        			<md-item-template>
        			<a ng-href="<c:url value="/products/show/{{item.id}}"/>" >
          <span class="item-title">
          <img alt="" class="fix-angu-img md-avatar"  ng-src="{{item.image}}">
            <span> {{item.name}} </span>
          </span>
          <span class="item-metadata">
            <span>
              <strong>{{item.price}}</strong> price
            </span>
            <span>
              <strong>{{item.expiryDate}}</strong> expiryDate
            </span>
          </span>
          
          <a/>
        </md-item-template>
      </md-autocomplete>
    </form>
						</md-content>
						

					<div class="clearfix"></div>
				</div>
				<div class="clearfix"></div>
			</div>
		</div>
	</div>
</div>
<div hidden id="messageLogin" >${alertLogin}</div>
<script src="${alertifyLog }"></script>
 
 <input type="hidden" id="loginCheckout" value="${alertCheckout}"> 
