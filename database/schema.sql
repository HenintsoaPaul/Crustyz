CREATE TABLE sale
(
    id_sale       SERIAL,
    daty          TIMESTAMP      NOT NULL,
    total_price   NUMERIC(15, 2) NOT NULL,
    customer_name VARCHAR(50) default 'anonymous',
    PRIMARY KEY (id_sale)
);

CREATE TABLE provider
(
    id_provider SERIAL,
    name        VARCHAR(50) NOT NULL,
    PRIMARY KEY (id_provider)
);

CREATE TABLE mvt_stock_type
(
    id_mvt_stock_type SERIAL,
    name              VARCHAR(50) NOT NULL,
    PRIMARY KEY (id_mvt_stock_type)
);

CREATE TABLE recipe
(
    id_recipe   SERIAL,
    name        VARCHAR(50),
    description TEXT,
    PRIMARY KEY (id_recipe)
);

CREATE TABLE employee_type
(
    id_employee_type SERIAL,
    name             VARCHAR(50) NOT NULL,
    PRIMARY KEY (id_employee_type)
);

CREATE TABLE product_category
(
    id_product_category SERIAL,
    name                VARCHAR(50) NOT NULL,
    PRIMARY KEY (id_product_category)
);

CREATE TABLE promotion
(
    id_promotion  SERIAL,
    beginning_daty TIMESTAMP NOT NULL,
    ending_daty   TIMESTAMP NOT NULL,
    PRIMARY KEY (id_promotion)
);

CREATE TABLE unit
(
    id_unit SERIAL,
    name    VARCHAR(50) NOT NULL,
    symbol VARCHAR(5) NOT NULL,
    PRIMARY KEY (id_unit),
    UNIQUE (name)
);

CREATE TABLE supply
(
    id_supply   SERIAL,
    daty        VARCHAR(50),
    total_price NUMERIC(15, 2) NOT NULL,
    id_provider INTEGER        NOT NULL,
    PRIMARY KEY (id_supply),
    FOREIGN KEY (id_provider) REFERENCES provider (id_provider)
);

CREATE TABLE ingredient
(
    id_ingredient SERIAL,
    name          VARCHAR(50) NOT NULL,
    id_unit       INTEGER     NOT NULL,
    PRIMARY KEY (id_ingredient),
    FOREIGN KEY (id_unit) REFERENCES unit (id_unit)
);

CREATE TABLE product
(
    id_product          SERIAL,
    name                VARCHAR(50)    NOT NULL,
    description         TEXT,
    unit_price          NUMERIC(15, 2) NOT NULL,
    id_unit             INTEGER        NOT NULL,
    id_product_category INTEGER        NOT NULL,
    PRIMARY KEY (id_product),
    FOREIGN KEY (id_unit) REFERENCES unit (id_unit),
    FOREIGN KEY (id_product_category) REFERENCES product_category (id_product_category)
);

CREATE TABLE ingredient_provider
(
    id_ingredient_provider SERIAL,
    unit_price             NUMERIC(15, 2) NOT NULL,
    id_ingredient          INTEGER        NOT NULL,
    id_provider            INTEGER        NOT NULL,
    PRIMARY KEY (id_ingredient_provider),
    FOREIGN KEY (id_ingredient) REFERENCES ingredient (id_ingredient),
    FOREIGN KEY (id_provider) REFERENCES provider (id_provider)
);

CREATE TABLE ingredient_stock
(
    id_ingredient_stock SERIAL,
    quantity            NUMERIC(15, 2) NOT NULL,
    id_ingredient       INTEGER        NOT NULL,
    PRIMARY KEY (id_ingredient_stock),
    FOREIGN KEY (id_ingredient) REFERENCES ingredient (id_ingredient)
);

CREATE TABLE mvt_ingredient_stock
(
    id_mvt_ingredient_stock SERIAL,
    daty                    DATE           NOT NULL,
    quantity                NUMERIC(15, 2) NOT NULL,
    id_ingredient           INTEGER        NOT NULL,
    id_mvt_stock_type       INTEGER        NOT NULL,
    PRIMARY KEY (id_mvt_ingredient_stock),
    FOREIGN KEY (id_ingredient) REFERENCES ingredient (id_ingredient),
    FOREIGN KEY (id_mvt_stock_type) REFERENCES mvt_stock_type (id_mvt_stock_type)
);

