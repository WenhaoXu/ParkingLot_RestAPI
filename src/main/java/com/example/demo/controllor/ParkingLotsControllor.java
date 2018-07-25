package com.example.demo.controllor;

import com.example.demo.model.ParkingLotModel;
import com.example.demo.service.ParkingBoysService;
import com.example.demo.service.ParkingLotsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ParkingLotsControllor {

    private ParkingLotsService parkingLotsService;
    @Autowired
    public  ParkingLotsControllor(ParkingLotsService parkingLotsService){
        this.parkingLotsService=parkingLotsService;
    }

    @GetMapping("/parkinglots")
    public List<ParkingLotModel> getParkingLots(){

        return  parkingLotsService.getParkingLots();
    }
}
