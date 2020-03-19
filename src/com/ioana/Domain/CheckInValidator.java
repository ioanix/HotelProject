package com.ioana.Domain;

public class CheckInValidator {


    public void validate(CheckIn checkIn) {

        String messages = "";

        if(checkIn.getNumberOfDays() <= 0) {

            messages += "The number of days must be > 0\n";
        }


        if(!messages.equals("")) {

            throw new IllegalArgumentException(messages);
        }

    }


    public void checkOutValidate(CheckIn checkIn) {

        String messages = "";

        if(checkIn.getFeedback().equals("")) {

            messages += "The feedback can't be empty!\n";
        }

        if(checkIn.getRating() < 1 || checkIn.getRating() > 5) {

            messages += "The rating must be a number between 1 and 5\n";
        }

        if(!messages.equals("")) {

            throw new IllegalArgumentException(messages);
        }
    }
}
