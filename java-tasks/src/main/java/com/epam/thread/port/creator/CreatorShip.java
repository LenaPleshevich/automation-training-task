package com.epam.thread.port.creator;

import com.epam.thread.port.pool.Ship;
import com.epam.thread.port.stateship.NewState;
import java.util.ArrayList;

public class CreatorShip {
    private static final int MIN_AMOUNT_SHIP = 2;

    public static ArrayList <Ship> createShip(int amount) {
        ArrayList <Ship> listShip = new ArrayList<Ship>();
        for( int i = 0; i < amount; i++) {
            Ship ship = new Ship();
            ship.setStateShip(new NewState());
            ship.setCapacityShip((int)(Math.random()*10) + MIN_AMOUNT_SHIP);
            if(i % 2 == 1) {
                ship.setPurpose(-1);
            } else {
                ship.setPurpose(1);
            }
            listShip.add(ship);
        }
        return listShip;
    }
}
