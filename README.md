# Hệ thống Quản lý Trại Thú cưng (Pet Farm Management)

Ứng dụng desktop Java Swing để quản lý thú cưng, nhân viên chăm sóc và lịch chăm sóc sử dụng SQLite. Hệ thống có tính năng đăng nhập, đăng ký tài khoản và phân quyền theo vai trò (ADMIN/STAFF).

## Yêu cầu hệ thống

- **Java**: JDK 17 hoặc cao hơn
- **Maven**: 3.6+ (để build và quản lý dependencies)
- **Hệ điều hành**: Windows, macOS, hoặc Linux

## Cấu trúc dự án

```
pet_manager/
├── src/main/java/petfarm/
│   ├── db/              # Quản lý kết nối SQLite và khởi tạo database
│   ├── model/           # Các lớp model (Pet, Caretaker, CareSchedule, User)
│   ├── repository/      # Data Access Layer (CRUD operations)
│   ├── service/         # Business Logic Layer
│   ├── util/            # Tiện ích (DateUtils, PasswordUtil, AuthContext)
│   └── view/            # Giao diện Swing (PetFarmApp, LoginDialog, RegisterDialog)
├── petfarm/             # Thư mục chứa database SQLite (tự động tạo)
│   └── db/
│       └── petfarm.db
├── pom.xml              # File cấu hình Maven
└── README.md            # File này
```

## Cài đặt và Chạy

### Cách 1: Sử dụng Maven (Khuyến nghị)

1. **Kiểm tra Java và Maven đã cài đặt:**
   ```bash
   java -version
   mvn -version
   ```

2. **Build dự án:**
   ```bash
   mvn clean compile
   ```

3. **Chạy ứng dụng:**
   ```bash
   mvn exec:java
   ```

   Hoặc sau khi compile:
   ```bash
   mvn exec:java -Dexec.mainClass="petfarm.view.PetFarmApp"
   ```

4. **Tạo JAR file (tùy chọn):**
   ```bash
   mvn clean package
   ```
   
   File JAR sẽ được tạo tại: `target/pet-manager-1.0.0.jar`
   
   Chạy JAR:
   ```bash
   java -jar target/pet-manager-1.0.0.jar
   ```

### Cách 2: Chạy trực tiếp với javac và java (không cần Maven)

1. **Tải SQLite JDBC driver:**
   ```bash
   mkdir -p lib
   cd lib
   curl -O https://repo1.maven.org/maven2/org/xerial/sqlite-jdbc/3.45.2.0/sqlite-jdbc-3.45.2.0.jar
   cd ..
   ```

2. **Compile:**
   ```bash
   javac -cp "lib/sqlite-jdbc-3.45.2.0.jar:." -d build src/main/java/petfarm/**/*.java
   ```

3. **Chạy:**
   ```bash
   java -cp "lib/sqlite-jdbc-3.45.2.0.jar:build" petfarm.view.PetFarmApp
   ```

## Đăng nhập

Khi khởi động ứng dụng, bạn sẽ thấy màn hình đăng nhập:

- **Tài khoản mặc định:**
  - Username: `admin`
  - Password: `admin123`
  - Vai trò: `ADMIN`

- **Tính năng đăng nhập:**
  - Nhập Username và Password
  - Mật khẩu được hash bằng SHA-256 với salt (không lưu plaintext)
  - Xác thực thông tin đăng nhập
  - Chuyển sang giao diện chính sau khi đăng nhập thành công

## Database

- Database SQLite sẽ được tự động tạo tại: `petfarm/db/petfarm.db`
- Khi chạy lần đầu, hệ thống sẽ tự động:
  - Tạo các bảng (users, caretakers, pets, care_schedule)
  - Tạo tài khoản ADMIN mặc định (username: `admin`, password: `admin123`)
  - Thêm dữ liệu mẫu nếu chưa có

## Tính năng

### 1. Đăng nhập và Quản lý Tài khoản
- **Đăng nhập:** Yêu cầu Username và Password để truy cập hệ thống
- **Đăng ký tài khoản:** Chỉ ADMIN được phép tạo tài khoản mới
  - Nhập Username (tối thiểu 3 ký tự)
  - Nhập Password và xác nhận mật khẩu (tối thiểu 4 ký tự)
  - Chọn vai trò: ADMIN hoặc STAFF
