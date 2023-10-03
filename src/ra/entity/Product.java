package ra.entity;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Product {
    private String productId;
    private String productName;
    private float price;
    private String description;
    private Date created;
    private int catalogId;
    private int productStatus;

    public Product() {
    }

    public Product(String productId, String productName, float price, String description, Date created, int catalogId, int productStatus) {
        this.productId = productId;
        this.productName = productName;
        this.price = price;
        this.description = description;
        this.created = created;
        this.catalogId = catalogId;
        this.productStatus = productStatus;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public int getCatalogId() {
        return catalogId;
    }

    public void setCatalogId(int catalogId) {
        this.catalogId = catalogId;
    }

    public int getProductStatus() {
        return productStatus;
    }

    public void setProductStatus(int productStatus) {
        this.productStatus = productStatus;
    }

    public void inputData(Scanner scanner, Categories[] arrCategories,
                          int indexCategories, Product[] arrProducts, int indexProduct) {
        //1. Nhập mã sản phẩm
        boolean isExit = true;
        System.out.println("Nhập vào mã sản phẩm:");
        do {
            this.productId = scanner.nextLine();
            //-Check 4 ký tự
            if (this.productId.length() == 4) {
                //-Ký tự bắt đầu là C, S, A
                if (this.productId.startsWith("C") || this.productId.startsWith("S") || this.productId.startsWith("A")) {
                    //-Không trùng lặp
                    boolean isExist = false;
                    for (int i = 0; i < indexProduct; i++) {
                        if (arrProducts[i].getProductId().equals(this.productId)) {
                            isExist = true;
                            break;
                        }
                    }
                    if (isExist) {
                        System.err.println("Mã sản phẩm đã tồn tại, vui lòng nhập lại");
                    } else {
                        break;
                    }
                } else {
                    System.err.println("Mã sản phẩm phải bắt đầu là ký tự C, S, A, vui lòng nhập lại");
                }
            } else {
                System.err.println("Mã sản phẩm phải gồm 4 ký tự, vui lòng nhập lại");
            }
        } while (isExit);
        //2. Nhập tên sản phẩm
        System.out.println("Nhập vào tên sản phẩm:");
        do {
            this.productName = scanner.nextLine();
            //-Kiểm tra độ dài
            if (this.productName.length() >= 10 && this.productName.length() <= 50) {
                //-Không trùng lặp
                boolean isExist = false;//Chưa tồn tại
                for (int i = 0; i < indexProduct; i++) {
                    if (arrProducts[i].getProductName().equals(this.productName)) {
                        isExist = true;
                        break;
                    }
                }
                if (isExist) {
                    System.err.println("Tên sản phẩm đã tồn tại, vui lòng nhập lại");
                } else {
                    break;
                }
            } else {
                System.err.println("Tên sản phẩm từ 10-50 ký tự, vui lòng nhập lại");
            }
        } while (isExit);
        //3. Nhập vào price
        System.out.println("Nhập vào giá sản phẩm:");
        do {
            this.price = Float.parseFloat(scanner.nextLine());
            if (this.price > 0) {
                break;
            } else {
                System.err.println("Giá sản phẩm phải lớn hơn 0, vui lòng nhập lại");
            }
        } while (isExit);
        //4. Mô tả sản phẩm
        System.out.println("Nhập vào mô tả sản phẩm:");
        this.description = scanner.nextLine();
        //5. Ngày nhập sản phẩm
        System.out.println("Nhập vào ngày nhập sản phẩm");
        do {
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            try {
                this.created = sdf.parse(scanner.nextLine());
                break;
            } catch (Exception ex) {
                System.err.println("Ngày nhập có định dạng dd/MM/yyyy, vui lòng nhập lại");
            }
        } while (isExit);
        //6. Chọn danh mục
        System.out.println("Chọn danh mục của sản phẩm:");
        for (int i = 0; i < indexCategories; i++) {
            System.out.printf("%d. %s\n", (i + 1), arrCategories[i].getCatalogName());
        }
        System.out.print("Chọn danh mục:");
        int choiceCatalogId = Integer.parseInt(scanner.nextLine());
        this.catalogId = arrCategories[choiceCatalogId - 1].getCatalogId();
        //7. Chọn trạng thái sản phẩm
        System.out.println("Chọn trạng thái sản phẩm:");
        System.out.println("1. Đang bán");
        System.out.println("2. Hết hàng");
        System.out.println("3. Không bán");
        System.out.print("Chọn trạng thái:");
        int choiceStatus = Integer.parseInt(scanner.nextLine());
        this.productStatus = choiceStatus - 1;
    }

    public void displayData() {
        System.out.printf("Mã sản phẩm: %s - Tên sản phẩm: %s - Giá: %f\n", this.productId, this.productName, this.price);
        System.out.printf("Mô tả: %s - Ngày tạo: %s\n",this.description,this.created.toString());
        System.out.printf("Mã danh mục: %d - Trạng thái: %s\n",
                this.catalogId,(this.productStatus==0)?"Đang bán":((this.productStatus==1)?"Hết hàng":"Không bán"));
    }

}
