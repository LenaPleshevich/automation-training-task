package com.epam.thread.port.stateship;

import com.epam.thread.port.pool.Ship;

public class NewState implements StateShip {
    @Override
    public void work(Ship ship) {
        System.out.println(ship.getName() + " arrived");
        ship.setStateShip(new WaitState());
    }
}
