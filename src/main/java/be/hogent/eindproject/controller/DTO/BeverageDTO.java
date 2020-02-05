package be.hogent.eindproject.controller.DTO;

import java.util.Objects;

public class BeverageDTO {
    private int beverageID;
    private String beverageName;
    private double price;

    public BeverageDTO() {
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

    public void setBeverageID(int beverageID) {
        this.beverageID = beverageID;
    }

    public void setBeverageName(String beverageName) {
        this.beverageName = beverageName;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BeverageDTO that = (BeverageDTO) o;
        return beverageID == that.beverageID &&
                Double.compare(that.price, price) == 0 &&
                Objects.equals(beverageName, that.beverageName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(beverageID, beverageName, price);
    }

    @Override
    public String toString() {
        return "BeverageDTO{" +
                "beverageID=" + beverageID +
                ", beverageName='" + beverageName + '\'' +
                ", price=" + price +
                '}';
    }
}
