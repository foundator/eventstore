package org.foundator.eventstore

import org.foundator.eventstore.BaseEvent.BaseVersion

abstract class SimpleEvent[T <: BaseVersion] extends BaseEvent {

    override final type Version = T
    override final type Current = T

    override def migrate(event : Version) = event
}
