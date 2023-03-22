package homeWork8.game;

public abstract class Barrier {

    private BarrierType barrierType;
    private int height;
    private int width;

    public Barrier(BarrierType barrierType) {
        this.barrierType = barrierType;
    }

    public BarrierType getBarrierType() {
        return barrierType;
    }

    public void setBarrierType(BarrierType barrierType) {
        this.barrierType = barrierType;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public String name(){
        return this.barrierType.toString();
    }
}
