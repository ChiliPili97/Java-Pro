package org.example;

import java.util.concurrent.ThreadFactory;

public class CustomTreadFactory implements ThreadFactory {
    private int threadsNum;
    @Override
    public Thread newThread(Runnable r) {
        return new Thread(r, generateThreadName());
    }

    private String generateThreadName (){
        threadsNum++;
        return "192.168.1.%d".formatted(threadsNum);
    }
}
