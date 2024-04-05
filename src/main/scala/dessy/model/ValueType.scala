package dessy.model

trait ValueType {
  val cname: String
  val name: String
  val uuid: String = java.util.UUID.randomUUID.toString
}
