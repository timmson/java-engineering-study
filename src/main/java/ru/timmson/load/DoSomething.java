package ru.timmson.load;

import io.undertow.Undertow;
import io.undertow.util.Headers;

import java.io.IOException;
import java.util.Scanner;

import static java.util.concurrent.CompletableFuture.runAsync;

public strictfp class DoSomething {

    public static void main(String[] args) throws IOException {
        Undertow server = Undertow.builder()
                .addHttpListener(8080, "localhost")
                .setHandler(exchange -> {
                    exchange.getResponseHeaders().put(Headers.CONTENT_TYPE, "text/plain");
                    final var response = "OK";
                    exchange.getResponseSender().send(response);
                    souf("Response >> %s %s", response, Thread.currentThread().getName());
                }).build();

        server.start();

        while (new Scanner(System.in).hasNextLine()) {

        }

        server.stop();
    }

    private static void souf(final String message, final Object... args) {
        runAsync(() -> {
                    final var threadName = Thread.currentThread().getName();
                    Object[] localArgs = new Object[]{threadName};
                    if (args != null) {
                        localArgs = new Object[args.length + 1];
                        localArgs[0] = threadName;
                        System.arraycopy(args, 0, localArgs, 1, args.length);
                    }
                    System.out.printf("[%s] " + message + "\r\n", localArgs);
                }
        );
    }

}
