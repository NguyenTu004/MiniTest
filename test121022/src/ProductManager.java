import java.util.Objects;
import java.util.Scanner;

public class ProductManager {
//    static int count = 0;
//    public static Product[] arr = new Product[100];
    private static Product[] arr;
    public ProductManager() {
        arr = new Product[0];
    }

    public static void  addProduct(Scanner scanner){
        String choice;
        do {
            System.out.println("___________________________________________");
            System.out.println("Menu:");
            System.out.println("Nhap ten san pham: ");
            String name = scanner.nextLine();
            System.out.println("Nhap gia san pham: ");
            int price = Integer.parseInt( scanner.nextLine());
            System.out.println("Mo ta san pham: ");
            String description = scanner.nextLine();
            Product product = new Product(name,price,description);
            Product[] newArr = new Product[arr.length+1];
            //Hàm Arrcopyz
            System.arraycopy(arr, 0, newArr, 0, newArr.length);
            newArr[arr.length] = product;
            arr=newArr;
            System.out.println("Them thanh cong!!");
//            {
//            arr[count]=product;
//            count++;
//            }
            System.out.println("Nhap Exit de thoat(Enter de tiep tuc):");
            choice = scanner.nextLine();
        }while (!Objects.equals(choice, "Exit"));
    }
    public static void  deleteProduct(Scanner scanner){
        if (arr.length > 0) {
        System.out.println("___________________________________________");
        System.out.println("Menu:");
        System.out.println("Nhap vi tri can xoa: ");
        int index = scanner.nextInt();
            Product[] newArr = new Product[arr.length - 1];
            for (int i = 0; i < newArr.length; i++) {
                if (i < index - 1) {
                    newArr[i] = arr[i];
                } else {
                    newArr[i] = arr[i + 1];
                }
            }
            arr = newArr;
            System.out.println("Xóa thành công!");
//            {
//                for (int i=0;i<arr.length;i++){
//            if (index==i){
//                    for (int j=0;j<arr.length-1;j++){
//                        arr[j]=arr[j+1];
//                        arr[arr.length-1]=null;
//                    }
//                    break;
//                    }
//                }
//            }
        } else {
            System.out.println("Danh sách không có sản phẩm nào!");
        }
    }
    public static void updateProduct(Scanner scanner){
        String choice;
        if (arr.length > 0) {
        do {
            System.out.println("___________________________________________");
            System.out.println("Menu");
            System.out.println("Vi tri can sua: ");
            int index = scanner.nextInt();
            System.out.println("1.Ten san pham: " + arr[index].getName());
            scanner.nextLine();
            String name = scanner.nextLine();
            System.out.println("2.Gia san pham: " + arr[index].getPrice());
            System.out.println("(Nhap -1 de bo qua)");
            int price = Integer.parseInt( scanner.nextLine());
            System.out.println("3.Mo ta san pham: " + arr[index].getDescription());
            String description = scanner.nextLine();

            if (!Objects.equals(name, " ")) {
                arr[index].setName(name);
            }
            if (price != -1) {
                arr[index].setPrice(price);
            }
            if (!Objects.equals(description, " ")) {
                arr[index].setName(name);
            }
            System.out.println("Product" +
                    "name='" + arr[index].getName() + '\'' +
                    ", price=" + arr[index].getPrice() +
                    ", description='" + arr[index].getDescription() + '\'');
            System.out.println("Nhap Exit de thoat(Enter de tiep tuc):");
            choice = scanner.nextLine();
        }while (!Objects.equals(choice, "Exit"));
        } else {
            System.out.println("Danh sách không có sản phẩm nào!");
        }


    }
    public static void display(){
        System.out.println("___________________________________________");
        for (int i=0;i< arr.length;i++){
            if (arr[i]!=null){
                System.out.println(i+"."+arr[i]);
            }
        }
    }
    public static void displayMaxPriceProduct(){
        if (arr.length > 0) {
        int max = arr[0].getPrice();
        int index=0;
        for (int i=0;i< arr.length;i++){
            if (arr[i]!=null){
                if (max<arr[i].getPrice()){
                    max=arr[i].getPrice();
                    index=i;
                }
            }
        }
        System.out.println("___________________________________________");
        System.out.println("San pham co gia tri lon nhat la: "+ arr[index].getName()+" : "+max);
    } else {
        System.out.println("Danh sách không có sản phẩm nào!");
    }
    }

}
