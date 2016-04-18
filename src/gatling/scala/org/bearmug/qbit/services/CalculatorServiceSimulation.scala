package org.bearmug.qbit.services

import com.excilys.ebi.gatling.core.Predef._
import com.excilys.ebi.gatling.http.Predef._
import com.excilys.ebi.gatling.jdbc.Predef._
import akka.util.duration._
import bootstrap._
import assertions._

class CalculatorServiceSimulation extends Simulation {
    
    before {
        println("Simulation is about to start!")
    }

    after {
        println("Simulation is finished!")
    }
    
    val scn = scenario("Calculator usage scenario").repeat(10) {
        // exec(
        //     http("Add Numbers")
        //         .get("http://localhost:${freePort}/services/calc/add/${parameterOne}/${parameterTwo}")
        //         .check(status.is(200))
        // )
    
        // exec(
        //     http("Multiply Numbers")
        //         .get("http://localhost:${freePort}/services/calc/mult/${parameterOne}/${parameterTwo}")
        //         .check(status.is(200))
        // )
  }

//   setUp(scn.users(200).ramp(100))
}