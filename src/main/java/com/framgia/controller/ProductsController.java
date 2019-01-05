/*package com.framgia.controller;

@Controller
@RequestMapping("/products")
public class ProductsController extends BaseController{
	
	@Autowired
	private ProductService productService;
	
	@RequestMapping(value = "/", method = RequestMethod.GET, produces = "application/json;charset=utf-8")
	@ResponseBody
	public List<ProductInfo> showProducts(@RequestParam("pageStart") int pageStart) {
		return productService.getProducts(pageStart);
	}
	
	//show information of product by single.jsp
	@GetMapping(value="/{id}")
	public String showSingleProduct(@PathVariable("id") Integer id ,Model model, HttpSession httpSession) {
		
		//add list product
		model.addAttribute("products", productService.getProductsByCategoryID(id));
		
		//add 1 productInfo
		model.addAttribute("product", productService.getProductById(id));
		return "client-single-product";
	}
}
*/