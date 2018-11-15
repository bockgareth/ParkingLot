create table if not exists ticket (
    id int auto_increment not null,
    ticket_id int,
    ticket_date date,
    ticket_enter_time time,
    ticket_exit_time time default 0,
    is_ticket_lost tinyint,
    amount_due int,
    primary key (id)
);

insert into ticket (ticket_id, ticket_date, ticket_enter_time, ticket_exit_time, is_ticket_lost, amount_due) values (479433531, '2018-11-12', '09:11:00', '11:20:00', false, 50);
insert into ticket (ticket_id, ticket_date, ticket_enter_time, ticket_exit_time, is_ticket_lost, amount_due) values (807551460, '2018-11-12', '09:25:00', '12:15:00', false, 50);
insert into ticket (ticket_id, ticket_date, ticket_enter_time, ticket_exit_time, is_ticket_lost, amount_due) values (841696139, '2018-11-12', '10:50:00', '11:20:00', true, 100);
insert into ticket (ticket_id, ticket_date, ticket_enter_time, ticket_exit_time, is_ticket_lost, amount_due) values (645045098, '2018-11-12', '10:55:00', '12:17:00', false, 30);
insert into ticket (ticket_id, ticket_date, ticket_enter_time, ticket_exit_time, is_ticket_lost, amount_due) values (701193341, '2018-11-12', '10:56:00', '13:50:00', false, 50);
insert into ticket (ticket_id, ticket_date, ticket_enter_time, ticket_exit_time, is_ticket_lost, amount_due) values (664786249, '2018-11-12', '11:10:00', '12:14:00', false, 30);
insert into ticket (ticket_id, ticket_date, ticket_enter_time, ticket_exit_time, is_ticket_lost, amount_due) values (639822628, '2018-11-12', '12:10:00', '14:31:00', true, 100);

insert into ticket (ticket_id, ticket_date, ticket_enter_time, ticket_exit_time, is_ticket_lost, amount_due) values (557812592, '2018-11-13', '09:10:00', '11:20:00', false, 50);
insert into ticket (ticket_id, ticket_date, ticket_enter_time, ticket_exit_time, is_ticket_lost, amount_due) values (916024061, '2018-11-13', '09:15:00', '12:25:00', true, 100);
insert into ticket (ticket_id, ticket_date, ticket_enter_time, ticket_exit_time, is_ticket_lost, amount_due) values (613997088, '2018-11-13', '09:20:00', '10:50:00', true, 100);
insert into ticket (ticket_id, ticket_date, ticket_enter_time, ticket_exit_time, is_ticket_lost, amount_due) values (935515147, '2018-11-13', '10:17:00', '11:55:00', false, 30);
insert into ticket (ticket_id, ticket_date, ticket_enter_time, ticket_exit_time, is_ticket_lost, amount_due) values (600387178, '2018-11-13', '10:40:00', '12:56:00', false, 50);
insert into ticket (ticket_id, ticket_date, ticket_enter_time, ticket_exit_time, is_ticket_lost, amount_due) values (989684182, '2018-11-13', '11:30:00', '13:15:00', false, 30);
insert into ticket (ticket_id, ticket_date, ticket_enter_time, ticket_exit_time, is_ticket_lost, amount_due) values (816575021, '2018-11-13', '11:45:00', '12:20:00', false, 20);
insert into ticket (ticket_id, ticket_date, ticket_enter_time, ticket_exit_time, is_ticket_lost, amount_due) values (179277774, '2018-11-13', '11:49:00', '12:17:00', true, 100);
insert into ticket (ticket_id, ticket_date, ticket_enter_time, ticket_exit_time, is_ticket_lost, amount_due) values (830639415, '2018-11-13', '12:50:00', '13:28:00', false, 20);
insert into ticket (ticket_id, ticket_date, ticket_enter_time, ticket_exit_time, is_ticket_lost, amount_due) values (473153841, '2018-11-13', '13:14:00', '15:40:00', false, 50);
insert into ticket (ticket_id, ticket_date, ticket_enter_time, ticket_exit_time, is_ticket_lost, amount_due) values (527010490, '2018-11-13', '13:31:00', '15:55:00', true, 100);
insert into ticket (ticket_id, ticket_date, ticket_enter_time, ticket_exit_time, is_ticket_lost, amount_due) values (274990265, '2018-11-13', '13:45:00', '14:47:00', false, 30);
insert into ticket (ticket_id, ticket_date, ticket_enter_time, ticket_exit_time, is_ticket_lost, amount_due) values (476375390, '2018-11-13', '14:55:00', '15:20:00', false, 10);

insert into ticket (ticket_id, ticket_date, ticket_enter_time, ticket_exit_time, is_ticket_lost, amount_due) values (268500605, '2018-11-14', '09:40:00', '11:20:00', false, 30);
insert into ticket (ticket_id, ticket_date, ticket_enter_time, ticket_exit_time, is_ticket_lost, amount_due) values (686140206, '2018-11-14', '09:55:00', '12:20:00', true, 100);
insert into ticket (ticket_id, ticket_date, ticket_enter_time, ticket_exit_time, is_ticket_lost, amount_due) values (631042966, '2018-11-14', '10:47:00', '13:15:00', false, 50);
insert into ticket (ticket_id, ticket_date, ticket_enter_time, ticket_exit_time, is_ticket_lost, amount_due) values (444301324, '2018-11-14', '11:13:00', '14:30:00', false, 50);
insert into ticket (ticket_id, ticket_date, ticket_enter_time, ticket_exit_time, is_ticket_lost, amount_due) values (661277202, '2018-11-14', '11:15:00', '15:20:00', false, 100);