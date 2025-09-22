ThisBuild / version      := "0.1.0"
ThisBuild / scalaVersion := "2.13.8"

lazy val canoe = project
  .in(file("."))
  .settings(
    name := "canoe",
    libraryDependencies ++= Seq(
      "org.http4s"    %% "http4s-dsl"          % http4sVersion,
      "org.http4s"    %% "http4s-blaze-client" % http4sVersion,
      "org.http4s"    %% "http4s-blaze-server" % http4sVersion,
      "org.http4s"    %% "http4s-circe"        % http4sVersion,
      "org.typelevel" %% "log4cats-slf4j"      % log4catsVersion
    ) ++ Seq(
      "co.fs2"        %% "fs2-core"      % fs2Version,
      "org.typelevel" %% "cats-core"     % catsCoreVersion,
      "org.typelevel" %% "cats-effect"   % catsEffectVersion,
      "io.circe"      %% "circe-core"    % circeVersion,
      "io.circe"      %% "circe-generic" % circeVersion,
      "io.circe"      %% "circe-parser"  % circeVersion,
      "org.typelevel" %% "log4cats-core" % log4catsVersion
    ) ++ (CrossVersion.partialVersion(scalaVersion.value) match {
      case Some((2, _)) =>
        Seq(
          compilerPlugin(("org.typelevel" % "kind-projector" % kindProjectorVersion).cross(CrossVersion.full)),
          compilerPlugin("org.augustjune" %% "context-applied" % contextAppliedVersion)
        )
      case _ => Seq.empty
    })
  )

lazy val fs2Version = "3.2.10"
lazy val catsCoreVersion = "2.7.0"
lazy val catsEffectVersion = "3.3.13"
lazy val catsLawsVersion = "2.8.0"
lazy val circeVersion = "0.14.1"
lazy val http4sVersion = "0.23.11"
lazy val log4catsVersion = "2.3.2"
lazy val scalatestVersion = "3.2.18"
lazy val disciplineVersion = "2.2.0"
lazy val scalacheckShapelessVersion = "1.2.5"
lazy val scalaJsDomVersion = "2.1.0"
lazy val scalaJsMacroTaskExecutor = "1.1.0"
lazy val kindProjectorVersion = "0.13.2"
lazy val contextAppliedVersion = "0.1.4"
