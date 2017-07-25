package org.bearmug

import io.gatling.core.Predef._
import io.gatling.http.Predef._

class BootSimulation extends Simulation {

  val random = scala.util.Random

  private val httpConf = http.baseURL("http://localhost:8090")

  private val fibonacciQbitFast = scenario("Spring Boot low-CPU fibonacci calculations").repeat(5) {

    exec(
      http("Calculate fibonacci number from 3 to 5")
        .get(s"/fibonacci-boot/get/${3 + random.nextInt(3)}")
        .check(status.is(200))
    )

  }

  setUp(
    fibonacciQbitFast.inject(rampUsers(30) over 10)
  ).protocols(httpConf)
}