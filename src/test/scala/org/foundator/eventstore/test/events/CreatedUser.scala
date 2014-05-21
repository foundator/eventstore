package org.foundator.eventstore.test.events

import org.foundator.eventstore.BaseEvent

object CreatedUser extends BaseEvent {
    sealed abstract class Version extends BaseEvent.BaseVersion
    case class V1(id : Int, email : String) extends Version
    case class V2(id : Int, name : String, email : String) extends Version
    case class V3(id : Long, name : String, email : String) extends Version
    override type Current = V3

    def apply(id : Long, name : String, email : String) : Current = V3(id, name, email)
    override def migrate(event : Version) : Current = event match {
        case e : V1 => migrate(V2(e.id, null, e.email))
        case e : V2 => migrate(V3(e.id, e.name, e.email))
        case e : V3 => e
    }
}
