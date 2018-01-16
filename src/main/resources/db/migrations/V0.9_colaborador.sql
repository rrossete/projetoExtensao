CREATE TABLE colaborador (
  id                  SERIAL4 PRIMARY KEY,
  oab                 VARCHAR(10),
  carga_horaria       SMALLINT NOT NULL,
  usuario_id          INT4     NOT NULL,
  tipo_colaborador_id INT4     NOT NULL,
  setor_id            INT4     NOT NULL
);

ALTER TABLE colaborador
  ADD FOREIGN KEY (usuario_id) REFERENCES usuario (id) ON DELETE CASCADE ON UPDATE CASCADE;

ALTER TABLE colaborador
  ADD FOREIGN KEY (tipo_colaborador_id) REFERENCES tipo_colaborador (id) ON DELETE CASCADE ON UPDATE CASCADE;

ALTER TABLE colaborador
  ADD FOREIGN KEY (setor_id) REFERENCES setor (id) ON DELETE CASCADE ON UPDATE CASCADE;

ALTER TABLE usuario
  DROP COLUMN tipo_colaborador_id;

ALTER TABLE usuario
  DROP COLUMN setor_id;

ALTER TABLE usuario
  ALTER COLUMN telefone SET NOT NULL;

ALTER TABLE usuario
  RENAME COLUMN celular TO telefone_opcional;