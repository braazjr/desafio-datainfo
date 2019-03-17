CREATE TABLE funcao_usuario_externo(
    co_funcao serial NOT NULL,
    no_funcao varchar(50) NOT NULL
);

ALTER TABLE funcao_usuario_externo ADD CONSTRAINT pk_eprtb016 PRIMARY KEY (co_funcao);

CREATE TABLE usuario_externo(
    nu_cpf varchar(11) NOT NULL,
    no_usuario varchar(60) NOT NULL,
    de_email varchar(255) NOT NULL,
    ic_situacao varchar(1) NOT NULL,
    ic_perfil_acesso smallint NOT NULL,
    co_funcao smallint NOT NULL,
    nu_telefone varchar(11)
);

ALTER TABLE usuario_externo ADD CONSTRAINT pk_eprtb008 PRIMARY KEY (nu_cpf);

ALTER TABLE usuario_externo ADD CONSTRAINT FK_eprtb008_eprtb016 FOREIGN KEY (co_funcao) REFERENCES funcao_usuario_externo (co_funcao) ON DELETE No Action ON UPDATE No Action;

INSERT INTO funcao_usuario_externo(co_funcao, no_funcao) VALUES (1, 'Gestor');
INSERT INTO funcao_usuario_externo(co_funcao, no_funcao) VALUES (2, 'Administrador');
INSERT INTO funcao_usuario_externo(co_funcao, no_funcao) VALUES (3, 'Frente de Caixa');