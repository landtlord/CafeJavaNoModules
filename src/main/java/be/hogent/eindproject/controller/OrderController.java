package be.hogent.eindproject.controller;

import be.hogent.eindproject.controller.DTO.BeverageDTO;
import be.hogent.eindproject.controller.DTO.OrderDTO;
import be.hogent.eindproject.controller.DTO.mappers.BeverageMapper;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class OrderController extends Controller {

    private List<BeverageDTO> beverageDTOs;

    public OrderController() {
        super();
        beverageDTOs = beverageRepository.getAllBeverages()
                .stream()
                .map(BeverageMapper::mapToBeverageDTO)
                .collect(Collectors.toList());
    }

    public List<BeverageDTO> getBeverageDTOs() {
        return beverageDTOs;
    }

    public List<OrderDTO> getOrdersFor(int tableNumber) {
        return new ArrayList<>();
    }
}
