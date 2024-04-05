<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <title>Books List</title>
        <!-- Bootstrap CSS -->
        <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
    </head>
    <body>
        <div class="container">
            <h1><b>Books Management</b></h1>
            <div class="d-flex justify-content-start">
                <h2><a class="btn btn-success" href="addBook.jsp">Add New Book</a></h2>
            <h2><a class="btn btn-danger ml-5" href="displayBook">List All Books</a></h2>
            </div>
            <h3 class="text-center"><b>List of Books</b></h3>
            <table class="table table-striped">
                <thead>
                    <tr>
                        <th>ID</th>
                        <th>Title</th>
                        <th>Author</th>
                        <th>Price</th>
                        <th>Actions</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach items="${books}" var="book">
                        <tr>
                            <td>${book.bookId}</td>
                            <td>${book.bookTitle}</td>
                            <td>${book.bookAuthor}</td>
                            <td>${book.bookPrice}</td>
                            <td>
                                <a href="selectById?id=${book.bookId}" class="btn btn-primary">Edit</a>
                                <form action="deleteBook" method="post" style="display: inline;">
                                    <input type="hidden" name="id" value="${book.bookId}">
                                    <button type="submit" class="btn btn-danger" onclick="return confirm('Are you sure you want to delete this book?')">Delete</button>
                                </form>
                            </td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </div>

        <!-- Bootstrap JS (optional, if needed) -->
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
    </body>
</html>
