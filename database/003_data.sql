INSERT INTO mvt_stock_type (name)
VALUES ('Sortie'),
       ('Entree');

INSERT INTO unit (name, symbol)
VALUES ('Kilogramme', 'kg'),
       ('Gramme', 'g'),
       ('Piece', 'p');

INSERT INTO ingredient (name, id_unit)
VALUES ('Farine', 1),
       ('Levure', 2),
       ('Beurre', 2),
       ('Oeuf', 3);

INSERT INTO mvt_ingredient_stock (daty, quantity, id_ingredient, id_mvt_stock_type)
VALUES ('02/02/2024', 5, 1, 2),
       ('02/02/2024', 15, 1, 2),
       ('02/02/2024', 5, 2, 2),
       ('02/02/2024', 7, 2, 2),
       ('02/02/2024', 11, 3, 2),
       ('02/02/2024', 25, 3, 2);

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
VALUES ('Pain raisin', 1500, 3, 2),
       ('Gateau au chocolat', 750, 3, 1),
       ('Mofo dopaina', 500, 3, 2);

INSERT INTO recipe (name)
VALUES ('Recette mofo tsisy dobera'),
       ('Recette mofo misy dobera mafilotra');

INSERT INTO recipe_step (name, no_step, description, quantity_used, id_ingredient, id_recipe)
VALUES ('Mikobaka', 1, 'Mila bokona be', 2, 1, 1),
       ('Manisy atody', 2, 'Tsy de hoe bokona loatra', 5, 4, 1),
       ('Mikobaka', 1, 'Mila bokona be', 3, 1, 2),
       ('Manisy atody', 2, 'Tsy de hoe bokona loatra', 5, 4, 2),
       ('Osorana dobera', 3, 'Dobera mafilotra ampiasaina', 1, 3, 2);

INSERT INTO recipe_product (id_product, id_recipe, quantity_produced)
VALUES (1, 1, 1),
       (3, 2, 1);

INSERT INTO production (daty, quantity, id_product)
VALUES ('08/01/2025', 5, 1),
       ('08/01/2025', 2, 2);

INSERT INTO mvt_product_stock (daty, quantity, id_product, id_mvt_stock_type)
VALUES ('02/02/2024', 5, 1, 2),
       ('02/02/2024', 15, 1, 2),
       ('02/02/2024', 5, 2, 2),
       ('02/02/2024', 25, 2, 2);

INSERT INTO employee_type (name)
VALUES ('Cuisinier'),
       ('Serveur');

INSERT INTO employee (name, first_name, cin, hire_date, salary, id_employee_type)
VALUES ('MANITRAJA', 'Henin Paul', '123456789', '01/01/2024', 500, 1),
       ('Jean', 'DuJardin', '789123456', '01/01/2024', 250, 2);
