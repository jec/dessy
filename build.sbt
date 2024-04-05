val scala3Version = "3.4.1"

lazy val root = project
  .in(file("."))
  .settings(
    name := "dessy",
    version := "0.1.0-SNAPSHOT",

    scalaVersion := scala3Version,
    scalacOptions += "-explain",

    libraryDependencies ++= Seq(
      "org.scalameta" %% "munit" % "0.7.29" % "test",
      "org.scalactic" %% "scalactic" % "3.2.18",
      "org.scalatest" %% "scalatest" % "3.2.18" % "test"
    )
  )
