package homeWork8.game;

public class Participant {

    private String member;
    private int maxJumpHeight;
    private int maxRunWidth;
    private int countBarrier;

    public Participant(String Participant, int maxJumpHeight, int maxRunWidth) {
        this.member = Participant;
        this.maxJumpHeight = maxJumpHeight;
        this.maxRunWidth = maxRunWidth;
    }

    private boolean canRun(String barrier, int width) {
        if (width <= this.maxRunWidth) {
            countBarrier++;
            System.out.println("Participant " + this.member + " run on the " + barrier + " distance of: " + width);
            return true;
        } else {
            System.out.println("Participant " + this.member + " didn't run on the " + barrier + " distance of: " + width + ". Barriers has been passed: " + countBarrier);
            return false;
        }
    }

    private boolean canJump(String barrier, int height) {
        if (height <= this.maxJumpHeight) {
            countBarrier++;
            System.out.println("Participant " + this.member + " jumped across " + barrier + " height of: " + height);
            return true;
        } else {
            System.out.println("Participant " + this.member + " didn't jump " + barrier + " height of: " + height + ". Barriers has been passed: " + countBarrier);
            return false;
        }
    }

    public boolean canOvercome(Barrier barrier) {
        if (barrier.getBarrierType() == BarrierType.WALL) {
            return canJump(barrier.name().toLowerCase(), barrier.getHeight());
        } else {
            return canRun(barrier.name().toLowerCase(), barrier.getWidth());
        }
    }
}
