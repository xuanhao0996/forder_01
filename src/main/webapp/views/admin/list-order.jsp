<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
	<div class="container" style="margin-top: 50px">
		<c:if test="${not empty msg}">
			<div class="alert alert-${css} alert-dismissible" role="alert">
				<button type="button" class="close" data-dismiss="alert" aria-label="Close">
					<span aria-hidden="true">&times;</span>
				</button>
				<spring:message code="${msg}" var="notFound" />
				<strong>${notFound}</strong>
			</div>
		</c:if>
		<div class="row md-col-8">
			<h2>Search From</h2>
			<spring:url value="/${order.id}" var="searchActionUrl" />
			<form:form action="searchActionUrl" method="GET" modelAttribute="order"
				cssClass="form-horizontal">
				<table>
					<tr>
						<th>Order id&nbsp;&nbsp;</th>
						<td><form:input path="id" cssClass="form-control" /> <form:errors
								path="id" cssClass="error" /></td>
					</tr>
				</table>
			</form:form>
		</div>
		<div class="row"">
			<div class="md-col-8">
				<fieldset>
					<legend>
						<h2> List Order</h2>
					</legend>
					<table class="table table-hover table-dark">
						<thead class="bg-primary">
							<tr>
								<th scope="col">#</th>
								<th scope="col">Customer-id</th>
								<th scope="col">Date create order</th>
								<th scope="col">Shipper-id</th>
								<th scope="col">Payment-id</th>
								<th scope="col"> Bill </th>
								<th scope="col"> Status</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach items="${orders}" var="orders" varStatus="count">
								<tr>
									<th scope="row">${count.index + 1}</th>
									<td>${orders.getUser().getId()}</td>
									<td>${orders.createDate}</td>
									<td>Shipper-id</td>
									<td>Payment-id</td>
									<td>${orders.totalBill}</td>
									<td>${orders.status}</td>
									<td>
										<c:if test="${orders.status == 'WAITING'}"> Waiting accept by admin </c:if>
										<c:if test="${orders.status == 'ACCEPTED'}"> Accepted  </c:if>
										<c:if test="${orders.status != 'WAITING' && orders.status != 'ACCEPTED'}"> N/A </c:if>								
									</td>
									<td>
										<spring:url value="/admin/orders/${orders.id}" var="detailActionUrl" />
										<button class="btn btn-info"
											onclick="location.href='${detailActionUrl}'">Detail</button>
											
										<spring:url value="/admin/orders/${orders.id}/edit" var="editActionUrl" />
										<button class="btn btn-warning"
											onclick="location.href='${editActionUrl}'">Edit</button>
											
										<spring:url value="/admin/orders/${orders.id}/delete" var="deleteActionUrl" />
										<button class="btn btn-danger"
											onclick="location.href='${deleteActionUrl}'">Delete</button>
									</td>
								</tr>
							</c:forEach>
					</tbody>
					</table>
				</fieldset>
				
						<a href="${pageContext.request.contextPath}/admin/orders/excel"> Export </a>
				
			</div>
		</div>
	</div>
