package eu.senla.flowers;

import java.math.BigDecimal;

public abstract class Flower {
    public String name;
    public BigDecimal price;
    public Color color;
    Flower(String name, BigDecimal price, Color color) {
        this.name = name;
        this.price = price;
        this.color = color;
    }

    public abstract BigDecimal getPrice();
}
