package formula.one

case class RaceResult(teamNumber: Int, finalSpeed: Double, completionTime: Int) {
  override def toString: String = s"Team $teamNumber complete race at $completionTime s with $finalSpeed m/s"
}
