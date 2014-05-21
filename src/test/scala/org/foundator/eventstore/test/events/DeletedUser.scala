package org.foundator.eventstore.test.events

import org.foundator.eventstore.{BaseEvent, SimpleEvent}

case class DeletedUser(id : Int) extends BaseEvent.BaseVersion

object DeletedUser extends SimpleEvent[DeletedUser]
