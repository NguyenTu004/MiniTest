package NhanVien;

public class NhanVienFullTime extends NhanVien implements TinhLuong{
    private double luong;
    private double tienThuong;
    private double tienPhat;

    public NhanVienFullTime() {
    }

    public NhanVienFullTime(String maNV, String ten, String soDT, String email, double luong, double tienThuong, double tienPhat) {
        super(maNV, ten, soDT, email);
        this.luong = luong;
        this.tienThuong = tienThuong;
        this.tienPhat = tienPhat;
    }

    public double getLuong() {
        return luong;
    }

    public void setLuong(double luong) {
        this.luong = luong;
    }

    public double getTienThuong() {
        return tienThuong;
    }

    public void setTienThuong(double tienThuong) {
        this.tienThuong = tienThuong;
    }

    public double getTienPhat() {
        return tienPhat;
    }

    public void setTienPhat(double tienPhat) {
        this.tienPhat = tienPhat;
    }

    @Override
    public String toString() {
        return "NhanVienFullTime { " +
                super.toString() +
                "luong=" + luong +
                ", tienThuong=" + tienThuong +
                ", tienPhat=" + tienPhat +
                " }";
    }

    @Override
    public double tinhLuong() {
        return getLuong()+getTienThuong()-getTienPhat();
    }
}
