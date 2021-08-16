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
        <div><h1>New Product</h1></div>
        <div class="container">
            <form:form
                action="/createCategory"
                method="post"
                modelAttribute="category"
            >
                <div class="form-group">
                    <form:label path="name">name</form:label>
                    <form:errors path="name" class="text-danger" />
                    <form:input path="name" class="form-control" />
                </div>
                <input type="submit" value="Submit" />
            </form:form>
        </div>
    </body>
</html>
