ThisBuild / version      := "0.1.0"
ThisBuild / scalaVersion := "2.13.8"

lazy val canoe = project
  .in(file("."))
  .settings(
    name := "canoe",
    libraryDependencies ++= Seq(
      "org.http4s"    %% "http4s-dsl"          % "0.23.11",
      "org.http4s"    %% "http4s-blaze-client" % "0.23.11",
      "org.http4s"    %% "http4s-blaze-server" % "0.23.11",
      "org.http4s"    %% "http4s-circe"        % "0.23.11",
      "org.typelevel" %% "log4cats-slf4j"      % "2.3.2",
      "co.fs2"        %% "fs2-core"            % "3.2.10",
      "org.typelevel" %% "cats-core"           % "2.7.0",
      "org.typelevel" %% "cats-effect"         % "3.3.13",
      "io.circe"      %% "circe-core"          % "0.14.1",
      "io.circe"      %% "circe-generic"       % "0.14.1",
      "io.circe"      %% "circe-parser"        % "0.14.1",
      "org.typelevel" %% "log4cats-core"       % "2.3.2"
    ),
    addCompilerPlugin("org.augustjune" %% "context-applied" % "0.1.4")
  )
