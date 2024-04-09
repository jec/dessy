package dessy.tree

import dessy.traversal

/**
 * Represents a node in a decision tree
 */
trait Step {
  type AnyResult <: traversal.Result
  type AnyStep <: Step
  
  def traverse(ctx: traversal.Context): AnyResult
  def nextStep(): AnyStep
}
