package ua.hillel.petrolStation;

import java.util.Random;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

public class PetrolStation implements Runnable {

    private double amount;
    private static final int MAX_CLIENTS_SIMULTANEOUSLY = 3;
    private static final double FUEL_FOR_ONE_REFUELING = 5;
    private Semaphore semaphore = new Semaphore(MAX_CLIENTS_SIMULTANEOUSLY);
    private static final Logger LOGGER = Logger.getLogger(PetrolStation.class.getName());

    public PetrolStation(double amount) {
        this.amount = amount;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    @Override
    public void run() {
        try {
            semaphore.acquire();
            this.doRefuel();
        } catch (InterruptedException ignore) { } finally {
            semaphore.release();
        }

    }

    private void doRefuel() {
        if (amount > FUEL_FOR_ONE_REFUELING) {
            LOGGER.info("%s start refueling".formatted(Thread.currentThread().getName()));
            int timeRefueling = new Random().nextInt(3, 10);
            try {
                TimeUnit.SECONDS.sleep(timeRefueling);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            amount = amount - 5;
            LOGGER.info("%s finish, time refueling: %d s. Fuel is left: %f. "
                    .formatted(Thread.currentThread().getName(), timeRefueling, amount));
        } else {
            LOGGER.info("Not enough fuel");
        }

    }
}
