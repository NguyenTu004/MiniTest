package product_category;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ProductManager {
    public List<Product> listProduct;
    public List<Category> listCategory;

    public ProductManager() {
        listProduct = new ArrayList<Product>();
        listCategory.add(new Category("Điện Tử"));
        listCategory.add(new Category("Gia Dụng"));
        listCategory.add(new Category("None"));
    }
    public void addProduct(Scanner scanner) {
        System.out.println("Ma san pham: ");
        Long id = Long.parseLong(scanner.nextLine());
        System.out.println("Ten san pham: ");
        String name = scanner.nextLine();
        System.out.println("Gia san pham: ");
        double price = Double.parseDouble(scanner.nextLine());
        System.out.println("So luong san pham: ");
        int quantity = Integer.parseInt(scanner.nextLine());
        System.out.println("Loai san pham: ");
        Category category = new Category();
        {
            System.out.println("1. "+listCategory.get(0));
            System.out.println("2. "+listCategory.get(1));
            System.out.println("3. "+listCategory.get(2));
            System.out.println("Nhap loai san pham(1-3): ");
            int choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1: category =listCategory.get(0); break;
                case 2: category =listCategory.get(1); break;
                case 3: category =listCategory.get(2); break;
            }
        }
        listProduct.add(new Product(id,name,price,quantity,category));
        System.out.println("Tao thanh cong!!!");
    }
    public void deleteProduct(Scanner scanner){
        System.out.println("Nhap id san pham can xoa:");
        long id = Long.parseLong(scanner.nextLine());
        int index = checkId(id);
        listProduct.remove(index);
        System.out.println("xoa thanh cong!!");
    }
    public void updateProduct(Scanner scanner){

    }
    public void display(){
        for (Product product : listProduct){
            System.out.println(product.toString());
        }
    }
    public int checkId(Long id) {
        int index= -1;
        for (int i = 0; i < listProduct.size(); i++) {
            if (listProduct.get(i).getId().equals(id)) {
                index = i;
                break;
            }
        }
        return index;
    }
    public void displayAProduct(Scanner scanner){
        System.out.println("Nhap id san pham can hien thi:");

    }
}
