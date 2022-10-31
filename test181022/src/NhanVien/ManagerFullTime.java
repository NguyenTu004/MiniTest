package NhanVien;

import java.util.*;

public class ManagerFullTime {
    public static List<NhanVienFullTime> listNhanVienFullTime = new ArrayList<>();
    public ManagerFullTime() {
    }
    public double tinhTongLuongFullTime(List<NhanVien> list) {
        double luongRead;
        double luongTongFullTime=0;
        for (NhanVienFullTime nhanVienFullTime : listNhanVienFullTime) {
            luongRead = nhanVienFullTime.tinhLuong();
            System.out.println("Nhan vien Full Time: " + nhanVienFullTime.getTen() + " : " + luongRead + " VND");
            luongTongFullTime += luongRead;
        }
        return luongTongFullTime;
    }
    public void luongFullTimeThapHonLuongTrungBinh( List<NhanVien> list){
        Manager manager = new Manager();
        double luongTB = manager.luongTrungBinhCaCongTy(list);
        for (int i = 0; i < listNhanVienFullTime.size(); i++) {
            if (listNhanVienFullTime.get(i).getLuong() < luongTB){
                System.out.println("STT: "+(i+1)+" : "+" Nhan Vien Full Time yeu kem:\t Ten: " +listNhanVienFullTime.get(i).getTen()+"\t\t Luong: "+ listNhanVienFullTime.get(i).getLuong() + "VND");
            }
        }
    }
    public void suaThongTinFullTime(Scanner scanner, NhanVienFullTime nhanVien1, int choice) {
        boolean flag;
        do {
            flag = false;
            String text = scanner.nextLine();
            if (!Objects.equals(text, "")) {
                try {
                    double num = Double.parseDouble(text);
                    switch (choice){
                        case 1:nhanVien1.setLuong(num);break;
                        case 2: nhanVien1.setTienThuong(num);break;
                        case 3: nhanVien1.setTienPhat(num);break;
                    }
                }catch (Exception exceptions){
                    System.err.println("Nhap du lieu dang so: ");
                    flag = true;
                }
            }
        }while (flag);
    }
    public void sapXepNhanVienFullTime( List<NhanVien> list){
        Manager manager = new Manager();
        manager.phanLoaiNhanVien(list);
        SapXepNVFullTime sapXep = new SapXepNVFullTime();
        Collections.sort(listNhanVienFullTime,sapXep);
        for (NhanVienFullTime nhanVienFullTime : listNhanVienFullTime) {
            System.out.println("Ten: " + nhanVienFullTime.getTen() + "\t\t Luong: " + nhanVienFullTime.getLuong());
        }
    }
}
