package com.ioana.Service;

import com.ioana.Domain.CheckIn;
import com.ioana.Domain.CheckInValidator;
import com.ioana.Domain.RatingForRoomViewModel;
import com.ioana.Repository.CheckInRepository;

import java.security.KeyException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CheckInService {


    private CheckInRepository checkInRepository;
    private CheckInValidator checkInValidator;


    public CheckInService(CheckInRepository checkInRepository, CheckInValidator checkInValidator) {

        this.checkInRepository = checkInRepository;
        this.checkInValidator = checkInValidator;
    }


    public void addCheckInService(int checkInId, int numberOfPersons, int roomNumber, int numberOfDays) throws KeyException {

        CheckIn checkIn = new CheckIn(checkInId, numberOfPersons, roomNumber, numberOfDays);

            this.checkInValidator.validate(checkIn);

            // check if the room number is not of an already occupied room
            for(CheckIn existingCheckIn : this.checkInRepository.readAll()) {

                if(existingCheckIn.getRoomNumber() == roomNumber && !existingCheckIn.isCheckedOut()) {

                    throw new IllegalArgumentException("The room is already occupied!");
                }
            }

            this.checkInRepository.create(checkIn);

    }


    public void checkOutService(int roomNumber, String feedback, int rating) throws KeyException {

        boolean isRoomOccupied = true;

        for (CheckIn checkIn : this.checkInRepository.readAll()) {      // parcurgem lista de check-in-uri

            if (!checkIn.isCheckedOut() && checkIn.getRoomNumber() == roomNumber) {

                isRoomOccupied = false;

                checkIn.setCheckedOut(true);
                checkIn.setFeedback(feedback);
                checkIn.setRating(rating);

                this.checkInValidator.checkOutValidate(checkIn);

                this.checkInRepository.update(checkIn);
                break;

            }
        }

        if(isRoomOccupied) {

            throw new IllegalArgumentException("The room is already occupied!");
        }
    }


    public List<RatingForRoomViewModel> getRoomsOrderedByAverageRating() {

        Map<Integer, List<Integer>> roomsRatings = new HashMap<>();   // map in care cheia = nr camerei, iar valorile = o lista cu rating-urile pt camera respectiva

        for(CheckIn checkIn : checkInRepository.readAll()) {

            int roomNumber = checkIn.getRoomNumber();
            int rating = checkIn.getRating();

            if(!roomsRatings.containsKey(roomNumber)) {

                List<Integer> ratingsList = new ArrayList<>();
                ratingsList.add(rating);
                roomsRatings.put(roomNumber, ratingsList);

            } else {

                roomsRatings.get(roomNumber).add(rating);
            }
        }


        List<RatingForRoomViewModel> result = new ArrayList<>();

        for(int roomNumber : roomsRatings.keySet()) {

            List<Integer> ratingsForRoom = roomsRatings.get(roomNumber);

            double ratingsForRoomSum = 0.0;

            for(double rating : ratingsForRoom) {

                ratingsForRoomSum += rating;
            }

            RatingForRoomViewModel ratingForRoomViewModel = new RatingForRoomViewModel(roomNumber, ratingsForRoomSum / ratingsForRoom.size());
            result.add(ratingForRoomViewModel);

        }


        result.sort((o1, o2) -> {

            if(o1.getAverageRatingForRoom() < o2.getAverageRatingForRoom()) {

                return 1;

            } else if(o1.getAverageRatingForRoom() == o2.getAverageRatingForRoom()) {

                return 0;

            } else {

                return -1;
            }
        });



        return result;

    }


    public List<CheckIn> getAll() {

        return this.checkInRepository.readAll();
    }
}



















