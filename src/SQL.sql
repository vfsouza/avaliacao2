CREATE DATABASE avaliacao (
    WITH
    OWNER = postgres
    ENCODING = 'UTF8'
    LC_COLLATE = 'Portuguese_Brazil.1252'
    LC_CTYPE = 'Portuguese_Brazil.1252'
    TABLESPACE = pg_default
    CONNECTION LIMIT = -1;
);

CREATE TABLE IF NOT EXISTS public.mensagem
(
    id integer NOT NULL GENERATED ALWAYS AS IDENTITY ( INCREMENT 1 START 0 MINVALUE 0 MAXVALUE 2147483647 CACHE 1 ),
    mensagem character varying(50) COLLATE pg_catalog."default",
    emocao character varying(15) COLLATE pg_catalog."default",
    CONSTRAINT mensagem_pkey PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS public.produto
(
    id integer NOT NULL,
    nome character varying(50) COLLATE pg_catalog."default",
    descricao character varying(50) COLLATE pg_catalog."default",
    desconto double precision,
    preco double precision,
    data_inicio character varying(20) COLLATE pg_catalog."default",
    CONSTRAINT produto_pkey PRIMARY KEY (id)
);