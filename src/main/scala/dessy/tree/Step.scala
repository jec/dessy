package dessy.tree

import dessy.traversal

trait Step {
  type AnyResult <: traversal.Result
  type AnyStep <: Step
  
  def traverse(ctx: traversal.Context): AnyResult
  def nextStep(): AnyStep
}
