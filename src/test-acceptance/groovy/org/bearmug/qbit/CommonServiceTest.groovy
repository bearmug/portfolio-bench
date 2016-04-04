package org.bearmug.qbit

import groovyx.net.http.RESTClient
import io.advantageous.qbit.server.EndpointServerBuilder
import io.advantageous.qbit.server.ServiceEndpointServer
import org.bearmug.qbit.services.CalculatorService
import spock.lang.Shared
import spock.lang.Specification

abstract class CommonServiceTest extends Specification {

    @Shared
    int freePort = PortHelper.availablePort

    @Shared
    RESTClient client = new RESTClient("http://localhost:${freePort}/services/${serviceName}/")

    @Shared
    ServiceEndpointServer server

    def setupSpec() {
        server = new EndpointServerBuilder().setPort(freePort).build()
        server.initServices(service);
        server.start();
    }

    def cleanupSpec() {
        server.stop()
        PortHelper.releasePort freePort
    }

    abstract String getServiceName()

    abstract Object getService()
}
