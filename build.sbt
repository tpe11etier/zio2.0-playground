name := "zio2.0-playground"

version := "0.1"

scalaVersion := "3.1.2"

resolvers += "Sonatype OSS Snapshots" at "https://s01.oss.sonatype.org/content/repositories/snapshots"
resolvers += "Moar Sonatype OSS Snapshots" at "https://oss.sonatype.org/content/repositories/snapshots"

val zioVersion        = "2.0.0-RC5"
val zioPreludeVersion = "1.0.0-RC13"
val zioLoggingVersion = "0.5.14"
val zioHttpVersion    = "2.0.0-RC6"
val zioJsonVersion    = "0.3.0-RC7"
val zioOpticsVersion  = "2.0.0-RC4"
val zioSchemaVersion  = "0.2.0-RC5"
val zQueryVersion     = "0.3.0-RC4"
//val quillVersion      = "3.16.3"
//val flywayVersion     = "8.5.7"
val zioConfigVersion  = "3.0.0-RC8"
val tapirVersion      = "1.0.0-M6"
//val chimneyVersion    = "0.6.1"
val sttpVersion       = "3.5.1"
val zmxVersion        = "0.0.11"
val zioMagicVersion   = "0.3.11"

//scalacOptions += "-Ymacro-annotations"

libraryDependencies ++= Seq(
  "dev.zio"                       %% "zio"                      % zioVersion,
  "dev.zio"                       %% "zio-macros"               % zioVersion,
  "dev.zio"                       %% "zio-prelude"              % zioPreludeVersion,
  "dev.zio"                       %% "zio-json"                 % zioJsonVersion,
  "dev.zio"                       %% "zio-logging-slf4j"        % zioLoggingVersion,
  "dev.zio"                       %% "zio-config"               % zioConfigVersion,
  "dev.zio"                       %% "zio-config-magnolia"      % zioConfigVersion,
  "dev.zio"                       %% "zio-config-typesafe"      % zioConfigVersion,
  "dev.zio"                       %% "zio-query"                % zQueryVersion,
//  "dev.zio"                       %% "zio-schema"               % zioSchemaVersion,
  "dev.zio"                       %% "zio-zmx"                  % zmxVersion,
//  "io.github.kitlangton"          %% "zio-magic"                % zioMagicVersion,
  "dev.zio"                       %% "zio-optics"               % zioOpticsVersion,
  "io.d11"                        %% "zhttp"                    % zioHttpVersion,
//  "io.getquill"                   %% "quill-jdbc-zio"           % quillVersion,
//  "org.flywaydb"                   % "flyway-core"              % flywayVersion,
  "com.softwaremill.sttp.tapir"   %% "tapir-zio"                % tapirVersion,
//  "com.softwaremill.sttp.tapir"   %% "tapir-zio-http"           % tapirVersion,
  "com.softwaremill.sttp.tapir"   %% "tapir-json-zio"           % tapirVersion,
  "com.softwaremill.sttp.tapir"   %% "tapir-redoc"              % tapirVersion,
  "com.softwaremill.sttp.tapir"   %% "tapir-openapi-docs"       % tapirVersion,
  "com.softwaremill.sttp.tapir"   %% "tapir-openapi-circe-yaml" % tapirVersion,
//  "io.scalaland"                  %% "chimney"                  % chimneyVersion,
  "com.softwaremill.sttp.client3" %% "httpclient-backend-zio"   % sttpVersion,
  "com.github.jwt-scala"          %% "jwt-core"                 % "9.0.5",
  "org.postgresql"                 % "postgresql"               % "42.3.3",
  "ch.qos.logback"                 % "logback-classic"          % "1.2.11",
  "net.logstash.logback"           % "logstash-logback-encoder" % "7.0.1",
  "dev.zio"                       %% "zio-test"                 % zioVersion % Test,
  "dev.zio"                       %% "zio-test-sbt"             % zioVersion % Test,
  "dev.zio"                       %% "zio-test-magnolia"        % zioVersion % Test
)
excludeDependencies ++= Seq(
  "com.thesamet.scalapb"   % "scalapb-runtime_2.13",
  "org.scala-lang.modules" % "scala-collection-compat_2.13"
)

testFrameworks += new TestFramework("zio.test.sbt.ZTestFramework")
