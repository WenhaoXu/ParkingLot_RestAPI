package com.example.demo.model;

import org.springframework.stereotype.Component;

@Component
public class receiptModel {
    public int receiptId;
    public  int carId;
    public  int boyId;
    public  int lotId;
    public  String status;

    public int getReceiptId() {
        return receiptId;
    }

    public int getCarId() {
        return carId;
    }

    public int getBoyId() {
        return boyId;
    }

    public String getStatus() {
        return status;
    }

    public int getLotId() {
        return lotId;
    }
}
