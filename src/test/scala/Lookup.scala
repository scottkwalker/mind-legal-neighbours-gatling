import io.gatling.core.Predef._
import io.gatling.http.Predef._
import play.api.libs.json.{JsNumber, JsObject, JsValue, Json}

object Lookup {

  val `return bad request when submission is empty` =
    exec(
      http("call legal-neighbours and get expected value").
        post("/mind/legal-neighbours").
        // Assertions
        check(status.is(400))
    )

  val `return ok with seq of ids when submission is valid and legal moves are found` = {
    val asJson: JsValue = {
      val scopeAsJson: (String, JsValue) = ("scope", JsObject(
        fields = Seq(
          ("numVals", JsNumber(1)),
          ("numFuncs", JsNumber(2)),
          ("numObjects", JsNumber(3)),
          ("height", JsNumber(4)),
          ("maxExpressionsInFunc", JsNumber(5)),
          ("maxFuncsInObject", JsNumber(6)),
          ("maxParamsInFunc", JsNumber(7)),
          ("maxObjectsInTree", JsNumber(8))
        )
      ))
      val currentNodeAsJson: (String, JsValue) = ("currentNode", JsNumber(1))

      JsObject(
        fields = Seq(
          scopeAsJson,
          currentNodeAsJson
        )
      )
    }
    val asString = Json.stringify(asJson)
    val input = StringBody(asString)
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
