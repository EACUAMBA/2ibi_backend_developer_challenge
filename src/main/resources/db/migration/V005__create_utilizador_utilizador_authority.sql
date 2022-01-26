create table utilizador_utilizador_authority(utilizador_id bigint not null constraint fkdinpjde4inlu444wtqbnmr5ll references utilizador, utilizador_authority_id bigint not null constraint fk328lykpxw7u5r60x9m16lpibc references utilizador_authority, constraint utilizador_authorities_pkey primary key (utilizador_id, utilizador_authority_id));

alter table utilizador_utilizador_authority owner to postgres;





