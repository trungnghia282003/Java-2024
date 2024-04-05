<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <title>Admin Page</title>
        <link rel="stylesheet" type="text/css" href="style.css"/>
        <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Roboto|Varela+Round|Open+Sans">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">
        <link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">

    </head>
    <body>
        <div class="container">
            <div class="table-responsive">
                <div class="table table-striped">
                    <div class="table-title">
                        <div class="row mt-5">
                            <div class="col-sm-8"><h2>User Details</h2></div>
                            <div class="col-sm-4">
                                <button type="button" class="btn btn-info add-new" data-toggle="modal" data-target="#addModal">
                                    <i class="fa fa-plus"></i> Add New
                                </button>
                            </div>
                        </div>
                    </div>
                    <table id="userTable" class="table table-bordered">
                        <thead>
                            <tr>
                                <th>Username</th>
                                <th>Password</th>
                                <th>RoleId</th>
                                <th>Actions</th>
                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach var="user" items="${userList}">
                                <tr>
                                    <td>${user.username}</td>
                                    <td>${user.password}</td>
                                    <td>${user.roleId}</td>
                                    <td>
                                        <button type="button" class="btn btn-warning edit" title="Edit" data-toggle="modal" data-target="#editModal" onclick="editUser(${user.id}, '${user.username}', '${user.password}')"><i class="material-icons">&#xE254;</i></button>
                                        <button type="button" class="btn btn-danger delete" title="Delete" data-toggle="modal" data-target="#confirmDeleteModal" onclick="confirmDelete(${user.id})"><i class="material-icons">&#xE872;</i></button>
                                    </td>
                                </tr>
                            </c:forEach>
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
        
        <!-- Modal cho việc thêm mới -->
        <div class="modal fade" id="addModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
            <div class="modal-dialog" role="document">
                <div class="modal-content">
                    <div class="modal-header">
                        <h5 class="modal-title" id="exampleModalLabel">Add New User</h5>
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                            <span aria-hidden="true">&times;</span>
                        </button>
                    </div>
                    <div class="modal-body">
                        <form id="addForm" method="post" action="admin">
                            <!-- Hidden input field for action parameter -->
                            <input type="hidden" name="action" value="/insert">
                            <div class="form-group">
                                <label for="username">Username</label>
                                <input type="text" class="form-control" id="username" name="username" placeholder="Enter a new username">
                            </div>
                            <div class="form-group">
                                <label for="password">Password</label>
                                <input type="password" class="form-control" id="password" name="password" placeholder="Enter a new password">
                            </div>
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
                        <button type="submit" class="btn btn-primary">Add User</button>
                    </div>
                    </form>
                </div>
            </div>      
        </div>

        <!-- Modal cho việc chỉnh sửa -->
        <div class="modal fade" id="editModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
            <div class="modal-dialog" role="document">
                <div class="modal-content">
                    <div class="modal-header">
                        <h5 class="modal-title" id="exampleModalLabel">Edit User</h5>
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                            <span aria-hidden="true">&times;</span>
                        </button>
                    </div>
                    <div class="modal-body">
                        <form id="editForm" method="post" action="admin">
                            <!-- Hidden input field for action parameter -->
                            <input type="hidden" name="action" value="/update">
                            <input type="hidden" id="editUserId" name="editUserId">
                            <div class="form-group">
                                <label for="editUsername">Username</label>
                                <input type="text" class="form-control" id="editUsername" name="editUsername">
                            </div>
                            <div class="form-group">
                                <label for="editPassword">Password</label>
                                <input type="text" class="form-control" id="editPassword" name="editPassword">
                            </div>
                            <div class="modal-footer">
                                <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
                                <button type="submit" class="btn btn-primary" onclick="showModal()">Update User</button>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </div>

        <!-- Modal confirm delete -->
        <div class="modal fade" id="confirmDeleteModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
            <div class="modal-dialog" role="document">
                <div class="modal-content">
                    <div class="modal-header">
                        <h5 class="modal-title" id="exampleModalLabel">Confirm Delete</h5>
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                            <span aria-hidden="true">&times;</span>
                        </button>
                    </div>
                    <div class="modal-body">
                        Are you sure you want to delete this user?
                    </div>
                    <div class="modal-footer">
                        <form id="deleteForm" method="post" action="admin">
                            <input type="hidden" id="deleteUserId" name="deleteUserId">
                            <input type="hidden" name="action" value="/delete">
                            <button type="button" class="btn btn-secondary" data-dismiss="modal">Cancel</button>
                            <button type="submit" class="btn btn-danger">Delete</button>
                        </form>
                    </div>
                </div>
            </div>
        </div>

        <script>
            function editUser(userId, username, password) {
                // Đặt thông tin người dùng vào form trong modal
                document.getElementById("editUserId").value = userId;
                document.getElementById("editUsername").value = username;
                document.getElementById("editPassword").value = password;
            }

            function showModal() {
                // Hiển thị modal
                $('#editModal').modal('show');
            }

            function confirmDelete(userId) {
                // Set the value of a hidden input field to the userId
                document.getElementById("deleteUserId").value = userId;
                // Show the confirm delete modal
                $('#confirmDeleteModal').modal('show');
            }

        </script>

        <script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
        <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"></script>
    </body>
</html>