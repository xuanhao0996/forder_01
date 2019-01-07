package com.framgia.controller.clients;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.framgia.bean.CartDetailInfo;
import com.framgia.bean.ProductInfo;
import com.framgia.controller.BaseController;

@Controller
@RequestMapping(value = "/cartDetail")
public class CartDetailController extends BaseController{
	
	@RequestMapping(method = RequestMethod.GET)
    public String viewCart(Model model, HttpSession session) {
        model.addAttribute("categories", categoryService.getAll());
        showMyCart(session);
        return "redirect:/";
    }
	
	 @RequestMapping(value = "/add/{productId}", method = RequestMethod.GET)
	    public String viewAdd(ModelMap mm, HttpSession session, @PathVariable("productId") Integer productId) {
	        @SuppressWarnings("unchecked")
			HashMap<Integer, CartDetailInfo> cartItems = (HashMap<Integer, CartDetailInfo>) session.getAttribute("myCartItems");
	        if (cartItems == null) {
	            cartItems = new HashMap<>();
	        }
	        ProductInfo product = productService.findById(productId);
	        if (product != null) {
	            if (cartItems.containsKey(productId)) {
	            	CartDetailInfo item = cartItems.get(productId);
	                item.setProduct(product);
	                item.setQuantity(item.getQuantity() + 1);
	                cartItems.put(productId, item);
	            } else {
	            	CartDetailInfo item = new CartDetailInfo();
	                item.setProduct(product);
	                item.setQuantity(1);
	                cartItems.put(productId, item);
	            }
	        }
	        session.setAttribute("myCartItems", cartItems);
	        session.setAttribute("myCartTotal", totalPrice(cartItems));
	        session.setAttribute("myCartNum", cartItems.size());
	        return "redirect:/";
	    }

	    @RequestMapping(value = "sub/{productId}", method = RequestMethod.GET)
	    public String viewUpdate(ModelMap mm, HttpSession session, @PathVariable("productId") Integer productId) {
	        @SuppressWarnings("unchecked")
			HashMap<Integer, CartDetailInfo> cartItems = (HashMap<Integer, CartDetailInfo>) session.getAttribute("myCartItems");
	        if (cartItems == null) {
	            cartItems = new HashMap<>();
	        }
	        session.setAttribute("myCartItems", cartItems);
	        return "redirect:/";
	    }

	    @RequestMapping(value = "remove/{productId}", method = RequestMethod.GET)
	    public String viewRemove(ModelMap mm, HttpSession session, @PathVariable("productId") Integer productId) {
	        @SuppressWarnings("unchecked")
			HashMap<Integer, CartDetailInfo> cartItems = (HashMap<Integer, CartDetailInfo>) session.getAttribute("myCartItems");
	        if (cartItems == null) {
	            cartItems = new HashMap<>();
	        }
	        if (cartItems.containsKey(productId)) {
	            cartItems.remove(productId);
	        }
	        session.setAttribute("myCartItems", cartItems);
	        session.setAttribute("myCartTotal", totalPrice(cartItems));
	        session.setAttribute("myCartNum", cartItems.size());
	        return "redirect:/";
	    }

	    public float totalPrice(HashMap<Integer, CartDetailInfo> cartItems) {
	        int count = 0;
	        for (Map.Entry<Integer, CartDetailInfo> list : cartItems.entrySet()) {
	            count += list.getValue().getProduct().getPrice() * list.getValue().getQuantity();
	        }
	        return count;
	    }
	
	private void showMyCart(HttpSession session) {
        @SuppressWarnings("unchecked")
		HashMap<Integer, CartDetailInfo> cartItems =
        		(HashMap<Integer, CartDetailInfo>) session.getAttribute("myCartItems");
        if (cartItems == null) {
            cartItems = new HashMap<>();
        }
        float count = 0;
        for (Map.Entry<Integer, CartDetailInfo> list : cartItems.entrySet()) {
            count += list.getValue().getProduct().getPrice() * list.getValue().getQuantity();
        }
        session.setAttribute("myCartItems", cartItems);
        session.setAttribute("myCartTotal", count);
        session.setAttribute("myCartNum", cartItems.size());
    }
}
