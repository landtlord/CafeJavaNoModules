package be.hogent.eindproject.model.model;


import java.util.Objects;

public class Beverage {
    private final int beverageID;
    private final String beverageName;
    private final double price;

    public Beverage(int beverageID, String beverageName, double price) {
        this.beverageID = beverageID;
        this.beverageName = beverageName;
        this.price = price;
    }

    public int getBeverageID() {
        return this.beverageID;
    }

    public String getBeverageName() {
        return this.beverageName;
    }

    public double getPrice() {
        return this.price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Beverage beverage = (Beverage) o;
        return beverageID == beverage.beverageID;
    }

    @Override
    public int hashCode() {
        return Objects.hash(beverageID);
    }


}
