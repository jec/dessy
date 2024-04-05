package dessy.acceptance

import dessy.model._
import dessy.traversal.Context
import org.scalatest.wordspec.AnyWordSpec
import org.scalatest.matchers.should.*

class TraversalSpec extends AnyWordSpec with Matchers {
  class Guideline extends Tree
  trait ObservationType extends ValueType
  case class BooleanObservationType(cname: String, name: String, tree: Guideline) extends ValueType with IsBooleanType with ObservationType {
    override type AnyTree = Guideline
  }
  case class EnumeratedObservationType(cname: String, name: String, tree: Guideline, enumerations: Set[BooleanObservationType]) extends ValueType with IsEnumeratedType with ObservationType {
    override type AnyTree = Guideline
    override type AnyBooleanType = BooleanObservationType
  }
  trait Observation extends Value
  case class BooleanObservation(valueType: BooleanObservationType, value: Boolean) extends Value with IsBoolean {
    override type AnyValueType = BooleanObservationType
  }
  case class EnumeratedObservation(valueType: EnumeratedObservationType, value: BooleanObservationType) extends Value with IsEnumerated {
    override type AnyValueType = EnumeratedObservationType
    override type AnyBooleanType = BooleanObservationType
  }
  case class TestContext(values: Set[Observation]) extends Context {
    override type AnyValue = Observation
  }

  private val sneakerGuideline = Guideline()
  private val basketballSneaker = BooleanObservationType("basketball", "Basketball sneaker", sneakerGuideline)
  private val runningSneaker = BooleanObservationType("running", "Running sneaker", sneakerGuideline)
  private val sneakerType = EnumeratedObservationType("sneaker-type", "Sneaker type", sneakerGuideline, Set(basketballSneaker, runningSneaker))

  private val dicksSportingGoods = BooleanObservationType("dicks-sporting-goods", "Dick's Sporting Goods", sneakerGuideline)
  private val champsSports = BooleanObservationType("champs-sports", "Champs Sports", sneakerGuideline)
  private val sneakerStore = EnumeratedObservationType("sneaker-store", "Sneaker store", sneakerGuideline, Set(dicksSportingGoods, champsSports))

  private val isRunningSneaker = BooleanObservation(runningSneaker, true)

  "A traversal" should {
    "do something" in {
      true should be (true)
    }
  }
}
