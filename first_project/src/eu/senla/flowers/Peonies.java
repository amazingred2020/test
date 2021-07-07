package eu.senla.flowers;

import java.math.BigDecimal;

public class Peonies extends Flower{

    public Peonies(String name, BigDecimal price, Color color) {
        super(name, price, color);
    }

    @Override
    public BigDecimal getPrice() {
        return price;
    }
}
