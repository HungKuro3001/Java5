package com.fpoly.shop.controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.fpoly.shop.dto.SearchTrainObject;
import com.fpoly.shop.entities.Category;
import com.fpoly.shop.entities.Train;
import com.fpoly.shop.entities.User;
import com.fpoly.shop.service.CategoryService;
import com.fpoly.shop.service.TrainService;
import com.fpoly.shop.service.UserService;

@Controller
@SessionAttributes("loggedInUser")
@RequestMapping("/")
public class ClientController {

	@Autowired
	private TrainService trainService;

	@Autowired
	private UserService userService;
	
	@Autowired
	private CategoryService categoryService;
	


	@ModelAttribute("loggedInUser")
	public User loggedInUser() {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		return userService.findByEmail(auth.getName());
	}
	
	@ModelAttribute("listDanhMuc")
	public List<Category> listDanhMuc(){
		return categoryService.getAllCategory();
	}

	public User getSessionUser(HttpServletRequest request) {
		return (User) request.getSession().getAttribute("loggedInUser");
	}

	@GetMapping
	public String clientPage(Model model) {
		return "client/home";
	}

	@GetMapping("/login")
	public String loginPage() {
		return "client/login";
	}
	
	@GetMapping("/contact")
	public String contactPage() {
		return "client/contact";
	}
	


	@GetMapping("/store")
	public String storePage(@RequestParam(defaultValue = "1") int page,@RequestParam(defaultValue = "") String price,@RequestParam(defaultValue = "") String brand,@RequestParam(defaultValue = "") String manufactor,@RequestParam(defaultValue = "") String seatNumber,@RequestParam(defaultValue = "") String carrierNumber,@RequestParam(defaultValue = "") String length,Model model) {		
		SearchTrainObject obj = new SearchTrainObject();
		obj.setBrand(brand);
		obj.setPrice(price);
		obj.setManufactor(manufactor);
		obj.setSeatNumber(seatNumber);
		
		obj.setCarrierNumber(carrierNumber);
		obj.setLength(length);
		Page<Train> list = trainService.getTrainByBrand(obj,page,12);
		int totalPage = list.getTotalPages();
		model.addAttribute("totalPage",totalPage);
		model.addAttribute("list",list.getContent());
		model.addAttribute("currentPage",page);
		model.addAttribute("price",price);
		model.addAttribute("brand",brand);
		model.addAttribute("manufactor",manufactor);
		model.addAttribute("seatNumber",seatNumber);
		model.addAttribute("carrierNumber",carrierNumber);
		model.addAttribute("length",length);
		List<Integer> pagelist = new ArrayList<Integer>();
		
		//Lap ra danh sach cac trang
		if(page==1 || page ==2 || page == 3 || page == 4)
		{
			for(int i = 2; i <=5 && i<=totalPage; i++)
			{
				pagelist.add(i);
			}
		}else if(page == totalPage)
		{
			for(int i = totalPage; i >= totalPage - 3 && i> 1; i--)
			{
				pagelist.add(i);
			}
			Collections.sort(pagelist);
		}else
		{
			for(int i = page; i <= page + 2 && i<= totalPage; i++)
			{
				pagelist.add(i);
			}
			for(int i = page-1; i >= page - 2 && i> 1; i--)
			{
				pagelist.add(i);
			}
			Collections.sort(pagelist);
		}
		model.addAttribute("pageList",pagelist);
			
		//Lay cac danh muc va hang san xuat tim thay
		Set<String> hangsx = new HashSet<String>();
		Set<String> pinSet = new HashSet<String>();
		Iterable<Train> dum = trainService.getTrainByNameCategory(brand);
		for(Train sp: dum)
		{
			hangsx.add(sp.getManufacturer().getNameManufacturer());
			if(brand.equals("Train"))
			{
				pinSet.add(sp.getName());
			}
		}
		model.addAttribute("hangsx",hangsx);
		model.addAttribute("pinSet",pinSet);
		return "client/store";
	}

	@GetMapping("/sp")
	public String detailspPage(@RequestParam int id, Model model) {
		Train sp = trainService.getTrainById(id);
		model.addAttribute("sp", sp);
		return "client/detailsp";
	}

	@GetMapping(value = "/logout")
	public String logoutPage(HttpServletRequest request, HttpServletResponse response, HttpSession session) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		if (auth != null) {
			new SecurityContextLogoutHandler().logout(request, response, auth);
		}
		return "redirect:/login?logout";
	}



	@GetMapping("/guarantee")
	public String guaranteePage(Model model) {

		return "client/guarantee";
	}

}
