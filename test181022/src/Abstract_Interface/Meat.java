package Abstract_Interface;

import java.time.LocalDate;

public class Meat extends Material implements Discount{
    private double weight;

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public Meat() {
    }

    @Override
    public double getAmount() {
        return getCost() * weight;
    }

    public Meat(double weight) {
        this.weight = weight;
    }

    public Meat(String id, String name, LocalDate manufacturingDate, int cost, double weight) {
        super(id, name, manufacturingDate, cost);
        this.weight = weight;
    }



    @Override
    public LocalDate getExpiryDate() {
        return super.getManufacturingDate().plusDays(+7);
    }


    @Override
    public String toString() {
        return "Meat{" +
                super.toString() +
                " weight=" + weight +
                '}';
    }

    @Override
    public double getRealMoney(int num) {
        return (getAmount()*(1-num/100));
    }
}
