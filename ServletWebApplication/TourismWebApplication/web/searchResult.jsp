<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>Kết quả tìm kiếm</title>
        <!-- Thêm Bootstrap CSS -->
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    </head>
    <body>
        <div class="container">
            <h1>Kết quả tìm kiếm</h1>

            <%-- Kiểm tra nếu không có kết quả tìm kiếm --%>
            <c:if test="${empty diaDiemList}">
                <p>Không tìm thấy kết quả phù hợp.</p>
            </c:if>

            <c:if test="${not empty diaDiemList}">
                <table class="table table-striped">
                    <thead>
                        <tr>
                            <th scope="col">Tên Địa Điểm</th>
                            <th scope="col">Dịch Vụ</th>
                            <th scope="col">Giá</th>
                            <th scope="col">Phường</th>
                            <th scope="col">Quận</th>
                            <th scope="col">Thành Phố</th>
                        </tr>
                    </thead>
                    <tbody>
                        <%-- Lặp qua danh sách địa điểm và hiển thị thông tin --%>
                        <c:forEach items="${diaDiemList}" var="diaDiem">
                            <tr>
                                <td>${diaDiem.tenDiaDiem}</td>
                                <td>${diaDiem.dichVu.tenDichVu}</td>
                                <td>${diaDiem.gia.mucGia}</td>
                                <td>${diaDiem.phuong.tenPhuong}</td>
                                <td>${diaDiem.quan.tenQuan}</td>
                                <td>${diaDiem.thanhPho.tenThanhPho}</td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
            </c:if>
            <div class="d-flex justify-content-end">
                <button type="button" class="btn btn-primary"><a href="dulichvietnam" class="text-white">Trở về</a></button>
            </div>
        </div>

        <!-- Thêm Bootstrap JavaScript (tùy chọn) -->
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
    </body>
</html>
