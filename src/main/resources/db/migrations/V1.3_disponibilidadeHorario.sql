CREATE TABLE disponibilidade_horario(
	id_disponibilidade SERIAL4 NOT NULL,
	fk_usuario SERIAL4 NOT NULL,
	dia_semana VARCHAR(7) NOT NULL,
	horario_inicio TIME WITHOUT TIME ZONE NOT NULL,
	horario_fim TIME WITHOUT TIME ZONE NOT NULL,
	cargahoraria TIME WITHOUT TIME ZONE NOT NULL,
	PRIMARY KEY(id_disponibilidade),
	FOREIGN KEY (fk_usuario) REFERENCES usuario(id) ON DELETE NO ACTION ON UPDATE NO ACTION
)