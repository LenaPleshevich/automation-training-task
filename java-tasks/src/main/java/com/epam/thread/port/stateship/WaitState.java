package com.epam.thread.port.stateship;

import com.epam.thread.port.pool.Ship;

public class WaitState implements StateShip {
    @Override
    public void work(Ship ship) {
        ship.setStateShip(new ServiceState());
        System.out.println(ship.getName() + "is waited");
    }
}
