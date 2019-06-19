package men.ahasan.spring_mysql_thymeleaf_jpa_crud.model;

import javax.validation.constraints.NotBlank;

public class ProductDTO {
    @NotBlank
    private String name;
    @NotBlank
    private String brand;
    @NotBlank
    private String madein;
    @NotBlank
    private String price;

    public Product getProduct() {
        Product product = new Product();
        product.setName(name);
        product.setBrand(brand);
        product.setMadein(madein);
        product.setPrice(Float.valueOf(price));
        return product;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getMadein() {
        return madein;
    }

    public void setMadein(String madein) {
        this.madein = madein;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }
}
