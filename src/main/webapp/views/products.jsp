<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH"
	crossorigin="anonymous">
</head>
<body>
	<div class="container p-5">
		<div class="pt-3 pb-3">
			<a class="btn btn-primary w-auto"
				href="${pageContext.request.contextPath}/add-product">Add Address</a>
		</div>
		<table class="table">
			<thead>
				<tr>
					<th scope="col">ID</th>
					<th scope="col">Name</th>
					<th scope="col">Price</th>
					<th scope="col">Quantity</th>
					<th scope="col">Image</th>
					<th scope="col">#</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${addresses}" var="item">
					<tr>
					<td>${item.addressId}</td>
					<td>${item.customerName}</td>
					<td>${item.phoneNumber}</td>
					<td>${item.address}</td>
					<td>${item.user.username}</td>
					<td>
						<div class="row">
							<a class="btn btn-primary w-auto me-3" href="#">Update</a>
							<input type="submit" class="btn btn-danger w-auto" value="Delete" />
						</div>
					</td>
				</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz"
		crossorigin="anonymous"></script>
</body>
</html>