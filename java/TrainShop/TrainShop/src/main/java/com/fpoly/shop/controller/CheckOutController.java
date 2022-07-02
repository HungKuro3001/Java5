package com.fpoly.shop.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.fpoly.shop.entities.Cart;
import com.fpoly.shop.entities.CartIndex;
import com.fpoly.shop.entities.Order;
import com.fpoly.shop.entities.OrderDetail;
import com.fpoly.shop.entities.Train;
import com.fpoly.shop.entities.User;
import com.fpoly.shop.service.CartService;
import com.fpoly.shop.service.IndexCartService;
import com.fpoly.shop.service.OrderDetailService;
import com.fpoly.shop.service.OrderService;
import com.fpoly.shop.service.TrainService;
import com.fpoly.shop.service.UserService;




@Controller
@SessionAttributes("loggedInUser")
public class CheckOutController {
	
	@Autowired
	private TrainService trainService;
	@Autowired
	private UserService userService;
	@Autowired
	private CartService cartService;
	@Autowired
	private IndexCartService indexCartService;
	@Autowired
	private OrderService orderService;
	@Autowired
	private OrderDetailService orderDetailService;

	@ModelAttribute("loggedInUser")
	public User loggedInUser() {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		return userService.findByEmail(auth.getName());
	}
	
	public User getSessionUser(HttpServletRequest request) {
		return (User) request.getSession().getAttribute("loggedInUser");
	}
	
	@GetMapping("/checkout")
	public String checkoutPage(HttpServletRequest res,Model model) {
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
		
		model.addAttribute("cart",listsp);
		model.addAttribute("quanity",quanity);
		model.addAttribute("user", currentUser);
		model.addAttribute("donhang", new com.fpoly.shop.entities.Order());
		
		return "client/checkout";
	}
	
//	@PostMapping(value="/thankyou")
//	public String thankyouPage(@ModelAttribute("donhang") Order donhang ,HttpServletRequest req,HttpServletResponse response ,Model model){
//		donhang.(new Date());
//		((HttpServletResponse) donhang).setStatus(0, "Đang chờ giao");
//
//		User currentUser = getSessionUser(req);
//		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
//		Map<Long,String> quanity = new HashMap<Long,String>();
//		List<Train> listsp = new ArrayList<Train>();
//		List<OrderDetail> listDetailDH = new ArrayList<OrderDetail>();
//	
//		if(auth == null || auth.getPrincipal() == "anonymousUser")     //Lay tu cookie
//		{
//			Order d = orderService.save(donhang);
//			Cookie cl[] = req.getCookies();		
//			Set<Long> idList = new HashSet<Long>();
//			for(int i=0; i< cl.length; i++)
//			{
//				if(cl[i].getName().matches("[0-9]+"))
//				{
//					idList.add(Long.parseLong(cl[i].getName()));					
//					quanity.put(Long.parseLong(cl[i].getName()), cl[i].getValue());  
//				}	
//			}
//			listsp = sanPhamService.getAllSanPhamByList(idList);
//			for(Train sp: listsp)
//			{
//				ChiTietDonHang detailDH = new ChiTietDonHang();
//				detailDH.setSanPham(sp);
//				detailDH.setSoLuongDat(Integer.parseInt(quanity.get(sp.getId())));
//				detailDH.setDonGia(Integer.parseInt(quanity.get(sp.getId()))*sp.getDonGia());
//				detailDH.setDonHang(d);
//				listDetailDH.add(detailDH);
//			}
//		}else     //Lay tu database
//		{
//			donhang.setNguoiDat(currentUser);
//			Order d = orderService.save(donhang);
//			Cart g = cartService.getCartByUser(currentUser);
//			List<CartIndex> listchimuc = indexCartService.getIndexCartByCart(g);
//			for(CartIndex c: listchimuc)
//			{			
//				CartIndex detailDH = new CartIndex();
//				detailDH.setTrain(c.getTrain());
//				detailDH.setPrice(c.getQuantity()*c.getTrain().getPrice());	
//				detailDH.set(c.getSo_luong());
//				detailDH.setDonHang(d);
//				listDetailDH.add(detailDH);		
//				
//				listsp.add(c.getSanPham());
//				quanity.put(c.getSanPham().getId(), Integer.toString(c.getSo_luong()));
//			}
//			
//		}					
//			
//		indexCartService.save(listDetailDH);
//		
//		cleanUpAfterCheckOut(req,response);
//		model.addAttribute("donhang",donhang);
//		model.addAttribute("cart",listsp);
//		model.addAttribute("quanity",quanity);
//		return "client/thankYou";
//	}
	
	public void cleanUpAfterCheckOut(HttpServletRequest request, HttpServletResponse response)
	{
		User currentUser = getSessionUser(request);
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		
		if(auth == null || auth.getPrincipal() == "anonymousUser")    //Su dung cookie de luu
		{
			Cookie clientCookies[] = request.getCookies();
			for(int i=0;i<clientCookies.length;i++)
			{
				if(clientCookies[i].getName().matches("[0-9]+"))
				{						
					clientCookies[i].setMaxAge(0);
					clientCookies[i].setPath("/carshop");
					response.addCookie(clientCookies[i]);
				}
			}
		}else //Su dung database de luu
		{
			Cart g = cartService.getCartByUser(currentUser);
			List<CartIndex> c = indexCartService.getIndexCartByCart(g);
			indexCartService.deleteAllChiMucGiohang(c);
		}
	}
	
	
	
}
