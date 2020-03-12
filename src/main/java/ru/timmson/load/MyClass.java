package ru.timmson.load;

import java.util.stream.LongStream;

public class MyClass {

    public static void main(String[] args) {
        int number = 20;
        Thread newThread = new Thread(() -> {
            System.out.println("Factorial of " + number + " is: " + LongStream.range(1, number + 1).reduce((left, right) -> left * right).orElse(0));
        });
        newThread.start();
    }

}
