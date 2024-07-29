ThisBuild / version := "0.1.0-SNAPSHOT"

ThisBuild / scalaVersion := "3.3.2"

val Http4sVersion = "0.23.27"
val mongoDBDriverVersion = "5.1.2"
val catsEffectVersion = "3.6-0142603"
val mongo4CatsVersion = "0.7.8"
val circeVersion = "0.14.9"

val mongoDBDriver      = ("org.mongodb.scala"  %% "mongo-scala-driver"  % mongoDBDriverVersion).cross(CrossVersion.for3Use2_13)
val http4sDsl          =  "org.http4s"         %% "http4s-dsl"          % Http4sVersion
val http4sCirce        =  "org.http4s"         %% "http4s-circe"        % Http4sVersion
val emberServer        =  "org.http4s"         %% "http4s-ember-server" % Http4sVersion
val catsEffect         =  "org.typelevel"      %% "cats-effect"         % catsEffectVersion
val mongo4CatsCirce    =  "io.github.kirill5k" %% "mongo4cats-circe"    % mongo4CatsVersion
val mongo4CatsEmbedded =  "io.github.kirill5k" %% "mongo4cats-embedded" % mongo4CatsVersion
val mongo4CatsCore     =  "io.github.kirill5k" %% "mongo4cats-core"     % mongo4CatsVersion

val circeGeneric       =  "io.circe"           %% "circe-generic"       % circeVersion

lazy val root = (project in file("."))
  .settings(
    name := "mongoTest",
    libraryDependencies ++= Seq(
      mongoDBDriver,
      http4sDsl,
      catsEffect,
      emberServer,
      http4sCirce,
      circeGeneric,
      mongo4CatsCore,
      mongo4CatsCirce,
      mongo4CatsEmbedded
      )
    )
