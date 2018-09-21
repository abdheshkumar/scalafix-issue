val commonSettings = Seq(
  version := "0.1",
  scalaVersion := "2.12.6",
  scalacOptions := Seq(
    "-Yrangepos",
    "-Ywarn-unused-import",
    "-P:semanticdb:exclude:Macros"
  ),
  addCompilerPlugin(scalafixSemanticdb)
)

val projectA = (project in file("projectA"))
  .settings(name := "projectA")
  .settings(commonSettings)

val projectB = (project in file("projectB"))
  .settings(name := "projectB")
  .settings(commonSettings)

val root = (project in file("."))
  .settings(name := "root")
  //.settings(commonSettings) // it will fix the problem
  .aggregate(projectA, projectB)
