CREATE TABLE controle_Horarios (
  id SERIAL4 NOT NULL PRIMARY KEY,
  fk_cliente SERIAL4 NOT NULL,
  fk_PreAtendimento SERIAL4 NOT NULL

);

ALTER TABLE controle_Horarios
    ADD CONSTRAINT fk_controleH_cliente FOREIGN KEY (fk_cliente) REFERENCES cliente (id)
    ON DELETE NO ACTION ON UPDATE NO ACTION;

ALTER TABLE controle_Horarios
    ADD CONSTRAINT fk_controleH_preAtendimento FOREIGN KEY (fk_PreAtendimento) REFERENCES Pre_Atendimento (id)
    ON DELETE NO ACTION ON UPDATE NO ACTION;


