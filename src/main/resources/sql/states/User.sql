begin;
set search_path to states;

create table "User" (
    id bigint not null primary key,
    email text not null unique
);

create function "User_CreateUser"() returns trigger as $$ begin
    insert into states."User" (id, email) values (new.id, new.email);
    return new;
end $$ language 'plpgsql';

create trigger "User_CreateUser" after insert or update of eventId on events."CreateUser"
for each row execute procedure "User_CreateUser"();

commit;
