package NhanVien;

import java.time.LocalDateTime;

public class NhanVienPartTime extends NhanVien implements TinhLuong{
    public static final int LUONGTHEOGIO = 100000;
    private double gioLam;

    public NhanVienPartTime() {
    }

    public NhanVienPartTime(double gioLam) {
        this.gioLam = gioLam;
    }

    public NhanVienPartTime(String maNV, String ten, String soDT, String email, double gioLam) {
        super(maNV, ten, soDT, email);
        this.gioLam = gioLam;
    }

    public double getGioLam() {
        return gioLam;
    }

    public void setGioLam(double gioLam) {
        this.gioLam = gioLam;
    }

    @Override
    public String toString() {
        return "NhanVienPartTime { " +
                super.toString() +
                "gioLam=" + gioLam +
                " }";
    }

    @Override
    public double tinhLuong() {
        return getGioLam()*LUONGTHEOGIO;
    }
}
