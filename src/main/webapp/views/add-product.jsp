<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
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
			<form action="${pageContext.request.contextPath}/add-product"
				method="POST"
				enctype="multipart/form-data">
				
				<c:if test="${prod != null}">
					<input value="${prod.id}" type="hidden" name="id"/>
				</c:if>
				
				<div class="mb-3">
				  <label class="form-label">Name</label>
				  <input value="${prod.name}" name="name" type="text" class="form-control">
				</div>
				
				<div class="mb-3">
				  <label class="form-label">Price</label>
				  <input value="${prod.price}" name="price" type="text" class="form-control">
				</div>
				
				<div class="mb-3">
				  <label class="form-label">Quantity</label>
				  <input value="${prod.quantity}" name="quantity" type="text" class="form-control">
				</div>
				
				<div class="mb-3">
				  <label class="form-label">Category</label>
				  <select class="form-select" name="catId">
				  	<c:choose>
				  	
				  		<c:when test="${prod != null}">
				  			<option value="-1">----------Select category---------</option>
				  		</c:when>
				  		
				  		<c:otherwise>
				  			<option selected value="-1">----------Select category---------</option>
				  		</c:otherwise>
				  		
				  	</c:choose>
					  <c:forEach items="${categories}" var="item">
					  
					  	<c:choose>
					  	
					  		<c:when test="${prod != null && prod.category.id == item.id}">
					  			<option selected value="${item.id}">${item.name}</option>
					  		</c:when>
					  		
					  		<c:otherwise>
					  			<option value="${item.id}">${item.name}</option>
					  		</c:otherwise>
					  		
					  	</c:choose>
					  	
					  </c:forEach>
					</select>
				</div>
				
				<div class="mb-3">
				  <label class="form-label">Images</label>
				  <input name="images" type="file" class="form-control" multiple accept="image/*">
				</div>
				
				<div class="mb-3 row gap-3">
					<c:forEach items="${prod.images}" var="item">
						<a class="w-auto" href="${pageContext.request.contextPath}/remove-image?imageId=${item.id}&prodId=${prod.id}">
							<img style="width: 100px; height: 100px" src="${pageContext.request.contextPath}/images/${item.name}"/>
						</a>
					</c:forEach>
				</div>
				
				<input type="submit" class="btn btn-primary" value="Add Product"/>
			</form>
		</div>
	</div>

	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
</body>
</html>