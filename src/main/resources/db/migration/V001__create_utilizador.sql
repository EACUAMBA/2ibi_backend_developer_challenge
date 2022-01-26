create table if not exists utilizador(id bigint not null constraint utilizador_pkey primary key, account_non_expired boolean, account_non_locked boolean, credentials_non_expired boolean, enabled boolean, password varchar(255), username varchar(255) );

alter table utilizador owner to postgres;

create sequence utilizador_seq increment by 50;

alter sequence utilizador_seq owner to postgres;

