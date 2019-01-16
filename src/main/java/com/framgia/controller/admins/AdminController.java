package com.framgia.controller.admins;

import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.framgia.bean.UserInfo;
import com.framgia.controller.BaseController;
import com.framgia.hepler.ConvertUser;

@Controller
@RequestMapping(value = "/admin")
public class AdminController extends BaseController {

	private static final Logger logger = Logger.getLogger(AdminController.class);

	@GetMapping
	public String adminHome(HttpSession httpSession, Model model) {
		logger.info("home page");
		model.addAttribute("user", new UserInfo());
		model.addAttribute("users", ConvertUser.usersToUserInfos(userService.getAll()));
		return "admin-home";
	}
}
