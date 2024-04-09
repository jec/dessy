package dessy.acceptance

import dessy.fixtures.sneakerGuideline.FullGuideline
import org.scalatest.wordspec.AnyWordSpec
import org.scalatest.matchers.should.*

class TraversalSpec extends AnyWordSpec, Matchers, FullGuideline {
  "A traversal" should {
    "do something" in {
      true should be (true)
    }
  }
}
