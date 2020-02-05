package be.hogent.eindproject.model.infrastructure;

import be.hogent.eindproject.model.model.Beverage;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class RepositorysTest {
    BeverageRepository beverageRepository = new BeverageRepository();

    @Test
    void findByID() {
        Beverage beverage = beverageRepository.findByID(1);

        assertThat(beverage.getBeverageID()).isEqualTo(1);
        assertThat(beverage.getBeverageName()).isEqualTo("Cola");
        assertThat(beverage.getPrice()).isEqualTo(2.40);
    }

    @Test
    void getAllBeverages() {
        List<Beverage> beverages = beverageRepository.getAllBeverages();

        assertThat(beverages).isNotEmpty();
        assertThat(beverages).containsAll(getAllBeveragesInDatabase());
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