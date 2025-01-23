INSERT INTO mvt_stock_type (name)
VALUES ('Sortie'),
       ('Entree');

INSERT INTO recipe_step_type (name)
VALUES ('Production'),
       ('Supplement');

INSERT INTO unit (name, symbol)
VALUES ('Kilogramme', 'kg'),
       ('Gramme', 'g'),
       ('Piece', 'p'),
       ('Litre', 'l'),
       ('Cuillere', 'c');

INSERT INTO ingredient (name, id_unit)
VALUES ('Farine', 1),
       ('Sel', 2),
       ('Sucre', 2),
       ('Levure Chimique', 2),
       ('Bicarbonate de soude', 2),
       ('Beurre', 2),
       ('Cacao en poudre', 2),
       ('Oeuf', 3),
       ('Eau', 4),
       ('Lait', 4),
       ('Huile', 4),
       ('Extrait de vanille', 5),
       ('Extrait de coco', 5);

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
VALUES ('Patisserie'),
       ('Viennoiserie');

INSERT INTO product (name, unit_price, id_unit, id_product_category)
VALUES ('Pain raisin', 1500, 3, 2),
       ('Gateau', 750, 3, 1),
       ('Mofo dopaina', 500, 3, 2),
       ('Croissant', 500, 3, 2);

INSERT INTO recipe (name)
VALUES ('Recette mofo tsisy dobera'),
       ('Recette mofo misy dobera mafilotra'),
       ('Recette Gateau au chocolat');

INSERT INTO recipe_step (name, no_step, description, id_recipe, id_recipe_step_type)
VALUES ('Mikobaka', 1, 'Mila mikobaka farine', 1, 1),
       ('Manisy atody', 2, 'Atodim-boalavo', 1, 1),
       ('Mikobaka', 1, 'Mila mikobaka farine', 2, 1),
       ('Manisy atody', 2, 'Atodim-boalavo', 2, 1),
       ('Osorana dobera', 3, 'Dobera mafilotra ampiasaina', 2, 2),
       ('Mélanger les ingrédients secs', 1, 'Afangaro tsara doly aloha.', 3, 1),
       ('Ajouter les ingrédients liquides', 2, 'Topasana tsikelikely', 3, 1),
       ('Cuire le gâteau', 3, 'Miandry kely', 3, 1);

-- Supplement beurre

INSERT INTO recipe_step_ingredient (id_recipe_step, id_ingredient, quantity_used)
VALUES (1, 1, 1),
       (2, 8, 2),
       (3, 1, 1),
       (4, 8, 2),
       (5, 6, 2),
       (6, 1, 1.5),
       (6, 7, 2),
       (6, 3, 2),
       (7, 8, 2),
       (7, 10, 1);

INSERT INTO recipe_product (id_product, id_recipe, quantity_produced)
VALUES (1, 1, 1),
       (3, 2, 1),
       (2, 3, 1);

INSERT INTO production (daty, quantity, id_product)
VALUES ('08/01/2025', 5, 1),
       ('08/01/2025', 2, 2);

INSERT INTO mvt_product_stock (daty, quantity, id_product, id_mvt_stock_type)
VALUES ('02/02/2024', 15, 1, 2),
       ('02/02/2024', 25, 2, 2),
       ('02/02/2024', 12, 3, 2),
       ('02/02/2024', 25, 4, 2);

-- Vien 1
-- Vien 1 + Pat 1

INSERT INTO employee_type (name)
VALUES ('Vendeur'),
       ('Serveur');

INSERT INTO employee (name, first_name, cin, hire_date, salary, id_employee_type)
VALUES ('MANITRAJA', 'Henintsoa Paul', '123456789', '01/01/2024', 500, 1),
       ('Jean', 'DuJardin', '789123456', '01/01/2024', 250, 1);

INSERT INTO sale (daty, total_price, id_employee)
VALUES ('01/02/2025', 1500, 1),
       ('01/03/2025', 1750, 2),
       ('01/10/2025', 1650, 1),
       ('01/11/2025', 1800, 2),
       ('01/20/2025', 2000, 1),
       ('01/21/2025', 1450, 2),
       ('01/27/2025', 1950, 1),
       ('01/28/2025', 1850, 2);

INSERT INTO sale_detail (quantity, price, id_product, id_sale)
VALUES (1, 1500, 1, 1),
       (2, 1000, 3, 2),
       (1, 750, 2, 3),
       (3, 1100, 4, 4),
       (2, 950, 3, 5),
       (1, 1150, 2, 6),
       (2, 1400, 4, 7),
       (3, 1250, 1, 8);
