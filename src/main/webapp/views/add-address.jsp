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
				action="${pageContext.request.contextPath}/add-address">
				
				<input type="hidden" name="userId" value="${userId}"/>
				
				<div class="mb-3">
				  <label class="form-label">Customer name</label>
				  <input name="customerName" type="text" class="form-control">
				</div>
				
				<div class="mb-3">
				  <label class="form-label">Phone Number</label>
				  <input name="phoneNumber" type="text" class="form-control">
				</div>
				
				<div class="mb-3">
				  <label class="form-label">Address</label>
				  <input name="address" type="text" class="form-control">
				</div>
				
				<input type="submit" class="btn btn-primary" value="Add address"/>
			</form>
		</div>
	</div>

	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
</body>
</html>