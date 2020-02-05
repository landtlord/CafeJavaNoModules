package be.hogent.eindproject.controller;

import be.hogent.eindproject.model.infrastructure.WaiterRepository;
import be.hogent.eindproject.model.model.Waiter;

import java.util.StringJoiner;

public class WaiterController {
    private WaiterRepository waiterRepository;

    public WaiterController() {
        this.waiterRepository = new WaiterRepository();
    }

    public String getFullNameOfWaiterBy(int id) {
        Waiter waiter = waiterRepository.findByID(id);
        StringJoiner sj = new StringJoiner(" ");
        sj.add(waiter.getFirstName()).add(waiter.getLastName());
        return sj.toString();
    }

}
