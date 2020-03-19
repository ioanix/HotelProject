package com.ioana.Repository;

import com.ioana.Domain.CheckIn;

import java.security.KeyException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CheckInRepository {

    private Map<Integer, CheckIn> storage = new HashMap<>();

    // CRUD - CREATE, READ, UPDATE, DELETE

    /**
     * Adds a ClientEntryCheckIn to the repository
     * throws KeyException if the id already exists
     */

    public void create(CheckIn clientCheckIn) throws KeyException {

        if (storage.containsKey(clientCheckIn.getCheckInId())) {

            throw new KeyException("The Id already exists");
        }

        storage.put(clientCheckIn.getCheckInId(), clientCheckIn);

    }


    public CheckIn read(int checkInId) {        // returneaza un client cu toate datele

        return storage.get(checkInId);
    }


    public List<CheckIn> readAll() {           // citeste toate valorile din storage si le pune intr-o lista

        return new ArrayList<>(storage.values());
    }


    public void update(CheckIn checkIn) throws KeyException {

        if (!storage.containsKey(checkIn.getCheckInId())) {

            throw new KeyException("The entry ID does not exist!");
        }

        storage.put(checkIn.getCheckInId(), checkIn);
    }


    public void delete(CheckIn checkIn) throws KeyException {

        if (!storage.containsKey(checkIn.getCheckInId())) {

            throw new KeyException("The entry ID does not exist!");
        }

        storage.remove(checkIn.getCheckInId(), checkIn);
    }


//    public void validate(CheckIn checkIn) throws KeyException {
//
//        if (checkIn.getRoomNumber() < 0) {
//
//            throw new KeyException("The room number must be a positive number");
//        }
//
//        for (CheckIn c : storage.values()) {
//
//            if (c.getRoomNumber() == checkIn.getRoomNumber() && !c.isCheckedOut()) {
//
//                throw new KeyException("The room is already taken");
//            }
//
//        }
//    }


}





















