package com.example.demo.model;

import org.springframework.stereotype.Component;

import java.util.LinkedList;
import java.util.List;
@Component
public class DbService {
    List<ParkingBoyModel>boysList=new LinkedList<>();
    List<ParkingLotModel>lotList=new LinkedList<>();
    List<receiptModel>receiptList=new LinkedList<>();
    public List<ParkingBoyModel> getBoysList() {
        return boysList;
    }

    public List<ParkingLotModel> getLotList() {
        return lotList;
    }

    public List<receiptModel> getReceiptList() {
        return receiptList;
    }
}