CREATE TABLE employee
(
    id_employee      SERIAL,
    name             VARCHAR(50)    NOT NULL,
    first_name       VARCHAR(50),
    cin              VARCHAR(50)    NOT NULL,
    hire_date        DATE           NOT NULL,
    salary           NUMERIC(15, 2) NOT NULL,
    id_employee_type INTEGER        NOT NULL,
    PRIMARY KEY (id_employee),
    FOREIGN KEY (id_employee_type) REFERENCES employee_type (id_employee_type)
);

CREATE TABLE rating
(
    id_rating  SERIAL,
    nb_star    INTEGER     NOT NULL,
    author     VARCHAR(50) NOT NULL default 'anonymous',
    daty       DATE        NOT NULL,
    comment    TEXT,
    id_product INTEGER     NOT NULL,
    PRIMARY KEY (id_rating),
    FOREIGN KEY (id_product) REFERENCES product (id_product)
);

CREATE TABLE recipe_step
(
    id_recipe_step SERIAL,
    name           VARCHAR(50) NOT NULL,
    no_step        INTEGER,
    description    TEXT,
    quantity_used  NUMERIC(15, 2),
    id_baker       INTEGER     NOT NULL,
    id_ingredient  INTEGER     NOT NULL,
    id_recipe      INTEGER     NOT NULL,
    PRIMARY KEY (id_recipe_step),
    FOREIGN KEY (id_baker) REFERENCES employee (id_employee),
    FOREIGN KEY (id_ingredient) REFERENCES ingredient (id_ingredient),
    FOREIGN KEY (id_recipe) REFERENCES recipe (id_recipe)
);

CREATE TABLE mvt_product_stock
(
    id_mvt_product_stock SERIAL,
    daty                 DATE           NOT NULL,
    quantity             NUMERIC(15, 2) NOT NULL,
    id_product           INTEGER        NOT NULL,
    id_mvt_stock_type    INTEGER        NOT NULL,
    PRIMARY KEY (id_mvt_product_stock),
    FOREIGN KEY (id_product) REFERENCES product (id_product),
    FOREIGN KEY (id_mvt_stock_type) REFERENCES mvt_stock_type (id_mvt_stock_type)
);

CREATE TABLE product_stock
(
    id_stock_product SERIAL,
    quantity         NUMERIC(15, 2) NOT NULL,
    id_product       INTEGER        NOT NULL,
    PRIMARY KEY (id_stock_product),
    FOREIGN KEY (id_product) REFERENCES product (id_product)
);

CREATE TABLE sale_detail
(
    id_sale_detail SERIAL,
    quantity       NUMERIC(15, 2),
    price          NUMERIC(15, 2),
    id_product     INTEGER NOT NULL,
    id_sale        INTEGER NOT NULL,
    PRIMARY KEY (id_sale_detail),
    FOREIGN KEY (id_product) REFERENCES product (id_product),
    FOREIGN KEY (id_sale) REFERENCES sale (id_sale)
);

CREATE TABLE supply_detail
(
    id_supply_detail       SERIAL,
    quantity               NUMERIC(15, 2),
    price                  NUMERIC(15, 2),
    id_ingredient_provider INTEGER NOT NULL,
    id_supply              INTEGER NOT NULL,
    PRIMARY KEY (id_supply_detail),
    FOREIGN KEY (id_ingredient_provider) REFERENCES ingredient_provider (id_ingredient_provider),
    FOREIGN KEY (id_supply) REFERENCES supply (id_supply)
);

CREATE TABLE recipe_product
(
    id_product        INTEGER,
    id_recipe         INTEGER,
    quantity_produced NUMERIC(15, 2) NOT NULL,
    PRIMARY KEY (id_product, id_recipe),
    FOREIGN KEY (id_product) REFERENCES product (id_product),
    FOREIGN KEY (id_recipe) REFERENCES recipe (id_recipe)
);

CREATE TABLE product_promotion
(
    id_product   INTEGER,
    id_promotion INTEGER,
    quantity     NUMERIC(15, 2) NOT NULL,
    percent_off  NUMERIC(2, 2),
    PRIMARY KEY (id_product, id_promotion),
    FOREIGN KEY (id_product) REFERENCES product (id_product),
    FOREIGN KEY (id_promotion) REFERENCES promotion (id_promotion)
);
