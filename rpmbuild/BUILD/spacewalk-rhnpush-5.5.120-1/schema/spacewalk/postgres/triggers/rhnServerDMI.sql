-- oracle equivalent source sha1 57586bc1fb2c9371e26894ddde64942381670feb

create or replace function rhn_server_dmi_mod_trig_fun() returns trigger as
$$
begin
	new.modified := current_timestamp;
 	return new;
end;
$$ language plpgsql;

create trigger
rhn_server_dmi_mod_trig
before insert or update on rhnServerDMI
for each row
execute procedure rhn_server_dmi_mod_trig_fun();

