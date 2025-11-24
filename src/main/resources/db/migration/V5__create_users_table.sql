-- V1__create_categories_table.sql
DROP TABLE IF EXISTS users;

CREATE TABLE users
(
    id       BIGSERIAL PRIMARY KEY,
    username VARCHAR(25)  NOT NULL,
    email    VARCHAR(25)  NOT NULL,
    password VARCHAR(256) NOT NULL,
    role     VARCHAR(25)  NOT NULL
);
