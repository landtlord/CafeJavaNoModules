package be.hogent.eindproject.controller;

import be.hogent.eindproject.model.infrastructure.WaiterRepository;
import be.hogent.eindproject.model.model.Waiter;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class LogInControllerTest {
    private LogInController logInController;

    private WaiterRepository waiterRepository;

    @BeforeEach
    void setUp() {
        waiterRepository = mock(WaiterRepository.class);
        logInController = new LogInController(waiterRepository);
    }

    @Test
    void givenCorrectCredentials_whenCheckLogin_thenTrueIsReturned() {
        int id = 1;
        String password = "password";
        Waiter waiter = new Waiter(id,"lastName","firstName",password);

        when(waiterRepository.findByID(id)).thenReturn(waiter);

        boolean result = logInController.checkLogin(id,password);

        assertTrue(result);
    }

    @Test
    void givenWrongCredentials_whenCheckLogin_thenFalseIsReturned() {
        int id = 1;
        String password = "password";
        Waiter waiter = new Waiter(id,"lastName","firstName",password + "wrong");

        when(waiterRepository.findByID(id)).thenReturn(waiter);

        boolean result = logInController.checkLogin(id,password);

        assertFalse(result);
    }
}