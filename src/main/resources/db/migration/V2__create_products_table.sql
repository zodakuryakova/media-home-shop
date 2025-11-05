-- V2__create_products_table.sql
DROP TABLE IF EXISTS products;

CREATE TABLE products (
    id BIGSERIAL PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    price INT NOT NULL,
    category_id BIGINT,
    FOREIGN KEY (category_id) REFERENCES categories(id)
);
