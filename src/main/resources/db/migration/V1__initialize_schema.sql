create table if not exists ticket (
    id int not null,
    ticket_date date,
    ticket_enter_time time,
    ticket_exit_time time,
    is_ticket_lost boolean,
    amount_due int,
);

create sequence id increment by 1 start with 1;

insert into ticket (id, ticket_date, ticket_enter_time, ticket_exit_time, is_ticket_lost, amount_due) values (next value for id, '2018-11-12', '09:11:00', '11:20:00', false, 50);
insert into ticket (id, ticket_date, ticket_enter_time, ticket_exit_time, is_ticket_lost, amount_due) values (next value for id, '2018-11-12', '09:25:00', '12:15:00', false, 50);
insert into ticket (id, ticket_date, ticket_enter_time, ticket_exit_time, is_ticket_lost, amount_due) values (next value for id, '2018-11-12', '10:50:00', '11:20:00', true, 100);
insert into ticket (id, ticket_date, ticket_enter_time, ticket_exit_time, is_ticket_lost, amount_due) values (next value for id, '2018-11-12', '10:55:00', '12:17:00', false, 30);
insert into ticket (id, ticket_date, ticket_enter_time, ticket_exit_time, is_ticket_lost, amount_due) values (next value for id, '2018-11-12', '10:56:00', '13:50:00', false, 50);
insert into ticket (id, ticket_date, ticket_enter_time, ticket_exit_time, is_ticket_lost, amount_due) values (next value for id, '2018-11-12', '11:10:00', '12:14:00', false, 30);
insert into ticket (id, ticket_date, ticket_enter_time, ticket_exit_time, is_ticket_lost, amount_due) values (next value for id, '2018-11-12', '12:10:00', '14:31:00', true, 100);

insert into ticket (id, ticket_date, ticket_enter_time, ticket_exit_time, is_ticket_lost, amount_due) values (next value for id, '2018-11-13', '09:10:00', '11:20:00', false, 50);
insert into ticket (id, ticket_date, ticket_enter_time, ticket_exit_time, is_ticket_lost, amount_due) values (next value for id, '2018-11-13', '09:15:00', '12:25:00', true, 100);
insert into ticket (id, ticket_date, ticket_enter_time, ticket_exit_time, is_ticket_lost, amount_due) values (next value for id, '2018-11-13', '09:20:00', '10:50:00', true, 100);
insert into ticket (id, ticket_date, ticket_enter_time, ticket_exit_time, is_ticket_lost, amount_due) values (next value for id, '2018-11-13', '10:17:00', '11:55:00', false, 30);
insert into ticket (id, ticket_date, ticket_enter_time, ticket_exit_time, is_ticket_lost, amount_due) values (next value for id, '2018-11-13', '10:40:00', '12:56:00', false, 50);
insert into ticket (id, ticket_date, ticket_enter_time, ticket_exit_time, is_ticket_lost, amount_due) values (next value for id, '2018-11-13', '11:30:00', '13:15:00', false, 30);
insert into ticket (id, ticket_date, ticket_enter_time, ticket_exit_time, is_ticket_lost, amount_due) values (next value for id, '2018-11-13', '11:45:00', '12:20:00', false, 20);
insert into ticket (id, ticket_date, ticket_enter_time, ticket_exit_time, is_ticket_lost, amount_due) values (next value for id, '2018-11-13', '11:49:00', '12:17:00', true, 100);
insert into ticket (id, ticket_date, ticket_enter_time, ticket_exit_time, is_ticket_lost, amount_due) values (next value for id, '2018-11-13', '12:50:00', '13:28:00', false, 20);
insert into ticket (id, ticket_date, ticket_enter_time, ticket_exit_time, is_ticket_lost, amount_due) values (next value for id, '2018-11-13', '13:14:00', '15:40:00', false, 50);
insert into ticket (id, ticket_date, ticket_enter_time, ticket_exit_time, is_ticket_lost, amount_due) values (next value for id, '2018-11-13', '13:31:00', '15:55:00', true, 100);
insert into ticket (id, ticket_date, ticket_enter_time, ticket_exit_time, is_ticket_lost, amount_due) values (next value for id, '2018-11-13', '13:45:00', '14:47:00', false, 30);
insert into ticket (id, ticket_date, ticket_enter_time, ticket_exit_time, is_ticket_lost, amount_due) values (next value for id, '2018-11-13', '14:55:00', '15:20:00', false, 10);

insert into ticket (id, ticket_date, ticket_enter_time, ticket_exit_time, is_ticket_lost, amount_due) values (next value for id, '2018-11-14', '09:40:00', '11:20:00', false, 30);
insert into ticket (id, ticket_date, ticket_enter_time, ticket_exit_time, is_ticket_lost, amount_due) values (next value for id, '2018-11-14', '09:55:00', '12:20:00', true, 100);
insert into ticket (id, ticket_date, ticket_enter_time, ticket_exit_time, is_ticket_lost, amount_due) values (next value for id, '2018-11-14', '10:47:00', '13:15:00', false, 50);
insert into ticket (id, ticket_date, ticket_enter_time, ticket_exit_time, is_ticket_lost, amount_due) values (next value for id, '2018-11-14', '11:13:00', '14:30:00', false, 50);
insert into ticket (id, ticket_date, ticket_enter_time, ticket_exit_time, is_ticket_lost, amount_due) values (next value for id, '2018-11-14', '11:15:00', '15:20:00', false, 100);
