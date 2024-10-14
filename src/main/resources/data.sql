INSERT INTO usuario (id, nome, login, senha, email) values (1, 'Anderson', 'Ander_iago', '1234', 'ander@gmail.com');
ALTER SEQUENCE usuario_id_seq RESTART with 2;
INSERT INTO perfil  (id, descricao) values (1, 'Cargo de admnistrador');
ALTER SEQUENCE perfil_id_seq RESTART with 2;
