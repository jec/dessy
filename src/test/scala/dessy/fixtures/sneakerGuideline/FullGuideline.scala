package dessy.fixtures.sneakerGuideline

import dessy.model._
import dessy.traversal.Context

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
   * @param tree
   */
  case class BooleanObservationType(cname: String, name: String, tree: Guideline) extends ValueType, IsBooleanType, ObservationType {
    override type AnyTree = Guideline
  }

  /**
   * An `EnumeratedObservationType` is a value type whose values are enumerated
   * by the referenced `BooleanObservationType`s.
   *
   * @param cname
   * @param name
   * @param tree
   * @param enumerations
   */
  case class EnumeratedObservationType(cname: String, name: String, tree: Guideline, enumerations: Set[BooleanObservationType]) extends ValueType, IsEnumeratedType, ObservationType {
    override type AnyTree = Guideline
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
    override type AnyValueType = BooleanObservationType
  }

  /**
   * An `EnumeratedObservation` is a value represented by an instance of a
   * `BooleanObservation`.
   *
   * @param valueType
   * @param value
   */
  case class EnumeratedObservation(valueType: EnumeratedObservationType, value: BooleanObservationType) extends Value, IsEnumerated {
    override type AnyValueType = EnumeratedObservationType
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

  private val sneakerGuideline = Guideline()

  private val basketballSneaker = BooleanObservationType("basketball", "Basketball sneaker", sneakerGuideline)
  private val runningSneaker = BooleanObservationType("running", "Running sneaker", sneakerGuideline)
  private val sneakerType = EnumeratedObservationType("sneaker-type", "Sneaker type", sneakerGuideline, Set(basketballSneaker, runningSneaker))

  private val dicksSportingGoods = BooleanObservationType("dicks-sporting-goods", "Dick's Sporting Goods", sneakerGuideline)
  private val champsSports = BooleanObservationType("champs-sports", "Champs Sports", sneakerGuideline)
  private val sneakerStore = EnumeratedObservationType("sneaker-store", "Sneaker store", sneakerGuideline, Set(dicksSportingGoods, champsSports))

  private val isRunningSneaker = BooleanObservation(runningSneaker, true)
}
