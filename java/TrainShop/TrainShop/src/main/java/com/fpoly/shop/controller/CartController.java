package com.fpoly.shop.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.fpoly.shop.entities.Cart;
import com.fpoly.shop.entities.CartIndex;
import com.fpoly.shop.entities.Train;
import com.fpoly.shop.entities.User;
import com.fpoly.shop.service.CartService;
import com.fpoly.shop.service.IndexCartService;
import com.fpoly.shop.service.TrainService;
import com.fpoly.shop.service.UserService;



@Controller
@SessionAttributes("loggedInUser")
public class CartController {
	
	@Autowired
	private TrainService trainService;
	@Autowired
	private UserService userService;
	@Autowired
	private CartService cartService;
	@Autowired
	private IndexCartService indexCartService;
	
	@ModelAttribute("loggedInUser")
	public User loggedInUser() {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		return userService.findByEmail(auth.getName());
	}
	
	public User getSessionUser(HttpServletRequest request) {
		return (User) request.getSession().getAttribute("loggedInUser");
	}
	
	@GetMapping("/cart")
	public String cartPage(HttpServletRequest res,Model model) {
		User currentUser = getSessionUser(res);
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		Map<Long,String> quanity = new HashMap<Long,String>();
		List<Train> listsp = new ArrayList<Train>();
		if(auth == null || auth.getPrincipal() == "anonymousUser")     //Lay tu cookie
		{
			Cookie cl[] = res.getCookies();		
			Set<Long> idList = new HashSet<Long>();
			for(int i=0; i< cl.length; i++)
			{
				if(cl[i].getName().matches("[0-9]+"))
				{
					idList.add(Long.parseLong(cl[i].getName()));
					quanity.put(Long.parseLong(cl[i].getName()), cl[i].getValue());  
				}
				
			}
			listsp = trainService.getAllTrainByList(idList);
		}else     //Lay tu database
		{
			Cart g = cartService.getCartByUser(currentUser);
			if(g != null)
			{
				List<CartIndex> listchimuc = indexCartService.getIndexCartByCart(g);
				for(CartIndex c: listchimuc)
				{
					listsp.add(c.getTrain());
					quanity.put(c.getTrain().getId(), Integer.toString(c.getQuantity()));
				}
			}
		}
		model.addAttribute("checkEmpty",listsp.size());
		model.addAttribute("cart",listsp);
		model.addAttribute("quanity",quanity);
		
		
		return "client/cart";
	}

}
