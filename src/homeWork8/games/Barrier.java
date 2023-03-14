package homeWork8.games;

public abstract class Barrier {

    public Barrier(BarrierType typeBarrier) {
        this.typeBarrier = typeBarrier;
    }

    public BarrierType typeBarrier;
    public int height;
    public int width;
}
