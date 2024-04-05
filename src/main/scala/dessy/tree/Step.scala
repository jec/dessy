package dessy.tree

import dessy.traversal

trait Step {
  def traverse(ctx: traversal.Context): traversal.Result
  def nextStep(): Step
}
