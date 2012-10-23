package tp

/**
 * IntList public interface
 */
final class IntList(val fold: IntList.Fold) {

  import IntList._

  override def toString = fold("nil")((x, acc) => "" + x + " :: " + acc)

  def foreach(f: Int => Unit) {
    fold(())((x, _) => f(x))
  }

  def map(f: Int => Int) = fold(nil)((x, xs) => cons(f(x), xs))

  def filter(p: Int => Boolean) = fold(nil)((x, xs) => if (p(x)) cons(x, xs) else xs)

  def sum = fold(0)(_ + _)

  def product = fold(1)(_ * _)

  def forall(p: Int => Boolean) = fold(true)((x, r) => r && p(x))

}

/**
 * Convenient factories
 */
object IntList {

  trait Fold {
    def apply[A](z: A)(op: (Int, A) => A): A
  }

  /** @return an empty list */
  def nil: IntList = new IntList(new Fold {
    def apply[A](z: A)(op: (Int, A) => A) = z
  })

  /** @return a list with a `head` element and a `tail` list */
  def cons(head: Int, tail: IntList): IntList = new IntList(new Fold {
    def apply[A](z: A)(op: (Int, A) => A) = op(head, tail.fold(z)(op))
  })

  /** @example IntList(1, 2, 3) */
  def apply(xs: Int*): IntList = xs.foldRight(nil)(cons)

}