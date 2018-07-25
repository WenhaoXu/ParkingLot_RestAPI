package com.example.demo.dto;

public class Ticket {
    public int receiptId;
    public  int carId;

    public Ticket(int receiptId, int carId) {
        this.receiptId = receiptId;
        this.carId = carId;
    }
}
