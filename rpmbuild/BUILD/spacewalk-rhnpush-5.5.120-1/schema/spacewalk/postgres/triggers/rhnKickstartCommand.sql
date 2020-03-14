-- oracle equivalent source sha1 0e86d5216475074f18119705796eb784f17a066d

create or replace function rhn_kscommand_mod_trig_fun() returns trigger as
$$
begin
       new.modified := current_timestamp;
        
        return new;
end;
$$ language plpgsql;

create trigger
rhn_kscommand_mod_trig
before insert or update on rhnKickstartCommand
for each row
execute procedure rhn_kscommand_mod_trig_fun();


