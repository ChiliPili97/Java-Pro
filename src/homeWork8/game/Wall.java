package homeWork8.game;

public class Wall extends Barrier {

    public Wall(int height) {
        super(BarrierType.WALL);
        super.height = height;
    }
}
