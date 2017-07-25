package org.bearmug

import io.gatling.core.Predef._
import io.gatling.http.Predef._

class FrameworksSimulation extends Simulation {

  val random = scala.util.Random

  private val httpConf = http.baseURL("http://localhost:8080/services")

  private val fibonacciQbitFast = scenario("Qbit low-CPU fibonacci calculations").repeat(5) {

    exec(
      http("Calculate fibonacci number from 3 to 5")
        .get(s"/fibonacci-qbit/get/${3 + random.nextInt(3)}")
        .check(status.is(200))
    )

  }

  setUp(
    fibonacciQbitFast.inject(rampUsers(10) over 10)
  ).protocols(httpConf)
}