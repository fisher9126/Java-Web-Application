1. Mô tả nghiệp vụ ￼

Khách đang ngồi ở máy trạm, muốn gọi đồ ăn (ví dụ “Mì xào bò”) mà không phải ra quầy.

Hệ thống phải:

- Kiểm tra còn hàng trong kho.

- Kiểm tra tài khoản user đủ tiền.

- Nếu ok → trừ kho, trừ tiền, trả kết quả thành công.

- Nếu hết hàng / thiếu tiền → trả lỗi rõ ràng.

2. Thành phần & DI ￼

- ‎`OrderFoodService`

▫ Xử lý nghiệp vụ đặt đồ ăn.

▫ DI qua constructor:

⁃ ‎`InventoryRepository`

⁃ ‎`UserAccountRepository`

- ‎`InventoryRepository`

▫ Lấy món theo ‎`itemCode`.

▫ Xem số lượng tồn, trừ kho.

- ‎`UserAccountRepository`

▫ Lấy user theo ‎`userId`.

▫ Xem số dư, trừ tiền.

- ‎`OrderResult` (DTO)

▫ ‎`boolean success`

▫ ‎`String message`

▫ (optional) ‎`remainingBalance`, ‎`remainingStock`, ‎`errorCode`

3. Input / Output ￼

Input (cho ‎`orderFood`):

- ‎`userId`

- ‎`itemCode`

- ‎`quantity`

Output:

- ‎`success` (true/false)

- ‎`message` cho người dùng

- (tuỳ chọn: số dư còn lại, tồn kho còn lại)

4. Các bước xử lý logic ￼

1. Validate ‎`quantity > 0`, sai → fail, báo “Số lượng phải lớn hơn 0”.

2. Lấy món từ ‎`InventoryRepository`.

▫ Không thấy món → fail, “Món không tồn tại”.

3. Kiểm tra kho:

▫ ‎`availableQuantity == 0` → fail, “Món X đã hết hàng”.

▫ ‎`availableQuantity < quantity` → fail, “Chỉ còn N phần”.

4. Lấy account từ ‎`UserAccountRepository`.

▫ Không có user → fail, “Tài khoản không hợp lệ”.

5. Tính tiền = ‎`unitPrice * quantity`, kiểm tra ‎`balance`:

▫ ‎`balance < totalPrice` → fail, “Không đủ tiền”.

6. Giao dịch (trong 1 transaction):

▫ ‎`decreaseStock(itemCode, quantity)`

▫ ‎`decreaseBalance(userId, totalPrice)`

7. Trả kết quả thành công:

▫ ‎`success = true`

▫ ‎`message = "Đặt món X xQ thành công. Số dư còn: ..."`

5. Loose Coupling ￼

- ‎`OrderFoodService` không dùng ‎`new` repo, chỉ nhận qua constructor.

- Spring ‎`ApplicationContext` tạo và inject các Repository.

- Dễ thay implement (in-memory, DB, mock) và dễ Unit Test.

6. Xử lý hai bẫy chính ￼

- Mì xào bò tồn kho = 0 → fail, báo “Món Mì xào bò đã hết hàng”.

- Số dư tài khoản âm / không đủ → fail, báo “Số dư không đủ, vui lòng nạp tiền”.