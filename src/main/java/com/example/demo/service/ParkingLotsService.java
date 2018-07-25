package com.example.demo.service;

import com.example.demo.model.DbService;
import com.example.demo.model.ParkingLotModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ParkingLotsService {

    private DbService dbService;
    @Autowired
    public ParkingLotsService(DbService dbService){
        this.dbService=dbService;
    }
    public List<ParkingLotModel> getParkingLots() {
        return  dbService.getLotList();
    }
}
