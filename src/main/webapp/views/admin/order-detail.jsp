<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
	<div class="container">
		<div class="row">
			<div class="col-xs-12 col-sm-12 col-md-6 col-lg-6 col-xs-offset-0 col-sm-offset-0 col-md-offset-3 col-lg-offset-3 toppad">
				<c:if test="${not empty msg}">
					<div class="alert alert-${css} alert-dismissible" role="alert">
						<button type="button" class="close" data-dismiss="alert" aria-label="Close">
							<span aria-hidden="true">&times;</span>
						</button>
						<strong>${msg}</strong>
					</div>
				</c:if>
				<c:if test="${empty msg}">
					<div class="panel panel-info">
						<div class="panel-heading">
							<h3 class="panel-title">Order Detail</h3>
						</div>
						<div class="panel-body">
							<div class="row">
								<!-- <div class="col-md-3 col-lg-3 " align="center">
									<img alt="User Pic"
										src="https://cdn1.iconfinder.com/data/icons/business-charts/512/customer-512.png"
										class="img-circle img-responsive">
								</div> -->
								<div class=" col-md-9 col-lg-9 ">
									<table class="table table-user-information">
										<tbody>
											<tr>
												<td>Id</td>
												<td>${order.id}</td>
											</tr>
											<tr>
												<td>Customer id</td>
												<td>${order.getUser().getId()}</td>
											</tr>
											<tr>
												<td>Create date</td>
												<td>${order.createDate}</td>
											</tr>
											<tr>
												<td>Shipping id</td>
												<td>Shipping id</td>
											</tr>
											<tr>
												<td>Payment id</td>
												<td>Shipping id</td>
											</tr>
											<tr>
												<td>Total bill</td>
												<td>${order.totalBill}</td>
											</tr>
											<tr>
												<td>Status</td>
												<td>${order.status}</td>
											</tr>
											
										</tbody>
									</table>
								</div>
							</div>
						</div>
						<div class="panel-footer" style="height: 50px; !important" >
							<span class="pull-right">
								<a href="${pageContext.request.contextPath}/admin/orders/edit/${order.id}"
									data-original-title="Edit this user" data-toggle="tooltip"
									type="button" class="btn btn-sm btn-warning"><i
										class="glyphicon glyphicon-edit"></i></a>
								<a href="${pageContext.request.contextPath}/admin/orders/delete/${order.id}"
									data-original-title="Remove this user" data-toggle="tooltip"
									type="button" class="btn btn-sm btn-danger"><i
									class="glyphicon glyphicon-remove"></i></a>
							</span>
						</div>
	
					</div>
				</c:if>
			</div>
		</div>
	</div>
