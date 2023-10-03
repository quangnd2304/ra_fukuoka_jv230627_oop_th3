package ra.presentation;

import ra.business.CatalogBusiness;
import ra.entity.Categories;

import java.util.Scanner;

public class CatalogMenu {
    public static void displayMenu(Scanner scanner, Categories[] arrCategories){
        boolean isExist = true;
        do {
            System.out.println("********************CATEGORIES MENU**********************");
            System.out.println("1. Nhập thông tin các danh mục");
            System.out.println("2. Hiển thị thông tin các danh mục");
            System.out.println("3. Cập nhật thông tin danh mục");
            System.out.println("4. Xóa danh mục");
            System.out.println("5. Cập nhật trạng thái danh mục");
            System.out.println("6. Thoát");
            System.out.print("Lựa chọn của bạn:");
            int choice = Integer.parseInt(scanner.nextLine());
            switch (choice){
                case 1:
                    CatalogBusiness.inputListCategories(scanner);
                    break;
                case 2:
                    CatalogBusiness.displayData();
                    break;
                case 3:
                    CatalogBusiness.updateCatalog(scanner);
                    break;
                case 4:
                    CatalogBusiness.deleteCatalog(scanner);
                    break;
                case 5:
                    CatalogBusiness.updateCatalogStatus(scanner);
                    break;
                case 6:
                    isExist = false;
                    break;
                default:
                    System.err.println("Vui lòng chọn 1-6");
            }
        }while (isExist);
    }
}
