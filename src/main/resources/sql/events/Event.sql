begin;
set search_path to events;

create table "Event" (
    id bigint not null primary key,
    occurred timestamp with time zone not null,
    eventName text not null
);

create function "Event_prepare"() returns trigger as $$ begin
    insert into events."Event" (id, occurred, eventName) values (new.eventId, now(), tg_table_name);
    return new;
end $$ language 'plpgsql';

create sequence "Event_sequence" owned by "Event".id;

commit;
