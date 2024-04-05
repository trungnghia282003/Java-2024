<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>Edit Book</title>
    <!-- Bootstrap CSS -->
    <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
    <div class="container">
        <h2>Edit Book</h2>
        <form action="updateBook" method="post">
            <input type="hidden" name="id" value="${book.bookId}">
            <div class="form-group">
                <label for="BookTitle">Book Title:</label>
                <input type="text" class="form-control" id="BookTitle" name="BookTitle" value="${book.bookTitle}">
            </div>
            <div class="form-group">
                <label for="BookAuthor">Book Author:</label>
                <input type="text" class="form-control" id="BookAuthor" name="BookAuthor" value="${book.bookAuthor}">
            </div>
            <div class="form-group">
                <label for="BookPrice">Book Price:</label>
                <input type="number" class="form-control" id="BookPrice" name="BookPrice" value="${book.bookPrice}">
            </div>
            <button type="submit" class="btn btn-primary">Update Book</button>
        </form>
    </div>

    <!-- Bootstrap JS (optional, if needed) -->
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>
