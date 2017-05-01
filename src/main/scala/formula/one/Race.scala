package formula.one

import scala.annotation.tailrec

class Race(teamNum: Int, trackLength: Double) {
  def assessInterval = 2
  val teams = for(i <- 1 to teamNum) yield Team(i)

  def run(): Seq[RaceResult] = {
    assess(0, Seq[RaceResult](), teams)
  }

  @tailrec
  private def assess(accuTime: Int, result: Seq[RaceResult], teams: Seq[Team]): Seq[RaceResult] = {
    if (teams.isEmpty) result
    else {
      // Check current position/distance
      val (completed, remainingTeams) =
        teams.foldLeft((Seq[RaceResult](),Seq[Team]())) {
          case ((result, teams), t) =>
            if (t.car.rePosition(assessInterval) >= trackLength)
              (result :+ RaceResult(t.number, t.car.speed, accuTime + assessInterval), teams)
            else
              (result, teams :+ t)
        }

      if (remainingTeams.isEmpty) result ++ completed
      else {
        // The first car is the slowest car
        val carsInRace = remainingTeams.map(_.car).sortWith(_.distance < _.distance)

        // Assessment by driver
        remainingTeams.foreach { case team =>
          team.driver.assess(carsInRace)
        }

        // TRACE
//        remainingTeams.foreach { t =>
//          println(s"${t.car} at ${accuTime + assessInterval}")
//        }

        assess(accuTime + assessInterval, result ++ completed, remainingTeams)
      }
    }
  }
}
