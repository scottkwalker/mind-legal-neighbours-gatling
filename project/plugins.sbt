//SBT plugins used by the project build

logLevel := Level.Debug

resolvers += "sonatype-releases" at "https://oss.sonatype.org/content/repositories/releases/"

addSbtPlugin("io.gatling" % "sbt-plugin" % "1.0-RC1")