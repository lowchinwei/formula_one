package formula.one

case class Driver(teamNumber: Int, myCar: Car) {
  def decerelateThreshold = 10
  def assess(cars: Seq[Car]) = {
    if (cars.head.teamNumber == teamNumber) myCar.useNitro
    else {
      // check any car within 10 m and decelerate
      cars.find(c => c.teamNumber != teamNumber && Math.abs(c.distance - myCar.distance) < decerelateThreshold) match {
        case Some(c) => myCar.decelerate
        case None =>
      }
    }
  }
}
