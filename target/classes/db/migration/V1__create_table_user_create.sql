CREATE TABLE vault.user_create
(
    id serial NOT NULL,
    name character varying,
    email character varying,
    PRIMARY KEY (id)
);

ALTER TABLE IF EXISTS vault.user_create
    OWNER to coresmarttime;