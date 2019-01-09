package com.framgia.controller;

import java.security.Principal;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.framgia.bean.UserInfo;

@Controller
public class HomeController extends BaseController {

	private static final Logger logger = Logger.getLogger(HomeController.class);

	@RequestMapping(value = "/")
	public ModelAndView index(HttpSession httpSession, HttpServletRequest request) {
		logger.info("home page");
		ModelAndView modelView = new ModelAndView("home");
		// model.addObject("category", new CategoryInfo());
		// add list category
		modelView.addObject("categories", categoryService.getAll());

		// add list product
		modelView.addObject("products", productService.getAll());

		// check login
		if (request.getUserPrincipal() != null) {
			Principal principal = request.getUserPrincipal();
			UserInfo userInfo = userService.findByEmail(principal.getName());

			modelView.addObject("alertLogin", "success");
			httpSession.setAttribute("currentUser", userInfo);
		} else {
			modelView.addObject("alertLogin", "err");
		}

		/*modelView.addObject("products", productService.getProducts(0));
		modelView.addObject("sumPage", sumPage);*/
		return modelView;
	}
/*
	@GetMapping("/login-google")
	public String loginGoogle(HttpServletRequest request, HttpSession httpSession, Model model)
			throws ClientProtocolException, IOException {
		String code = request.getParameter("code");

		if (StringUtils.isNotBlank(code) || code.isEmpty()) {
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
>>>>>>> v2
		}
		return modelView;
	}

	@GetMapping("/login-google")
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
			userService.saveOrUpdate(ConvertUser.convertSingleUserInfoToUser(setValueUser(googleInfo)));
			model.addAttribute("alertLogin", "success");
		}
		httpSession.setAttribute("userSession", userCurrent);
		model.addAttribute("alertLogin", "success");

	}

	private UserInfo setValueUser(GoogleInfo googleInfo) {
		PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		UserInfo user = new UserInfo();
		user.setEmail(googleInfo.getEmail());
		user.setPassword(passwordEncoder.encode(googleInfo.getId()));
		user.setName(googleInfo.getEmail());
		user.setRole("USER");
		user.setPhone("");
		return user;
	}
*/
}