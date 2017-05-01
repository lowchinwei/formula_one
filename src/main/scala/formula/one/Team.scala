package formula.one

case class Team(number: Int) {
  val car = Car(number, 0, startPoint)
  val driver = Driver(number, car)
  def startPoint = {
    -(number - 1) * 200
  }
}
