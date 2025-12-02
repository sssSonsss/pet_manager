# Tài Liệu Dự Án Chi Tiết
## Hệ Thống Quản Lý Trại Thú Cưng (Pet Farm Management System)

---

## 📋 Mục Lục

1. [Tổng Quan Dự Án](#1-tổng-quan-dự-án)
2. [Kiến Trúc Hệ Thống](#2-kiến-trúc-hệ-thống)
3. [Công Nghệ Sử Dụng](#3-công-nghệ-sử-dụng)
4. [Cấu Trúc Dự Án](#4-cấu-trúc-dự-án)
5. [Chi Tiết Các Tính Năng](#5-chi-tiết-các-tính-năng)
6. [Database Schema](#6-database-schema)
7. [Hướng Dẫn Cài Đặt](#7-hướng-dẫn-cài-đặt)
8. [Hướng Dẫn Sử Dụng](#8-hướng-dẫn-sử-dụng)
9. [Bảo Mật và Phân Quyền](#9-bảo-mật-và-phân-quyền)
10. [API và Service Layer](#10-api-và-service-layer)
11. [Giao Diện Người Dùng](#11-giao-diện-người-dùng)
12. [Troubleshooting](#12-troubleshooting)

---

## 1. Tổng Quan Dự Án

### 1.1. Mô Tả Dự Án

**Hệ Thống Quản Lý Trại Thú Cưng** là một ứng dụng desktop được phát triển bằng Java Swing, giúp các trung tâm chăm sóc thú cưng quản lý toàn bộ hoạt động của mình một cách hiệu quả. Hệ thống cung cấp các chức năng quản lý khách hàng, thú cưng, nhân viên, dịch vụ, lịch chăm sóc và các hoạt động liên quan.

### 1.2. Mục Tiêu Dự Án

- **Quản lý khách hàng**: Theo dõi thông tin khách hàng, điểm tích lũy, và lịch sử dịch vụ
- **Quản lý thú cưng**: Quản lý thông tin chi tiết về thú cưng, sức khỏe, và chủ sở hữu
- **Quản lý nhân viên**: Quản lý thông tin nhân viên, ca làm việc, và tài khoản đăng nhập
- **Quản lý dịch vụ**: Quản lý các dịch vụ cung cấp, giá cả, và trạng thái hoạt động
- **Quản lý lịch chăm sóc**: Lập lịch và theo dõi các hoạt động chăm sóc thú cưng
- **Bảo mật và phân quyền**: Hệ thống phân quyền rõ ràng giữa ADMIN và STAFF

### 1.3. Đối Tượng Sử Dụng

- **ADMIN (Quản trị viên)**: Có quyền quản lý toàn bộ hệ thống, bao gồm thêm, sửa, xóa tất cả dữ liệu
- **STAFF (Nhân viên)**: Có quyền xem, thêm, sửa dữ liệu nhưng không được phép xóa

---

## 2. Kiến Trúc Hệ Thống

### 2.1. Kiến Trúc Tổng Quan

Hệ thống được xây dựng theo mô hình **3-Layer Architecture**:

```
┌─────────────────────────────────────┐
│         Presentation Layer          │
│    (View - Java Swing UI)           │
│  - PetFarmApp                       │
│  - LoginDialog, PetDialog, etc.     │
└──────────────┬──────────────────────┘
               │
┌──────────────▼──────────────────────┐
│        Business Logic Layer         │
│    (Service - Business Rules)       │
│  - PetService, CustomerService, etc.│
└──────────────┬──────────────────────┘
               │
┌──────────────▼──────────────────────┐
│        Data Access Layer            │
│    (Repository - Database)         │
│  - PetRepository, CustomerRepo, etc.│
└──────────────┬──────────────────────┘
               │
┌──────────────▼──────────────────────┐
│         Database Layer              │
│         (SQLite Database)           │
└─────────────────────────────────────┘
```

### 2.2. Các Thành Phần Chính

1. **Model Layer**: Định nghĩa cấu trúc dữ liệu (Pet, Customer, Caretaker, Service, etc.)
2. **Repository Layer**: Xử lý các thao tác CRUD với database
3. **Service Layer**: Chứa business logic và validation
4. **View Layer**: Giao diện người dùng Java Swing
5. **Utility Layer**: Các tiện ích hỗ trợ (DateUtils, PasswordUtil, AuthContext)

---

## 3. Công Nghệ Sử Dụng

### 3.1. Ngôn Ngữ và Framework

- **Java 17+**: Ngôn ngữ lập trình chính
- **Java Swing**: Framework xây dựng giao diện desktop
- **SQLite**: Database nhẹ, không cần cài đặt server
- **Maven**: Công cụ quản lý dependencies và build project

### 3.2. Dependencies

```xml
<dependencies>
    <!-- SQLite JDBC Driver -->
    <dependency>
        <groupId>org.xerial</groupId>
        <artifactId>sqlite-jdbc</artifactId>
        <version>3.45.2.0</version>
    </dependency>
</dependencies>
```

### 3.3. Yêu Cầu Hệ Thống

- **JDK**: 17 hoặc cao hơn
- **Maven**: 3.6+ (khuyến nghị)
- **Hệ điều hành**: Windows, macOS, hoặc Linux
- **RAM**: Tối thiểu 512MB
- **Ổ cứng**: ~50MB cho ứng dụng và database

---

## 4. Cấu Trúc Dự Án

### 4.1. Cấu Trúc Thư Mục

```
pet_manager/
├── src/main/java/petfarm/
│   ├── db/                          # Quản lý database
│   │   ├── DatabaseInitializer.java # Khởi tạo database và dữ liệu mẫu
│   │   ├── SQLiteConnectionManager.java # Quản lý kết nối SQLite
│   │   └── schema.sql               # Schema database
│   │
│   ├── model/                       # Các lớp model
│   │   ├── Pet.java                 # Model thú cưng
│   │   ├── Customer.java            # Model khách hàng
│   │   ├── Caretaker.java           # Model nhân viên
│   │   ├── CareSchedule.java        # Model lịch chăm sóc
│   │   ├── Service.java             # Model dịch vụ
│   │   ├── ServiceBooking.java      # Model đặt lịch dịch vụ
│   │   ├── WorkSchedule.java        # Model lịch làm việc nhân viên
│   │   └── User.java                # Model người dùng
│   │
│   ├── repository/                  # Data Access Layer
│   │   ├── PetRepository.java
│   │   ├── CustomerRepository.java
│   │   ├── CaretakerRepository.java
│   │   ├── CareScheduleRepository.java
│   │   ├── ServiceRepository.java
│   │   └── UserRepository.java
│   │
│   ├── service/                     # Business Logic Layer
│   │   ├── PetService.java
│   │   ├── CustomerService.java
│   │   ├── CaretakerService.java
│   │   ├── CareScheduleService.java
│   │   ├── ServiceService.java
│   │   └── UserService.java
│   │
│   ├── util/                        # Tiện ích
│   │   ├── AuthContext.java         # Quản lý authentication context
│   │   ├── DateUtils.java           # Xử lý ngày tháng
│   │   └── PasswordUtil.java       # Hash và verify password
│   │
│   └── view/                        # Giao diện người dùng
│       ├── PetFarmApp.java          # Màn hình chính
│       ├── LoginDialog.java         # Dialog đăng nhập
│       ├── PetDialog.java           # Dialog thêm/sửa thú cưng
│       ├── CustomerDialog.java      # Dialog thêm/sửa khách hàng
│       ├── CaretakerDialog.java      # Dialog thêm/sửa nhân viên
│       ├── ServiceDialog.java       # Dialog thêm/sửa dịch vụ
│       └── ScheduleDialog.java      # Dialog thêm/sửa lịch chăm sóc
│
├── petfarm/db/                      # Thư mục chứa database
│   └── petfarm.db                   # File database SQLite
│
├── target/                          # Thư mục build output
│
├── pom.xml                          # Cấu hình Maven
├── build.py                         # Script build cross-platform
├── run.sh                           # Script chạy (Linux/Mac)
├── run.bat                          # Script chạy (Windows)
├── README.md                        # Tài liệu cơ bản
└── PROJECT_DOCUMENTATION.md         # Tài liệu chi tiết (file này)
```

### 4.2. Design Patterns Sử Dụng

- **Repository Pattern**: Tách biệt logic truy cập dữ liệu
- **Service Pattern**: Tách biệt business logic
- **Singleton Pattern**: AuthContext, SQLiteConnectionManager
- **DAO Pattern**: Repository classes
- **MVC Pattern**: Model-View-Controller trong Swing

---

## 5. Chi Tiết Các Tính Năng

### 5.1. Quản Lý Khách Hàng (Customer Management)

#### 5.1.1. Tính Năng Chính

- ✅ **Thêm khách hàng mới**: Tạo hồ sơ khách hàng với đầy đủ thông tin
- ✅ **Cập nhật thông tin**: Sửa đổi thông tin khách hàng
- ✅ **Xóa khách hàng**: Xóa khách hàng khỏi hệ thống (chỉ ADMIN)
- ✅ **Xem danh sách thú cưng**: Xem tất cả thú cưng của khách hàng
- ✅ **Quản lý điểm tích lũy**: Thêm/trừ điểm tích lũy cho khách hàng

#### 5.1.2. Thông Tin Khách Hàng

- **ID**: Mã định danh duy nhất
- **Tên**: Họ và tên khách hàng
- **Số điện thoại**: Liên hệ
- **Email**: Email liên hệ
- **Địa chỉ**: Địa chỉ khách hàng
- **Điểm tích lũy**: Điểm thưởng từ các dịch vụ (mặc định: 0)
- **Ngày đăng ký**: Ngày khách hàng đăng ký sử dụng dịch vụ

#### 5.1.3. Tính Năng Tìm Kiếm và Lọc

- **Tìm kiếm**: Theo tên, email, số điện thoại
- **Lọc theo điểm tích lũy**:
  - 0 điểm
  - 1-100 điểm
  - 101-500 điểm
  - 501-1000 điểm
  - Trên 1000 điểm

#### 5.1.4. Quyền Truy Cập

- **ADMIN**: Đầy đủ quyền (Thêm, Sửa, Xóa)
- **STAFF**: Chỉ xem, không thể thêm/sửa/xóa

---

### 5.2. Quản Lý Thú Cưng (Pet Management)

#### 5.2.1. Tính Năng Chính

- ✅ **Thêm thú cưng mới**: Tạo hồ sơ thú cưng và liên kết với khách hàng
- ✅ **Cập nhật thông tin**: Sửa đổi thông tin thú cưng
- ✅ **Xóa thú cưng**: Xóa thú cưng khỏi hệ thống (chỉ ADMIN)
- ✅ **Liên kết với khách hàng**: Mỗi thú cưng phải thuộc về một khách hàng
- ✅ **Gán nhân viên chăm sóc**: Chỉ định nhân viên phụ trách

#### 5.2.2. Thông Tin Thú Cưng

- **ID**: Mã định danh duy nhất
- **Tên**: Tên thú cưng
- **Loài**: Loài thú cưng (Chó, Mèo, v.v.)
- **Tuổi**: Tuổi của thú cưng
- **Sức khỏe**: Tình trạng sức khỏe hiện tại
- **Ngày nhập**: Ngày thú cưng được đưa vào trung tâm
- **Khẩu phần**: Chế độ ăn uống
- **Khách hàng**: Chủ sở hữu thú cưng (bắt buộc)
- **Nhân viên**: Nhân viên phụ trách chăm sóc

#### 5.2.3. Tính Năng Tìm Kiếm và Lọc

- **Tìm kiếm**: Theo tên, loài, tên khách hàng, tên nhân viên
- **Lọc theo loài**: Tự động cập nhật từ dữ liệu
- **Lọc theo sức khỏe**: Tự động cập nhật từ dữ liệu
- **Lọc theo khách hàng**: Chọn khách hàng cụ thể

#### 5.2.4. Quyền Truy Cập

- **ADMIN**: Đầy đủ quyền (Thêm, Sửa, Xóa)
- **STAFF**: Chỉ xem, không thể thêm/sửa/xóa

---

### 5.3. Quản Lý Nhân Viên (Caretaker/Staff Management)

#### 5.3.1. Tính Năng Chính

- ✅ **Thêm nhân viên mới**: Tạo hồ sơ nhân viên và tài khoản đăng nhập tự động
- ✅ **Cập nhật thông tin**: Sửa đổi thông tin nhân viên
- ✅ **Xóa nhân viên**: Xóa nhân viên và tài khoản liên kết (chỉ ADMIN)
- ✅ **Tạo tài khoản tự động**: Khi thêm nhân viên, hệ thống tự động tạo tài khoản STAFF
- ✅ **Đồng bộ thông tin**: Thông tin nhân viên được đồng bộ với tài khoản đăng nhập

#### 5.3.2. Thông Tin Nhân Viên

- **ID**: Mã định danh duy nhất
- **Tên**: Họ và tên nhân viên
- **Email**: Email liên hệ
- **Ngày sinh**: Ngày tháng năm sinh
- **Ca làm việc**: Ca làm việc (Sáng, Chiều, Tối, v.v.)
- **User ID**: ID tài khoản đăng nhập liên kết

#### 5.3.3. Tính Năng Tìm Kiếm và Lọc

- **Tìm kiếm**: Theo tên, email
- **Lọc theo ca làm việc**: Tự động cập nhật từ dữ liệu

#### 5.3.4. Quyền Truy Cập

- **ADMIN**: Đầy đủ quyền (Thêm, Sửa, Xóa)
- **STAFF**: Chỉ xem, không thể thêm/sửa/xóa

#### 5.3.5. Tài Khoản Đăng Nhập

Khi tạo nhân viên mới, ADMIN cần cung cấp:
- **Username**: Tên đăng nhập (không thể sửa sau khi tạo)
- **Password**: Mật khẩu (có thể đổi sau)
- Hệ thống tự động tạo tài khoản STAFF và liên kết với nhân viên

---

### 5.4. Quản Lý Dịch Vụ (Service Management)

#### 5.4.1. Tính Năng Chính

- ✅ **Thêm dịch vụ mới**: Tạo dịch vụ với đầy đủ thông tin
- ✅ **Cập nhật dịch vụ**: Sửa đổi thông tin và giá cả
- ✅ **Xóa dịch vụ**: Xóa dịch vụ khỏi hệ thống (chỉ ADMIN)
- ✅ **Kích hoạt/Tạm dừng**: Bật/tắt dịch vụ

#### 5.4.2. Thông Tin Dịch Vụ

- **ID**: Mã định danh duy nhất
- **Tên dịch vụ**: Tên dịch vụ (ví dụ: Tắm rửa, Grooming, Khám bệnh)
- **Mô tả**: Mô tả chi tiết dịch vụ
- **Giá**: Giá dịch vụ (VNĐ)
- **Thời gian**: Thời gian thực hiện (phút)
- **Loại**: Phân loại dịch vụ (GROOMING, HEALTH, SPA, BOARDING, etc.)
- **Trạng thái**: Hoạt động hoặc Tạm dừng

#### 5.4.3. Tính Năng Tìm Kiếm và Lọc

- **Tìm kiếm**: Theo tên dịch vụ, mô tả
- **Lọc theo loại**: Tự động cập nhật từ dữ liệu
- **Lọc theo trạng thái**: Hoạt động / Tạm dừng
- **Lọc theo giá**:
  - Dưới 100.000 VNĐ
  - 100.000 - 500.000 VNĐ
  - 500.000 - 1.000.000 VNĐ
  - Trên 1.000.000 VNĐ

#### 5.4.4. Quyền Truy Cập

- **ADMIN**: Đầy đủ quyền (Thêm, Sửa, Xóa)
- **STAFF**: Chỉ xem, không thể thêm/sửa/xóa

---

### 5.5. Quản Lý Lịch Chăm Sóc (Care Schedule Management)

#### 5.5.1. Tính Năng Chính

- ✅ **Thêm lịch chăm sóc**: Tạo lịch chăm sóc cho thú cưng
- ✅ **Cập nhật lịch**: Sửa đổi thông tin lịch chăm sóc
- ✅ **Xóa lịch**: Xóa lịch chăm sóc (chỉ ADMIN)
- ✅ **Gán nhân viên**: Chỉ định nhân viên thực hiện
- ✅ **Ghi chú**: Thêm ghi chú cho từng hoạt động

#### 5.5.2. Thông Tin Lịch Chăm Sóc

- **ID**: Mã định danh duy nhất
- **Thú cưng**: Thú cưng cần chăm sóc
- **Nhân viên**: Nhân viên được gán thực hiện
- **Hoạt động**: Mô tả hoạt động chăm sóc
- **Ngày**: Ngày thực hiện
- **Ghi chú**: Ghi chú bổ sung

#### 5.5.3. Tính Năng Tìm Kiếm và Lọc

- **Tìm kiếm**: Theo tên thú cưng, tên nhân viên, hoạt động, ghi chú
- **Lọc theo thời gian**:
  - Hôm nay
  - Tuần này
  - Tháng này
  - Chọn ngày cụ thể
  - Tất cả
- **Sắp xếp**:
  - Ngày tăng dần
  - Ngày giảm dần

#### 5.5.4. Quyền Truy Cập

- **ADMIN**: Đầy đủ quyền (Thêm, Sửa, Xóa)
- **STAFF**: Chỉ xem, không thể thêm/sửa/xóa

---

### 5.6. Xác Thực và Phân Quyền (Authentication & Authorization)

#### 5.6.1. Đăng Nhập

- **Username/Password**: Xác thực bằng username và password
- **Hash mật khẩu**: SHA-256 với salt (không lưu plaintext)
- **Session management**: Quản lý phiên đăng nhập qua AuthContext

#### 5.6.2. Phân Quyền

**ADMIN (Quản trị viên)**:
- ✅ Xem tất cả dữ liệu
- ✅ Thêm, sửa, xóa tất cả dữ liệu
- ✅ Tạo tài khoản nhân viên mới
- ✅ Quản lý toàn bộ hệ thống

**STAFF (Nhân viên)**:
- ✅ Xem tất cả dữ liệu
- ✅ Thêm, sửa dữ liệu
- ❌ KHÔNG được phép xóa dữ liệu
- ❌ KHÔNG được tạo tài khoản mới

#### 5.6.3. Bảo Mật

- **Password Hashing**: SHA-256 với salt riêng cho mỗi mật khẩu
- **Input Validation**: Kiểm tra dữ liệu đầu vào
- **SQL Injection Prevention**: Sử dụng PreparedStatement
- **Session Management**: Quản lý phiên đăng nhập an toàn

---

## 6. Database Schema

### 6.1. Các Bảng Chính

#### 6.1.1. Bảng `users`
Lưu trữ thông tin tài khoản đăng nhập.

```sql
CREATE TABLE users (
    id INTEGER PRIMARY KEY AUTOINCREMENT,
    username TEXT UNIQUE NOT NULL,
    password_hash TEXT NOT NULL,
    salt TEXT NOT NULL,
    role TEXT NOT NULL CHECK(role IN ('ADMIN', 'STAFF')),
    name TEXT,
    email TEXT,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);
```

**Các trường**:
- `id`: ID tài khoản
- `username`: Tên đăng nhập (duy nhất)
- `password_hash`: Mật khẩu đã hash
- `salt`: Salt để hash mật khẩu
- `role`: Vai trò (ADMIN hoặc STAFF)
- `name`: Tên người dùng
- `email`: Email
- `created_at`: Ngày tạo

#### 6.1.2. Bảng `customers`
Lưu trữ thông tin khách hàng.

```sql
CREATE TABLE customers (
    id INTEGER PRIMARY KEY AUTOINCREMENT,
    name TEXT NOT NULL,
    phone TEXT,
    email TEXT,
    address TEXT,
    loyalty_points INTEGER DEFAULT 0,
    registration_date DATE DEFAULT CURRENT_DATE
);
```

**Các trường**:
- `id`: ID khách hàng
- `name`: Tên khách hàng
- `phone`: Số điện thoại
- `email`: Email
- `address`: Địa chỉ
- `loyalty_points`: Điểm tích lũy
- `registration_date`: Ngày đăng ký

#### 6.1.3. Bảng `caretakers`
Lưu trữ thông tin nhân viên chăm sóc.

```sql
CREATE TABLE caretakers (
    id INTEGER PRIMARY KEY AUTOINCREMENT,
    name TEXT NOT NULL,
    email TEXT,
    date_of_birth DATE,
    shift TEXT,
    user_id INTEGER,
    FOREIGN KEY (user_id) REFERENCES users(id) ON DELETE CASCADE
);
```

**Các trường**:
- `id`: ID nhân viên
- `name`: Tên nhân viên
- `email`: Email
- `date_of_birth`: Ngày sinh
- `shift`: Ca làm việc
- `user_id`: ID tài khoản liên kết

#### 6.1.4. Bảng `pets`
Lưu trữ thông tin thú cưng.

```sql
CREATE TABLE pets (
    id INTEGER PRIMARY KEY AUTOINCREMENT,
    name TEXT NOT NULL,
    species TEXT,
    age INTEGER,
    health_status TEXT,
    intake_date DATE,
    diet TEXT,
    customer_id INTEGER,
    caretaker_id INTEGER,
    FOREIGN KEY (customer_id) REFERENCES customers(id) ON DELETE SET NULL,
    FOREIGN KEY (caretaker_id) REFERENCES caretakers(id) ON DELETE SET NULL
);
```

**Các trường**:
- `id`: ID thú cưng
- `name`: Tên thú cưng
- `species`: Loài
- `age`: Tuổi
- `health_status`: Tình trạng sức khỏe
- `intake_date`: Ngày nhập
- `diet`: Khẩu phần
- `customer_id`: ID khách hàng sở hữu
- `caretaker_id`: ID nhân viên phụ trách

#### 6.1.5. Bảng `care_schedule`
Lưu trữ lịch chăm sóc thú cưng.

```sql
CREATE TABLE care_schedule (
    id INTEGER PRIMARY KEY AUTOINCREMENT,
    pet_id INTEGER NOT NULL,
    caretaker_id INTEGER NOT NULL,
    activity TEXT NOT NULL,
    schedule_date DATE NOT NULL,
    notes TEXT,
    FOREIGN KEY (pet_id) REFERENCES pets(id) ON DELETE CASCADE,
    FOREIGN KEY (caretaker_id) REFERENCES caretakers(id) ON DELETE CASCADE
);
```

**Các trường**:
- `id`: ID lịch chăm sóc
- `pet_id`: ID thú cưng
- `caretaker_id`: ID nhân viên
- `activity`: Hoạt động chăm sóc
- `schedule_date`: Ngày thực hiện
- `notes`: Ghi chú

#### 6.1.6. Bảng `services`
Lưu trữ thông tin dịch vụ.

```sql
CREATE TABLE services (
    id INTEGER PRIMARY KEY AUTOINCREMENT,
    name TEXT NOT NULL,
    description TEXT,
    price REAL NOT NULL,
    duration_minutes INTEGER,
    category TEXT,
    is_active INTEGER DEFAULT 1
);
```

**Các trường**:
- `id`: ID dịch vụ
- `name`: Tên dịch vụ
- `description`: Mô tả
- `price`: Giá (VNĐ)
- `duration_minutes`: Thời gian (phút)
- `category`: Loại dịch vụ
- `is_active`: Trạng thái (1 = hoạt động, 0 = tạm dừng)

### 6.2. Quan Hệ Giữa Các Bảng

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

### 6.3. Ràng Buộc và Quy Tắc

- **Foreign Key Constraints**: Đảm bảo tính toàn vẹn dữ liệu
- **Cascade Delete**: Khi xóa nhân viên, tự động xóa tài khoản liên kết
- **Unique Constraints**: Username phải duy nhất
- **Check Constraints**: Role chỉ được là ADMIN hoặc STAFF

---

## 7. Hướng Dẫn Cài Đặt

### 7.1. Yêu Cầu Hệ Thống

- **Java Development Kit (JDK)**: Phiên bản 17 hoặc cao hơn
- **Apache Maven**: Phiên bản 3.6 trở lên (khuyến nghị)
- **Hệ điều hành**: Windows, macOS, hoặc Linux

### 7.2. Cài Đặt Java

#### Windows:
1. Tải JDK 17+ từ [Oracle](https://www.oracle.com/java/technologies/downloads/) hoặc [Adoptium](https://adoptium.net/)
2. Cài đặt và thiết lập biến môi trường `JAVA_HOME`
3. Thêm `%JAVA_HOME%\bin` vào `PATH`

#### macOS:
```bash
# Sử dụng Homebrew
brew install openjdk@17

# Hoặc tải từ Adoptium
```

#### Linux:
```bash
# Ubuntu/Debian
sudo apt-get update
sudo apt-get install openjdk-17-jdk

# CentOS/RHEL
sudo yum install java-17-openjdk-devel
```

### 7.3. Cài Đặt Maven

#### Windows:
1. Tải Maven từ [Apache Maven](https://maven.apache.org/download.cgi)
2. Giải nén và thiết lập biến môi trường `MAVEN_HOME`
3. Thêm `%MAVEN_HOME%\bin` vào `PATH`

#### macOS:
```bash
brew install maven
```

#### Linux:
```bash
# Ubuntu/Debian
sudo apt-get install maven

# CentOS/RHEL
sudo yum install maven
```

### 7.4. Clone và Build Dự Án

```bash
# Clone repository (nếu có)
git clone <repository-url>
cd pet_manager

# Hoặc giải nén file zip
unzip pet_manager.zip
cd pet_manager

# Build dự án
mvn clean compile

# Chạy ứng dụng
mvn exec:java
```

### 7.5. Sử Dụng Script Build

#### Windows:
```bash
run.bat
```

#### Linux/macOS:
```bash
chmod +x run.sh
./run.sh
```

#### Cross-platform (Python):
```bash
python build.py
# hoặc
python3 build.py
```

### 7.6. Tạo JAR File

```bash
mvn clean package
```

File JAR sẽ được tạo tại: `target/pet-manager-1.0.0.jar`

Chạy JAR:
```bash
java -jar target/pet-manager-1.0.0.jar
```

---

## 8. Hướng Dẫn Sử Dụng

### 8.1. Đăng Nhập

1. Khởi động ứng dụng
2. Nhập thông tin đăng nhập:
   - **Username**: `admin`
   - **Password**: `admin123`
3. Click "Đăng nhập"

### 8.2. Quản Lý Khách Hàng

#### Thêm Khách Hàng Mới:
1. Chọn tab "👤 Khách hàng"
2. Click nút "Thêm"
3. Điền thông tin:
   - Tên (bắt buộc)
   - Số điện thoại
   - Email
   - Địa chỉ
4. Click "Lưu"

#### Cập Nhật Khách Hàng:
1. Chọn khách hàng trong bảng
2. Click "Cập nhật"
3. Sửa thông tin cần thiết
4. Click "Lưu"

#### Xóa Khách Hàng:
1. Chọn khách hàng trong bảng
2. Click "Xóa"
3. Xác nhận xóa

#### Quản Lý Điểm Tích Lũy:
1. Chọn khách hàng
2. Click "Thêm điểm" hoặc "Trừ điểm"
3. Nhập số điểm
4. Click "OK"

### 8.3. Quản Lý Thú Cưng

#### Thêm Thú Cưng Mới:
1. Chọn tab "🐾 Quản lý thú cưng"
2. Click "Thêm"
3. Điền thông tin:
   - Tên (bắt buộc)
   - Loài
   - Tuổi
   - Sức khỏe
   - Ngày nhập
   - Khẩu phần
   - **Chọn khách hàng** (bắt buộc)
   - Chọn nhân viên phụ trách
4. Click "Lưu"

#### Tìm Kiếm và Lọc:
- Sử dụng thanh tìm kiếm để tìm theo tên, loài, khách hàng, nhân viên
- Sử dụng các bộ lọc: Loài, Sức khỏe, Khách hàng
- Click "Xóa bộ lọc" để reset

### 8.4. Quản Lý Nhân Viên

#### Thêm Nhân Viên Mới:
1. Chọn tab "👥 Nhân viên chăm sóc"
2. Click "Thêm"
3. Điền thông tin:
   - Tên (bắt buộc)
   - Email
   - Ngày sinh
   - Ca làm việc
   - **Username** (bắt buộc, không thể sửa sau)
   - **Password** (bắt buộc)
4. Click "Lưu"
5. Hệ thống tự động tạo tài khoản STAFF

#### Cập Nhật Nhân Viên:
- Username không thể sửa
- Có thể đổi mật khẩu (để trống nếu không muốn đổi)

### 8.5. Quản Lý Dịch Vụ

#### Thêm Dịch Vụ Mới:
1. Chọn tab "🛎️ Dịch vụ"
2. Click "Thêm"
3. Điền thông tin:
   - Tên dịch vụ (bắt buộc)
   - Mô tả
   - Giá (bắt buộc)
   - Thời gian (phút)
   - Loại dịch vụ
   - Trạng thái (Hoạt động/Tạm dừng)
4. Click "Lưu"

### 8.6. Quản Lý Lịch Chăm Sóc

#### Thêm Lịch Chăm Sóc:
1. Chọn tab "📅 Lịch chăm sóc"
2. Click "Thêm"
3. Điền thông tin:
   - Chọn thú cưng (bắt buộc)
   - Chọn nhân viên (bắt buộc)
   - Hoạt động (bắt buộc)
   - Ngày (bắt buộc)
   - Ghi chú
4. Click "Lưu"

#### Lọc và Sắp Xếp:
- **Lọc theo thời gian**: Hôm nay, Tuần này, Tháng này, Chọn ngày
- **Sắp xếp**: Ngày tăng dần, Ngày giảm dần
- **Tìm kiếm**: Theo tên thú cưng, nhân viên, hoạt động

### 8.7. Đăng Xuất

1. Click menu "Tài khoản"
2. Chọn "Đăng xuất"
3. Xác nhận đăng xuất

---

## 9. Bảo Mật và Phân Quyền

### 9.1. Bảo Mật Mật Khẩu

- **Hashing Algorithm**: SHA-256
- **Salt**: Mỗi mật khẩu có salt riêng
- **Storage**: Chỉ lưu hash, không lưu plaintext
- **Validation**: Kiểm tra độ mạnh mật khẩu

### 9.2. Phân Quyền Chi Tiết

#### ADMIN:
| Tính năng | Xem | Thêm | Sửa | Xóa |
|-----------|-----|------|-----|-----|
| Khách hàng | ✅ | ✅ | ✅ | ✅ |
| Thú cưng | ✅ | ✅ | ✅ | ✅ |
| Nhân viên | ✅ | ✅ | ✅ | ✅ |
| Dịch vụ | ✅ | ✅ | ✅ | ✅ |
| Lịch chăm sóc | ✅ | ✅ | ✅ | ✅ |
| Tài khoản | ✅ | ✅ | ✅ | ✅ |

#### STAFF:
| Tính năng | Xem | Thêm | Sửa | Xóa |
|-----------|-----|------|-----|-----|
| Khách hàng | ✅ | ❌ | ❌ | ❌ |
| Thú cưng | ✅ | ❌ | ❌ | ❌ |
| Nhân viên | ✅ | ❌ | ❌ | ❌ |
| Dịch vụ | ✅ | ❌ | ❌ | ❌ |
| Lịch chăm sóc | ✅ | ❌ | ❌ | ❌ |
| Tài khoản | ❌ | ❌ | ❌ | ❌ |

### 9.3. Session Management

- **AuthContext**: Singleton quản lý phiên đăng nhập
- **Logout**: Xóa thông tin phiên khi đăng xuất
- **Permission Check**: Kiểm tra quyền trước mỗi thao tác

---

## 10. API và Service Layer

### 10.1. PetService

```java
// Liệt kê tất cả thú cưng
List<Pet> listPets()

// Tìm thú cưng theo ID
Optional<Pet> findById(Integer id)

// Thêm thú cưng mới
void addPet(Pet pet) throws Exception

// Cập nhật thú cưng
void updatePet(Pet pet) throws Exception

// Xóa thú cưng
void deletePet(Integer id) throws Exception
```

### 10.2. CustomerService

```java
// Liệt kê tất cả khách hàng
List<Customer> listCustomers()

// Tìm khách hàng theo ID
Optional<Customer> findById(Integer id)

// Thêm khách hàng mới
void addCustomer(Customer customer) throws Exception

// Cập nhật khách hàng
void updateCustomer(Customer customer) throws Exception

// Xóa khách hàng
void deleteCustomer(Integer id) throws Exception

// Lấy danh sách thú cưng của khách hàng
List<Pet> getCustomerPets(Integer customerId) throws Exception

// Thêm điểm tích lũy
void addLoyaltyPoints(Integer customerId, int points) throws Exception

// Trừ điểm tích lũy
void subtractLoyaltyPoints(Integer customerId, int points) throws Exception
```

### 10.3. CaretakerService

```java
// Liệt kê tất cả nhân viên
List<Caretaker> listCaretakers()

// Tìm nhân viên theo ID
Optional<Caretaker> findById(Integer id)

// Thêm nhân viên và tạo tài khoản
void addCaretaker(Caretaker caretaker, String username, String password) throws Exception

// Cập nhật nhân viên
void updateCaretaker(Caretaker caretaker, String newPassword) throws Exception

// Xóa nhân viên và tài khoản liên kết
void deleteCaretaker(Integer id) throws Exception
```

### 10.4. ServiceService

```java
// Liệt kê tất cả dịch vụ
List<Service> listServices()

// Liệt kê dịch vụ đang hoạt động
List<Service> listActiveServices()

// Tìm dịch vụ theo ID
Optional<Service> findById(Integer id)

// Thêm dịch vụ mới
void addService(Service service) throws Exception

// Cập nhật dịch vụ
void updateService(Service service) throws Exception

// Xóa dịch vụ
void deleteService(Integer id) throws Exception
```

### 10.5. CareScheduleService

```java
// Liệt kê tất cả lịch chăm sóc
List<CareSchedule> listSchedules()

// Tìm lịch chăm sóc theo ID
Optional<CareSchedule> findById(Integer id)

// Thêm lịch chăm sóc mới
void addSchedule(CareSchedule schedule) throws Exception

// Cập nhật lịch chăm sóc
void updateSchedule(CareSchedule schedule) throws Exception

// Xóa lịch chăm sóc
void deleteSchedule(Integer id) throws Exception
```

---

## 11. Giao Diện Người Dùng

### 11.1. Màn Hình Đăng Nhập

- **Form đăng nhập**: Username và Password
- **Validation**: Kiểm tra thông tin đăng nhập
- **Error handling**: Hiển thị thông báo lỗi rõ ràng

### 11.2. Màn Hình Chính

- **Menu Bar**: 
  - Thông tin người dùng hiện tại
  - Menu "Tài khoản" → "Đăng xuất"
  
- **Tab Navigation**: 5 tab chính
  1. 👤 Khách hàng
  2. 🐾 Quản lý thú cưng
  3. 👥 Nhân viên chăm sóc
  4. 🛎️ Dịch vụ
  5. 📅 Lịch chăm sóc

### 11.3. Tính Năng Giao Diện

- **Tìm kiếm**: Thanh tìm kiếm với nút tìm kiếm
- **Lọc dữ liệu**: Dropdown filters cho các tiêu chí
- **Sắp xếp**: Sắp xếp dữ liệu theo nhiều tiêu chí
- **Dialog Forms**: Form popup cho thêm/sửa
- **Validation**: Kiểm tra dữ liệu đầu vào
- **Error Messages**: Thông báo lỗi rõ ràng
- **Success Messages**: Thông báo thành công

### 11.4. Responsive Design

- **Table Layout**: Hiển thị dữ liệu dạng bảng
- **Scrollable**: Cuộn được khi dữ liệu nhiều
- **Selection**: Chọn một dòng để thao tác
- **Button States**: Nút bị vô hiệu hóa khi không có quyền

---

## 12. Troubleshooting

### 12.1. Lỗi Thường Gặp

#### Lỗi: "Missing sqlite-jdbc driver on classpath"
**Nguyên nhân**: SQLite JDBC driver chưa được tải
**Giải pháp**: 
```bash
mvn clean compile
```

#### Lỗi: "Unsupported class file major version"
**Nguyên nhân**: Java version không đúng
**Giải pháp**: Nâng cấp lên Java 17+
```bash
java -version  # Kiểm tra version
```

#### Lỗi: "Maven not found"
**Nguyên nhân**: Maven chưa được cài đặt
**Giải pháp**: Cài đặt Maven hoặc sử dụng script build

#### Lỗi: "Database locked"
**Nguyên nhân**: Database đang được sử dụng bởi process khác
**Giải pháp**: Đóng tất cả instance của ứng dụng

#### Lỗi: "Foreign key constraint failed"
**Nguyên nhân**: Xóa dữ liệu có liên kết
**Giải pháp**: Xóa dữ liệu con trước, sau đó xóa dữ liệu cha

### 12.2. Debug Mode

Để debug, thêm logging:
```java
System.out.println("Debug: " + variable);
```

Hoặc sử dụng debugger trong IDE.

### 12.3. Reset Database

Nếu cần reset database:
```bash
rm -rf petfarm/db/petfarm.db
# Hoặc trên Windows
del petfarm\db\petfarm.db
```

Sau đó chạy lại ứng dụng, database sẽ được tạo mới.

---

## 13. Phát Triển Tương Lai

### 13.1. Tính Năng Dự Kiến

- [ ] Quản lý đặt lịch dịch vụ (Service Booking)
- [ ] Quản lý lịch làm việc nhân viên (Work Schedule)
- [ ] Báo cáo và thống kê
- [ ] Xuất dữ liệu ra Excel/PDF
- [ ] Backup và restore database
- [ ] Tìm kiếm nâng cao với full-text search
- [ ] Thông báo và nhắc nhở
- [ ] Mobile app (tùy chọn)

### 13.2. Cải Tiến Kỹ Thuật

- [ ] Unit tests
- [ ] Integration tests
- [ ] Logging framework (Log4j, SLF4J)
- [ ] Configuration file (properties)
- [ ] Multi-language support
- [ ] Theme customization

---

## 14. Kết Luận

Hệ Thống Quản Lý Trại Thú Cưng là một ứng dụng desktop hoàn chỉnh, được xây dựng với kiến trúc rõ ràng, bảo mật tốt, và giao diện thân thiện. Hệ thống hỗ trợ đầy đủ các chức năng quản lý cần thiết cho một trung tâm chăm sóc thú cưng, với phân quyền rõ ràng và tính năng tìm kiếm, lọc mạnh mẽ.

---

## 15. Liên Hệ và Hỗ Trợ

- **Tác giả**: Development Team
- **Version**: 1.0.0
- **License**: Educational Purpose
- **Repository**: [GitHub Repository URL]

---

**Tài liệu này được cập nhật lần cuối**: 2025-12-01

**Phiên bản tài liệu**: 1.0.0

