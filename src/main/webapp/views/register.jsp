<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
</head>
<body>
	<div class="container">
		<div class="col-4 offset-4">
			<p>${error}</p>
			<form method="POST"
				action="${pageContext.request.contextPath}/register?id=${user.id}">
				
				<div class="mb-3">
				  <label class="form-label">Username</label>
				  <input value="${user.username}" name="username" type="text" class="form-control">
				</div>
				
				<div class="mb-3">
				  <label class="form-label">Password</label>
				  <input value="${user.password}" name="password" type="password" class="form-control">
				</div>
				
				<div class="mb-3">
				  <label class="form-label">Name</label>
				  <input value="${user.name}" name="name" type="text" class="form-control">
				</div>
				
				<div class="mb-3">
				  <label class="form-label">Email</label>
				  <input value="${user.email}" name="email" type="text" class="form-control">
				</div>
				
				<div class="mb-3">
				  <label class="form-label">Address</label>
				  <input value="${user.address}" name="address" type="text" class="form-control">
				</div>
				
				<input type="submit" class="btn btn-primary" value="Login"/>
			</form>
		</div>
	</div>

	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
</body>
</html>