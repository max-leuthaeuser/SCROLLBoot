name := "SCROLLBoot"

lazy val commonSettings = Seq(
  organization := "tu.dresden.de",
  version := "0.0.1",
  scalaVersion := "2.12.3",
  scalacOptions ++= Seq(
  	"-encoding", "utf8",
    "-deprecation",
    "-feature",
    "-language:dynamics",
    "-language:reflectiveCalls",
    "-language:postfixOps",
    "-language:implicitConversions",
    "-unchecked",
    "-target:jvm-1.8")
)

lazy val main = (project in file(".")).settings(commonSettings: _*).
  settings(
    libraryDependencies ++= Seq(
      "com.github.max-leuthaeuser" %% "scroll" % "latest.integration"
    )
  )
