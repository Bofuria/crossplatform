<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Fishing Website</title>
	<spring:url value="/resources/css/bootstrap.min.css"  var="mainCss"/>
	<link href="${mainCss}" rel="stylesheet" />
</head>
<body>
	<nav class="navbar navbar-expand-lg navbar-light bg-light">
		<a class="navbar-brand" href="#">Home</a>
		<button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>
		<div class="collapse navbar-collapse" id="navbarNav">
			<ul class="navbar-nav">
				<li class="nav-item">
					<a class="nav-link" href="orders.jsp">My orders</a>
				</li>
			</ul>
		</div>
		<div class="ml-auto">
			<a class="btn btn-primary" href="cabinet.jsp">My cabinet</a>
		</div>
	</nav>
	<div class="container mt-4">
		<div class="row">
			<div class="col-md-6 offset-md-3">
				<form action="#" method="GET">
					<div class="input-group mb-3">
						<input type="text" class="form-control" placeholder="Search for fishing items" aria-label="Search for fishing items" aria-describedby="button-addon2">
						<div class="input-group-append">
							<button class="btn btn-primary" type="submit" id="button-addon2">Search</button>
						</div>
					</div>
				</form>
			</div>
		</div>
		<div class="row">
            <c:forEach items="${goodsList}" var="goodsItem" varStatus="status">
                <div class="col-md-3 mb-4">
                    <div class="card">
                        <img src="${pageContext.request.contextPath}/images/${goodsItem.goods_id}.jpg" class="card-img-top" alt="...">
                        <div class="card-body">
                            <h5 class="card-title">${goodsItem.name}</h5>
                            <p class="card-text">$${goodsItem.price}</p>
                            <a href="#" class="btn btn-primary">Buy</a>
                        </div>
                    </div>
                </div>
                <c:if test="${status.count % 4 == 0}">
                    </div><div class="row">
                </c:if>
            </c:forEach>
        </div>
	</div>
</body>
</html>
