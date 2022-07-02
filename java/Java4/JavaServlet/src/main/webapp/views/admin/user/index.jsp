<%@ page language="java" contentType="text/html; charset=UTF-8" session="true"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>

        <c:if test = "${!empty sessionScope.error}">
            <div class="alert alert-danger">
                ${sessionScope.error}
            </div>
        </c:if>
        <table class="table">
            <thead>
                <tr>
                    <th scope="col">Họ tên</th>
                    <th scope="col">Địa chỉ</th>
                    <th scope="col">SDT</th>
                    <th scope="col">Email</th>
                    <th scope="col">Giới tính</th>
                   
                </tr>
            </thead>
            <tbody>
               <c:forEach var="obj" items="${ds}" >
                <tr>
                    <td>${obj.hoTen}</td>
                    <td>${obj.diaChi}</td>
                    <td>${obj.sdt}</td>
                    <td>${obj.email}</td>
                    <td>
                    <c:choose>
                        <c:when test="${obj.gioiTinh == 0}">
                            <td>Nam</td>
                        </c:when>
                        <c:otherwise>
                            <td>Nữ</td>
                        </c:otherwise>
                    </c:choose>
                    <td>
                    <td>
                    	<a class "btn btn-primary" href="/JavaServlet/admin/users/edit?id=${obj.id}">Cập nhật</a>
                    <td>
                    <td>
                    	<a class "btn btn-Danger" href="/JavaServlet/admin/users/delete?id=${obj.id}">Xoá</a>
                    <td>
                </tr>
                
               </c:forEach>
            </tbody>
        </table>
    
