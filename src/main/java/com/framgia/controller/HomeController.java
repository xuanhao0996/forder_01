package com.framgia.controller;

import java.security.Principal;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.framgia.bean.CategoryInfo;

@Controller
public class HomeController extends BaseController {

	@RequestMapping(value = {"/","index"},method= RequestMethod.GET)
	public String index(Model model, HttpSession httpSession,HttpServletRequest request) {
		List<CategoryInfo> list = categoryService.getCategories();
		
		httpSession.setAttribute("categories",list );
		double sumPage = Math.ceil((double) productService.getProducts(-1).size() / 4);
		
		if(request.getUserPrincipal() != null) {
			Principal principal = request.getUserPrincipal();
			model.addAttribute("email", principal.getName());
			model.addAttribute("alertLogin","success");
		}else {
			model.addAttribute("alertLogin","err");
		}
		
		model.addAttribute("products", productService.getProducts(0));
		model.addAttribute("sumPage", sumPage);
		return "client-index";
	}

}
