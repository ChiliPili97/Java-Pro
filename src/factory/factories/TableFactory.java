package factory.factories;

import factory.furniture.Furniture;
import factory.furniture.impl.Table;

public class TableFactory extends FurnitureFactory {

    @Override
    protected Furniture createFurniture() {
        return new Table();
    }
}
