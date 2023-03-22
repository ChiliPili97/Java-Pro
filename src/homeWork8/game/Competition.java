package homeWork8.game;

public class Competition {

    public static void start(Participant[]  participants, Barrier[] barriers){
        for (Participant p: participants) {
            for (Barrier b: barriers) {
                if (!p.canOvercome(b)) {
                    break;
                }
            }
        }
    }
}
