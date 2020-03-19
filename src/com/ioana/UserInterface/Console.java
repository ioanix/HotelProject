package com.ioana.UserInterface;

import com.ioana.Domain.CheckIn;
import com.ioana.Domain.RatingForRoomViewModel;
import com.ioana.Service.CheckInService;
import java.security.KeyException;
import java.util.Scanner;

public class Console {

    private CheckInService checkInService;

    private Scanner scanner = new Scanner(System.in);


    public Console(CheckInService checkInService) {
        this.checkInService = checkInService;
    }


    public void runUserInterface() {

        while (true) {

            showMenu();
            String option = scanner.nextLine();

            if ("1".equals(option)) {

                this.handleAddCheckInService();

            } else if ("2".equals(option)) {

                this.handleCheckOutService();

            } else if ("3".equals(option)) {

                this.handleShowRooms();

            } else if ("a".equals(option)) {

                this.handleAll();

            } else if ("x".equals(option)) {

                break;

            } else {

                System.out.println("Comanda invalida");
            }

        }
    }


    private void showMenu() {
        System.out.println("1. Check in");
        System.out.println("2. Check out");
        System.out.println("3. Afisare camere descrescator dupa rating(ca medie)");
        System.out.println("a. Afisare toate intrarile");
        System.out.println("x. Iesire din aplicatie");
        System.out.print("Optiune: ");
    }

    private void handleAddCheckInService() {

        try {

            System.out.println("ID-ul intrarii: ");
            int idCheckIn = scanner.nextInt();

            System.out.println("Numarul de persoane cazate: ");
            int numberOfPersons = scanner.nextInt();

            System.out.println("Numarul camerei: ");
            int roomNumber = scanner.nextInt();

            System.out.println("Numarul de zile: ");
            int numberOfDays = scanner.nextInt();
            scanner.nextLine();

            this.checkInService.addCheckInService(idCheckIn, numberOfPersons, roomNumber, numberOfDays);

        } catch (KeyException e) {

            e.getMessage();

        }
    }


    private void handleCheckOutService() {

        System.out.println("Numarul camerei care se elibereaza: ");
        int roomNumber = scanner.nextInt();

        System.out.println("Feedback: ");
        scanner.nextLine();
        String feedback = scanner.nextLine();

        System.out.println("Rating:");
        int rating = scanner.nextInt();
        scanner.nextLine();

        try {

            //checkInService.validateCheckOut(feedback, rating);
            checkInService.checkOutService(roomNumber, feedback, rating);

        } catch (KeyException e) {

            System.out.println(e.getMessage());

        } catch (IllegalArgumentException e) {

            System.out.println(e.getMessage());
        }

    }


    private void handleShowRooms() {

        for(RatingForRoomViewModel ratingForRoomViewModel : this.checkInService.getRoomsOrderedByAverageRating()) {

            System.out.println(ratingForRoomViewModel.toString());
        }
    }

    private void handleAll() {

        for (CheckIn checkIn : checkInService.getAll()) {

            System.out.println(checkIn.toString());
        }

    }


}
