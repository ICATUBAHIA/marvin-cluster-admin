/**
  * Copyright [2017] [B2W Digital]
 **
 Licensed under the Apache License, Version 2.0 (the "License");
*you may not use this file except in compliance with the License.
*You may obtain a copy of the License at
 **
 http://www.apache.org/licenses/LICENSE-2.0
 **
 Unless required by applicable law or agreed to in writing, software
*distributed under the License is distributed on an "AS IS" BASIS,
*WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
*See the License for the specific language governing permissions and
*limitations under the License.
  */
name := "marvin-cluster-admin"

version := "0.0.1"

scalaVersion := "2.12.3"

libraryDependencies ++= Seq(
  "com.typesafe.akka" %% "akka-http" % "10.0.10",
  "com.typesafe.akka" %% "akka-http-spray-json" % "10.0.10",
  "org.clapper"       %% "grizzled-slf4j" % "1.3.0",
  "com.typesafe.akka" %% "akka-http-testkit" % "10.0.10" % Test,
  "org.scalatest"     %% "scalatest"     % "3.0.1" % Test,
  "org.scalamock"     %% "scalamock-scalatest-support" % "3.5.0" % Test
)

mainClass in (Compile, run) := Some("org.marvin.cluster.api.AdminHttpAPI")
mainClass in assembly := Some("org.marvin.custer.api.AdminHttpAPI")