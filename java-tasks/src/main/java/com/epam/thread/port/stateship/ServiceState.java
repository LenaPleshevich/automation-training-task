package com.epam.thread.port.stateship;

import com.epam.thread.port.pool.Ship;

public class ServiceState implements StateShip {
    @Override
    public void work(Ship ship) {
        System.out.println(ship.getName() + " on  service");
        if(ship.getPurpose() == 1) {
            ship.setStateShip(new UnloadState());
        } else {
            ship.setStateShip(new LoadState());
        }
    }
}
