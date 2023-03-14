package homeWork8.games;

public class Wall extends Barrier {

    public Wall(int height) {
        super(BarrierType.WALL);
        super.height = height;
    }
}
