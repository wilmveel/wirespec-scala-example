name := "wirespec-scala-example"
version := "0.0.1"
organization := "community.flock.wirespec.example.scala"

libraryDependencies ++= Seq(
  "dev.zio" %% "zio" % "2.0.18",
  "dev.zio" %% "zio-http" % "3.0.0-RC2",
  "dev.zio" %% "zio-json" % "0.6.1"
)