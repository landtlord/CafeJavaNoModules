package be.hogent.eindproject.controller.DTO.mappers;

import be.hogent.eindproject.controller.DTO.BeverageDTO;
import be.hogent.eindproject.model.model.Beverage;

public class BeverageMapper {
     public static BeverageDTO mapToBeverageDTO(Beverage beverage){
         BeverageDTO beverageDTO = new BeverageDTO();
         beverageDTO.setBeverageID(beverage.getBeverageID());
         beverageDTO.setBeverageName(beverage.getBeverageName());
         beverageDTO.setPrice(beverage.getPrice());
         return beverageDTO;
     }

     public static Beverage mapToBeverage(BeverageDTO beverageDTO){
         return new Beverage(
                 beverageDTO.getBeverageID(),
                 beverageDTO.getBeverageName(),
                 beverageDTO.getPrice()
         );
     }
}
