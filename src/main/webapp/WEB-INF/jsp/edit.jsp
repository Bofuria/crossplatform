<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Add Product</title>
    <link href="<c:url value='/resources/css/bootstrap.min.css' />" rel="stylesheet" />
</head>
<body>
    <nav class="navbar navbar-expand-lg navbar-light bg-light">
    		<a class="navbar-brand" href="/index">Home</a>
    		<button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
    			<span class="navbar-toggler-icon"></span>
    		</button>
    		<div class="collapse navbar-collapse" id="navbarNav">
    			<ul class="navbar-nav">
                	<li class="nav-item">
                		<a class="nav-link" href="edit">Edit</a>
                	</li>
                	<li class="nav-item">
                		<a class="nav-link" href="orders">My orders</a>
                	</li>
                </ul>
    		</div>
    		<div class="ml-auto">
    			<a class="btn btn-primary" href="cabinet">My cabinet</a>
    		</div>
    </nav>
    <div class="container mt-4">
        <h1>Add Product</h1>
        <form:form method="POST" action="${pageContext.request.contextPath}/products" enctype="multipart/form-data">
            <div class="form-group">
                <label for="name">Name:</label>
                <input type="text" class="form-control" id="name" name="name" required>
            </div>
            <div class="form-group">
                <label for="quantity">Quantity:</label>
                <input type="number" class="form-control" id="quantity" name="quantity" required>
            </div>
            <div class="form-group">
                <label for="price">Price:</label>
                <input type="number" step="0.01" class="form-control" id="price" name="price" required>
            </div>
            <div class="form-group">
                <label for="image">Image:</label>
                <input type="file" class="form-control-file" id="img" name="image" accept="image/*" required>
            </div>
            <div class="form-group">
                <label for="description">Description:</label>
                <textarea class="form-control" id="description" name="description" rows="3" required></textarea>
            </div>
            <button type="submit" class="btn btn-primary">Submit</button>
        </form:form>
    </div>
    <script src="<c:url value='/resources/js/jquery-3.6.0.min.js' />"></script>
    <script src="<c:url value='/resources/js/bootstrap.bundle.min.js' />"></script>
</body>
</html>
