package com.example.demo.service;

import com.example.demo.model.DbService;
import com.example.demo.model.ParkingBoyModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ParkingBoysService {
    private DbService dbService;
    @Autowired
    public ParkingBoysService(DbService dbService){
        this.dbService=dbService;
    }
    public List<ParkingBoyModel> getParkingBoys() {

        List<ParkingBoyModel> list=dbService.getBoysList();

        return  list;
    }

    public ParkingBoyModel addParkingBoy(ParkingBoyModel parkingBoy) {
        List<ParkingBoyModel> list=dbService.getBoysList();
        list.add(parkingBoy);
        return parkingBoy;
    }
}
