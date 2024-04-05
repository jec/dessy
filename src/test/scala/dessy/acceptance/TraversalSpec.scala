package dessy.acceptance

import dessy.model.{Value, ValueType}
import org.scalatest.wordspec.AnyWordSpec
import org.scalatest.matchers.should.*

class TraversalSpec extends AnyWordSpec with Matchers {
  case class ObservationType(name: String, uuid: String) extends ValueType
  case class Observation(valueType: ObservationType, value: String) extends Value

  "A traversal" should {
    "do something" in {
      true should be (true)
    }
  }
}
