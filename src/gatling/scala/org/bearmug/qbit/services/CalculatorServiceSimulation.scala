package org.bearmug.qbit.services

import io.gatling.core.Predef._
import io.gatling.http.Predef._

class CalculatorServiceSimulation extends Simulation {

  val random = scala.util.Random

  val scn = scenario("Calculator usage scenario").repeat(15) {

    exec(
      http("Add Numbers")
        .get("http://localhost:8080/services/calc/add/22/55")
        .check(status.is(200))
    )

    exec(
      http("Multiply Numbers")
        .get("http://localhost:8080/services/calc/mult/12/24")
        .check(status.is(200))
    )
  }

  setUp(
    scn.inject(atOnceUsers(5))
  )
}