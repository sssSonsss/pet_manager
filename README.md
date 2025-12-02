# Hệ thống Quản lý Trại Thú cưng (Pet Farm Management)

Ứng dụng desktop Java Swing để quản lý thú cưng, nhân viên chăm sóc và lịch chăm sóc sử dụng SQLite. Hệ thống có tính năng đăng nhập và phân quyền theo vai trò (ADMIN/STAFF).

## 🚀 Chạy nhanh

### Cách đơn giản nhất (Cả Mac và Windows):
```bash
python3 build.py
# hoặc
python build.py
```

### Hoặc chạy trực tiếp với Maven:
```bash
mvn clean compile exec:java
```

**Lưu ý:** Database sẽ tự động tạo khi chạy lần đầu tại `petfarm/db/petfarm.db`

---

## Yêu cầu hệ thống

- **Java**: JDK 17 hoặc cao hơn
- **Maven**: 3.6+ (để build và quản lý dependencies)
- **Python**: 3.x (để chạy script `build.py`, hoặc có thể dùng Maven trực tiếp)
- **Hệ điều hành**: Windows, macOS, hoặc Linux

## Cài đặt môi trường

### Kiểm tra Java:
```bash
java -version  # Cần JDK 17+
```

Nếu chưa có Java:
- **macOS**: `brew install openjdk@17`
- **Windows/Linux**: https://adoptium.net/

### Kiểm tra Maven:
```bash
mvn -version  # Cần Maven 3.6+
```

Nếu chưa có Maven:
- **macOS**: `brew install maven`
- **Windows**: Tải từ https://maven.apache.org/download.cgi và thêm vào PATH
- **Linux**: `sudo apt install maven`

## Khởi tạo Database

Database SQLite sẽ được **tự động tạo** khi chạy ứng dụng lần đầu tiên. Không cần cài đặt hoặc cấu hình thêm.

### Quá trình khởi tạo tự động:

Khi ứng dụng khởi động, hệ thống sẽ:
- Tự động tạo thư mục `petfarm/db/` nếu chưa có
- Tạo file database `petfarm.db` tại `petfarm/db/petfarm.db`
- Tạo tất cả các bảng cần thiết:
  - `users` - Tài khoản đăng nhập (ADMIN/STAFF)
  - `customers` - Thông tin khách hàng
  - `caretakers` - Thông tin nhân viên chăm sóc
  - `pets` - Thông tin thú cưng
  - `care_schedule` - Lịch chăm sóc
  - `services` - Dịch vụ
- Tạo tài khoản ADMIN mặc định: `admin` / `admin123`
- Tạo 2 tài khoản STAFF mặc định: `staff1`, `staff2` / `staff123`
- Thêm dữ liệu mẫu (khách hàng, thú cưng, lịch chăm sóc)

### Reset database (nếu cần):

**macOS/Linux:**
```bash
rm petfarm/db/petfarm.db
```

**Windows:**
```cmd
del petfarm\db\petfarm.db
```

Sau đó chạy lại ứng dụng, database sẽ được tạo mới tự động.

## Build và Chạy dự án

### Cách 1: Sử dụng script Python (Khuyến nghị)

Script `build.py` hoạt động trên cả Mac và Windows:

```bash
python3 build.py
# hoặc
python build.py
```

Script sẽ tự động:
- Kiểm tra Java và Maven đã cài đặt
- Build dự án (`mvn clean compile`)
- Chạy ứng dụng (`mvn exec:java`)

### Cách 2: Chạy trực tiếp với Maven

**Build và chạy trong một lệnh:**
```bash
mvn clean compile exec:java
```

**Hoặc từng bước:**
```bash
mvn clean compile  # Build dự án
mvn exec:java      # Chạy ứng dụng
```

### Cách 3: Tạo JAR và chạy

```bash
mvn clean package
java -jar target/pet-manager-1.0.0.jar
```

## Đăng nhập

Khi ứng dụng khởi động, bạn sẽ thấy màn hình đăng nhập.

### Tài khoản mặc định:

**ADMIN (Quản trị viên):**
- Username: `admin`
- Password: `admin123`
- Quyền: Toàn quyền quản lý hệ thống

**STAFF (Nhân viên):**
- Username: `staff1` hoặc `staff2`
- Password: `staff123`
- Quyền: Xem và chỉnh sửa dữ liệu (không được xóa)

