package dessy.acceptance

import dessy.model.{BooleanValueType, EnumeratedValueType, Value, ValueType}
import org.scalatest.wordspec.AnyWordSpec
import org.scalatest.matchers.should.*

class TraversalSpec extends AnyWordSpec with Matchers {
  case class ObservationType(cname: String, name: String, uuid: String) extends ValueType
  case class BooleanObservationType(cname: String, name: String, uuid: String) extends BooleanValueType
  case class EnumeratedObservationType(cname: String, name: String, uuid: String, enumerations: Set[BooleanValueType]) extends EnumeratedValueType
  case class Observation(valueType: ObservationType, value: String) extends Value

  private val basketballSneaker = BooleanObservationType("basketball", "Basketball sneaker", java.util.UUID.randomUUID.toString)
  private val runningSneaker = BooleanObservationType("running", "Running sneaker", java.util.UUID.randomUUID.toString)
  private val sneakerType = EnumeratedObservationType("sneaker-type", "Sneaker type", java.util.UUID.randomUUID.toString, Set(basketballSneaker, runningSneaker))

  private val dicksSportingGoods = BooleanObservationType("dicks-sporting-goods", "Dick's Sporting Goods", java.util.UUID.randomUUID.toString)
  private val champsSports = BooleanObservationType("champs-sports", "Champs Sports", java.util.UUID.randomUUID.toString)
  private val sneakerStore = EnumeratedObservationType("sneaker-store", "Sneaker store", java.util.UUID.randomUUID.toString, Set(dicksSportingGoods, champsSports))

  "A traversal" should {
    "do something" in {
      true should be (true)
    }
  }
}
