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