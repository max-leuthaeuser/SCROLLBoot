name := "SCROLLBoot"

lazy val commonSettings = Seq(
  organization := "com.github.max-leuthaeuser",
  version := "0.1.0",
  scalaVersion := "3.8.3",
  javacOptions ++= Seq("--release", "17"),
  scalacOptions ++= Seq(
    "-encoding",
    "utf8",
    "-deprecation",
    "-feature",
    "-language:dynamics",
    "-language:reflectiveCalls",
    "-language:postfixOps",
    "-language:implicitConversions",
    "-unchecked"
  )
)

lazy val main = (project in file("."))
  .settings(commonSettings*)
  .settings(
    libraryDependencies += "com.github.max-leuthaeuser" %% "scroll" % "3.4"
  )
