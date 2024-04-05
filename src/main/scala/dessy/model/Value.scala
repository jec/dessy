package dessy.model

trait Value {
  type AnyValueType <: ValueType
  
  val valueType: AnyValueType
}
