package com.ioana.Domain;

public class CheckIn {

    private int checkInId;
    private int numberOfPersons;
    private int roomNumber;
    private int numberOfDays;
    private boolean isCheckedOut;
    private String feedback;
    private int rating;


    public CheckIn(int checkInId, int numberOfPersons, int roomNumber, int numberOfDays) {
        this.checkInId = checkInId;
        this.numberOfPersons = numberOfPersons;
        this.roomNumber = roomNumber;
        this.numberOfDays = numberOfDays;
        this.isCheckedOut = false;
    }

    public int getCheckInId() {
        return checkInId;
    }

    public int getNumberOfPersons() {
        return numberOfPersons;
    }

    public void setNumberOfPersons(int numberOfPersons) {
        this.numberOfPersons = numberOfPersons;
    }

    public int getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(int roomNumber) {
        this.roomNumber = roomNumber;
    }

    public int getNumberOfDays() {
        return numberOfDays;
    }

    public void setNumberOfDays(int numberOfDays) {
        this.numberOfDays = numberOfDays;
    }

    public boolean isCheckedOut() {
        return isCheckedOut;
    }

    public void setCheckedOut(boolean checkedOut) {
        isCheckedOut = checkedOut;
    }

    public String getFeedback() {
        return feedback;
    }

    public void setFeedback(String feedback) {
        this.feedback = feedback;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    @Override
    public String toString() {
        return "CheckIn{" +
                "checkIn=" + checkInId +
                ", numberOfPersons=" + numberOfPersons +
                ", roomNumber=" + roomNumber +
                ", numberOfDays=" + numberOfDays +
                ", isCheckedOut=" + isCheckedOut +
                ", feedback='" + feedback + '\'' +
                ", rating=" + rating +
                '}';
    }
}























