package tp

/**
 * IntList public interface
 */
sealed abstract class IntList {

  def foreach(f: Int => Unit): Unit

  def map(f: Int => Int): IntList

  def filter(p: Int => Boolean): IntList

  def sum = fold(0, _ + _)

  def product = fold(1, _ * _)

  def fold(z: Int, op: (Int, Int) => Int): Int

  def forall(p: Int => Boolean) = foldBool(true, (x, r) => r && p(x))

  def foldBool(z: Boolean, op: (Int, Boolean) => Boolean): Boolean

}

/**
 * Empty list
 */
class Nil extends IntList {

  override def toString = "nil"

  def foreach(f: Int => Unit) { }

  def map(f: Int => Int) = IntList.nil

  def filter(p: (Int) => Boolean) = IntList.nil

  def fold(z: Int, op: (Int, Int) => Int): Int = z

  def foldBool(z: Boolean, op: (Int, Boolean) => Boolean): Boolean = z
}

/**
 * List with a `head` element and a `tail` list
 * @param head Head element
 * @param tail Tail list
 */
class Cons(head: Int, tail: IntList) extends IntList {

  override def toString = "" + head + " :: " + tail

  def foreach(f: Int => Unit) {
    f(head)
    tail.foreach(f)
  }

  def map(f: Int => Int): IntList = IntList.cons(f(head), tail.map(f))

  def filter(p: (Int) => Boolean) =
    if (p(head)) IntList.cons(head, tail.filter(p))
    else tail.filter(p)

  def fold(z: Int, op: (Int, Int) => Int) = op(head, tail.fold(z, op))

  def foldBool(z: Boolean, op: (Int, Boolean) => Boolean) = op(head, tail.foldBool(z, op))
}

/**
 * Convenient factories
 */
object IntList {

  /** @return an empty list */
  def nil: IntList = new Nil

  /** @return a list with a `head` element and a `tail` list */
  def cons(head: Int, tail: IntList): IntList = new Cons(head, tail)

  /** @example IntList(1, 2, 3) */
  def apply(xs: Int*): IntList = xs.foldRight(nil)(cons)

}