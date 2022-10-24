package Abstract_Interface;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.Scanner;

import static Abstract_Interface.Manager.*;

public class Main {
    public static void main(String[] args) {
        ArrayList<Material> materials = new ArrayList<>();
        {
            materials.add( new CrispyFlour("11A","Bot Mi", LocalDate.of(2022,10,12),10,200));
            materials.add( new CrispyFlour("22A","Bot Chien", LocalDate.of(2022,10,3),24,200));
            materials.add( new CrispyFlour("33A","Bot Chien gion", LocalDate.of(2022,8,6),456,200));
            materials.add( new CrispyFlour("44A","Bot Ngo", LocalDate.of(2022,4,23),32,200));
            materials.add( new CrispyFlour("55A","Bot Nang", LocalDate.of(2022,10,1),342,200));
            materials.add( new Meat("11B","Thit lon", LocalDate.of(2022,11,1),100,200));
            materials.add( new Meat("22B","Thit cho", LocalDate.of(2022,11,2),200,200));
            materials.add( new Meat("33B","Thit bo", LocalDate.of(2022,11,3),300,200));
            materials.add( new Meat("44B","Thit trau", LocalDate.of(2022,11,2),250,200));
            materials.add( new Meat("55B","Thit ga", LocalDate.of(2022,11,1),20,200));
        }


        Scanner scanner = new Scanner(System.in);
        int choice ;
        do {
            System.out.println("MENU");
            System.out.println("1.Thêm sản phẩm: ");
            System.out.println("2.Xóa sản phẩm: ");
            System.out.println("3.Sửa sản phẩm: ");
            System.out.println("4.Hiển thị sản phẩm: ");
            System.out.println("5.Sản phẩm giảm giá: ");
            System.out.println("0.Thoát: ");
            System.out.println("Lựa chọn của bạn: ");
            choice = Integer.parseInt(scanner.nextLine());
            switch (choice){
                case 1:add(materials,scanner);break;
                case 2:delete(materials,scanner);break;
                case 3:edit(materials,scanner);break;
                case 4:display(materials);break;
                case 5:displayDiscountPro(materials,scanner);break;
            }
        }while (choice !=0);

    }

}
