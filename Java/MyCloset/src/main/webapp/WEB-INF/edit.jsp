<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
    <!-- form:form -->
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
        <!DOCTYPE html>
        <html>

        <head>
            <meta charset="ISO-8859-1">
            <title>Insert title here</title>
            <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css"
                integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65"
                crossorigin="anonymous">
        </head>

        <body>
            <div class="container">
                <h1>Edit this Article of clothing</h1>

                <form:form action="/closetitem/update/${itemToEdit.id}" method="post" modelAttribute="itemToEdit">
                    <input type="hidden" name="_method" value="put">
                    <!--The model attribute represents which model to bind to-->
                    <!-- The path="" must match the member variables from the Table Model class -->
                    <p>
                        <form:label path="name">Name: </form:label>
                        <form:errors path="name" class="text-danger" />
                        <form:input type="text" path="name" class="form-control" />
                    </p>
                    <p>
                        <form:label path="clothingType">Type of Clothing:</form:label>
                        <form:errors path="clothingType" class="text-danger" />
                        <form:input type="text" path="clothingType" class="form-control" />
                    </p>
                    <p>
                        <form:label path="price">Price: </form:label>
                        <form:errors path="price" class="text-danger" />
                        <form:input type="number" path="price" step="0.01" class="form-control" />
                    </p>
                    <p>
                        <form:label path="description">Description: </form:label>
                        <form:errors path="description" class="text-danger" />
                        <form:textarea path="description" class="form-control" />
                    </p>
                    <input type="submit" value="Submit" />
                </form:form>
            </div>

        </body>

        </html>