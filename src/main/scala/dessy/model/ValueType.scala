package dessy.model

trait ValueType {
  type AnyTree <: Tree
  
  val cname: String
  val name: String
  val uuid: String = java.util.UUID.randomUUID.toString
  val tree: AnyTree
}
