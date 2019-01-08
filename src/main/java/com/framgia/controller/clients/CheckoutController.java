package com.framgia.controller.clients;

import java.util.HashMap;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.framgia.bean.CartDetailInfo;
import com.framgia.controller.BaseController;

@Controller
@RequestMapping(value = "/checkout")
public class CheckoutController extends BaseController {
//	@RequestMapping(value = "checkout.html", method = RequestMethod.POST)
   /* public String viewCheckout(ModelMap mm, HttpSession session, @ModelAttribute("receipt") Receipt receipt) {
        HashMap<Integer, CartDetailInfo> cartItems = (HashMap<Integer, CartDetailInfo>) session.getAttribute("myCartItems");
        if (cartItems == null) {
            cartItems = new HashMap<>();
        }
        receipt.setReceiptDate(new Timestamp(new Date().getTime()));
        receipt.setReceiptStatus(true);
        receiptService.create(receipt);
        for (Map.Entry<Integer, Cart> entry : cartItems.entrySet()) {
            ReceiptItem receiptItem = new ReceiptItem();
            receiptItem.setReceipt(receipt);
            receiptItem.setProduct(entry.getValue().getProduct());
            receiptItem.setReceiptItemPrice(entry.getValue().getProduct().getProductPrice());
            receiptItem.setReceiptItemSale(entry.getValue().getProduct().getProductSale());
            receiptItem.setReceiptItemQuantity(entry.getValue().getQuantity());
            receiptItem.setReceiptItemStatus(true);
            receiptItemService.create(receiptItem);
        }
        cartItems = new HashMap<>();
        session.setAttribute("myCartItems", cartItems);
        session.setAttribute("myCartTotal", 0);
        session.setAttribute("myCartNum", 0);
        return "pages/success";
    }*/
}
