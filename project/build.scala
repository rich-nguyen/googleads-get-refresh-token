
import sbt.Keys._
import sbt._

object GoogleadsGetRefreshToken extends Build {


  lazy val googleadsGetRefreshToken = Project("root", file("."))
    .settings(
      organization := "com.gu",
      libraryDependencies ++= Seq(
        "com.google.api-ads" % "ads-lib" % "2.14.0"
      ),
      resolvers := Seq(
        Classpaths.typesafeReleases,
        "Typesafe Repo" at "http://repo.typesafe.com/typesafe/releases/"
      ),
      licenses += ("Apache-2.0", url("http://www.apache.org/licenses/LICENSE-2.0.html"))
    )

  }
