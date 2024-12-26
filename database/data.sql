INSERT INTO mvt_stock_type (name)
VALUES ('Sortie'),
       ('Entree');

INSERT INTO unit (name, symbol)
VALUES ('Kilogramme', 'kg'),
       ('Gramme', 'g'),
       ('Unite', 'u');

INSERT INTO ingredient (name, id_unit)
VALUES ('Farine', 1),
       ('Levure', 2),
       ('Oeuf', 3);

INSERT INTO provider (name)
VALUES ('Farine_ko'),
       ('Atody_ko');

INSERT INTO ingredient_provider (unit_price, id_ingredient, id_provider)
VALUES (1500, 1, 1),
       (500, 2, 1),
       (750, 3, 2);

INSERT INTO product_category (name)
VALUES ('Viennoiserie'),
       ('Patisserie');

INSERT INTO product (name, unit_price, id_unit, id_product_category)
VALUES ('Pain raisin', 1500, 3, 1),
       ('Gateau au chocolat', 750, 3, 2);

INSERT INTO employee_type (name)
VALUES ('Cuisinier'),
       ('Serveur');

INSERT INTO employee (name, first_name, cin, hire_date, salary, id_employee_type)
VALUES ('MANITRAJA', 'Henin Paul', '123456789', '01/01/2024', 500, 1),
       ('Jean', 'DuJardin', '789123456', '01/01/2024', 250, 2);
