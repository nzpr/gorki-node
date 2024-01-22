package coop.rchain.rholang.normalizer2.env

trait RestrictReader {

  /** Current processing is being executed within a pattern. */
  def insidePattern: Boolean

  /** Current processing is being executed within a receive pattern
   *  and this receive is not inside any other pattern */
  def insideTopLevelReceivePattern: Boolean

  /** Current processing is being executed within a bundle*/
  def insideBundle: Boolean
}