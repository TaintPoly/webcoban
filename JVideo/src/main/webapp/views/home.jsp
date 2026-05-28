<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
	<jsp:include page="/views/header.jsp"></jsp:include>
	<jsp:include page="/views/menu.jsp"></jsp:include>
	<main>
		<div class="row">
			<div class="col-md-4">
				<div class="card">
				  <img src="https://photo.znews.vn/w480/Uploaded/bpiqdqmv/2026_05_23/morganrogers.JPG" class="card-img-top" alt="...">
				  <div class="card-body">
				  	<a href="/JVideo/video/detail?id=1">
				    <h5 class="card-title">Card title</h5>
				    </a>
				    <p class="card-text">Some quick example text to build on the card title and make up the bulk of the card’s content.</p>
				    <a href="#" class="btn btn-primary">Go somewhere</a>
				  </div>
				</div>
			</div>
			
			<div class="col-md-4">
				<div class="card">
				  <img src="https://photo.znews.vn/w480/Uploaded/bpiqdqmv/2026_05_23/morganrogers.JPG" class="card-img-top" alt="...">
				  <div class="card-body">
				 	 <a href="/JVideo/video/detail?id=2">
				    <h5 class="card-title">Card title</h5>
				    </a>
				    <p class="card-text">Some quick example text to build on the card title and make up the bulk of the card’s content.</p>
				    <a href="#" class="btn btn-primary">Go somewhere</a>
				  </div>
				</div>
			</div>
			
			<div class="col-md-4">
				<div class="card">
				  <img src="https://photo.znews.vn/w480/Uploaded/bpiqdqmv/2026_05_23/morganrogers.JPG" class="card-img-top" alt="...">
				  <div class="card-body">
				    <h5 class="card-title">Card title</h5>
				    <p class="card-text">Some quick example text to build on the card title and make up the bulk of the card’s content.</p>
				    <a href="#" class="btn btn-primary">Go somewhere</a>
				  </div>
				</div>
			</div>
			
			<div class="col-md-4">
				<div class="card">
				  <img src="https://photo.znews.vn/w480/Uploaded/bpiqdqmv/2026_05_23/morganrogers.JPG" class="card-img-top" alt="...">
				  <div class="card-body">
				    <h5 class="card-title">Card title</h5>
				    <p class="card-text">Some quick example text to build on the card title and make up the bulk of the card’s content.</p>
				    <a href="#" class="btn btn-primary">Go somewhere</a>
				  </div>
				</div>
			</div>	
		</div>
	
	</main>
	
	<footer>
	
	
	</footer>
</div>

</body>
</html>