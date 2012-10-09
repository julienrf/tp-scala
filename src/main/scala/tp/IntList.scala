package tp

sealed abstract class IntList {

  // override def toString: String

  // def foreach(f: Int => Unit): Unit

  // def map(f: Int => Int): IntList

  // def filter(p: Int => Boolean): IntList

  // def fold(z: Int, op: (Int, Int) => Int): Int

  // def sum: Int

  // def product: Int

  // def forall(p: Int => Boolean): Boolean

  // def foldBool(z: Boolean, op: (Int, Boolean) => Boolean): Boolean

}

object IntList {

  def nil = new IntList {
    // TODO Write some code here
  }

  def cons(head: Int, tail: IntList) = new IntList {
    // TODO Write some code here
  }

  // Already implemented. Use it as follows: `IntList(1, 2, 3)`
  def apply(xs: Int*): IntList = xs.foldRight(nil)(cons)

}