## Cấu trúc dự án

```
pet_manager/
├── src/main/java/petfarm/
│   ├── db/              # Quản lý kết nối SQLite và khởi tạo database
│   ├── model/           # Các lớp model (Pet, Caretaker, CareSchedule, User, Customer, Service)
│   ├── repository/      # Data Access Layer (CRUD operations)
│   ├── service/         # Business Logic Layer
│   ├── util/            # Tiện ích (DateUtils, PasswordUtil, AuthContext)
│   └── view/            # Giao diện Swing (PetFarmApp, LoginDialog, các Dialog)
├── petfarm/             # Thư mục chứa database SQLite (tự động tạo)
│   └── db/
│       └── petfarm.db
├── pom.xml              # File cấu hình Maven
├── build.py             # Script build và chạy (cross-platform)
└── README.md            # File này
```

## Cấu trúc Database

Database được lưu tại: `petfarm/db/petfarm.db`

### Các bảng chính:

- **users**: Tài khoản đăng nhập (ADMIN/STAFF)
- **customers**: Thông tin khách hàng
- **caretakers**: Thông tin nhân viên chăm sóc
- **pets**: Thông tin thú cưng (liên kết với customer và caretaker)
- **care_schedule**: Lịch chăm sóc thú cưng
- **services**: Dịch vụ

### Quan hệ giữa các bảng:

- `users` (1) ↔ `caretakers` (1): Mỗi nhân viên có một tài khoản đăng nhập
- `customers` (1) → `pets` (N): Mỗi khách hàng có nhiều thú cưng
- `caretakers` (1) → `pets` (N): Mỗi nhân viên chăm sóc nhiều thú cưng
- `pets` (1) → `care_schedule` (N): Mỗi thú cưng có nhiều lịch chăm sóc
- `caretakers` (1) → `care_schedule` (N): Mỗi nhân viên có nhiều lịch chăm sóc

## Tính năng

### 1. Đăng nhập và Quản lý Tài khoản
- **Đăng nhập:** Yêu cầu Username và Password để truy cập hệ thống
- **Tài khoản mặc định:**
  - ADMIN: `admin` / `admin123`
  - STAFF: `staff1` hoặc `staff2` / `staff123`
- **Bảo mật:** Mật khẩu được hash bằng SHA-256 với salt, không lưu dạng plaintext
- **Đăng xuất:** Menu "Tài khoản" → "Đăng xuất"

### 2. Phân quyền (Authorization)

#### ADMIN (Quản trị viên)
- Quyền quản lý toàn bộ hệ thống
- Có thể thêm, sửa, **xóa** tất cả dữ liệu
- Truy cập đầy đủ tất cả tính năng

#### STAFF (Nhân viên)
- Quyền xem và chỉnh sửa hạn chế
- Có thể thêm, sửa dữ liệu
- **KHÔNG được phép xóa** dữ liệu (nút "Xóa" bị vô hiệu hóa)

### 3. Quản lý Thú cưng
- Thêm, sửa, xóa thông tin thú cưng (xóa chỉ dành cho ADMIN)
- Tìm kiếm và lọc theo loài, sức khỏe, khách hàng
- Theo dõi: tên, loài, tuổi, sức khỏe, ngày nhập, khẩu phần, nhân viên phụ trách, khách hàng

### 4. Quản lý Nhân viên Chăm sóc
- Thêm, sửa, xóa nhân viên (xóa chỉ dành cho ADMIN)
- Tìm kiếm và lọc theo ca làm việc
- Theo dõi: tên, số điện thoại, email, ngày sinh, ca làm việc
- Tự động tạo tài khoản đăng nhập khi thêm nhân viên mới

### 5. Quản lý Khách hàng
- Thêm, sửa, xóa khách hàng (xóa chỉ dành cho ADMIN)
- Tìm kiếm và lọc theo điểm tích lũy
- Theo dõi: tên, số điện thoại, email, địa chỉ, điểm tích lũy, ngày đăng ký

### 6. Quản lý Dịch vụ
- Thêm, sửa, xóa dịch vụ (xóa chỉ dành cho ADMIN)
- Tìm kiếm và lọc theo danh mục, trạng thái, giá
- Theo dõi: tên, mô tả, giá, thời lượng, danh mục, trạng thái

