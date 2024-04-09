package dessy.traversal

import dessy.model.Value

/**
 * Represents a set of Values used during the traversal of a decision tree
 */
trait Context {
  type AnyValue <: Value

  val values: Set[AnyValue]
}
