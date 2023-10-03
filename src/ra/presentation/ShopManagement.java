package ra.presentation;

import ra.entity.Categories;
import ra.entity.Product;

import java.util.Scanner;

public class ShopManagement {
    public static Categories[] arrCategories = new Categories[100];
    public static Product[] arrProducts = new Product[100];
    public static int indexCategories = 0;
    public static int indexProduct = 0;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        do {
            System.out.println("****************SHOP MENU********************");
            System.out.println("1. Quản lý danh mục sản phẩm");
            System.out.println("2. Quản lý sản phẩm");
            System.out.println("3. Thoát");
            System.out.print("Lựa chọn của bạn:");
            int choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:
                    CatalogMenu.displayMenu(scanner,arrCategories);
                    break;
                case 2:
                    break;
                case 3:
                    System.exit(0);
                default:
                    System.err.println("Vui lòng chọn 1-3");
            }
        } while (true);
    }
}
