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
		<header>
		
		</header>
		<nav>
		
		</nav>
		
		<main>
			<h1>Danh sách video</h1>
			<table class="table">
			  <thead>
			    <tr>
			      <th scope="col">#</th>
			      <th scope="col">First</th>
			      <th scope="col">Last</th>
			      <th scope="col">Hành động</th>
			    </tr>
			  </thead>
			  <tbody>
			  	<c:forEach items="${list}" var="vd">
				    <tr>
				      <th scope="row">${vd.id}</th>
				      <td>${vd.title}</td>
				      <td>Otto</td>
				      <td>
				      	<c:if test="${vd.active}">
				      		<a href="#">Ngưng hoạt động</a>
				      	</c:if>
				      </td>
				    </tr>
			    </c:forEach>
			  </tbody>
			</table>
		</main>
	</div>
</body>
</html>