package com.example.demo.model;

import org.springframework.stereotype.Component;

@Component
public class ParkingLotModel {
    public int lotId;
    public int size;
    public int alive;
    public ParkingBoyModel parkingBoy;

    public int getLotId() {
        return lotId;
    }

    public void setLotId(int id) {
        this.lotId = id;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int getAlive() {
        return alive;
    }

    public void setAlive(int alive) {
        this.alive = alive;
    }

    public ParkingBoyModel getParkingBoy() {
        return parkingBoy;
    }

    public void setParkingBoy(ParkingBoyModel parkingBoy) {
        this.parkingBoy = parkingBoy;
    }
}
