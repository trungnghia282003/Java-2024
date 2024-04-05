<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>Edit Player</title>
    <!-- Bootstrap CSS -->
    <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
    <div class="container">
        <h2>Edit Player</h2>
        <form action="updatePlayer" method="post">
            <input type="hidden" name="id" value="${player.id}">
            <div class="form-group">
                <label for="playerName">Player Name:</label>
                <input type="text" class="form-control" id="playerName" name="playerName" value="${player.playerName}">
            </div>
            <button type="submit" class="btn btn-primary">Update Player</button>
        </form>
    </div>

    <!-- Bootstrap JS (optional, if needed) -->
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>
