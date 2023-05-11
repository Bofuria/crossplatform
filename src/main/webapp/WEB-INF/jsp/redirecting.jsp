<!DOCTYPE html>
<html xmlns:th="http://www.thymeleaf.org">
<head>
  <meta charset="UTF-8">
  <title>Redirecting...</title>
</head>
<body>
  <p>Order submitted successfully, you are being redirected to index automatically in 5 sec...</p>
  <script th:inline="javascript">
    var delay = [[${delay}]];
    setTimeout(function() {
      window.location.href = "/index";
    }, delay);
  </script>
</body>
</html>
