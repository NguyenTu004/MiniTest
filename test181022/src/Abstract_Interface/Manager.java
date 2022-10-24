package Abstract_Interface;


import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.Scanner;

public class Manager {
    private static String id;
    private static String name;
    private static int  cost;
    private static double weight;
    private static int quantity;
    private static int days;
    private static int month;
    private static int year;
    private static int index;
    private static double moneyDiscount;

    private static double money;
    private static double moneyExpired;

    public static void displayAdd(Scanner scanner, int choice,ArrayList<Material> arrayslist) {
        System.out.println("_________________________________________________");
        System.out.println("Id sản phẩm: ");
        id = scanner.nextLine();
        System.out.println("Tên sản phẩm: ");
        name = scanner.nextLine();
        System.out.println("Ngày sản xuất sản phẩm: ");
        date(scanner);
        LocalDate manufacturingDate= LocalDate.of(year, month, days);
        System.out.println("Giá sản phẩm: ");
        cost = Integer.parseInt(scanner.nextLine());
        switch (choice){
            case 1: System.out.println("Số lượng: ");
                quantity = Integer.parseInt(scanner.nextLine());
                CrispyFlour crispyFlour = new CrispyFlour(id,name,manufacturingDate,cost,quantity);
                System.out.println(crispyFlour);
                 arrayslist.add(crispyFlour);
                break;
            case 2:System.out.println("Cân nặng: ");
                weight = Integer.parseInt(scanner.nextLine());
                Meat meat = new Meat(id,name,manufacturingDate,cost,weight);
                System.out.println(meat);
                arrayslist.add( meat);
                break;
        }
    }

    private static void date(Scanner scanner) {
        System.out.println("Ngày:");
        days = Integer.parseInt(scanner.nextLine());
        System.out.println("Tháng: ");
        month = Integer.parseInt(scanner.nextLine());
        System.out.println("Năm: ");
        year = Integer.parseInt(scanner.nextLine());
    }

    public static void add(ArrayList<Material> arrayslist, Scanner scanner){
        System.out.println("Menu");
        System.out.println("1.Bột: ");
        System.out.println("2.Thịt: ");
        int choice = Integer.parseInt(scanner.nextLine());
        displayAdd(scanner,choice,arrayslist);

    }
    public static void delete(ArrayList<Material> arrayslist, Scanner scanner) {
        System.out.println("Menu");
        System.out.println("Vị trí cần xóa(1-"+arrayslist.size()+"): ");
        int index = Integer.parseInt( scanner.nextLine())-1;
        arrayslist.remove(index);
    }
    public static void edit(ArrayList<Material> arrayslist, Scanner scanner) {
        System.out.println("Menu");
        System.out.println("Vị trí cần sửa(1-"+arrayslist.size()+"): ");
        int index = Integer.parseInt( scanner.nextLine())-1;
        System.out.println("Id sản phẩm: "+ arrayslist.get(index).getId());
        id = scanner.nextLine();
        System.out.println("Tên sản phẩm: "+ arrayslist.get(index).getName());
        name = scanner.nextLine();
        System.out.println("Giá sản phẩm: "+ arrayslist.get(index).getCost());
        cost = Integer.parseInt(scanner.nextLine());
        checkMeatCeispyFlour(arrayslist, scanner, index);
        checkEdit(arrayslist, index);
        System.out.println(arrayslist.get(index));

    }

    private static void checkMeatCeispyFlour(ArrayList<Material> arrayslist, Scanner scanner, int index) {
        if (arrayslist.get(index) instanceof Meat){
            Meat meat = (Meat) arrayslist.get(index);
            System.out.println("Cân nặng: "+ meat.getWeight());
            weight = Integer.parseInt(scanner.nextLine());

        }else{
            CrispyFlour crispyFlour = (CrispyFlour) arrayslist.get(index);
            System.out.println("Số lượng: "+ crispyFlour.getQuantity());
            quantity = Integer.parseInt(scanner.nextLine());
        }
    }

    public static void checkEdit(ArrayList<Material> arrayslist,int index){
        arrayslist.get(index).setId(id);
        arrayslist.get(index).setName(name);
        arrayslist.get(index).setCost(cost);
        if(arrayslist.get(index) instanceof Meat) {
            Meat pro = (Meat) arrayslist.get(index);
            pro.setWeight(weight);
        }else{
            CrispyFlour pro = (CrispyFlour) arrayslist.get(index);
            pro.setQuantity(quantity);
        }
    }
    public static void display(ArrayList<Material> arrayslist){
        for (Material material : arrayslist) {
            System.out.println(material);
        }
    }
    public static void displayDiscountPro(ArrayList<Material> arrayslist, Scanner scanner){
        System.out.println("Menu");
        System.out.println("Nhập thời gian hôm nay: ");
        date(scanner);
        LocalDate date= LocalDate.of(year, month, days);
        double discount =  extracted(arrayslist, date);
        System.out.println("Giá thành chênh lệch giữa chiết khấu và không chiết khấu tại ngày hôm nay là: "+discount);

    }

    private static double extracted(ArrayList<Material> arrayslist, LocalDate date) {
        for (int i = 0; i< arrayslist.size(); i++) {
            kTraHanSD(arrayslist, date, i);
            hienThiSanPhamHetHanSD(arrayslist);
        }
        if (moneyExpired != 0){
            System.out.println("Tong so tien san pham het han: "+moneyExpired);
        }
        System.out.println("Tong tien tat ca san pham: "+money);
        System.out.println("Tong so tien cua san pham giam gia: "+moneyDiscount);
        return money - moneyDiscount-moneyExpired;
    }

    private static void hienThiSanPhamHetHanSD(ArrayList<Material> arrayslist) {
        if (days < 0 || month < 0) {
            if (arrayslist.get(index) instanceof Meat){
            System.out.println("Ten san pham: " + arrayslist.get(index).getName() + "   Gia: " + arrayslist.get(index).getCost()+" can nang: "+ ((Meat) arrayslist.get(index)).getWeight());
            }else if (arrayslist.get(index) instanceof CrispyFlour){
                CrispyFlour crispyFlour = (CrispyFlour) arrayslist.get(index);
                System.out.println("Ten san pham: " + crispyFlour.getName() + "   Gia: " +crispyFlour.getCost()+" can nang: "+ crispyFlour.getQuantity());
            }
        }
    }

    private static void kTraHanSD(ArrayList<Material> arrayslist, LocalDate date, int i) {
        if (arrayslist.get(i) instanceof Meat) {
            Meat meat = ((Meat) arrayslist.get(i));
            Period period = Period.between(date,meat.getExpiryDate());
            days = period.getDays();
            if (days < 5 && days > 0) {
                moneyDiscount += meat.getRealMoney(30);
            }else if (days > 0){
                moneyDiscount += meat.getRealMoney(10);
                money += meat.getAmount();
            }else if (days < 0){
                money += meat.getAmount();
                moneyExpired += meat.getAmount();
                index = i;
            }
        }else{
            CrispyFlour crispyFlour = (CrispyFlour) arrayslist.get(i);
            Period period = Period.between(date,crispyFlour.getExpiryDate());
            month = period.getMonths();
            if (month == 1) {
                moneyDiscount += crispyFlour.getRealMoney(40);
            }else if (month < 4 && month > 0){
                moneyDiscount += crispyFlour.getRealMoney(5);
            }else if (month > 0){
                moneyDiscount += crispyFlour.getCost();
                money +=crispyFlour.getAmount();
            }else if (month < 0){
                money +=crispyFlour.getAmount();
                moneyExpired += crispyFlour.getAmount();
                index = i;
            }
        }
    }
}
