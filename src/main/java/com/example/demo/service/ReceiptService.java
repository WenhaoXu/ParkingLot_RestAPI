package com.example.demo.service;

import com.example.demo.dto.Order;
import com.example.demo.dto.Ticket;
import com.example.demo.model.DbService;
import com.example.demo.model.ParkingLotModel;
import com.example.demo.model.receiptModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ReceiptService {
    private DbService dbService;
    private receiptModel receipt;
    @Autowired
    public ReceiptService(DbService dbService,receiptModel receipt){
        this.dbService=dbService;
        this.receipt=receipt;
    }
    public Ticket parkingCar(int carId) {
         receipt.carId=carId;
       List<receiptModel>list= dbService.getReceiptList();
         receipt.receiptId=list.size()+1;
         Ticket ticket=new Ticket( receipt.carId,receipt.receiptId);
         receipt.status="unpark";
         dbService.getReceiptList().add(receipt);
         return ticket;
    }

    public List<Order> getAllOrders(String status) {
        List<receiptModel>list =   dbService.getReceiptList().stream().filter(receipt->receipt.status.equals("unpark")).collect(Collectors.toList());
        return   list.stream().map(receiptModel->{
            Order order=new Order();
            order.carId=receiptModel.carId;
            order.orderId =receiptModel.receiptId;
            order.status=receiptModel.status;
            return order;
        }).collect(Collectors.toList());
    }

    public boolean robOrder(int boyId) {
       for(receiptModel receiptModel:dbService.getReceiptList()){
           if(receiptModel.status.equals("unpark"))
           {
               List<ParkingLotModel>list1=dbService.getLotList();
               receiptModel.status="parked";
               receiptModel.boyId=boyId;
               for(ParkingLotModel parkingLotModel:list1){
                   if(parkingLotModel.getParkingBoy().boyId==boyId&&parkingLotModel.alive!=0){
                       parkingLotModel.alive--;
                   }
               }
               return  true;
           }
       }
       return  false;
    }

    public boolean deleteReceipt(int ticketId) {
        List<receiptModel>list =   dbService.getReceiptList();
        List<ParkingLotModel>list1=dbService.getLotList();
        for(receiptModel receiptModel:list){
            if(receiptModel.receiptId==ticketId){
             int lotId=   receiptModel.getLotId();
             for(ParkingLotModel parkingLotModel:list1){
                 if(parkingLotModel.lotId==lotId){
                     parkingLotModel.alive++;
                 }
             }
              return   list.remove(receiptModel);
            }
        }
        return false;
    }
}
