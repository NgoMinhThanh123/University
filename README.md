# Hướng dẫn cài đặt hệ thống University Backend
## Bước 1. clone project về
## Bước 2. Sử dụng IDE như IntelliJ, Netbeans hoặc Eclipse
## Bước 3. Sử dụng MySQL để tạo cơ sở dữ liệu.
```
-Mở MySQL, tạo 1 database rỗng có tên university
```
```
-Trên Toolbar, chọn Server -> Data import -> Chọn Import from Self-Contained File -> Chọn file university.sql đã đính kèm trong project
```
```
-Ở Default Schema to be Imported To, chọn database vừa tạo là university.
```
```
-Nhấn Start Import
```
## Bước 4. Mở project UniversitySB bằng IntelliJ
```
chọn src -> main -> java -> com.nmt.universitysb -> chuột phải vào UniversitySbApplicaiton -> Run UniversitySbApplicaiton
```
## Bước 5. Mở trình duyệt và gõ đường dẫn "http://localhost:8082"
## Bước 6. Đăng nhập với thông tin sau để test các chức năng của admin
```
tài khoản: giaovu
```
```
mật khẩu: 123456
```
# Hướng dẫn chạy hệ thống University Front-end
## Bước 1: Mở thư mục university (nằm trong thư mục đã clone về) bằng Visual Studio Code
## Bước 2. Trên toolbar, chọn Terminal -> new Terminal, trong hộp thoại terminal, gõ lệnh "npm install" để cài đặt
## Bước 3. Sau khi cài đặt xong, gõ tiếp lệnh "npm start" để chạy chương trình
