package dessy.model

trait EnumeratedValueType extends ValueType {
  val enumerations: Set[BooleanValueType]
}
