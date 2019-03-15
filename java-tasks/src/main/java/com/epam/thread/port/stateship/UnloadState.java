package com.epam.thread.port.stateship;

import com.epam.thread.port.pool.Ship;

public class UnloadState implements StateShip{
    @Override
    public void work(Ship ship) {
        ship.setStateShip(new LockedState());
        System.out.println(ship.getName() + " unload");
    }
}
