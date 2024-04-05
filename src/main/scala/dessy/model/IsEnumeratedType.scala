package dessy.model

trait IsEnumeratedType {
  type AnyBooleanType <: IsBooleanType
  val enumerations: Set[AnyBooleanType]
}
