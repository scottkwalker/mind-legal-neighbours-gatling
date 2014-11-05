//SBT plugins used by the project build

logLevel := Level.Debug

resolvers += "sonatype-releases" at "https://oss.sonatype.org/content/repositories/releases/"

resolvers += "Typesafe Repo" at "http://repo.typesafe.com/typesafe/releases/"

addSbtPlugin("io.gatling" % "sbt-plugin" % "1.0")

addSbtPlugin("com.typesafe.sbt" % "sbt-git" % "0.6.4")