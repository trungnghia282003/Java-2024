
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Du lịch Việt Nam</title>
        <!-- Bootstrap CSS -->
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    </head>
    <body>
        <div class="container">
            <h1 class="text-center">Du lịch Việt Nam</h1>
            <div class="row">

                <div class="col">
                    <form>
                        <div class="form-group">
                            <label for="DiaDiem">Địa điểm</label>
                            <input type="text" class="form-control" id="diadiem" placeholder="Nhập địa điểm">
                        </div>
                        <div class="form-group">
                            <label for="DichVu">Dịch vụ</label>
                            <select class="form-control" id="dichvu">
                                <option>Hãy chọn dịch vụ</option>
                                <c:forEach items="${dichVuList}" var="dichVu">
                                    <option value="${dichVu.id}">${dichVu.tenDichVu}</option>
                                </c:forEach>
                            </select>
                        </div>
                        <div class="form-group">
                            <label for="gia">Giá cả</label>
                            <select class="form-control" id="gia">
                                <option>Hãy chọn mức giá</option>
                                <option>1</option>  
                            </select>
                        </div>
                    </form>
                </div>

                <div class="col">
                    <form>
                        <div class="form-group">
                            <label for="thanhpho">Thành phố</label>
                            <select class="form-control" id="thanhpho">
                                <option>Hãy chọn thành phố</option>
                                <option>2</option>
                            </select>
                        </div>
                        <div class="form-group">
                            <label for="quan">Quận</label>
                            <select class="form-control" id="quan">
                                <option>Hãy chọn quận</option>
                                <option>2</option>
                            </select>
                        </div>
                        <div class="form-group">
                            <label for="phuong">Phường</label>
                            <select class="form-control" id="phuong">
                                <option>Hãy chọn phường</option>
                                <option>2</option>
                            </select>
                        </div>
                    </form>
                    <div class="d-flex justify-content-end">
                        <button type="submit" class="btn btn-primary">Tìm kiếm</button>
                    </div>
                </div>
            </div>

            <div class="mt-5 row">
                <table class="table">
                    <thead>
                        <tr>
                            <th scope="col">Tên địa điểm</th>
                            <th scope="col">Thành phố</th>
                            <th scope="col">Quận</th>
                            <th scope="col">Phường</th>
                            <th scope="col">Dịch vụ</th>
                            <th scope="col">Giá</th>
                        </tr>
                    </thead>
                    <tbody>
                        <tr>
                            <th scope="row">1</th>
                            <td>Mark</td>
                            <td>Otto</td>
                            <td>@mdo</td>
                            <td>Otto</td>
                            <td>@mdo</td>
                        </tr>
                    </tbody>
                </table>
            </div>
        </div>        <!-- Optional JavaScript -->
        <!-- jQuery first, then Popper.js, then Bootstrap JS -->
        <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/popper.js@1.14.7/dist/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
    </body>
</html>
