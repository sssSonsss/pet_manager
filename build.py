#!/usr/bin/env python3
# -*- coding: utf-8 -*-
"""
Script build và chạy dự án Pet Farm Management
Hỗ trợ cả Windows và Mac/Linux
"""

import os
import sys
import subprocess
import platform

def print_header():
    print("=" * 50)
    print("  Pet Farm Management System")
    print("=" * 50)
    print()

def check_command(command, name, install_url=None):
    """Kiểm tra xem command có tồn tại không"""
    try:
        result = subprocess.run(
            [command, "--version"],
            stdout=subprocess.PIPE,
            stderr=subprocess.PIPE,
            text=True
        )
        if result.returncode == 0:
            version = result.stdout.strip().split('\n')[0]
            print(f"✓ {name} đã sẵn sàng: {version}")
            return True
    except FileNotFoundError:
        pass
    
    print(f"❌ {name} chưa được cài đặt.")
    if install_url:
        print(f"   Vui lòng cài đặt từ: {install_url}")
    return False

def run_command(command, description, check=True):
    """Chạy một command và hiển thị kết quả"""
    print(f"\n{description}...")
    print("-" * 50)
    
    # Chạy command
    result = subprocess.run(command, shell=True)
    
    if result.returncode != 0:
        if check:
            print(f"\n❌ {description} thất bại!")
            sys.exit(1)
        return False
    
    print(f"\n✓ {description} thành công!")
    return True

def main():
    print_header()
    
    # Kiểm tra Java
    if not check_command("java", "Java", "https://adoptium.net/"):
        print("\nVui lòng cài đặt JDK 17+ trước khi tiếp tục.")
        sys.exit(1)
    
    # Kiểm tra Maven
    if not check_command("mvn", "Maven", "https://maven.apache.org/download.cgi"):
        print("\nVui lòng cài đặt Maven trước khi tiếp tục.")
        sys.exit(1)
    
    print()
    
    # Build project
    if not run_command("mvn clean compile", "Đang build dự án"):
        sys.exit(1)
    
    # Chạy ứng dụng
    print("\n" + "=" * 50)
    print("Đang khởi động ứng dụng...")
    print("=" * 50)
    print()
    
    # Chạy và không check return code vì ứng dụng có thể thoát bình thường
    subprocess.run("mvn exec:java", shell=True)
    
    print("\n" + "=" * 50)
    print("Ứng dụng đã đóng.")
    print("=" * 50)

if __name__ == "__main__":
    try:
        main()
    except KeyboardInterrupt:
        print("\n\nĐã hủy bởi người dùng.")
        sys.exit(0)
    except Exception as e:
        print(f"\n❌ Lỗi: {e}")
        sys.exit(1)

