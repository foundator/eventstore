package org.foundator.eventstore.views

import org.foundator.eventstore.BaseEvent

abstract class View {

    def initialize(tables : Tables)

    def update(tables : Tables, event : BaseEvent)

    def view(tables : Tables)

    abstract class Row {}

    case class Table[R <: Row]()

    case class Reference[T <: Table[_]](id : Long)

}

class Tables {}
