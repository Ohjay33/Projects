<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

  <!-- c:out ; c:forEach ; c:if -->
  <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <!-- Formatting (like dates) -->
    <%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
      <!-- form:form -->
      <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
        <!-- for rendering errors on PUT routes -->
        <%@ page isErrorPage="true" %>
          <!DOCTYPE html>
          <html>

          <head>
            <meta charset="UTF-8">
            <title>Title Here</title>
            <!-- Bootstrap -->
            <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
              integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
              crossorigin="anonymous">
          </head>


          <body>
            <div class="container"> <!-- Beginning of Container -->
              <h1>Hello. Here is all the Clothes in the Closet!</h1>

              <table class="table table-sm table-dark">
                <thead>
                  <tr>
                    <th scope="col">#ID</th>
                    <th scope="col">Name</th>
                    <th scope="col">Clothing Type</th>
                    <th scope="col">price</th>
                    <th scope="col">Description</th>
                    <th>Actions</th>
                  </tr>
                </thead>
                <tbody>

                  <c:forEach items='${ allClosetItems }' var='closetObj'>

                    <tr>
                      <th scope="row">${closetObj.id}</th>
                      <td> <a href="/closetitems/${closetObj.id}">${closetObj.name}</a></td>
                      <td>${closetObj.clothingType}</td>
                      <td>${closetObj.price}</td>
                      <td>${closetObj.description}</td>
                      <td>
                        <a href="/closetitems/edit/${closetObj.id}">Edit:</a> ||
                        <a href="/closeitems/delete/${closetObj.id}">Delete:</a>
                      </td>
                    </tr>
                  </c:forEach>



                </tbody>
              </table>
              <hr>

              <form:form action="/closetitem/create" method="post" modelAttribute="closetitem">
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


            </div> <!-- End of Container -->
          </body>

          </html>