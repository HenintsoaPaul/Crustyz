package mg.crustyz.dto;

import lombok.Data;
import mg.crustyz.entity.product.Product;
import mg.crustyz.entity.recipe.RecipeProduct;
import mg.crustyz.entity.stock.ProductStock;


@Data
public class RecipeProductDTO {
    private RecipeProduct recipeProduct;
    private ProductStock productStock;

    public RecipeProductDTO( RecipeProduct recipeProduct, ProductStock productStock ) {
        this.recipeProduct = recipeProduct;
        this.productStock = productStock;
    }

    public Product getProduct() {
        return this.productStock.getProduct();
    }

    public double getUnitPrice() {
        return this.getProduct().getUnitPrice();
    }

    public double getQuantity() {
        return this.productStock.getQuantity();
    }

    public double getEstimation() {
        return this.getQuantity() * this.getUnitPrice();
    }
}
