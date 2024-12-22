CREATE TABLE sale(
   id_sale SERIAL,
   daty TIMESTAMP NOT NULL,
   total_price NUMERIC(15,2)   NOT NULL,
   PRIMARY KEY(id_sale)
);

CREATE TABLE provider(
   id_provider SERIAL,
   name VARCHAR(50)  NOT NULL,
   PRIMARY KEY(id_provider)
);

CREATE TABLE ingredient(
   id_ingredient SERIAL,
   name VARCHAR(50)  NOT NULL,
   PRIMARY KEY(id_ingredient)
);

CREATE TABLE product_type(
   id_product_type SERIAL,
   name VARCHAR(50)  NOT NULL,
   PRIMARY KEY(id_product_type)
);

CREATE TABLE ingredient_provider(
   id_ingredient_provider SERIAL,
   unit_price NUMERIC(15,2)   NOT NULL,
   id_ingredient INTEGER NOT NULL,
   id_provider INTEGER NOT NULL,
   PRIMARY KEY(id_ingredient_provider),
   FOREIGN KEY(id_ingredient) REFERENCES ingredient(id_ingredient),
   FOREIGN KEY(id_provider) REFERENCES provider(id_provider)
);

CREATE TABLE stock(
   id_stock SERIAL,
   quantity NUMERIC(15,2)   NOT NULL,
   id_ingredient INTEGER NOT NULL,
   PRIMARY KEY(id_stock),
   FOREIGN KEY(id_ingredient) REFERENCES ingredient(id_ingredient)
);

CREATE TABLE mvt_stock_type(
   id_mvt_stock_type SERIAL,
   name VARCHAR(50)  NOT NULL,
   PRIMARY KEY(id_mvt_stock_type)
);

CREATE TABLE baking(
   id_baking SERIAL,
   daty DATE NOT NULL,
   PRIMARY KEY(id_baking)
);

CREATE TABLE recipe(
   id_recipe SERIAL,
   name VARCHAR(50) ,
   description TEXT,
   PRIMARY KEY(id_recipe)
);

CREATE TABLE employee_type(
   id_employee_type SERIAL,
   name VARCHAR(50)  NOT NULL,
   PRIMARY KEY(id_employee_type)
);

CREATE TABLE product(
   id_product SERIAL,
   name VARCHAR(50) ,
   description TEXT,
   unit_price NUMERIC(15,2)   NOT NULL,
   id_baking INTEGER NOT NULL,
   id_product_type INTEGER NOT NULL,
   PRIMARY KEY(id_product),
   FOREIGN KEY(id_baking) REFERENCES baking(id_baking),
   FOREIGN KEY(id_product_type) REFERENCES product_type(id_product_type)
);

CREATE TABLE sale_detail(
   id_sale_detail SERIAL,
   quantity NUMERIC(15,2)  ,
   price NUMERIC(15,2)  ,
   id_product INTEGER NOT NULL,
   id_sale INTEGER NOT NULL,
   PRIMARY KEY(id_sale_detail),
   FOREIGN KEY(id_product) REFERENCES product(id_product),
   FOREIGN KEY(id_sale) REFERENCES sale(id_sale)
);

CREATE TABLE supply(
   id_supply SERIAL,
   daty VARCHAR(50) ,
   total_price NUMERIC(15,2)   NOT NULL,
   id_provider INTEGER NOT NULL,
   PRIMARY KEY(id_supply),
   FOREIGN KEY(id_provider) REFERENCES provider(id_provider)
);

CREATE TABLE supply_detail(
   id_supply_detail SERIAL,
   quantity NUMERIC(15,2)  ,
   price NUMERIC(15,2)  ,
   id_ingredient_provider INTEGER NOT NULL,
   id_supply INTEGER NOT NULL,
   PRIMARY KEY(id_supply_detail),
   FOREIGN KEY(id_ingredient_provider) REFERENCES ingredient_provider(id_ingredient_provider),
   FOREIGN KEY(id_supply) REFERENCES supply(id_supply)
);

CREATE TABLE mvt_stock(
   id_mvt_stock SERIAL,
   daty DATE NOT NULL,
   quantity NUMERIC(15,2)   NOT NULL,
   id_ingredient INTEGER NOT NULL,
   id_stock INTEGER NOT NULL,
   id_mvt_stock_type INTEGER NOT NULL,
   PRIMARY KEY(id_mvt_stock),
   FOREIGN KEY(id_ingredient) REFERENCES ingredient(id_ingredient),
   FOREIGN KEY(id_stock) REFERENCES stock(id_stock),
   FOREIGN KEY(id_mvt_stock_type) REFERENCES mvt_stock_type(id_mvt_stock_type)
);

CREATE TABLE employee(
   id_employee SERIAL,
   name VARCHAR(50)  NOT NULL,
   first_name VARCHAR(50) ,
   cin VARCHAR(50)  NOT NULL,
   hire_date DATE NOT NULL,
   salary NUMERIC(15,2)   NOT NULL,
   id_employee_type INTEGER NOT NULL,
   PRIMARY KEY(id_employee),
   FOREIGN KEY(id_employee_type) REFERENCES employee_type(id_employee_type)
);

CREATE TABLE rating(
   id_rating SERIAL,
   nb_star INTEGER NOT NULL,
   author VARCHAR(50)  NOT NULL default 'anonymous',
   daty DATE NOT NULL,
   comment TEXT,
   id_product INTEGER NOT NULL,
   PRIMARY KEY(id_rating),
   FOREIGN KEY(id_product) REFERENCES product(id_product)
);

CREATE TABLE baked_ingredient(
   id_ingredient INTEGER,
   id_baking INTEGER,
   quantity NUMERIC(15,2)   NOT NULL,
   PRIMARY KEY(id_ingredient, id_baking),
   FOREIGN KEY(id_ingredient) REFERENCES ingredient(id_ingredient),
   FOREIGN KEY(id_baking) REFERENCES baking(id_baking)
);

CREATE TABLE product_recipe(
   id_product INTEGER,
   id_recipe INTEGER,
   PRIMARY KEY(id_product, id_recipe),
   FOREIGN KEY(id_product) REFERENCES product(id_product),
   FOREIGN KEY(id_recipe) REFERENCES recipe(id_recipe)
);

CREATE TABLE baker(
   id_baking INTEGER,
   id_employee INTEGER,
   PRIMARY KEY(id_baking, id_employee),
   FOREIGN KEY(id_baking) REFERENCES baking(id_baking),
   FOREIGN KEY(id_employee) REFERENCES employee(id_employee)
);
