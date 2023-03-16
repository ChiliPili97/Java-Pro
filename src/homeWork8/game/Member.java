package homeWork8.game;

public class Member {

    public Member(String member, int maxJumpHeight, int maxRunWidth) {
        this.member = member;
        this.maxJumpHeight = maxJumpHeight;
        this.maxRunWidth = maxRunWidth;
    }

    private String member;
    private int maxJumpHeight;
    private int maxRunWidth;
    private int countBarrier;

    private boolean canRun(String barrier, int width) {
        if (width <= this.maxRunWidth) {
            countBarrier++;
            System.out.println("Member " + this.member + " run on the " + barrier + " distance of: " + width);
            return true;
        } else {
            System.out.println("Member " + this.member + " didn't run on the " + barrier + " distance of: " + width + ". Barriers has been passed: " + countBarrier);
            return false;
        }
    }

    private boolean canJump(String barrier, int height) {
        if (height <= this.maxJumpHeight) {
            countBarrier++;
            System.out.println("Member " + this.member + " jumped across " + barrier + " height of: " + height);
            return true;
        } else {
            System.out.println("Member " + this.member + " didn't jump " + barrier + " height of: " + height + ". Barriers has been passed: " + countBarrier);
            return false;
        }
    }

    public boolean canOvercome(Barrier barrier) {
        if (barrier.barrierType == BarrierType.WALL) {
            return canJump(barrier.barrierType.toString().toLowerCase(), barrier.height);
        } else {
            return canRun(barrier.barrierType.toString().toLowerCase(), barrier.width);
        }
    }
}
