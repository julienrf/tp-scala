package tp

/**
 * The code inside this object will be executed when you’ll hit `sbt run`
 */
object Main extends App {

  println(Functions.fibonacci(3))

  val xs = IntList(1, 2, 3)
  println(xs)

  println(xs.map(x => x * x))

}
