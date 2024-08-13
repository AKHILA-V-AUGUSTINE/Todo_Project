<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="ISO-8859-1">
    <title>View ToDo Items</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/toastr.js/latest/toastr.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/toastr.js/latest/toastr.min.js"></script>

    <style>
        a {
            color: white;
        }

        a:hover {
            color: white;
            text-decoration: none;
        }
    </style>
</head>
<body>

<div class="container">
    <h1 class="p-3">ToDo Item List</h1>

    <form:form>
        <table class="table table-bordered">
            <thead>
                <tr>
                    <th>Id</th>
                    <th>Title</th>
                    <th>Description</th>
                    <th>Created Date</th>
                    <th>Updated Date</th>
                    <th>Status</th>
                    <th>Mark Completed</th>
                    <th>Edit</th>
                    <th>Delete</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="todo" items="${list}">
                    <tr>
                        <td>${todo.id}</td>
                        <td>${todo.title}</td>
                        <td>${todo.description}</td>
                        <td>${todo.createdDate}</td>
                        <td>${todo.updateDate}</td>
                        <td>${todo.status}</td>
                        <td>
                            <button type="button" class="btn btn-success"
                                    onclick="location.href='/updateToDoStatus/${todo.id}'">Mark Complete</button>
                        </td>
                        <td>
                            <button type="button" class="btn btn-primary"
                                    onclick="location.href='/editToDoItem/${todo.id}'">Edit</button>
                        </td>
                        <td>
                            <button type="button" class="btn btn-danger"
                                    onclick="location.href='/deleteToDoItem/${todo.id}'">Delete</button>
                        </td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </form:form>

    <button type="button" class="btn btn-primary btn-block" onclick="location.href='/addToDoItem'">Add New ToDo Item</button>
</div>

<script type="text/javascript">
    window.onload = function() {
        var msg = "${message}"; // This should be set server-side

        if (msg === "Save Success") {
            toastr.success("Item added successfully!!");
        } else if (msg === "Delete Success") {
            toastr.success("Item deleted successfully!!");
        } else if (msg === "Delete Failure") {
            toastr.error("Some error occurred, couldn't delete item");
        } else if (msg === "Edit Success") {
            toastr.success("Item updated successfully!!");
        }

        toastr.options = {
            "closeButton": true,
            "debug": false,
            "newestOnTop": false,
            "progressBar": true,
            "positionClass": "toast-top-right",
            "preventDuplicates": false,
            "showDuration": "300",
            "hideDuration": "1000",
            "timeOut": "5000",
            "extendedTimeOut": "1000",
            "showEasing": "swing",
            "hideEasing": "linear",
            "showMethod": "fadeIn",
            "hideMethod": "fadeOut"
        };
    };
</script>

</body>
</html>
