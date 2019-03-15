package com.epam.thread.port.pool;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

public class ChannelPier {
        private final static int POOL_SIZE = 4;
        private final Semaphore semaphore = new Semaphore(POOL_SIZE, true);
        private final Queue<Pier> resources = new LinkedList<Pier>();

    public ChannelPier() {
    }

    public void createPier(int amountPiers) {
        for (int i = 0; i < amountPiers; i++) {
            int j = i+1;
            resources.add(new Pier("pier "+ j));
        }
    }

        public Pier getResource(long maxWaitMillis){
            Pier newResources = null;
            try {
                if (semaphore.tryAcquire(maxWaitMillis, TimeUnit.SECONDS)) {
                    newResources = resources.poll();
                    return newResources;
                }

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return newResources;
        }
        public void returnResource(Pier res) {
            resources.add(res);
            semaphore.release();
        }

    @Override
    public String toString() {
        return "ChannelPier{" +
                "semaphore=" + semaphore +
                ", resources=" + resources +
                '}';
    }
}




