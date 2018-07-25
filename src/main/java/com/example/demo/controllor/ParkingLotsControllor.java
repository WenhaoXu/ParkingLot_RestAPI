package com.example.demo.controllor;

import com.example.demo.model.ParkingLotModel;
import com.example.demo.service.ParkingBoysService;
import com.example.demo.service.ParkingLotsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping("/parkinglots")
    public ParkingLotModel addParkingLot(@RequestBody ParkingLotModel parkingLot){
        return  parkingLotsService.addParkingLot(parkingLot);
    }

    @PutMapping("parkinglots/parkinglot/{id}/parkingboy/{boyid}")
     public  boolean  giveBoyidToParkingLot(@PathVariable int id,@PathVariable int boyid){
        return parkingLotsService.giveBoyidToParkingLot(id,boyid);
    }
}
