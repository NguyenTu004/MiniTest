package NhanVien;

import java.util.*;
import java.lang.Integer;
public class Manager {
    public static final int LUONGTHEOGIO = 100000;
    static List<NhanVienFullTime> listNhanVienFullTime = new ArrayList<>();
    static List<NhanVienPartTime> listNhanVienPartTime = new ArrayList<>();
    static NhanVienFullTime nhanVien1 ;
    static NhanVienPartTime nhanVien2 ;
    static int index = 0;
    static boolean flag ;
    public static void tinhLuong( List<NhanVien> list){
        tinhLuongFullTime(list);
        tinhLuongPartTime(list);
    }
    public static void phanLoaiNhanVien( List<NhanVien> list){
       listNhanVienFullTime.clear();
       listNhanVienPartTime.clear();
        for (NhanVien nhanVien : list) {
            if (nhanVien instanceof NhanVienFullTime ) {
                listNhanVienFullTime.add((NhanVienFullTime) nhanVien);
            } else if (nhanVien instanceof NhanVienPartTime ) {
                listNhanVienPartTime.add(((NhanVienPartTime) nhanVien));
            }
        }
    }
    public static double tinhLuongPartTime(List<NhanVien> list) {
        phanLoaiNhanVien(list);
        double luongRead;
        double luongTongPartTime=0;
        for (NhanVienPartTime nhanVienPartTime : listNhanVienPartTime) {
            luongRead = nhanVienPartTime.getGioLam() * LUONGTHEOGIO;
            luongTongPartTime +=luongRead;
            System.out.println("Nhan Vien Part Time: " + nhanVienPartTime.getTen() + " : " + luongRead + " VND");
        }
        return luongTongPartTime;
    }
    public static double tinhLuongFullTime(List<NhanVien> list) {
        phanLoaiNhanVien(list);
        double luongRead;
        double luongTongFullTime=0;
        for (NhanVienFullTime nhanVienFullTime : listNhanVienFullTime) {
            luongRead = nhanVienFullTime.getLuong() + (nhanVienFullTime.getTienThuong() - nhanVienFullTime.getTienPhat());
            System.out.println("Nhan vien Full Time: " + nhanVienFullTime.getTen() + " : " + luongRead + " VND");
            luongTongFullTime += luongRead;
        }
        return luongTongFullTime;
    }
    public static double luongTong( List<NhanVien> list){
        double luongTong=0;
        phanLoaiNhanVien(list);
        for (NhanVienPartTime nhanVienPartTime : listNhanVienPartTime) {
            luongTong += nhanVienPartTime.getGioLam() * LUONGTHEOGIO;
        }
        for (NhanVienFullTime nhanVienFulltTime : listNhanVienFullTime) {
            luongTong += nhanVienFulltTime.getLuong() + (nhanVienFulltTime.getTienThuong() - nhanVienFulltTime.getTienPhat());
        }
        return luongTong;
    }
    public static double luongTB( List<NhanVien> list){
        double luongTong = luongTong(list);
        return  luongTong/list.size();

    }
    public static void nhanVienFullTimeYeuKem( List<NhanVien> list){
        double luongTB = luongTB(list);
        for (int i = 0; i < listNhanVienFullTime.size(); i++) {
            if (listNhanVienFullTime.get(i).getLuong() < luongTB){
                System.out.println("STT: "+i+" : "+" Nhan Vien Full Time yeu kem: " + listNhanVienFullTime.get(i).getLuong() + "VND");
            }
        }
    }
    public static void sapXepNhanVienFullTime( List<NhanVien> list){
        phanLoaiNhanVien(list);
        double x;
        int pos;
        int size = listNhanVienFullTime.size();
        for (int i = 1; i < size; i++) {
            x = listNhanVienFullTime.get(i).getLuong();
            pos = i;
            while ( pos > 0 && x <  listNhanVienFullTime.get(i-1).getLuong()){
                listNhanVienFullTime.remove(i);
                listNhanVienFullTime.add(pos,listNhanVienFullTime.get(pos-1));
                pos--;
            }
            listNhanVienFullTime.remove(pos);
            listNhanVienFullTime.add(pos,listNhanVienFullTime.get(pos));
        }
        for (NhanVienFullTime nhanVienFullTime : listNhanVienFullTime) {
            System.out.println("Ten: " + nhanVienFullTime.getTen() + "   Luong: " + nhanVienFullTime.getLuong());
        }
    }
    public static void display( List<NhanVien> list){
        for (int i = 0; i < list.size(); i++) {
            System.out.println(i + " : "+list.get(i));
        }
    }
    public static void kiemTraLuong(List<NhanVien> list, Scanner scanner) {
        int choice1;
        do {
        System.out.println("1.Luong tong ca cong ti: ");
        System.out.println("2.Luong tong cua nhan vien Full time: ");
        System.out.println("3.Luong tong cua nhan vien Part time: ");
        System.out.println("0.Thoát");
        System.out.println("Lua chon cua ban: ");
        choice1 = Integer.parseInt(scanner.nextLine());
            switch (choice1){
                case 1:
                    tinhLuong(list);
                    double luongTong = Manager.luongTong(list);
                    System.out.println("Luong tong cua ca cong ti la: " + luongTong);
                    break;
                case 2:
                    double luongTongFullTime = Manager.tinhLuongFullTime(list);
                    System.out.println("Luong tong cua nhan vien full time la: " + luongTongFullTime);
                    break;
                case 3:
                    double luongTongPartTime = Manager.tinhLuongPartTime(list);
                    System.out.println("Luong tong cua nhan vien part time la: " + luongTongPartTime);
                    break;
            }
        if (choice1 == 0){
            break;
        }
        }while (true);
    }

