# Bài tập Tìm kiếm Du Lịch Việt Nam

Tạo một form có các trường
Địa điểm: Nhập keyword
Dịch vụ: Nhập keyword: kiểu string
Giá: Nhập keyword
Tỉnh/Thành Phố: Dropdowns
Quận/Huyện: Dropdowns
Xã/Phường: Dropdowns

SEARCHING

Yêu cầu:

Đầu vào: - Client nhập các truờng trên JSP -> request.

Đầu ra:  - Server nhận request từ client tại servlet.
	 - Server gửi câu query xuống database .
	 - Database kiêm tra câu query rồi  trả lại kết quả.
	 - Server nhận kết quả từ database và trả lại respose lên client.
	 - Client hiển thị kết quả sẽ được hiển ra table.

- Địa điểm nhập ''keyword'' là các địa điểm du lịch của Đà Nẵng
- Dịch vụ nhập ''keyword'' là các hoạt động của địa điểm du lịch đó ví dụ vui chơi, xiếc khỉ,..
- Giá nhập ''keyword'' là nhập vào giá bất kì từ thấp nhất đến cao nhất.
- Nếu giá nhập vào nằm trong khoảng từ giá thấp nhất đến giá cao nhất thì in ra danh sách kết quả. ....
- Địa điểm quan hệ 1-n với - Tỉnh quan hệ 1-n với Quận quan hệ 1-n với Thành phố.

Vậy khi chọn dropdown nếu chưa chọn thành phố thì không xuất hiện dropdown của quận -> chưa xuất hiện dropdown của xã/ phường.

DATABASE
Table Diadiem (Id + Tendiadiem) + IdDichVu + IdGia + IdThanhPho
Table Dichvu  (Id + Tendichvu)	
Table Gia     (Id + Mucgia)
Table Thanhpho(Id + TenThanhPho) + IdQuan 
Table Quan    (Id+ TenQuan) + IdHuyen
Table Phuong  (Id + TenPhuong) + IdPhuong

-----------------------------------------------------------------------------

Bước 1: Tạo động Frontend
Bước 2: Tạo Database
Bước 3: Tạo Controller


    

	
	
