package com.fpoly.shop.api.admin;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.fpoly.shop.entities.Cart;
import com.fpoly.shop.entities.CartIndex;
import com.fpoly.shop.entities.ResponseObject;
import com.fpoly.shop.entities.Train;
import com.fpoly.shop.entities.User;
import com.fpoly.shop.service.CartService;
import com.fpoly.shop.service.IndexCartService;
import com.fpoly.shop.service.TrainService;
import com.fpoly.shop.service.UserService;

@RestController
@RequestMapping("api/gio-hang")
@SessionAttributes("loggedInUser")
public class GioHangApi  {
	
	@Autowired
	private UserService userService;
	@Autowired
	private CartService cartService;
	@Autowired
	private TrainService trainService;
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
	
	@GetMapping("/addSanPham")
	public ResponseObject addToCart(@RequestParam String id,HttpServletRequest request,HttpServletResponse response) {
		ResponseObject ro = new ResponseObject();
		Train sp = trainService.getTrainById(Long.parseLong(id));
		if(sp.getQuantity() == 0)
		{
			ro.setStatus("false");
			return ro;
		}
		User currentUser = getSessionUser(request);
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();	
		if(auth == null || auth.getPrincipal() == "anonymousUser" )    //Su dung cookie de luu
		{
			Cookie clientCookies[] = request.getCookies();
			boolean found = false;
			for(int i=0;i<clientCookies.length;i++)
			{
				if(clientCookies[i].getName().equals(id))     //Neu san pham da co trong cookie tang so luong them 1
				{				
					clientCookies[i].setValue(Integer.toString(Integer.parseInt(clientCookies[i].getValue())+1));
					clientCookies[i].setPath("/carshop");
					clientCookies[i].setMaxAge(60*60*24*7);
					response.addCookie(clientCookies[i]);
					found = true;
					break;
				}
			}
			if(!found)   //Neu san pham ko co trong cookie,them vao cookie
			{
				Cookie c = new Cookie(id,"1");
				c.setPath("/carshop");
				c.setMaxAge(60*60*24*7);
				response.addCookie(c);
			}
		}else {     //Su dung database de luu
			Cart g = cartService.getCartByUser(currentUser);
			if(g==null)
			{
				g = new Cart();
				g.setUser(currentUser);
				g = cartService.save(g);			
			}
			
			CartIndex c = indexCartService.getIndexCartByCartAndTrain(sp,g);
			if(c== null)     //Neu khong tim chi muc gio hang, tao moi
			{
				System.out.println(g.getUser().getEmail());
				System.out.println(g.getId());
				c = new CartIndex();
				c.getCart();
				c.setTrain(sp);
				c.setQuantity(1);
			}else       //Neu san pham da co trong database tang so luong them 1
			{
				c.setQuantity(c.getQuantity()+1);
			}
			c = indexCartService.saveIndexCart(c);
		}
		ro.setStatus("success");
		return ro;
	}
	
	@GetMapping("/changSanPhamQuanity")
	public ResponseObject changeQuanity(@RequestParam String id,@RequestParam String value,HttpServletRequest request,HttpServletResponse response) {
		User currentUser = getSessionUser(request);
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		ResponseObject ro = new ResponseObject();
		if(auth == null || auth.getPrincipal() == "anonymousUser" )    //Su dung cookie de luu
		{
			Cookie clientCookies[] = request.getCookies();
			for(int i=0;i<clientCookies.length;i++)
			{
				if(clientCookies[i].getName().equals(id))
				{						
					clientCookies[i].setValue(value);
					clientCookies[i].setPath("/carshop");
					clientCookies[i].setMaxAge(60*60*24*7);
					response.addCookie(clientCookies[i]);
					break;
				}
			}
		}else //Su dung database de luu
		{
			Cart g = cartService.getCartByUser(currentUser);
			Train sp = trainService.getTrainById(Long.parseLong(id));
			CartIndex c = indexCartService.getIndexCartByCartAndTrain(sp,g);
			c.setQuantity(Integer.parseInt(value));
			c = indexCartService.saveIndexCart(c);
		}
		ro.setStatus("success");
		return ro;
	}
	
	@GetMapping("/deleteFromCart")
	public ResponseObject deleteSanPham(@RequestParam String id,HttpServletRequest request,HttpServletResponse response) {
		User currentUser = getSessionUser(request);
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();	
		ResponseObject ro = new ResponseObject();
		if(auth == null || auth.getPrincipal() == "anonymousUser")    //Su dung cookie de luu
		{
			Cookie clientCookies[] = request.getCookies();
			for(int i=0;i<clientCookies.length;i++)
			{
				if(clientCookies[i].getName().equals(id))
				{						
					clientCookies[i].setMaxAge(0);
					clientCookies[i].setPath("/carshop");
					System.out.println(clientCookies[i].getMaxAge());
					response.addCookie(clientCookies[i]);
					break;
				}
			}
		}else //Su dung database de luu
		{
			Cart g = cartService.getCartByUser(currentUser);
			Train sp = trainService.getTrainById(Long.parseLong(id));
			CartIndex c = indexCartService.getIndexCartByCartAndTrain(sp,g);
			indexCartService.deleteIndexCart(c);
		}
		
		ro.setStatus("success");
		return ro;
	}
}
