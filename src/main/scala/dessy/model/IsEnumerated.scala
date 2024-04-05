package dessy.model

trait IsEnumerated {
  type AnyBooleanType <: IsBooleanType 
    
  val value: AnyBooleanType
}
