package NhanVien;

public class NhanVien {
    private String maNV;
    private String ten;
    private int soDT;
    private String email;

    public NhanVien() {
    }

    public NhanVien(String maNV, String ten, int soDT, String email) {
        this.maNV = maNV;
        this.ten = ten;
        this.soDT = soDT;
        this.email = email;
    }

    public String getMaNV() {
        return maNV;
    }

    public void setMaNV(String maNV) {
        this.maNV = maNV;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public int getSoDT() {
        return soDT;
    }

    public void setSoDT(int soDT) {
        this.soDT = soDT;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "maNV='" + maNV + '\'' +
                ", ten='" + ten + '\'' +
                ", soDT=" + soDT +
                ", email='" + email + '\'';
    }
}
