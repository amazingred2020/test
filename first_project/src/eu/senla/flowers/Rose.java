package eu.senla.flowers;

import java.math.BigDecimal;

public class Rose extends Flower{

    public Rose(String name, BigDecimal price, Color color) {
        super(name, price, color);
    }

    @Override
    public BigDecimal getPrice() {
        return price;
    }
}
