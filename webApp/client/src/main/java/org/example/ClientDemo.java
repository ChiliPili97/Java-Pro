package org.example;

import java.util.concurrent.*;

public class ClientDemo {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(5, new CustomTreadFactory());
        for (int i = 0; i < 5; i++){
            executorService.execute(new Client());
            try {
                TimeUnit.SECONDS.sleep(5);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        executorService.shutdown();
    }
}