### 7. Quản lý Lịch Chăm sóc
- Thêm, sửa, xóa lịch chăm sóc (xóa chỉ dành cho ADMIN)
- Tìm kiếm và lọc theo ngày, hoạt động
- Sắp xếp theo ngày (tăng dần/giảm dần)
- Lọc theo: hôm nay, tuần này, tháng này, chọn ngày, tất cả
- Theo dõi: thú cưng, nhân viên, hoạt động, ngày, ghi chú

## Giao diện

Ứng dụng sử dụng Java Swing với các màn hình:

### Màn hình Đăng nhập
- Form nhập Username và Password
- Hiển thị thông tin tài khoản mặc định
- Hỗ trợ phím Enter để đăng nhập nhanh

### Màn hình Chính
- **Menu bar:** Hiển thị thông tin user hiện tại và menu "Tài khoản"
  - Menu "Đăng xuất"
- **Các Tab chính:**
  - **Quản lý thú cưng**: Thêm, sửa, xóa, tìm kiếm và lọc thú cưng
  - **Quản lý nhân viên**: Thêm, sửa, xóa, tìm kiếm và lọc nhân viên chăm sóc
  - **Quản lý khách hàng**: Thêm, sửa, xóa, tìm kiếm và lọc khách hàng
  - **Quản lý dịch vụ**: Thêm, sửa, xóa, tìm kiếm và lọc dịch vụ
  - **Quản lý lịch chăm sóc**: Thêm, sửa, xóa, tìm kiếm và lọc lịch chăm sóc

## Xử lý lỗi thường gặp

### Lỗi: "Missing sqlite-jdbc driver on classpath"
**Giải pháp:** Chạy `mvn clean compile`

### Lỗi: "Unsupported class file major version"
**Giải pháp:** Nâng cấp Java lên phiên bản 17 hoặc cao hơn

### Lỗi: "Maven not found"
**Giải pháp:** Cài đặt Maven và thêm vào PATH

### Lỗi: "Could not initialize database"
**Giải pháp:**
- Kiểm tra quyền ghi vào thư mục `petfarm/db/`
- Đảm bảo không có ứng dụng khác đang sử dụng database
- Xóa file database cũ và chạy lại ứng dụng

### Lỗi: "Foreign key constraint failed"
**Giải pháp:** Xóa database và tạo lại:
```bash
rm petfarm/db/petfarm.db  # macOS/Linux
del petfarm\db\petfarm.db  # Windows
```
Sau đó chạy lại ứng dụng.

## Tóm tắt các lệnh nhanh

### Chạy ứng dụng:
```bash
python3 build.py
# hoặc
mvn clean compile exec:java
```

### Build JAR và chạy:
```bash
mvn clean package
java -jar target/pet-manager-1.0.0.jar
```

### Reset database và chạy lại:
```bash
rm petfarm/db/petfarm.db && python3 build.py  # macOS/Linux
del petfarm\db\petfarm.db && python build.py   # Windows
```

## Lưu ý quan trọng

1. **Database tự động tạo:** Không cần cài đặt SQLite riêng, database sẽ được tạo tự động khi chạy ứng dụng lần đầu tại `petfarm/db/petfarm.db`.

2. **File script:** Dự án có sẵn file `build.py` để chạy nhanh trên cả Mac và Windows.

3. **Dữ liệu mẫu:** Khi chạy lần đầu, hệ thống sẽ tự động tạo:
   - 1 tài khoản ADMIN (`admin` / `admin123`)
   - 2 tài khoản STAFF (`staff1`, `staff2` / `staff123`)
   - 1 khách hàng mẫu
   - 1 thú cưng mẫu
   - 1 lịch chăm sóc mẫu

4. **Bảo mật:** Mật khẩu được hash bằng SHA-256 với salt, không lưu dạng plaintext.

5. **Format ngày:** Sử dụng định dạng `yyyy-MM-dd` (ví dụ: 2025-01-15).

6. **Phân quyền:** 
   - ADMIN có toàn quyền quản lý hệ thống
   - STAFF chỉ có thể xem và chỉnh sửa, không được xóa dữ liệu

## Tác giả

Dự án quản lý trại thú cưng sử dụng Java Swing và SQLite.

## License

Dự án này được tạo cho mục đích học tập.
