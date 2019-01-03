package com.framgia.controller;

import java.io.IOException;
import java.security.Principal;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.http.client.ClientProtocolException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.framgia.bean.CategoryInfo;
import com.framgia.bean.GoogleInfo;
import com.framgia.bean.UserInfo;
import com.framgia.model.User;

@Controller
public class HomeController extends BaseController {

	@RequestMapping(value = { "/", "index" }, method = RequestMethod.GET)
	public String index(Model model, HttpSession httpSession, HttpServletRequest request) {
		List<CategoryInfo> list = categoryService.getCategories();

		httpSession.setAttribute("categories", list);
		double sumPage = Math.ceil((double) productService.getProducts(-1).size() / 4);

		if (request.getUserPrincipal() != null) {
			Principal principal = request.getUserPrincipal();
			model.addAttribute("email", principal.getName());
			model.addAttribute("alertLogin", "success");
		} else {
			model.addAttribute("alertLogin", "err");
		}

		model.addAttribute("products", productService.getProducts(0));
		model.addAttribute("sumPage", sumPage);
		return "client-index";
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
	}

}
