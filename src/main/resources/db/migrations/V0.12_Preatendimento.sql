CREATE TABLE public.pre_atendimento
(
    id SERIAL PRIMARY KEY,
    data_inicial TIMESTAMP,
    data_final TIMESTAMP,
    semestre VARCHAR
    --tirar dataFinal.. incluir na tela Duração do atendimento para gerar a tabela.
);