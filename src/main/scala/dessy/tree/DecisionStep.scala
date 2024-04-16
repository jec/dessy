package dessy.tree

import dessy.traversal

/**
 * A leaf node in a decision tree that presents a list of Choices
 */
class DecisionStep extends Step {
  def traverse(ctx: traversal.Context): traversal.result.Completed = {
    traversal.result.Completed()
  }

  def nextStep(): Option[Step] = None
}
