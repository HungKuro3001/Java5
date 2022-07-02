package com.fpoly.shop.controller;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.fpoly.shop.dto.ListTask;
import com.fpoly.shop.entities.Role;
import com.fpoly.shop.entities.User;
import com.fpoly.shop.service.CategoryService;
import com.fpoly.shop.service.ManufacturerService;
import com.fpoly.shop.service.OrderService;
import com.fpoly.shop.service.RoleService;
import com.fpoly.shop.service.UserService;

@Controller
@RequestMapping("/admin")
@SessionAttributes("loggedInUser")
public class AdminController {

	@Autowired
	private CategoryService categoryService;

	@Autowired
	private ManufacturerService manufacturerService;

	@Autowired
	private UserService userService;

	@Autowired
	private RoleService roleService;
	


	@Autowired
	private OrderService orderService;

	@ModelAttribute("loggedInUser")
	public User loggedInUser() {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		return userService.findByEmail(auth.getName());
	}

	@GetMapping
	public String adminPage(Model model) {
		ListTask listCongViec = new ListTask();
		listCongViec.setNewOrder(orderService.countByStatusOrder("Đang chờ giao"));
		listCongViec.setOrderWaitting(orderService.countByStatusOrder("Chờ duyệt"));
		
		model.addAttribute("listCongViec", listCongViec);
		return "admin/trangAdmin";
	}

	@GetMapping("/danh-muc")
	public String quanLyDanhMucPage() {
		return "admin/quanLyDanhMuc";
	}

	@GetMapping("/nhan-hieu")
	public String quanLyNhanHieuPage() {
		return "admin/quanLyNhanHieu";
	}


	
	@GetMapping("/san-pham")
	public String quanLySanPhamPage(Model model) {
		model.addAttribute("listNhanHieu", manufacturerService.getALlHangSX());
		model.addAttribute("listDanhMuc", categoryService.getAllCategory());
		return "admin/quanLySanPham";
	}

	@GetMapping("/profile")
	public String profilePage(Model model, HttpServletRequest request) {
		model.addAttribute("user", getSessionUser(request));
		return "admin/profile";
	}

	@PostMapping("/profile/update")
	public String updateUser(@ModelAttribute User nd, HttpServletRequest request) {
		User currentUser = getSessionUser(request);
		currentUser.setAddress(nd.getAddress());
		currentUser.setName(nd.getName());
		currentUser.setSdt(nd.getSdt());
		userService.updateUser(currentUser);
		return "redirect:/admin/profile";
	}

//	@GetMapping("/don-hang")
//	public String quanLyDonHangPage(Model model) {
//		Set<Role> vaiTro = new HashSet<>();
//		// lấy danh sách shipper
//		vaiTro.add(roleService.findByNameRole("ROLE_SHIPPER"));
//		List<User> shippers = nguoiDungService.getNguoiDungByVaiTro(vaiTro);
//		for (NguoiDung shipper : shippers) {
//			shipper.setListDonHang(donHangService.findByTrangThaiDonHangAndShipper("Đang giao", shipper));
//		}
//		model.addAttribute("allShipper", shippers);
//		return "admin/quanLyDonHang";
//	}

	@GetMapping("/tai-khoan")
	public String quanLyTaiKhoanPage(Model model) {
	    model.addAttribute("listVaiTro", roleService.findAllVaiTro());
		return "admin/quanLyTaiKhoan";
	}
	
	@GetMapping("/thong-ke")
	public String thongKePage(Model model) {
		return "admin/thongKe";
	}
	
	public User getSessionUser(HttpServletRequest request) {
		return (User) request.getSession().getAttribute("loggedInUser");
	}
	
	

}
