INSERT INTO public.utilizador (id, account_non_expired, account_non_locked, credentials_non_expired, enabled, password, username)VALUES (1, true, true, true, true, '$2a$10$GFYg0tCsdmNB/djRvw.cS.Ol56sBvDqeF5O4YbjfK.zK3jyKqcXFG', 'eacuamba');
INSERT INTO public.utilizador (id, account_non_expired, account_non_locked, credentials_non_expired, enabled, password, username)VALUES (2, true, true, true, true, '$2a$10$GFYg0tCsdmNB/djRvw.cS.Ol56sBvDqeF5O4YbjfK.zK3jyKqcXFG', 'luis');
INSERT INTO public.utilizador (id, account_non_expired, account_non_locked, credentials_non_expired, enabled, password, username)VALUES (3, true, true, true, true, '$2a$10$GFYg0tCsdmNB/djRvw.cS.Ol56sBvDqeF5O4YbjfK.zK3jyKqcXFG', 'carlos');



SELECT setval('utilizador_seq', 3);
