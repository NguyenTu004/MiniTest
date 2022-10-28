package NhanVien;

import java.io.FileOutputStream;
import java.io.*;
import java.util.*;
import java.lang.*;
public class Manager {
    static List<NhanVienFullTime> listNhanVienFullTime = new ArrayList<>();
    static List<NhanVienPartTime> listNhanVienPartTime = new ArrayList<>();
    static NhanVienFullTime nhanVien1 ;
    static NhanVienPartTime nhanVien2 ;
    static final String pathNhanVien ="C:\\Users\\ASUS\\Desktop\\Máy tính\\Test_Java\\test181022\\src\\NhanVien\\File_luu_tru\\nhanVien.txt";

    static int index ;
    static boolean flag ;


    public static void tinhLuong(List<NhanVien> list){
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
            luongRead = nhanVienPartTime.tinhLuong();
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
            luongRead = nhanVienFullTime.tinhLuong();
            System.out.println("Nhan vien Full Time: " + nhanVienFullTime.getTen() + " : " + luongRead + " VND");
            luongTongFullTime += luongRead;
        }
        return luongTongFullTime;
    }
    public static double luongTong( List<NhanVien> list){
        double luongTong=0;
        phanLoaiNhanVien(list);
        for (NhanVienPartTime nhanVienPartTime : listNhanVienPartTime) {
            luongTong += nhanVienPartTime.tinhLuong();
        }
        for (NhanVienFullTime nhanVienFulltTime : listNhanVienFullTime) {
            luongTong += nhanVienFulltTime.tinhLuong();
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
                System.out.println("STT: "+(i+1)+" : "+" Nhan Vien Full Time yeu kem:\t Ten: " +listNhanVienFullTime.get(i).getTen()+"\t\t Luong: "+ listNhanVienFullTime.get(i).getLuong() + "VND");
            }
        }
    }
    public static void sapXepNhanVienFullTime( List<NhanVien> list){
        phanLoaiNhanVien(list);
        SapXepNVFullTime sapXep = new SapXepNVFullTime();
        Collections.sort(listNhanVienFullTime,sapXep);
        for (NhanVienFullTime nhanVienFullTime : listNhanVienFullTime) {
            System.out.println("Ten: " + nhanVienFullTime.getTen() + "\t\t Luong: " + nhanVienFullTime.getLuong());
        }
    }
    public static void display( List<NhanVien> list){
        for (int i = 0; i < list.size(); i++) {
            System.out.println((i+1) + " : "+list.get(i));
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

    private static void kTraNhanVien(Scanner scanner, List<NhanVien> list, int choice, String maNV, String name, String soDT, String email) {
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
                kTraNhanVien(scanner, list, choice, maNV, name, soDT, email);
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
    public static void update(Scanner scanner,List<NhanVien> list){
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

    private static void hienThiThongTinNhanVien(Scanner scanner, List<NhanVien> list) {
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

    private static void suaThongTinNhanVien(Scanner scanner, List<NhanVien> list, int choice, NhanVienFullTime nhanVien1, NhanVienPartTime nhanVien2, int index, boolean flag) {
        switch (choice) {
            case 1:
                System.out.println("1.Ten Nhan Vien: " + list.get(index).getTen());
                suaThongTinNVDangChu(scanner, list, index,1);break;
            case 2:
                System.out.println("2.So Dien Thoai Nhan Vien: " + list.get(index).getSoDT());
                suaThongTinNVDangChu(scanner, list, index,3);break;
            case 3:
                System.out.println("3.Email Nhan Vien: " + list.get(index).getEmail());
                suaThongTinNVDangChu(scanner, list, index,2);break;
            case 4: if (flag) {
                    System.out.println("4,Luong cung cua nhan vien: " + nhanVien1.getLuong());
                suaThongTinFullTime(scanner, nhanVien1,1);
                } else {
                    System.out.println("4.Gio lam cua nhan vien: " + nhanVien2.getGioLam());
                    suaThongTinPartTime(scanner, nhanVien2);
                }break;
            case 5: if (flag) {
                    System.out.println("5.Tien thuong cua nhan vien: " + nhanVien1.getTienThuong());
                suaThongTinFullTime(scanner, nhanVien1,2);
                }break;
            case 6:if (flag) {
                    System.out.println("6.Tien phat cua nhan vien: " + nhanVien1.getTienPhat());
                    suaThongTinFullTime(scanner, nhanVien1,3);
                }break;
        }
    }
    private static boolean phanLoaiNhanVien(List<NhanVien> list,String text ) {
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

    private static void suaThongTinNVDangChu(Scanner scanner, List<NhanVien> list, int index,int choice) {
            String text = scanner.nextLine();
            if (!Objects.equals(text, "")) {
                    switch (choice){
                        case 1: list.get(index).setTen(text);break;
                        case 2: list.get(index).setEmail(text);break;
                        case 3:
                            try{
                                int soDT =Integer.parseInt(text);
                                list.get(index).setSoDT(text);break;
                            }catch (Exception e){
                                System.err.println("Nhap sai du lieu");
                            }
                            break;
                    }
            }
    }
    private static void suaThongTinPartTime(Scanner scanner, NhanVienPartTime nhanVien2) {
        boolean flag;
        do {
            flag = false;
            String gioLamText = scanner.nextLine();
            if (!Objects.equals(gioLamText, "")) {
                try {
                    double gioLam = Double.parseDouble(gioLamText);
                    nhanVien2.setGioLam(gioLam);
                }catch (Exception exceptions){
                    System.err.println("Nhap du lieu dang so: ");
                    flag = true;
                }
            }
        }while (flag);
    }
    private static void suaThongTinFullTime(Scanner scanner, NhanVienFullTime nhanVien1,int choice) {
        boolean flag;
        do {
            flag = false;
            String tienText = scanner.nextLine();
            if (!Objects.equals(tienText, "")) {
                try {
                    double tienSo = Double.parseDouble(tienText);
                    switch (choice){
                        case 1:nhanVien1.setLuong(tienSo);break;
                        case 2: nhanVien1.setTienThuong(tienSo);break;
                        case 3: nhanVien1.setTienPhat(tienSo);;break;
                    }
                }catch (Exception exceptions){
                    System.err.println("Nhap du lieu dang so: ");
                    flag = true;
                }
            }
        }while (flag);
    }
    public static void delete(Scanner scanner,List<NhanVien> list){
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
            FileOutputStream fos = new FileOutputStream(pathNhanVien);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(list);
            fos.close();
            oos.close();
        }catch (IOException e){
            e.printStackTrace();
        }
    }
    public static List<NhanVien> readFile(){
        List<NhanVien> listFull ;
        List<NhanVien> list = new ArrayList<NhanVien>();
        try {
            FileInputStream in = new FileInputStream(pathNhanVien);
            ObjectInputStream ois = new ObjectInputStream(in);
            listFull = (List<NhanVien>) ois.readObject();
           list = listFull;
        }catch (IOException | ClassNotFoundException e){
            e.printStackTrace();
        }
        return list;
    }
}
