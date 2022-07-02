<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<form action="/JavaServlet/admin/users/store"
		method="post"
	>
		<label>Họ và tên</label>
		<input type="text" name="hoTen"> <br>
		<label>Địa chỉ</label>
		<input type="text" name="diaChi"> <br>
		<label>Email</label>
		<input type="email" name="email"><br>
		<label>Mật khẩu</label>
		<input type="password" name="password"><br>
		<label>Số điện thoại</label>
		<input name="sdt"><br>
		<label>Giới tính</label>
		<input name="gioiTinh" value="1" type="radio">Nam
		<input name="gioiTinh" value="0" type="radio"> Nu<br>
		<button>Thêm mới</button>
	</form>