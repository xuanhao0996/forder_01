'use strict';
angular.module('myApp').factory('ProductService',['$http','$q',function($http,$q){
	 var REST_SERVICE_URI = 'http://localhost:8080/forder_01/products/';
	 var factory = {
			 fetchAllProduct:fetchAllProduct,
			 createProduct:createProduct,
			 updateProduct:updateProduct,
			 deleteProduct:deleteProduct
			 
	 };
	 return factory;
	 
	 function fetchAllProduct(){
		 var defened = $q.defer();
		 $http.get(REST_SERVICE_URI).then(
				 function(response){
					 defened.resolve(response.data)
				 },function(err){
					 console.error('Error while fetching Product');
					 defened.resolve(err)
				 }
		 );
		 return defened.promise;
	 }
	function createProduct(product){
		var defened = $q.defer();
		$http.post(REST_SERVICE_URI,product).then(
				function(response){
				
					defened.resolve(response.data);
				},function(err){
					 console.error('Error while creating Product');
					 defened.reject(err);
				}
		);
		return defened.promise;
	}
	function updateProduct(product,id){
		var defened = $q.defer();
		$http.put(REST_SERVICE_URI+id,product).then(
				function(response){
					defened.resolve(response.data);
				},function(err){
					 console.error('Error while creating Product');
					 defened.reject(err);
				}
		);
		return defened.promise;
	}
	function deleteProduct(id){
		var defened = $q.defer();
		$http.delete(REST_SERVICE_URI+id).then(
				function(response){
					defened.resolve(response.data);
				},function(err){
					 console.error('Error while delete Product');
					 defened.reject(err);
				}
		);
		return defened.promise;
	}
}]);

angular.module('myAppSearch').factory('ProductServiceSearch',['$http','$q',function($http,$q){
	 var REST_SERVICE_URI = 'http://localhost:8080/forder_01/products/';
	 var factory = {
			 fetchAllProduct:fetchAllProduct,	 
	 };
	 return factory;
	 
	 function fetchAllProduct(){
		 var defened = $q.defer();
		 $http.get(REST_SERVICE_URI).then(
				 function(response){
					 defened.resolve(response.data)
				 },function(err){
					 console.error('Error while fetching Product');
					 defened.resolve(err)
				 }
		 );
		 return defened.promise;
	 }

}]);