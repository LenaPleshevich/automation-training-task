package com.epam.thread.port.show;

import com.epam.thread.port.creator.CreatorShip;
import com.epam.thread.port.pool.ChannelPier;
import com.epam.thread.port.pool.Port;
import com.epam.thread.port.pool.Ship;
import java.util.ArrayList;

public class Main {
    public static final int AMOUNT_PIER = 4;
    public static final int START_SIZE_STORAGE = 15;
    public static final int AMOUNT_SHIP = 7;

    public static void main(String[] args){
        Port port = Port.getInstance();
        port.setSizeStorage(START_SIZE_STORAGE);
        ChannelPier channelPier = new ChannelPier();
        channelPier.createPier(AMOUNT_PIER);
        port.setPierChannelPool(channelPier);
        ArrayList<Ship> listShip = CreatorShip.createShip(AMOUNT_SHIP);
        for(Ship ship: listShip) {
            ship.setPort(port);
        }
        for(Ship ship: listShip) {
            ship.start();
        }
    }
}
