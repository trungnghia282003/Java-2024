<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Register page</title>
        <!-- Bootstrap CSS -->
        <link rel="stylesheet" type="text/css" href="style.css" />
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    </head>
    <body>
        <div class="container">
            <div class="col-md-4 border border-1 rounded">
                <h1 class="text-center">Register Form</h1>
                <form id="registerForm" action="register" method="post">
                    <!-- Email input -->
                    <div class="form-outline mb-4">
                        <label class="form-label">Username</label>
                        <input type="text" id="username" name="username" class="form-control" placeholder="Enter username" />
                    </div>

                    <!-- Password input -->
                    <div class="form-outline mb-4">
                        <label class="form-label">Password</label>
                        <input type="password" id="password" name="password" class="form-control" placeholder="Enter password" />
                    </div>

                    <!-- Submit button -->
                    <div class="d-flex justify-content-end mb-4"> 
                        <button type="submit" class="btn btn-primary">Register</button>
                    </div>
                </form>
            </div>
        </div>
        <script>
            document.addEventListener("DOMContentLoaded", function () {
                var form = document.querySelector("#registerForm");

                form.addEventListener("submit", function (event) {
                    var usernameInput = document.querySelector("#username");
                    var passwordInput = document.querySelector("#password");

                    // Kiểm tra nếu trường username hoặc trường password không được điền
                    if (!usernameInput.value.trim() || !passwordInput.value.trim()) {
                        event.preventDefault(); // Ngăn chặn form được submit
                        alert("Please enter both username and password."); // Hiển thị thông báo
                    }
                });
            });
        </script>

        <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/popper.js@1.14.7/dist/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
    </body>
</html>
