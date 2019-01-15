package com.framgia.controller.admins;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.framgia.bean.OrderInfo;
import com.framgia.bean.UserInfo;
import com.framgia.controller.BaseController;
import com.framgia.hepler.ConvertOrder;
import com.framgia.hepler.ConvertUser;
@Controller
@RequestMapping("/admin/orders")
public class OrderController extends BaseController {
	/*
	 * Chức năng quản lý order: show list order thêm thông tin ship cho order chấp
	 * nhận hoặc hủy bỏ đơn hàng
	 */
	private static final Logger logger = Logger.getLogger(OrderController.class);

	@RequestMapping("")
	public String showAllOrder(Model model) {
		model.addAttribute("order", new OrderInfo());
		model.addAttribute("orders", orderService.getAll());
		return "list-order";
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public String showOrderDetail(@PathVariable("id") Integer id, Model model) {
		logger.info("Order detail");
		OrderInfo orderInfo = ConvertOrder.orderToInfo(orderService.findByIdJoinFetch(id));
		if (orderInfo == null) {
			model.addAttribute("css", "danger");
			model.addAttribute("msg", "notFound");
		}
		model.addAttribute("order", orderInfo);
		return "order-detail";
	}

	@RequestMapping(value = "/{id}/delete", method = RequestMethod.GET)
	public String deleteuser(@PathVariable("id") Integer id, final RedirectAttributes redirectAttributes) {
		logger.info("delete order");
		if (orderService.deleteOrder(id)) {
			redirectAttributes.addFlashAttribute("css", "success");
			redirectAttributes.addFlashAttribute("msg", "deleted");
		} else {
			redirectAttributes.addFlashAttribute("css", "error");
			redirectAttributes.addFlashAttribute("msg", "deleted");
		}

		return "redirect:/admin/orders";

	}

	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public String newUser(Model model) {
		UserInfo userInfo = new UserInfo();
		// set default value
		model.addAttribute("userForm", userInfo);
		model.addAttribute("status", "add");

		return "user-form";
	}

	@RequestMapping(value = "/{id}/edit", method = RequestMethod.GET)
	public String editUser(@PathVariable("id") Integer id, Model model) {
		UserInfo userInfo = ConvertUser.userToUserInfo(userService.findById(id));
		model.addAttribute("userForm", userInfo);
		model.addAttribute("status", "edit");

		return "user-form";

	}

	@PostMapping(value = { "/create", "/update" })
	public String saveUser(@ModelAttribute("userForm") UserInfo userInfo, RedirectAttributes redirectAttrs) {
		userService.saveOrUpdate(ConvertUser.userInfoToUser(userInfo));
		return "redirect:/admin/users";
	}

	@RequestMapping(value = "/excel", method = RequestMethod.GET)
	public ModelAndView getExcel() {
		List<OrderInfo> orders = orderService.getAll();
		return new ModelAndView("OrderListExcel", "orders", orders);
	}

}
