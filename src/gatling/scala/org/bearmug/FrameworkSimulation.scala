package org.bearmug

import io.gatling.core.Predef._
import io.gatling.http.Predef._

sealed abstract case class FrameworkSimulation(name: String, baseUrl: String, path: String) extends Simulation {

  val random = scala.util.Random

  private val httpConf = http.baseURL(baseUrl)

  private val fibonacciFast = scenario(s"$name low-CPU fibonacci calculations").repeat(5) {

    exec(
      http("Calculate fibonacci number from 3 to 5")
        .get(s"$path/${3 + random.nextInt(3)}")
        .check(status.is(200))
    )

  }

  setUp(
    fibonacciFast.inject(rampUsers(30) over 10)
  ).protocols(httpConf)
}
