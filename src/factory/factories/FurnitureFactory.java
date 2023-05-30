package factory.factories;

import factory.furniture.Furniture;

public abstract class FurnitureFactory {
    public Furniture create() {
        Furniture furniture = createFurniture();
        return furniture;
    }

    protected abstract Furniture createFurniture();
}
