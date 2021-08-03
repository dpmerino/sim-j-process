-- Database: processDB

-- DROP DATABASE "process1DB";

CREATE DATABASE "process1DB"
    WITH
    OWNER = postgres
    ENCODING = 'UTF8'
    LC_COLLATE = 'Spanish_Mexico.1252'
    LC_CTYPE = 'Spanish_Mexico.1252'
    TABLESPACE = pg_default
    CONNECTION LIMIT = -1;

COMMENT ON DATABASE "process-service"
    IS 'base de datos para el servicio de process';



insert into public.process(process_id, nombre_proc, desc_proc) values(1,'Ordinario','descripcion 1');
insert into public.process(process_id, nombre_proc, desc_proc) values(2,'Sumario','descripcion 2');
insert into public.process(process_id, nombre_proc, desc_proc) values(3,'Monitorio','descripcion 3');
insert into public.process(process_id, nombre_proc, desc_proc) values(4,'Ejecutivo','descripcion 4');
insert into public.process(process_id, nombre_proc, desc_proc) values(5,'Voluntario','descripcion 5');

insert into public.actions(actions_id, nombre_act, desc_act, n_steps, process_id) values(1,'Extraordinario adquisitiva de dominio','descripcion 1',9, 1);
insert into public.actions(actions_id, nombre_act, desc_act, n_steps, process_id) values(2,'Reforma de testamento','descripcion 2',9, 1);
insert into public.actions(actions_id, nombre_act, desc_act, n_steps, process_id) values(3,'Reivindicación','descripcion 3',9, 1);
insert into public.actions(actions_id, nombre_act, desc_act, n_steps, process_id) values(4,'Nulidad de matrimonio civil','descripcion 4',9, 1);
insert into public.actions(actions_id, nombre_act, desc_act, n_steps, process_id) values(5,'Rescisión de contrato por vicios redhibitorios','descripcion 5',9, 1);
insert into public.actions(actions_id, nombre_act, desc_act, n_steps, process_id) values(6,'Rescisión de contrato por lesión enorme por pago menor al justo precio','descripcion 6',9, 1);
insert into public.actions(actions_id, nombre_act, desc_act, n_steps, process_id) values(7,'Resolucion de contrato de promesa de compraventa','descripcion 7',9, 1);
insert into public.actions(actions_id, nombre_act, desc_act, n_steps, process_id) values(8,'Cobro de dinero','descripcion 8',9, 1);
insert into public.actions(actions_id, nombre_act, desc_act, n_steps, process_id) values(9,'Cancelación de hipoteca','descripcion 9',9, 1);
insert into public.actions(actions_id, nombre_act, desc_act, n_steps, process_id) values(10,'Prescipción ordinaria de Dominio','descripcion 9',9, 1);
insert into public.actions(actions_id, nombre_act, desc_act, n_steps, process_id) values(11,'Presunción de muerte','descripcion 9',9, 1);
insert into public.actions(actions_id, nombre_act, desc_act, n_steps, process_id) values(12,'Daño moral','descripcion 9',9, 1);
insert into public.actions(actions_id, nombre_act, desc_act, n_steps, process_id) values(13,'Daños y Perjuicios','descripcion 9',9, 1);
insert into public.actions(actions_id, nombre_act, desc_act, n_steps, process_id) values(14,'Dominio del bien, en cual mantiene posesión','descripcion 9',9, 1);
insert into public.actions(actions_id, nombre_act, desc_act, n_steps, process_id) values(15,'Declaratorio de la unión de hecho','descripcion 9',9, 1);
insert into public.actions(actions_id, nombre_act, desc_act, n_steps, process_id) values(16,'Terminación de comodato precario','descripcion 9',9, 1);
insert into public.actions(actions_id, nombre_act, desc_act, n_steps, process_id) values(17,'Cumplimiento de los deberes del usufructuario','descripcion 9',9, 1);
insert into public.actions(actions_id, nombre_act, desc_act, n_steps, process_id) values(18,'Petición de Herencia','descripcion 9',9, 1);
insert into public.actions(actions_id, nombre_act, desc_act, n_steps, process_id) values(19,'Nulidad de Usufructo','descripcion 9',9, 1);
insert into public.actions(actions_id, nombre_act, desc_act, n_steps, process_id) values(20,'Imcumplimiento de contrato','descripcion 9',9, 1);

