<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 3/30/2022
  Time: 1:14 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>

<c:if test="${ empty ds }">
    <p class="alert alert-warning">Không có bản ghi</p>
</c:if>

<c:if test="${ !empty ds }">
    <table class="table">
        <thead class="table-primary">
        <th>Họ tên</th>
        <th>Địa chỉ</th>
        <th>SĐT</th>
        <th>Email</th>
        <th>Giới tính</th>
        <th colspan="2">Thao tác</th>
        </thead>
        <tbody>
        <c:forEach var="obj" items="${ ds }">
            <tr>
                <td>${ obj.hoTen }</td>
                <td>${ obj.diaChi }</td>
                <td>${ obj.sdt }</td>
                <td>${ obj.email }</td>
                <td>
                    <c:choose>
                        <c:when test="${ obj.gioiTinh == 1 }">Nam</c:when>
                        <c:when test="${ obj.gioiTinh == 0 }">Nữ</c:when>
                        <c:otherwise> - </c:otherwise>
                    </c:choose>
                </td>
                <td>
                    <a class="btn btn-primary"
                       href="/Test/admin/users/edit?id=${ obj.id }"
                    >
                        Cập nhật
                    </a>
                </td>
                <td>
                    <a class="btn btn-danger"
                       href="/Test/admin/users/delete?id=${ obj.id }"
                    >
                        Xóa
                    </a>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</c:if>
