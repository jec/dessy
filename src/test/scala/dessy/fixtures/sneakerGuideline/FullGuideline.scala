package dessy.fixtures.sneakerGuideline

import dessy.model._
import dessy.traversal.Context
import dessy.tree

/**
 * Includes the full "Sneaker Guideline"
 */
trait FullGuideline {
  /**
   * A Guideline is a decision tree that collects all related value types
   * (`ObservationType`s here), values (`Observation`s here), and choice-related
   * classes. in addition to the tree nodes.
   */
  class Guideline extends Tree

  /**
   * An `ObservationType` is a value type.
   */
  trait ObservationType extends ValueType

  /**
   * A `BooleanObservationType` is a value type that can be true or false.
   *
   * @param cname
   * @param name
   */
  case class BooleanObservationType(cname: String, name: String) extends ValueType, IsBooleanType, ObservationType {
  }

  /**
   * An `EnumeratedObservationType` is a value type whose values are enumerated
   * by the referenced `BooleanObservationType`s.
   *
   * @param cname
   * @param name
   * @param enumerations
   */
  case class EnumeratedObservationType(cname: String, name: String, enumerations: Set[BooleanObservationType]) extends ValueType, IsEnumeratedType, ObservationType {
    override type AnyBooleanType = BooleanObservationType
  }

  /**
   * An `Observation` is a value.
   */
  trait Observation extends Value

  /**
   * A `BooleanObservation` is a value that can be either true or false.
   *
   * @param valueType
   * @param value
   */
  case class BooleanObservation(valueType: BooleanObservationType, value: Boolean) extends Value, IsBoolean {
  }

  /**
   * An `EnumeratedObservation` is a value represented by an instance of a
   * `BooleanObservation`.
   *
   * @param valueType
   * @param value
   */
  case class EnumeratedObservation(valueType: EnumeratedObservationType, value: BooleanObservationType) extends Value, IsEnumerated {
    override type AnyBooleanType = BooleanObservationType
  }

  /**
   * A `TestContext` is a context that contains the `Observation`s used by
   * a traversal of a `Guideline` decision tree.
   *
   * @param values observations used for the traversal
   */
  case class TestContext(values: Set[Observation]) extends Context {
    override type AnyValue = Observation
  }

  private val decisionStep = tree.DecisionStep()

  private val sneakerGuideline = Guideline()

  private val basketballSneaker = BooleanObservationType("basketball", "Basketball sneaker")
  private val runningSneaker = BooleanObservationType("running", "Running sneaker")
  private val sneakerType = EnumeratedObservationType("sneaker-type", "Sneaker type", Set(basketballSneaker, runningSneaker))

  private val dicksSportingGoods = BooleanObservationType("dicks-sporting-goods", "Dick's Sporting Goods")
  private val champsSports = BooleanObservationType("champs-sports", "Champs Sports")
  private val sneakerStore = EnumeratedObservationType("sneaker-store", "Sneaker store", Set(dicksSportingGoods, champsSports))

  private val isRunningSneaker = BooleanObservation(runningSneaker, true)
}
