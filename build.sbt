name := "zio-playground"

version := "0.1"

scalaVersion := "2.13.5"

val zioVersion        = "1.0.8"
val zioPreludeVersion = "1.0.0-RC5"
val zioLoggingVersion = "0.5.8"
val zioHttpVersion    = "1.0.0.0-RC15"
val zioJsonVersion    = "0.1.5"
val quillVersion      = "3.7.1"
val flywayVersion     = "7.9.1"
val zioConfigVersion  = "1.0.5"

scalacOptions += "-Ymacro-annotations"

libraryDependencies ++= Seq(
  "dev.zio"             %% "zio"                      % zioVersion,
  "dev.zio"             %% "zio-macros"               % zioVersion,
  "dev.zio"             %% "zio-prelude"              % zioPreludeVersion,
  "dev.zio"             %% "zio-json"                 % zioJsonVersion,
  "dev.zio"             %% "zio-logging-slf4j"        % zioLoggingVersion,
  "dev.zio"             %% "zio-config"               % zioConfigVersion,
  "dev.zio"             %% "zio-config-magnolia"      % zioConfigVersion,
  "dev.zio"             %% "zio-config-typesafe"      % zioConfigVersion,
  "io.d11"              %% "zhttp"                    % zioHttpVersion,
  "io.getquill"         %% "quill-jdbc-zio"           % quillVersion,
  "org.flywaydb"         % "flyway-core"              % flywayVersion,
  "org.postgresql"       % "postgresql"               % "42.2.8",
  "ch.qos.logback"       % "logback-classic"          % "1.2.3",
  "net.logstash.logback" % "logstash-logback-encoder" % "6.5",
  "dev.zio"             %% "zio-test"                 % zioVersion % Test,
  "dev.zio"             %% "zio-test-sbt"             % zioVersion % Test,
  "dev.zio"             %% "zio-test-magnolia"        % zioVersion % Test
)

testFrameworks += new TestFramework("zio.test.sbt.ZTestFramework")
