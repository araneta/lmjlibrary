import sbt._
import Keys._
import PlayProject._

object ApplicationBuild extends Build {

    val appName         = "lmjlibrary"
    val appVersion      = "1.0-SNAPSHOT"

    val appDependencies = Seq(
      // Add your project dependencies here,
		//"mysql" % "mysql-connector-java" % "5.1.18"
		"postgresql" % "postgresql" % "9.1-901.jdbc4"
		//"barcode4j" % "barcode4j" % "2.0"
    )

    val main = PlayProject(appName, appVersion, appDependencies, mainLang = JAVA).settings(
      // Add your own project settings here      
    )
    playAssetsDirectories <+= baseDirectory / "barcode"

}
