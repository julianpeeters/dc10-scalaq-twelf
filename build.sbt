val Dc10ScalaQV = "0.6.0"
val MUnitV = "0.7.29"

inThisBuild(List(
  crossScalaVersions := Seq(scalaVersion.value),
  description := "Render to Twelf as a target lang. Library for use with the dc10-scalaq code generator.",
  organization := "com.julianpeeters",
  homepage := Some(url("https://github.com/julianpeeters/dc10-scalaq-twelf")),
  licenses := List("Apache-2.0" -> url("http://www.apache.org/licenses/LICENSE-2.0")),
  developers := List(
    Developer(
      "julianpeeters",
      "Julian Peeters",
      "julianpeeters@gmail.com",
      url("http://github.com/julianpeeters")
    )
  ),
  scalacOptions ++= Seq(
    "-deprecation",
    "-feature",
    "-Werror",
    "-source:future",
    "-Wunused:all",
    "-Wvalue-discard"
  ),
  scalaVersion := "3.4.0",
  versionScheme := Some("semver-spec"),
))

lazy val scalaq = crossProject(JSPlatform, JVMPlatform, NativePlatform)
  .in(file("modules/render"))
  .settings(
    name := "dc10-scalaq-twelf",
    libraryDependencies ++= Seq(
      // main
      "com.julianpeeters" %%% "dc10-scalaq" % Dc10ScalaQV,
      // test
      "org.scalameta"     %% "munit"        % MUnitV      % Test
    )
  )
  .jsSettings(test := {})
  .nativeSettings(test := {})

lazy val docs = project.in(file("docs/gitignored"))
  .settings(
    mdocOut := file("."),
    mdocVariables := Map(
      "SCALAQ" -> Dc10ScalaQV,
      "SCALA" -> crossScalaVersions.value.map(e => e.takeWhile(_ != '.')).mkString(", "),
      "TWELF" -> "1.7.1+",
      "VERSION" -> version.value.takeWhile(_ != '+'),
    )
  )
  .dependsOn(scalaq.jvm)
  .enablePlugins(MdocPlugin)
  .enablePlugins(NoPublishPlugin)