package com.example.demo.controllor;

import com.example.demo.dto.Car;
import com.example.demo.dto.Order;
import com.example.demo.dto.Ticket;
import com.example.demo.model.receiptModel;
import com.example.demo.service.ReceiptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ReceiptControllor {
    private ReceiptService receiptService;
    @Autowired
    public ReceiptControllor(ReceiptService receiptService){
        this.receiptService=receiptService;
    }

    @PostMapping("/ticket")
    public Ticket parkingCar(@RequestBody Car car){
    return   receiptService.parkingCar(car.carId);
    }

    @GetMapping("/order")
    public List<Order>  getAllOrders(@RequestParam String status){
          return   receiptService.getAllOrders(status);
    }





}
