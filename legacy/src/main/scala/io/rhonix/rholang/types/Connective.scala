package io.rhonix.rholang.types

/** Connective for type Bool in pattern */
object ConnBoolN extends ConnectiveSTypeN

/** Connective for type Int in pattern */
object ConnIntN extends ConnectiveSTypeN

/** Connective for type BigInt in pattern */
object ConnBigIntN extends ConnectiveSTypeN

/** Connective for type String in pattern */
object ConnStringN extends ConnectiveSTypeN

/** Connective for type Uri in pattern */
object ConnUriN extends ConnectiveSTypeN

/** Connective for type ByteArray in pattern */
object ConnByteArrayN extends ConnectiveSTypeN

/** The "~" (logical Not) for pattern matching.
  * the pattern ~p says "anything but p" */
final class ConnNotN(val p: ParN) extends ConnectiveFuncN
object ConnNotN { def apply(p: ParN): ConnNotN = new ConnNotN(p) }

/** The "/\" (logical And) Conjunction for pattern matching. */
// TODO: Consider a replacement `ps: Seq[ParN]` to `p1: ParN, p2: ParN`
final class ConnAndN(val ps: Seq[ParN]) extends ConnectiveFuncN
object ConnAndN {
  def apply(ps: Seq[ParN]): ConnAndN      = new ConnAndN(ps)
  def apply(p1: ParN, p2: ParN): ConnAndN = new ConnAndN(Seq(p1, p2))
}

/** The "\/" (logical Or) Disjunction for pattern matching. */
// TODO: Consider a replacement `ps: Seq[ParN]` to `p1: ParN, p2: ParN`
final class ConnOrN(val ps: Seq[ParN]) extends ConnectiveFuncN
object ConnOrN {
  def apply(ps: Seq[ParN]): ConnOrN      = new ConnOrN(ps)
  def apply(p1: ParN, p2: ParN): ConnOrN = new ConnOrN(Seq(p1, p2))
}

/** The "=..." Binding for Bound variable in pattern matching.
 * @param index the De Bruijn index of the variable which should have been bound above this pattern.
 * @param depth the CURRENT pattern nesting depth of THIS varRef. This is used for checking in reducer.
 *
 * The purpose of VarRef is to provide a mechanism to bind variables to values or processes
 * within pattern matching structures in Rholang, which is useful for controlling the flow of information
 * and processes within a Rholang program.
 * {{{  
 * // Example with match:
 *   new x in {
 *     match *x {
 *       =*x => true
 *       _   => false
 *     }
 *   }
 *  // Example with for:
 *  new x in {
 *    for(@{=*x} <- @"chan") { x!(Nil) }
 *  }
 *  // complex example
 *    new stdout(`rho:io:stdout`) in {
 *     match 42 {
 *       x => {
 *         @"chan1"!({for(@42 <- @"chan2") { Nil }}) |
 *         for (@y <- @"chan1") {
 *           match y {
 *             {for(@{=x} <- @"chan2") { Nil }} => stdout!("yes")
 *             _                                => stdout!("no")
 *           }
 *         }
 *       }
 *     }
 *   }
 * }}}
 */
final class ConnVarRefN(val index: Int, val depth: Int) extends ConnectiveVarN
object ConnVarRefN {
  def apply(index: Int, depth: Int): ConnVarRefN = new ConnVarRefN(index, depth)
}
