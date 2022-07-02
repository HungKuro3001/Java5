<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 3/30/2022
  Time: 1:14 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>

<form method="POST"
      action="/Test/admin/users/store">
    <div>control
        <label >Họ tên</label>
        <input class="form-control" type="text" name="hoTen" />
    </div>
    <div>
        <label>Địa chỉ</label>
        <input class="form-control" type="text" name="diaChi" />
    </div>
    <div>
        <label>SĐT</label>
        <input class="form-control" type="text" name="sdt" />
    </div>
    <div>
        <label>Email</label>
        <input class="form-control" type="email" name="email" />
    </div>
    <div>
        <label>Password</label>
        <input class="form-control" type="password" name="password" />
    </div>
    <div>
        <label>Giới tính</label>
        <input class="form-control" type="radio" name="gioiTinh" value="1" />
        <label>Nam</label>
        <input class="form-control" type="radio" name="gioiTinh" value="0" />
        <label>Nữ</label>
    </div>
    <div>
        <button>Thêm mới</button>
    </div>
</form>