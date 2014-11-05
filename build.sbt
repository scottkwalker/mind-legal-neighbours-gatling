name := """mind-legal-neighbours-gatling"""

version := "1.0-SNAPSHOT"

scalaVersion := "2.10.4"

lazy val root = (project in file(".")).
  enablePlugins(GatlingPlugin)

// Change this to another test framework if you prefer
libraryDependencies ++= Seq(
  "org.scalatest" %% "scalatest" % "2.2.2" % "test",
  "io.gatling.highcharts" % "gatling-charts-highcharts" % "2.0.2" % "test",
  "io.gatling" % "test-framework" % "1.0" % "test",
  "com.typesafe.play" %% "play-json" % "2.4.0-M1")