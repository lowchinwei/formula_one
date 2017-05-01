package formula.one

import scala.util.{ Failure, Success, Try }

object Main {
  def main(arguments: Array[String]): Unit = {
    parameters(arguments) match {
      case Success((teamNumber, trackLength)) =>
        (new Race(teamNumber, trackLength)).run().foreach(println)
      case Failure(ex) =>
        println(s"Fail to start race because of ${ex.toString}")

    }
  }

  def parameters(params: Array[String]) = Try {
    if (params.size == 2) {
      val teamNumber = params(0).toInt
      if (teamNumber <= 0) throw new Exception("Team number cannot be zero or negative")
      val trackLength = params(1).toDouble
      if (trackLength <= 0) throw new Exception("Track length cannot be zero or negative")
      (teamNumber, trackLength)
    } else throw new Exception("Not enough argument")
  }
}
