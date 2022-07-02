<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <form action="/PH17124_HoangPhiHung_300322/admin/users/store"
    method="post"
>
    <label>Họ và tên</label>
    <input class="form-control" type="text" name="hoTen"> <br>
    <label>Địa chỉ</label>
    <input class="form-control" type="text" name="diaChi"> <br>
    <label>Email</label>
    <input class="form-control" type="email" name="email"><br>
    <label>Mật khẩu</label>
    <input class="form-control" type="password" name="password"><br>
    <label>Số điện thoại</label>
    <input class="form-control" name="sdt"><br>
    <label>Giới tính</label>
    <input name="gioiTinh" value="1" type="radio">Nam
    <input  name="gioiTinh" value="0" type="radio"> Nu<br>
    <button class="form-control">Thêm mới</button>
</form>