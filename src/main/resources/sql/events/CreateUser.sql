begin;
set search_path to events;

create table "CreateUser" (
    id bigserial not null unique,
    email text not null
) inherits ("Event");

commit;
