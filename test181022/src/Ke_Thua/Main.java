package Ke_Thua;

import java.util.ArrayList;
import java.util.Scanner;

import static Ke_Thua.Manager.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice;
        ArrayList<Book> arrayList = new ArrayList<>();
        arrayList.add( new ProgrammingBook(11,"Tu",657.0,"Tu","Java","hihi"));
        arrayList.add( new ProgrammingBook(22,"Tuu",34.0,"Tu","Java","hihihi"));
        arrayList.add( new ProgrammingBook(33,"Tung",34.0,"Tu","Java","hihihi"));
        arrayList.add(new ProgrammingBook(44,"Tut",3456.0,"Tu","pHp","hihihi"));
        arrayList.add( new ProgrammingBook(55,"Tui",34236.0,"Tu","Js","hihihi"));
        arrayList.add( new FictionBook(66,"Tuhu",435,"Tu","Viễn tưởng 1"));
        arrayList.add( new FictionBook(77,"Tull",45,"Tu","Viễn tưởng 1"));
        arrayList.add( new FictionBook(88,"chill",2,"Tu","Viễn tưởng 2"));
        arrayList.add( new FictionBook(99,"chilllll",56,"Tu","Viễn tưởng 6"));
        arrayList.add( new FictionBook(1010,"veryChill",27,"Tu","Viễn tưởng 1"));
        do{
            System.out.println("MENU");
            System.out.println("1.Tổng tiền của 10 cuốn sách");
            System.out.println("2.Đếm số sách ProgrammingBook có language là Java");
            System.out.println("3.Đếm số sách Fiction có category là Viễn tưởng 1");
            System.out.println("4.Đếm số sách Fiction có giá <100");
            System.out.println("0.Thoát");
            System.out.println("Lựa chọn của bạn?????-?????");
            choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:System.out.println("Tổng tiền của 10 cuốn sách: " +tongTien(arrayList));break;
                case 2:System.out.println("Số sách ProgrammingBook có language là Java: "+languageJava(arrayList));break;
                case 3:System.out.println("Số sách Fiction có category là Viễn tưởng 1: "+category(arrayList));break;
                case 4: System.out.println("Số sách Fiction có giá <100: "+ficPrice(arrayList));break;
            }
        }while(choice != 0);
    }
}
