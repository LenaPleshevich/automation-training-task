package com.epam.thread.port.pool;

import java.util.concurrent.TimeUnit;

public class Pier{
    private Ship ship;
    private String name;

    public Pier(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setShip(Ship ship) {
        this.ship = ship;
    }

    public void using(Port port) {
        try {
            ship.service();
            switch (ship.getPurpose()) {
                case 1 :
                    System.out.println(ship.getName() +   "start amount container on storage = " + port.getCapacityStorage());
                    port.addContainer(ship.getCapacityShip());
                    System.out.println(ship.getName() + " end amount container on storage = " + port.getCapacityStorage());
                    break;
                case -1 :
                    System.out.println(ship.getName() + " start amount container on storage = " + port.getCapacityStorage());
                    port.removeContainer(ship.getCapacityShip());
                    System.out.println(ship.getName() + " end amount container on storage = " + port.getCapacityStorage());
                    break;
                default:
                    break;
            }
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Pier pier = (Pier) o;

        if (!ship.equals(pier.ship)) return false;
        return name.equals(pier.name);

    }

    @Override
    public int hashCode() {
        int result = ship.hashCode();
        result = 31 * result + name.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Pier{" +
                "ship=" + ship +
                ", name='" + name + '\'' +
                '}';
    }
}
