@echo off
REM Script chạy dự án Pet Farm Management cho Windows

echo === Pet Farm Management System ===
echo.

REM Kiểm tra Java
java -version >nul 2>&1
if errorlevel 1 (
    echo ❌ Java chưa được cài đặt. Vui lòng cài đặt JDK 17+
    pause
    exit /b 1
)

REM Kiểm tra Maven
mvn -version >nul 2>&1
if errorlevel 1 (
    echo ❌ Maven chưa được cài đặt.
    echo Vui lòng cài đặt Maven từ https://maven.apache.org/download.cgi
    pause
    exit /b 1
)

echo ✓ Java và Maven đã sẵn sàng
echo.

REM Build và chạy
echo Đang build dự án...
call mvn clean compile

if errorlevel 1 (
    echo.
    echo ❌ Build thất bại. Vui lòng kiểm tra lỗi ở trên.
    pause
    exit /b 1
)

echo.
echo ✓ Build thành công!
echo Đang khởi động ứng dụng...
echo.
call mvn exec:java

pause
