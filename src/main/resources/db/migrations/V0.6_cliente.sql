CREATE TABLE cliente (
  id                   SERIAL4 PRIMARY KEY,
  nome                 VARCHAR(200)       NOT NULL,
  endereco_id          INT4               NOT NULL,
  RG                   VARCHAR(20) UNIQUE NOT NULL,
  CPF                  VARCHAR(20) UNIQUE NULL,
  nome_mae             VARCHAR(200)       NULL,
  nome_pai             VARCHAR(200)       NULL,
  dt_nascimento        DATE               NULL,
  nacionalidade        VARCHAR(100)       NULL,
  naturalidade         VARCHAR(200)       NULL,
  profissao            VARCHAR(200)       NULL,
  estado_civil         VARCHAR(20)        NULL,
  telefone_residencial VARCHAR(20)        NULL,
  telefone_celular     VARCHAR(20)        NULL,
  email                VARCHAR(200)       NULL,
  outro_contato        VARCHAR(200)       NULL
);

ALTER TABLE cliente
  ADD FOREIGN KEY (endereco_id) REFERENCES endereco (id) ON DELETE CASCADE ON UPDATE CASCADE;
