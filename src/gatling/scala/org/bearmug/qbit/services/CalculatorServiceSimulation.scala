package org.bearmug.qbit.services

import io.gatling.core.Predef._
import io.gatling.http.Predef._
import org.bearmug.qbit.PortHelper
import io.advantageous.qbit.server.EndpointServerBuilder
import io.advantageous.qbit.server.ServiceEndpointServer
import org.bearmug.qbit.services.CalculatorService

class CalculatorServiceSimulation extends Simulation {
    
    var freePort = -1
    var server = "none"
    val random = scala.util.Random
    
    before {
        println("CalculatorServiceSimulation is about to start!")
        
        freePort = PortHelper.availablePort()
        server = new EndpointServerBuilder().setPort(freePort).build()
        server.initServices(service)
        server.start()
    }

    after {
        println("CalculatorServiceSimulation is finished!")
        
        server.stop()
        PortHelper.releasePort(freePort)
    }
    
    val scn = scenario("Calculator usage scenario").repeat(1) {
        
        val parameterOne = random.nextInt(1000)
        val parameterTwo = random.nextInt(1000)
        
        exec(
            http("Add Numbers")
                .get("http://localhost:${freePort}/services/calc/add/${parameterOne}/${parameterTwo}")
                .check(status.is(200))
        )
    
        exec(
            http("Multiply Numbers")
                .get("http://localhost:${freePort}/services/calc/mult/${parameterOne}/${parameterTwo}")
                .check(status.is(200))
        )
  }

  setUp ( 
        scn.inject(atOnceUsers(1))
  )
}