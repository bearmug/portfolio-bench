package org.bearmug.qbit;


import io.advantageous.qbit.server.EndpointServerBuilder;
import io.advantageous.qbit.server.ServiceEndpointServer;
import org.bearmug.qbit.services.InstrumentService;
import org.bearmug.qbit.services.PingService;


public class MainService {

    public static void main(String[] args) {
        ServiceEndpointServer server = new EndpointServerBuilder().setPort(8080).build();
        server.initServices(new PingService(), new InstrumentService());
        server.start();
    }
}
