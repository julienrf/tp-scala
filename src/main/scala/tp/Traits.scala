package tp

import concurrent.{Await, Future}
import concurrent.ExecutionContext.Implicits.global
import concurrent.util.duration._
import java.util.Date

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
  var cached: Option[(Int, Long)] = None
  override def energy(person: String) = cached match {
    case Some((value, timestamp)) if timestamp + 10 < (new Date).getTime => value
    case _ =>
      val value = super.energy(person)
      cached = Some(value, (new Date).getTime)
      value
  }
}

trait RichOPower extends OPower {
  def energyInJoules(person: String): Int = energy(person) * 3600
}