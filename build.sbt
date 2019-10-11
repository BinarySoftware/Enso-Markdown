lazy val root = (project in file(".")).
  settings(
    inThisBuild(List(
      organization := "com.BinarySoftware",
      name := "PROJECT_NAME",
      version := "1.0",
      trapExit := false
    )),
    name := "PROJECT_NAME"
  )

val circeVersion = "0.10.0"

libraryDependencies ++= Seq(
  "org.scalatest" %% "scalatest" % "3.0.8" % "test"
)