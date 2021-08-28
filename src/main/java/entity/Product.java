package entity;

import java.util.ArrayList;
import java.util.List;

public class Product {
    private Integer Id;

    public Product() {
    }

    public Product(String productName, int timeToProduce) {
        this.productName = productName;
        this.timeToProduce = timeToProduce;
    }

    public Product(String productName) {
    }

    public void setId(Integer id) {
        Id = id;
    }

    private String productName;
    private int priceOfAllMaterials;
    private List<Material> materialList = new ArrayList<>();
    private int timeToProduce;

    public String getProductName() {
        return productName;
    }

    public Integer getId() {
        return Id;
    }

    /*public void setId(Integer id) {
        Id = id;
    }*/

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public int getPriceOfAllMaterials() {
        return priceOfAllMaterials;
    }

    public void setPriceOfAllMaterials(int priceOfAllMaterials) {
        this.priceOfAllMaterials = priceOfAllMaterials;
    }

    public List<Material> getMaterialList() {
        return materialList;
    }

    public void setMaterialList(List<Material> materialList) {
        this.materialList = materialList;
    }

    public int getTimeToProduce() {
        return timeToProduce;
    }

    public void setTimeToProduce(int timeToProduce) {
        this.timeToProduce = timeToProduce;
    }
}

