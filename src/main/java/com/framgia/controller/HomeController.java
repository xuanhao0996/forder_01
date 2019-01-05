package com.framgia.controller;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController extends BaseController {
	
	private static final Logger logger = Logger.getLogger(HomeController.class);
	
	@RequestMapping(value = "/")
	public ModelAndView index() {
		logger.info("home page");
		ModelAndView model = new ModelAndView("home");
		//model.addObject("category", new CategoryInfo());
		//add list category
		model.addObject("categories", categoryService.getAll());
		
		//add list product
		model.addObject("products", productService.getAll());
		return model;
	}
	/*@RequestMapping(value = { "/", "index" }, method = RequestMethod.GET)
	public String index(Model model, HttpSession httpSession, HttpServletRequest request) {
		List<CategoryInfo> list = categoryService.getAll();

		httpSession.setAttribute("categories", list);

		double sumPage = Math.ceil((double) productService.getProducts(-1).size() / 4);

		if (request.getUserPrincipal() != null) {
			Principal principal = request.getUserPrincipal();
			UserInfo userInfo = userService.findByEmail(principal.getName());
			
			model.addAttribute("email", principal.getName());
			model.addAttribute("alertLogin", "success");
			httpSession.setAttribute("user", userInfo);
		} else {
			model.addAttribute("alertLogin", "err");
		}

		model.addAttribute("products", productService.getProducts(0));
		model.addAttribute("sumPage", sumPage);
		return "client-index";
	}*/

	/*@GetMapping("/login-google")
	public String loginGoogle(HttpServletRequest request, HttpSession httpSession, Model model)
			throws ClientProtocolException, IOException {
		String code = request.getParameter("code");

		if (code == null || code.isEmpty()) {
			model.addAttribute("messageLogin", "err");
			return "redirect:/";
		}
		model.addAttribute("messageLogin", "success");
		String accessToken = googleUtils.getToken(code);
		GoogleInfo googleInfo = googleUtils.getUserInfo(accessToken);
		checkEmailAndPasswordByGoogle(googleInfo, model, httpSession);
		return "redirect:/";
	}

	private void checkEmailAndPasswordByGoogle(GoogleInfo googleInfo, Model model, HttpSession httpSession) {
		UserInfo userCurrent = userService.findByEmailAndPassword(googleInfo.getEmail(), googleInfo.getId());

		if (userCurrent == null) {
			userService.saveOrUpdate(setValueUser(googleInfo));
			model.addAttribute("alertLogin", "success");
		}
		httpSession.setAttribute("userSession", userCurrent);
		model.addAttribute("alertLogin", "success");

	}

	private User setValueUser(GoogleInfo googleInfo) {
		PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		User user = new User();
		user.setEmail(googleInfo.getEmail());
		user.setPassword(passwordEncoder.encode(googleInfo.getId()));
		user.setName(googleInfo.getEmail());
		user.setRole(0);
		user.setPhone("");
		return user;
	}*/

}