package com.example.demo.controllor;

import com.example.demo.model.ParkingBoyModel;
import com.example.demo.service.ParkingBoysService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ParkingBoysControllor {
    private ParkingBoysService parkingBoysService;
    @Autowired
    public ParkingBoysControllor (ParkingBoysService parkingBoysService){
        this.parkingBoysService=parkingBoysService;
    }

    @GetMapping("/parkingboys")
    public List<ParkingBoyModel> getParkingBoys(){
        List<ParkingBoyModel>  list= parkingBoysService.getParkingBoys();
        return list;
    }

}
