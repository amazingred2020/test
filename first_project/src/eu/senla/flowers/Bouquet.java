package eu.senla.flowers;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Bouquet {

    private List<Flower> flowers;
    private String bouquetName;
    private BigDecimal price;
    private int flowers_count;
    private String type;

    public Bouquet(){
        flowers = new ArrayList<>();
        this.price = new BigDecimal("0");
    }

    public void addFlower(Flower flower){
        flowers.add(flower);
        setPrice(flower.getPrice());
    }

    public String getPrice() {
        return price.toString();
    }

    public void setPrice(BigDecimal price) {
        this.price = this.price.add(price);
    }
}
