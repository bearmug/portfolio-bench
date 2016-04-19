package org.bearmug.qbit;


import io.advantageous.qbit.server.EndpointServerBuilder;
import io.advantageous.qbit.server.ServiceEndpointServer;
import org.bearmug.qbit.services.InstrumentService;
import org.bearmug.qbit.services.PingService;
import org.bearmug.qbit.services.CalculatorService;


public class MainService {

    private ServiceEndpointServer server;

    public static void main(String[] args) {
        new MainService().start();
    }
    
    public void start() {
        server = new EndpointServerBuilder().setPort(8080).build();
        server.initServices(new PingService(), new CalculatorService());
        server.start();
    }
    
    public void stop() {
        server.stop();
    }
}
