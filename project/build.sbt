
lazy val googleadsGetRefreshToken = (project in file("."))
  .settings(
    organization := "com.gu",
    libraryDependencies ++= Seq(
      "com.google.api-ads" % "ads-lib" % "3.7.0",
      "com.google.api-client" % "google-api-client" % "1.23.0"
    ),
    resolvers := Seq(
      Classpaths.typesafeReleases,
      "Typesafe Repo" at "http://repo.typesafe.com/typesafe/releases/"
    ),
    licenses += ("Apache-2.0", url("http://www.apache.org/licenses/LICENSE-2.0.html"))
  )

