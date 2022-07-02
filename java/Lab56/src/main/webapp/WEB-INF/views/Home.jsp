<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="/css/bootstrap.min.css" rel="stylesheet">
<link href="/css/style.css" rel="stylesheet">
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.8.3/font/bootstrap-icons.css">
</head>

<body ng-app="myapp">
	<div class="container" ng-controller="myController">
		<form action="/product/deletes" method="post">
			<div class="row"
				style="background: #435d7d; font-family: 'Varela Round', sans-serif; color: #fff;">
				<div class="col-9 mt-2 mb-2">
					<h3 class="fw-bold text-white">Quản lý Tàu</h3>
				</div>
				<div class="col-3 mt-2 mb-2">
					<a class="btn btn-danger" data-bs-toggle="modal"
						data-bs-target="#deleteEmployeeModal">Delete</a>
					<div id="deleteEmployeeModal" class="modal fade">
						<div class="modal-dialog  text-dark">
							<div class="modal-content">

								<div class="modal-header">
									<h4 class="modal-title" id="exampleModalLabel">Xóa nhiều
										Tàu</h4>
									<button type="button" class="btn-close" data-bs-dismiss="modal"
										aria-label="Close"></button>
								</div>
								<div class="modal-body">
									<p>Bạn có muốn xóa Những tàu được chọn ?</p>

								</div>
								<div class="modal-footer">
									<input type="button" class="btn btn-default"
										data-bs-dismiss="modal" value="Cancel"> <input
										type="submit" class="btn btn-danger" value="Delete">
								</div>

							</div>
						</div>
					</div>
					<a href="/product/create" type="button" class="btn btn-success">Thêm mới</a>
				</div>
			</div>
			<div class="row mt-3">


				<div class="col-5 offset-3 text-center">

					<label class="alert alert-${sessionScope.alert }">${sessionScope.message }</label>
					<c:remove var="alert" scope="session" />
					<c:remove var="message" scope="session" />

				</div>
				<div class="col-3   ">

					<div class="form-input-group">
					<div class="row">
					
						<label class="form-label col-4 mt-2 fw-bold">Loại tàu</label> 
						<div class="col-6">
						<select class="form-select"
							name="type">
							<option value="all">Tất cả</option>
							<c:forEach items="${type }" var="loai">
								<option value="${loai }" ${typeHT == loai ? 'selected' :'' }>${loai }</option>
							</c:forEach>
						</select>
						</div>
						<div class="col-2">
						<button class="btn btn-success" formaction="/product/search" formmethod="get">Search</button>
						</div>
						
					</div>

					</div>

				</div>


			</div>
			<div class="row mt-3 ">
				<table class="table table-striped table-hover">
					<thead class="text-center">
						<tr>
							<th><input type="checkbox" ng-click="select()"
								ng-model="selectAll" class="form-check-input"></th>
							<th>Name</th>
							<th>Date</th>
							<th>Type<th>
							<th>CarriageNumber</th>
							<th>SeatNumber</th>
							
							<th colspan="1">Thao tác</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${trains }" var="train">
							<tr>
								<td class="text-center"><input type="checkbox"
									class="form-check-input" ng-checked="selectAll" name="id"
									value="${train.id }"></td>
								<td class="text-center">${train.name }</td>
								<td class="text-center"><fmt:formatDate
										value="${train.createdDate }" pattern="dd-MM-yyyy" /></td>
								<td class="text-center">${train.type }</td>
								<td class="text-center">${train.seatNumber }</td>
								<td class="text-center">${train.carriageNumber }</td>
								
								<td><a href="/product/edit/${train.id }"
									class="bi bi-pencil-fill text-warning offset-5"></a>
									
									 <a type="button" class="bi bi-trash-fill text-danger"
									data-bs-toggle="modal"
									data-bs-target="#deleteEmployeeModal${train.id }"></a>
									<div id="deleteEmployeeModal${train.id }" class="modal fade">
										<div class="modal-dialog  text-dark">
											<div class="modal-content">
												<form action="/product/remove?id=${train.id }" method="post">
													<div class="modal-header">
														<h4 class="modal-title" id="exampleModalLabel">Xóa
															Tàu ${train.name }</h4>
														<button type="button" class="btn-close"
															data-bs-dismiss="modal" aria-label="Close"></button>
													</div>
													<div class="modal-body">
														<p>Bạn có muốn xóa tàu này ?</p>

													</div>
													<div class="modal-footer">
														<input type="button" class="btn btn-default"
															data-bs-dismiss="modal" value="Cancel"> <input
															type="submit" class="btn btn-danger" value="Delete">
													</div>
												</form>
											</div>

										</div>
									</div></td>

							</tr>
						</c:forEach>
					</tbody>
				</table>
				<div class="clearfix">
					<div class="hint-text">
						Showing <b>5</b> out of <b>${count }</b> entries
					</div>
					<ul class="pagination">
						<li class="page-item"><a href="/product/home?page=1">First</a></li>
						<c:forEach begin="1" end="${pagecount }" var="pagecount">
							<li class="page-item ${page+1 == pagecount ? 'active' :'' }"><a
								href="/product/home?page=${pagecount }" class="page-link">${pagecount}</a></li>
						</c:forEach>

						<li class="page-item"><a
							href="/product/home?page=${pagecount }" class="page-link">Last</a></li>
					</ul>
				</div>
			</div>
		</form>
	</div>
	<script src="/js/jquery.min.js"></script>
	<script src="/js/popper.min.js"></script>
	<script src="/js/angularJS.min.js"></script>
	<script src="/js/bootstrap.min.js"></script>
	<script>
		var app = angular.module("myapp", []);
		app.controller("myController", function($scope) {
			$scope.selectAll = false;
			$scope.select = function() {
				$scope.selectAll = true;
				console.log($scope.selectAll);
			}
		});
	</script>

</body>
</html>