<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Basket - Fishing Website</title>
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
            	<li class="nav-item active">
                    <a class="nav-link" href="basket">Basket</a>
                </li>
            </ul>
		</div>
		<div class="ml-auto">
			<a class="btn btn-primary" href="cabinet">My cabinet</a>
		</div>
	</nav>
	<div class="container mt-4">
		<h1>Basket</h1>
		<form id="orderForm">
            <table class="table">
                <thead>
                    <tr>
                        <th>Name</th>
                        <th>Quantity</th>
                        <th>Price</th>
                        <th>Total Price</th>
                        <th></th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach items="${basketItems}" var="basketItem">
                        <tr>
                        <input type="hidden" name="totalPrice[${basketItem.goods_id}]" value="${basketItem.price}" />
                        <input type="hidden" name="item[${basketItem.goods_id}]" value="${basketItem.goods_id}" />
                        <input type="hidden" name="quantity[${basketItem.goods_id}]"/>


                            <td id="item-${basketItem.goods_id}">${basketItem.name}</td>
                            <td>
                                <input id="input-${basketItem.goods_id}" type="number" min="0" max="${basketItem.quantity}"
                                class="quantity-input" data-goodsid="${basketItem.goods_id}" data-price="${basketItem.price}"
                                value="0">
                            </td>
                            <td id="single-price-${basketItem.goods_id}" data-priceSingle="${basketItem.price}">$${basketItem.price}</td>
                            <td id="total-price-${basketItem.goods_id}" class="total-price"></td>
                            <td><button class="btn btn-danger remove-btn" data-goodsid="${basketItem.goods_id}">Remove</button></td>
                        </tr>
                    </c:forEach>
                </tbody>
                <tfoot>
                    <tr>
                        <input type="hidden" name="summaryPrice" value="$${totalPrice}" />
                        <td colspan="3" class="text-right"><strong>Total:</strong></td>
                        <td id="summary-price"><strong>$${totalPrice}</strong></td>
                    </tr>
                </tfoot>
            </table>


            <div class="form-group mt-3 mb-3">
              <label for="payment-type">Payment Type:</label>
              <select class="form-control" id="payment-type" name="paymentType" required>
                <option value="">Choose payment type</option>
                <option value="1">Post-payment</option>
                <option value="2">Online</option>
              </select>
            </div>
            <div class="form-group mt-3 mb-3">
              <label for="address">Delivery Address:</label>
              <input type="text" class="form-control" id="address" name="address" required>
            </div>
            <button id="submit-btn" type="button" class="btn btn-primary">Submit Order</button>
        </form>
	</div>
	<script src="<c:url value='/resources/js/jquery-3.6.0.min.js'/>"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap/5.2.3/js/bootstrap.min.js" integrity="sha512-1/RvZTcCDEUjY/CypiMz+iqqtaoQfAITmNSJY17Myp4Ms5mdxPS5UV7iOfdZoxcGhzFbOm6sntTKJppjvuhg4g==" crossorigin="anonymous" referrerpolicy="no-referrer"></script>
    <script defer>

    function sendOrder() {
      // Get form data
      const form = document.getElementById('orderForm');
      const formData = new FormData(form);

      // Send data via AJAX
      const xhr = new XMLHttpRequest();
      xhr.open('POST', 'basket/submit');
      xhr.onload = function() {
        if (xhr.status === 200) {
          console.log(xhr.responseText);
        } else {
          console.error(xhr.statusText);
        }
      };
      xhr.onerror = function() {
        console.error(xhr.statusText);
      };
      xhr.send(formData);
    }


    $(document).ready(function() {
        const submitButton = document.querySelector('#orderForm button[type="button"]');
        submitButton.addEventListener('click', sendOrder);

        $(".remove-btn").click(function() {
            var goodsId = $(this).data("goodsid");
            $.ajax({
                url: "<c:url value='/basket/remove'/>",
                method: "POST",
                data: { goods_id: goodsId },
                success: function() {
                    location.reload(); // Reload the page after successful removal
                },
                error: function() {
                   location.reload(); // Reload the page after successful removal
               }
            });
        });

        $(".quantity-input").change(function() {

            var goodsId = $(this).data("goodsid");
            var quantity = quantity = $(this).val();;
            var price = $(this).data("price");
            var newPrice = quantity * price;

            var priceNode = document.querySelector(`#total-price-` + goodsId);
            var text = document.createTextNode("");

            // Get the new value of the quantity input
            const quantityInput = document.querySelector(`#input-` + goodsId);
            const newValue = quantityInput.value;

            // Set the value of the hidden input field
            const hiddenInputQuantity = document.querySelector('input[name="quantity[' + goodsId + ']"]');
            const hiddenInputTotalPrice = document.querySelector('input[name="totalPrice[' + goodsId + ']"]');
            const hiddenInputSummaryPrice = document.querySelector('input[name="summaryPrice"]');

            hiddenInputQuantity.value = newValue;

            while (priceNode.firstChild) {
              priceNode.removeChild(priceNode.firstChild);
            }

            priceNode.appendChild(text);
            var childNode = priceNode.childNodes[0];
            childNode.textContent = newPrice + "$";

            priceNode.dataset.priceTotal = newPrice;
            hiddenInputTotalPrice.value = newPrice;

            //
            // getting total price of all products
            //

            // Get all the elements with class "total-price"
            const totalPrices = document.querySelectorAll('.total-price');

            // Initialize the total variable to 0
            let total = 0;

            // Iterate over the total-price elements and sum up their values
            totalPrices.forEach((priceElement) => {
                const price = parseFloat(priceElement.dataset.priceTotal);
                total += price;
            });

            // Set the text content of the element with id "summary-price" to the total
            const summaryPriceElement = document.getElementById('summary-price');
            hiddenInputSummaryPrice.value = total;
            summaryPriceElement.textContent = '$' + total.toFixed(2);
        });

        $("#submit-btn").click(function() {
            sendOrder();
        });
    });
    </script>
</body>
</html>