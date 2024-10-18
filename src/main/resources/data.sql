
INSERT INTO perfil  (id, descricao) values (1, 'Admnistrador');
INSERT INTO perfil  (id, descricao) values (2, 'Vendedor');
ALTER SEQUENCE perfil_id_seq RESTART with 3;

INSERT INTO recurso  (id, nome, chave) values (1, 'Tela usuário', 'usuario');
INSERT INTO recurso  (id, nome, chave) values (2, 'Tela Perfil', 'perfil');

ALTER SEQUENCE recurso_id_seq RESTART with 3;


