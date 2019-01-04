'use strict';
angular.module('myApp').controller('ProductController',['$scope','$http','ProductService',function($scope,$http,ProductService){
	var self = this;
	self.simulateQuery = true;
	
	self.product = {id:null,category:null,name:'',price:0,code:'',image:'',desciption:'',expiryDate:''};
	self.products=[];
	
	fetchAllProduct();

	self.SelectedProduct = null;  
    //event fires when click on textbox  
	self.SelectedProduct = function (selected) {  
        if (selected) {  
        	self.SelectedProduct = selected.originalObject;
        }  
    }  
	
	function fetchAllProduct(){
		ProductService.fetchAllProduct()
		.then(
				function(d){
					self.products = d;
					console.log(self.products)
				},function(err){
					 console.error('Error while fetching Haisan');
				}
		);
		
	}

	
	
}]);