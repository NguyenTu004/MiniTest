package NhanVien;

import java.io.FileOutputStream;
import java.io.*;
import java.util.*;
import java.lang.*;

import static NhanVien.ManagerFullTime.listNhanVienFullTime;
import static NhanVien.ManagerPartTime.listNhanVienPartTime;

public class Manager {
//    public List<NhanVienFullTime> listNhanVienFullTime = new ArrayList<>();
//    public List<NhanVienPartTime> listNhanVienPartTime = new ArrayList<>();
    public NhanVienFullTime nhanVien1 ;
    public NhanVienPartTime nhanVien2 ;
    public static final String PATH_NHAN_VIEN ="C:\\Users\\ASUS\\Desktop\\Máy tính\\Test_Java\\test181022\\src\\NhanVien\\File_luu_tru\\nhanVien.txt";
    static int index ;
    static boolean flag ;

    public Manager() {
    }

//    public void hienThiLuongCaCongTy(List<NhanVien> list){
//        fullTime.tinhTongLuongFullTime(list);
//        partTime.tinhTongLuongPartTime(list);
//    }
    public void phanLoaiNhanVien( List<NhanVien> list){
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
    public double luongTongCaCongTy( List<NhanVien> list){
        ManagerPartTime partTime = new ManagerPartTime();
        ManagerFullTime fullTime = new ManagerFullTime();
        double luongTongPartTime = partTime.tinhTongLuongPartTime(list);
        double luongTongFullTime = fullTime.tinhTongLuongFullTime(list);
        return luongTongFullTime+luongTongPartTime;
    }
    public double luongTrungBinhCaCongTy( List<NhanVien> list){
        double luongTong = luongTongCaCongTy(list);
        return  luongTong/list.size();

    }
    public void hienThiThongTinCaCongTy( List<NhanVien> list){
        for (int i = 0; i < list.size(); i++) {
            System.out.println((i+1) + " : "+list.get(i));
        }
    }
    public void kiemTraLuongCaCongTy(List<NhanVien> list, Scanner scanner) {
        int choice;
        ManagerPartTime partTime = new ManagerPartTime();
        ManagerFullTime fullTime = new ManagerFullTime();
        do {
            System.out.println("1.Luong tong ca cong ti: ");
            System.out.println("2.Luong tong cua nhan vien Full time: ");
            System.out.println("3.Luong tong cua nhan vien Part time: ");
            System.out.println("0.Thoát");
            System.out.println("Lua chon cua ban: ");
        choice = Integer.parseInt(scanner.nextLine());
            switch (choice){
                case 1:
//                    hienThiLuongCaCongTy(list);
                    try {
                        double luongTong = luongTongCaCongTy(list);
                        System.out.println("Luong tong cua ca cong ti la: " + luongTong);
                    }catch (Exception e){
                        System.out.println(e.getMessage());
                    }
                    break;
                case 2:
                    double luongTongFullTime = fullTime.tinhTongLuongFullTime(list);
                    System.out.println("Luong tong cua nhan vien full time la: " + luongTongFullTime);
                    break;
                case 3:
                    double luongTongPartTime = partTime.tinhTongLuongPartTime(list);
                    System.out.println("Luong tong cua nhan vien part time la: " + luongTongPartTime);
                    break;
            }
        }while (choice != 0);
    }

    private void kiemTraNhanVien(Scanner scanner, List<NhanVien> list, int choice, String maNV, String name, String soDT, String email) {
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
    public void taoThongTinNhanVien(Scanner scanner,List<NhanVien> list){
        do {
            try {
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
                String soDT = scanner.nextLine();
                System.out.println("Email Nhan Vien: ");
                String email = scanner.nextLine();
                kiemTraNhanVien(scanner, list, choice, maNV, name, soDT, email);
            }catch (Exception e){
                System.out.println("Nhap sai du lieu! moi ban nhap lai!!!");
            }
            writeFile(list);
            System.out.println("0.Thoát");
            String text = scanner.nextLine();
            if (text.equals("0")){
                break;
            }
        }while (true);
    }
    public void suaThongTinNhanVien(Scanner scanner,List<NhanVien> list){
        int choice;
        do {
            System.out.println("Sua thong tin nhan vien ");
            hienThiThongTinNhanVien(scanner, list);
            System.out.println("0.Thoat");
            System.out.println("Lua chon cua ban: ");
            choice = Integer.parseInt(scanner.nextLine());
            suaThongTinNhanVien(scanner, list, choice, nhanVien1, nhanVien2, index, flag);
            writeFile(list);
        }while (choice != 0) ;
    }

    private void hienThiThongTinNhanVien(Scanner scanner, List<NhanVien> list) {
        System.out.println("Nhap ma nhan vien hien thi: ");
        String text = scanner.nextLine();
        flag = phanLoaiNhanVien(list,text);
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

    private void suaThongTinNhanVien(Scanner scanner, List<NhanVien> list, int choice, NhanVienFullTime nhanVien1, NhanVienPartTime nhanVien2, int index, boolean flag) {
        ManagerPartTime partTime = new ManagerPartTime();
        ManagerFullTime fullTime = new ManagerFullTime();
        switch (choice) {
            case 1:
                System.out.println("1.Ten Nhan Vien: " + list.get(index).getTen());
                suaThongTinNhanVienKieuChu(scanner, list, index,1);break;
            case 2:
                System.out.println("2.So Dien Thoai Nhan Vien: " + list.get(index).getSoDT());
                suaThongTinNhanVienKieuChu(scanner, list, index,3);break;
            case 3:
                System.out.println("3.Email Nhan Vien: " + list.get(index).getEmail());
                suaThongTinNhanVienKieuChu(scanner, list, index,2);break;
            case 4: if (flag) {
                System.out.println("4,Luong cung cua nhan vien: " + nhanVien1.getLuong());
                fullTime.suaThongTinFullTime(scanner, nhanVien1,1);
                } else {
                System.out.println("4.Gio lam cua nhan vien: " + nhanVien2.getGioLam());
                    partTime.suaThongTinPartTime(scanner, nhanVien2);
                }break;
            case 5: if (flag) {
                System.out.println("5.Tien thuong cua nhan vien: " + nhanVien1.getTienThuong());
                fullTime.suaThongTinFullTime(scanner, nhanVien1,2);
                }break;
            case 6:if (flag) {
                System.out.println("6.Tien phat cua nhan vien: " + nhanVien1.getTienPhat());
                fullTime.suaThongTinFullTime(scanner, nhanVien1,3);
                }break;
        }
    }
    private boolean phanLoaiNhanVien(List<NhanVien> list,String text ) {
        boolean flag = false;
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getMaNV().equals(text)) {
                index = i;
                if (list.get(index) instanceof NhanVienFullTime) {
                    flag = true;
                }
                break;
            }
        }
        return flag;
    }
    private void suaThongTinNhanVienKieuChu(Scanner scanner, List<NhanVien> list, int index,int choice) {
            String text = scanner.nextLine();
            if (!Objects.equals(text, "")) {
                    switch (choice){
                        case 1: list.get(index).setTen(text);break;
                        case 2: list.get(index).setEmail(text);break;
                        case 3:
                            try{
                                int num =Integer.parseInt(text);
                                list.get(index).setSoDT(text);break;
                            }catch (Exception e){
                                System.err.println("Nhap sai du lieu");
                            }
                            break;
                    }
            }
    }
    public void xoaThongTinNhanVien(Scanner scanner,List<NhanVien> list){
        hienThiThongTinNhanVien(scanner,list);
        System.out.println("Ban co muon xoa thong tin nhan vien: "+list.get(index).getTen());
        System.out.println("Nhap 'xoa' de xac nhan: ");
        String text = scanner.nextLine();
        if (text.equals("xoa")){
            list.remove(index);
            writeFile(list);
        }
    }
    public static void writeFile( List<NhanVien> list){
        try{
            FileOutputStream fos = new FileOutputStream(PATH_NHAN_VIEN);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(list);
            fos.close();
            oos.close();
        }catch (IOException e){
            e.printStackTrace();
        }
    }
    public static List<NhanVien> readFile(){
        List<NhanVien> list = new ArrayList<NhanVien>();
        try {
            FileInputStream in = new FileInputStream(PATH_NHAN_VIEN);
            ObjectInputStream ois = new ObjectInputStream(in);
            list = (List<NhanVien>) ois.readObject() ;
        }catch (IOException | ClassNotFoundException e){
            e.printStackTrace();
        }
        return list;
    }
}
