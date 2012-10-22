package tp

/**
 * IntList public interface
 */
sealed abstract class IntList {

  import IntList._

  def fold[A](z: A, op: (Int, A) => A): A

  final override def toString = fold[String]("nil", (x, acc) => "" + x + " :: " + acc)

  final def foreach(f: Int => Unit) {
    fold[Unit]((), (x, _) => f(x))
  }

  final def map(f: Int => Int) = fold[IntList](nil, (x, xs) => cons(f(x), xs))

  final def filter(p: Int => Boolean) = fold[IntList](nil, (x, xs) => if (p(x)) cons(x, xs) else xs)

  final def sum = fold[Int](0, _ + _)

  final def product = fold[Int](1, _ * _)

  final def forall(p: Int => Boolean) = fold[Boolean](true, (x, r) => r && p(x))

}

/**
 * Empty list
 */
class Nil extends IntList {
  def fold[A](z: A, op: (Int, A) => A): A = z
}

/**
 * List with a `head` element and a `tail` list
 * @param head Head element
 * @param tail Tail list
 */
class Cons(head: Int, tail: IntList) extends IntList {
  def fold[A](z: A, op: (Int, A) => A) = op(head, tail.fold(z, op))
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