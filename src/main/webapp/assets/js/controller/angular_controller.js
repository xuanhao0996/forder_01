'use strict';
angular.module('myApp').controller('ProductController',['$scope','$http','$timeout', '$q', '$log','ProductService',function($scope,$http,$timeout, $q, $log,ProductService){
	var self = this;
	
	
	self.product = {id:null,category:1,name:'',price:0,code:'',image:'',desciption:'',expiryDate:new Date()};
	self.products=[];
	
	self.isOpen = false;
	
	self.resetProduct = resetProduct;
	self.submitProduct = submitProduct;
	//search
    self.simulateQuery = true;
    self.isDisabled    = false;

    self.repos         = loadAll();
    self.querySearch   = querySearch;
    self.selectedItemChange = selectedItemChange;
    self.searchTextChange   = searchTextChange;
	
	fetchAllProduct();

    function querySearch (query) {
        var results = query ? self.repos.filter( createFilterFor(query) ) : self.repos,
            deferred;
        if (self.simulateQuery) {
          deferred = $q.defer();
          $timeout(function () { deferred.resolve( results ); }, Math.random() * 1000, false);
          return deferred.promise;
        } else {
          return results;
        }
      }

      function searchTextChange(text) {
        $log.info('Text changed to ' + text);
      }

      function selectedItemChange(item) {
        $log.info('Item changed to ' + JSON.stringify(item));
      }
      
	function fetchAllProduct(){
		ProductService.fetchAllProduct()
		.then(
				function(d){
					self.products = d;
					
				},function(err){
					 console.error('Error while fetching Product');
				}
		);
		
	}
    function loadAll() {
    	ProductService.fetchAllProduct()
		.then(
				function(d){
					self.repos = d;
					var repon = self.repos;
					return repon.map( function (repo) {
			            repo.value = repo.name.toLowerCase();
			            return repo;
			          });
				},function(err){
					 console.error('Error while fetching Product');
				}
		);		
        }

        function createFilterFor(query) {
          var lowercaseQuery = query.toLowerCase();

          return function filterFn(item) {
            return (item.value.indexOf(lowercaseQuery) === 0);
          };

        }
        
        function createProduct(product){
      		ProductService.createProduct(product).then(
      				fetchAllProduct,
      				function(err){
      					 console.error('Error while create Product');
      				}
      		);
      	}
      	
      	function submitProduct(){
      		createProduct(self.product)
      		if(self.product.id === null){
      			
      		}else{
      			
      		}
      		resetProduct();
      	}
      	
      	function resetProduct(){
      		self.product = {id:null,category:null,name:'',price:0,code:'',image:'',desciption:'',expiryDate:''};
      		$scope.productForm.$setPristine();
      	}
	
}]);