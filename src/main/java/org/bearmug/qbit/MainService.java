package org.bearmug.qbit;


import io.advantageous.qbit.server.EndpointServerBuilder;
import io.advantageous.qbit.server.ServiceEndpointServer;
import org.bearmug.qbit.services.SimpleService;


public class MainService {

    public static void main(String[] args) {
        ServiceEndpointServer server = new EndpointServerBuilder().setPort(8080).build();
        server.initServices(new SimpleService());
        server.start();
    }
}
