package com.example.demo.service;

import com.example.demo.model.DbService;
import com.example.demo.model.ParkingBoyModel;
import com.example.demo.model.ParkingLotModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

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

    public ParkingLotModel addParkingLot(ParkingLotModel parkingLot) {
        List<ParkingLotModel> lotModelList=dbService.getLotList();
        lotModelList.add(parkingLot);
        return  parkingLot;
    }

    public boolean giveBoyidToParkingLot(int id, int boyid) {
        List<ParkingLotModel> lotModelList=dbService.getLotList();
        List<ParkingBoyModel> boyModelList=dbService.getBoysList();
        List<ParkingBoyModel>newlist=  boyModelList.stream().filter(boy->boy.boyId==boyid).collect(Collectors.toList());
        if(newlist.size()==0){
            return false;
        }
        for(ParkingLotModel lot :lotModelList){
            if(lot.lotId==id){
                lot.setParkingBoy(newlist.get(0));
                return true;
            }
        }
        return false;

    }
}
