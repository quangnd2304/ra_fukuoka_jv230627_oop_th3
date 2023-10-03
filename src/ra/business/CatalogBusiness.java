package ra.business;

import ra.entity.Categories;
import ra.presentation.ShopManagement;

import java.util.Scanner;

public class CatalogBusiness {

    public static void inputListCategories(Scanner scanner) {
        System.out.println("Nhập vào số lượng danh mục cần nhập dữ liệu:");
        int n = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < n; i++) {
            ShopManagement.arrCategories[ShopManagement.indexCategories] = new Categories();
            ShopManagement.arrCategories[ShopManagement.indexCategories].inputData(scanner, ShopManagement.arrCategories,ShopManagement.indexCategories );
            ShopManagement.indexCategories++;
        }
    }
    public static void displayData(){
        for (int i = 0; i < ShopManagement.indexCategories; i++) {
            ShopManagement.arrCategories[i].displayData();
        }
    }
    public static void updateCatalog(Scanner scanner){
        System.out.println("Nhập vào mã danh mục cần cập nhật: ");
        int catalogIdUpdate = Integer.parseInt(scanner.nextLine());
        int indexUpdate = getIndexOfArrCategories(catalogIdUpdate);
        if (indexUpdate>=0){
            //Thực hiện cập nhật theo chỉ số index
            System.out.println("Nhập tên danh mục:");
            String catalogName = scanner.nextLine();
            if (catalogName.trim().length()!=0){
                ShopManagement.arrCategories[indexUpdate].setCatalogName(catalogName);
            }
            System.out.println("Nhập vào mô tả danh mục:");
            String description = scanner.nextLine();
            if (description.trim().length()!=0){
                ShopManagement.arrCategories[indexUpdate].setDescription(description);
            }
            System.out.println("Nhập vào trạng thái danh mục:");
            String status = scanner.nextLine();
            if (status.trim().length()!=0){
                ShopManagement.arrCategories[indexUpdate].setCatalogStaus(Boolean.parseBoolean(status));
            }
        }else{
            System.err.println("Mã danh mục không tồn tại");
        }
    }

    public static void deleteCatalog(Scanner scanner){
        System.out.println("Nhập vào mã danh mục cần xóa:");
        int catalogId = Integer.parseInt(scanner.nextLine());
        int indexDelete = getIndexOfArrCategories(catalogId);
        if (indexDelete>=0){
            //Kiểm tra danh mục có chứa sản phẩm hay không
            boolean isExistProduct = false;//Danh mục chưa chứa phẩm
            for (int i = 0; i < ShopManagement.indexProduct; i++) {
                if (ShopManagement.arrProducts[i].getCatalogId()==catalogId){
                    isExistProduct = true;//Danh mục đã chứa sản phẩm
                    break;
                }
            }
            if (isExistProduct){
                System.err.println("Danh mục đang chứa sản phẩm, không thể xóa được");
            }else{
                //Thực hiện xóa
                for (int i = indexDelete; i < ShopManagement.indexCategories-1; i++) {
                    ShopManagement.arrCategories[i] = ShopManagement.arrCategories[i+1];
                }
                ShopManagement.arrCategories[ShopManagement.indexCategories-1] = null;
                ShopManagement.indexCategories--;
            }
        }else{
            System.err.println("Mã danh mục không tồn tại");
        }
    }

    public static void updateCatalogStatus(Scanner scanner){
        System.out.println("Nhập vào mã danh mục cần cập nhật trạng thái:");
        int catalogId = Integer.parseInt(scanner.nextLine());
        int indexUpdate = getIndexOfArrCategories(catalogId);
        if (indexUpdate>=0){
            //Cập nhập trạng thái
            ShopManagement.arrCategories[indexUpdate].setCatalogStaus(!ShopManagement.arrCategories[indexUpdate].isCatalogStaus());
        }else{
            System.err.println("Mã danh mục không tồn tại");
        }
    }

    public static int getIndexOfArrCategories(int catalogId){
        for (int i = 0; i < ShopManagement.indexCategories; i++) {
            if (ShopManagement.arrCategories[i].getCatalogId()==catalogId){
                return i;//Có tồn tại
            }
        }
        return -1;//Không tồn tại
    }
}
