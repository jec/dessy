package dessy.model

/**
 * A mixin for an enumerated Value
 */
trait IsEnumerated {
  type AnyBooleanType <: IsBooleanType 
    
  val value: AnyBooleanType
}
