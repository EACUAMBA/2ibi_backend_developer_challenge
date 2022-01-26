INSERT INTO public.pais (id, area, capital, nome, regiao_id, sub_regiao_id) VALUES (1, 250000, 'Capital 1', 'Pais 1', 1, 1);

INSERT INTO public.pais (id, area, capital, nome, regiao_id, sub_regiao_id) VALUES (2, 300000, 'Capital 2', 'Pais 2', 2, 2);

INSERT INTO public.pais (id, area, capital, nome, regiao_id, sub_regiao_id) VALUES (3, 400000, 'Capital 3', 'Pais 3', 3, 3);

SELECT setval('pais_seq', 3);