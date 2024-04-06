<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
            <form id="searchForm" method="post" action="search">
                <div class="row">
                    <div class="col">
                        <div class="form-group">
                            <label for="DiaDiem">Địa điểm</label>
                            <input type="text" class="form-control" id="diadiem" name="diadiem"
                                   placeholder="Nhập địa điểm">
                        </div>
                        <div class="form-group">
                            <label for="DichVu">Dịch vụ</label>
                            <select class="form-control" id="dichVuDropdown" name="dichVuDropdown">
                                <option value="">Hãy chọn dịch vụ</option>
                                <c:forEach items="${dichVuList}" var="dichVu">
                                    <option value="${dichVu.id}">${dichVu.tenDichVu}</option>
                                </c:forEach>
                            </select>
                        </div>
                        <div class="form-group">
                            <label for="gia">Giá cả</label>
                            <select class="form-control" id="giaDropdown" name="giaDropdown">
                                <option value="">Hãy chọn mức giá</option>
                                <c:forEach items="${giaList}" var="gia">
                                    <option value="${gia.id}">${gia.mucGia}</option>
                                </c:forEach>
                            </select>
                        </div>
                    </div>
                    <div class="col">
                        <div class="form-group">
                            <label for="thanhpho">Thành phố</label>
                            <select class="form-control" id="thanhPhoDropdown" name="thanhPhoDropdown" onchange="onCityChange()">
                                <option value="" selected>Hãy chọn thành phố</option>
                                <c:forEach items="${thanhPhoList}" var="thanhpho">
                                    <option value="${thanhpho.id}">${thanhpho.tenThanhPho}</option>
                                </c:forEach>
                            </select>
                        </div>
                        <div class="form-group">
                            <label for="quan">Quận</label>
                            <select class="form-control" id="quanDropdown" name="quanDropdown" onchange="onDistrictChange()">
                                <option value="" selected>Hãy chọn quận</option>
                                <c:forEach items="${quanList}" var="quan">
                                    <option value="${quan.id}">${quan.tenQuan}</option>
                                </c:forEach>
                            </select>
                        </div>
                        <div class="form-group">
                            <label for="phuong">Phường</label>
                            <select class="form-control" id="phuongDropdown" name="phuongDropdown">
                                <option value="" selected>Hãy chọn phường</option>
                                <c:forEach items="${phuongList}" var="phuong">
                                    <option value="${phuong.id}">${phuong.tenPhuong}</option>
                                </c:forEach>
                            </select>
                        </div>
                        <div class="d-flex justify-content-end">
                            <button type="submit" class="btn btn-primary" onclick="submitForm()">Tìm kiếm</button>
                        </div>
                    </div>
                </div>
            </form>
            <div class="mt-5 row">
                <table id="diaDiemTable" class="table table-striped">
                    <thead>
                        <tr>
                            <th scope="col">Tên địa điểm</th>
                            <th scope="col">Phường</th>
                            <th scope="col">Quận</th>
                            <th scope="col">Thành phố</th>                
                            <th scope="col">Dịch vụ</th>
                            <th scope="col">Giá</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach var="diaDiem" items="${diaDiemList}">
                            <tr>
                                <td>${diaDiem.tenDiaDiem}</td>
                                <td>${diaDiem.phuong.tenPhuong}</td>
                                <td>${diaDiem.phuong.quan.tenQuan}</td>
                                <td>${diaDiem.phuong.quan.thanhPho.tenThanhPho}</td>
                                <td>${diaDiem.dichVu.tenDichVu}</td>
                                <td>${diaDiem.gia.mucGia}</td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
            </div>
        </div>   

        <script>
            // Hàm được gọi khi Thành phố được chọn
            function onCityChange() {
                var cityId = document.getElementById("thanhPhoDropdown").value;
                console.log(cityId);
                var xhttp = new XMLHttpRequest();
                xhttp.onreadystatechange = function () {
                    if (this.readyState == 4 && this.status == 200) {
                        // Xử lý phản hồi từ máy chủ và cập nhật dropdown Quận
                        document.getElementById("quanDropdown").innerHTML = this.responseText;
                        // Kích hoạt dropdown Quận sau khi đã cập nhật dữ liệu
                        document.getElementById("quanDropdown").disabled = false;
                    }
                };
                xhttp.open("GET", "http://localhost:8080/ServletWebApplication/dulichvietnam?action=getDistrictsByCityId&cityId=" + cityId, true);
                xhttp.send();
            }

            // Hàm được gọi khi Quận được chọn
            function onDistrictChange() {
                var districtId = document.getElementById("quanDropdown").value;
                console.log(districtId);
                var xhttp = new XMLHttpRequest();
                xhttp.onreadystatechange = function () {
                    if (this.readyState == 4 && this.status == 200) {
                        // Xử lý phản hồi từ máy chủ và cập nhật dropdown Phường
                        document.getElementById("phuongDropdown").innerHTML = this.responseText;
                        // Kích hoạt dropdown Phường sau khi đã cập nhật dữ liệu
                        document.getElementById("phuongDropdown").disabled = false;
                    }
                };
                xhttp.open("GET", "http://localhost:8080/ServletWebApplication/dulichvietnam?action=getWardsByDistrictId&districtId=" + districtId, true);
                xhttp.send();
            }

            // Sự kiện onChange cho trường nhập input "Địa điểm"
            document.getElementById("diadiem").addEventListener("input", function () {
                // Lấy giá trị của input "Địa điểm"
                var diadiemValue = this.value;
                // Sử dụng giá trị diadiemValue ở đây nếu cần thiết
                console.log(diadiemValue);
            });

            // Sự kiện onChange cho dropdown "Dịch vụ"
            document.getElementById("dichVuDropdown").addEventListener("change", function () {
                // Lấy ID của dịch vụ đã chọn
                var dichVuId = this.value;
                console.log(dichVuId);
                // Gửi yêu cầu AJAX để xử lý thay đổi dịch vụ
                var xhttp = new XMLHttpRequest();
                xhttp.onreadystatechange = function () {
                    if (this.readyState == 4 && this.status == 200) {
                        // Xử lý phản hồi từ máy chủ nếu cần thiết
                    }
                };
                xhttp.open("GET", "http://localhost:8080/ServletWebApplication/dulichvietnam?action=handleServiceChange&dichVuId=" + dichVuId, true);
                xhttp.send();
            });

            // Sự kiện onChange cho dropdown "Giá cả"
            document.getElementById("giaDropdown").addEventListener("change", function () {
                // Lấy ID của mức giá đã chọn
                var giaId = this.value;
                console.log(giaId);
                // Gửi yêu cầu AJAX để xử lý thay đổi giá cả
                var xhttp = new XMLHttpRequest();
                xhttp.onreadystatechange = function () {
                    if (this.readyState == 4 && this.status == 200) {
                        // Xử lý phản hồi từ máy chủ nếu cần thiết
                    }
                };
                xhttp.open("GET", "http://localhost:8080/ServletWebApplication/dulichvietnam?action=handlePriceChange&giaId=" + giaId, true);
                xhttp.send();
            });

            // Sự kiện onChange cho dropdown "Phường"
            document.getElementById("phuongDropdown").addEventListener("change", function () {
                // Lấy ID của phường đã chọn
                var phuongId = this.value;
                console.log(phuongId);
                // Gửi yêu cầu AJAX để xử lý thay đổi phường
                var xhttp = new XMLHttpRequest();
                xhttp.onreadystatechange = function () {
                    if (this.readyState == 4 && this.status == 200) {
                        // Xử lý phản hồi từ máy chủ nếu cần thiết
                    }
                };
                xhttp.open("GET", "http://localhost:8080/ServletWebApplication/dulichvietnam?action=handleWardChange&phuongId=" + phuongId, true);
                xhttp.send();
            });
        </script>
        <!-- Optional JavaScript -->
        <!-- jQuery first, then Popper.js, then Bootstrap JS -->
        <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/popper.js@1.14.7/dist/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
    </body>
</html>
