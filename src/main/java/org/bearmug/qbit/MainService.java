package org.bearmug.qbit;


import io.advantageous.qbit.server.EndpointServerBuilder;
import org.bearmug.controller.QbitFibonacciController;


public class MainService {

    public static void main(String[] args) {
        new MainService().start();
    }

    public void start() {
        new EndpointServerBuilder()
                .setPort(8080)
                .build()
                .initServices(new QbitFibonacciController())
                .start();
    }
}
