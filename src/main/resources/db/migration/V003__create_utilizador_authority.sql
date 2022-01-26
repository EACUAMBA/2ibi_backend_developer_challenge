create table utilizador_authority(id bigint not null constraint utilizador_authority_pkey primary key, authority varchar(255));

alter table utilizador_authority owner to postgres;

create sequence utilizador_authority_seq increment by 50;

alter sequence utilizador_authority_seq owner to postgres;



