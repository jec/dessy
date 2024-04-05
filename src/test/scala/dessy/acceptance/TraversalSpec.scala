package dessy.acceptance

import dessy.model.{BooleanValueType, EnumeratedValueType, Value, ValueType}
import org.scalatest.wordspec.AnyWordSpec
import org.scalatest.matchers.should.*

class TraversalSpec extends AnyWordSpec with Matchers {
  case class ObservationType(cname: String, name: String) extends ValueType
  case class BooleanObservationType(cname: String, name: String) extends BooleanValueType
  case class EnumeratedObservationType(cname: String, name: String, enumerations: Set[BooleanValueType]) extends EnumeratedValueType
  case class Observation(valueType: ObservationType, value: String) extends Value

  private val basketballSneaker = BooleanObservationType("basketball", "Basketball sneaker")
  private val runningSneaker = BooleanObservationType("running", "Running sneaker")
  private val sneakerType = EnumeratedObservationType("sneaker-type", "Sneaker type", Set(basketballSneaker, runningSneaker))

  private val dicksSportingGoods = BooleanObservationType("dicks-sporting-goods", "Dick's Sporting Goods")
  private val champsSports = BooleanObservationType("champs-sports", "Champs Sports")
  private val sneakerStore = EnumeratedObservationType("sneaker-store", "Sneaker store", Set(dicksSportingGoods, champsSports))

  "A traversal" should {
    "do something" in {
      true should be (true)
    }
  }
}
