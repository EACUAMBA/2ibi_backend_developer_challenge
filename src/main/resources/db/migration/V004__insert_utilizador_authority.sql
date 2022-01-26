INSERT INTO public.utilizador_authority (id, authority)VALUES (1, 'ROLE_ADMIN');
INSERT INTO public.utilizador_authority (id, authority)VALUES (2, 'ADMIN:WRITE');
INSERT INTO public.utilizador_authority (id, authority)VALUES (3, 'ADMIN:READ');
INSERT INTO public.utilizador_authority (id, authority)VALUES (4, 'ADMIN:DELETE');
INSERT INTO public.utilizador_authority (id, authority)VALUES (5, 'ADMIN:UPDATE');

--
SELECT setval('utilizador_authority_seq', 5);


