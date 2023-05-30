package factory.factories;

import factory.furniture.Furniture;
import factory.furniture.impl.Chair;

public class ChairFactory extends FurnitureFactory {

    @Override
    protected Furniture createFurniture() {
        return new Chair();
    }
}
