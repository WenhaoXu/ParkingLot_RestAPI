package com.example.demo.service;

import com.example.demo.model.DbService;
import com.example.demo.model.ParkingBoyModel;
import com.example.demo.model.ParkingLotModel;
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

    public boolean deleteBoy(int id) {
        List<ParkingBoyModel> list=dbService.getBoysList();
        for(ParkingBoyModel parkingBoyModel:list){
            if(parkingBoyModel.boyId==id){
                list.remove(parkingBoyModel);
             List<ParkingLotModel>list1=   dbService.getLotList();
             for(ParkingLotModel parkingLotModel:list1){
                 if(parkingLotModel.getParkingBoy().boyId==id){
                     list1.remove(parkingLotModel);
                 }
             }
             return true;
            }
        }
        return false;
    }
}