- **Bảo mật:** Mật khẩu được hash bằng SHA-256 với salt, không lưu dạng plaintext
- **Đăng xuất:** Menu "Tài khoản" → "Đăng xuất"

### 2. Phân quyền (Authorization)

#### ADMIN (Quản trị viên)
- Quyền quản lý toàn bộ hệ thống
- Có thể tạo tài khoản mới
- Có thể thêm, sửa, **xóa** tất cả dữ liệu
- Truy cập đầy đủ tất cả tính năng

#### STAFF (Nhân viên)
- Quyền xem và chỉnh sửa hạn chế
- Có thể thêm, sửa dữ liệu
- **KHÔNG được phép xóa** dữ liệu (nút "Xóa" bị vô hiệu hóa)
- Không thể tạo tài khoản mới

### 3. Quản lý Thú cưng
- Thêm, sửa, xóa thông tin thú cưng (xóa chỉ dành cho ADMIN)
- Theo dõi: tên, loài, tuổi, sức khỏe, ngày nhập, khẩu phần, nhân viên phụ trách

### 4. Quản lý Nhân viên Chăm sóc
- Thêm, sửa, xóa nhân viên (xóa chỉ dành cho ADMIN)
- Theo dõi: tên, số điện thoại, ca làm việc

### 5. Quản lý Lịch Chăm sóc
- Tạo lịch chăm sóc cho thú cưng
- Gán nhân viên cho từng hoạt động
- Ghi chú và ngày thực hiện
- Xóa lịch chăm sóc (chỉ dành cho ADMIN)

## Giao diện

Ứng dụng sử dụng Java Swing với các màn hình:

### Màn hình Đăng nhập
- Form nhập Username và Password
- Hiển thị thông tin tài khoản mặc định
- Hỗ trợ phím Enter để đăng nhập nhanh

### Màn hình Chính
- **Menu bar:** Hiển thị thông tin user hiện tại và menu "Tài khoản"
  - Menu "Đăng ký tài khoản" (chỉ hiển thị cho ADMIN)
  - Menu "Đăng xuất"
- **3 Tab chính:**
  - **Tab 1**: Quản lý thú cưng
  - **Tab 2**: Nhân viên chăm sóc
  - **Tab 3**: Lịch chăm sóc

### Màn hình Đăng ký (Chỉ ADMIN)
- Form tạo tài khoản mới
- Nhập Username, Password, Xác nhận mật khẩu
- Chọn vai trò (ADMIN hoặc STAFF)

## Lưu ý

- **Database:** Sẽ được tạo tự động ở thư mục `petfarm/db/` trong thư mục làm việc hiện tại
- **Format ngày:** `yyyy-MM-dd` (ví dụ: 2025-01-15)
- **Java:** Đảm bảo Java 17+ đã được cài đặt
- **Bảo mật:** 
  - Mật khẩu được hash bằng SHA-256 với salt, không lưu dạng plaintext
  - Mỗi mật khẩu có salt riêng để tăng cường bảo mật
- **Phân quyền:** 
  - STAFF không thể xóa dữ liệu (nút "Xóa" bị vô hiệu hóa)
  - Chỉ ADMIN mới có thể tạo tài khoản mới

## Xử lý lỗi thường gặp

### Lỗi: "Missing sqlite-jdbc driver on classpath"
**Giải pháp**: Đảm bảo đã chạy `mvn clean compile` hoặc tải driver SQLite vào thư mục `lib/`

### Lỗi: "Unsupported class file major version"
**Giải pháp**: Nâng cấp Java lên phiên bản 17 hoặc cao hơn

### Lỗi: "Maven not found"
**Giải pháp**: Cài đặt Maven từ https://maven.apache.org/download.cgi hoặc sử dụng cách 2 (javac/java)

## Tác giả

Dự án quản lý trại thú cưng sử dụng Java Swing và SQLite.

## License

Dự án này được tạo cho mục đích học tập.
