package be.hogent.eindproject.model.model;


import lombok.Getter;

import java.util.Objects;

@Getter
public class Waiter {
    private final int id;
    private final String lastName;
    private final String firstName;
    private final String password;

    public Waiter(int id, String lastName, String firstName, String password) {
        this.id = id;
        this.lastName = lastName;
        this.firstName = firstName;
        this.password = password;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Waiter waiter = (Waiter) o;
        return id == waiter.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
