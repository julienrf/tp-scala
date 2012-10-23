package tp

import annotation.tailrec

object Functions {

  def fibonacci(n: Int): Int =
    if (n <= 1) n
    else fibonacci(n - 1) + fibonacci(n - 2)

  def fibonacciRec(n: Int): Int = {
    @tailrec
    def fibLoop(n: Int, acc: (Int, Int)): Int = {
      if (n == 0) acc._1
      else fibLoop(n - 1, (acc._2, acc._1 + acc._2))
    }
    fibLoop(n, (0, 1))
  }

  def show(f: Int => Int, xs: Int*) {
    for (x <- xs) {
      println(f(x))
    }
  }

}
