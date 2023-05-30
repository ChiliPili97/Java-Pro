package factory;

import factory.factories.FurnitureFactory;
import factory.factories.ChairFactory;
import factory.factories.TableFactory;
import factory.furniture.Furniture;

public class FactoryDemo {
    public static void main(String[] args) {
        FurnitureFactory chairFactory = new ChairFactory();
        Furniture chair = chairFactory.create();

        FurnitureFactory tableFactory = new TableFactory();
        Furniture table = tableFactory.create();
    }
}