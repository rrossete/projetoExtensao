CREATE TABLE parametrosdosistema(
  id SERIAL4 PRIMARY KEY,
  nome VARCHAR(200) NOT NULL,
  numero_minimo_horas INTEGER NOT NULL,
  numero_maximo_alunos INTEGER NOT NULL
);