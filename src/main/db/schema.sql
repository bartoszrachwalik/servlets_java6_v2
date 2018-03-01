BEGIN;

CREATE TABLE public.course
(
    id bigserial NOT NULL,
    name character varying(255) COLLATE pg_catalog."default",
    CONSTRAINT course_pkey PRIMARY KEY (id)
)

CREATE TABLE public.password
(
    id bigserial NOT NULL,
    value character varying(255) COLLATE pg_catalog."default",
    user_id bigint NOT NULL,
    CONSTRAINT password_pkey PRIMARY KEY (id),
    CONSTRAINT uk_i9uvktd2nb19eavt7kxmdfk3q UNIQUE (user_id),
    CONSTRAINT fk5g75wosax1s4tgfxggpn5me5i FOREIGN KEY (user_id)
        REFERENCES public."user" (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
)


CREATE TABLE public.review
(
    id bigserial NOT NULL,
    description character varying(255) COLLATE pg_catalog."default",
    rating character varying(255) COLLATE pg_catalog."default",
    course_id bigint,
    CONSTRAINT review_pkey PRIMARY KEY (id),
    CONSTRAINT fkrup2xedv6pbpp5ehadk0w48yv FOREIGN KEY (course_id)
        REFERENCES public.course (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
)

CREATE TABLE public."user"
(
    id bigserial NOT NULL,
    email character varying(255) COLLATE pg_catalog."default",
    firstname character varying(255) COLLATE pg_catalog."default",
    lastname character varying(255) COLLATE pg_catalog."default",
    CONSTRAINT user_pkey PRIMARY KEY (id)
)

CREATE TABLE public.user_course
(
    users_id bigserial NOT NULL,
    courses_id bigint NOT NULL,
    CONSTRAINT fknens01bltprvgc6a5i9ajuvv1 FOREIGN KEY (courses_id)
        REFERENCES public.course (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION,
    CONSTRAINT fkpfu1vysq5cjjmw5iyx09gf3jw FOREIGN KEY (users_id)
        REFERENCES public."user" (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
)

COMMIT;