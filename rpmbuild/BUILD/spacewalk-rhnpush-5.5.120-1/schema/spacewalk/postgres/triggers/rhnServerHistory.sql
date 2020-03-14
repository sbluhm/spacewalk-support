-- oracle equivalent source sha1 cc9b3384c95116ffb2789c83956557993241c4e4


create or replace function rhn_serverhistory_mod_trig_fun() returns trigger as
$$
begin
	new.modified := current_timestamp;
 	return new;
end;
$$ language plpgsql;

create trigger
rhn_serverhistory_mod_trig
before insert or update on rhnServerHistory
for each row
execute procedure rhn_serverhistory_mod_trig_fun();


