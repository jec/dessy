package dessy.model

/**
 * Represents a value that is used during traversal
 *
 * In object-oriented terms, a Value is the instantiation of an actual value of
 * a given ValueType.
 */
trait Value {
  type AnyValueType <: ValueType

  val valueType: AnyValueType
}
