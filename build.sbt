val scala3Version = "3.3.4"

lazy val root = project
  .in(file("."))
  .settings(
    name := "dessy",
    version := "0.1.0-SNAPSHOT",

    scalaVersion := scala3Version,
    scalacOptions += "-explain",

    libraryDependencies ++= Seq(
      "org.scalameta" %% "munit" % "1.0.0" % "test",
      "org.scalactic" %% "scalactic" % "3.2.19",
      "org.scalatest" %% "scalatest" % "3.2.19" % "test"
    )
  )
