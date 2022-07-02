<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <form action="/JavaServlet/admin/users/update?id={$user.id}"
    method="post"
>
    <label>Họ và tên</label>
    <input type="text" name="hoTen" values="${hoTen}"> <br>
    <label>Địa chỉ</label>
    <input type="text" name="diaChi" values="${diaChi}"> <br>
    <label>Email</label>
    <input type="email" name="email" value="${email}"> <br>
    <label>Mật khẩu</label>
    <input type="password" name="password" value="${password}"> <br>
    <label>Số điện thoại</label>
    <input name="sdt" value="${sdt}"> <br>
    <label>Giới tính</label>
    <input name="gioiTinh" value="1" type="radio">Nam
    <input name="gioiTinh" value="0" type="radio"> Nu<br>
    <button>cập nhật</button>
</form>