<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
<div ng-app="myApp" class="generic-container" ng-controller="ProductController as ctrl">
 	 <table class="table table-hover">
		<thead>
			<tr>
				<th ng-click="predicate = 'ctrl.products.id'; reverse=!reverse">ID Product</th>
				<th>category</th>
				<th ng-click="predicate = 'ctrl.products.name'; reverse=!reverse">name</th>
				<th ng-click="predicate = 'ctrl.products.price'; reverse=!reverse">price</th>
				<th>code</th>
				<th>image</th>
				<th>desciption</th>
				<th>expiryDate</th>
			</tr>
		</thead>
		<tbody>
			
				<tr ng-repeat="u in ctrl.products | orderBy:predicate:reverse ">
					<td><span ng-bind="u.id"></span></td>
					<td><span ng-bind="u.category"></span></td>
					<td><span ng-bind="u.name"></span></td>
					<td><span ng-bind="u.price"></span></td>
					<td><span ng-bind="u.code"></span></td>
					<td><img alt="" class="fix-angu-img md-avatar"  ng-src="{{u.image}}"></span></td>
					<td><span ng-bind="u.desciption"></span></td>
					<td><span ng-bind="u.expiryDate"></span></td>
<!-- 					<td><button ng-click="ctrl.edit(u.mahaisan)"class="btn btn-success custom-width">Edit</button> 
					<button ng-click="ctrl.remove(u.mahaisan)" class="btn btn-success custom-width">Delete</button> -->
					</td>
				</tr>
		
		</tbody>
	</table>
	<!-- ADD -->
		<form  ng-submit="ctrl.submitProduct()"  name="productForm" method="post">
	<input type="hidden" ng-model="ctrl.products.id" >
		<p>category</p>
		<input name="category" ng-model="ctrl.product.category" type="text">
		  <div class="has-error" ng-show="productForm.$dirty">
                 <span ng-show="productForm.category.$error.required">This is a required field</span>
                 <span ng-show="productForm.category.$invalid">This field is invalid </span>
          </div>
		<p>price</p>
		<input name="price" ng-model="ctrl.product.price" type="text">
		<p>name</p>
		<input name="name" ng-model="ctrl.product.name" type="text"  required ng-minlength="3">
		  <div class="has-error" ng-show="productForm.$dirty">
                 <span ng-show="productForm.name.$error.required">This is a required field</span>
                 <span ng-show="productForm.name.$error.minlength">Minimum length required is 3</span>
                 <span ng-show="productForm.name.$invalid">This field is invalid </span>
          </div>
		<p>code</p>
		<input name="code" ng-model="ctrl.product.code" type="text">
		<p>image</p>
		<input name="image" ng-model="ctrl.product.image" type="text">
		<p>desciption</p>
		<input name="desciption" ng-model="ctrl.product.desciption" type="text">
		<p>expiryDate</p>
		<input name="expiryDate"  ng-model="ctrl.product.expiryDate" type="date">
		<br/><br/>
		<input type="submit" value="add">
	</form>
 </div>
