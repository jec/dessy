package dessy.model

trait IsEnumeratedType {
  type AnyBooleanValueType <: BooleanValueType

  val enumerations: Set[IsBooleanType]
}
