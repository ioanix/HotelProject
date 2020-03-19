package com.ioana.Domain;

public class RatingForRoomViewModel {

    private int roomNumber;
    private double averageRatingForRoom;


    public RatingForRoomViewModel(int roomNumber, double averageRatingForRoom) {

        this.roomNumber = roomNumber;
        this.averageRatingForRoom = averageRatingForRoom;
    }

    public int getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(int roomNumber) {
        this.roomNumber = roomNumber;
    }

    public double getAverageRatingForRoom() {
        return averageRatingForRoom;
    }

    public void setAverageRatingForRoom(double averageRatingForRoom) {
        this.averageRatingForRoom = averageRatingForRoom;
    }

    @Override
    public String toString() {
        return "RatingForRoomViewModel{" +
                "roomNumber=" + roomNumber +
                ", averageRatingForRoom=" + averageRatingForRoom +
                '}';
    }
}
