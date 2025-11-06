-- V1__create_categories_table.sql
DROP TABLE IF EXISTS categories;

CREATE TABLE categories (
    id BIGSERIAL PRIMARY KEY,
    name VARCHAR(25) NOT NULL
);
