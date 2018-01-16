CREATE TABLE usuario (
  id                 SERIAL4 PRIMARY KEY,
  nome               VARCHAR(250) NOT NULL,
  matricula_ufjf     VARCHAR(100),
  endereco_id        INT4         NOT NULL,
  telefone           VARCHAR(50),
  celular            VARCHAR(50),
  email              VARCHAR(250) NOT NULL,
  setor_id           INT4         NOT NULL,
  tipo_colaborador_id INT4         NOT NULL,
  dt_criacao         TIMESTAMP    NOT NULL DEFAULT now(),
  dt_exclusao        TIMESTAMP
);

ALTER TABLE usuario
  ADD FOREIGN KEY (tipo_colaborador_id) REFERENCES tipo_colaborador (id) ON DELETE CASCADE ON UPDATE CASCADE;

ALTER TABLE usuario
  ADD FOREIGN KEY (setor_id) REFERENCES setor (id) ON DELETE CASCADE ON UPDATE CASCADE;

ALTER TABLE usuario
  ADD FOREIGN KEY (endereco_id) REFERENCES endereco (id) ON DELETE CASCADE ON UPDATE CASCADE;

