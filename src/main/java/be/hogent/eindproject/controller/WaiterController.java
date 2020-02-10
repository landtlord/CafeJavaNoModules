package be.hogent.eindproject.controller;

import be.hogent.eindproject.model.model.Waiter;

import java.util.StringJoiner;

public class WaiterController extends Controller {

    public String getFullNameOfWaiterBy(int id) {
        Waiter waiter = waiterRepository.findByID(id);
        StringJoiner sj = new StringJoiner(" ");
        sj.add(waiter.getFirstName()).add(waiter.getLastName());
        return sj.toString();
    }

}
