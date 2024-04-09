package dessy.model

/**
 * A mixin for a ValueType that is an enumerated type
 */
trait IsEnumeratedType {
  type AnyBooleanType <: IsBooleanType
  val enumerations: Set[AnyBooleanType]
}
