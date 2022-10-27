package NhanVien;

import java.util.Comparator;

public class SapXepNVFullTime implements Comparator<NhanVienFullTime> {
    @Override
    public int compare(NhanVienFullTime o1, NhanVienFullTime o2) {
        if(o1.getLuong() > o2.getLuong()){
            return 1;
        }else if(o1.getLuong() == o2.getLuong()){
            return 0;
        }else{
            return -1;
        }
    }
}
