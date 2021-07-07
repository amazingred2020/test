package eu.senla.flowers;

import java.math.BigDecimal;

public class Tulip extends Flower{

    public Tulip(String name, BigDecimal price, Color color) {
        super(name, price, color);
    }

    @Override
    public BigDecimal getPrice() {
        return price;
    }
}
