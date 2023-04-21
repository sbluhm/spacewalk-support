-- oracle equivalent source sha1 ccc582cc073ec275c9fff718fca32a723eb99eed


create or replace function rhn_sproftype_mod_trig_fun() returns trigger as
$$
begin
	new.modified := current_timestamp;
 	return new;
end;
$$ language plpgsql;

create trigger
rhn_sproftype_mod_trig
before insert or update on rhnServerProfileType
for each row
execute procedure rhn_sproftype_mod_trig_fun();


