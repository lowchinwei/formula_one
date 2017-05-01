package formula.one

import org.scalatest.FunSpec

class MainTestSpec extends FunSpec {
  describe("The main program") {
    it("Should validate empty arguments") {
      assert(Main.parameters(Array()).isFailure)
    }
    it("Should validate missing arguments") {
      assert(Main.parameters(Array("1")).isFailure)
    }
    it("Should validate invalid team number") {
      assert(Main.parameters(Array("s", "1")).isFailure)
      assert(Main.parameters(Array("", "1")).isFailure)
      assert(Main.parameters(Array("0", "1")).isFailure)
      assert(Main.parameters(Array("-1100", "1")).isFailure)
    }
    it("Should validate invalid track length") {
      assert(Main.parameters(Array("5", "s")).isFailure)
      assert(Main.parameters(Array("5", "")).isFailure)
      assert(Main.parameters(Array("5", "0")).isFailure)
      assert(Main.parameters(Array("5", "-1100")).isFailure)
    }
    it("Should parse the parameters correctly") {
      val teamNumber = 5
      val trackLength = 10
      val params = Main.parameters(Array(teamNumber.toString, trackLength.toString))
      assert(params.isSuccess)
      assert(params.get._1 == teamNumber && params.get._2 == trackLength)
    }
  }
}
