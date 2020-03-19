package com.ioana;

import com.ioana.Domain.CheckInValidator;
import com.ioana.Repository.CheckInRepository;
import com.ioana.Service.CheckInService;
import com.ioana.UserInterface.Console;

import java.security.KeyException;

public class Main {

    public static void main(String[] args) throws KeyException {

        CheckInRepository checkInRepository = new CheckInRepository();
        CheckInValidator checkInValidator = new CheckInValidator();
        CheckInService checkInService = new CheckInService(checkInRepository, checkInValidator);

        checkInService.addCheckInService(1, 4, 10, 7);
        checkInService.checkOutService(10, "sddss", 4);

        checkInService.addCheckInService(2, 2, 10, 3);
        checkInService.checkOutService(10, "dddss", 2);

        checkInService.addCheckInService(3, 2, 10, 3);
        checkInService.checkOutService(10, "gtttt", 5);

        checkInService.addCheckInService(4, 1, 13, 6);
        checkInService.checkOutService(13, "hhhhk", 2);

        checkInService.addCheckInService(5, 1, 13, 6);
        checkInService.checkOutService(13, "hhhhk", 3);




        Console console = new Console(checkInService);
        console.runUserInterface();


    }
}
