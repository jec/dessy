package dessy.tree

import dessy.traversal

/**
 * Represents a node in a decision tree
 */
trait Step {
  def traverse(ctx: traversal.Context): traversal.Result
  def nextStep(): Option[Step]
}
