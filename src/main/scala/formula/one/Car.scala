package formula.one

case class Car(teamNumber: Int, var speed: Double, var distance: Double, var nitroUsed: Boolean = false) {
  def topSpeed: Int = 150 + (10 * teamNumber)
  def kmPerHourToMeterPerSecond: Double = 1000.0 / 3600
  def topSpeedMeterPerSecond: Double = topSpeed * kmPerHourToMeterPerSecond
  def acceleration: Int = 2 * teamNumber
  def handlingFactor: Double = 0.8

  def accelerate(time: Int) {
    // TRACE
    //println(s"car ${teamNumber} accelerate")
    speed = topSpeedMeterPerSecond.min(speed + acceleration * time)
  }
  def decelerate = {
    // TRACE
    //println(s"car ${teamNumber} decelerate")
    speed = speed * handlingFactor
  }
  def rePosition(time: Int) = {
    distance = distance + (speed * time) + (acceleration / 2.0 * time * time)
    accelerate(time)
    distance
  }

  def useNitro {
    if (!nitroUsed) {
      // TRACE
      //println(s"car ${teamNumber} using nitro")
      speed = topSpeedMeterPerSecond.min(speed * 2)
      nitroUsed = true
    }
  }

}
