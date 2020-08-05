
scalaVersion := "2.12.10"

libraryDependencies ++= Seq(
  "com.amazonaws" % "aws-xray-recorder-sdk-core" % "2.6.1",
  "com.twitter" % "util-core_2.12" % "20.6.0",
  "com.twitter" %% "finagle-http" % "20.6.0",
  "com.twitter" %% "twitter-server" % "20.7.0",
  "ch.qos.logback" % "logback-classic" % "1.2.3"
)

