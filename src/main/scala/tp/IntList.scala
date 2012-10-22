package tp

/**
 * IntList public interface
 */
sealed abstract class IntList {

  def foreach(f: Int => Unit): Unit

  def map(f: Int => Int): IntList

  def filter(p: Int => Boolean): IntList

  def sum: Int

  def product: Int

  def fold(z: Int, op: (Int, Int) => Int): Int

  def forall(p: Int => Boolean): Boolean

  def foldBool(z: Boolean, op: (Int, Boolean) => Boolean): Boolean

}

/**
 * Empty list
 */
class Nil extends IntList {

  override def toString = ???

  def foreach(f: Int => Unit) {
    ???
  }

  def map(f: Int => Int): IntList = ???

  def filter(p: (Int) => Boolean) = ???

  def sum = ???

  def product = ???

  def fold(z: Int, op: (Int, Int) => Int): Int = ???

  def forall(p: Int => Boolean): Boolean = ???

  def foldBool(z: Boolean, op: (Int, Boolean) => Boolean): Boolean = ???
}

/**
 * List with a `head` element and a `tail` list
 * @param head Head element
 * @param tail Tail list
 */
class Cons(head: Int, tail: IntList) extends IntList {

  override def toString = ???

  def foreach(f: Int => Unit) {
    ???
  }

  def map(f: Int => Int): IntList = ???

  def filter(p: (Int) => Boolean) = ???

  def sum = ???

  def product = ???

  def fold(z: Int, op: (Int, Int) => Int) = ???

  def forall(p: (Int) => Boolean) = ???

  def foldBool(z: Boolean, op: (Int, Boolean) => Boolean) = ???
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