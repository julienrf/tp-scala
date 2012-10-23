package tp

import concurrent.{Await, Future}
import concurrent.ExecutionContext.Implicits.global
import concurrent.duration._

class OPower {
  def energy(person: String): Int = {
    val future = Future {
      Thread.sleep(1000)
      (math.random * 5000).toInt
    }
    Await.result(future, 2.seconds)
  }
}

trait Cache extends OPower {
  override def energy(person: String) = ???
}

trait RichOPower extends OPower {
  def energyInJoules(person: String): Int = ???
}