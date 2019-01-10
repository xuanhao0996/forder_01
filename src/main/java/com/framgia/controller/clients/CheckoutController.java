package com.framgia.controller.clients;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.framgia.bean.OrderInfo;
import com.framgia.bean.UserInfo;
import com.framgia.controller.BaseController;

@Controller
@RequestMapping(value = "/checkout")
public class CheckoutController extends BaseController {
	
	@GetMapping(value = "")
	public String viewCheckout(HttpSession httpSession, Model model) {
		// check login
		UserInfo currentUser = (UserInfo) httpSession.getAttribute("currentUser");
		if (currentUser == null) {
			model.addAttribute("alertCheckout", "loginCheckout");
			return "redirect:/";
		}
		else {
			httpSession.getAttribute("myCartItems");
			httpSession.getAttribute("myCartTotal");
			httpSession.getAttribute("myCartNum");
			return "client-checkout";
		}
	}
	
	@RequestMapping(value = "/acceptCheckout", method = RequestMethod.GET	)
    public String acceptCheckout(Model model, HttpSession httpSession){
		model.addAttribute("categories", categoryService.getAll());
        
		OrderInfo orderInfo = orderService.createOrder(httpSession);
        orderDetailService.createOrderDetail(httpSession, orderInfo);
       
        return "client-success";
    }
}
