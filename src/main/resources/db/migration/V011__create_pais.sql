create table pais(id bigint not null primary key, area double precision, capital varchar(255), nome varchar(255), regiao_id bigint constraint fkk6d9ttt9jxjbokn48tr3jcjlu references regiao, sub_regiao_id bigint constraint fkb6xoqbjalfaqiv2os102wxdx7 references subregiao );

alter table pais owner to postgres;

create sequence pais_seq increment by 50;

alter sequence pais_seq owner to postgres;

