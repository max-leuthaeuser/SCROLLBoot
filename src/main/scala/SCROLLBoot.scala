import scroll.internal.Compartment
import scroll.internal.support.DispatchQuery
import DispatchQuery._

object SCROLLBoot extends App {

  case class Copter(name: String)

  class SomeCompartment extends Compartment {

    case class SimpleAPI() {
      def fly(): Unit = {
        val name: String = (+this).name
        println(name + " is flying ...")
      }
    }

    case class EmergencyDetector() {

      def isFalling: Boolean = true // faked

      def fly(): Unit = {
        val name: String = (+this).name
        println(name + " is flying safely ...")
      }
    }

    case class Parachute() {
      def openParachute(): Unit = {
        println("Opening ... ")
      }
    }

  }

  new SomeCompartment {

    val dji = Copter("DJIPhantom") <+> SimpleAPI() <+> EmergencyDetector() <+> Parachute()

    /*
    implicit val dd =
      From(_.isInstanceOf[Copter]).
        To(_.isInstanceOf[EmergencyDetector]).
        Through(anything).
        Bypassing(_.isInstanceOf[SimpleAPI])
    */

    dji.fly()

    val falling: Boolean = dji.isFalling()
    if (falling) {
      dji.openParachute()
    }

  }
}
