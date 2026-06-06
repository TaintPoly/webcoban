<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Đăng ký</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-sRIl4kxILFvY47J16cr9ZwB07vP4J8+LH7qKQnuqkuIAvNWLzeN8tE5YBujZqJLB" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/js/bootstrap.bundle.min.js" integrity="sha384-FKyoEForCGlyvwx9Hj09JcYn3nv7wiPVlz7YYwJrWVcXK/BmnVDxM+D2scQbITxI" crossorigin="anonymous"></script>

</head>
<body>
<div class="container">
    <jsp:include page="/views/header.jsp"></jsp:include>
	<jsp:include page="/views/menu.jsp"></jsp:include>
	<main>
	 <label class="text-danger">${error }</label>
	<form action="/JVideo/register" method="post">
			<div class="mb-3">
			  <label for="email" class="form-label">Email</label>
			  <input type="email" class="form-control" id="email" name="email" placeholder="name@example.com">
			</div>
			<div class="mb-3">
			  <label for="password" class="form-label">Mật khẩu</label>
			  <input type="password" class="form-control" id="password" name="password" placeholder="mật khẩu">
			</div>
			<div class="mb-3">
			  <label for="repeatPassword" class="form-label">Nhập lại mật khẩu</label>
			  <input type="password" class="form-control" id="repeatPassword" name="repeatPassword" placeholder="xác nhận lại mật khẩu">
			</div>
			<div class="mb-3">
			  <label for="fullName" class="form-label">Họ và tên</label>
			  <input type="text" class="form-control" id="fullName" name="fullName" placeholder="Họ và tên">
			</div>
			<div class="mb-3">
			<button class="btn btn-primary">Đăng ký</button>
			</div>
	</form>
	</main>
</div>

</body>
</html>