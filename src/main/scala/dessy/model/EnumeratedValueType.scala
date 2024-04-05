package dessy.model

trait EnumeratedValueType extends ValueType {
  type AnyBooleanValueType <: BooleanValueType

  val enumerations: Set[AnyBooleanValueType]
}
