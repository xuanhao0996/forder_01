package com.framgia.controller.clients;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.framgia.bean.CartDetailInfo;
import com.framgia.bean.OrderDetailInfo;
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
			/*httpSession.getAttribute("myCartItems");
			httpSession.getAttribute("myCartTotal");
			httpSession.getAttribute("myCartNum");*/
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
    public String viewCheckout(ModelMap mm, HttpSession httpSession,
    						HttpServletRequest request, Model model){
		
		model.addAttribute("categories", categoryService.getAll());
		
		@SuppressWarnings("unchecked")
		HashMap<Integer, CartDetailInfo> cartItems = (HashMap<Integer, CartDetailInfo>) httpSession.getAttribute("myCartItems");
        if (cartItems == null) {
            cartItems = new HashMap<>();
        }
       
        OrderInfo orderInfo = new OrderInfo();
        orderInfo.setCreateDate(new Date(System.currentTimeMillis()));
        orderInfo.setStatus(0);
        orderInfo.setUser((UserInfo) httpSession.getAttribute("currentUser"));
        /*save to database
         * orderService.saveOrUpdate(orderInfo);
        */
        
        //set parameter of orderDetail
        for(Map.Entry<Integer, CartDetailInfo> entry : cartItems.entrySet()){
        	OrderDetailInfo orderDetailInfo = new OrderDetailInfo();
        	orderDetailInfo.setOrder(orderInfo);
        	orderDetailInfo.setProduct(entry.getValue().getProduct());
        	orderDetailInfo.setProductPrice(entry.getValue().getProduct().getPrice());
        	orderDetailInfo.setQuantity(entry.getValue().getQuantity());
        	/*
        	 * orderDetailService.saveOrUpdate(orderDetailInfo);
        	 */
        }
        
        cartItems = new HashMap<>();
        httpSession.setAttribute("myCartItems", cartItems);
        httpSession.setAttribute("myCartTotal", 0);
        httpSession.setAttribute("myCartNum", 0);
        return "client-success";
    }
}
