-- oracle equivalent source sha1 fa27f750556add2a2ca99cf203e1f972017e2c26

create or replace function rhn_avshutdown_mod_trig_fun() returns trigger as
$$
begin
        new.modified := current_timestamp;
	return new;
end;
$$ language plpgsql;

create trigger
rhn_avshutdown_mod_trig
before insert or update on rhnActionVirtShutdown
for each row
execute procedure rhn_avshutdown_mod_trig_fun();

