package org.bearmug

import io.gatling.core.Predef._
import io.gatling.http.Predef._

abstract class FrameworkSim(name: String, baseUrl: String, path: String) extends Simulation {

  val random = scala.util.Random

  private val httpConf = http.baseURL(baseUrl)

  private val fibonacciFast = scenario(s"$name low-CPU fibonacci calculations").repeat(10) {

    exec(
      http("Calculate fibonacci number from 5 to 10")
        .get(s"$path${5 + random.nextInt(6)}")
        .check(status.is(200))
    )

  }

  private val fibonacciHard = scenario(s"$name high-CPU fibonacci calculations").repeat(10) {

    exec(
      http("Calculate fibonacci number from 20 to 25")
        .get(s"$path${29 + random.nextInt(6)}")
        .check(status.is(200))
    )

  }

  setUp(
    fibonacciFast.inject(rampUsers(50) over 10)
  ).protocols(httpConf)
}






