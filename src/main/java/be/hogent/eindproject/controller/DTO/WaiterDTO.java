package be.hogent.eindproject.controller.DTO;

import java.util.Objects;

public class WaiterDTO {
    private int id;
    private String lastName;
    private String firstName;
    private String password;

    public WaiterDTO() {
    }

    public int getId() {
        return this.id;
    }

    public String getLastName() {
        return this.lastName;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public String getPassword() {
        return this.password;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        WaiterDTO waiterDTO = (WaiterDTO) o;
        return id == waiterDTO.id &&
                Objects.equals(lastName, waiterDTO.lastName) &&
                Objects.equals(firstName, waiterDTO.firstName) &&
                Objects.equals(password, waiterDTO.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, lastName, firstName, password);
    }

    @Override
    public String toString() {
        return "WaiterDTO{" +
                "id=" + id +
                ", lastName='" + lastName + '\'' +
                ", firstName='" + firstName + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
