package NhanVien;

import java.util.*;

import static NhanVien.Manager.*;

public class Main {
    public static void main(String[] args) {
        List<NhanVien> list = readFile();
        Scanner scanner = new Scanner(System.in);
        int choice;
        do {
            System.out.println("___________________________________________");
            System.out.println("Menu: ");
            System.out.println("1.Tao thong tin nhan vien: ");
            System.out.println("2.Sua thong tin nhan vien: ");
            System.out.println("3.Xoa thong tin nhan vien: ");
            System.out.println("4.Luong tong: ");
            System.out.println("5.Luong trung binh cua tat ca nhan vien: ");
            System.out.println("6.Nhan vien full time yeu kem: ");
            System.out.println("7.Danh sach luong nhan vien full time tang dan: ");
            System.out.println("8.Hien thi danh sach nhan vien cong ti: ");
            System.out.println("0.Thoat!!!!!!!!!!!!");
            System.out.println("Nhap lua chon: ");
            choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:
                    add(scanner, list);
                    break;
                case 2:
                    update(scanner, list);
                    break;
                case 3:
                    delete(scanner, list);
                    break;
                case 4:
                    kiemTraLuong(list, scanner);
                    break;
                case 5:
                    double luongTB = Manager.luongTB(list);
                    System.out.println("Luong trung binh cua ca cong ti la: " + luongTB);
                    break;
                case 6:
                    nhanVienFullTimeYeuKem(list);
                    break;
                case 7:
                    sapXepNhanVienFullTime(list);
                    break;
                case 8:
                    display(list);
                    break;
            }
        } while (choice != 0);
    }


}
