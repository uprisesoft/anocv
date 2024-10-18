create table document (id bigint generated by default as identity, user_id bigint, name varchar(255) not null, original varchar(255), processed varchar(255), primary key (id));
create table users (id bigint generated by default as identity, email varchar(255), name varchar(255), primary key (id));
alter table if exists document add constraint FKm19xjdnh3l6aueyrpm1705t52 foreign key (user_id) references users;