# 🚀 Hướng dẫn Chạy Nhanh

## Bước 1: Cài đặt Maven (nếu chưa có)

### macOS:
```bash
brew install maven
```

### Kiểm tra:
```bash
mvn -version
java -version
```

## Bước 2: Chạy dự án

### Cách đơn giản nhất (Unix/macOS):
```bash
./run.sh
```

### Hoặc chạy trực tiếp với Maven:
```bash
mvn clean compile
mvn exec:java
```

### Tạo JAR file để chạy độc lập:
```bash
mvn clean package
java -jar target/pet-manager-1.0.0.jar
```

## ✅ Cấu trúc dự án đã được thiết lập:

- ✓ `pom.xml` - File cấu hình Maven với SQLite JDBC dependency
- ✓ `src/main/java/petfarm/` - Tất cả source code đã được di chuyển vào cấu trúc Maven chuẩn
- ✓ `README.md` - Hướng dẫn chi tiết
- ✓ `INSTALL.md` - Hướng dẫn cài đặt Maven
- ✓ `run.sh` / `run.bat` - Script chạy dự án
- ✓ `.gitignore` - File ignore cho Git

## 📝 Lưu ý:

- Database SQLite sẽ tự động được tạo tại: `petfarm/db/petfarm.db`
- Yêu cầu: Java 17+ và Maven 3.6+

Xem `README.md` để biết thêm chi tiết!
