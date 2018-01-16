CREATE TABLE projeto (
  id               SERIAL4 PRIMARY KEY,
  nome             VARCHAR(100),
  resumo           VARCHAR(255),
  colaborador_id   INT4,
  dt_inicio        DATE,
  dt_fim           DATE,
  num_bolsas       INT4,
  num_voluntarios  INT4,
  tipo_projeto     VARCHAR(50),
  orgao_fomento_id INT4
);

ALTER TABLE projeto
  ADD FOREIGN KEY (colaborador_id) REFERENCES colaborador (id) ON DELETE CASCADE ON UPDATE CASCADE;

ALTER TABLE projeto
  ADD FOREIGN KEY (orgao_fomento_id) REFERENCES orgao_fomento (id) ON DELETE CASCADE ON UPDATE CASCADE;