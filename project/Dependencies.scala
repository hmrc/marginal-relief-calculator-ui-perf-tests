import sbt._

object Dependencies {

//  TODO: UPGRADING CAUSES ERROR - NEED TO INVESTIGATE
  private val gatlingVersion = "3.6.1"

  val test = Seq(
    "com.typesafe"          % "config"                    % "1.4.3"        % Test,
    "uk.gov.hmrc"          %% "performance-test-runner"   % "6.0.0"        % Test,
    "io.gatling"            % "gatling-test-framework"    % gatlingVersion % Test,
    "io.gatling.highcharts" % "gatling-charts-highcharts" % gatlingVersion % Test
  )
}
