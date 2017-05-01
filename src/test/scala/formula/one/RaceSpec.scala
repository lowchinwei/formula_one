package formula.one

import org.scalatest.FunSpec

class RaceSpec extends FunSpec {
  describe("The race results") {
    it("Should match the expected") {
      val teamNumber = 5
      val trackLength = 100
      val expectedResult =
        Seq(
          RaceResult(1, 20.0, 10),
          RaceResult(2, Car(2, 0, 0).topSpeedMeterPerSecond, 14),
          RaceResult(3, 50.0, 14),
          RaceResult(4, Car(4, 0, 0).topSpeedMeterPerSecond, 16),
          RaceResult(5, Car(5, 0, 0).topSpeedMeterPerSecond, 16)
        )
      val result = (new Race(teamNumber, trackLength)).run()
      result.foreach(println)
      assert(compareResult(expectedResult, result))
    }
    it("Should match the expected for 10 teams") {
      val teamNumber = 10
      val trackLength = 100
      val expectedResult =
        Seq(
          RaceResult(1, 20.0, 10),
          RaceResult(2, Car(2, 0, 0).topSpeedMeterPerSecond, 14),
          RaceResult(3, 50.0, 14),
          RaceResult(4, Car(4, 0, 0).topSpeedMeterPerSecond, 16),
          RaceResult(5, Car(5, 0, 0).topSpeedMeterPerSecond, 18),
          RaceResult(6, Car(6, 0, 0).topSpeedMeterPerSecond, 20),
          RaceResult(7, Car(7, 0, 0).topSpeedMeterPerSecond, 20),
          RaceResult(8, Car(8, 0, 0).topSpeedMeterPerSecond, 22),
          RaceResult(9, Car(9, 0, 0).topSpeedMeterPerSecond, 24),
          RaceResult(10, Car(10, 0, 0).topSpeedMeterPerSecond, 24)
        )
      val result = (new Race(teamNumber, trackLength)).run()
      result.foreach(println)
      assert(compareResult(expectedResult, result))
    }
  }

  def compareResult(expectedResult: Seq[RaceResult], result: Seq[RaceResult]) = {
    if (expectedResult.size == result.size) {
      expectedResult.zip(result).forall { case (expected, result) => expected.equals(result) }
    } else false
  }
}
