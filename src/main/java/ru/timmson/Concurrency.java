package ru.timmson;

import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Concurrency {

    private static AtomicReference<String> sb = new AtomicReference<>("0");

    public static void main(String[] args) throws InterruptedException {
        final var collect = IntStream.range(1, 10)
                .mapToObj(Concurrency::runnable)
                .map(Thread::new)
                .peek(Thread::start)
                .collect(Collectors.toList());

        for (Thread t : collect) {
            t.join();
        }

        System.out.println("sb.toString() = " + sb.toString());

    }

    public static Runnable runnable(int i) {
        return () -> sb.updateAndGet(s -> String.valueOf(Integer.parseInt(s) + 1));
    }

}
