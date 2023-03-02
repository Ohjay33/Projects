<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
        <!DOCTYPE html>
        <html>

        <head>
            <meta charset="ISO-8859-1">
            <title>Game Form </title>
            <link rel="stylesheet" href="/css/style.css">
            <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css"
                integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65"
                crossorigin="anonymous">
        </head>

        <body>
            <div class="container">

                <h1>Find your game here!</h1>
                <form action="/gamespot" method="post">
                    <div class="form-group">
                        <label for="">Game Name:</label>
                        <input type="text" name="game_name" id="" class="form-control">
                    </div>

                    <div class="form-group">
                        <label for="">Price:</label>
                        <input type="number" name="price" id="" class="form-control">
                    </div>

                    <div class="form-group">
                        <label for="">Console Type:</label>
                        <input type="text" name="console_type" id="" class="form-control">
                    </div>

                    <div class="form-group">
                        <label for="">Describe Game:</label>
                        <textarea name="game_describe" id="" cols="30" rows="5" class="form-control"> </textarea>
                        <!-- <input type="text" name="" id="" class="form-control"> -->
                    </div>
                    <input type="submit" value="Submit">
                </form>

            </div>

        </body>

        </html>