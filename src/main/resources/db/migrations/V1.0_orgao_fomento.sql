CREATE TABLE orgao_fomento (
  id                 SERIAL4 PRIMARY KEY,
  nome               VARCHAR(10) NOT NULL,
  nome_completo      VARCHAR(100) NOT NULL,
  tipo               VARCHAR(50) NULL
);

INSERT INTO orgao_fomento (nome,nome_completo,tipo) VALUES ('CNPq','Conselho Nacional de Desenvolvimento Científico e Tecnológico',' ');

INSERT INTO orgao_fomento (nome,nome_completo,tipo) VALUES ('UFJF','Universidade Federal de Juiz de Fora',' ');

INSERT INTO orgao_fomento (nome,nome_completo,tipo) VALUES ('CAPES','Coordenação de Aperfeiçoamento de Pessoal de Nível Superior',' ');

INSERT INTO orgao_fomento (nome,nome_completo,tipo) VALUES ('FAPEMIG','Fundação de Amparo à Pesquisa de MG',' ');

