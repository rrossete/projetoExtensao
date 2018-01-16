CREATE TABLE lista_espera (

  id SERIAL4 PRIMARY KEY,
  nome VARCHAR (200) NOT NULL,
  cliente VARCHAR (200) NOT NULL,
  tel_contato VARCHAR (15) NOT NULL,
  demanda_juridica VARCHAR  (200) NOT NULL,
  observacao VARCHAR (400) NULL

);

CREATE TABLE lista_agendamento (
  id SERIAL4 PRIMARY KEY,
  data DATE NULL,
  horario DATE NULL,
  cliente VARCHAR (100) NOT NULL,
  demanda VARCHAR  (25) NOT NULL,
  disciplina VARCHAR (50) NOT NULL,
  aluno1 VARCHAR (100) NOT NULL ,
  aluno2 VARCHAR (100)

);
