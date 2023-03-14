package homeWork8.games;

public class DemoMember {
    public static void main(String[] args) {

        Member[] members = new Member[3];
        members[0] = new Member("human", 1, 1000);
        members[1] = new Member("cat", 3, 700);
        members[2] = new Member("robot", 2, 2000);
        Barrier[] barriers = new Barrier[2];
        barriers[0] = new Wall(2);
        barriers[1] = new Racetrack(800);

        for (Member m: members) {
            for (Barrier b: barriers) {
                if (!m.overcome(b)) {
                    break;
                }
            }
        }
    }
}
