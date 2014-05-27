package org.foundator.eventstore.test.views

import org.foundator.eventstore.views.View._

object UserView {

    case class UserRow() extends Row
    object UserTable extends Table[UserRow]

}
