create table regiao (id bigint not null constraint regiao_pkey primary key, nome varchar(255));

alter table regiao owner to postgres;

create sequence regiao_seq increment by 50;

alter sequence regiao_seq owner to postgres;

