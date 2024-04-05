<!DOCTYPE html>
<html>
<head>
    <title>Add Player</title>
    <!-- Bootstrap CSS -->
    <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
    <div class="container">
        <h2>Add Player</h2>
        <form action="addPlayer" method="post">
            <div class="form-group">
                <label for="PlayerName">Player Name:</label>
                <input type="text" class="form-control" id="PlayerName" name="PlayerName" placeholder="Enter a new player">
            </div>
            <button type="submit" class="btn btn-primary">Add Player</button>
        </form>
    </div>

    <!-- Bootstrap JS (optional, if needed) -->
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>
