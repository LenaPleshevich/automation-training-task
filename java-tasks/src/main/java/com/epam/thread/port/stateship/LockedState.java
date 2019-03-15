package com.epam.thread.port.stateship;

import com.epam.thread.port.pool.Ship;

public class LockedState implements StateShip {
    @Override
    public void work(Ship ship) {
        System.out.println(ship.getName() + " is locked");
    }
}
