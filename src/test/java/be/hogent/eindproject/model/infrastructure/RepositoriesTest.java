package be.hogent.eindproject.model.infrastructure;

import be.hogent.eindproject.model.model.Beverage;
import be.hogent.eindproject.model.model.Order;
import be.hogent.eindproject.model.model.Waiter;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class RepositoriesTest {
    BeverageRepository beverageRepository = new BeverageRepository();
    OrderRepository orderRepository = new OrderRepository();
    WaiterRepository waiterRepository = new WaiterRepository();

    @Test
    void givenBeverageRepository_whenFindByID_theTheCorrectBeverageIsProvide() {
        //when
        Beverage beverage = beverageRepository.findByID(1);

        //then
        assertThat(beverage.getBeverageID()).isEqualTo(1);
        assertThat(beverage.getBeverageName()).isEqualTo("Cola");
        assertThat(beverage.getPrice()).isEqualTo(2.40);
    }

    @Test
    void givenBeverageRepository_whenGetAllBeveragesInDatabase_theTheCorrectListOfBeveragesIsProvide() {
        //when
        List<Beverage> beverages = beverageRepository.getAllBeverages();

        //then
        assertThat(beverages).isNotEmpty();
        assertThat(beverages).containsAll(getAllBeveragesInDatabase());
    }

    @Test
    void givenWaiterRepository_whenFindByID_theTheCorrectWaiterIsProvide() {
        //when
        Waiter waiter = waiterRepository.findByID(1);

        //then
        assertThat(waiter.getId()).isEqualTo(1);
        assertThat(waiter.getFirstName()).isEqualTo("Wout");
        assertThat(waiter.getLastName()).isEqualTo("Peters");
        assertThat(waiter.getPassword()).isEqualTo("password");

    }

    @Test
    void givenOrderRepository_whenFindByID_theTheCorrectOrderIsProvide() {
        //when
        Order order = orderRepository.findByID(1);

        //then
        assertThat(order.getId()).isEqualTo(1);
        assertThat(order.getOrderNumber()).isEqualTo(1);
        assertThat(order.getQuantity()).isEqualTo(5);
        assertThat(order.getDate()).isEqualTo(LocalDate.of(2019, 12, 13));
        assertThat(order.getBeverage()).isEqualTo(beverageRepository.findByID(1));
        assertThat(order.getWaiter()).isEqualTo(waiterRepository.findByID(1));
    }

    private List<Beverage> getAllBeveragesInDatabase() {
        return List.of(
                new Beverage(1, "Cola", 2.40),
                new Beverage(2, "Leffe", 3.00),
                new Beverage(3, "Koffie", 2.40),
                new Beverage(4, "Cola-Light", 2.40),
                new Beverage(5, "Whisky", 12.00),
                new Beverage(6, "Thee", 2.40),
                new Beverage(7, "Spa", 2.40),
                new Beverage(8, "Westmalle", 3.00),
                new Beverage(9, "Hoegaarden", 2.70),
                new Beverage(10, "Duvel", 3.20),
                new Beverage(11, "Stella", 2.20),
                new Beverage(12, "Chocomelk", 2.50),
                new Beverage(13, "Tonic", 2.40),
                new Beverage(14, "Latte", 2.80),
                new Beverage(15, "Fanta", 2.40),
                new Beverage(16, "Sprite", 2.40),
                new Beverage(17, "Minute Maid", 2.80)
        );
    }
}