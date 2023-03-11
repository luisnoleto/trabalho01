-- This file allow to write SQL commands that will be emitted in test and dev.
-- The commands are commented as their support depends of the database
-- insert into myentity (id, field) values(nextval('hibernate_sequence'), 'field-1');
-- insert into myentity (id, field) values(nextval('hibernate_sequence'), 'field-2');
-- insert into myentity (id, field) values(nextval('hibernate_sequence'), 'field-3');

insert into sorvete (sabores, precosabor) values('Chocolate', '4.00');
insert into sorvete (sabores, precosabor) values('Baunilia', '3.50');
insert into sorvete (sabores, precosabor) values('Morango', '4.50');
insert into sorvete (sabores, precosabor) values('Limão', '3.50');
insert into sorvete (sabores, precosabor) values('Flocos', '4.50');
insert into sorvete (sabores, precosabor) values('Menta', '5.50');
insert into sorvete (sabores, precosabor) values('Banana', '3.50');
insert into sorvete (sabores, precosabor) values('Cereja', '4.50');
insert into sorvete (sabores, precosabor) values('Beijinho', '4.00');
insert into sorvete (sabores, precosabor) values('Ferreiro Rocher', '7.50');


INSERT into cobertura (id_sorvete, coberturas) values(1, 'Chocolate');
INSERT into cobertura (id_sorvete, coberturas) values(2, 'Creme');
INSERT into cobertura (id_sorvete, coberturas) values(3, 'Morango');
INSERT into cobertura (id_sorvete, coberturas) values(4, 'Limão');
INSERT into cobertura (id_sorvete, coberturas) values(5, 'Chocolate Meio-Amargo');
INSERT into cobertura (id_sorvete, coberturas) values(6, 'Menta');
INSERT into cobertura (id_sorvete, coberturas) values(7, 'Banana');
INSERT into cobertura (id_sorvete, coberturas) values(8, 'Cereja');
INSERT into cobertura (id_sorvete, coberturas) values(9, 'Chocolate Branco');
INSERT into cobertura (id_sorvete, coberturas) values(10, 'Chocolate ao Leite');