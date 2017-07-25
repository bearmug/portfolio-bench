package org.bearmug.qbit;


import io.advantageous.qbit.server.EndpointServerBuilder;
import org.bearmug.qbit.services.QbitFibonacciService;


public class MainService {

    public static void main(String[] args) {
        new MainService().start();
    }

    public void start() {
        new EndpointServerBuilder()
                .setPort(8080)
                .build()
                .initServices(new QbitFibonacciService())
                .start();
    }
}
