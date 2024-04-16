package dessy.model

/**
 * Represents a type of value that is used during traversal
 *
 * In object-oriented terms, a ValueType is the class of a value, not an actual
 * value.
 */
trait ValueType {
  val cname: String
  val name: String
  val uuid: String = java.util.UUID.randomUUID.toString
  val tree: Tree
}
