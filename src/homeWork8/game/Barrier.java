package homeWork8.game;

public abstract class Barrier {

    public Barrier(BarrierType barrierType) {
        this.barrierType = barrierType;
    }

    public BarrierType barrierType;
    public int height;
    public int width;
}
