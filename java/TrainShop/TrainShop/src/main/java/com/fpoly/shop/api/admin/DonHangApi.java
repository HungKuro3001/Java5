package com.fpoly.shop.api.admin;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fpoly.shop.dto.SearchOrderObject;
import com.fpoly.shop.entities.Cart;
import com.fpoly.shop.entities.CartIndex;
import com.fpoly.shop.entities.Order;
import com.fpoly.shop.entities.OrderDetail;
import com.fpoly.shop.entities.Train;
import com.fpoly.shop.service.OrderService;
import com.fpoly.shop.service.UserService;



@RestController
@RequestMapping("/api/don-hang")
public class DonHangApi {

	@Autowired
	private OrderService orderService;

	@Autowired
	private UserService userService;

	// lấy danh sách đơn hàng theo search object
	@GetMapping("/all")
	public Page<Order> getDonHangByFilter(@RequestParam(defaultValue = "1") int page, @RequestParam String trangThai,
			@RequestParam String tuNgay, @RequestParam String denNgay) throws ParseException {

		SearchOrderObject object = new SearchOrderObject();
		object.setEndDate(denNgay);
		object.setStatus(trangThai);
		object.setStartDate(tuNgay);
		Page<Order> listDonHang = orderService.getAllOrderByFilter(object, page);
		return listDonHang;
	}

	@GetMapping("/{id}")
	public Order getDonHangById(@PathVariable long id) {
		return orderService.findById(id);
	}

	// phân công đơn hàng
	@PostMapping("/assign")
	public void phanCongDonHang(@RequestParam("shipper") String emailShipper,
			@RequestParam("donHangId") long donHangId) {
		Order dh = orderService.findById(donHangId);
		dh.setStatus("Đang giao");
	

		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		try {

			String dateStr = format.format(new Date());
			Date date = format.parse(dateStr);
			dh.setDateShip(date);
		} catch (ParseException e) {
			e.printStackTrace();
		}

		orderService.save(dh);
	}

	// xác nhận hoàn thành đơn hàng
	@PostMapping("/update")
	public void xacNhanHoanThanhDon(@RequestParam("donHangId") long donHangId,
			@RequestParam("ghiChu") String ghiChuAdmin) {
		Order dh = orderService.findById(donHangId);
		
		for(OrderDetail ct : dh.getOrderDetail()) {
			Train sp = ct.getTrain();
			
		}
		dh.setStatus("Hoàn thành");

	
		orderService.save(dh);
	}

	// xác nhận hoàn thành đơn hàng
	@PostMapping("/cancel")
	public void huyDonHangAdmin(@RequestParam("donHangId") long donHangId) {
		Order dh = orderService.findById(donHangId);
		dh.setStatus("Đã bị hủy");
		orderService.save(dh);
	}
//
////	// lấy dữ liệu làm báo cáo thống kê
	@GetMapping("/report")
	public List<Object> test() {
		return orderService.getOrderByDateYear();
	}
}
