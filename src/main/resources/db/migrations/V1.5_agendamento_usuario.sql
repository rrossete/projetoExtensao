CREATE TABLE agendamento_usuario(

    id SERIAL4 PRIMARY KEY,
    demandaJuridica INT4 NOT NULL,
    disciplinaEmCurso TEXT NOT NULL,
    usuario1 INT4 NOT NULL,
    usuario2 INT4,
    horario_cliente INT4 NOT NULL

);

ALTER TABLE agendamento_usuario
    ADD CONSTRAINT fk_agendamento_usuario1 FOREIGN KEY (usuario1) REFERENCES usuario (id)
    ON UPDATE CASCADE ON DELETE CASCADE;

ALTER TABLE agendamento_usuario
    ADD CONSTRAINT fk_agendamento_demanda FOREIGN KEY (demandaJuridica) REFERENCES demanda_juridica(id)
    ON UPDATE CASCADE ON DELETE CASCADE;

ALTER TABLE agendamento_usuario
    ADD CONSTRAINT fk_agendamento_usuario2 FOREIGN KEY (usuario2) REFERENCES usuario (id)
    ON UPDATE CASCADE ON DELETE CASCADE;

ALTER TABLE agendamento_usuario
    ADD CONSTRAINT fk_agendamento_harario_cliente FOREIGN KEY (horario_cliente) REFERENCES controle_Horarios (id)
    ON UPDATE CASCADE ON DELETE CASCADE;