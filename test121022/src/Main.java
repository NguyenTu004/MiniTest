import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner =new Scanner(System.in);
        int choice;
        do {
            System.out.println("___________________________________________");
            System.out.println("MENU: ");
            System.out.println("1.Them san pham:");
            System.out.println("2.Xoa san pham:");
            System.out.println("3.Sua san pham:");
            System.out.println("4.San pham co gia tri lon nhat:");
            System.out.println("5.Hien thi:");
            System.out.println("0.Thoat!!!!!");
            System.out.println("Lua chon cua ban: ");
            choice = scanner.nextInt();
            switch (choice) {
                case 1 -> {
                    ProductManager.addProduct(scanner);
                    ProductManager.display();
                }
                case 2 -> {
                    ProductManager.deleteProduct(scanner);
                    ProductManager.display();
                }
                case 3 -> ProductManager.updateProduct(scanner);
                case 4 -> ProductManager.displayMaxPriceProduct();
                case 5 -> ProductManager.display();
            }
        }while (choice!=0);


    }
}