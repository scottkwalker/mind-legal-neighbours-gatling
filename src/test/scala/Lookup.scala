import io.gatling.core.Predef._
import io.gatling.http.Predef._

object Lookup {

  val `return bad request when submission is empty` =
    exec(
      http("call legal-neighbours and get expected value").
        post("/mind/legal-neighbours").
        // Assertions
        check(status.is(400))
    )

  val `return ok with seq of ids when submission is valid and legal moves are found` = {
    val input = StringBody( """{"scope":{"numVals":1,"numFuncs":2,"numObjects":3,"height":4,"maxExpressionsInFunc":5,"maxFuncsInObject":6,"maxParamsInFunc":7,"maxObjectsInTree":8},"currentNode":1}""")
    val expected = "[7]"
    exec(
      http("call legal-neighbours and get expected value").
        post("/mind/legal-neighbours").
        body(input).asJSON.
        // Assertions
        check(status.is(200)).
        check(bodyString.is(expected))
    )
  }

  val `return empty seq when submission is valid but no matches are in scope` = {
    // Height set to zero.
    val input = StringBody( """{"scope":{"numVals":1,"numFuncs":2,"numObjects":3,"height":0,"maxExpressionsInFunc":5,"maxFuncsInObject":6,"maxParamsInFunc":7,"maxObjectsInTree":8},"currentNode":1}""")
    val expected = "[]"
    exec(
      http("call legal-neighbours and get expected value").
        post("/mind/legal-neighbours").
        body(input).asJSON.
        // Assertions
        check(status.is(200)).
        check(bodyString.is(expected))
    )
  }
}
