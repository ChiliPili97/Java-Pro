package ua.hillel.petrolStation;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class PetrolStationDemo {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(6);
        PetrolStation petrolStation = new PetrolStation(100);
        for (int i = 0; i < 6; i++) {
            executorService.execute(petrolStation);
        }
        executorService.shutdown();
    }
}
