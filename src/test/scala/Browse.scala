import io.gatling.core.Predef._
import io.gatling.http.Predef._

object Browse {

  private val introTitle = "<title>Mind</title>"
  private val healthCheckTitle = "<title>Health check</title>"
  private val legalNeighboursTitle = "<title>Mind - Legal neighbours calculator</title>"
  val siteRoot = exec(
    http("go to root redirects to intro page")
      .get("/")
      // Assertions
      .check(status.is(200))
      .check(regex(introTitle).exists) // Page title
  )
  val intro = exec(
    http("go to intro")
      .get("/mind/intro")
      // Assertions
      .check(status.is(200))
      .check(regex(introTitle).exists) // Page title
  )
  val healthCheck = exec(
    http("go to health-check")
      .get("/mind/health-check")
      // Assertions
      .check(status.is(200))
      .check(regex(healthCheckTitle).exists) // Page title
  )
  val legalNeighbours = exec(
    http("go to legal-neighbours")
      .get("/mind/legal-neighbours")
      // Assertions
      .check(status.is(200))
      .check(regex(legalNeighboursTitle).exists) // Page title
  )
}
