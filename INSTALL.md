# Hướng dẫn Cài đặt Maven (Nếu chưa có)

## macOS (sử dụng Homebrew - Khuyến nghị)

```bash
brew install maven
```

Sau khi cài đặt, kiểm tra:
```bash
mvn -version
```

## Windows

1. Tải Maven từ: https://maven.apache.org/download.cgi
2. Giải nén vào thư mục (ví dụ: `C:\Program Files\Apache\maven`)
3. Thêm Maven vào PATH:
   - Mở "Environment Variables"
   - Thêm `C:\Program Files\Apache\maven\bin` vào PATH
4. Mở Command Prompt mới và chạy:
```cmd
mvn -version
```

## Linux (Ubuntu/Debian)

```bash
sudo apt update
sudo apt install maven
```

## Sau khi cài đặt Maven

Chạy dự án bằng một trong các cách sau:

### Cách 1: Sử dụng script (Unix/macOS)
```bash
./run.sh
```

### Cách 2: Sử dụng script (Windows)
```cmd
run.bat
```

### Cách 3: Chạy trực tiếp với Maven
```bash
mvn clean compile
mvn exec:java
```

### Cách 4: Tạo JAR và chạy
```bash
mvn clean package
java -jar target/pet-manager-1.0.0.jar
```
