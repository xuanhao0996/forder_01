package com.framgia.controller.admins;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.framgia.bean.UserInfo;
import com.framgia.controller.BaseController;
import com.framgia.hepler.ConvertUser;

@Controller
@RequestMapping("/admin/user")
public class UserController extends BaseController {

	private static final Logger logger = Logger.getLogger(AdminController.class);
	
	@GetMapping("/list")
	public String listUser(Model model) {
		model.addAttribute("users", userService.getAll());
		return "list-user";
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public String showUserDetail(@PathVariable("id") Integer id, Model model) {
		logger.info("detail user");
		UserInfo userInfo = ConvertUser.userToUserInfo(userService.findById(id));
		if (userInfo == null) {
			model.addAttribute("css", "danger");
			model.addAttribute("msg", "notFound");
		}
		model.addAttribute("user", userInfo);
		return "user";
	}

	@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
	public String deleteuser(@PathVariable("id") Integer id, final RedirectAttributes redirectAttributes) {
		logger.info("delete user");
		if (userService.deleteUser(id)) {
			redirectAttributes.addFlashAttribute("css", "success");
			redirectAttributes.addFlashAttribute("msg", "deleted");
		} else {
			redirectAttributes.addFlashAttribute("css", "error");
			redirectAttributes.addFlashAttribute("msg", "deleted");
		}

		return "redirect:/";

	}

	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public String newUser(Model model) {
		UserInfo userInfo = new UserInfo();
		// set default value
		model.addAttribute("userForm", userInfo);
		model.addAttribute("status", "add");

		return "user-form";
	}

	@RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
	public String editUser(@PathVariable("id") Integer id, Model model) {
		UserInfo userInfo = ConvertUser.userToUserInfo(userService.findById(id));
		model.addAttribute("userForm", userInfo);
		model.addAttribute("status", "edit");

		return "user-form";

	}
	
	@PostMapping(value = "/saveUser")
	public String saveUser(@ModelAttribute("userForm") UserInfo userInfo) {
		userInfo.getId();
		userService.saveOrUpdate(ConvertUser.userInfoToUser(userInfo));
		return "redirect:/";
	}
}
