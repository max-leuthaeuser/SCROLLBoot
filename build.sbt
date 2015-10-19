name := "SCROLLBoot"

lazy val commonSettings = Seq(
  organization := "tu.dresden.de",
  version := "0.0.1",
  scalaVersion := "2.11.7",
  scalacOptions := Seq("-unchecked", "-deprecation", "-feature", "-encoding", "utf8")
)

lazy val main = (project in file(".")).settings(commonSettings: _*).
  settings(
    libraryDependencies ++= Seq(
      "com.github.max-leuthaeuser" % "scroll_2.11" % "latest.integration"
    )
  )
