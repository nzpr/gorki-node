package coop.rchain.rholang.normalizer2.syntax

import coop.rchain.rholang.interpreter.compiler.FreeContext
import coop.rchain.rholang.normalizer2.env.BoundVarWriter

trait BoundVarWriterSyntax {
  implicit def boundVarWriterOps[T](bw: BoundVarWriter[T]): BoundVarWriterOps[T] = new BoundVarWriterOps[T](bw)
}

final class BoundVarWriterOps[T](val bw: BoundVarWriter[T]) extends AnyVal {

  /** Bound free variables in the current scope.
   *
   * Free variables are sorted by levels and then added with indexes:
   * {i0, i1, ..., iN} = {fl0 + last + 1, fl1 + last + 1, ..., flN + last + 1}.
   * Here, i0, ..., iN represent the Bruijn indices of the new bound vars,
   * fl0, ..., flN are the Bruijn levels of the inserted free vars,
   * last is the last index among all bound vars at the moment. */
  def absorbFree(freeVars: Seq[(String, FreeContext[T])]): Seq[Int] = {
    val sortedByLevel  = freeVars.sortBy(_._2.level)
    val (levels, data) = sortedByLevel.unzip(fv => (fv._2.level, (fv._1, fv._2.typ, fv._2.sourcePosition)))
    assert(
      levels == levels.indices,
      "Error when absorbing free variables during normalization: incorrect de Bruijn levels." +
        s"Should be ${levels.indices}, but was $levels.",
    )
    bw.putBoundVars(data)
  }
}
