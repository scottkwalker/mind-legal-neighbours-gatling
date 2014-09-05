import io.gatling.core.Predef._

object Scenarios {

  val humanUsers = scenario("Visit all html pages").
    exec(
      Browse.siteRoot,
      Browse.intro,
      Browse.healthCheck,
      Browse.legalNeighbours
    )
}
