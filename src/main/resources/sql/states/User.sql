begin;
set search_path to states;

create table "User" (
    id bigint not null unique,
    email text not null unique
);

create function "User_CreateUser"() returns trigger as $$ begin
    insert into states."User" select id, email from events."CreateUser" where eventId = new.id;
    return new;
end $$ language 'plpgsql';

create trigger "User_CreateUser" after insert or update of id on events."Event"
for each row when (new.eventName = 'CreateUser')
execute procedure "User_CreateUser"();

commit;
