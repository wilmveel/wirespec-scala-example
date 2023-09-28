name := "wirespec-scala-example"
version := "0.0.1"
organization := "community.flock.wirespec.example.scala"

libraryDependencies ++= Seq(
  "com.fasterxml.jackson.core" % "jackson-databind" % "2.15.2",
  "com.fasterxml.jackson.module" %% "jackson-module-scala" % "2.15.2",
  "dev.zio" %% "zio" % "2.0.18",
  "dev.zio" %% "zio-http" % "3.0.0-RC2"
)