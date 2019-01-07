package com.framgia.controller.admins;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.framgia.controller.BaseController;

@Controller
@RequestMapping(value = "/categories", method = RequestMethod.GET)
public class CategoriesController extends BaseController {

	@GetMapping(value = "/{categoryId}")
	public String showCategory(@PathVariable("categoryId") Integer categoryId, Model model, HttpSession httpSession) {
		model.addAttribute("categories", categoryService.getAll());
		model.addAttribute("products", productService.findByCategoryId(categoryId));
		return "client-category";
	}
}
