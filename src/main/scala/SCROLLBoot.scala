import annotations.Role
import scroll.internal.Compartment

object SCROLLBoot extends App {

  /**
   * Just a simple natural type.
   * Can not do anything but printing some statement on stdout.
   */
  class SomePlayer {
    def hello(): Unit = {
      println("Hello World from some player!")
    }
  }

  /**
   * A new compartment. Only containing one role for demo purposes.
   */
  class SomeCompartment extends Compartment {

    /**
     * A role that will be bound to [[SomePlayer]] later on
     * and will alter its behaviour.
     */
    @Role class SomeRole {
      def hello(): Unit = {
        println("Hello World from some role!")
      }
    }

  }

  val player = new SomePlayer()

  /**
   * This will use the standard behaviour defined in the natural type.
   */
  player.hello()

  /**
   * Creating an anonymous instance of the [[Compartment]] defined above.
   */
  new SomeCompartment {
    /**
     * Creating a play-relation now and calling the compound-objects behaviour
     * which is actually defined in its role [[SomeRole]].
     */
    player play new SomeRole() hello()
  }
}