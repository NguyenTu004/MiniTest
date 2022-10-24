package Ke_Thua;

import java.util.ArrayList;

public class Manager {
    public static double tongTien(ArrayList<Book> arrList){
        double tongtien = 0;
        for(int i = 0; i < arrList.size(); i++){
            Book book = arrList.get(i);
            tongtien += book.getPrice();
        }
        return tongtien;
    }
    public static int languageJava(ArrayList<Book> arrList) {
        int count=0;
        for (int i = 0; i < arrList.size(); i++) {
            if (arrList.get(i) instanceof ProgrammingBook) {
                ProgrammingBook proBook = (ProgrammingBook) arrList.get(i);
                if (proBook.getLanguage().equals("Java")) {
                    count++;
                }
            }
        }
        return count;
    }
    public static int category(ArrayList<Book> arrList) {
        int count=0;
        for (int i = 0; i < arrList.size(); i++) {
            if (arrList.get(i) instanceof FictionBook) {
                FictionBook ficBook = (FictionBook) arrList.get(i);
                if (ficBook.getCategory().equals("Viễn tưởng 1")) {
                    count++;
                }
            }
        }
        return count;
    }
    public static int ficPrice(ArrayList<Book> arrList) {
        int count=0;
        for (int i = 0; i < arrList.size(); i++) {
            if (arrList.get(i) instanceof FictionBook) {
                Book book = arrList.get(i);
                if (book.getPrice()<100) {
                    count++;
                }
            }
        }
        return count;
    }


}

