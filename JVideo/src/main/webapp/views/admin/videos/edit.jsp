<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>  
<%@ taglib uri="http://java.sun.com/jstl/fmt_rt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-sRIl4kxILFvY47J16cr9ZwB07vP4J8+LH7qKQnuqkuIAvNWLzeN8tE5YBujZqJLB" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/js/bootstrap.bundle.min.js" integrity="sha384-FKyoEForCGlyvwx9Hj09JcYn3nv7wiPVlz7YYwJrWVcXK/BmnVDxM+D2scQbITxI" crossorigin="anonymous"></script>
</head>
<body>
	<div class="container">
		<jsp:include page="/views/admin/header.jsp"></jsp:include>
		
		<jsp:include page="/views/admin/menu.jsp"></jsp:include>
		<main>
			<h1>Chỉnh sửa video</h1>
			<label class="text-success">${message }</label>
			<label class="text-danger">${message_error }</label>
			<form action="/JVideo/admin/videos/edit?id=${video.id}" method="post">
				<div class="mb-3">
				  <label for="title" class="form-label">Tiêu đề</label>
				  <input type="text" class="form-control" id="title" name="title" value="${video.title}"  required>
					<label class="text-danger">${errors.title }</label>
				</div>
				<div class="mb-3">
				  <label for="poster" class="form-label">Ảnh đại diện</label>
				  <input type=text class="form-control" id="poster" name="poster" value="${video.poster}">
					<label class="text-danger">${errors.poster }</label>
				</div>
				<div class="mb-3">
				  <label for="poster" class="form-label">Youtube Id</label>
				  <input type=text class="form-control" id="youtubeId" name="youtubeId" value="${video.youtubeId}">
				</div>
				<div class="mb-3">
				  <label for="description" class="form-label">Mô tả</label>
				  <textarea class="form-control" name="description" id="description" rows="3" >${video.description}</textarea>
				</div>
				
				<div class="mb-3">
					<label for="description" class="form-label">Hoạt động</label>
					<div class="form-check form-check-inline">
					  <input class="form-check-input" type="radio" name="active" id="active1" value="true" checked>
					  <label class="form-check-label" for="inlineRadio1">Hoạt động</label>
					</div>
					<div class="form-check form-check-inline">
					  <input class="form-check-input" type="radio" name="active" id="active2" value="false">
					  <label class="form-check-label" for="inlineRadio2">Ngưng hoạt động</label>
					</div>
				</div>
				
				<div class="mb-3">
					<button class="btn btn-primary">Lưu</button>
					<a href="/JVideo/admin/videos" class="btn btn-secondary">Quay lại</a>
				</div>
			</form>
			
		</main>
	</div>
</body>
</html>