package be.hogent.eindproject.controller;

import be.hogent.eindproject.model.infrastructure.BeverageRepository;
import be.hogent.eindproject.model.infrastructure.OrderRepository;
import be.hogent.eindproject.model.infrastructure.WaiterRepository;

abstract class Controller {
    WaiterRepository waiterRepository;
    BeverageRepository beverageRepository;
    OrderRepository orderRepository;

    Controller() {
        waiterRepository = new WaiterRepository();
        beverageRepository = new BeverageRepository();
        orderRepository = new OrderRepository();
    }

    Controller(WaiterRepository waiterRepository) {
        this.waiterRepository = waiterRepository;
        beverageRepository = new BeverageRepository();
        orderRepository = new OrderRepository();
    }
}
