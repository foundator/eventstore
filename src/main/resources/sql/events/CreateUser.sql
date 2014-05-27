begin;
set search_path to events;

create table "CreateUser" (
    eventId bigint not null default nextval('events."Event_sequence"') references "Event" (id) on update cascade on delete cascade deferrable initially deferred,
    id bigserial not null primary key,
    email text not null
);

create trigger "_prepare" after insert on "CreateUser" for each row execute procedure events."Event_prepare"();

commit;
