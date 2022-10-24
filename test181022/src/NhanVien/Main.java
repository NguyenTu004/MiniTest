package NhanVien;

import java.util.*;

import static NhanVien.Manager.*;

public class Main {
    public static void main(String[] args) {
        List<NhanVien> list = new ArrayList<NhanVien>();
        Scanner scanner = new Scanner(System.in);
        int choice;
        do {
            System.out.println("___________________________________________");
            System.out.println("Menu: ");
            System.out.println("1.Tao thong tin nhan vien: ");
            System.out.println("2.Luong tong: ");
            System.out.println("3.Luong trung binh cua tat ca nhan vien: ");
            System.out.println("4.Nhan vien full time yeu kem: ");
            System.out.println("5.Danh sach luong nhan vien full time tang dan: ");
            System.out.println("6.Hien thi danh sach nhan vien cong ti: ");
            System.out.println("Nhap lua chon: ");
            choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:
                    add(scanner, list);
                    break;
                case 2:
                    kiemTraLuong(list, scanner);
                    break;
                case 3:
                    double luongTB = Manager.luongTB(list);
                    System.out.println("Luong trung binh cua ca cong ti la: " + luongTB);
                    break;
                case 4:
                    nhanVienFullTimeYeuKem(list);
                    break;
                case 5:
                    sapXepNhanVienFullTime(list);
                    break;
                case 6:
                    display(list);
                    break;
            }
        } while (choice != 0);
    }


}
