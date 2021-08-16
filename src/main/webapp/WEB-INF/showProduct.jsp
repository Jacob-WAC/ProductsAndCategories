<!-- prettier-ignore -->
<%@ page language="java" contentType="text/html charset=UTF-8" pageEncoding="UTF-8" %>
<!-- prettier-ignore -->
<%@ taglib prefix = "c" uri="http://java.sun.com/jsp/jstl/core" %>
<!-- prettier-ignore -->
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!-- prettier-ignore -->
<!DOCTYPE html>
<html>
    <head>
        <meta charset="ISO-8859-1" />
        <title>Insert title here</title>
        <link
            rel="stylesheet"
            href="/webjars/bootstrap/css/bootstrap.min.css"
        />
        <script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
    </head>
    <body>
        <div class="container">
            <h1>${product.name}</h1>

            <ul>
                <c:forEach items="${product.categories}" var="category">
                    <li>${category.name}</li></c:forEach
                >
            </ul>
        </div>
        <div>
            <form action="/addCategory/${product.id}" method="post">
                <select name="categoryId">
                    <c:forEach items="${categories}" var="category">
                        <option value="${category.id}">${category.name}</option>
                    </c:forEach>
                    <input type="submit" value="Add Product to Category!" />
                </select>
            </form>
        </div>
    </body>
</html>
