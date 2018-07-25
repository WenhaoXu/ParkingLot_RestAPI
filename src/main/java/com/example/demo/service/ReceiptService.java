package com.example.demo.service;

import com.example.demo.dto.Order;
import com.example.demo.dto.Ticket;
import com.example.demo.model.DbService;
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
        


    }
}
