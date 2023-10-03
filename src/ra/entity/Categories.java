package ra.entity;

import java.util.Scanner;

public class Categories {
    private int catalogId;
    private String catalogName;
    private String description;
    private boolean catalogStaus;

    public Categories() {
    }

    public Categories(int catalogId, String catalogName, String description, boolean catalogStaus) {
        this.catalogId = catalogId;
        this.catalogName = catalogName;
        this.description = description;
        this.catalogStaus = catalogStaus;
    }

    public int getCatalogId() {
        return catalogId;
    }

    public void setCatalogId(int catalogId) {
        this.catalogId = catalogId;
    }

    public String getCatalogName() {
        return catalogName;
    }

    public void setCatalogName(String catalogName) {
        this.catalogName = catalogName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isCatalogStaus() {
        return catalogStaus;
    }

    public void setCatalogStaus(boolean catalogStaus) {
        this.catalogStaus = catalogStaus;
    }


    public void inputData(Scanner scanner, Categories[] arrCategories, int index) {
        //1. Sinh ra mã danh mục
        //-Tìm mã danh mục lớn nhất trong mảng arrCategories
        int max = 0;
        for (int i = 0; i < index; i++) {
            if (arrCategories[i].getCatalogId() > max) {
                max = arrCategories[i].getCatalogId();
            }
        }
        //-Sinh mã
        this.catalogId = max + 1;
        //2. Nhập tên danh mục
        boolean isExit = true;
        System.out.println("Nhập vào tên danh mục:");
        do {
            this.catalogName = scanner.nextLine();
            //-Check độ dài < 50
            if (this.catalogName.length() < 50) {
                //-Không trùng lặp
                boolean isExist = false;//Không trùng
                for (int i = 0; i < index; i++) {
                    if (arrCategories[i].getCatalogName().toLowerCase().equals(this.catalogName.toLowerCase())) {
                        isExist = true;//Bị trùng lặp - đã tồn tại rồi
                        break;
                    }
                }
                if (isExist) {
                    System.err.println("Tên danh mục đã tồn tại, vui lòng nhập lại");
                } else {
                    break;
                }
            } else {
                System.err.println("Tên danh mục có độ dài nhỏ hơn 50 ký tự, vui lòng nhập lại");
            }
        } while (isExit);
        //3. Nhập mô tả danh mục
        System.out.println("Nhập vào mô tả danh mục:");
        this.description = scanner.nextLine();
        //4. Nhập trạng thái danh mục
        System.out.println("Nhập vào trạng thái danh mục:");
        do {
            String status = scanner.nextLine();
            if (status.equals("true") || status.equals("false")) {
                this.catalogStaus = Boolean.parseBoolean(status);
                break;
            } else {
                System.err.println("Trạng thái danh mục chỉ nhận giá trị true hoặc false, vui lòng nhập lại");
            }
        } while (isExit);
    }

    public void displayData() {
        System.out.printf("Mã danh mục: %d - Tên danh mục: %s - Mô tả: %s - Trạng thái: %s\n",
                this.catalogId, this.catalogName, this.description,
                this.isCatalogStaus() ? "Hoạt động" : "Không hoạt động");
    }
}
