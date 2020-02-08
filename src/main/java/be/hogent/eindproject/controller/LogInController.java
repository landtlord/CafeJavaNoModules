package be.hogent.eindproject.controller;

import be.hogent.eindproject.controller.DTO.WaiterDTO;
import be.hogent.eindproject.controller.DTO.mappers.WaiterMapper;
import be.hogent.eindproject.model.infrastructure.WaiterRepository;
import be.hogent.eindproject.model.model.Waiter;

public class LogInController {
    private WaiterRepository waiterRepository;
    private WaiterDTO loggedInWaiterDTO;
    private boolean loggedIn = false;

    public LogInController() {
        this.waiterRepository = new WaiterRepository();
        setNoBodyLoggedInWaiterDTO();
    }

    //for testing with Mocked waiterRepository
    LogInController(WaiterRepository waiterRepository) {
        this.waiterRepository = waiterRepository;
        setNoBodyLoggedInWaiterDTO();
    }

    public boolean checkLogin(int waiterId, String password) {
        Waiter waiter = waiterRepository.findByID(waiterId);
        if (waiter.getPassword().equals(password)) {
            loggedInWaiterDTO = WaiterMapper
                    .mapToWaiterDTO(
                            waiterRepository.findByID(waiterId));
            loggedIn = true;
        }
        return loggedIn;
    }

    public WaiterDTO getLoggedInWaiterDTO() {
        return loggedInWaiterDTO;
    }

    public boolean isLoggedIn() {
        return loggedIn;
    }

    public void logOut() {
        loggedIn = false;
    }

    private void setNoBodyLoggedInWaiterDTO() {
        loggedInWaiterDTO = null;
    }
}
