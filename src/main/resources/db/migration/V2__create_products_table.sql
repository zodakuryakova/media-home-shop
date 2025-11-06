-- V2__create_products_table.sql
DROP TABLE IF EXISTS products;

CREATE TABLE products (
    id BIGSERIAL PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    brand VARCHAR (25) NOT NULL,
    price DOUBLE PRECISION NOT NULL,
    imageUrl VARCHAR(255),
    category_id BIGINT,
    FOREIGN KEY (category_id) REFERENCES categories(id)
);
