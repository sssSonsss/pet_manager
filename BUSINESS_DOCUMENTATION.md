# Tài Liệu Nghiệp Vụ
## Hệ Thống Quản Lý Trại Thú Cưng (Pet Farm Management System)

**Version**: 1.0.0  
**Ngày tạo**: 2025-12-01  
**Tác giả**: Business Analysis Team  
**Trạng thái**: Approved

---

## 📑 Mục Lục

1. [Tổng Quan Dự Án](#1-tổng-quan-dự-án)
2. [Mục Tiêu Nghiệp Vụ](#2-mục-tiêu-nghiệp-vụ)
3. [User Personas](#3-user-personas)
4. [User Stories](#4-user-stories)
5. [Use Cases](#5-use-cases)
6. [Business Rules](#6-business-rules)
7. [Workflows & Business Processes](#7-workflows--business-processes)
8. [Functional Requirements](#8-functional-requirements)
9. [Non-Functional Requirements](#9-non-functional-requirements)
10. [Acceptance Criteria](#10-acceptance-criteria)
11. [Business Glossary](#11-business-glossary)
12. [Assumptions & Constraints](#12-assumptions--constraints)

---

## 1. Tổng Quan Dự Án

### 1.1. Mô Tả Nghiệp Vụ

Hệ Thống Quản Lý Trại Thú Cưng là một giải pháp phần mềm được thiết kế để hỗ trợ các trung tâm chăm sóc thú cưng quản lý toàn bộ hoạt động kinh doanh của mình. Hệ thống giúp tự động hóa các quy trình nghiệp vụ, tăng hiệu quả quản lý, và cải thiện chất lượng dịch vụ chăm sóc thú cưng.

### 1.2. Vấn Đề Nghiệp Vụ

**Vấn đề hiện tại:**
- Quản lý thông tin khách hàng và thú cưng bằng sổ sách thủ công, dễ mất mát và khó tìm kiếm
- Không có hệ thống theo dõi lịch chăm sóc, dễ bỏ sót các hoạt động quan trọng
- Khó khăn trong việc quản lý nhân viên và phân công công việc
- Không có hệ thống tích điểm khách hàng, khó khăn trong việc giữ chân khách hàng
- Thiếu thông tin tổng hợp về dịch vụ và doanh thu

**Giải pháp:**
- Hệ thống quản lý tập trung, số hóa toàn bộ thông tin
- Tự động hóa lập lịch chăm sóc
- Quản lý nhân viên và phân quyền rõ ràng
- Hệ thống tích điểm khách hàng tự động
- Tìm kiếm và lọc dữ liệu nhanh chóng

### 1.3. Phạm Vi Dự Án

**Trong phạm vi:**
- ✅ Quản lý thông tin khách hàng và thú cưng
- ✅ Quản lý nhân viên và tài khoản đăng nhập
- ✅ Quản lý dịch vụ và giá cả
- ✅ Lập lịch chăm sóc thú cưng
- ✅ Hệ thống tích điểm khách hàng
- ✅ Tìm kiếm và lọc dữ liệu
- ✅ Phân quyền ADMIN và STAFF

**Ngoài phạm vi:**
- ❌ Thanh toán trực tuyến
- ❌ Ứng dụng di động
- ❌ Tích hợp với hệ thống bên thứ ba
- ❌ Báo cáo và thống kê tự động
- ❌ Quản lý kho hàng
- ❌ Đặt lịch dịch vụ (Service Booking)
- ❌ Quản lý lịch làm việc nhân viên (Work Schedule)

---

## 2. Mục Tiêu Nghiệp Vụ

### 2.1. Mục Tiêu Chính

1. **Tăng hiệu quả quản lý**: Giảm 70% thời gian xử lý thủ công
2. **Cải thiện chất lượng dịch vụ**: Đảm bảo không bỏ sót lịch chăm sóc
3. **Tăng sự hài lòng khách hàng**: Hệ thống tích điểm và quản lý tốt hơn
4. **Tối ưu hóa nguồn lực**: Phân công nhân viên hợp lý
5. **Bảo mật dữ liệu**: Bảo vệ thông tin khách hàng và thú cưng

### 2.2. KPI (Key Performance Indicators)

- **Thời gian xử lý**: Giảm từ 30 phút xuống 10 phút cho mỗi giao dịch
- **Độ chính xác**: Đạt 99% độ chính xác trong quản lý lịch chăm sóc
- **Sự hài lòng khách hàng**: Tăng 40% điểm đánh giá
- **Hiệu quả nhân viên**: Tăng 50% năng suất làm việc
- **Tỷ lệ lỗi**: Giảm 80% lỗi do xử lý thủ công

---

## 3. User Personas

### 3.1. Persona 1: Quản Lý Trung Tâm (ADMIN)

**Tên**: Nguyễn Văn A  
**Vai trò**: Quản lý trung tâm thú cưng  
**Tuổi**: 35-50  
**Kinh nghiệm**: 5+ năm quản lý

**Mục tiêu:**
- Quản lý toàn bộ hoạt động của trung tâm
- Theo dõi hiệu quả làm việc của nhân viên
- Đưa ra quyết định dựa trên dữ liệu hiện có
- Đảm bảo chất lượng dịch vụ

**Nhu cầu:**
- Xem tổng quan toàn bộ hệ thống
- Quản lý nhân viên và phân quyền
- Tìm kiếm và lọc dữ liệu nhanh chóng
- Có quyền kiểm soát đầy đủ (thêm, sửa, xóa)

**Pain Points:**
- Không có thời gian để xử lý từng chi tiết nhỏ
- Cần thông tin tổng hợp nhanh chóng
- Cần đảm bảo tính bảo mật và kiểm soát

### 3.2. Persona 2: Nhân Viên Chăm Sóc (STAFF)

**Tên**: Trần Thị B  
**Vai trò**: Nhân viên chăm sóc thú cưng  
**Tuổi**: 20-35  
**Kinh nghiệm**: 1-3 năm

**Mục tiêu:**
- Thực hiện các nhiệm vụ chăm sóc thú cưng
- Cập nhật thông tin về thú cưng
- Xem lịch làm việc của mình
- Ghi chú về tình trạng thú cưng

**Nhu cầu:**
- Giao diện đơn giản, dễ sử dụng
- Xem thông tin nhanh chóng
- Cập nhật dữ liệu dễ dàng
- Không cần quyền quản lý phức tạp

**Pain Points:**
- Sợ xóa nhầm dữ liệu quan trọng
- Cần hướng dẫn rõ ràng
- Muốn tập trung vào công việc chăm sóc

---

## 4. User Stories

### 4.1. Epic 1: Quản Lý Khách Hàng

#### Story 1.1: Đăng Ký Khách Hàng Mới
**Là một** Quản lý trung tâm (ADMIN)  
**Tôi muốn** thêm thông tin khách hàng mới vào hệ thống  
**Để** có thể theo dõi và quản lý khách hàng một cách chuyên nghiệp

**Acceptance Criteria:**
- ✅ Có thể nhập đầy đủ thông tin: tên, số điện thoại, email, địa chỉ
- ✅ Hệ thống tự động gán điểm tích lũy = 0 khi tạo mới
- ✅ Hệ thống tự động gán ngày đăng ký = ngày hiện tại
- ✅ Tên khách hàng là bắt buộc
- ✅ Hiển thị thông báo thành công sau khi thêm

#### Story 1.2: Tìm Kiếm Khách Hàng
**Là một** Nhân viên hoặc Quản lý  
**Tôi muốn** tìm kiếm khách hàng theo tên, email, hoặc số điện thoại  
**Để** có thể tìm thông tin khách hàng nhanh chóng

**Acceptance Criteria:**
- ✅ Tìm kiếm không phân biệt hoa thường
- ✅ Tìm kiếm theo tên, email, hoặc số điện thoại
- ✅ Hiển thị kết quả ngay lập tức khi nhập
- ✅ Hiển thị thông báo nếu không tìm thấy

#### Story 1.3: Quản Lý Điểm Tích Lũy
**Là một** Quản lý trung tâm  
**Tôi muốn** thêm hoặc trừ điểm tích lũy cho khách hàng  
**Để** khuyến khích khách hàng quay lại và tăng sự trung thành

**Acceptance Criteria:**
- ✅ Có thể thêm điểm tích lũy
- ✅ Có thể trừ điểm tích lũy (không được âm)
- ✅ Điểm tích lũy được cập nhật ngay lập tức
- ✅ Hiển thị lịch sử thay đổi điểm (tùy chọn)

### 4.2. Epic 2: Quản Lý Thú Cưng

#### Story 2.1: Đăng Ký Thú Cưng Mới
**Là một** Quản lý trung tâm  
**Tôi muốn** thêm thông tin thú cưng mới và liên kết với khách hàng  
**Để** có thể theo dõi và chăm sóc thú cưng đúng cách

**Acceptance Criteria:**
- ✅ Phải chọn khách hàng sở hữu thú cưng (bắt buộc)
- ✅ Có thể gán nhân viên phụ trách
- ✅ Nhập đầy đủ thông tin: tên, loài, tuổi, sức khỏe, ngày nhập, khẩu phần
- ✅ Tên thú cưng là bắt buộc
- ✅ Hiển thị danh sách khách hàng để chọn

#### Story 2.2: Xem Thú Cưng Của Khách Hàng
**Là một** Nhân viên hoặc Quản lý  
**Tôi muốn** xem tất cả thú cưng của một khách hàng  
**Để** hiểu rõ hơn về khách hàng và thú cưng của họ

**Acceptance Criteria:**
- ✅ Chọn khách hàng từ danh sách
- ✅ Hiển thị tất cả thú cưng của khách hàng đó
- ✅ Hiển thị thông tin chi tiết: tên, loài, tuổi, sức khỏe
- ✅ Hiển thị thông báo nếu khách hàng chưa có thú cưng

#### Story 2.3: Lọc Thú Cưng Theo Loài
**Là một** Nhân viên  
**Tôi muốn** lọc thú cưng theo loài  
**Để** dễ dàng quản lý và chăm sóc theo từng loại

**Acceptance Criteria:**
- ✅ Dropdown hiển thị tất cả loài có trong hệ thống
- ✅ Có option "Tất cả loài" để xem tất cả
- ✅ Kết quả lọc được cập nhật ngay lập tức

### 4.3. Epic 3: Quản Lý Nhân Viên

#### Story 3.1: Tạo Tài Khoản Nhân Viên
**Là một** Quản lý trung tâm  
**Tôi muốn** tạo tài khoản đăng nhập cho nhân viên mới  
**Để** nhân viên có thể đăng nhập và sử dụng hệ thống

**Acceptance Criteria:**
- ✅ Khi thêm nhân viên, phải nhập username và password
- ✅ Hệ thống tự động tạo tài khoản STAFF
- ✅ Username phải duy nhất
- ✅ Password phải có độ dài tối thiểu
- ✅ Thông báo username và password cho nhân viên

#### Story 3.2: Cập Nhật Thông Tin Nhân Viên
**Là một** Quản lý trung tâm  
**Tôi muốn** cập nhật thông tin nhân viên  
**Để** đảm bảo thông tin luôn chính xác và cập nhật

**Acceptance Criteria:**
- ✅ Có thể cập nhật tên, email, ngày sinh, ca làm việc
- ✅ Username không thể thay đổi
- ✅ Có thể đổi mật khẩu (tùy chọn)
- ✅ Thông tin được đồng bộ với tài khoản đăng nhập

### 4.4. Epic 4: Quản Lý Dịch Vụ

#### Story 4.1: Thêm Dịch Vụ Mới
**Là một** Quản lý trung tâm  
**Tôi muốn** thêm dịch vụ mới vào hệ thống  
**Để** có thể cung cấp thêm các dịch vụ cho khách hàng

**Acceptance Criteria:**
- ✅ Nhập đầy đủ thông tin: tên, mô tả, giá, thời gian, loại
- ✅ Tên dịch vụ và giá là bắt buộc
- ✅ Có thể đặt trạng thái hoạt động/tạm dừng
- ✅ Giá phải là số dương

#### Story 4.2: Lọc Dịch Vụ Theo Giá
**Là một** Nhân viên hoặc Quản lý  
**Tôi muốn** lọc dịch vụ theo khoảng giá  
**Để** dễ dàng tìm dịch vụ phù hợp với ngân sách

**Acceptance Criteria:**
- ✅ Có các khoảng giá: Dưới 100k, 100k-500k, 500k-1M, Trên 1M
- ✅ Kết quả lọc chính xác theo khoảng giá
- ✅ Có thể kết hợp với tìm kiếm

### 4.5. Epic 5: Quản Lý Lịch Chăm Sóc

#### Story 5.1: Tạo Lịch Chăm Sóc
**Là một** Quản lý trung tâm  
**Tôi muốn** tạo lịch chăm sóc cho thú cưng  
**Để** đảm bảo không bỏ sót các hoạt động chăm sóc quan trọng

**Acceptance Criteria:**
- ✅ Phải chọn thú cưng và nhân viên (bắt buộc)
- ✅ Phải nhập hoạt động và ngày (bắt buộc)
- ✅ Có thể thêm ghi chú
- ✅ Hiển thị lịch trong danh sách

#### Story 5.2: Xem Lịch Theo Tuần
**Là một** Nhân viên  
**Tôi muốn** xem lịch chăm sóc trong tuần này  
**Để** biết công việc của mình trong tuần

**Acceptance Criteria:**
- ✅ Có filter "Tuần này"
- ✅ Hiển thị tất cả lịch từ thứ 2 đến chủ nhật của tuần hiện tại
- ✅ Sắp xếp theo ngày

#### Story 5.3: Tìm Kiếm Lịch Chăm Sóc
**Là một** Nhân viên hoặc Quản lý  
**Tôi muốn** tìm kiếm lịch chăm sóc theo tên thú cưng hoặc nhân viên  
**Để** tìm nhanh lịch cần thiết

**Acceptance Criteria:**
- ✅ Tìm kiếm theo tên thú cưng, nhân viên, hoạt động
- ✅ Tìm kiếm không phân biệt hoa thường
- ✅ Kết quả được cập nhật ngay lập tức

---

## 5. Use Cases

### 5.1. Use Case 1: Đăng Nhập Hệ Thống

**Actor**: ADMIN, STAFF  
**Precondition**: Ứng dụng đã được khởi động

**Main Flow:**
1. Hệ thống hiển thị màn hình đăng nhập
2. Người dùng nhập username và password
3. Người dùng click "Đăng nhập"
4. Hệ thống xác thực thông tin
5. Hệ thống kiểm tra quyền truy cập
6. Hệ thống hiển thị màn hình chính tương ứng với quyền

**Alternative Flow 5a: Thông tin đăng nhập sai**
- 5a.1. Hệ thống hiển thị thông báo lỗi
- 5a.2. Quay lại bước 2

**Postcondition**: Người dùng đã đăng nhập thành công

### 5.2. Use Case 2: Thêm Khách Hàng Mới

**Actor**: ADMIN  
**Precondition**: Đã đăng nhập với quyền ADMIN

**Main Flow:**
1. ADMIN chọn tab "Khách hàng"
2. ADMIN click nút "Thêm"
3. Hệ thống hiển thị dialog thêm khách hàng
4. ADMIN nhập thông tin: tên (bắt buộc), số điện thoại, email, địa chỉ
5. ADMIN click "Lưu"
6. Hệ thống kiểm tra dữ liệu hợp lệ
7. Hệ thống lưu khách hàng mới
8. Hệ thống hiển thị thông báo thành công
9. Hệ thống cập nhật danh sách khách hàng

**Alternative Flow 6a: Dữ liệu không hợp lệ**
- 6a.1. Hệ thống hiển thị thông báo lỗi
- 6a.2. Quay lại bước 4

**Postcondition**: Khách hàng mới đã được thêm vào hệ thống

### 5.3. Use Case 3: Thêm Thú Cưng Mới

**Actor**: ADMIN  
**Precondition**: Đã đăng nhập với quyền ADMIN, đã có ít nhất 1 khách hàng

**Main Flow:**
1. ADMIN chọn tab "Quản lý thú cưng"
2. ADMIN click nút "Thêm"
3. Hệ thống hiển thị dialog thêm thú cưng
4. ADMIN chọn khách hàng từ dropdown (bắt buộc)
5. ADMIN nhập thông tin: tên (bắt buộc), loài, tuổi, sức khỏe, ngày nhập, khẩu phần
6. ADMIN chọn nhân viên phụ trách (tùy chọn)
7. ADMIN click "Lưu"
8. Hệ thống kiểm tra dữ liệu hợp lệ
9. Hệ thống lưu thú cưng mới
10. Hệ thống hiển thị thông báo thành công
11. Hệ thống cập nhật danh sách thú cưng

**Alternative Flow 4a: Chưa có khách hàng**
- 4a.1. Hệ thống hiển thị thông báo "Vui lòng thêm khách hàng trước"
- 4a.2. Use case kết thúc

**Alternative Flow 8a: Dữ liệu không hợp lệ**
- 8a.1. Hệ thống hiển thị thông báo lỗi
- 8a.2. Quay lại bước 4

**Postcondition**: Thú cưng mới đã được thêm và liên kết với khách hàng

### 5.4. Use Case 4: Tạo Tài Khoản Nhân Viên

**Actor**: ADMIN  
**Precondition**: Đã đăng nhập với quyền ADMIN

**Main Flow:**
1. ADMIN chọn tab "Nhân viên chăm sóc"
2. ADMIN click nút "Thêm"
3. Hệ thống hiển thị dialog thêm nhân viên
4. ADMIN nhập thông tin nhân viên: tên, email, ngày sinh, ca làm việc
5. ADMIN nhập username (bắt buộc, duy nhất)
6. ADMIN nhập password (bắt buộc)
7. ADMIN click "Lưu"
8. Hệ thống kiểm tra username chưa tồn tại
9. Hệ thống tạo tài khoản STAFF với username và password
10. Hệ thống tạo bản ghi nhân viên và liên kết với tài khoản
11. Hệ thống hiển thị thông báo thành công với username và password
12. Hệ thống cập nhật danh sách nhân viên

**Alternative Flow 8a: Username đã tồn tại**
- 8a.1. Hệ thống hiển thị thông báo "Username đã tồn tại"
- 8a.2. Quay lại bước 5

**Postcondition**: Nhân viên mới và tài khoản STAFF đã được tạo

### 5.5. Use Case 5: Tìm Kiếm và Lọc Dữ Liệu

**Actor**: ADMIN, STAFF  
**Precondition**: Đã đăng nhập

**Main Flow:**
1. Người dùng chọn tab bất kỳ (Khách hàng, Thú cưng, v.v.)
2. Người dùng nhập từ khóa vào ô tìm kiếm
3. Hệ thống lọc dữ liệu theo từ khóa
4. Hệ thống hiển thị kết quả ngay lập tức
5. Người dùng có thể chọn thêm bộ lọc (nếu có)
6. Hệ thống kết hợp tìm kiếm và lọc
7. Hệ thống hiển thị kết quả cuối cùng

**Alternative Flow 4a: Không tìm thấy kết quả**
- 4a.1. Hệ thống hiển thị "Không tìm thấy kết quả"
- 4a.2. Người dùng có thể xóa bộ lọc và tìm lại

**Postcondition**: Dữ liệu được lọc và hiển thị theo yêu cầu

---

## 6. Business Rules

### 6.1. Quy Tắc Quản Lý Khách Hàng

**BR-001**: Mỗi khách hàng phải có tên (bắt buộc)  
**BR-002**: Điểm tích lũy mặc định = 0 khi tạo khách hàng mới  
**BR-003**: Điểm tích lũy không được âm  
**BR-004**: Ngày đăng ký mặc định = ngày hiện tại  
**BR-005**: Chỉ ADMIN mới được thêm, sửa, xóa khách hàng

### 6.2. Quy Tắc Quản Lý Thú Cưng

**BR-101**: Mỗi thú cưng phải thuộc về một khách hàng (bắt buộc)  
**BR-102**: Tên thú cưng là bắt buộc  
**BR-103**: Một khách hàng có thể có nhiều thú cưng  
**BR-104**: Một thú cưng chỉ thuộc về một khách hàng  
**BR-105**: Chỉ ADMIN mới được thêm, sửa, xóa thú cưng

### 6.3. Quy Tắc Quản Lý Nhân Viên

**BR-201**: Mỗi nhân viên phải có tài khoản đăng nhập (tự động tạo)  
**BR-202**: Username phải duy nhất trong hệ thống  
**BR-203**: Username không thể thay đổi sau khi tạo  
**BR-204**: Password phải có độ dài tối thiểu 4 ký tự  
**BR-205**: Khi xóa nhân viên, tài khoản liên kết cũng bị xóa  
**BR-206**: Chỉ ADMIN mới được thêm, sửa, xóa nhân viên

### 6.4. Quy Tắc Quản Lý Dịch Vụ

**BR-301**: Tên dịch vụ là bắt buộc  
**BR-302**: Giá dịch vụ phải là số dương  
**BR-303**: Trạng thái mặc định = "Hoạt động"  
**BR-304**: Chỉ ADMIN mới được thêm, sửa, xóa dịch vụ

### 6.5. Quy Tắc Quản Lý Lịch Chăm Sóc

**BR-401**: Mỗi lịch chăm sóc phải có thú cưng, nhân viên, hoạt động, và ngày (tất cả bắt buộc)  
**BR-402**: Ngày không được là quá khứ (có thể nới lỏng tùy nghiệp vụ)  
**BR-403**: Chỉ ADMIN mới được thêm, sửa, xóa lịch chăm sóc

### 6.6. Quy Tắc Phân Quyền

**BR-501**: ADMIN có quyền đầy đủ: xem, thêm, sửa, xóa tất cả dữ liệu  
**BR-502**: STAFF chỉ có quyền xem, không được thêm, sửa, xóa  
**BR-503**: STAFF không thể tạo tài khoản mới  
**BR-504**: Mỗi người dùng chỉ có một vai trò (ADMIN hoặc STAFF)

### 6.7. Quy Tắc Bảo Mật

**BR-601**: Mật khẩu phải được hash bằng SHA-256 với salt  
**BR-602**: Mật khẩu không được lưu dạng plaintext  
**BR-603**: Mỗi mật khẩu có salt riêng  
**BR-604**: Session phải được quản lý an toàn

---

## 7. Workflows & Business Processes

### 7.1. Quy Trình Đăng Ký Khách Hàng Mới

```
┌─────────────┐
│  Khách hàng │
│   đến trung │
│     tâm     │
└──────┬──────┘
       │
       ▼
┌─────────────────┐
│ ADMIN tiếp nhận │
│  thông tin KH    │
└──────┬──────────┘
       │
       ▼
┌─────────────────┐
│ Mở hệ thống và  │
│ chọn "Thêm KH"  │
└──────┬──────────┘
       │
       ▼
┌─────────────────┐
│ Nhập thông tin: │
│ - Tên (bắt buộc)│
│ - SĐT, Email    │
│ - Địa chỉ       │
└──────┬──────────┘
       │
       ▼
┌─────────────────┐
│ Hệ thống tự động│
│ - Điểm = 0      │
│ - Ngày = hôm nay│
└──────┬──────────┘
       │
       ▼
┌─────────────────┐
│ Lưu và hiển thị │
│ thông báo thành │
│      công       │
└─────────────────┘
```

### 7.2. Quy Trình Đăng Ký Thú Cưng Mới

```
┌─────────────┐
│ Khách hàng  │
│ đưa thú cưng│
│   đến trung │
│     tâm     │
└──────┬──────┘
       │
       ▼
┌─────────────────┐
│ ADMIN kiểm tra  │
│ KH đã có trong  │
│    hệ thống?    │
└──────┬──────────┘
       │
   ┌───┴───┐
   │  Có   │   Không
   │       │
   ▼       ▼
┌─────┐ ┌─────────────┐
│ Tiếp│ │ Thực hiện    │
│ tục │ │ quy trình    │
│     │ │ đăng ký KH   │
└──┬──┘ └──────┬───────┘
   │           │
   └─────┬─────┘
         │
         ▼
┌─────────────────┐
│ Chọn tab "Thú   │
│     cưng"       │
└──────┬──────────┘
       │
       ▼
┌─────────────────┐
│ Click "Thêm" và │
│ chọn KH từ      │
│   dropdown      │
└──────┬──────────┘
       │
       ▼
┌─────────────────┐
│ Nhập thông tin: │
│ - Tên (bắt buộc)│
│ - Loài, tuổi    │
│ - Sức khỏe      │
│ - Ngày nhập     │
│ - Khẩu phần     │
└──────┬──────────┘
       │
       ▼
┌─────────────────┐
│ Chọn nhân viên  │
│  phụ trách (tùy │
│      chọn)      │
└──────┬──────────┘
       │
       ▼
┌─────────────────┐
│ Lưu và liên kết │
│ với khách hàng  │
└─────────────────┘
```

### 7.3. Quy Trình Tạo Tài Khoản Nhân Viên

```
┌─────────────┐
│ ADMIN cần   │
│ tuyển nhân  │
│    viên     │
└──────┬──────┘
       │
       ▼
┌─────────────────┐
│ Chọn tab "Nhân  │
│     viên"       │
└──────┬──────────┘
       │
       ▼
┌─────────────────┐
│ Click "Thêm"    │
└──────┬──────────┘
       │
       ▼
┌─────────────────┐
│ Nhập thông tin  │
│ nhân viên:      │
│ - Tên, Email    │
│ - Ngày sinh     │
│ - Ca làm việc   │
└──────┬──────────┘
       │
       ▼
┌─────────────────┐
│ Nhập thông tin  │
│ đăng nhập:      │
│ - Username      │
│ - Password      │
└──────┬──────────┘
       │
       ▼
┌─────────────────┐
│ Hệ thống kiểm   │
│ tra username    │
│   chưa tồn tại  │
└──────┬──────────┘
       │
   ┌───┴───┐
   │  OK   │   Trùng
   │       │
   ▼       ▼
┌─────┐ ┌─────────────┐
│ Tiếp│ │ Hiển thị lỗi │
│ tục │ │ và yêu cầu   │
│     │ │ nhập lại     │
└──┬──┘ └──────────────┘
   │
   ▼
┌─────────────────┐
│ Hệ thống tạo:   │
│ 1. Tài khoản    │
│    STAFF        │
│ 2. Bản ghi nhân │
│    viên         │
│ 3. Liên kết     │
└──────┬──────────┘
       │
       ▼
┌─────────────────┐
│ Hiển thị thông  │
│ báo thành công  │
│ với username và │
│    password     │
└─────────────────┘
```

### 7.4. Quy Trình Lập Lịch Chăm Sóc

```
┌─────────────┐
│ Cần lập lịch │
│ chăm sóc cho │
│  thú cưng   │
└──────┬──────┘
       │
       ▼
┌─────────────────┐
│ Chọn tab "Lịch  │
│   chăm sóc"     │
└──────┬──────────┘
       │
       ▼
┌─────────────────┐
│ Click "Thêm"    │
└──────┬──────────┘
       │
       ▼
┌─────────────────┐
│ Chọn thú cưng   │
│  từ dropdown    │
│   (bắt buộc)    │
└──────┬──────────┘
       │
       ▼
┌─────────────────┐
│ Chọn nhân viên  │
│  từ dropdown    │
│   (bắt buộc)    │
└──────┬──────────┘
       │
       ▼
┌─────────────────┐
│ Nhập hoạt động  │
│   (bắt buộc)    │
└──────┬──────────┘
       │
       ▼
┌─────────────────┐
│ Chọn ngày thực  │
│     hiện        │
│   (bắt buộc)    │
└──────┬──────────┘
       │
       ▼
┌─────────────────┐
│ Thêm ghi chú    │
│    (tùy chọn)   │
└──────┬──────────┘
       │
       ▼
┌─────────────────┐
│ Lưu lịch chăm   │
│      sóc        │
└──────┬──────────┘
       │
       ▼
┌─────────────────┐
│ Lịch được hiển  │
│ thị trong danh  │
│      sách       │
└─────────────────┘
```

---

## 8. Functional Requirements

### 8.1. FR-001: Quản Lý Khách Hàng

**FR-001.1**: Hệ thống phải cho phép ADMIN thêm khách hàng mới với các thông tin:
- Tên (bắt buộc)
- Số điện thoại
- Email
- Địa chỉ
- Điểm tích lũy (mặc định = 0)
- Ngày đăng ký (mặc định = ngày hiện tại)

**FR-001.2**: Hệ thống phải cho phép ADMIN cập nhật thông tin khách hàng (trừ điểm tích lũy và ngày đăng ký)

**FR-001.3**: Hệ thống phải cho phép ADMIN xóa khách hàng

**FR-001.4**: Hệ thống phải cho phép tìm kiếm khách hàng theo tên, email, số điện thoại

**FR-001.5**: Hệ thống phải cho phép lọc khách hàng theo điểm tích lũy

**FR-001.6**: Hệ thống phải cho phép ADMIN thêm/trừ điểm tích lũy cho khách hàng

**FR-001.7**: Hệ thống phải cho phép xem danh sách thú cưng của khách hàng

**FR-001.8**: STAFF chỉ được xem, không được thêm/sửa/xóa

### 8.2. FR-002: Quản Lý Thú Cưng

**FR-002.1**: Hệ thống phải cho phép ADMIN thêm thú cưng mới với các thông tin:
- Tên (bắt buộc)
- Loài
- Tuổi
- Sức khỏe
- Ngày nhập
- Khẩu phần
- Khách hàng sở hữu (bắt buộc)
- Nhân viên phụ trách (tùy chọn)

**FR-002.2**: Hệ thống phải đảm bảo mỗi thú cưng phải thuộc về một khách hàng

**FR-002.3**: Hệ thống phải cho phép ADMIN cập nhật thông tin thú cưng

**FR-002.4**: Hệ thống phải cho phép ADMIN xóa thú cưng

**FR-002.5**: Hệ thống phải cho phép tìm kiếm thú cưng theo tên, loài, khách hàng, nhân viên

**FR-002.6**: Hệ thống phải cho phép lọc thú cưng theo loài, sức khỏe, khách hàng

**FR-002.7**: STAFF chỉ được xem, không được thêm/sửa/xóa

### 8.3. FR-003: Quản Lý Nhân Viên

**FR-003.1**: Hệ thống phải cho phép ADMIN thêm nhân viên mới với các thông tin:
- Tên (bắt buộc)
- Email
- Ngày sinh
- Ca làm việc
- Username (bắt buộc, duy nhất)
- Password (bắt buộc)

**FR-003.2**: Hệ thống phải tự động tạo tài khoản STAFF khi thêm nhân viên

**FR-003.3**: Hệ thống phải đảm bảo username là duy nhất

**FR-003.4**: Hệ thống phải cho phép ADMIN cập nhật thông tin nhân viên (trừ username)

**FR-003.5**: Hệ thống phải cho phép ADMIN đổi mật khẩu nhân viên

**FR-003.6**: Hệ thống phải cho phép ADMIN xóa nhân viên và tài khoản liên kết

**FR-003.7**: Hệ thống phải đồng bộ thông tin nhân viên với tài khoản đăng nhập

**FR-003.8**: Hệ thống phải cho phép tìm kiếm nhân viên theo tên, email

**FR-003.9**: Hệ thống phải cho phép lọc nhân viên theo ca làm việc

**FR-003.10**: STAFF chỉ được xem, không được thêm/sửa/xóa

### 8.4. FR-004: Quản Lý Dịch Vụ

**FR-004.1**: Hệ thống phải cho phép ADMIN thêm dịch vụ mới với các thông tin:
- Tên dịch vụ (bắt buộc)
- Mô tả
- Giá (bắt buộc, số dương)
- Thời gian (phút)
- Loại dịch vụ
- Trạng thái (Hoạt động/Tạm dừng)

**FR-004.2**: Hệ thống phải cho phép ADMIN cập nhật dịch vụ

**FR-004.3**: Hệ thống phải cho phép ADMIN xóa dịch vụ

**FR-004.4**: Hệ thống phải cho phép tìm kiếm dịch vụ theo tên, mô tả

**FR-004.5**: Hệ thống phải cho phép lọc dịch vụ theo loại, trạng thái, giá

**FR-004.6**: STAFF chỉ được xem, không được thêm/sửa/xóa

### 8.5. FR-005: Quản Lý Lịch Chăm Sóc

**FR-005.1**: Hệ thống phải cho phép ADMIN thêm lịch chăm sóc với các thông tin:
- Thú cưng (bắt buộc)
- Nhân viên (bắt buộc)
- Hoạt động (bắt buộc)
- Ngày (bắt buộc)
- Ghi chú (tùy chọn)

**FR-005.2**: Hệ thống phải cho phép ADMIN cập nhật lịch chăm sóc

**FR-005.3**: Hệ thống phải cho phép ADMIN xóa lịch chăm sóc

**FR-005.4**: Hệ thống phải cho phép lọc lịch theo thời gian:
- Hôm nay
- Tuần này
- Tháng này
- Chọn ngày cụ thể
- Tất cả

**FR-005.5**: Hệ thống phải cho phép sắp xếp lịch theo ngày (tăng dần/giảm dần)

**FR-005.6**: Hệ thống phải cho phép tìm kiếm lịch theo thú cưng, nhân viên, hoạt động

**FR-005.7**: STAFF chỉ được xem, không được thêm/sửa/xóa

### 8.6. FR-006: Xác Thực và Phân Quyền

**FR-006.1**: Hệ thống phải yêu cầu đăng nhập trước khi sử dụng

**FR-006.2**: Hệ thống phải xác thực username và password

**FR-006.3**: Hệ thống phải hash mật khẩu bằng SHA-256 với salt

**FR-006.4**: Hệ thống phải phân biệt quyền ADMIN và STAFF

**FR-006.5**: Hệ thống phải vô hiệu hóa các nút "Thêm", "Sửa", "Xóa" cho STAFF

**FR-006.6**: Hệ thống phải cho phép đăng xuất

### 8.7. FR-007: Tìm Kiếm và Lọc

**FR-007.1**: Hệ thống phải hỗ trợ tìm kiếm không phân biệt hoa thường

**FR-007.2**: Hệ thống phải cập nhật kết quả tìm kiếm ngay lập tức

**FR-007.3**: Hệ thống phải cho phép kết hợp tìm kiếm và lọc

**FR-007.4**: Hệ thống phải có nút "Xóa bộ lọc" để reset

**FR-007.5**: Hệ thống phải tự động cập nhật danh sách filter từ dữ liệu hiện có

---

## 9. Non-Functional Requirements

### 9.1. Performance Requirements

**NFR-001**: Hệ thống phải phản hồi trong vòng 2 giây cho các thao tác thông thường

**NFR-002**: Tìm kiếm phải trả về kết quả trong vòng 1 giây

**NFR-003**: Hệ thống phải hỗ trợ ít nhất 1000 bản ghi mỗi bảng

### 9.2. Security Requirements

**NFR-101**: Mật khẩu phải được hash, không lưu plaintext

**NFR-102**: Hệ thống phải ngăn chặn SQL injection

**NFR-103**: Hệ thống phải có phân quyền rõ ràng

**NFR-104**: Session phải được quản lý an toàn

### 9.3. Usability Requirements

**NFR-201**: Giao diện phải trực quan, dễ sử dụng

**NFR-202**: Thông báo lỗi phải rõ ràng, dễ hiểu

**NFR-203**: Hệ thống phải hỗ trợ phím tắt (Enter để đăng nhập, v.v.)

**NFR-204**: Form validation phải rõ ràng, chỉ ra trường nào sai

### 9.4. Reliability Requirements

**NFR-301**: Hệ thống phải hoạt động ổn định, không crash

**NFR-302**: Database phải được backup định kỳ (thủ công)

**NFR-303**: Hệ thống phải xử lý lỗi gracefully

### 9.5. Compatibility Requirements

**NFR-401**: Hệ thống phải chạy trên Windows, macOS, Linux

**NFR-402**: Hệ thống yêu cầu Java 17+

**NFR-403**: Hệ thống không cần kết nối internet

---

## 10. Acceptance Criteria

### 10.1. AC-001: Đăng Nhập

**Given**: Ứng dụng đã được khởi động  
**When**: Người dùng nhập đúng username và password  
**Then**: 
- ✅ Hệ thống hiển thị màn hình chính
- ✅ Menu bar hiển thị thông tin người dùng và vai trò
- ✅ Các tab được hiển thị đầy đủ

**When**: Người dùng nhập sai username hoặc password  
**Then**:
- ✅ Hệ thống hiển thị thông báo lỗi
- ✅ Không cho phép đăng nhập
- ✅ Form đăng nhập vẫn hiển thị

### 10.2. AC-002: Thêm Khách Hàng

**Given**: ADMIN đã đăng nhập  
**When**: ADMIN thêm khách hàng mới với tên hợp lệ  
**Then**:
- ✅ Khách hàng được lưu vào database
- ✅ Điểm tích lũy = 0
- ✅ Ngày đăng ký = ngày hiện tại
- ✅ Hiển thị thông báo thành công
- ✅ Danh sách khách hàng được cập nhật

**When**: ADMIN thêm khách hàng mà không nhập tên  
**Then**:
- ✅ Hệ thống hiển thị thông báo lỗi
- ✅ Không lưu khách hàng
- ✅ Form vẫn mở để sửa

### 10.3. AC-003: Phân Quyền STAFF

**Given**: STAFF đã đăng nhập  
**When**: STAFF mở bất kỳ tab nào  
**Then**:
- ✅ Các nút "Thêm", "Cập nhật", "Xóa" bị vô hiệu hóa
- ✅ STAFF chỉ có thể xem dữ liệu
- ✅ Hiển thị thông báo "Chỉ ADMIN mới được phép..." khi click

### 10.4. AC-004: Tìm Kiếm

**Given**: Đã có dữ liệu trong hệ thống  
**When**: Người dùng nhập từ khóa vào ô tìm kiếm  
**Then**:
- ✅ Kết quả được lọc ngay lập tức
- ✅ Tìm kiếm không phân biệt hoa thường
- ✅ Hiển thị số lượng kết quả (tùy chọn)

**When**: Không tìm thấy kết quả  
**Then**:
- ✅ Bảng hiển thị trống
- ✅ Có thể xóa bộ lọc để xem lại tất cả

### 10.5. AC-005: Tạo Tài Khoản Nhân Viên

**Given**: ADMIN đã đăng nhập  
**When**: ADMIN thêm nhân viên mới với username chưa tồn tại  
**Then**:
- ✅ Tài khoản STAFF được tạo tự động
- ✅ Nhân viên được liên kết với tài khoản
- ✅ Hiển thị username và password cho ADMIN
- ✅ Nhân viên có thể đăng nhập ngay

**When**: ADMIN thêm nhân viên với username đã tồn tại  
**Then**:
- ✅ Hệ thống hiển thị thông báo "Username đã tồn tại"
- ✅ Không tạo tài khoản
- ✅ Form vẫn mở để sửa

---

## 11. Business Glossary

### 11.1. Thuật Ngữ Nghiệp Vụ

**Khách hàng (Customer)**: Người sở hữu thú cưng và sử dụng dịch vụ của trung tâm

**Thú cưng (Pet)**: Động vật được khách hàng đưa đến trung tâm để chăm sóc

**Nhân viên (Caretaker/Staff)**: Người làm việc tại trung tâm, có tài khoản đăng nhập

**Quản lý (Admin)**: Người quản lý toàn bộ hệ thống, có quyền đầy đủ

**Dịch vụ (Service)**: Các hoạt động mà trung tâm cung cấp (tắm rửa, grooming, v.v.)

**Lịch chăm sóc (Care Schedule)**: Kế hoạch chăm sóc thú cưng theo thời gian

**Điểm tích lũy (Loyalty Points)**: Điểm thưởng cho khách hàng khi sử dụng dịch vụ

**Ca làm việc (Shift)**: Thời gian làm việc của nhân viên (Sáng, Chiều, Tối)

**Hoạt động (Activity)**: Công việc cụ thể cần thực hiện cho thú cưng

**Ghi chú (Notes)**: Thông tin bổ sung về lịch chăm sóc hoặc thú cưng

### 11.2. Trạng Thái và Vai Trò

**ADMIN**: Vai trò quản trị viên, có quyền đầy đủ

**STAFF**: Vai trò nhân viên, chỉ có quyền xem

**Hoạt động (Active)**: Dịch vụ đang được cung cấp

**Tạm dừng (Inactive)**: Dịch vụ tạm thời không cung cấp

---

## 12. Assumptions & Constraints

### 12.1. Assumptions (Giả Định)

**AS-001**: Người dùng có kiến thức cơ bản về sử dụng máy tính

**AS-002**: Mỗi trung tâm có ít nhất 1 quản lý (ADMIN)

**AS-003**: Nhân viên được đào tạo cơ bản về sử dụng hệ thống

**AS-004**: Database được backup định kỳ bởi quản lý

**AS-005**: Hệ thống chỉ sử dụng trong nội bộ trung tâm

### 12.2. Constraints (Ràng Buộc)

**CS-001**: Hệ thống chỉ hỗ trợ tiếng Việt

**CS-002**: Hệ thống yêu cầu Java 17+, không hỗ trợ phiên bản cũ hơn

**CS-003**: Database SQLite có giới hạn về kích thước và số lượng kết nối đồng thời

**CS-004**: Hệ thống không có tính năng đa người dùng đồng thời (single-user)

**CS-005**: Không có tính năng backup tự động, phải backup thủ công

**CS-006**: Không có tính năng audit log (ghi nhận lịch sử thay đổi)

---

## 13. Appendix

### 13.1. Tài Khoản Mặc Định

- **Username**: `admin`
- **Password**: `admin123`
- **Vai trò**: ADMIN

### 13.2. Định Dạng Dữ Liệu

- **Ngày tháng**: `yyyy-MM-dd` (ví dụ: 2025-12-01)
- **Giá tiền**: Số thực (VNĐ)
- **Số điện thoại**: Chuỗi ký tự
- **Email**: Định dạng email chuẩn

### 13.3. Liên Hệ

- **Email**: support@petfarm.com
- **Hotline**: 1900-xxxx
- **Website**: www.petfarm.com

---

**Tài liệu này được phê duyệt bởi**:  
- Business Analyst: _______________  
- Project Manager: _______________  
- Stakeholder: _______________  

**Ngày phê duyệt**: _______________

---

**Version History**:
- v1.0.0 (2025-12-01): Phiên bản đầu tiên

