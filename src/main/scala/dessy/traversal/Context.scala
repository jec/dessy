package dessy.traversal

import dessy.model.Value

trait Context {
  type AnyValue <: Value
  
  val values: Set[AnyValue]
}
