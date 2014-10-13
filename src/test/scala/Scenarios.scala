import io.gatling.core.Predef._

object Scenarios {

  val humanUsers = scenario("Visit all html pages").
    exec(
      Browse.siteRoot,
      Browse.intro,
      Browse.healthCheck,
      Browse.legalNeighbours
    )

  val serviceUsers = scenario("Lookup values").
    exec(
      Lookup.`return bad request when submission is empty`,
      Lookup.`return ok with seq of ids when submission is valid and legal moves are found`,
      Lookup.`return empty seq when submission is valid but no matches are in scope`
    )

  val load = scenario("Load").
    exec(
      randomSwitch(
        0.7 -> Lookup.`return empty seq when submission is valid but no matches are in scope`,
        0.3 -> Lookup.`return ok with seq of ids when submission is valid and legal moves are found`
      )
    )
}
