begin;
drop schema states cascade;
drop schema events cascade;
create schema states;
create schema events;
set search_path to events;

create table "Event" (
    eventId bigserial not null primary key,
    eventOccurred timestamp with time zone not null default now()
);

create or replace function events.timeTravel(travelFromId bigint, travelTo timestamp with time zone) returns bigint as $$
declare
    currentEventId bigint;
    currentRowId tid;
begin
    for currentRowId, currentEventId in select ctid, eventId from events."Event" where eventId > $1 and eventOccurred < $2 order by eventId asc loop
        update events."Event" set eventId = eventId where ctid = currentRowId;
    end loop;
    return coalesce(currentEventId, $1);
end
$$ language 'plpgsql';

commit;
