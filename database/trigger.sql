-- Ingredient Stock
CREATE OR REPLACE FUNCTION update_ingredient_stock()
    RETURNS TRIGGER AS
$$
DECLARE
    current_quantity NUMERIC(15, 2);
BEGIN
    SELECT quantity
    INTO current_quantity
    FROM ingredient_stock
    WHERE id_ingredient = NEW.id_ingredient;

    -- Mvt de Sortie
    IF NEW.id_mvt_stock_type = 1 THEN
        IF current_quantity IS NULL OR current_quantity < NEW.quantity THEN
            RAISE EXCEPTION 'Stock insuffisant pour le mouvement de sortie (id_ingredient: %, quantité demandée: %, quantité disponible: %)',
                NEW.id_ingredient, NEW.quantity, COALESCE(current_quantity, 0);
        END IF;

        UPDATE ingredient_stock
        SET quantity = quantity - NEW.quantity
        WHERE id_ingredient = NEW.id_ingredient;

    ELSE
        IF current_quantity IS NULL THEN
            INSERT INTO ingredient_stock (id_ingredient, quantity)
            VALUES (NEW.id_ingredient, NEW.quantity);
        ELSE
            UPDATE ingredient_stock
            SET quantity = quantity + NEW.quantity
            WHERE id_ingredient = NEW.id_ingredient;
        END IF;
    END IF;

    RETURN NEW;
END;
$$ LANGUAGE plpgsql;

CREATE OR REPLACE TRIGGER trg_insert_ingredient_stock
    AFTER INSERT
    ON mvt_ingredient_stock
    FOR EACH ROW
EXECUTE FUNCTION update_ingredient_stock();

-- Product Stock
CREATE OR REPLACE FUNCTION update_product_stock()
    RETURNS TRIGGER AS
$$
DECLARE
    current_quantity NUMERIC(15, 2);
BEGIN
    SELECT quantity
    INTO current_quantity
    FROM product_stock
    WHERE id_product = NEW.id_product;

    -- Mvt de Sortie
    IF NEW.id_mvt_stock_type = 1 THEN
        IF current_quantity IS NULL OR current_quantity < NEW.quantity THEN
            RAISE EXCEPTION 'Stock insuffisant pour le mouvement de sortie (id_product: %, quantité demandée: %, quantité disponible: %)',
                NEW.id_product, NEW.quantity, COALESCE(current_quantity, 0);
        END IF;

        UPDATE product_stock
        SET quantity = quantity - NEW.quantity
        WHERE id_product = NEW.id_product;

    ELSE
        IF current_quantity IS NULL THEN
            INSERT INTO product_stock (id_product, quantity)
            VALUES (NEW.id_product, NEW.quantity);
        ELSE
            UPDATE product_stock
            SET quantity = quantity + NEW.quantity
            WHERE id_product = NEW.id_product;
        END IF;
    END IF;

    RETURN NEW;
END;
$$ LANGUAGE plpgsql;

CREATE OR REPLACE TRIGGER trg_insert_product_stock
    AFTER INSERT
    ON mvt_product_stock
    FOR EACH ROW
EXECUTE FUNCTION update_product_stock();
