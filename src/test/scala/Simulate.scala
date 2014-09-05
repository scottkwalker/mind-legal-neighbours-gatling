import Scenarios.humanUsers
import io.gatling.core.Predef._
import io.gatling.http.Predef._

class Simulate extends Simulation {

  private val httpConf = http
    .baseURL("http://localhost:9000")
    .acceptHeader("text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8")
    .doNotTrackHeader("1")
    .acceptLanguageHeader("en-US,en;q=0.5")
    .acceptEncodingHeader("gzip, deflate")
    .userAgentHeader("Mozilla/5.0 (Windows NT 5.1; rv:31.0) Gecko/20100101 Firefox/31.0")

  setUp(
    humanUsers.inject(atOnceUsers(1))
  ).
    protocols(httpConf)
}