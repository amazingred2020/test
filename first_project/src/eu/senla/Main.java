package eu.senla;

import eu.senla.flowers.*;

import java.math.BigDecimal;

public class Main {

    public static void main(String[] args){
        Bouquet boucket1 = new Bouquet();
        Bouquet boucket2 = new Bouquet();

        Flower rose1 = new Rose("Роза красная", new BigDecimal("60"), Color.red);
        Flower rose2 = new Rose("Роза белая", new BigDecimal("90"), Color.white);
        Flower pione1 = new Peonies("Пион розовый",new BigDecimal("35"), Color.pink);
        Flower pione2 = new Peonies("Пион фиолетовый", new BigDecimal("14"), Color.purple);
        Flower tulip1 = new Tulip("Тюльпан фиолетовый", new BigDecimal("96"), Color.purple);
        Flower tulip2 = new Tulip("Тюльпан желтый", new BigDecimal("79"), Color.yellow);
        Flower chrisant1 = new Сhrysanthemum("Хризантема желтая", new BigDecimal("200"), Color.yellow);
        Flower chrisant2 = new Сhrysanthemum("Хризантема оранжевая", new BigDecimal("186"), Color.orange);

        boucket1.addFlower(rose1);
        boucket1.addFlower(pione1);
        boucket1.addFlower(tulip1);
        boucket1.addFlower(chrisant1);

        boucket2.addFlower(rose2);
        boucket2.addFlower(pione2);
        boucket2.addFlower(tulip2);
        boucket2.addFlower(chrisant2);

        System.out.println("цена первого букета: " + boucket1.getPrice());
        System.out.println("цена второго букета: " + boucket2.getPrice());
    }
}
