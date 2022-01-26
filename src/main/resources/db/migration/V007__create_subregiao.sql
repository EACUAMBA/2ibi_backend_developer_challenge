create table subregiao(id bigint not null constraint subregiao_pkey primary key, nome varchar(255));

alter table subregiao owner to postgres;

create sequence subregiao_seq increment by 50;

alter sequence subregiao_seq owner to postgres;



