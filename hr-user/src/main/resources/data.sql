INSERT INTO tb_user (name, email, password) VALUES ('Nina Brown', 'nina@gmail.com', '$2a$10$c.k59v02Cre6aIZe624J2uHakh0bfiB34xqUVVFuf2TRszE.Ma5La');
INSERT INTO tb_user (name, email, password) VALUES ('Leia Red', 'leia@gmail.com', '$2a$10$c.k59v02Cre6aIZe624J2uHakh0bfiB34xqUVVFuf2TRszE.Ma5La');
INSERT INTO tb_user (name, email, password) VALUES ('Edson Silva', 'edsonnsousa@hotmail.com', '$2a$10$c.k59v02Cre6aIZe624J2uHakh0bfiB34xqUVVFuf2TRszE.Ma5La');

INSERT INTO tb_role (role_name) VALUES ('ROLE_OPERATOR');
INSERT INTO tb_role (role_name) VALUES ('ROLE_ADMIN');

INSERT INTO tb_user_role (user_id, role_id) VALUES (1, 1);
INSERT INTO tb_user_role (user_id, role_id) VALUES (2, 1);
INSERT INTO tb_user_role (user_id, role_id) VALUES (2, 2);
INSERT INTO tb_user_role (user_id, role_id) VALUES (3, 2);