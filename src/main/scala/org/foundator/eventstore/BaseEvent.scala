package org.foundator.eventstore

trait BaseEvent {
    final type BaseVersion = BaseEvent.BaseVersion
    type Version <: BaseVersion
    type Current <: Version
    // def apply(...) : Current
    def migrate(event : Version) : Current
    object As {
        def unapply(event : Version) = Some(migrate(event))
    }
}

object BaseEvent {
    abstract class BaseVersion
}
