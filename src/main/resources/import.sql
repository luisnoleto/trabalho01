-- This file allow to write SQL commands that will be emitted in test and dev.
-- The commands are commented as their support depends of the database
-- insert into myentity (id, field) values(nextval('hibernate_sequence'), 'field-1');
-- insert into myentity (id, field) values(nextval('hibernate_sequence'), 'field-2');
-- insert into myentity (id, field) values(nextval('hibernate_sequence'), 'field-3');

insert into sorvete (id, sabores, precosabor) values(nextval('hibernate_sequence'), 'Chocolate', 4.00);
insert into sorvete (id, sabores, precosabor) values(nextval('hibernate_sequence'), 'Baunilia', 3.50);
insert into sorvete (id, sabores, precosabor) values(nextval('hibernate_sequence'), 'Morango', 4.50);