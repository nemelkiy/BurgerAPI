DROP TABLE IF EXISTS product CASCADE;
DROP SEQUENCE IF EXISTS global_seq;

CREATE SEQUENCE global_seq START WITH 1;

CREATE TABLE product
(
    id       INTEGER PRIMARY KEY DEFAULT nextval('global_seq'),
    name     VARCHAR NOT NULL,
    weight   INTEGER NOT NULL,
    price    INTEGER NOT NULL,
    category VARCHAR NOT NULL
);

INSERT INTO public.product (name, weight, price, category)
VALUES ('Нью-йорк', 250, 350, 'Бургеры');
INSERT INTO public.product (name, weight, price, category)
VALUES ('Блэк Джек', 350, 450, 'Бургеры');
INSERT INTO public.product (name, weight, price, category)
VALUES ('Маргарита', 550, 600, 'Пицца');
INSERT INTO public.product (name, weight, price, category)
VALUES ('Техасская', 570, 620, 'Пицца');
INSERT INTO public.product (name, weight, price, category)
VALUES ('Круассан с шоколадным кремом', 150, 200, 'Десерты');
INSERT INTO public.product (name, weight, price, category)
VALUES ('Молочный коктейль ваниль', 500, 350, 'Напитки');