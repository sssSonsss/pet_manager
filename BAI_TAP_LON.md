# BÁO CÁO BÀI TẬP LỚN
## HỆ THỐNG QUẢN LÝ TRẠI THÚ CƯNG
### (Pet Farm Management System)

---

**Môn học**: Lập trình Giao diện  
**Giảng viên hướng dẫn**: _________________  
**Sinh viên thực hiện**: _________________  
**Mã sinh viên**: _________________  
**Lớp**: _________________  
**Năm học**: 2024 - 2025

---

## LỜI CẢM ƠN

Em xin chân thành cảm ơn thầy/cô _________________ đã tận tình hướng dẫn, chỉ bảo trong quá trình thực hiện bài tập lớn này.

Em cũng xin cảm ơn các bạn trong lớp đã hỗ trợ, đóng góp ý kiến để em hoàn thành tốt bài tập.

Cuối cùng, em xin cảm ơn gia đình đã tạo điều kiện và động viên em trong suốt quá trình học tập.

---

## MỤC LỤC

1. [Giới thiệu](#1-giới-thiệu)
2. [Phân tích yêu cầu](#2-phân-tích-yêu-cầu)
3. [Thiết kế hệ thống](#3-thiết-kế-hệ-thống)
4. [Các tính năng của hệ thống](#4-các-tính-năng-của-hệ-thống)
5. [Giao diện người dùng](#5-giao-diện-người-dùng)
6. [Công nghệ sử dụng](#6-công-nghệ-sử-dụng)
7. [Kết quả đạt được](#7-kết-quả-đạt-được)
8. [Kết luận và hướng phát triển](#8-kết-luận-và-hướng-phát-triển)
9. [Tài liệu tham khảo](#9-tài-liệu-tham-khảo)

---

## DANH MỤC HÌNH VẼ

- Hình 1: Sơ đồ kiến trúc hệ thống
- Hình 2: Sơ đồ use case tổng quan
- Hình 3: Sơ đồ luồng dữ liệu
- Hình 4: Màn hình đăng nhập
- Hình 5: Màn hình quản lý khách hàng
- Hình 6: Màn hình quản lý thú cưng
- Hình 7: Màn hình quản lý nhân viên
- Hình 8: Màn hình quản lý dịch vụ
- Hình 9: Màn hình quản lý lịch chăm sóc

---

## 1. GIỚI THIỆU

### 1.1. Đặt vấn đề

Trong thời đại công nghệ hiện nay, việc quản lý thông tin bằng phương pháp thủ công đã trở nên lỗi thời và không hiệu quả. Đặc biệt đối với các trung tâm chăm sóc thú cưng, việc quản lý thông tin khách hàng, thú cưng, nhân viên và lịch chăm sóc một cách thủ công gây ra nhiều khó khăn:

- **Mất thời gian**: Việc tìm kiếm thông tin trong sổ sách mất rất nhiều thời gian
- **Dễ mất mát dữ liệu**: Sổ sách có thể bị mất, hỏng hoặc bị ướt
- **Khó khăn trong việc cập nhật**: Mỗi lần thay đổi phải ghi chép lại, dễ nhầm lẫn
- **Không có hệ thống tích điểm**: Khó khăn trong việc quản lý và khuyến khích khách hàng
- **Thiếu tính bảo mật**: Thông tin dễ bị xem trộm hoặc thay đổi

### 1.2. Mục tiêu của đề tài

Xây dựng một hệ thống quản lý trại thú cưng với các mục tiêu:

1. **Số hóa toàn bộ thông tin**: Chuyển đổi từ quản lý thủ công sang quản lý bằng phần mềm
2. **Tăng hiệu quả quản lý**: Giảm thời gian xử lý, tăng độ chính xác
3. **Bảo mật thông tin**: Bảo vệ dữ liệu khách hàng và thú cưng
4. **Phân quyền rõ ràng**: Phân biệt quyền hạn giữa quản lý và nhân viên
5. **Dễ sử dụng**: Giao diện thân thiện, dễ học và sử dụng

### 1.3. Phạm vi nghiên cứu

**Phạm vi của đề tài:**
- Xây dựng ứng dụng desktop quản lý trại thú cưng
- Quản lý thông tin khách hàng, thú cưng, nhân viên
- Quản lý dịch vụ và lịch chăm sóc
- Hệ thống phân quyền ADMIN và STAFF
- Tìm kiếm và lọc dữ liệu

**Giới hạn của đề tài:**
- Chỉ phát triển cho hệ điều hành desktop (Windows, macOS, Linux)
- Không có tính năng thanh toán trực tuyến
- Không có ứng dụng di động
- Không có báo cáo và thống kê tự động

### 1.4. Phương pháp nghiên cứu

- **Nghiên cứu lý thuyết**: Tìm hiểu về Java Swing, SQLite, các design patterns
- **Phân tích yêu cầu**: Xác định các chức năng cần thiết
- **Thiết kế hệ thống**: Vẽ sơ đồ, thiết kế database
- **Lập trình**: Sử dụng Java để xây dựng ứng dụng
- **Kiểm thử**: Test các chức năng để đảm bảo hoạt động đúng

---

## 2. PHÂN TÍCH YÊU CẦU

### 2.1. Yêu cầu chức năng

#### 2.1.1. Quản lý khách hàng
- Thêm, sửa, xóa thông tin khách hàng
- Tìm kiếm khách hàng theo tên, email, số điện thoại
- Lọc khách hàng theo điểm tích lũy
- Quản lý điểm tích lũy (thêm/trừ điểm)
- Xem danh sách thú cưng của khách hàng

#### 2.1.2. Quản lý thú cưng
- Thêm, sửa, xóa thông tin thú cưng
- Liên kết thú cưng với khách hàng (bắt buộc)
- Gán nhân viên phụ trách cho thú cưng
- Tìm kiếm thú cưng theo tên, loài, khách hàng, nhân viên
- Lọc thú cưng theo loài, sức khỏe, khách hàng

#### 2.1.3. Quản lý nhân viên
- Thêm, sửa, xóa thông tin nhân viên
- Tự động tạo tài khoản đăng nhập khi thêm nhân viên
- Đồng bộ thông tin nhân viên với tài khoản
- Tìm kiếm nhân viên theo tên, email
- Lọc nhân viên theo ca làm việc

#### 2.1.4. Quản lý dịch vụ
- Thêm, sửa, xóa dịch vụ
- Quản lý giá cả và thời gian thực hiện
- Kích hoạt/tạm dừng dịch vụ
- Tìm kiếm dịch vụ theo tên, mô tả
- Lọc dịch vụ theo loại, trạng thái, giá

#### 2.1.5. Quản lý lịch chăm sóc
- Thêm, sửa, xóa lịch chăm sóc
- Gán thú cưng và nhân viên cho lịch
- Lọc lịch theo thời gian (hôm nay, tuần này, tháng này, chọn ngày)
- Sắp xếp lịch theo ngày (tăng dần/giảm dần)
- Tìm kiếm lịch theo thú cưng, nhân viên, hoạt động

#### 2.1.6. Xác thực và phân quyền
- Đăng nhập bằng username và password
- Phân quyền ADMIN và STAFF
- ADMIN: Đầy đủ quyền (thêm, sửa, xóa)
- STAFF: Chỉ xem, không được thêm/sửa/xóa
- Đăng xuất

### 2.2. Yêu cầu phi chức năng

#### 2.2.1. Hiệu năng
- Phản hồi trong vòng 2 giây cho các thao tác thông thường
- Tìm kiếm trả về kết quả trong vòng 1 giây
- Hỗ trợ ít nhất 1000 bản ghi mỗi bảng

#### 2.2.2. Bảo mật
- Mật khẩu được hash bằng SHA-256 với salt
- Ngăn chặn SQL injection
- Phân quyền rõ ràng
- Quản lý session an toàn

#### 2.2.3. Khả năng sử dụng
- Giao diện trực quan, dễ sử dụng
- Thông báo lỗi rõ ràng
- Hỗ trợ phím tắt (Enter để đăng nhập)
- Validation form rõ ràng

#### 2.2.4. Tương thích
- Chạy trên Windows, macOS, Linux
- Yêu cầu Java 17+
- Không cần kết nối internet

---

## 3. THIẾT KẾ HỆ THỐNG

### 3.1. Kiến trúc hệ thống

Hệ thống được xây dựng theo mô hình **3-Layer Architecture**:

```
┌─────────────────────────────────────┐
│      Presentation Layer (View)      │
│    - PetFarmApp (Main Window)      │
│    - LoginDialog                   │
│    - PetDialog, CustomerDialog, etc.│
└──────────────┬──────────────────────┘
               │
┌──────────────▼──────────────────────┐
│     Business Logic Layer (Service)  │
│    - PetService                     │
│    - CustomerService                │
│    - CaretakerService, etc.          │
└──────────────┬──────────────────────┘
               │
┌──────────────▼──────────────────────┐
│   Data Access Layer (Repository)    │
│    - PetRepository                  │
│    - CustomerRepository             │
│    - CaretakerRepository, etc.       │
└──────────────┬──────────────────────┘
               │
┌──────────────▼──────────────────────┐
│        Database Layer (SQLite)      │
│         - petfarm.db                │
└─────────────────────────────────────┘
```

**Ưu điểm của kiến trúc này:**
- Tách biệt rõ ràng giữa các layer
- Dễ bảo trì và mở rộng
- Có thể thay đổi database mà không ảnh hưởng đến business logic
- Dễ test từng layer riêng biệt

### 3.2. Thiết kế cơ sở dữ liệu

#### 3.2.1. Các bảng chính

**Bảng `users`**: Lưu trữ thông tin tài khoản đăng nhập
- `id`: ID tài khoản (Primary Key)
- `username`: Tên đăng nhập (Unique, Not Null)
- `password_hash`: Mật khẩu đã hash (Not Null)
- `salt`: Salt để hash mật khẩu (Not Null)
- `role`: Vai trò (ADMIN hoặc STAFF)
- `name`: Tên người dùng
- `email`: Email
- `created_at`: Ngày tạo

**Bảng `customers`**: Lưu trữ thông tin khách hàng
- `id`: ID khách hàng (Primary Key)
- `name`: Tên khách hàng (Not Null)
- `phone`: Số điện thoại
- `email`: Email
- `address`: Địa chỉ
- `loyalty_points`: Điểm tích lũy (Default: 0)
- `registration_date`: Ngày đăng ký (Default: CURRENT_DATE)

**Bảng `caretakers`**: Lưu trữ thông tin nhân viên
- `id`: ID nhân viên (Primary Key)
- `name`: Tên nhân viên (Not Null)
- `email`: Email
- `date_of_birth`: Ngày sinh
- `shift`: Ca làm việc
- `user_id`: ID tài khoản liên kết (Foreign Key → users.id)

**Bảng `pets`**: Lưu trữ thông tin thú cưng
- `id`: ID thú cưng (Primary Key)
- `name`: Tên thú cưng (Not Null)
- `species`: Loài
- `age`: Tuổi
- `health_status`: Tình trạng sức khỏe
- `intake_date`: Ngày nhập
- `diet`: Khẩu phần
- `customer_id`: ID khách hàng (Foreign Key → customers.id)
- `caretaker_id`: ID nhân viên phụ trách (Foreign Key → caretakers.id)

**Bảng `services`**: Lưu trữ thông tin dịch vụ
- `id`: ID dịch vụ (Primary Key)
- `name`: Tên dịch vụ (Not Null)
- `description`: Mô tả
- `price`: Giá (Not Null)
- `duration_minutes`: Thời gian (phút)
- `category`: Loại dịch vụ
- `is_active`: Trạng thái (1 = hoạt động, 0 = tạm dừng)

**Bảng `care_schedule`**: Lưu trữ lịch chăm sóc
- `id`: ID lịch chăm sóc (Primary Key)
- `pet_id`: ID thú cưng (Foreign Key → pets.id, Not Null)
- `caretaker_id`: ID nhân viên (Foreign Key → caretakers.id, Not Null)
- `activity`: Hoạt động (Not Null)
- `schedule_date`: Ngày thực hiện (Not Null)
- `notes`: Ghi chú

#### 3.2.2. Quan hệ giữa các bảng

```
users (1) ──── (1) caretakers
                │
                │ (1)
                │
                ▼
            pets (N)
                │
                │ (N)
                │
                ▼
        care_schedule (N)

customers (1) ──── (N) pets
```

### 3.3. Design Patterns sử dụng

1. **Repository Pattern**: Tách biệt logic truy cập dữ liệu
2. **Service Pattern**: Tách biệt business logic
3. **Singleton Pattern**: AuthContext, SQLiteConnectionManager
4. **DAO Pattern**: Repository classes
5. **MVC Pattern**: Model-View-Controller trong Swing

---

## 4. CÁC TÍNH NĂNG CỦA HỆ THỐNG

### 4.1. Tính năng đăng nhập và phân quyền

#### 4.1.1. Đăng nhập hệ thống

**Mô tả**: Người dùng phải đăng nhập bằng username và password trước khi sử dụng hệ thống.

**Các bước thực hiện**:
1. Khởi động ứng dụng, màn hình đăng nhập hiển thị
2. Nhập username và password
3. Click nút "Đăng nhập" hoặc nhấn Enter
4. Hệ thống xác thực thông tin
5. Nếu đúng, chuyển sang màn hình chính
6. Nếu sai, hiển thị thông báo lỗi

**Tài khoản mặc định**:
- Username: `admin`
- Password: `admin123`
- Vai trò: ADMIN

**Bảo mật**:
- Mật khẩu được hash bằng SHA-256 với salt
- Mỗi mật khẩu có salt riêng
- Không lưu mật khẩu dạng plaintext

#### 4.1.2. Phân quyền người dùng

**ADMIN (Quản trị viên)**:
- ✅ Xem tất cả dữ liệu
- ✅ Thêm, sửa, xóa tất cả dữ liệu
- ✅ Tạo tài khoản nhân viên mới
- ✅ Quản lý toàn bộ hệ thống

**STAFF (Nhân viên)**:
- ✅ Xem tất cả dữ liệu
- ❌ KHÔNG được thêm dữ liệu
- ❌ KHÔNG được sửa dữ liệu
- ❌ KHÔNG được xóa dữ liệu
- ❌ KHÔNG được tạo tài khoản mới

**Cách thực hiện**:
- Các nút "Thêm", "Cập nhật", "Xóa" bị vô hiệu hóa cho STAFF
- Khi STAFF click các nút này, hiển thị thông báo "Chỉ ADMIN mới được phép..."
- Menu bar hiển thị vai trò và tên người dùng
- Tên hiển thị: Ưu tiên hiển thị `name` nếu có, nếu không thì hiển thị `username`

### 4.2. Tính năng quản lý khách hàng

#### 4.2.1. Thêm khách hàng mới

**Mô tả**: ADMIN có thể thêm khách hàng mới vào hệ thống.

**Thông tin cần nhập**:
- **Tên** (bắt buộc): Họ và tên khách hàng
- **Số điện thoại**: Số điện thoại liên hệ
- **Email**: Email liên hệ
- **Địa chỉ**: Địa chỉ khách hàng

**Tự động gán**:
- **Điểm tích lũy**: Mặc định = 0
- **Ngày đăng ký**: Mặc định = ngày hiện tại

**Quy trình**:
1. Chọn tab "👤 Khách hàng"
2. Click nút "Thêm"
3. Dialog "Thêm khách hàng" hiển thị
4. Nhập thông tin (tên là bắt buộc)
5. Click "Lưu"
6. Hệ thống kiểm tra dữ liệu hợp lệ
7. Lưu vào database
8. Hiển thị thông báo thành công
9. Cập nhật danh sách khách hàng

**Validation**:
- Tên không được để trống
- Email phải đúng định dạng (nếu có)
- Hiển thị thông báo lỗi rõ ràng

#### 4.2.2. Cập nhật thông tin khách hàng

**Mô tả**: ADMIN có thể sửa đổi thông tin khách hàng.

**Thông tin có thể sửa**:
- Tên, số điện thoại, email, địa chỉ

**Thông tin không thể sửa**:
- Điểm tích lũy (phải dùng chức năng thêm/trừ điểm)
- Ngày đăng ký (giữ nguyên)

**Quy trình**:
1. Chọn khách hàng trong bảng
2. Click nút "Cập nhật"
3. Dialog hiển thị với thông tin đã điền sẵn
4. Sửa thông tin cần thiết
5. Click "Lưu"
6. Cập nhật database
7. Hiển thị thông báo thành công

#### 4.2.3. Xóa khách hàng

**Mô tả**: ADMIN có thể xóa khách hàng khỏi hệ thống.

**Lưu ý**: Khi xóa khách hàng, các thú cưng liên kết sẽ không bị xóa nhưng sẽ mất liên kết (customer_id = NULL).

**Quy trình**:
1. Chọn khách hàng trong bảng
2. Click nút "Xóa"
3. Hệ thống hiển thị dialog xác nhận
4. Xác nhận xóa
5. Xóa khỏi database
6. Hiển thị thông báo thành công
7. Cập nhật danh sách

#### 4.2.4. Tìm kiếm và lọc khách hàng

**Tìm kiếm**:
- Tìm theo: Tên, email, số điện thoại
- Không phân biệt hoa thường
- Kết quả hiển thị ngay lập tức khi nhập

**Lọc theo điểm tích lũy**:
- Tất cả
- 0 điểm
- 1-100 điểm
- 101-500 điểm
- 501-1000 điểm
- Trên 1000 điểm

**Cách sử dụng**:
1. Nhập từ khóa vào ô tìm kiếm
2. Chọn bộ lọc từ dropdown (nếu cần)
3. Kết quả được lọc và hiển thị ngay
4. Click "Xóa bộ lọc" để reset

#### 4.2.5. Quản lý điểm tích lũy

**Thêm điểm**:
1. Chọn khách hàng
2. Click nút "Thêm điểm"
3. Nhập số điểm cần thêm (phải > 0)
4. Click "OK"
5. Điểm được cập nhật ngay lập tức

**Trừ điểm**:
1. Chọn khách hàng
2. Click nút "Trừ điểm"
3. Nhập số điểm cần trừ (phải > 0)
4. Click "OK"
5. Điểm được trừ (không được âm)

#### 4.2.6. Xem thú cưng của khách hàng

**Mô tả**: Xem danh sách tất cả thú cưng thuộc về một khách hàng.

**Quy trình**:
1. Chọn khách hàng trong bảng
2. Click nút "Xem thú cưng"
3. Hệ thống hiển thị dialog với danh sách thú cưng
4. Hiển thị: Tên, loài, tuổi của từng thú cưng
5. Nếu khách hàng chưa có thú cưng, hiển thị thông báo

### 4.3. Tính năng quản lý thú cưng

#### 4.3.1. Thêm thú cưng mới

**Mô tả**: ADMIN có thể thêm thú cưng mới và liên kết với khách hàng.

**Thông tin cần nhập**:
- **Tên** (bắt buộc): Tên thú cưng
- **Loài**: Loài thú cưng (Chó, Mèo, v.v.)
- **Tuổi**: Tuổi của thú cưng
- **Sức khỏe**: Tình trạng sức khỏe hiện tại
- **Ngày nhập**: Ngày thú cưng được đưa vào trung tâm
- **Khẩu phần**: Chế độ ăn uống
- **Khách hàng** (bắt buộc): Chọn từ dropdown danh sách khách hàng
- **Nhân viên phụ trách** (tùy chọn): Chọn từ dropdown danh sách nhân viên

**Quy trình**:
1. Chọn tab "🐾 Quản lý thú cưng"
2. Click nút "Thêm"
3. Dialog "Thêm thú cưng" hiển thị
4. Chọn khách hàng từ dropdown (bắt buộc)
5. Nhập các thông tin khác
6. Chọn nhân viên phụ trách (nếu có)
7. Click "Lưu"
8. Hệ thống kiểm tra dữ liệu
9. Lưu vào database
10. Hiển thị thông báo thành công

**Validation**:
- Tên không được để trống
- Phải chọn khách hàng (bắt buộc)
- Ngày nhập phải đúng định dạng yyyy-MM-dd

#### 4.3.2. Cập nhật thông tin thú cưng

**Mô tả**: ADMIN có thể sửa đổi thông tin thú cưng.

**Thông tin có thể sửa**:
- Tất cả thông tin (tên, loài, tuổi, sức khỏe, ngày nhập, khẩu phần)
- Có thể thay đổi khách hàng sở hữu
- Có thể thay đổi nhân viên phụ trách

**Quy trình**: Tương tự như thêm, nhưng form đã được điền sẵn thông tin

#### 4.3.3. Xóa thú cưng

**Mô tả**: ADMIN có thể xóa thú cưng khỏi hệ thống.

**Lưu ý**: Khi xóa thú cưng, các lịch chăm sóc liên kết cũng sẽ bị xóa (CASCADE DELETE).

**Quy trình**:
1. Chọn thú cưng trong bảng
2. Click nút "Xóa"
3. Xác nhận xóa
4. Xóa khỏi database
5. Cập nhật danh sách

#### 4.3.4. Tìm kiếm và lọc thú cưng

**Tìm kiếm**:
- Tìm theo: Tên, loài, tên khách hàng, tên nhân viên
- Không phân biệt hoa thường
- Kết quả hiển thị ngay lập tức

**Lọc**:
- **Theo loài**: Dropdown tự động cập nhật từ dữ liệu hiện có
- **Theo sức khỏe**: Dropdown tự động cập nhật từ dữ liệu hiện có
- **Theo khách hàng**: Dropdown hiển thị danh sách khách hàng có thú cưng

**Cách sử dụng**:
1. Nhập từ khóa vào ô tìm kiếm
2. Chọn bộ lọc từ các dropdown
3. Kết quả được lọc và hiển thị
4. Click "Xóa bộ lọc" để reset

### 4.4. Tính năng quản lý nhân viên

#### 4.4.1. Thêm nhân viên mới

**Mô tả**: ADMIN có thể thêm nhân viên mới và tự động tạo tài khoản đăng nhập.

**Thông tin cần nhập**:
- **Thông tin nhân viên**:
  - Tên (bắt buộc)
  - Email
  - Ngày sinh
  - Ca làm việc
- **Thông tin đăng nhập**:
  - Username (bắt buộc, duy nhất, không thể sửa sau)
  - Password (bắt buộc, tối thiểu 4 ký tự)

**Quy trình**:
1. Chọn tab "👥 Nhân viên chăm sóc"
2. Click nút "Thêm"
3. Dialog "Thêm nhân viên" hiển thị
4. Nhập thông tin nhân viên
5. Nhập username và password
6. Click "Lưu"
7. Hệ thống kiểm tra username chưa tồn tại
8. Tạo tài khoản STAFF với username và password
9. Tạo bản ghi nhân viên và liên kết với tài khoản
10. Hiển thị thông báo thành công với username và password

**Đặc điểm**:
- Username phải duy nhất trong hệ thống
- Nếu username đã tồn tại, hiển thị lỗi và yêu cầu nhập lại
- Tài khoản được tạo tự động, nhân viên có thể đăng nhập ngay

#### 4.4.2. Cập nhật thông tin nhân viên

**Mô tả**: ADMIN có thể sửa đổi thông tin nhân viên.

**Thông tin có thể sửa**:
- Tên, email, ngày sinh, ca làm việc
- Mật khẩu (tùy chọn, để trống nếu không muốn đổi)

**Thông tin không thể sửa**:
- Username (không thể thay đổi sau khi tạo)

**Quy trình**:
1. Chọn nhân viên trong bảng
2. Click nút "Cập nhật"
3. Dialog hiển thị với thông tin đã điền sẵn
4. Username hiển thị nhưng bị disable (không thể sửa)
5. Sửa các thông tin khác
6. Nhập mật khẩu mới (nếu muốn đổi, để trống nếu không)
7. Click "Lưu"
8. Cập nhật thông tin nhân viên
9. Nếu có mật khẩu mới, cập nhật mật khẩu tài khoản
10. Đồng bộ thông tin (tên, email) với tài khoản đăng nhập

#### 4.4.3. Xóa nhân viên

**Mô tả**: ADMIN có thể xóa nhân viên và tài khoản liên kết.

**Lưu ý**: Khi xóa nhân viên, tài khoản STAFF liên kết cũng sẽ bị xóa (CASCADE DELETE).

**Quy trình**:
1. Chọn nhân viên trong bảng
2. Click nút "Xóa"
3. Hệ thống hiển thị dialog xác nhận với cảnh báo
4. Xác nhận xóa
5. Xóa nhân viên và tài khoản liên kết
6. Hiển thị thông báo thành công

#### 4.4.4. Tìm kiếm và lọc nhân viên

**Tìm kiếm**:
- Tìm theo: Tên, email
- Không phân biệt hoa thường

**Lọc**:
- **Theo ca làm việc**: Dropdown tự động cập nhật từ dữ liệu hiện có

**Làm mới dữ liệu**:
- Nút "Làm mới": Xóa lựa chọn hiện tại và tải lại danh sách nhân viên
- Hữu ích khi cần reset bảng và xóa bộ lọc

### 4.5. Tính năng quản lý dịch vụ

#### 4.5.1. Thêm dịch vụ mới

**Mô tả**: ADMIN có thể thêm dịch vụ mới vào hệ thống.

**Thông tin cần nhập**:
- **Tên dịch vụ** (bắt buộc): Tên dịch vụ (ví dụ: Tắm rửa, Grooming, Khám bệnh)
- **Mô tả**: Mô tả chi tiết dịch vụ
- **Giá** (bắt buộc): Giá dịch vụ (VNĐ), phải là số dương
- **Thời gian**: Thời gian thực hiện (phút)
- **Loại dịch vụ**: Phân loại (GROOMING, HEALTH, SPA, BOARDING, etc.)
- **Trạng thái**: Hoạt động hoặc Tạm dừng (mặc định: Hoạt động)

**Quy trình**:
1. Chọn tab "🛎️ Dịch vụ"
2. Click nút "Thêm"
3. Dialog "Thêm dịch vụ" hiển thị
4. Nhập thông tin dịch vụ
5. Click "Lưu"
6. Hệ thống kiểm tra dữ liệu (tên và giá bắt buộc)
7. Lưu vào database
8. Hiển thị thông báo thành công

#### 4.5.2. Cập nhật dịch vụ

**Mô tả**: ADMIN có thể sửa đổi thông tin dịch vụ, bao gồm giá cả và trạng thái.

**Quy trình**: Tương tự như thêm, nhưng form đã được điền sẵn

#### 4.5.3. Xóa dịch vụ

**Mô tả**: ADMIN có thể xóa dịch vụ khỏi hệ thống.

**Quy trình**: Chọn dịch vụ → Click "Xóa" → Xác nhận → Xóa

#### 4.5.4. Tìm kiếm và lọc dịch vụ

**Tìm kiếm**:
- Tìm theo: Tên dịch vụ, mô tả
- Không phân biệt hoa thường

**Lọc**:
- **Theo loại**: Dropdown tự động cập nhật từ dữ liệu
- **Theo trạng thái**: Hoạt động / Tạm dừng
- **Theo giá**:
  - Dưới 100.000 VNĐ
  - 100.000 - 500.000 VNĐ
  - 500.000 - 1.000.000 VNĐ
  - Trên 1.000.000 VNĐ

### 4.6. Tính năng quản lý lịch chăm sóc

#### 4.6.1. Thêm lịch chăm sóc

**Mô tả**: ADMIN có thể tạo lịch chăm sóc cho thú cưng.

**Thông tin cần nhập**:
- **Thú cưng** (bắt buộc): Chọn từ dropdown danh sách thú cưng
- **Nhân viên** (bắt buộc): Chọn từ dropdown danh sách nhân viên
- **Hoạt động** (bắt buộc): Mô tả hoạt động chăm sóc
- **Ngày** (bắt buộc): Ngày thực hiện (định dạng yyyy-MM-dd)
- **Ghi chú** (tùy chọn): Ghi chú bổ sung

**Quy trình**:
1. Chọn tab "📅 Lịch chăm sóc"
2. Click nút "Thêm"
3. Dialog "Thêm lịch chăm sóc" hiển thị
4. Chọn thú cưng từ dropdown
5. Chọn nhân viên từ dropdown
6. Nhập hoạt động
7. Chọn ngày (có thể dùng date picker)
8. Thêm ghi chú (nếu có)
9. Click "Lưu"
10. Hệ thống kiểm tra dữ liệu
11. Lưu vào database
12. Hiển thị thông báo thành công

#### 4.6.2. Cập nhật lịch chăm sóc

**Mô tả**: ADMIN có thể sửa đổi lịch chăm sóc.

**Quy trình**: Tương tự như thêm, nhưng form đã được điền sẵn

#### 4.6.3. Xóa lịch chăm sóc

**Mô tả**: ADMIN có thể xóa lịch chăm sóc.

**Quy trình**: Chọn lịch → Click "Xóa" → Xác nhận → Xóa

#### 4.6.4. Lọc và sắp xếp lịch chăm sóc

**Lọc theo thời gian**:
- **Tất cả**: Hiển thị tất cả lịch
- **Hôm nay**: Chỉ hiển thị lịch của ngày hiện tại
- **Tuần này**: Hiển thị lịch từ thứ 2 đến chủ nhật của tuần hiện tại
- **Tháng này**: Hiển thị lịch của tháng hiện tại
- **Chọn ngày**: Nhập ngày cụ thể (yyyy-MM-dd)

**Sắp xếp**:
- **Ngày tăng dần**: Sắp xếp từ ngày cũ đến mới
- **Ngày giảm dần**: Sắp xếp từ ngày mới đến cũ

**Tìm kiếm**:
- Tìm theo: Tên thú cưng, tên nhân viên, hoạt động, ghi chú
- Không phân biệt hoa thường

**Cách sử dụng**:
1. Chọn bộ lọc thời gian từ dropdown
2. Nếu chọn "Chọn ngày", nhập ngày vào ô text
3. Chọn cách sắp xếp
4. Nhập từ khóa tìm kiếm (nếu cần)
5. Kết quả được lọc và sắp xếp ngay lập tức
6. Click "Xóa bộ lọc" để reset

### 4.7. Tính năng tìm kiếm và lọc tổng quát

#### 4.7.1. Tìm kiếm

**Đặc điểm chung**:
- Tất cả các tab đều có thanh tìm kiếm
- Tìm kiếm không phân biệt hoa thường
- Kết quả hiển thị ngay lập tức khi nhập
- Có thể tìm kiếm trên nhiều trường cùng lúc

**Cách sử dụng**:
1. Nhập từ khóa vào ô tìm kiếm
2. Nhấn Enter hoặc click nút "🔍 Tìm"
3. Kết quả được lọc và hiển thị ngay

#### 4.7.2. Lọc dữ liệu

**Đặc điểm**:
- Mỗi tab có các bộ lọc phù hợp với dữ liệu
- Dropdown filter tự động cập nhật từ dữ liệu hiện có
- Có thể kết hợp nhiều bộ lọc cùng lúc
- Có thể kết hợp tìm kiếm và lọc

**Cách sử dụng**:
1. Chọn bộ lọc từ dropdown
2. Kết quả được lọc ngay lập tức
3. Có thể chọn nhiều bộ lọc cùng lúc
4. Click "Xóa bộ lọc" để reset tất cả

#### 4.7.3. Xóa bộ lọc

**Chức năng**: Reset tất cả bộ lọc và tìm kiếm về trạng thái ban đầu.

**Cách sử dụng**: Click nút "Xóa bộ lọc" → Tất cả filter và search được reset

---

## 5. GIAO DIỆN NGƯỜI DÙNG

### 5.1. Màn hình đăng nhập

**Mô tả**: Màn hình đầu tiên khi khởi động ứng dụng.

**Các thành phần**:
- Ô nhập Username
- Ô nhập Password (ẩn ký tự)
- Nút "Đăng nhập"
- Thông tin tài khoản mặc định (hiển thị để tham khảo)

**Tính năng**:
- Hỗ trợ phím Enter để đăng nhập nhanh
- Validation: Kiểm tra username và password không được để trống
- Hiển thị thông báo lỗi rõ ràng nếu đăng nhập sai

### 5.2. Màn hình chính

**Cấu trúc**:
- **Menu Bar**: 
  - Menu "Tài khoản" → "Đăng xuất"
  - Thông tin người dùng hiện tại (tên, vai trò) ở bên phải
  - Màu sắc khác nhau cho ADMIN (xanh lá) và STAFF (xanh dương)
  
- **Tab Navigation**: 5 tab chính
  - **Cho ADMIN**:
    1. 👤 Khách hàng
    2. 🐾 Quản lý thú cưng
    3. 👥 Nhân viên chăm sóc
    4. 🛎️ Dịch vụ
    5. 📅 Lịch chăm sóc
  - **Cho STAFF** (tên tab khác để nhấn mạnh quyền xem):
    1. 👤 Khách hàng
    2. 🐾 Xem thú cưng
    3. 👥 Xem nhân viên
    4. 🛎️ Dịch vụ
    5. 📅 Lịch chăm sóc

- **Panel thông tin** (chỉ hiển thị cho STAFF):
  - Thông báo về quyền hạn của STAFF
  - Nhắc nhở không được phép xóa dữ liệu

### 5.3. Cấu trúc mỗi tab

**Các thành phần chung**:
1. **Panel tìm kiếm và lọc** (ở trên):
   - Ô tìm kiếm với nút "🔍 Tìm"
   - Các dropdown filter
   - Nút "Xóa bộ lọc"

2. **Bảng dữ liệu** (ở giữa):
   - Hiển thị dữ liệu dạng bảng
   - Có thể cuộn khi dữ liệu nhiều
   - Chọn một dòng để thao tác

3. **Panel nút chức năng** (ở dưới):
   - Nút "Thêm" (chỉ ADMIN)
   - Nút "Cập nhật" (chỉ ADMIN)
   - Nút "Xóa" (chỉ ADMIN)
   - Các nút chức năng đặc biệt (tùy từng tab):
     - **Khách hàng**: "Xem thú cưng", "Thêm điểm", "Trừ điểm"
     - **Nhân viên**: "Làm mới" (refresh dữ liệu)
     - **Thú cưng**: Tự động cập nhật dropdown khi thêm/sửa/xóa
     - **Lịch chăm sóc**: Tự động cập nhật dropdown thú cưng và nhân viên

### 5.4. Dialog forms

**Đặc điểm chung**:
- Popup dialog để thêm/sửa dữ liệu
- Form validation rõ ràng
- Hiển thị lỗi ngay tại trường bị sai
- Nút "Lưu" và "Hủy"
- Tự động đóng sau khi lưu thành công

**Các dialog**:
- `CustomerDialog`: Thêm/sửa khách hàng
- `PetDialog`: Thêm/sửa thú cưng
- `CaretakerDialog`: Thêm/sửa nhân viên
- `ServiceDialog`: Thêm/sửa dịch vụ
- `ScheduleDialog`: Thêm/sửa lịch chăm sóc

### 5.5. Thông báo

**Các loại thông báo**:
- **Thông báo thành công**: Màu xanh, hiển thị khi thao tác thành công
- **Thông báo lỗi**: Màu đỏ, hiển thị khi có lỗi
- **Thông báo cảnh báo**: Màu vàng, hiển thị khi cần cảnh báo
- **Dialog xác nhận**: Hiển thị khi cần xác nhận (xóa, đăng xuất)

---

## 6. CÔNG NGHỆ SỬ DỤNG

### 6.1. Ngôn ngữ lập trình

**Java 17+**:
- Ngôn ngữ chính để phát triển ứng dụng
- Sử dụng các tính năng mới của Java 17 (records, switch expressions, etc.)
- Object-oriented programming

### 6.2. Framework và thư viện

**Java Swing**:
- Framework xây dựng giao diện desktop
- Các component: JFrame, JDialog, JTable, JComboBox, JTextField, etc.
- Layout managers: BorderLayout, FlowLayout

**SQLite JDBC Driver (3.45.2.0)**:
- Kết nối và thao tác với database SQLite
- PreparedStatement để ngăn chặn SQL injection

### 6.3. Cơ sở dữ liệu

**SQLite**:
- Database nhẹ, không cần cài đặt server
- File-based database
- Hỗ trợ foreign key constraints
- Tự động tạo file database khi chạy lần đầu

### 6.4. Công cụ phát triển

**Apache Maven**:
- Quản lý dependencies
- Build và compile project
- Tạo JAR file

**IDE**: IntelliJ IDEA, Eclipse, hoặc NetBeans

### 6.5. Design Patterns

1. **Repository Pattern**: Tách biệt data access logic
2. **Service Pattern**: Tách biệt business logic
3. **Singleton Pattern**: Quản lý connection và authentication context
4. **DAO Pattern**: Data Access Object trong repository layer
5. **MVC Pattern**: Model-View-Controller trong Swing

---

## 7. KẾT QUẢ ĐẠT ĐƯỢC

### 7.1. Các tính năng đã hoàn thành

✅ **Quản lý khách hàng**:
- Thêm, sửa, xóa khách hàng
- Tìm kiếm và lọc
- Quản lý điểm tích lũy
- Xem thú cưng của khách hàng

✅ **Quản lý thú cưng**:
- Thêm, sửa, xóa thú cưng
- Liên kết với khách hàng (bắt buộc)
- Gán nhân viên phụ trách
- Tìm kiếm và lọc đa tiêu chí

✅ **Quản lý nhân viên**:
- Thêm, sửa, xóa nhân viên
- Tự động tạo tài khoản đăng nhập
- Đồng bộ thông tin với tài khoản
- Tìm kiếm và lọc
- Nút làm mới dữ liệu

✅ **Quản lý dịch vụ**:
- Thêm, sửa, xóa dịch vụ
- Quản lý giá cả và trạng thái
- Tìm kiếm và lọc theo nhiều tiêu chí

✅ **Quản lý lịch chăm sóc**:
- Thêm, sửa, xóa lịch
- Lọc theo thời gian (hôm nay, tuần này, tháng này, chọn ngày)
- Sắp xếp theo ngày
- Tìm kiếm đa tiêu chí

✅ **Xác thực và phân quyền**:
- Đăng nhập bằng username/password
- Phân quyền ADMIN và STAFF rõ ràng
- Bảo mật mật khẩu bằng SHA-256 hash

✅ **Tìm kiếm và lọc**:
- Tìm kiếm không phân biệt hoa thường
- Lọc đa tiêu chí
- Kết hợp tìm kiếm và lọc
- Tự động cập nhật filter options

### 7.2. Giao diện người dùng

✅ **Giao diện trực quan**:
- Layout rõ ràng, dễ hiểu
- Màu sắc phân biệt vai trò
- Icon và emoji để dễ nhận biết

✅ **Tính năng UX**:
- Validation form rõ ràng
- Thông báo lỗi dễ hiểu
- Hỗ trợ phím tắt
- Dialog forms thân thiện

### 7.3. Bảo mật

✅ **Bảo mật mật khẩu**:
- Hash bằng SHA-256 với salt
- Không lưu plaintext
- Mỗi mật khẩu có salt riêng

✅ **Phân quyền**:
- Phân biệt rõ ràng ADMIN và STAFF
- Vô hiệu hóa các chức năng không được phép
- Kiểm tra quyền trước mỗi thao tác

✅ **SQL Injection Prevention**:
- Sử dụng PreparedStatement
- Không dùng string concatenation cho SQL

### 7.4. Hiệu năng

✅ **Phản hồi nhanh**:
- Tìm kiếm trả về kết quả trong 1 giây
- Các thao tác thông thường trong 2 giây
- Tối ưu hóa query database

### 7.5. Tính ổn định

✅ **Xử lý lỗi**:
- Try-catch cho các thao tác database
- Hiển thị thông báo lỗi rõ ràng
- Không crash khi có lỗi

✅ **Validation**:
- Kiểm tra dữ liệu đầu vào
- Ngăn chặn dữ liệu không hợp lệ
- Thông báo lỗi cụ thể

---

## 8. KẾT LUẬN VÀ HƯỚNG PHÁT TRIỂN

### 8.1. Kết luận

Qua quá trình nghiên cứu và phát triển, em đã hoàn thành hệ thống quản lý trại thú cưng với đầy đủ các tính năng cơ bản:

1. **Quản lý toàn diện**: Hệ thống quản lý đầy đủ thông tin khách hàng, thú cưng, nhân viên, dịch vụ và lịch chăm sóc.

2. **Phân quyền rõ ràng**: Hệ thống phân quyền ADMIN và STAFF giúp bảo vệ dữ liệu và đảm bảo an toàn.

3. **Tìm kiếm và lọc mạnh mẽ**: Tính năng tìm kiếm và lọc đa tiêu chí giúp người dùng tìm thông tin nhanh chóng.

4. **Giao diện thân thiện**: Giao diện trực quan, dễ sử dụng, phù hợp với cả người dùng không chuyên.

5. **Bảo mật tốt**: Hệ thống bảo mật mật khẩu và ngăn chặn các lỗ hổng bảo mật phổ biến.

**Những điểm mạnh**:
- Kiến trúc rõ ràng, dễ bảo trì
- Code được tổ chức tốt, dễ đọc
- Tính năng đầy đủ cho nhu cầu cơ bản
- Giao diện thân thiện

**Những hạn chế**:
- Chưa có báo cáo và thống kê tự động
- Chưa có tính năng backup tự động
- Chưa hỗ trợ đa người dùng đồng thời
- Chưa có audit log

### 8.2. Hướng phát triển

Trong tương lai, hệ thống có thể được mở rộng với các tính năng:

1. **Báo cáo và thống kê**:
   - Báo cáo doanh thu theo tháng/năm
   - Thống kê số lượng khách hàng, thú cưng
   - Biểu đồ trực quan hóa dữ liệu

2. **Xuất dữ liệu**:
   - Xuất danh sách ra Excel
   - In báo cáo ra PDF
   - Export/Import dữ liệu

3. **Tính năng nâng cao**:
   - Đặt lịch dịch vụ (Service Booking)
   - Quản lý lịch làm việc nhân viên (Work Schedule)
   - Thông báo và nhắc nhở tự động
   - Tìm kiếm nâng cao với full-text search

4. **Cải tiến kỹ thuật**:
   - Unit tests và integration tests
   - Logging framework
   - Configuration file
   - Multi-language support
   - Theme customization

5. **Mở rộng platform**:
   - Ứng dụng web
   - Ứng dụng di động
   - API cho tích hợp với hệ thống khác

### 8.3. Bài học kinh nghiệm

Qua quá trình thực hiện bài tập, em đã học được:

1. **Kỹ năng lập trình**: Nâng cao kỹ năng Java, Swing, SQLite
2. **Thiết kế hệ thống**: Hiểu về kiến trúc 3-layer, design patterns
3. **Phân tích yêu cầu**: Xác định và phân tích yêu cầu nghiệp vụ
4. **Quản lý dự án**: Lập kế hoạch, tổ chức code, quản lý thời gian
5. **Debugging**: Kỹ năng tìm và sửa lỗi

### 8.4. Lời cảm ơn

Em xin chân thành cảm ơn thầy/cô đã hướng dẫn và tạo điều kiện để em hoàn thành bài tập này. Bài tập đã giúp em củng cố kiến thức và nâng cao kỹ năng lập trình.

---

## 9. TÀI LIỆU THAM KHẢO

1. Oracle Corporation. (2024). *Java Platform, Standard Edition Documentation*. https://docs.oracle.com/javase/

2. Oracle Corporation. (2024). *Java Swing Tutorial*. https://docs.oracle.com/javase/tutorial/uiswing/

3. SQLite. (2024). *SQLite Documentation*. https://www.sqlite.org/docs.html

4. Apache Software Foundation. (2024). *Apache Maven Documentation*. https://maven.apache.org/guides/

5. Xerial. (2024). *SQLite JDBC Driver*. https://github.com/xerial/sqlite-jdbc

6. Gamma, E., Helm, R., Johnson, R., & Vlissides, J. (1994). *Design Patterns: Elements of Reusable Object-Oriented Software*. Addison-Wesley.

7. Fowler, M. (2002). *Patterns of Enterprise Application Architecture*. Addison-Wesley.

---

**Hết báo cáo**

---

*Báo cáo này được thực hiện bởi sinh viên trong khuôn khổ bài tập lớn môn Lập trình Giao diện, năm học 2024-2025.*

