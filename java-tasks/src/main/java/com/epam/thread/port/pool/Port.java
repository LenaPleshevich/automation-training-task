package com.epam.thread.port.pool;

import java.util.concurrent.atomic.AtomicInteger;

public class Port {
    private static final int START_AMOUNT_CONTAINER_STORAGE = 10;
    private static final Port instance = new Port();
    private int sizeStorage;
    private static AtomicInteger capacityStorage = new AtomicInteger(START_AMOUNT_CONTAINER_STORAGE);
    private ChannelPier pierChannelPool;

    public ChannelPier getPierChannelPool() {
        return pierChannelPool;
    }

    public void setPierChannelPool(ChannelPier pierChannelPool) {
        this.pierChannelPool = pierChannelPool;
    }

    private Port() {
    }

    public static Port getInstance() {
        return instance;
    }


     public void addContainer(int amountContainer) {
        if(sizeStorage - capacityStorage.get() >= amountContainer) {
            capacityStorage.getAndUpdate(n -> n + amountContainer);
        } else {
            capacityStorage.getAndUpdate(n -> n - 10);
            addContainer(amountContainer);
        }
    }

    public void removeContainer(int amountContainer) {
        if(capacityStorage.get() >= amountContainer) {
            capacityStorage.getAndUpdate(n -> n - amountContainer);
        } else {
            capacityStorage.getAndUpdate(n -> n + 10);
            removeContainer(amountContainer);
        }
    }

    public int getCapacityStorage() {
        return capacityStorage.get();
    }

    public void setSizeStorage(int sizeStorage) {
        this.sizeStorage = sizeStorage;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Port port = (Port) o;

        if (sizeStorage != port.sizeStorage) return false;
        return pierChannelPool.equals(port.pierChannelPool);

    }

    @Override
    public int hashCode() {
        int result = sizeStorage;
        result = 31 * result + pierChannelPool.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Port{" +
                "sizeStorage=" + sizeStorage +
                ", pierChannelPool=" + pierChannelPool +
                '}';
    }
}
