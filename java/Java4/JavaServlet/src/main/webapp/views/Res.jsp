<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="/JavaServlet/ResController"
		method="post"
	>
		<label>Họ và tên</label>
		<input type="text" name="hoten"> <br>
		<label>Địa chỉ</label>
		<input type="text" name="diachi"> <br>
		<label>Email</label>
		<input type="email" name="email"><br>
		<label>Mật khẩu</label>
		<input type="password" name="password"><br>
		<label>Số điện thoại</label>
		<input name="sdt"><br>
		<label>Giới tính</label>
		<input name="gioitinh" value="1" type="radio">Nam
		<input name="gioitinh" value="0" type="radio"> Nu<br>
		<label>Loại khách hàng</label>
		<select name="loaiKH">
			<option value="1">Vip</option>
			<option value="0">Thuong</option>
		</select><br>
		
		<button>Đăng kí</button>
	</form>
</body>
</html>