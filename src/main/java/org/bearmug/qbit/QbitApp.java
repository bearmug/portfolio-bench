package org.bearmug.qbit;


import io.advantageous.qbit.server.EndpointServerBuilder;


public class QbitApp {

    public static void main(String[] args) {
        new QbitApp().start();
    }

    public void start() {
        new EndpointServerBuilder()
                .setPort(8080)
                .build()
                .initServices(new QbitFibonacciController())
                .start();
    }
}