    private static void kTraNhanVien(Scanner scanner, List<NhanVien> list, int choice, String maNV, String name, int soDT, String email) {
        switch (choice) {
            case 1: {
                System.out.println("Luong cung cua nhan vien: ");
                double luong = Double.parseDouble(scanner.nextLine());
                System.out.println("Tien thuong cua nhan vien: ");
                double tienThuong = Double.parseDouble(scanner.nextLine());
                System.out.println("Tien phat cua nhan vien: ");
                double tienPhat = Double.parseDouble(scanner.nextLine());
                NhanVien nhanVien = new NhanVienFullTime(maNV, name, soDT, email, luong, tienThuong, tienPhat);
                list.add(nhanVien);
                System.out.println("Tao thanh cong!!!");
                break;
            }
            case 2 :{
                System.out.println("Gio lam cua nhan vien: ");
                double gioLam = Double.parseDouble(scanner.nextLine());
                NhanVien nhanVien1 = new NhanVienPartTime(maNV, name, soDT, email, gioLam);
                list.add(nhanVien1);
                System.out.println("Tao thanh cong!!!");
                break;
            }
        }
    }
    public static void add(Scanner scanner,List<NhanVien> list){
        do {
            System.out.println("Tao thong tin nhan vien: ");
            System.out.println("1.Nhan vien FullTime: ");
            System.out.println("2.Nhan vien PratTime: ");
            System.out.println("Lua chon cua ban: ");
            int choice = Integer.parseInt(scanner.nextLine());
            System.out.println("Ma Nhan Vien: ");
            String maNV = scanner.nextLine();
            System.out.println("Ten Nhan Vien: ");
            String name = scanner.nextLine();
            System.out.println("So Dien Thoai Nhan Vien: ");
            int soDT = Integer.parseInt(scanner.nextLine());
            System.out.println("Email Nhan Vien: ");
            String email = scanner.nextLine();
            kTraNhanVien(scanner, list, choice, maNV, name, soDT, email);
            System.out.println("0.Thoát");
            String text = scanner.nextLine();
            if (text.equals("0")){
                break;
            }
        }while (true);
    }
    public static void update(Scanner scanner,List<NhanVien> list){
        int choice;
        do {
            System.out.println("Sua thong tin nhan vien ");
            hienThiThongTinNhanVien(scanner, list);
            System.out.println("0.Thoat");
            System.out.println("Lua chon cua ban: ");
            choice = Integer.parseInt(scanner.nextLine());
            suaThongTinNhanVien(scanner, list, choice, nhanVien1, nhanVien2, index, flag);
        }while (choice != 0) ;
    }

    private static void hienThiThongTinNhanVien(Scanner scanner, List<NhanVien> list) {
        System.out.println("Nhap ma nhan vien hien thi: ");
        flag = phanLoaiNhanVien(scanner, list,index);
        System.out.println("*.Ma Nhan Vien: " + list.get(index).getMaNV());
        System.out.println("1.Ten Nhan Vien: " + list.get(index).getTen());
        System.out.println("2.So Dien Thoai Nhan Vien: " + list.get(index).getSoDT());
        System.out.println("3.Email Nhan Vien: " + list.get(index).getEmail());
        if (flag) {
            nhanVien1 = ((NhanVienFullTime) list.get(index));
            System.out.println("4,Luong cung cua nhan vien: " + nhanVien1.getLuong());
            System.out.println("5.Tien thuong cua nhan vien: " + nhanVien1.getTienThuong());
            System.out.println("6.Tien phat cua nhan vien: " + nhanVien1.getTienPhat());
        } else {
            nhanVien2 = ((NhanVienPartTime) list.get(index));
            System.out.println("4.Gio lam cua nhan vien: " + nhanVien2.getGioLam());
        }
    }

