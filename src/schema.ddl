-- Table: public.commodity

-- DROP TABLE public.commodity;

CREATE TABLE public.commodity
(
    id bigint NOT NULL,
    name character varying(255) COLLATE pg_catalog."default",
    weight double precision,
    value double precision,
    shipment_id bigint,
    CONSTRAINT commodity_pkey PRIMARY KEY (id)
)

TABLESPACE pg_default;

ALTER TABLE public.commodity
    OWNER to postgres;

-- Table: public.customer

-- DROP TABLE public.customer;

CREATE TABLE public.customer
(
    id bigint NOT NULL,
    name character varying(255) COLLATE pg_catalog."default",
    email character varying(255) COLLATE pg_catalog."default",
    shipment_id bigint,
    CONSTRAINT customer_pkey PRIMARY KEY (id)
)

TABLESPACE pg_default;

ALTER TABLE public.customer
    OWNER to postgres;

-- Table: public.shipment

-- DROP TABLE public.shipment;

CREATE TABLE public.shipment
(
    id bigint NOT NULL,
    awbnumber character varying(255) COLLATE pg_catalog."default",
    totalweight double precision,
    totalvalue double precision,
    customer_id bigint,
    committeddate timestamp without time zone,
    updateddate timestamp without time zone,
    CONSTRAINT shipment_pkey PRIMARY KEY (id)
)

TABLESPACE pg_default;

ALTER TABLE public.shipment
    OWNER to postgres;
