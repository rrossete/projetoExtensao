

CREATE TABLE listaEspera(

    id SERIAL4 primary key,
    cliente_id INT4 NOT NULL,
    demanda_juridica_id INT4 NOT NULL,
    observacoes VARCHAR(250)
);

ALTER TABLE listaEspera
    ADD FOREIGN KEY (cliente_id) REFERENCES cliente (id) ON DELETE CASCADE ON UPDATE CASCADE;

ALTER TABLE listaEspera
    ADD FOREIGN KEY (demanda_juridica_id) REFERENCES demanda_juridica (id) ON DELETE CASCADE ON UPDATE CASCADE;