package eu.senla.flowers;

import java.math.BigDecimal;

public class Сhrysanthemum extends Flower{

    public Сhrysanthemum(String name, BigDecimal price, Color color) {
        super(name, price, color);
    }

    @Override
    public BigDecimal getPrice() {
        return price;
    }
}
