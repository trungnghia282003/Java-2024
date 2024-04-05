<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <title>Players List</title>
        <!-- Bootstrap CSS -->
        <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
    </head>
    <body>
        <div class="container">
            <h1><b>Players List</b></h1>
            <h3><a class="btn btn-success" href="addPlayer.jsp">Add a new player</a></h3>
            <table class="table table-striped">
                <thead>
                    <tr>
                        <th>ID</th>
                        <th>Name</th>
                        <th>Actions</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach items="${players}" var="player">
                        <tr>
                            <td>${player.id}</td>
                            <td>${player.playerName}</td>
                            <td>
                                <a href="selectById?id=${player.id}" class="btn btn-primary">Edit</a>
                                <form action="deletePlayer" method="post" style="display: inline;">
                                    <input type="hidden" name="id" value="${player.id}">
                                    <button type="submit" class="btn btn-danger" onclick="return confirm('Are you sure you want to delete this player?')">Delete</button>
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
