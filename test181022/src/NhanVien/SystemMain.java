package NhanVien;

import java.util.List;
import java.util.Scanner;

import static NhanVien.Manager.readFile;

public class SystemMain {
    public void system(){
        Manager manager = new Manager();
        List<NhanVien> list = readFile();
        ManagerFullTime fullTime = new ManagerFullTime();
        Scanner scanner = new Scanner(java.lang.System.in);
        manager.phanLoaiNhanVien(list);
        int choice;
        do {
            java.lang.System.out.println("___________________________________________");
            java.lang.System.out.println("Menu: ");
            java.lang.System.out.println("1.Tao thong tin nhan vien: ");
            java.lang.System.out.println("2.Sua thong tin nhan vien: ");
            java.lang.System.out.println("3.Xoa thong tin nhan vien: ");
            java.lang.System.out.println("4.Luong tong: ");
            java.lang.System.out.println("5.Luong trung binh cua ca cong ty: ");
            java.lang.System.out.println("6.Nhan vien full time yeu kem: ");
            java.lang.System.out.println("7.Danh sach luong nhan vien full time tang dan: ");
            java.lang.System.out.println("8.Hien thi danh sach nhan vien cong ti: ");
            java.lang.System.out.println("0.Thoat!!!!!!!!!!!!");
            java.lang.System.out.println("Nhap lua chon: ");
            choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:
                    manager.taoThongTinNhanVien(scanner, list);
                    break;
                case 2:
                    manager.suaThongTinNhanVien(scanner, list);
                    break;
                case 3:
                    manager.xoaThongTinNhanVien(scanner, list);
                    break;
                case 4:
                    manager.kiemTraLuongCaCongTy(list, scanner);
                    break;
                case 5:
                    double luongTB = manager.luongTrungBinhCaCongTy(list);
                    java.lang.System.out.println("Luong trung binh cua ca cong ti la: " + luongTB);
                    break;
                case 6:
                    fullTime.luongFullTimeThapHonLuongTrungBinh(list);
                    break;
                case 7:
                    fullTime.sapXepNhanVienFullTime(list);
                    break;
                case 8:
                    manager.hienThiThongTinCaCongTy(list);
                    break;
            }
        } while (choice != 0);
    }

}
