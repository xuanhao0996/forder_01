package com.framgia.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.framgia.bean.UserInfo;
import com.framgia.exception.EmailExistsException;
import com.framgia.hepler.ConvertUser;

@Controller
public class LoginController extends BaseController{
	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public ModelAndView showRegistrantionForm(HttpServletRequest request, HttpServletResponse response) {
		
	    ModelAndView mav = new ModelAndView("register");
	    mav.addObject("user", new UserInfo());
	    return mav;
	}

	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public String registerUserAccount(HttpServletRequest request, HttpServletResponse response,
			  @ModelAttribute("user") UserInfo user) throws EmailExistsException {

		userService.registerNewUserAccount(ConvertUser.userInfoToUser(user));
		return "redirect:/";
	}
}
