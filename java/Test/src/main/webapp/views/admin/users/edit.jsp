<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 3/30/2022
  Time: 1:17 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<form method="POST"
      action="/Test/admin/users/update?id=${ user.id }">
    <div>
        <label>Họ tên</label>
        <input type="text" name="hoTen" value="${ user.hoTen }" />
    </div>
    <div>
        <label>Địa chỉ</label>
        <input type="text" name="diaChi" value="${ user.diaChi }" />
    </div>
    <div>
        <label>SĐT</label>
        <input type="text" name="sdt" value="${ user.sdt }" />
    </div>
    <div>
        <label>Email</label>
        <input type="email" name="email" value="${ user.email }" />
    </div>
    <div>
        <label>Password</label>
        <input type="password" name="password" />
    </div>
    <div>
        <label>Giới tính</label>
        <input type="radio" name="gioiTinh" value="1"
        ${ user.gioiTinh == 1 ? "checked" : "" }
        />
        <label>Nam</label>
        <input type="radio" name="gioiTinh" value="0"
        ${ user.gioiTinh == 0 ? "checked" : "" }
        />
        <label>Nữ</label>
    </div>
    <div>
        <button>Cập nhật</button>
    </div>

</form>
