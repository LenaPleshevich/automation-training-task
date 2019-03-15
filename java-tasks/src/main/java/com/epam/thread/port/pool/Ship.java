package com.epam.thread.port.pool;

import com.epam.thread.port.stateship.StateShip;
import java.util.concurrent.TimeUnit;

public class Ship extends Thread {
    private int capacityShip;
    private int purpose;
    private Port port;
    private Pier pier;
    private StateShip stateShip;

    public Ship(){}

    public StateShip getStateShip() {
        return stateShip;
    }

    public void setStateShip(StateShip stateShip) {
        this.stateShip = stateShip;
    }

     public void service() {
        stateShip.work(this);
    }

    public void setPier(Pier pier) {
        this.pier = pier;
    }

    public void setPort(Port port) {
        this.port = port;
    }

    public int getCapacityShip() {
        return capacityShip;
    }

    public void setCapacityShip(int capacityShip) {
        this.capacityShip = capacityShip;
    }

    public int getPurpose() {
        return purpose;
    }

    public void setPurpose(int purpose) {
        this.purpose = purpose;
    }

    public void run() {
        this.setPier(null);
        try {
            pier = port.getPierChannelPool().getResource(1000);
            this.service();
            TimeUnit.SECONDS.sleep(5);
            System.out.println(this.getName() + " working on " + pier.getName());
            pier.setShip(this);
            this.service();
            pier.using(this.port);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            if (pier != null) {
                port.getPierChannelPool().returnResource(pier);
                this.service();
            }
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Ship ship = (Ship) o;

        if (capacityShip != ship.capacityShip) return false;
        if (purpose != ship.purpose) return false;
        if (!port.equals(ship.port)) return false;
        return pier.equals(ship.pier);

    }

    @Override
    public int hashCode() {
        int result = capacityShip;
        result = 31 * result + purpose;
        result = 31 * result + port.hashCode();
        result = 31 * result + pier.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Ship{" +
                "capacityShip=" + capacityShip +
                ", purpose=" + purpose +
                ", port=" + port +
                ", pier=" + pier +
                '}';
    }
}


