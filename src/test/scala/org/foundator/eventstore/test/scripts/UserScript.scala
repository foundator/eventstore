package org.foundator.eventstore.test.scripts

import org.foundator.eventstore.test.events.{DeletedUser, CreatedUser}

object UserScript {

    def main(arguments : Array[String]) {

        val user1 = CreatedUser.V1(1, "hans@example.com")
        val user = CreatedUser(1, "Hans", "hans@example.com")
        val deletion = DeletedUser(1)

        user1 match {
            case CreatedUser.As(e) => println(e.name)
        }

        user match {
            case CreatedUser.As(e) => println(e.name)
        }

        deletion match {
            case DeletedUser.As(e) => println(e.id)
        }
    }

}
