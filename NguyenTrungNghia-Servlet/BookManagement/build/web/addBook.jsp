<!DOCTYPE html>
<html>
<head>
    <title>Add Book</title>
    <!-- Bootstrap CSS -->
    <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
    <div class="container">
        <h2>Add Book</h2>
        <form action="addBook" method="post">
            <div class="form-group">
                <label for="BookTitle">Book Title:</label>
                <input type="text" class="form-control" id="BookTitle" name="BookTitle" placeholder="Enter book title">
            </div>
            <div class="form-group">
                <label for="BookAuthor">Book Author:</label>
                <input type="text" class="form-control" id="BookAuthor" name="BookAuthor" placeholder="Enter book author">
            </div>
            <div class="form-group">
                <label for="BookPrice">Book Price:</label>
                <input type="number" class="form-control" id="BookPrice" name="BookPrice" placeholder="Enter book price">
            </div>
            <button type="submit" class="btn btn-primary">Add Book</button>
        </form>
    </div>

    <!-- Bootstrap JS (optional, if needed) -->
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>