    private static void suaThongTinNhanVien(Scanner scanner, List<NhanVien> list, int choice, NhanVienFullTime nhanVien1, NhanVienPartTime nhanVien2, int index, boolean flag) {
        switch (choice) {
            case 1:
                System.out.println("1.Ten Nhan Vien: " + list.get(index).getTen());
                suaThongTinTen(scanner, list, index);break;
            case 2:
                System.out.println("2.So Dien Thoai Nhan Vien: " + list.get(index).getSoDT());
                suaThongTinSoDT(scanner, list, index);break;
            case 3:
                System.out.println("3.Email Nhan Vien: " + list.get(index).getEmail());
                suaThongTinEmail(scanner, list, index);break;
            case 4: if (flag) {
                    System.out.println("4,Luong cung cua nhan vien: " + nhanVien1.getLuong());
                    suaThongTinLuongCung(scanner, nhanVien1);
                } else {
                    System.out.println("4.Gio lam cua nhan vien: " + nhanVien2.getGioLam());
                    suaThongTinGiolam(scanner, nhanVien2);
                }break;
            case 5: if (flag) {
                    System.out.println("5.Tien thuong cua nhan vien: " + nhanVien1.getTienThuong());
                    suaThongTinTienThuong(scanner, nhanVien1);
                }break;
            case 6:if (flag) {
                    System.out.println("6.Tien phat cua nhan vien: " + nhanVien1.getTienPhat());
                    suaThongTinTienPhat(scanner, nhanVien1);
                }break;
        }
    }
    private static boolean phanLoaiNhanVien(Scanner scanner, List<NhanVien> list, int index) {
        boolean flag = false;
        String text = scanner.nextLine();
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getMaNV().equals(text)) {
                index = i;
            }
            if (list.get(index) instanceof NhanVienFullTime) {
                flag = true;
                break;
            }
        }
        return flag;
    }

    private static void suaThongTinTen(Scanner scanner, List<NhanVien> list, int index) {
        String name = scanner.nextLine();
        if (!Objects.equals(name, " ")) {
            list.get(index).setTen(name);
        }
    }

    private static void suaThongTinSoDT(Scanner scanner, List<NhanVien> list, int index) {
        String soDTText = scanner.nextLine();
        if (!Objects.equals(soDTText, "")) {
            int soDT = Integer.parseInt(soDTText);
            list.get(index).setSoDT(soDT);
        }
    }

    private static void suaThongTinEmail(Scanner scanner, List<NhanVien> list, int index) {
        String email = scanner.nextLine();
        if (!Objects.equals(email, "")) {
            list.get(index).setEmail(email);
        }
    }

    private static void suaThongTinGiolam(Scanner scanner, NhanVienPartTime nhanVien2) {
        String gioLamText = scanner.nextLine();
        if (!Objects.equals(gioLamText, "")) {
            double gioLam = Double.parseDouble(scanner.nextLine());
            nhanVien2.setGioLam(gioLam);
        }
    }

    private static void suaThongTinLuongCung(Scanner scanner, NhanVienFullTime nhanVien1) {
        String luongText = scanner.nextLine();
        if (!Objects.equals(luongText, "")) {
            double luong = Double.parseDouble(luongText);
            nhanVien1.setLuong(luong);
        }
    }

    private static void suaThongTinTienThuong(Scanner scanner, NhanVienFullTime nhanVien1) {
        String tienThuongText = scanner.nextLine();
        if (!Objects.equals(tienThuongText, "")) {
            double luong = Double.parseDouble(tienThuongText);
            nhanVien1.setTienThuong(luong);
        }
    }

    private static void suaThongTinTienPhat(Scanner scanner, NhanVienFullTime nhanVien1) {
        String tienPhatText = scanner.nextLine();
        if (!Objects.equals(tienPhatText, "")) {
            double luong = Double.parseDouble(tienPhatText);
            nhanVien1.setTienPhat(luong);
        }
    }

}
