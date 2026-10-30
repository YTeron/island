package net.yteron.island.server;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;

public class Loger {
    private static final ExecutorService WRITER = Executors.newSingleThreadExecutor(r ->{
        Thread t = new Thread(r,"log");
        return t;
    });
    public static void log(String msg) {
        WRITER.execute(() -> System.out.println(msg));
    }
    public static void shutdown() {
        WRITER.shutdown();
    }
}
