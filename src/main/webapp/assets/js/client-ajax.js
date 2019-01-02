$(document).ready(function() {
	 function page_pagination(value){
		
		 html="<div>";
		 for(var i=0;i<value.length;i++){
				 html +='<div class="col-md-3 md-col"><div class="col-md">';
					 html +='<a href="single.html"><img src='+value[i].image+' alt="" /></a><div class="top-content">';
					html +='<h5><a href="single.html">'+value[i].name+'</a></h5>';
					html +='<div class="white">';
					html +='<a href="#" class="addtoCart hvr-shutter-in-vertical hvr-shutter-in-vertical2 ">ADD TO CART</a>';
					html +='<p class="dollar"><span class="in-dollar">$</span><span>'+value[i].price+'</span></p>';
					html +='<div class="clearfix"></div>';
				    html +='</div></div></div></div></div>';
				   
		 		}   
		 html+="</div>";
		 return html;
	 }
	 $('body').on("click",".page-pargin",function(){
		 var sotrang = parseInt($(this).text());
		 var pageStart = (sotrang-1)*4;
		 ($('a.page-pargin').removeClass('active'));
		
		 $(this).addClass('active');
		 $.ajax({
			 url:"/forder_01/products",
			 type:"get",
			 data:{
				 pageStart:pageStart
			 },
		 success:function(value){
			 $('#pagination-page').html(page_pagination(value));
			}
		 	
		 })
		 return false;
	 })
	 
	 $('body').on("click",".pre",function(){
		 var pre = parseInt($("a.active").text())-1;
		 if(pre > 0){
			 var pageStart = (pre-1)*4;
			 ($('a.page-pargin').removeClass('active'));
				
			 $('#page'+pre+'').addClass('active');
			 $.ajax({
				 url:"/forder_01/products",
				 type:"get",
				 data:{
					 pageStart:pageStart
				 },
			 success:function(value){
				 $('#pagination-page').html(page_pagination(value));
				}
			 	
			 })
		 }
		 return false;
	 })
	 
	 	 $('body').on("click",".next",function(){
		 var pre = parseInt($("a.active").text())+1;
		 var sumPage = parseInt($('input[name=sumPage]').val());
		 if(pre <= sumPage){
			 
			 var pageStart = (pre-1)*4;
			 ($('a.page-pargin').removeClass('active'));
				
			 $('#page'+pre+'').addClass('active');
			 $.ajax({
				 url:"/forder_01/products",
				 type:"get",
				 data:{
					 pageStart:pageStart
				 },
			 success:function(value){
				 $('#pagination-page').html(page_pagination(value));
				}
			 	
			 })
		 }
		 return false;
	 })

	 
});