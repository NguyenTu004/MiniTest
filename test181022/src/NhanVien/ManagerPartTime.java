package NhanVien;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class ManagerPartTime {
    public static List<NhanVienPartTime> listNhanVienPartTime = new ArrayList<>();

    public ManagerPartTime() {
    }
    public double tinhTongLuongPartTime(List<NhanVien> list) {
        double luongRead;
        double luongTongPartTime=0;
        for (NhanVienPartTime nhanVienPartTime : listNhanVienPartTime) {
            luongRead = nhanVienPartTime.tinhLuong();
            luongTongPartTime +=luongRead;
            System.out.println("Nhan Vien Part Time: " + nhanVienPartTime.getTen() + " : " + luongRead + " VND");
        }
        return luongTongPartTime;
    }
    public void suaThongTinPartTime(Scanner scanner, NhanVienPartTime nhanVien2) {
        boolean flag;
        do {
            flag = false;
            String text = scanner.nextLine();
            if (!Objects.equals(text, "")) {
                try {
                    double num = Double.parseDouble(text);
                    nhanVien2.setGioLam(num);
                }catch (Exception exceptions){
                    System.err.println("Nhap du lieu dang so: ");
                    flag = true;
                }
            }
        }while (flag);
    }
}
