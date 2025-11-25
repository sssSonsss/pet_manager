# Hướng dẫn Test các chức năng Đăng nhập và Tạo tài khoản

## Tổng quan
Ứng dụng đã có đầy đủ logic cho:
- ✅ Đăng nhập ADMIN/STAFF (username + password)
- ✅ Đăng nhập USER (tên + email)
- ✅ Tạo tài khoản STAFF (chỉ ADMIN)
- ✅ Tạo tài khoản USER (chỉ ADMIN)

## Cách chạy ứng dụng

```bash
cd "/Users/sonnguyen/Downloads/09. Lap trinh Giao dien/pet_manager"
mvn clean compile exec:java -Dexec.mainClass="petfarm.view.PetFarmApp"
```

Hoặc sử dụng script:
- Windows: `run.bat`
- Linux/Mac: `run.sh`

## Test Case 1: Đăng nhập bằng ADMIN

### Bước 1: Khởi động ứng dụng
- Chạy ứng dụng, màn hình đăng nhập sẽ hiển thị

### Bước 2: Đăng nhập
- **Tab**: Chọn tab "ADMIN/STAFF" (mặc định)
- **Username**: `admin`
- **Password**: `admin123`
- Click "Đăng nhập"

### Kết quả mong đợi:
- ✅ Hiển thị thông báo "Đăng nhập thành công!"
- ✅ Màn hình chính hiển thị với title: "Pet Farm Management - Quản trị viên (admin)"
- ✅ Menu bar hiển thị "👤 admin (ADMIN)" màu xanh lá
- ✅ Menu "Tài khoản" có option "Đăng ký tài khoản"

---

## Test Case 2: Tạo tài khoản STAFF

### Điều kiện tiên quyết:
- Phải đăng nhập bằng ADMIN (xem Test Case 1)

### Bước 1: Mở dialog đăng ký
- Click menu "Tài khoản" → "Đăng ký tài khoản"
- Dialog "Đăng ký tài khoản mới" hiển thị

### Bước 2: Tạo STAFF
- **Tab**: Chọn tab "Tạo STAFF" (mặc định)
- **Tên đăng nhập**: `staff1`
- **Mật khẩu**: `staff123`
- **Xác nhận mật khẩu**: `staff123`
- Click "Tạo tài khoản"

### Kết quả mong đợi:
- ✅ Hiển thị thông báo "Tạo tài khoản STAFF thành công!"
- ✅ Dialog đóng lại
- ✅ Có thể đăng nhập bằng `staff1` / `staff123`

---

## Test Case 3: Đăng nhập bằng USER

### Bước 1: Tạo USER (nếu chưa có)
- Đăng nhập bằng ADMIN
- Tạo USER với tên "Nguyễn Văn A" và email "nguyenvana@example.com"

### Bước 2: Đăng xuất và đăng nhập lại
- Click menu "Tài khoản" → "Đăng xuất"
- **Tab**: Chọn tab "USER"
- **Tên**: `Nguyễn Văn A`
- **Email**: `nguyenvana@example.com`
- Click "Đăng nhập"

### Kết quả mong đợi:
- ✅ Hiển thị thông báo "Đăng nhập thành công!"
- ✅ Màn hình chính hiển thị với title: "Pet Farm Management - Người dùng (Nguyễn Văn A)"
- ✅ Menu bar hiển thị "👤 Nguyễn Văn A (USER)" màu đỏ
- ✅ Tất cả các nút "Thêm", "Cập nhật", "Xóa" đều bị vô hiệu hóa

---

## Tài khoản mặc định

Khi khởi động lần đầu, database sẽ tự động tạo:
- **ADMIN**: 
  - Username: `admin`
  - Password: `admin123`

---

## Kết luận

Tất cả các chức năng đã được triển khai đầy đủ và sẵn sàng để test!
