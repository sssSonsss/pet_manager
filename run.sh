#!/bin/bash

# Script chạy dự án Pet Farm Management

echo "=== Pet Farm Management System ==="
echo ""

# Kiểm tra Java
if ! command -v java &> /dev/null; then
    echo "❌ Java chưa được cài đặt. Vui lòng cài đặt JDK 17+"
    exit 1
fi

# Kiểm tra Maven
if ! command -v mvn &> /dev/null; then
    echo "❌ Maven chưa được cài đặt. Đang sử dụng cách thay thế..."
    echo ""
    echo "Vui lòng chạy: mvn clean compile && mvn exec:java"
    exit 1
fi

echo "✓ Java và Maven đã sẵn sàng"
echo ""

# Build và chạy
echo "Đang build dự án..."
mvn clean compile

if [ $? -eq 0 ]; then
    echo ""
    echo "✓ Build thành công!"
    echo "Đang khởi động ứng dụng..."
    echo ""
    mvn exec:java
else
    echo ""
    echo "❌ Build thất bại. Vui lòng kiểm tra lỗi ở trên."
    exit 1
fi
