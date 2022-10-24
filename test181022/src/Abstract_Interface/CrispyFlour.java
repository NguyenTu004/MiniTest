package Abstract_Interface;

import java.time.LocalDate;

public class CrispyFlour extends Material implements Discount{
    private int quantity;

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public CrispyFlour() {
    }

    @Override
    public double getAmount() {
        return quantity * getCost() ;
    }

    public CrispyFlour(int quantity) {
        this.quantity = quantity;
    }

    public CrispyFlour(String id, String name, LocalDate manufacturingDate, int cost, int quantity) {
        super(id, name, manufacturingDate, cost);
        this.quantity = quantity;
    }



    @Override
    public LocalDate getExpiryDate() {
        return super.getManufacturingDate().plusYears(+1);
    }
    @Override
    public double getRealMoney(int num) {
        return   (getAmount()*(1-num/100));
    }

    @Override
    public String toString() {
        return "CrispyFlour{" +
                super.toString() +
                " quantity=" + quantity +
                '}';
    }
}
