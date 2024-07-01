create table if not exists custom_messages (
    id bigint not null,
    content varchar(255),
    title varchar(255) not null,
    type varchar(255) not null check (type in ('PRIMARY','SECONDARY')),
    primary key (id)
);

create sequence if not exists custom_messages_id_seq start with 1 increment by 50