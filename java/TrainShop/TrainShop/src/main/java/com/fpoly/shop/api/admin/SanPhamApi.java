package com.fpoly.shop.api.admin;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.fpoly.shop.dto.SearchTrainObject;
import com.fpoly.shop.dto.TrainDTO;
import com.fpoly.shop.entities.ResponseObject;
import com.fpoly.shop.entities.Train;
import com.fpoly.shop.service.TrainService;
import com.fpoly.shop.validator.TrainValidator;

@RestController
@RequestMapping("api/san-pham")
public class SanPhamApi {

	@Autowired
	private TrainValidator validator;

	@Autowired
	private TrainService sanPhamService;

	@InitBinder("sanPhamDto")
	protected void initialiseBinder(WebDataBinder binder) {
		binder.setValidator(validator);
	}

	// lấy tất cả san phẩm theo tiêu chí, mặc địch lấy tất cả 
	@GetMapping("/all")
	public Page<Train> getAllSanPhamByFilter(@RequestParam(defaultValue = "1") int page, 
			 @RequestParam String danhMucId, @RequestParam String hangSXId, @RequestParam String donGia, @RequestParam String sapXepTheoGia) {
		SearchTrainObject searchObject = new SearchTrainObject();
		searchObject.setIdCategory(danhMucId);
		searchObject.setIdManufacturer(hangSXId);
		searchObject.setPrice(donGia);
		searchObject.setSoryByPrice(sapXepTheoGia);
		
		Page<Train> listSanPham = sanPhamService.getAllTrainByFilter(searchObject, page-1, 10);
		return listSanPham;
	}
	
	@GetMapping("/products")
	public List<Train> getLatestSanPham(){
		return sanPhamService.getLatestTrain();
	}

	// lấy sản phẩm theo id
	@GetMapping("/{id}")
	public Train getSanPhamById(@PathVariable long id) {
		return sanPhamService.getTrainById(id);
	}
	
	
	// lấy sản phẩm theo tên
	@GetMapping("/")
	public Page<Train> getSanPhamById(@RequestParam String tenSanPham, @RequestParam(defaultValue = "1") int page) {
		return sanPhamService.getTrainByTrainNameForAdmin(tenSanPham, page-1, 10 );
	}

	// lưu sản phẩm vào db
	@PostMapping(value = "/save")
	public ResponseObject addSanPham(@ModelAttribute @Valid TrainDTO newSanPhamDto, BindingResult result,
			HttpServletRequest request) {

		ResponseObject ro = new ResponseObject();

		// nếu có lỗi xảy ra ( validate)
		if (result.hasErrors()) {
			Map<String, String> errors = result.getFieldErrors().stream()
					.collect(Collectors.toMap(FieldError::getField, FieldError::getDefaultMessage));
			errors.forEach((k, v) -> System.out.println(" test: Key : " + k + " Value : " + v));
			ro.setErrorMessages(errors);
			ro.setStatus("fail");
			errors = null;
		} else {
			// lưu sản phẩm
			Train sp = sanPhamService.save(newSanPhamDto);
			ro.setData(sp);
			saveImageForProduct(sp, newSanPhamDto, request);
			ro.setStatus("success");
		}
		return ro;
	}
	
	
	@DeleteMapping("/delete/{id}")
	public String deleteSanPham(@PathVariable long id) {
		sanPhamService.deleteById(id);
		return "OK !";
	}

	
	// lưu ảnh của sản phẩm vào thư mục
	public void saveImageForProduct(Train sp, TrainDTO dto, HttpServletRequest request) {

		MultipartFile productImage = dto.getHinhAnh();
		String rootDirectory = request.getSession().getServletContext().getRealPath("/");
		Path path = Paths.get(rootDirectory + "/resources/images/" + sp.getId() + ".png");
		System.out.println(productImage != null && !productImage.isEmpty());
		if (productImage != null && !productImage.isEmpty()) {

			try {
				productImage.transferTo(new File(path.toString()));
			} catch (Exception ex) {
				ex.printStackTrace();
				throw new RuntimeException("Product image saving failed", ex);
			}
		}
	}
}
