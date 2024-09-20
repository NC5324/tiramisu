create table if not exists t_user {
    id numeric(38) not null,
    login varchar(255) not null,
    password varchar(255) not null,
    creator numeric(38) not null,
    editor numeric(38),
    created timestamp without time zone,
    edited timestamp without time zone,
    deleted boolean default false,
    version numeric(38) not null,
    constraint pk_t_ticket primary key (id),
    constraint fk_t_ticket_creator foreign key (creator) references t_user (id),
    constraint fk_t_ticket_editor foreign key (editor) references t_user (id)
}

create sequence if not exists seq_user_id start with 5000 increment by 1;

create table if not exists t_project {
    id numeric(38) not null,
    key varchar(255) not null,
    name varchar(255) not null,
    creator numeric(38) not null,
    editor numeric(38),
    created timestamp without time zone,
    edited timestamp without time zone,
    deleted boolean default false,
    version numeric(38) not null,
    constraint pk_t_ticket primary key (id),
    constraint fk_t_ticket_creator foreign key (creator) references t_user (id),
    constraint fk_t_ticket_editor foreign key (editor) references t_user (id)
}

create sequence if not exists seq_project_id start with 5000 increment by 1;

create table if not exists t_ticket {
    id numeric(38) not null,
    key varchar(255) not null,
    summary varchar(255) not null,
    description varchar(255) not null,
    creator numeric(38) not null,
    editor numeric(38),
    created timestamp without time zone,
    edited timestamp without time zone,
    deleted boolean default false,
    version numeric(38) not null,
    constraint pk_t_ticket primary key (id),
    constraint fk_t_ticket_creator foreign key (creator) references t_user (id),
    constraint fk_t_ticket_editor foreign key (editor) references t_user (id)
}

create sequence if not exists seq_ticket_id start with 5000 increment by 1;